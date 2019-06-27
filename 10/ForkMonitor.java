class ForkMonitor{
private int []fork={2,2,2,2};
private ReentrantLock lock=new ReentrantLock();
private Condition []OktoEat= new Condition[5];//hay siempre un palillo mas por filosofo

 public ForkMonitor(){
   for(int i=0;i<OktoEat.length;++i){
     OktoEat[i]=lock.newCondition();
   }
 }

 private void takeForks(int i){
   lock.lock()
    while(fork[i]!=2){
      try{
        OktoEat[i].await();//se mantienen las condiciones de guarda en API alto nivel
      }catch(Exception ex){}
    }
    fork[i+1]=fork[i+1]--;
    fork[i-1]=fork[i-1]--;
    lock.unlock();
 }

 private void releaseForks(int i){
   lock.lock();
   fork[i+1]=fork[i+1]++;
   fork[i-1]=fork[i-1]++;
   if(fork[i+1]==2){
     try{
     OktoEat[i+1].signalAll();//podemos usar signalAll por solo hay una variable
   }catch(Exception ex){}
   if(fokr[i-1]==2){
     try{
     OktoEat[i-1].signalAll();//esperando en cada cola de la variable de condicion
   }catch(Exception ex){}
   }
   lock.unlock();
 }

}
