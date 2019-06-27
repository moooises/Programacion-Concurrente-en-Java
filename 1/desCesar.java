import java.util.Scanner;
		class desCesar{
			public static void main(String[] args){
				Scanner sc = new Scanner(System.in);
				System.out.println("Introduzca una cadena:");
				String cadena = sc.nextLine();
				String resultado="";
				System.out.println("Introduzca un valor para n: ");
				int n = sc.nextInt();
				int mod = n%27;//54
				int valor;
				for(int i=0;i<cadena.length();++i){
					valor=(int)(cadena.charAt(i));
					valor= valor - mod;
					char asc=(char) valor;
					//System.out.print(""+asc);
					resultado+=asc;
												}
				System.out.println(resultado);

													}
					}