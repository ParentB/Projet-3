import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean fin = false ;
		ArrayList <Integer> tab = new ArrayList <Integer>() ;
		int taille = 4;
		
		
		Mastermind master = new Mastermind();
		
		tab.add(1);
		tab.add(1);
		tab.add(1);
		tab.add(1);
		
		while(!fin ) {
			
			Main.Saisi(tab,taille);
			
			fin = master.setReponse(tab);
				
		}
		
	}
	
	
	
	
	
	static boolean Saisi (ArrayList <Integer> tab,int taille) {
		
		Scanner sc = new Scanner(System.in);
		String str ;
		do {
			
			System.out.println("\n\t Entrez votre réponse");
			str = sc.nextLine();
			
			if(str.length()!= taille)
				System.out.println("\n\t Mauvaise entrée");;
				
			
		}while(str.length() != taille);
		
		
		for(int i=0; i<taille;i++) {
			tab.set(i, (int)str.charAt(i)-48);
		}
		
      	 
		return true;
	}

}

