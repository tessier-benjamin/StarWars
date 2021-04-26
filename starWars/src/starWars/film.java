package starWars;

import java.io.Console;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class film {
	
	String titre;
	String annee_de_sortie;
	int numero_episode;
	int cout;
	int recette;
	ArrayList<acteur> duet;
	
	public film(boolean nouveauFilm) 
	{
		 if(nouveauFilm==true){
			 	System.out.println("[Nouveau film]");
	            Scanner scan = new Scanner(System.in);
	            System.out.println("-  titre du film : ");
	            String titreFilm = scan.nextLine();
	            this.titre = titreFilm;
	            System.out.println("-  ann�e du film : ");
	            String anneeDeSortieFilm = scan.next();
	            this.annee_de_sortie = anneeDeSortieFilm;
	            System.out.println("-  num�ro du film : ");
	            int numeroEpisodeFilm = scan.nextInt();
	            this.numero_episode = numeroEpisodeFilm;
	            System.out.println("-  co�t du film : ");
	            int coutFilm = scan.nextInt();
	            this.cout = coutFilm;
	            System.out.println("- recette du film : ");
	            int recetteFilm = scan.nextInt();
	            this.recette = recetteFilm;
	            this.duet = new ArrayList();
	            System.out.println("[Nouveau film enregistr�]");
	        }
	}
	
	   public film(String titre, String anneeDeSortie, int numeroEpisode, int cout, int recette) {
	        this.titre = titre;
	        this.annee_de_sortie = anneeDeSortie;
	        this.numero_episode = numeroEpisode;
	        this.cout = cout;
	        this.recette = recette;
	        this.duet = new ArrayList();
	    }
	
	public String getTitre()
	{
		return this.titre;
	}
	
	public String getAnneeSortie()
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
	
	public int getRecette()
	{
		return this.recette;
	}
	
	 public ArrayList<acteur> getDuet() 
	 { 
		 return this.duet; 
	 }

	
	void setTitre(String titre)
	{
		this.titre=titre;
	}
	
	void setAnneeSortie(String annee_de_sortie)
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
	
	void setRecette(int recette)
	{
		this.recette=recette;
	}
	
	public void setActeurs(ArrayList<acteur> acteurs) 
	{ 
		this.duet = acteurs; 
	}
	
	public String toString() 
	{
		return "Le film: "+this.titre+" est l'episode numero "+this.numero_episode+" est sortie en "+this.annee_de_sortie+" sa production � cout� "+this.cout+" et a produit une recette de "+this.recette;
	}
	
	public static void afficherTrilogie(Collection<film> Trilogie) {
		
		for(film Value : Trilogie) {
			System.out.println(Value);
		}
		
	}
	
	public int nbActeurs(Collection<acteur> duet) 
	{
		 return !this.duet.isEmpty() && this.duet.size()>0 ? this.duet.size() : 0 ;
	}
	
	public int nbPersonnages(Collection<personnage> duet) 
	{
		  int i = 0;
	        for(acteur acteur : this.duet){
	            i +=acteur.getNombrePersonnages();
	        }
	        return i;
	}
	
	  public ArrayList calculBenefice(){
	        double x = this.recette-this.cout;
	        ArrayList result = new ArrayList();
	        if(x >= 0){
	            result.add(true);
	            result.add(x);
	        } else {
	            result.add(false);
	            result.add(x);
	        }
	        return result;
	    }
	
	  public boolean isBefore(String anneeInserted) throws ParseException{
	        DateFormat format = new SimpleDateFormat("YYYY", Locale.FRANCE);
	        Date anneeDeSortieToDate = format.parse(this.annee_de_sortie);
	        Date anneeInsertedToDate = format.parse(anneeInserted);
	        return anneeDeSortieToDate.compareTo(anneeInsertedToDate) < 0;
	    }
	  
	  
	  public ArrayList tri(){
	        ArrayList<acteur> acteursTries = new ArrayList();
	        if(this.duet!=null && !this.duet.isEmpty() && this.duet.size()>0){
	            Collections.sort(this.duet, new Comparator<acteur>() {
	                @Override
	                public int compare(acteur acteur1, acteur acteur2){ return  acteur1.getNom().compareTo(acteur2.getNom()); }
	            });
	            acteursTries.addAll(this.duet);       
	        } else{
	            acteursTries = null;
	        }
	        return acteursTries;
	    }
	  
	public static void main(String[] arg) throws ParseException {
		
		 film filmA = new film("Star wars I","1977", 1, 1234123, 6443123);
		 film filmB = new film("Star wars II","1980", 2, 1234123, 6443123);
		 film filmC = new film("Star wars III","1983", 3, 1234123, 6443123);
		 ArrayList<film> films = new ArrayList();
	        films.add(filmA);
	        films.add(filmB);
	        films.add(filmC);
	        
	        int y = 1;
	        for(film film : films){
	        	System.out.println("[Film "+y+"]"+film.toString());
	            y++;
	        }
	        
	        personnage persoA = new personnage("Skywalker", "Anakin");
	        personnage persoB = new personnage("Skywalker", "Luke");
	        personnage persoC = new personnage("Skywalker", "Shmi");
	        personnage persoD = new personnage("Skywalker", "Ben");

	        
	        acteur acteur1 = new acteur("Ford", "Harrison");
	        acteur acteur2 = new acteur("Hamill", "Mark");
	        acteur acteur3 = new acteur("Fisher", "Carrie");
	        acteur acteur4 = new acteur("Guinness", "Alec");
	        
	        ArrayList<personnage> personnagesActeurA = new ArrayList(1);
	        personnagesActeurA.add(persoA);
	        personnagesActeurA.add(persoB);
	        acteur1.setDuetPersonnages(personnagesActeurA);
	        ArrayList<personnage> personnagesActeurB = new ArrayList(1);
	        personnagesActeurB.add(persoC);
	        personnagesActeurB.add(persoD);
	        acteur2.setDuetPersonnages(personnagesActeurB);
	        ArrayList<personnage> personnagesActeurC = new ArrayList(1);
	        personnagesActeurC.add(persoC);
	        personnagesActeurC.add(persoD);
	        acteur3.setDuetPersonnages(personnagesActeurC);
	        ArrayList<personnage> personnagesActeurD = new ArrayList(1);
	        personnagesActeurD.add(persoC);
	        personnagesActeurD.add(persoD);
	        acteur4.setDuetPersonnages(personnagesActeurD);
	        
	        ArrayList<acteur> acteursList1 = new ArrayList();
	        acteursList1.add(acteur1);
	        acteursList1.add(acteur2);
	        acteursList1.add(acteur3);
	        acteursList1.add(acteur4);
	        filmA.setActeurs(acteursList1);
	        System.out.println("\n"+filmA.toString());
	        
	        boolean isBefore = filmA.isBefore("2020");
	        System.out.println("\n isBefore : "+isBefore);
	        
	        System.out.println("\n"+filmA.getDuet());
	        filmA.tri();
	        System.out.println("\n"+filmA.getDuet());
	        
	        System.out.println("\nHashMap Dico");
	        HashMap<String,film> dicoFilms = new HashMap();
	        dicoFilms.put(filmA.getAnneeSortie(), filmA);
	        dicoFilms.put(filmB.getAnneeSortie(), filmB);
	        dicoFilms.put(filmC.getAnneeSortie(), filmC);
	        //dicoFilms.put(filmD.getAnneeDeSortie(), filmD);
	        
	        makeBackUp(dicoFilms);
	        
	    }
	    
	    public static void makeBackUp(HashMap dicoFilms){
	        Set dicoFilmsSetIterator = dicoFilms.entrySet();
	        Iterator dicoFilmsList = dicoFilmsSetIterator.iterator();
	        while(dicoFilmsList.hasNext()) {
	            Map.Entry film = (Map.Entry)dicoFilmsList.next();
	            String filmKey = (String) film.getKey();
	            film filmValue = (film) film.getValue();
	            String filmTitre = filmValue.getTitre();
	            String filmBenefice = filmValue.calculBenefice().get(1).toString();
	            System.out.println(""+filmKey+" - "+filmTitre+" - "+filmBenefice);
	        }
	    }
	
}
