import java.util.*;

/**
	*En esta programa creamos los arrays de objetos de la clase Paciente, 
	*donde ademas llamamos a los metodos parainicializar,modificar,observar
	*y borrar los parametros de esas clase
	*@author Moises Guerrero Lopez 
	*@version 1.0
	*/
	
public class Biblioteca{
	/**
	*En la clase principal creamos el array de objetos
	*/
	public static void main(String[] args){
	int i;
	//System.out.println("Cuantos pacientes tiene la consulta medica:");
	Scanner sc = new Scanner(System.in);
	//int n = sc.nextInt();
	ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	//Pacinete []p=new Paciente[100];
	/**
	*Menu para las diversas opciones que queramos realizar
	*/
	
	int op;
	do{

	System.out.println("Eliga que funcion quiere:");
	System.out.println("1 - Insertar");
	System.out.println("2 - Borrar");
	System.out.println("3 - Visualizar");
	System.out.println("0 - Salir");
	op=sc.nextInt();
	
	switch(op)
	{
	   		case 1:
	   				String nomb,DNI,direc,telef,segur;
	   				sc.nextLine();
	   				System.out.println("Seleccione el nombre a introducir:");
	   				nomb=sc.nextLine();
	   				System.out.println("Seleccione el DNI a introducir:");
	   				DNI=sc.nextLine();
	   				System.out.println("Seleccione la direccion a introducir:");
	   				direc=sc.nextLine();
	   				System.out.println("Seleccione el telefono a introducir:");
	   				telef=sc.nextLine();
	   				System.out.println("Seleccione la compa�ia de seguros a introducir:");
	   				segur=sc.nextLine();
	   				Paciente p= new Paciente(nomb,DNI,direc,telef,segur);
	   				/**
	   				El constructor de la clase Paciente
	   				*/
	   				pacientes.add(p);
	   				//pacientes[i]= new Paciente(nomb,DNI,direc,telef,segur);
	   				System.out.println("Desea realizar alguna operacion: ");	
	   				break;
	   		//Arreglar, mover valores siguientes hasta i		
	   		case 2:
	   			/**
	   				sc.nextLine();
	   				pacientes[i].nombre="";
	   				pacientes[i].dni="";
	   				pacientes[i].direcc="";
	   				pacientes[i].tel="";
	   				pacientes[i].seguro="";*/
	   				if(!pacientes.isEmpty()){
	   							do{
	   								System.out.println("Seleccione el paciente que quiereas del 0 al "+(pacientes.size()-1));
	   								i=sc.nextInt();
	   							}while(i<0 || i>=pacientes.size());
	   							pacientes.remove(i);
	   				}
	   				else System.out.println("Lista vacia");
	   				
	   				System.out.println("Desea realizar alguna operacion: ");	
	   				break;
	   		
	   		case 3:
	   				 if(!pacientes.isEmpty()){
	   				Paciente p1;
	   				do{
	   					System.out.println("Seleccione el paciente que quiereas del 0 al "+(pacientes.size()-1));
	   					i=sc.nextInt();
	   				}while(i<0 || i>=pacientes.size());
	   				p1=pacientes.get(i);
	   				 
	   				System.out.println("El nombre del paciente es: "+p1.nombre);
	   				System.out.println("Su DNI es: "+p1.dni);
	   				System.out.println("Su direccion es: "+p1.direcc);
	   				System.out.println("Su telefono es: "+p1.tel);
	   				System.out.println("Su compa�ia de seguros es: "+p1.seguro);
	   				 }
	   				 else System.out.println("Lista Vacia");
	   				System.out.println("Desea realizar alguna operacion: ");	
	   				break;
	   				
	   	default:	break;
	  }
	  }while(op!=0);
	  System.out.println("Adios");
	
											}
											}