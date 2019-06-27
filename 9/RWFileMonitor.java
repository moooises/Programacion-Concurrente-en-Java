/**
 * @(#)RWmonitor.java
 * @author Moises Guerero López (adaptado)
 * @version 1.00
 */

import java.io.*;
import java.util.concurrent.locks.ReentrantLock;

class RWFileMonitor{
  public RandomAccessFile myfich;
  public int readers;
  public boolean writing = false;
  public File ruta = new File("datos.dat");

  public RWFileMonitor(){
    readers=0;
  }

  public synchronized void StartRead(int id) {
    while (writing){
      try {
         wait();
      } catch (Exception e) {}
}
    readers = readers + 1;
      System.out.println("Lector "+id+" inicia lectura...");
     try {
               myfich = new RandomAccessFile(ruta, "rw");//abrimos
               while(myfich.getFilePointer() <= myfich.length())
               System.out.println(myfich.readInt());
               myfich.close();//cerramos



    notifyAll();
     } catch (Exception e) {}
  }

  public synchronized void EndRead(int id) {
    readers = readers - 1;

    System.out.println("Lector "+id+" finaliza lectura...");

  if (readers == 0){

    try{
      notifyAll();
    }catch(Exception ex){}
  }
  }

  public synchronized void StartWrite(int id) {
    while (writing || (readers != 0))
      try {
        //if(readers!=0)System.out.println("Hay leyendo: "+readers);
         wait();
      } catch (InterruptedException e) {}
        try {
                    myfich = new RandomAccessFile(ruta, "rw");//abrimos
                     for(int i=0;i<5;i++) myfich.writeInt(i);
                     myfich.close();//cerramos
                     //System.out.println("Fichero creado...");
                  } catch (IOException e) {}


    writing = true;

    System.out.println("Escritor "+id+" inicia escritura...");
  }

  public synchronized void EndWrite(int id) {
    writing = false;

    try{
    notifyAll();
  }catch(Exception ex){}

    System.out.println("Escritor "+id+" finaliza escritura...");
  }
}
