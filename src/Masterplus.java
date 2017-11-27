import java.util.ArrayList;

public class Masterplus extends Master {

	protected boolean admin;
	protected ArrayList<Integer> code = new ArrayList <Integer>() ;
	protected int taille ;
	protected int possi=10 ;

	Masterplus(){
		admin=true;	
		taille =4;
		possi = 10;
		codeAleaInit(code,taille, possi);
	}

	Masterplus(int pTaille){
		admin=true;	
		taille =pTaille;
		codeAleaInit(code,taille, possi);	
	}

	Masterplus(int pTaille, boolean pAdmin){
		admin=pAdmin;	
		taille =pTaille;
		codeAleaInit(code,taille, possi);	
	}

	public void reset() {

		codeAlea(code,taille, possi);

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

	public int setRep(ArrayList <Integer> rep) {

		int verif =0;
		if (admin) {
			System.out.println("\n\t la réponse est :");
			for(int i = 0; i<taille; i++) {
				System.out.print(code.get(i));
			}
		}
		if (rep.size()!= taille) {
			System.out.println("\n\tMauvaise entrée ");
			return verif;
		}
		System.out.println("\n\tProposition : ");
		for(int i=0 ;i<taille;i++) {
			System.out.print(rep.get(i));
		}
		System.out.print(" -> Reponse : ");
		verif = 1 ;
		for(int i = 0; i < taille; i++){ 
			if (code.get(i)==rep.get(i)) {
				System.out.print("=");
			}
			else if(code.get(i)<rep.get(i)) {
				System.out.print("+");
				verif = 0;
			}
			else if(code.get(i)>rep.get(i)) {
				System.out.print("-");
				verif = 0;
			}	
		}
		return verif;
	}
}