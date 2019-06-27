/**
*@author Moises Guerrero Lopez
*@version 1.0
*/
import java.util.concurrent.*;
public class usaConductores implements Runnable{
	public static Conductores conductores;
public int n;
	public usaConductores(int i){
		n=i;
	}

public void run(){
	System.out.println(conductores.getdni(n));
}

public static void main(String[] args){
int nTareas=4;
conductores= new Conductores(nTareas);
ThreadPoolExecutor pool= new ThreadPoolExecutor(nTareas,nTareas,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());

for(int j=0;j<nTareas;++j){
pool.execute(new usaConductores(j));
					}

pool.shutdown();
try{
	pool.awaitTermination(2, TimeUnit.SECONDS);
}catch(Exception ex){}


					}



				}
