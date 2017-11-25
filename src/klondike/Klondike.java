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
//		Me creo una Clase Menu
		Menu menu = new Menu();
		
//		Suponemos que mete un número del 1 al 8 y es correcto
//		método privado seleccionar opcion
		
		switch (menu.getOpcion()) {
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
		new Klondike().jugar();
	}

}
