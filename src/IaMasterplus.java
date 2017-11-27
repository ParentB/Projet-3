import java.util.ArrayList;

public class IaMasterplus extends Masterplus {

	protected ArrayList<Integer> codeia = new ArrayList <>() ;
	protected ArrayList<Integer> memia = new ArrayList <>() ;
	int nbTour = 1;
	IaMasterplus(){
		super();
		codeAlea(codeia,taille, possi);
		System.out.println("\n\t"+ possi+ " "+ possi/2+ " "+ possi%2);
		for(int i = 0 ; i < taille; i++) {
			memia.add( possi/2 );
			System.out.println("\n\t"+ memia.get(i));
		}
	}




	IaMasterplus(int pTaille){
		super();	
		codeAleaInit(codeia,taille, possi);
		for(int i = 0 ; i < taille; i++){
			memia.add( possi/2+ (possi%2));
		}
	}

	IaMasterplus(int pTaille, boolean pAdmin){
		super();	
		codeAleaInit(codeia,taille, possi);
		for(int i = 0 ; i<taille; i++){
			memia.add( possi/2+ (possi%2));
		}
	}





	IaMasterplus(int pTaille, int pPossi,ArrayList <Integer> pCodeia){
		super();	
		for(int i = 0 ; i < taille; i++){
			codeia.set(i, pCodeia.get(i));
			memia.set(i, possi/2+ (possi%2));
		}
	}


	public void reset() {

		codeAlea(code,taille, possi);
		codeAlea(codeia,taille, possi);
		nbTour =1;
		for(int i = 0 ; i<taille; i++) {
			memia.set( i , possi/2 );
			System.out.println("\n\t"+ memia.get(i));
		}
	}


	public void setCode(ArrayList <Integer> tab) {

		for(int i =0 ; i< taille ;i++) {
			codeia.set(i, tab.get(i));
		}
	}


	public int setReponseIaDef(ArrayList <Integer> tab) {

		boolean verifI = false;
		int result =0;
		String str;
		System.out.println("\n\t tour" + nbTour);
		str = this.SetRepIa();
		memia = Dicho(str,memia,nbTour,possi);
		if("====".equals(str)) 
			verifI = true;
		if(verifI)
			result = 1;
		else
			result = 0;
		nbTour = nbTour +1 ;
		return result;
	}









	public int setReponseIa(ArrayList <Integer> tab) {

		int verifJ;
		boolean verifI = false;
		int result =0;
		String str;
		System.out.println("\n\t tour" + nbTour);
		verifJ= this.setRep(tab);
		str = this.SetRepIa();
		memia = Dicho(str,memia,nbTour,possi);
		if("====".equals(str)) 
			verifI = true;
		if(verifI && verifJ == 1)
			result = 1;
		else if (verifJ==1 && !verifI)
			result = 2;
		else if (verifI && verifJ !=1)
			result = -1;
		else
			result = 0;
		nbTour = nbTour +1 ;
		return result;
	}



	public String SetRepIa() {

		String inputIa ="";
		System.out.println("\n\t Votre code :");
		for(int i = 0; i<taille; i++) {
			System.out.print(codeia.get(i));
		}
		if (memia.size()!= taille) {
			System.out.println("\n\tMauvaise entrée ");
			return "";
		}
		System.out.println("\n\tProposition de l'IA : ");
		for(int i=0 ;i<taille;i++) {
			System.out.print(memia.get(i));
		}
		System.out.print(" -> Reponse : ");
		for(int i = 0; i < taille; i++){ 
			if (codeia.get(i)==memia.get(i)) {
				System.out.print("=");
				inputIa = inputIa +"=" ;
			} else if(codeia.get(i)<memia.get(i)) {
				System.out.print("+");
				inputIa = inputIa +"+";
			} else if(codeia.get(i)>memia.get(i)) {
				System.out.print("-");
				inputIa = inputIa +"-" ;
			}	
		}
		return inputIa;
	}






	static ArrayList <Integer> Dicho(String str, ArrayList <Integer> tab, int tour, int pPossi ) {

		int a;
		a= pPossi/ (int)Math.pow(2, tour+1)  ;
		if (pPossi/(int)Math.pow(2, tour+1)%2 == 1 || pPossi/(int)Math.pow(2, tour+1)%2 == 0 )
			a=a+1;
		for(int i = 0; i<str.length();i++) {
			if( str.charAt(i) == '-') {
				tab.set(i, (int) ( tab.get(i))+a);
			} else if (str.charAt(i) == '+') {
				tab.set(i, (int) ( tab.get(i) - a ));
			}
		}
		return tab;
	}




}
