#include <iostream>
#include <random>
#include <cmath>
#include <chrono>
#include <ctime>
using namespace std;

double montecarlo(double );

int main(){
	std::chrono::time_point<std::chrono::system_clock> start,end;
	double n;
	double PI;
	cout<<"¿Cuantos numeros quieres mandar?";
	cin>>n;
	start=std::chrono::system_clock::now();
	PI=montecarlo(n);
	cout<<"La aproximacion es "<<PI;
	end=std::chrono::system_clock::now();
	std::chrono::duration<double> seconds=end-start;
	//std::time_t end_time=std::chrono::system_clock::to_time_t(end);
	cout<<"Ha tardado: "<<seconds.count()<< "s\n";
}

 double montecarlo(double n){
	std::random_device rd;
	std::mt19937 gen(rd());
	std::uniform_real_distribution<> dis(0,1);

	double x,y;
	double aciertos=0;

	for(int i=0;i<n;++i){
		x=dis(gen);
		y=dis(gen);

		if(pow(x,2)+pow(y,2)<=1){
			++aciertos;
		}
	}
	return 4*(aciertos/n);
}