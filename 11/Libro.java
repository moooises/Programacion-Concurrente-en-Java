public class Libro implements java.io.Serializable{

	private String nombre;
	private String editorial;
	private String autor;
	private int edicion;
	
	public Libro(String nombre,String editorial,String autor,int edicion){
		this.nombre=nombre;
		this.editorial=editorial;
		this.autor=autor;
		this.edicion=edicion;
																			}
	public void setnombre(String nombre){
		this.nombre=nombre;
										}
	
	public String getnombre(){
		return nombre;
								}
	public void erasenombre(){
		this.nombre=null;
								}
					
	public void seteditorial(String editorial){
		this.editorial=editorial;
												}	
												
	public String geteditorial(){
		return editorial;
												}
												
	public void eraseeditorial(){
		this.editorial=null;
								}
												
	public void setautor(String autor){
		this.autor=autor;
										}
										
	public String getautor(){
		return autor;
							}

	public void eraseautor(){
		this.autor=null;
								}
							
	public void setedicion(int edicion){
		this.edicion=edicion;
										}
							
	public int getedicion(){
		return edicion;
							}
							
	public void eraseedicion(){
		this.edicion=0;
								}
										
										
			}