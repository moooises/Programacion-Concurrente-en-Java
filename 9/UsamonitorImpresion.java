/**
*@author Moises Guerrero Lopez
*@version 1.0
*/

import java.util.concurrent.*;

class UsamonitorImpresion implements Runnable{
	private static monitorImpresion monitor;
	private int id;

	public UsamonitorImpresion(int id){
	this.id=id;
															}

	public void run(){
		int n;
		//System.out.println("Entra en el hilo");
		n=monitor.coger_impresora();//*****
		System.out.println("El usuario "+(id+1)+" coge la impresora "+(n+1));
		monitor.dejar_impresora(n);
		System.out.println("El usuario "+(id+1)+" deja la impresora "+(n+1));

						}



	public static void main(String[] args){
		monitor= new monitorImpresion(3) ;
	int nNuc = Runtime.getRuntime().availableProcessors();
    double Cb = 0.5; //Float.parseFloat(args[0]);
    int tamPool = (int)(nNuc/(1-Cb));

    //monitorImpresion monitor = new monitorImpresion(3);	//cantidad de impresoras

    ExecutorService exec = Executors.newCachedThreadPool();
    for(int i=0;i<tamPool;++i){
    	exec.execute(new UsamonitorImpresion(i));
    						}
    	exec.shutdown();
											}


							}
