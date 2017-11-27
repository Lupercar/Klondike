package klondike;

public class Carta {

//	31:38
	private int palo; 
	private int numero; 
	private boolean bocaArriba;				//0			1		2			3
	private static final String[] PALOS = {"Picas","Trevoles","Diamantes","Coronas"};
	
	private static final Intervalo NEGROS = new Intervalo(0,1); //posicion 0 y 1 de PALOS
	private static final Intervalo ROJOS = new Intervalo(2,3);
	
	private static final String[] NUMEROS = {"As","2","3","4","5","6","7","8","9","10","J","Q","K"};
	
	public Carta(int palo, int numero) {
		assert new Intervalo(0,Baraja.NUM_PALOS-1).incluye(palo); 
		assert new Intervalo(0,Baraja.NUM_NUMEROS-1).incluye(palo); 
		this.palo = palo;
		this.numero = numero; 
		bocaArriba = false; 
	}

	public boolean bocaArriba() {
		return bocaArriba;
	}
	
	public void voltear() {
		bocaArriba = !bocaArriba;
	}
	
	public boolean esAs() {
		return numero == 0;
	}
	
	public boolean esRey() {
		return numero == 12; 
	}
	
	public boolean siguiente(Carta carta) {
		return numero == carta.numero+1;
	}
	
	public boolean igualPalo(Carta carta) {
		return palo == carta.palo; 
	}
	
	public boolean distintoColor(Carta carta) {
		return this.rojo() && carta.negro() || this.negro() && carta.rojo(); 
	}
	
	public boolean rojo(){
		return ROJOS.incluye(palo); 
	}
	
	public boolean negro(){
		return NEGROS.incluye(palo); 
	}
	
	
	public Carta() {
		// TODO Auto-generated constructor stub
	}

	public void mostrar() {
		String numero = "???";
		String palo = "???";
		if(this.bocaArriba){
			numero = NUMEROS[this.numero];
			palo = PALOS[this.palo]; 
		}
		new GestorIo().out("{" + numero + " de " + palo + "}"); 
	}

}
