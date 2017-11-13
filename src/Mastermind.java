import java.util.ArrayList;

public class Mastermind {
	
	protected boolean admin ;
	protected ArrayList <Integer> code = new ArrayList <Integer>() ;
	protected ArrayList <Boolean> tri = new ArrayList <Boolean>() ;
	protected int taille ;
	protected int possi ;
	protected int trouv;
	protected int mal;
	
	Mastermind(){
		admin=true;	
		taille =4;
		possi = 4;
		
		for(int i = 0;i <taille; i++) {
			code.add( (int)( Math.random()*(possi + 1) ));
			tri.add(true);
		}	
	}
	
	Mastermind(int pTaille, int pPossi){
		admin=true;	
		taille =pTaille;
		possi = pPossi;
		
		for(int i = 0;i <taille; i++) {
			code.add( (int)( Math.random()*(possi + 1) ));
			tri.add(true);
		}	
	}
	
	public void setAdmin(boolean pAdmin) {
		
		admin =pAdmin ;
		
		if(admin) {
			System.out.println("\n\t Vous êtes passé en mode administarteur");
		}
		else {
			System.out.println("\n\t Vous êtes sortie du mode administrateur");
		}	
	}
	
	public boolean getAdmin() {
		
		return admin;
		
	}
	
	
	public void setCode(int[] tab) {
		
		if (admin) {
			if(tab.length != taille) {
				System.out.println("\n\t Réponse de mauvaise taille");
			}
			else {
				for(int i = 0; i < taille; i++){ 
					code.set(i, tab[i]);
				}
			}
			
		}
		
		else {
			System.out.println("\n\t Vous devez entrez en mode admin pour changer le code ");
		}
	}
	
public boolean setReponse (ArrayList <Integer> tab) {
		
		boolean verif =false;
		trouv = 0;
		mal = 0;
		
		if (admin) {
			System.out.println("\n\t la réponse est :");
			for(int i = 0; i<taille; i++) {
				System.out.print(code.get(i));
			}
		}
		
		if (tab.size()!= taille) {
			
			System.out.println("\n\tMauvaise entrée ");
			
			return verif;
			
		}
		
		System.out.println("\n\tProposition : ");
			
		for(int i=0 ;i<taille;i++) {
			System.out.print(tab.get(i));
			}
			
			System.out.print(" -> Reponse : ");
			verif = true ;
			
			for(int i = 0; i < taille; i++){ 
				if (code.get(i)==tab.get(i) && tri.get(i)) {
					trouv = trouv + 1;
					tri.set(i, false);
					
				}
				
			}
			
			for(int j = 0; j < taille; j++){ 
				for(int i = 0; i < taille; i++){ 
					if (code.get(i)==tab.get(j) && tri.get(i)) {
						mal = mal + 1;
						tri.set(i, false);
						verif = false;
					}
				
				}
			}
				
			for(int i = 0; i < taille; i++){ 
				
				tri.set(i, true);
				
			}
			
			System.out.print(" il y a "+trouv+" Bien placé et "+mal+" mal placé");
		return verif;
 
	}

}


