import java.util.ArrayList;

public class Masterplus extends Master {
	
	protected boolean admin ;
	protected ArrayList <Integer> code = new ArrayList <Integer>() ;
	protected int taille ;
	protected int possi ;
	
	Masterplus(){
		admin=true;	
		taille =4;
		possi = 4;
		
		CodeAlea(code,taille, possi);
	}
	
	Masterplus(int pTaille, int pPossi){
		admin=true;	
		taille =pTaille;
		possi = pPossi;
		
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
	
	
	
	
public boolean setReponse (ArrayList <Integer> tab) {
	
	return SetRep(code,tab,taille,admin);
		
 
	}



}



