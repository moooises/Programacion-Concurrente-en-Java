#include <iostream>
#include <condition_variable>
#include <mutex>
using namespace std;

struct pcMonitor{//EN java es el monitor cadena
	int numSlots=0,putIn=0,takeOut=0,cont=0;
	double* buffer;
	std::condition_variable not_full;
	std::condition_variable not_empty;
	std::mutex lock;


	pcMonitor(int nslots){
		numSlots=nslots;
		buffer= new double[nslots];
	}

	void producir(double valor){
		std::unique_lock<std::mutex> l(lock);
		not_full.wait(l,[this](){return cont!=numSlots;});//se realiza el wair cuando el{} es falso

		buffer[putIn]=valor;
		putIn=(putIn+1)%numSlots;
		++cont;
		not_empty.notify_one();

	}

	double consumir(){
		std::unique_lock<std::mutex> l(lock);
		not_empty.wait(l,[this](){return cont!=0;});

		double res=buffer[takeOut];
		takeOut=(takeOut+1)%numSlots;
		--cont;
		not_full.notify_one();
		return res;
	}
};
