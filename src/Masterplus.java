import java.util.ArrayList;

public class Masterplus extends Master {
	
	protected boolean admin= true ;
	protected ArrayList<Integer> code = new ArrayList <Integer>() ;
	protected int taille ;
	protected int possi=10 ;
	
	Masterplus(){
		admin=true;	
		taille =4;
		possi = 10;
		
		CodeAleaInit(code,taille, possi);
	}
	
	Masterplus(int pTaille){
		admin=true;	
		taille =pTaille;
		
		
		CodeAleaInit(code,taille, possi);	
	}
	
	Masterplus(int pTaille, boolean pAdmin){
		admin=pAdmin;	
		taille =pTaille;
		
		
		CodeAleaInit(code,taille, possi);	
	}
	
	
	
	public void reset() {
		
		CodeAlea(code,taille, possi);
		
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
	
	
	
	
public int setReponse (ArrayList <Integer> tab) {
	
	
	return SetRep(code,tab,taille,admin);
		
 
	}




static int SetRep(ArrayList <Integer> tab1,ArrayList <Integer> tab2,int pTaille,boolean pAdmin) {
	
	int verif =0;
	
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
		verif = 1 ;
		
		for(int i = 0; i < pTaille; i++){ 
			if (tab1.get(i)==tab2.get(i)) {
				System.out.print("=");
			}
			else if(tab1.get(i)<tab2.get(i)) {
				System.out.print("+");
				verif = 0;
			}
			else if(tab1.get(i)>tab2.get(i)) {
				System.out.print("-");
				verif = 0;
			}	
		}
	return verif;
	
}



}



