package klondike;
	
public class Menu {
	
	private static final String[] TITULOS = new String[]{
			"\n1. Mover de baraja a descarte." +
			"\n2. Mover de descarte a palo." +
			"\n3. Mover de descarte a columna." +
			"\n4. Mover de palo a columna." +
			"\n5. Mover de columna a palo." +
			"\n6. Mover de columna a columna." +
			"\n7. Voltear carta en columna." +
			"\n8. Voltear descarte en baraja." +
			"\n9. Salir."
	};
	
	public static final Intervalo OPCIONES = new Intervalo(1,9); 
	
	public void mostrar() {
		GestorIo gestorIo = new GestorIo();
		for(String titulo : TITULOS){
			gestorIo.out(titulo);
		}
	}
	
	public int getOpcion(){
		GestorIo gestorIo = new GestorIo();
		int opcion; 
		boolean error; 
		do{
			gestorIo.out("\nOpcion:? [1-9]: ");
			opcion = gestorIo.inInt(); 
			error = !OPCIONES.incluye(opcion); 
			if(error){
				gestorIo.out("Error!!! Debe ser una opcion entero entre 1 y 9 "); 
			}
		}while(error); 
		
		return opcion; 
	}
	
	

}
