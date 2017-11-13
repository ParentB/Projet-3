import java.util.ArrayList;

public class IaMasterplus extends Masterplus {
	
	protected ArrayList <Integer> codeia = new ArrayList <Integer>() ;
	protected ArrayList <Integer> memia = new ArrayList <Integer>() ;
	int nbTour =0;
	
	IaMasterplus(){
		super();
		CodeAlea(codeia,taille, possi);
		System.out.println("\n\t"+ possi+ " "+ possi/2+ " "+ possi%2);
		for(int i =0 ; i<taille; i++){
			memia.add( possi/2 );
			System.out.println("\n\t"+ memia.get(i));
			
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
	
	
	
	
	
	public int setReponseResult (ArrayList <Integer> tab) {
		
		boolean verifJ;
		boolean verifI = false;
		int result =0;
		String str;
		nbTour = nbTour +1 ;
		System.out.println("\n\t tour" + nbTour);
		
		verifJ= SetRep(code,tab,taille,admin);
		str = SetRepIa(codeia,memia,taille);
		
		memia = Dicho(str,memia,nbTour,possi);
		
		if(str =="====") 
			verifI = true;
		
		if(verifI && verifJ)
			result =1 ;
		else if (verifJ)
			result = 2;
		else
			result =0;
		
		return result;
			
	 
		}
	
	
	
	
	
	static String SetRepIa(ArrayList <Integer> tab1,ArrayList <Integer> tab2,int pTaille) {
		
		
		String inputIa ="";
		
			System.out.println("\n\t Votre code :");
			for(int i = 0; i<pTaille; i++) {
				System.out.print(tab1.get(i));
		}
		
		if (tab2.size()!= pTaille) {
			
			System.out.println("\n\tMauvaise entrée ");
			
			return "";
			
		}
		System.out.println("\n\tProposition de l'IA : ");
			
		for(int i=0 ;i<pTaille;i++) {
			System.out.print(tab2.get(i));
			}
			
			System.out.print(" -> Reponse : ");
			
			
			for(int i = 0; i < pTaille; i++){ 
				if (tab1.get(i)==tab2.get(i)) {
					System.out.print("=");
					inputIa = inputIa +"=" ;
				}
				else if(tab1.get(i)<tab2.get(i)) {
					System.out.print("+");
					inputIa = inputIa +"+";
					
				}
				else if(tab1.get(i)>tab2.get(i)) {
					System.out.print("-");
					inputIa = inputIa +"-" ;
					
				}	
			}
			
			
		return inputIa;
		
	}
	
	
	
	
	
	
	static ArrayList <Integer> Dicho(String str, ArrayList <Integer> tab, int tour, int pPossi ) {
		
		for(int i = 0; i<str.length();i++) {
			
			if( str.charAt(i) == '-') {
				
				tab.set(i, (int) ( tab.get(i) + (pPossi / Math.pow(( double)pPossi, (double)tour)) + (pPossi / Math.pow(( double)pPossi, (double)tour))%2 ));
				
			}
			
			else if (str.charAt(i) == '+') {
				
				tab.set(i, (int) ( tab.get(i) -( pPossi / Math.pow(( double)pPossi, (double)tour)) - (pPossi % Math.pow(( double)pPossi, (double)tour))%2));
				
			}
		}
		
		return tab;
	}

	


}
