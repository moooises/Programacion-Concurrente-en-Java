public class prodMatConcurrente extends Thread{
		private static int filasA;
		private static int columnasA;
		private static int filasB;
		private static int columnasB;
		private static int A[][];
		private static int b[][];
		private static int y[][];
		private int filaux;
		
		public prodMatConcurrente(){}
		public prodMatConcurrente(int [][]A,int[][] b,int[][]y,int f,int c,int e,int k,int aux){
		this.filasA=f;
		this.columnasA=c;
		this.filasB=e;
		this.columnasB=k;
		this.A=A;
		this.b=b;
		this.y=y;
		this.filaux=aux;
											}
											
		public void run(){ 
		
		int aux;
		System.out.print("\n");
			for(int i=0;i<columnasB;++i){
			aux=0;
				for(int j=0;j<columnasA;++j){
					aux=aux+((A[filaux][j])*(b[j][i]));//00x00 01x10 02x20 00x01 01x11 02x21
					y[filaux][i]=aux;
											}
					
					 //00 01 02
								}
							}
							
		public static int visualizar(int i,int j){
		return y[i][j];
														}



}