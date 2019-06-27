#include <iostream>
#include <condition_variable>
#include <mutex>
#include <thread>
#include <random>
#include <cmath>
#include <atomic>
#include <chrono>
#include <ctime>
#include "pcMonitor.cpp"
using namespace std;

pcMonitor monitor(100);


void run(int i){
	if(i%2)monitor.producir(rand()%100);
	else monitor.consumir();

}

int main(){
	std::chrono::time_point<std::chrono::system_clock> start,end;
	start=std::chrono::system_clock::now();
	int tareas=4;//pasar por argumento
	thread hilos[10];
	srand(time(NULL));
	for(int i=0;i<10;++i){
		hilos[i]= thread(run,i);
	}

	for(int i=0;i<10;++i){
		hilos[i].join();
	}

	end=std::chrono::system_clock::now();
	std::chrono::duration<double> seconds= end-start;
	cout<<"Ha tardado: "<<seconds.count()<< "s\n";

}