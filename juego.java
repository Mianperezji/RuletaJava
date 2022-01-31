package ruleta;

import java.util.Scanner;

public class juego {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Ruleta rule = new Ruleta();
		// TODO Auto-generated method stub

		
		//Establezco por consola el dinero que tengo para jugar
		System.out.println("Cuanto dinero tienes?");
		double dinero=sc.nextDouble();
		
		rule.setDinero(dinero);
		
		//mientras tenga dinero, quiero apostar
		while(rule.getDinero()>0) {
			//ESTABLEZCO LA APUESTA A REALIZAR
			System.out.println("Cuanto quieres apostar?");
			double apuesta =sc.nextDouble();
			rule.setApuesta(apuesta);
			
			//ESTABLEZCO A QUE QUIERO APOSTAR Y DECLARO EN LA VARIABLE PREMIADO EL NUMERO PREMIADO
			System.out.println("Que quieres hacer=");
			System.out.println("1- Apostar a un numero");
			System.out.println("2- Apostar a Par o Impar");
			System.out.println("3- Apostar a Negro o Rojo");
			System.out.println("4- Apostar a Docena");
			int opcion = sc.nextInt();
			int premiado =rule.getNumprem();
			
			switch(opcion) {
			case 1:
				
				System.out.println("A que numero quieres apostar?");
				int numero = sc.nextInt();
				rule.setNumjug(numero);
				
				//LA OPCION 1 DEL SETTER PREMIO
				rule.setPremio(1);
				//SI EL NUMERO COINCIDE TE SUMA EL PREMIO AL DINERO CON EL METODO WINNER
				if (rule.getNumjug()==premiado) {
					
					rule.winner("", premiado);
					
					//SI NO COINCIDE, PIERDES
				}else {
					rule.loser("", premiado);				
				}
				break;
				
			case 2:
				
				System.out.println("1- Apostar a Par");
				System.out.println("2- Apostar a Impar");
				int opcion2=sc.nextInt();
				//OPCION DOS DEL SETTER PREMIO, EL PREMIO SERA IGUAL A APUESTA*2
				rule.setPremio(2);
				
				//APOSTAMOS AL PAR
				if(opcion2==1) {
					//SI ES PAR GANAS
					if(premiado%2==0) {
						rule.winner("par", premiado);
						
						
						//SI ES IMPAR PIERDES
					}else {
						rule.loser("impar", premiado);						
					}
					//APOSTAMOS A IMPAR									
				}else {
					
					//SI ES PAR, PIERDES
					if(premiado%2==0) {
												
						rule.loser("par", premiado);
						
					//SI ES IMPAR, GANAS							
					}else {
						
						rule.winner("impar", premiado);
					}
						
						
				}
				break;
				//APOSTAMOS A NEGRO O ROJO
			case 3:
				// LA OPCION PARA CALCULAR EL SETTER DEL PREMIO ES 2, ES DECIR MULTIPLICAS TU DINERO POR 2
				rule.setPremio(2);
				System.out.println("A que color quieres apostar?");
				System.out.println("1- Negro");
				System.out.println("2- Rojo");
				 opcion2=sc.nextInt();
				
				 //APOSTAMIS AL NEGRO
				if (opcion2==1) {
					//SI SALE 0 GANA LA BANCA
					if (premiado==0) {
						rule.banca(premiado);
						
						//SI ES PAR PIERDES, LOS NUMEROS PARES SON ROJOS
					}else if(premiado%2==0) {
						
						
						rule.loser("rojo", premiado);
						
						
						//SI NO ES PAR GANAS, LOS NUMEROS NEGROS SON IMPARES
					}else {
						
						rule.winner("negro", premiado);
					}
					//SI NO APOSTAMOS AL NEGRO, APOSTAMOS AL ROJO																									
				}else {
					//SI SALE 0 GANA LA BANCA
					if (premiado==0) {
						rule.banca(premiado);
						//SI SALE PAR GANAS, LOS NUMEROS PARES SON ROJOS			
					}else if(premiado%2==0) {
						rule.winner("rojo", premiado);
							
						//SI NO SALE PAR PIERDES, LOS NUMEROS IMPARES SON NEGROS
					}else {
						
						rule.loser("negro", premiado);
						
					}
										
				}break;
				
				//CASO 4 APOSTAMOS A LA DOCENA
			case 4:
				//SETTER DEL PREMIO, OPCION 3, PREMIO== APUESTA*3
				rule.setPremio(3);
				System.out.println("A que docena quieres apostar?");
				System.out.println("1- 1-12");
				System.out.println("2- 13-24");
				System.out.println("3- 25-36");
				 opcion2=sc.nextInt();
				 				 
				 //SI SALE 0 GANA LA BANCA
				 if (premiado==0) {
					 rule.banca(premiado);
								
					 //SI NO SALE 0, HAZ ESTO
					}else {
						
						//APOSTAMOS A LA PRIMERA DOCENA
						if (opcion2==1) {
							//SI EL NUMERO PREMIADO ES MAYOR QUE 12, PIERDES
							if(premiado>12) {
								
								rule.loser("", premiado);
									
								//SI NO ES MAYOR QUE 12 GANAS
							}else {
								
								rule.winner("primera docena ", premiado);
							}
									
							//APOSTAMOS A LA SEGUNDA DOCENA
						}if (opcion2==2) {
							//SI EL NUMERO PREMIADO ES MENOR QUE 12 O ES MAYOR QUE 24 PIERDES
							if(premiado<12 || premiado > 24) {
								
								rule.loser("", premiado);
								//SI NO, GANAS															
							}else {
								
								rule.winner("segunda docena", premiado);
							}
							//SI NO APOSTAMOS A LA PRIMERA O SEGUNDA DOCENA, APOSTAMOS A LA TERCERA
						}else {
								//SI EL NUMERO PREMIADO ES MENOR QUE 24 PIERDES
								if(premiado < 24) {
								
									rule.loser("", premiado);
										
									//SI NO, GANAS
							}else {
								
								rule.winner("tercera docena", premiado);
							}
																					
						}
																			
					}																										
			}
					//CIERRO SCANNER Y LA RULE NO ES UN JUEGO, YO CUANDO PIERDO TODO MI DINERO ME JODE QUE FLIPAS								
		}System.out.println("Has perdido, la proxima vez, se menos ludopata");
		sc.close();
						
	}
							
}


