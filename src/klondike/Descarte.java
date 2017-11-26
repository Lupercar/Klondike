package klondike;

public class Descarte {

	private Carta[] cartas; 
	private int ultima; 
	
	public Descarte(){
		ultima = 0; 
		//como mucho puede haber 28 cartas
		cartas = new Carta[52-28]; 
	}
	
//	En el descarte se eneña tres cartas
	public void mostrar() {
		GestorIo gestorIo = new GestorIo();	
		gestorIo.out("\nDescarte: ");
		if(this.vacia()){
			gestorIo.out("<VACIA>");
		}else{
			int primeraVisible = ultima -3; 
			if(primeraVisible<0){ //sino tengo 3 cartas la primera visible saldra negativo
				primeraVisible = 0; 
			}
			
			for(int i=primeraVisible; i<ultima;i++){
				cartas[i].mostrar();
			}
		}
	}

//	Estoy repitiendo código
	private boolean vacia() {
		return ultima == 0;
	}

	public void moverA(Palo[] palos) {
		// TODO Auto-generated method stub
		
	}

	public void moverA(Columna[] columnas) {
		// TODO Auto-generated method stub
		
	}

	public void moverA(Palo palo) {
		assert palo != null; 
		if(this.vacia()){
			new GestorIo().out("Error!!! No hay cartas en descarte.");
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

	private Carta sacar() {
		// TODO Auto-generated method stub
		return null;
	}

	public void moverA(Columna columna) {
		assert columna != null; 
		if(this.vacia()){
			new GestorIo().out("Error!!! No hay cartas en descarte.");
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

	public void voltear(Baraja baraja) {
		// TODO Auto-generated method stub
		
	}

	public void poner(Carta carta) {
		// TODO Auto-generated method stub
		
	}

}
