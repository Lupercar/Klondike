package klondike;

public class Klondike {

	private Baraja baraja;
	private Palo[] palos; // tengo 4 palos
	private Columna[] columnas;
	private Descarte descarte;

	private Klondike() {
		baraja = new Baraja();
		descarte = new Descarte();

		palos = new Palo[4];
		for (int i = 0; i < palos.length; i++) {
			palos[i] = new Palo();
		}

		columnas = new Columna[7];
		for (int i = 0; i < columnas.length; i++) {
			columnas[i] = new Columna(i + 1, baraja);
		}
	}

	private void jugar() {
		// Le pongo un menu con las opciones
		// Me creo una Clase Menu
		GestorIo gestorIo = new GestorIo();
		Menu menu = new Menu();
		int opcion;

		do {
			// método privado mostrar estado()
			this.mostrar();
			
			//le paso una opcion
			opcion = menu.getOpcion(); 
			
			// Suponemos que mete un número del 1 al 8 y es correcto
			// método privado seleccionar opcion
			switch (opcion) {
			case 1:
				baraja.moverA(descarte); 
				break;
			case 2:
				descarte.moverA(palos);
				break;
			case 3:
				descarte.moverA(columnas);
				break;
			case 4:
				gestorIo.out("De que palo? [1-4]: ");
				Palo palo = palos[gestorIo.inInt()-1];
				gestorIo.out("De que columna? [1-7]: ");
				Columna columna = columnas[gestorIo.inInt()-1];
				palo.moverA(columna);
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
		} while (opcion != 9);
	}

	private void mostrar() {
		baraja.mostrar();
		descarte.mostrar();
		for (int i = 0; i < palos.length; i++) {
			palos[i].mostrar();
		}
		for (int i = 0; i < columnas.length; i++) {
			columnas[i].mostrar();
		}
	}

	public static void main(String[] args) {
		new Klondike().jugar();
	}

}//1:44:17
