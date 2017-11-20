import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int choix = -1 , mode = 0 ,  tour = 10, taille = 4, possi = 4;
		boolean pAdmin = true;
		
		
		do {
		
			System.out.println("\n\t Bienvenue sur le Programme de jeux Master ");
			System.out.println("\n\t 1) Jouer au Masterplus ");
			System.out.println("\n\t 2) Jouer au Mastermind ");
			System.out.println("\n\t 0) quitter ");
			choix = Saisi(sc, choix, 2);
			
			switch(choix) {
			case 1 :
				mode = 10 ;
				break;
				
			case 2 :
				mode = 20;
				break;
				
			}
			while (choix != 0) {
				
				System.out.println("\n\t Choississez le mode de jeu ");
				System.out.println("\n\t 0) challenger ");
				System.out.println("\n\t 1) duel ");
				System.out.println("\n\t 2) defender ");
				choix = Saisi(sc, choix, 2);
				
				
				
				switch(choix) {
				case 0 :
					mode = mode + 1 ;
					break;
					
				case 1 :
					mode = mode + 2;
					break;
					
				case 2 :
					mode = mode + 3;
					break;
				}
				choix = 2 ;
				
				do {
					
					switch(mode) {
					
					case 11 :
						jMasterplus(sc ,taille, tour ,pAdmin);
						break;
						
					case 12 :
						jIaMasterplus(sc, taille, tour, pAdmin);
						break;
						
					case 13 :
						jIaMasterplusDef(sc, taille, tour, pAdmin);
						break;
						
					case 21 :
						jMastermind(sc,taille,possi,tour, pAdmin);
						
						break;
						
					case 22 :
						
						jIaMastermind(sc ,taille,tour,possi,pAdmin);
						
						break;
						
					case 23 :
						
						//jIaMastermind(sc ,taille,tour,possi,pAdmin);
						
						break;
					}
					
					System.out.println("\n\t Voulez vous rejouer ? ");
					System.out.println("\n\t 1) non ");
					System.out.println("\n\t 2) oui ");
					System.out.println("\n\t 0) quitter le programme ");
					choix = Saisi(sc, choix, 2);
					
				}while(choix == 2);
				
				
				
				
				
				
				
			}
			
			
			
			
		}while (choix != 0);
		sc.close();
		
		
	}
	
	
	
	
	
	static boolean SaisiRep (Scanner sc ,ArrayList <Integer> tab,int taille,int possi) {
		
		boolean verif = true;
		
		
		String str ;
		do {
			
			do {
				System.out.println("\n\t Entrez votre réponse");
				str = sc.nextLine();
				
				if(str.length()!= taille)
					System.out.println("\n\t Mauvaise entrée");
					
				
			}while(str.length() != taille );
			
			verif = false;
			for(int i=0; i<taille;i++) {
				tab.set(i, (int)str.charAt(i)-48);
				if(tab.get(i)<0 || tab.get(i) >= possi) {
					
					verif = true;
					
				}
			}
			
		}while(verif);
		
		
		return true;
		
	}
	
	
	
static int Saisi (Scanner  sc ,int  choix, int max ) {
	
	do {
		
		try {
	   		choix = sc.nextInt();
	   	  } catch (java.util.InputMismatchException e) {
	   	    choix = -1;
	   	  }
	   	  finally{
	  		 sc.nextLine();
	   	  }
		
	}while(choix < 0 || choix > max);
	 
		return choix;
		
	}

static void jMasterplus (Scanner sc ,int taille, int tour, boolean admin) {
	
	ArrayList <Integer> rep = new ArrayList <Integer>() ;
	
	for(int j = 0 ; j < taille ; j++) {
		rep.add(1);
	}
	
	int res = 0, i = 0;
	Masterplus master = new Masterplus (taille, admin);
	
	while (res !=1 && i <tour ) {
		
		System.out.println("\n\t tour restant :" + (tour - 1 - i));
		
		SaisiRep(sc,rep , taille, 10 );
		
		
		
		res=master.setReponse(rep);
		
		i = i+1;
		
		
	}
	
	if(res == 1) {
		
		System.out.println("\n\t Vous avez Gagné");
	}
	else {
		System.out.println("\n\t Vous avez perdu");
	}
	
}

static void jMastermind (Scanner sc ,int taille,int possi, int tour ,boolean admin) {
	
	ArrayList <Integer> rep = new ArrayList <Integer>() ;
	
	for(int j = 0 ; j < taille ; j++) {
		rep.add(1);
	}
	
	int res = 0, i = 0;
	Mastermind master = new Mastermind (taille, possi, admin);
	
	while (res !=1 && i <tour ) {
		
		System.out.println("\n\t tour restant :" + (tour - 1 - i));
		
		SaisiRep(sc,rep , taille, possi);
		
		
		
		res=master.setReponse(rep);
		
		i = i+1;
		
		
	}
	
	if(res == 1) {
		
		System.out.println("\n\t Vous avez Gagné");
	}
	else {
		System.out.println("\n\t Vous avez perdu");
	}
	
}

static void jIaMasterplus(Scanner sc ,int taille, int tour, boolean admin) {
	
	ArrayList <Integer> rep = new ArrayList <Integer>() ;
	
	for(int j = 0 ; j < taille ; j++) {
		rep.add(1);
	}
	
	int res = 0, i = 0;
	boolean resu = true;
	IaMasterplus master = new IaMasterplus (taille, admin);
	System.out.println("\n\t Entrez votre code :");
	
	SaisiRep (sc , rep , taille, 10);
	
	master.setCode(rep);
	
	while (resu && i <tour ) {
		
		System.out.println("\n\t tour restant :" + (tour - 1 - i));
		
		SaisiRep(sc,rep , taille, 10);
		
		
		
		res=master.setReponseIa(rep);
		
		i = i+1;
		
		if (res != 0)
			resu= false;
		
		
	}
	
	if(res == 1) {
		
		System.out.println("\n\t Egalité");
		resu = false ;
	}
	else if (res == 2) {
		System.out.println("\n\t Vous avez gagné");
		resu = false ;
	}
	else  {
		System.out.println("\n\t Vous avez perdu");
		resu = false ;
	}
}

static void jIaMastermind(Scanner sc ,int taille, int tour, int possi, boolean admin) {
	
	ArrayList <Integer> rep = new ArrayList <Integer>() ;
	
	for(int j = 0 ; j < taille ; j++) {
		rep.add(1);
	}
	
	int res = 0, i = 0;
	boolean resu = true;
	IaMastermind master = new IaMastermind (taille, possi, admin);
	System.out.println("\n\t Entrez votre code :");
	
	SaisiRep (sc , rep , taille, possi);
	
	master.setCode(rep);
	
	while (resu && i <tour ) {
		
		System.out.println("\n\t tour restant :" + (tour - 1 - i));
		
		SaisiRep(sc,rep , taille, possi);
		
		
		
		res=master.setReponseIa(rep);
		
		i = i+1;
		
		if (res != 0)
			resu= false;
		
		
	}
	
	if(res == 1 || res == 0) {
		
		System.out.println("\n\t Egalité");
		resu = false ;
	}
	else if (res == 2) {
		System.out.println("\n\t Vous avez gagné");
		resu = false ;
	}
	else  {
		System.out.println("\n\t Vous avez perdu");
		resu = false ;
	}
}

static void jIaMasterplusDef(Scanner sc ,int taille, int tour, boolean admin) {
	
	ArrayList <Integer> rep = new ArrayList <Integer>() ;
	
	for(int j = 0 ; j < taille ; j++) {
		rep.add(1);
	}
	
	int res = 0, i = 0;
	boolean resu = true;
	IaMasterplus master = new IaMasterplus (taille, admin);
	System.out.println("\n\t Entrez votre code :");
	
	SaisiRep (sc , rep , taille, 10);
	
	master.setCode(rep);
	
	while (resu && i <tour ) {
		
		System.out.println("\n\t tour restant :" + (tour - 1 - i));
		
		
		
		res=master.setReponseIaDef(rep);
		
		i = i+1;
		
		if (res != 0)
			resu= false;
		
		
	}
	
	if(res == 1) {
		
		System.out.println("\n\t Vous avez perdu");

	}
	else  {
		System.out.println("\n\t Vous avez gagné");
	}
}




}



