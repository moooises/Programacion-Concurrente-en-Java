import java.util.concurrent.*;


public class usalectorEscritor implements Runnable{
public boolean tag;
public static lectorEscritor lectorescritor = new lectorEscritor();
	public usalectorEscritor(boolean tag){
		this.tag=tag;
	}

	public void run(){
		if(tag){
		lectorescritor.inicia_escritura();
		lectorescritor.fin_escritura();
		}
		else{
		lectorescritor.inicia_lectura();
		lectorescritor.fin_lectura();
		}

	}

	public static void main(String[] args){

		int l=5;
		int e=2;
		int nTareas=4;
		ThreadPoolExecutor pool= new ThreadPoolExecutor(nTareas,nTareas,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());

		for(int i=1;i<7;++i){
			if(i==1 || i==2)pool.execute(new usalectorEscritor(true));
			else pool.execute(new usalectorEscritor(false));
								}

		pool.shutdown();
		try{
				pool.awaitTermination(2, TimeUnit.SECONDS);
				}catch(Exception ex){}

					System.out.println("No ha habido interbloqueo");

								}
							}
