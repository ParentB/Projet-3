import java.util.ArrayList;

public class Mastermind extends Master {

	protected boolean admin ;
	protected ArrayList <Integer> code = new ArrayList <Integer>() ;
	protected int taille ;
	protected int possi ;


	Mastermind(){

		admin=true;	
		taille =4;
		possi = 4;
		codeAleaInit(code,taille, possi);	
	}

	Mastermind(int pTaille, int pPossi){

		admin=true;	
		taille =pTaille;
		possi = pPossi;
		codeAleaInit(code,taille, possi);		
	}

	Mastermind(int pTaille, int pPossi, boolean pAdmin){

		admin=pAdmin;	
		taille =pTaille;
		possi = pPossi;
		codeAleaInit(code,taille, possi);		
	}

	public void setAdmin(boolean pAdmin) {

		admin =pAdmin ;
		if(admin) {
			System.out.println("\n\t Vous êtes passé en mode administrateur");
		} else {
			System.out.println("\n\t Vous êtes sortie du mode administrateur");
		}	
	}



	public void reset() {

		CodeAlea(code,taille, possi);
	}




	public boolean getAdmin() {

		return admin;
	}

	public int setRep(ArrayList <Integer> rep){

		int trouv = 0;
		int mal =0 ;
		ArrayList <Boolean> tri1 = new ArrayList <Boolean>() ;
		ArrayList <Boolean> tri2 = new ArrayList <Boolean>() ;
		for (int i=0 ; i < taille  ;i++) {
			tri1.add(true);
			tri2.add(true);
		}
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
			if (code.get(i) == rep.get(i) && tri1.get(i)) {
				trouv = trouv + 1;
				tri1.set(i, false);
				tri2.set(i, false);
			}
		}
		for(int j = 0 ; j<taille ; j++) {
			int i = 0;
			while(i<taille && tri1.get(j)) {
				if (code.get(i) == rep.get(j) && tri2.get(i)) {
					mal = mal + 1;
					tri1.set(j, false);
					tri2.set(i, false);
				}
				i = i + 1 ;
			}
		}
		if(trouv!= taille)
			verif = 0;
		System.out.print(" il y a "+trouv+" Bien placé et "+mal+" mal placé");
		return verif;
	}

	static void CodeAlea(ArrayList <Integer> tab,int taille ,int  pPossi) {

		for(int i = 0;i <taille; i++) {
			tab.add( (int)( Math.random()*(pPossi)));
		}	
	}
}




