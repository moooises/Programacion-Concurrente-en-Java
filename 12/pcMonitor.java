import java.util.*;
import java.lang.*;
import java.util.concurrent.locks.*;

    public class pcMonitor {

    	//private Lock cerrojo= new ReentrantLock();
    	private final Condition no_vacio = cerrojo.newCondition();
    	private final Condition no_lleno = cerrojo.newCondition();
        int numSlots;
        double[]vector;
        Random rd = new Random();
        int putIn,takeOut;
        int cont;

      public pcMonitor(int numSlots){
        this.numSlots=numSlots;
        vector=new double[numSlots];
      }

      public synchronized void insertar () {
      	 // cerrojo.lock();
      	  //try{
        while (cont == numSlots)
          try {
          	  no_vacio.await();
          } catch (InterruptedException e) {}
        vector[putIn] =(Math.pow(rd.nextDouble(),2)+Math.pow(rd.nextDouble(),2));
        putIn = (putIn + 1) % numSlots;
        cont++;
       no_lleno.signalAll();
       	//  }finally{cerrojo.unlock();}
      														}

      public synchronized double extraer () {
      	// cerrojo.lock();
      	 //try{
        double valor;
        while (cont == 0)
          try {
            no_lleno.await();
          } catch (InterruptedException e) {
            System.err.println("wait interrumpido");
          }
        valor = vector[takeOut];
        takeOut = (takeOut + 1) % numSlots;
        cont--;
        no_vacio.signalAll();
        return valor;
        // }finally{cerrojo.unlock();}
      }
    }//Buffer
