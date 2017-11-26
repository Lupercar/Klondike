package klondike;

import java.util.Random;

public class Baraja {
	
	public static final int NUM_NUMEROS = 13;
	public static final int NUM_PALOS = 4;
	private Carta[] cartas; 
	private int ultima; 
	
	public Baraja(){
		ultima = 0; 
		cartas = new Carta[NUM_PALOS*NUM_NUMEROS]; //52 cartas
		int contador = 0;
		for(int i = 0; i<NUM_PALOS;i++){
			for(int j = 0; j<NUM_NUMEROS; j++){
				this.poner(new Carta(i,j)); 
			}
		}
		this.barajar(); 
	}
	
	private void barajar() {
		Random aleatorio = new Random();
		for(int i=0; i<1000;i++){
			int origen = aleatorio.nextInt(NUM_PALOS*NUM_NUMEROS);
			int destino = aleatorio.nextInt(NUM_PALOS*NUM_NUMEROS);
			Carta carta = cartas[origen];
			cartas[origen] = cartas[destino];
			cartas[destino] = carta; 
		}
	}

	private void poner(Carta carta) {
		assert carta != null; 
		assert ! carta.bocaArriba(); 
		assert ! this.completa(); 
		cartas[ultima] = carta; 
		ultima++; 
	}

	private boolean completa() {
		return ultima == NUM_PALOS * NUM_NUMEROS;
	}

	public void mostrar() {
		GestorIo gestorIo = new GestorIo();
		gestorIo.out("\nBaraja: ");
		if(this.vacia()){
			gestorIo.out("<VACIA>");
		}else{
			this.cima().mostrar(); 
		}
	}

	private Carta cima() {
		assert !this.vacia();
		return cartas[ultima-1];
	}

	public void moverA(Descarte descarte) {
		if(this.vacia()){
			new GestorIo().out("Error!!! No hay cartas en la baraja.");
		}else{
			int contador = 3; 
			while(contador>0 && !this.vacia()){
				Carta carta = this.sacar();
				carta.voltear();
				descarte.poner(carta);
				contador--; 
			}
		}
	}

	private Carta sacar() {
		assert !this.vacia(); 
		ultima--;
		return cartas[ultima];
	}

	private boolean vacia() {
		return ultima == 0;
	}

}
