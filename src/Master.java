import java.util.ArrayList;

public class Master {
	
	static void CodeAlea(ArrayList <Integer> tab,int taille ,int  pPossi) {
		
		for(int i = 0;i <taille; i++) {
			tab.add( (int)( Math.random()*(pPossi + 1) ));
		}	
		
	}

	static void setCode(ArrayList <Integer>  pCode,ArrayList <Integer> tab, int pTaille) {
		
		
		if(tab.size() != pTaille) {
			System.out.println("\n\t Réponse de mauvaise taille");
		}
		else {
			for(int i = 0; i < pTaille; i++){ 
				pCode.set(i, tab.get(i));
			}
		}
	}

	static boolean SetRep(ArrayList <Integer> tab1,ArrayList <Integer> tab2,int pTaille,boolean pAdmin) {
		
		boolean verif =false;
		
		if (pAdmin) {
			System.out.println("\n\t la réponse est :");
			for(int i = 0; i<pTaille; i++) {
				System.out.print(tab1.get(i));
			}
		}
		
		if (tab2.size()!= pTaille) {
			
			System.out.println("\n\tMauvaise entrée ");
			
			return verif;
			
		}
		
		System.out.println("\n\tProposition : ");
			
		for(int i=0 ;i<pTaille;i++) {
			System.out.print(tab2.get(i));
			}
			
			System.out.print(" -> Reponse : ");
			verif = true ;
			
			for(int i = 0; i < pTaille; i++){ 
				if (tab1.get(i)==tab2.get(i)) {
					System.out.print("=");
				}
				else if(tab1.get(i)<tab2.get(i)) {
					System.out.print("+");
					verif = false;
				}
				else if(tab1.get(i)>tab2.get(i)) {
					System.out.print("-");
					verif = false;
				}	
			}
		return verif;
		
	}

}
