package main.formes.util;
import java.awt.Point;

import main.formes.*;


/**
 * Classe qui permet de repositionner les formes au bon endroit dans la fenetre
 * @author Pierre-Luc Landry
 * 2013/10/16 Version Initiale
 *
 */
public class ReplaceurFormes {
	

	final int DISTANCE = 40;
    private ListeFormes liste;

    public ListeFormes getListe() {
        return liste;
    }
	
	
	/**
	 * Constructeur qui permet de travailler avec la liste original de formes
	 * @param liste Liste de formes original 
	 */
	public ReplaceurFormes(ListeFormes liste){
		this.liste = liste;
        nouvellesCoordonnees();
	}
	
	
	/**
	 * Méthode qui permet de changer les coordonnees de la forme
	 * On change toutes les formes precentes dans la liste  a l'aide d'une boucle
	 *
	 */
	private void nouvellesCoordonnees(){

        AbstractForme forme;
		liste.premiere();
		
		for(int i=0; i<liste.getLength();i++){
            forme = liste.getNoeudCourant().getForme();
			liste.getNoeudCourant().setForme(setCoordonnees(forme, DISTANCE*i, DISTANCE*i));
			liste.suivant();	
		}
		 
	}
	
	
	private AbstractForme setCoordonnees(AbstractForme forme, int x, int y){

        Point p1,pCentre;

		if(forme.getType()==Formes.CARRE||forme.getType()==Formes.RECTANGLE){
			p1 = new Point(x, y);
            Rectangle rectangle = (Rectangle) forme;
            rectangle.setPremiereCoordonnee(p1);
            rectangle.setSecondeCoordonnee(new Point(x+rectangle.getLargeur(),y+rectangle.getHauteur()));
            return rectangle;
		}
		else if(forme.getType()==Formes.CERCLE || forme.getType()==Formes.OVALE){

            Ovale ovale = (Ovale) forme;
			pCentre = new Point(x, y);
            ovale.setCoordonneeCentre(pCentre);
            return ovale;

		}
		else if(forme.getType()==Formes.LIGNE){
            Ligne ligne = (Ligne) forme;
			p1 = new Point(x, y);
			ligne.setPremiereCoordonnee(p1);
			ligne.setSecondeCoordonnee(new Point(p1.x + ligne.getLargeur(), p1.y + ligne.getHauteur()));
            return ligne;
		}
        return null;
	}	
}
