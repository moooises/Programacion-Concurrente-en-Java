import java.util.*;
import java.util.concurrent.*;

class UsarRWFileMonitor implements Runnable{

	private static RWFileMonitor monitor=new  RWFileMonitor();;
	private boolean tipo;
	private int id;


	public UsarRWFileMonitor(boolean tipo,int id){
		this.tipo=tipo;
		this.id=id;
													}

	public void run(){
		if(tipo){
			monitor.StartWrite(id);
			monitor.EndWrite(id);
				}
		else{
			monitor.StartRead(id);
			monitor.EndRead(id);
			}
						}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int lect,escr;

		System.out.println("Cuantos escritores quieres?");
		escr=sc.nextInt();
		System.out.println("Cuantos lectores quieres?");
		lect=sc.nextInt();

		ExecutorService exec = Executors.newCachedThreadPool();


		for(int i=0;i<escr;++i){
			exec.execute(new UsarRWFileMonitor(true,i));
								}


		for(int j=0;j<lect;++j){
		exec.execute(new UsarRWFileMonitor(false,j));
								}

		exec.shutdown();

											}

											}
