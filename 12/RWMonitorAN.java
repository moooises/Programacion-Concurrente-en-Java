/**
* @autor Moises Guerrero Lopez
* @version 1.0
*/

//En esta practica debe modificar este monitor, construyendo una version equivalente que
//emplee el API de alto nivel para control de la concurrencia.
//Esto implica:
//(1) Proveer exclusion mutua mediante cerrojos ReentrantLock
//(2) Proveer sincronizacion con objetos Condition

import java.util.concurrent.locks.*;

class RWMonitorAN {
	private final ReentrantLock cerrojo= new ReentrantLock();
	private final Condition leer = cerrojo.newCondition();
	private final Condition escribir = cerrojo.newCondition();
	volatile int readers = 0;
	volatile boolean writing = false;

  void StartRead() {
  	  cerrojo.lock();
  try {
    while (writing) leer.await();
    readers = readers + 1;
    System.out.println("Lector inicia lectura...");
   }finally{
      	 		 cerrojo.unlock();
      	 	  }
  }

   void EndRead() {
  	  cerrojo.lock();
  	try{
    readers = readers - 1;
    if (readers == 0) escribir.signal();
    System.out.println("Lector finaliza lectura...");
    	}finally{
    				cerrojo.unlock();
    			 }
  }
  
  void StartWrite() {
  	  cerrojo.lock();
   try{ 	   
    while (writing || (readers != 0))escribir.await();
    writing = true;
    System.out.println("Escritor inicia escritura...");
   		}finally{
   					cerrojo.unlock();
   				}
  }
  
   void EndWrite() {
   	cerrojo.lock();
   	try{
    writing = false;
    leer.signal();
    System.out.println("Escritor finaliza escritura...");
    	}finally{
    				cerrojo.unlock();
    			}
  }
  
}
