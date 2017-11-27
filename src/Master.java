import java.util.ArrayList;

public class Master {

	static void codeAlea(ArrayList <Integer> tab,int taille ,int  pPossi) {

		for(int i = 0;i <taille; i++) {
			tab.set( i,(int)( Math.random()*(pPossi) ));
		}	
	}

	static void codeAleaInit(ArrayList <Integer> tab,int taille ,int  pPossi) {

		for(int i = 0;i <taille; i++) {
			tab.add( (int)( Math.random()*(pPossi) ));
		}	
	}



}
