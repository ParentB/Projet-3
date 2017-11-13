import java.util.ArrayList;

public class IaMasterplus extends Masterplus {
	
	protected ArrayList <Integer> codeia = new ArrayList <Integer>() ;
	protected ArrayList <Integer> memia = new ArrayList <Integer>() ;
	int nbTour =0;
	
	IaMasterplus(){
		super();
		CodeAlea(codeia,taille, possi);
		for(int i =0 ; i<taille; i++){
			memia.add( possi/2 );
			
		}
	}
	
	IaMasterplus(int pTaille, int pPossi){
		super();	
		CodeAlea(codeia,taille, possi);
		for(int i =0 ; i<taille; i++){
			memia.set(i, possi/2+ (possi%2));
	}
	}
	
	IaMasterplus(int pTaille, int pPossi,ArrayList <Integer> pCodeia){
		super();	
		for(int i =0 ; i<taille; i++){
			codeia.set(i, pCodeia.get(i));
			memia.set(i, possi/2+ (possi%2));
	}
	}
	
	
	
	
	
	public boolean setReponse (ArrayList <Integer> tab) {
		
		return SetRep(code,tab,taille,admin);
		//return SetRepIa(codeia,tab,memia,taille,possi,nbTour,true);
			
	 
		}
	
	
	
	
	
	/*static boolean SetRepIa(ArrayList <Integer> tab1,ArrayList <Integer> tab2,ArrayList <Integer> mem,int pTaille,int pPossi,int tour,boolean pAdmin) {
		
		boolean verif =false;
		String inputIa ="";
		
			System.out.println("\n\t Votre code :");
			for(int i = 0; i<pTaille; i++) {
				System.out.print(tab1.get(i));
		}
		
		if (tab2.size()!= pTaille) {
			
			System.out.println("\n\tMauvaise entrée ");
			
			return verif;
			
		}
		tour= tour +1 ;
		System.out.println("\n\tProposition de l'IA : ");
			
		for(int i=0 ;i<pTaille;i++) {
			System.out.print(tab2.get(i));
			}
			
			System.out.print(" -> Reponse : ");
			verif = true ;
			
			for(int i = 0; i < pTaille; i++){ 
				if (tab1.get(i)==tab2.get(i)) {
					System.out.print("=");
					inputIa = inputIa +"=" ;
				}
				else if(tab1.get(i)<tab2.get(i)) {
					System.out.print("+");
					inputIa = inputIa +"+";
					verif = false;
				}
				else if(tab1.get(i)>tab2.get(i)) {
					System.out.print("-");
					inputIa = inputIa +"-" ;
					verif = false;
				}	
			}
			
			Dicho(inputIa, mem, tour, pPossi);
		return verif;
		
	}*/
	
	
	
	
	
	
	/*static void Dicho(String str, ArrayList <Integer> tab, int tour, int pPossi ) {
		
		for(int i = 0; i<str.length();i++) {
			
			if( str.charAt(i) == '+') {
				
				tab.set(i, (int) ( tab.get(i) + pPossi / Math.pow(( double)pPossi, (double)tour )));
				
			}
			
			else if (str.charAt(i) == '-') {
				
				tab.set(i, (int) ( tab.get(i) - pPossi / Math.pow(( double)pPossi, (double)tour )));
				
			}
		}
	}*/

	


}
