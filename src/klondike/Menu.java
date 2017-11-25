package klondike;
	
public class Menu {
	GestorIo gestorIo = new GestorIo();
	public int getOpcion(){
		gestorIo.out("1. Mover de baraja a descarte.");
		gestorIo.out("2. Mover de descarte a palo.");
		gestorIo.out("3. Mover de descarte a columna.");
		gestorIo.out("4. Mover de palo a columna.");
		gestorIo.out("5. Mover de columna a palo.");
		gestorIo.out("6. Mover de columna a columna.");
		gestorIo.out("7. Voltear carta en columna.");
		gestorIo.out("8. Voltear descarte en baraja.");
		gestorIo.out("9. Salir.");
		gestorIo.out("Opcion? [1-9]:");
		return gestorIo.inInt(); 
	}

}
