package klondike;

public class Baraja {

	public static final int NUM_PALOS = 4;
	private Carta[] cartas; 
	
	public Baraja(){
		cartas = new Carta[52]; 
		int contador = 0;
		for(int i = 0; i<4;i++){
			for(int j = 0; j<13; j++){
				cartas[] = new Carta(i,j);
				contador++; 
			}
		}
	}
	
	public void mostrar() {
		// TODO Auto-generated method stub
		
	}

	public void moverA(Descarte descarte) {
		// TODO Auto-generated method stub
		
	}

}
