package klondike;


public class Klondike {

	private Baraja baraja;
	private Palo[] palos; //tengo 4 palos
	private Columna[] columnas; 
	private Descarte descarte; 
	
	private Klondike(){
		baraja = new Baraja(); 
		descarte = new Descarte(); 

		palos = new Palo[4]; 
		for(int i=0; i<palos.length; i++){
			palos[i] = new Palo(); 
		}
		
		columnas = new Columna[7];
		for(int i=0; i<columnas.length; i++){
			columnas[i] = new Columna(i+1,baraja); 
		}
	}
	
	private void jugar() {
//		método privado llamado mostrar estado()
		this.mostrar();
		
//		Le pongo un menu con las opciones
//		método privado menu
		GestorIo gestorIo = new GestorIo();
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
		
//		Suponemos que mete un número del 1 al 8 y es correcto
//		método privado seleccionar opcion
		int opcion = gestorIo.inInt();
		switch (opcion) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;

		default:
			break;
		}
	}

	
	private void mostrar() {
		baraja.mostrar();
		descarte.mostrar();
		for(int i=0; i<palos.length; i++){
			palos[i].mostrar(); 
		}
		for(int i=0; i<columnas.length; i++){
			columnas[i].mostrar(); 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Klondike().jugar();
	}

}
