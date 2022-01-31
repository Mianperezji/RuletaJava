package ruleta;

public class Ruleta {
	
	private int numprem;
	private int numjug;
	private double dinero;
	private double apuesta;
	private double premio;
	
	
	// GETTERS AND SETTERS
	public int getNumprem() {
		//getter que te devuelve el num premiado entre 0 y 36
		numprem=(int)(Math.random() * 36);
		
		return numprem;
	}


		// SETTER INUTIL
	public void setNumprem(int numprem) {
		this.numprem = numprem;
	}



	public int getNumjug() {
		return numjug;
	}



	public void setNumjug(int numjug) {
		this.numjug = numjug;
	}



	public double getDinero() {
		return dinero;
	}



	public void setDinero(double dinero) {
		this.dinero = dinero;
	}



	public double getApuesta() {
		return apuesta;
	}



	public void setApuesta(double apuesta) {
		this.apuesta = apuesta;
	}



	public double getPremio() {
		return premio;
	}


	// DEPENDE DEL NUMERO QUE LE INTRODUZCAS TE CALCULARA UN PREMIO U OTRO
	public void setPremio(double premio) {
		//pleno
		if (premio==1) {
			this.premio= (apuesta*35);
			//par o impar rojo negro
		}else if (premio==2) {
			this.premio=(apuesta*2);
			//docena
		}else {
			this.premio=(apuesta*3);
		}
		
		
	}
	
	//TE SUMA  EL PREMIO AL DINERO ACTUAL SI GANAS
	public  void winner(String s, int premiado) {
		
		this.setDinero(this.getDinero()+this.getPremio());
		System.out.println("Ha salido el "+premiado+ " " + s +
				" . Has ganado, tienes "+ this.getDinero()+" euros");
		
		
	}
	//TE RESTA LO APOSTADO AL DINERO ACTUAL 
	public void loser(String s, int premiado) {
		
		this.setDinero(this.getDinero()-this.getApuesta());
		
		System.out.println("Ha salido el "+premiado+ ". "+s+
				"Has perdido, tienes "+ this.getDinero()+" euros");
		
		
		
	}
	
	public void banca(int premiado) {
		
		
		this.setDinero(this.getDinero()-this.getApuesta());
		
		System.out.println("Ha salido el "+premiado+
				" gana la banca, tienes "+ this.getDinero()+" euros");
		
		
		
	}



	public Ruleta() {
		
		dinero =0;
		apuesta=0;
		numjug=0;
		numprem=0;
		premio=0;
		
	}

}
