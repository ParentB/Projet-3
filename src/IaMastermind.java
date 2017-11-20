import java.util.ArrayList;

public class IaMastermind extends Mastermind {

	protected ArrayList<Integer> codeia = new ArrayList <>() ;
	protected ArrayList<Integer> memia = new ArrayList <>() ;
	protected ArrayList<Integer> memoire = new ArrayList <>() ;
	protected int memiatrouv = 0 ;
	protected int memiamal = 0 ;


	IaMastermind(){
		super();
		CodeAleaInit(codeia,taille, possi);
		System.out.println("\n\t"+ possi+ " "+ possi/2+ " "+ possi%2);
		
		for(int i = 0 ; i<taille; i++) {
			
			memia.add( possi/2 );
			System.out.println("\n\t"+ memia.get(i));

		}
	}




	IaMastermind(int pTaille, int pPossi){
		super();	
		CodeAleaInit(codeia,taille, possi);
		for(int i = 0 ; i<taille; i++){
			memia.add( possi/2+ (possi%2));
		}
	}
	

	IaMastermind(int pTaille, int pPossi, boolean pAdmin){
		super();	
		CodeAleaInit(codeia,taille, possi);
		for(int i = 0 ; i<taille; i++){
			memia.add( possi/2+ (possi%2));
		}
	}





	IaMastermind(int pTaille, int pPossi,ArrayList <Integer> pCodeia){
		super();	
		for(int i = 0 ; i < taille; i++){
			codeia.set(i, pCodeia.get(i));
			memia.set(i, possi/2+ (possi%2));
		}
	}
	
	public void setCode(ArrayList <Integer> tab) {


		for(int i =0 ; i< taille ;i++) {
			codeia.set(i, tab.get(i));
		}
	
}
	
	public void reset() {
		
		CodeAlea(code,taille, possi);
		CodeAlea(codeia,taille, possi);
		CodeAlea(memia, taille ,possi);
		memiatrouv = 0;
		memiamal = 0;


		
		
	}









	public int setReponseIa (ArrayList <Integer> tab) {

		ArrayList<Integer> rep =  new ArrayList <>();
		int verifJ = 0, result = 0, trouv = 0, mal = 0;
		boolean verifI = false;
		
		
		

		
		rep= crack(memia,memoire, taille, possi ,memiatrouv, memiamal);
		
		verifJ= SetRep(code,tab,taille,admin);
		rep = SetRepIa(codeia,rep,taille);
		
		mal = rep.get(taille +1 );
		rep.remove(taille +1 );
		trouv = rep.get(taille );
		rep.remove(taille);
		
		if(( 5 * trouv ) + ( 4  * mal ) > ( 5 * memiatrouv ) + ( 4 * memiamal )) {
			memiatrouv = trouv ;
			memiamal = mal ;
			memia = rep;
		}
		
		if(memiatrouv == taille ) {
			verifI = true;
		}


		if(verifI && verifJ == 1)
			result = 1;
		else if (verifJ==1 && !verifI)
			result = 2;
		else if (verifI && verifJ !=1)
			result = -1;
		else
			result = 0;
		


		return result;


	}
	
	public int setReponseIaDef (ArrayList <Integer> tab) {

		ArrayList<Integer> rep =  new ArrayList <>();
		int  result = 0, trouv = 0, mal = 0;
		boolean verifI = false;
		
		
		

		
		rep= crack(memia,memoire, taille, possi ,memiatrouv, memiamal);
		
		rep = SetRepIa(codeia,rep,taille);
		
		mal = rep.get(taille +1 );
		rep.remove(taille +1 );
		trouv = rep.get(taille );
		rep.remove(taille);
		
		if(( 5 * trouv ) + ( 4  * mal ) > ( 5 * memiatrouv ) + ( 4 * memiamal )) {
			memiatrouv = trouv ;
			memiamal = mal ;
			memia = rep;
		}
		
		if(memiatrouv == taille ) {
			verifI = true;
		}


		if(verifI)
			result = 1;
		else
			result = 0;
		


		return result;


	}





	static ArrayList<Integer> SetRepIa(ArrayList <Integer> tab1,ArrayList <Integer> tab2,int pTaille ) {


		ArrayList<Integer> res =  tab2;
		ArrayList<Boolean> tri1 =  new ArrayList <>();
		ArrayList<Boolean> tri2 =  new ArrayList <>();
		
		for(int i=0;i < pTaille; i++) {
			tri1.add(true);
			tri2.add(true);
		}
		int trouv = 0, mal = 0;

		System.out.println("\n\t Votre code :");
		for(int i = 0; i<pTaille; i++) {
			System.out.print(tab1.get(i));
		}
		

	
		System.out.println("\n\tProposition de l'IA : ");

		for(int i=0 ;i<pTaille;i++) {
			System.out.print(tab2.get(i));
		}

		System.out.print(" -> Reponse : ");


		for(int i = 0; i < pTaille; i++){ 
			if ( tab1.get(i)== tab2.get(i)) {
				
				trouv = trouv + 1;
				tri1.set(i, false);
				tri2.set(i, false);
			}
		}
		
	
		for(int j = 0 ; j<pTaille ; j++) {
			int i = 0;
			while(i<pTaille && tri1.get(j)) {
				if (tab1.get(i)==tab2.get(j) && tri2.get(i)) {
					mal = mal + 1;
					tri1.set(j, false);
					tri2.set(i, false);
				}
				i = i + 1 ;
				
			}
		}
		
		
		System.out.print(" il y a "+trouv+" Bien placé et "+mal+" mal placé");
		
		res.add(trouv);
		res.add(mal);


		return res;

	}

	
	
static ArrayList <Integer> crack(ArrayList<Integer> mem,ArrayList <Integer> memoire, int pTaille, int pPossi, int trouvia, int malia){
	
	ArrayList<Integer> etat =  new ArrayList <>();
	ArrayList<Integer> rep =  new ArrayList <>();
	int j =0, verif =0000;
	
	for(int i = 0; i<pTaille; i++) {
		
		etat.add(0);
		rep.add(mem.get(i));
	}
	
	do {
		verif = 0;
		j = 0 ;
		for(int i = 0; i<pTaille; i++) {
			
			etat.set(i,0);
			
		}
		
		
		while(j<trouvia) {
			
				
			int alea = (int)( Math.random()*(pPossi)  ); 
			if (etat.get(alea) == 0) {

				
				etat.set(alea, 1);
				j= j + 1;
			}
			
		}
		
		j = 0 ;
		
		while(j<malia) {
			

			
			int alea;
			
			do {
				
				alea = (int)( Math.random()*(pTaille)  ); 
			}while(etat.get(alea) != 0);
			
			
			
				
				int trans =0,alea2 = -1;
				do {
					
					alea2=(int)( Math.random()*(pTaille)  );
					
				}while(etat.get(alea2)!=0);
				
				trans = rep.get(alea);
				rep.set(alea, rep.get(alea2));
				rep.set(alea2, trans);
				if (malia- j %2 == 0) {
					etat.set(alea, 1);
					j = j +2;
				}
				else {
					etat.set(alea, 0);
					j = j + 1;
				}
				
				etat.set(alea2, 1);
			
			
		}
		
		for(int i = 0 ; i < pTaille ; i++) {
			if (etat.get(i) == 0) {	
				rep.set(i,(int)( Math.random()*(pPossi) ));
			}
			

		}
		int puis =1;
		for(int i = 0 ; i < pTaille ; i++) {
			
			verif = verif + (rep.get(i)* puis);
			puis =puis *10;
			
		}
		System.out.println(" non déja fait");
	}while (memoire.contains(verif));
	
	memoire.add(verif);
	
	return rep;
	
}

}
