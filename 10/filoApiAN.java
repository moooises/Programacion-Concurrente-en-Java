/**
* @autor Moises Guerrero Lopez
* @version 1.0
*/

import java.util.concurrent.locks.*;


class filoApiAN{
	private static int []tenedor;
	private final ReentrantLock cerrojo= new ReentrantLock();
	private Condition [] comer;
	private int nfilosofo;
	
/**
*el identificador del filosofo
* @param nfilosofos int;
*/
	
	public filoApiAN(int nfilosofo){
		this.nfilosofo=nfilosofo;
		comer = new Condition[nfilosofo];
		tenedor = new int[nfilosofo];
		
		for(int i=0;i<nfilosofo;++i){
			tenedor[i]=2;
			comer[i]=cerrojo.newCondition();
								}
		
		
/**
*el identificador del filosofo
* @param i int;
*/									}
	void coger_tenedor(int i){
		cerrojo.lock();
		try{
		if (tenedor[i]!=2) comer[i].await();
		}catch(Exception e){
		if(i==0){
			tenedor[i+1]=tenedor[i+1]-1;
			tenedor[4]=tenedor[4]-1;
					}
		else {
			if(i==4){
				tenedor[0]=tenedor[0]-1;
				tenedor[i-1]=tenedor[i-1]-1;
							}
			else {
				tenedor[i+1]=tenedor[i+1]-1;
				tenedor[i-1]=tenedor[i-1]-1;
				}
			}
		}finally{
		cerrojo.unlock();
					}
				}

/**
*el identificador del filosofo
* @param i int;
*/			
	void dejar_tenedor(int i){
		cerrojo.lock();
		if(i==0){
			tenedor[i+1]=tenedor[i+1]+1;
			tenedor[4]=tenedor[4]+1;
			
			if(tenedor[i+1]==2) comer[i+1].signal();	
			if(tenedor[4]==2) comer[4].signal();
					}
		else {
			if(i==4){
				tenedor[0]=tenedor[0]+1;
				tenedor[i-1]=tenedor[i-1]+1;
				
			if(tenedor[0]==2) comer[0].signal();	
			if(tenedor[i-1]==2) comer[i-1].signal();
							}
			else {
				tenedor[i+1]=tenedor[i+1]+1;
				tenedor[i-1]=tenedor[i-1]+1;
				
			if(tenedor[i+1]==2) comer[i+1].signal();	
			if(tenedor[i-1]==2) comer[i-1].signal();
				}
			}
		
		cerrojo.unlock();
							}
					}