package starWars;

import java.util.Scanner;
import java.util.Collection;
import java.util.ArrayList;

public class film {
	
	String titre;
	int annee_de_sortie;
	int numero_episode;
	int cout;
	int recette;
	
	public film(String titre,int annee_de_sortie,int numero_episode,int cout,int recette) 
	{
		this.titre=titre;
		this.annee_de_sortie=annee_de_sortie;
		this.numero_episode=numero_episode;
		this.cout=cout;
		this.recette=recette;
	}
	
	public String getTitre()
	{
		return this.titre;
	}
	
	public int getAnneeSortie()
	{
		return this.annee_de_sortie;
	}
	
	public int getNumeroEpisode()
	{
		return this.numero_episode;
	}
	public int getCout()
	{
		return this.cout;
	}
	
	public int cout()
	{
		return this.recette;
	}
	
	void setTitre(String titre)
	{
		this.titre=titre;
	}
	
	void setAnneeSortie(int annee_de_sortie)
	{
		this.annee_de_sortie=annee_de_sortie;
	}
	
	void setNumeroEpisode(int numero_episode)
	{
		this.numero_episode=numero_episode;
	}
	void setCout(int cout)
	{
		this.cout=cout;
	}
	
	void setNote(int recette)
	{
		this.recette=recette;
	}
	
	public String toString() 
	{
		return "Le film: "+this.titre+" est l'episode numero "+this.numero_episode+" est sortie en "+this.annee_de_sortie+" sa production à couté "+this.cout+" et a produit une recette de "+this.recette;
	}
	
	public static void afficherTrilogie(Collection<film> Trilogie) {
		
		for(film Value : Trilogie) {
			System.out.println(Value);
		}
		
	}
	
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		acteur A1 = new acteur("Lucas","George");
		film F1 = new film("La Menace fantôme",1999,1,100000,300000);
		film F2 = new film("L'attaque des clones",2002,2,500000,560000);
		System.out.println(F1);
		System.out.println(F2);
		System.out.println("Saisir le titre : ");
		String titre = sc.nextLine();
		System.out.println("Saisir l'année : ");
		String annéeString = sc.nextLine();
		int annee = Integer.parseInt(annéeString);
		System.out.println("Saisir le numéro : ");
		String numéroString = sc.nextLine();
		int numero = Integer.parseInt(numéroString);
		System.out.println("Saisir le Coût : ");
		String CountString = sc.nextLine();
		int cout = Integer.parseInt(CountString);
		System.out.println("Saisir la recette : ");
		String RecetteString = sc.nextLine();
		int Recette = Integer.parseInt(RecetteString);
		film F3 = new film(titre,annee,numero,cout,Recette);
		System.out.println(F3);
		personnage P1 = new personnage("Skywalker","Luke");
		personnage P2 = new personnage("Vador","Dark");
		System.out.println(P1);
		Collection<film> Trilogie;
		Trilogie = new ArrayList<film>();
		Trilogie.add(F1);
		Trilogie.add(F2);
		Trilogie.add(F3);
		afficherTrilogie(Trilogie);
	}
	
}
