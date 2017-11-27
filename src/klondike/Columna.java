package klondike;

public class Columna {
	
	private Carta[] cartas;
	private int ultima;
	private int posicion;

	public Columna(int posicion, Baraja baraja) {
		this.posicion = posicion;
		ultima = 0; 
		cartas = new Carta[posicion + Baraja.NUM_NUMEROS-1]; 
		for(int i=0; i<posicion; i++){
			Carta carta = baraja.sacar();
			if(i == posicion-1){
				carta.voltear();
			}
			this.poner(carta);
		}
	}
	
	private boolean vacia(){
		return ultima == 0; 
	}
	
	private boolean completa(){
		return ultima == Baraja.NUM_NUMEROS; 
	}
	
	private Carta cima(){
		assert !this.vacia();
		return cartas[ultima-1]; 
	}

	public Carta sacar(){
		assert !this.vacia();
		ultima--;
		return cartas[ultima]; 
	}
	
	public void poner(Carta carta) {
		assert carta != null;
		assert !this.completa(); 
		cartas[ultima] = carta;
		ultima++; 
	}
	
	public void mostrar() {
		GestorIo gestorIo = new GestorIo();
		gestorIo.out("\nColumna " + posicion + ": ");
		if(this.vacia()){
			gestorIo.out("<VACIA>");
		}else{
			for(Carta carta : cartas){
				carta.mostrar();
			}
		}
	}

	public void moverA(Palo palo) {
		if(this.vacia()){
			new GestorIo().out("Error!!! No hay cartas en columna.");
		}else{
			Carta carta = this.sacar();
			if(palo.apilable(carta)){
				palo.poner(carta);
			}else{
				this.poner(carta);
				new GestorIo().out("Error!!! No se puede realizar ese movimiento.");
			}
		}
	}

	public void moverA(Columna columna) {
		if(this.vacia()){
			new GestorIo().out("Error!!! No hay cartas en columna.");
		}else{
			Carta carta = this.sacar();
			if(columna.apilable(carta)){
				columna.poner(carta);
			}else{
				this.poner(carta);
				new GestorIo().out("Error!!! No se puede realizar ese movimiento.");
			}
		}
	}

	public void voltear() {
		if(this.vacia()){
			new GestorIo().out("Error!!! No hay carta que voltear.");
		}else if(this.cima().bocaArriba()){
			new GestorIo().out("Error!!! No hay carta boca abajo en la cima.");
		}else{
			this.cima().voltear();
		}
	}

	public boolean apilable(Carta carta) {
		assert carta != null;
		return this.vacia() && carta.esRey() ||
			!this.vacia() && this.cima().bocaArriba() &&
			this.cima().siguiente(carta) && 
			this.cima().distintoColor(carta);
	}

	

}
