package klondike;

//23:42
public class Palo {

	private Carta[] cartas; 
	private int ultima; 
	
	public Palo() {
		ultima = 0; 
		//Un palo tiene como mucho 13 cartas
		cartas = new Carta[Baraja.NUM_NUMEROS];
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
	
	public void moverA(Columna columna) {
		// TODO Auto-generated method stub
		
	}

	public boolean apilable(Carta carta) {
		assert carta != null; 
		return this.vacia() && carta.esAs() || 
				!this.vacia() && carta.siguiente(this.cima()) && carta.igualPalo(this.cima()); 
	}

	public void poner(Carta carta) {
		// TODO Auto-generated method stub
		
	}
	
	public void mostrar(){
		GestorIo gestorIo = new GestorIo();
		gestorIo.out("\nPalo: ");
		if(this.vacia()){
			gestorIo.out("<VACIA>");
		}else{
			this.cima().mostrar(); //la carta que hay en la cima la muestro
		}
	}
	
	
}
