#include <iostream>
#include <thread>
#include <random>
#include <cmath>
#include <atomic>
#include <chrono>
#include <ctime>
#include <mutex>
using namespace std;

void montecarlo(int,int);
	double aciertos;
	std::mutex mut;


int main(int argc, char *argv[]){
	std::chrono::time_point<std::chrono::system_clock> start,end;
	thread hilos[4];
	double n=atoi(argv[2]);
	int tareas=atoi(argv[1]);
	cout<<"Tareas: "<<tareas<<"\n";//cambiar el 4 por tareas y pasar por argumento
	int ventana=n/tareas;//
	int j=tareas;
	if(ventana==0){
		j=1;
		ventana=n;
	}

	start=std::chrono::system_clock::now();

	for(int i=0;i<j;++i){
		hilos[i]=thread(montecarlo,ventana,i);
	
	}

	for(int i=0;i<j;++i){
	hilos[i].join();
	}

	double resul=4*(aciertos/n);
	cout<<"La aproximacion es "<<resul<<"\n";
	end=std::chrono::system_clock::now();
	std::chrono::duration<double> seconds=end-start;
	//std::time_t end_time=std::chrono::system_clock::to_time_t(end);
	cout<<"Ha tardado: "<<seconds.count()<< "s\n";
	return 0;
}	

void montecarlo(int n,int index){
	std::random_device rd;
	std::mt19937 gen(rd());
	std::uniform_real_distribution<> dis(0,1);

	double x,y;

	for(int i=0;i<n;++i){
		x=dis(gen);
		y=dis(gen);

		if(pow(x,2)+pow(y,2)<=1){
			mut.lock();
			++aciertos;
			mut.unlock();
		}
	}
	
}