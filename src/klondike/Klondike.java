package klondike;

public class Klondike {

	private Baraja baraja;
	private Palo[] palos; // tengo 4 palos
	private Columna[] columnas;
	private Descarte descarte;
	
	private static final int NUM_COLUMNAS = 7; 

	private Klondike() {
		baraja = new Baraja();
		descarte = new Descarte();

		palos = new Palo[Baraja.NUM_PALOS];
		for (int i = 0; i < palos.length; i++) {
			palos[i] = new Palo();
		}

		columnas = new Columna[NUM_COLUMNAS];
		for (int i = 0; i < columnas.length; i++) {
			columnas[i] = new Columna(i + 1, baraja);
		}
	}

	private void jugar() {
		// Le pongo un menu con las opciones
		// Me creo una Clase Menu
		Menu menu = new Menu();
		int opcion;

		do {
			// método privado mostrar estado()
			this.mostrar();
			menu.mostrar();
			
			//le paso una opcion
			opcion = menu.getOpcion(); 
			
			// Suponemos que mete un número del 1 al 8 y es correcto
			// método privado seleccionar opcion
			switch (opcion) {
			case 1:
				baraja.moverA(descarte); 
				break;
			case 2:
				descarte.moverA(this.recogerPalo("A"));
				break;
			case 3:
				descarte.moverA(this.recogerColumna("A"));
				break;
			case 4:
				this.recogerPalo("De").moverA(this.recogerColumna("A"));
				break;
			case 5:
				this.recogerColumna("De").moverA(this.recogerPalo("A"));
				break;
			case 6:
				this.recogerColumna("De").moverA(this.recogerColumna("A"));
				break;
			case 7:
				this.recogerColumna("De").voltear();
				break;
			case 8:
				descarte.voltear(baraja);
				break;
			case 9:
				break;

			}
		} while (opcion != 9);
	}

	private Columna recogerColumna(String prefijo) {
		GestorIo gestorIo = new GestorIo();
		int columna; 
		boolean error; 
		do{
			gestorIo.out("¿" + prefijo + " qué columna? [1-" + NUM_COLUMNAS + "]:" ); 
			columna = gestorIo.inInt(); 
			error = !new Intervalo(1,NUM_COLUMNAS).incluye(columna); 
			if(error){
				gestorIo.out("Error!!! Debe ser un número entero entre 1 y " + NUM_COLUMNAS);
			}
		}while(error);
		return columnas[columna-1];
	}

	private Palo recogerPalo(String prefijo) {
		GestorIo gestorIo = new GestorIo();
		int palo; 
		boolean error; 
		do{
			gestorIo.out("¿" + prefijo + " qué palo? [1-" + Baraja.NUM_PALOS + "]:" ); 
			palo = gestorIo.inInt(); 
			error = !new Intervalo(1,Baraja.NUM_PALOS).incluye(palo); 
			if(error){
				gestorIo.out("Error!!! Debe ser un número entero entre 1 y " + Baraja.NUM_PALOS);
			}
		}while(error);
		return palos[palo-1];
	}

	private void mostrar() {
		baraja.mostrar();
		descarte.mostrar();
		for (Palo palo : palos) {
			palo.mostrar();
		}
		for (Columna columna : columnas) {
			columna.mostrar();
		}
	}

	public static void main(String[] args) {
		new Klondike().jugar();
	}

}
