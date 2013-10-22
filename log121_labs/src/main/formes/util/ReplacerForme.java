package main.formes.util;
import java.awt.Point;

import main.formes.Forme;
import main.formes.Formes;
import main.formes.ListeFormes;


/**
 * Classe qui permet de repositionner les formes au bon endroit dans la fenetre
 * @author Pierre-Luc Landry
 * 2013/10/16 Version Initiale
 *
 */
public class ReplacerForme  {
	

	final int DISTANCE = 40;
	private Point p1,p2,pCentre;
	private ListeFormes liste;
	
	
	/**
	 * Constructeur qui permet de travailler avec la liste original de formes
	 * @param liste Liste de formes original 
	 */
	public ReplacerForme(ListeFormes liste){
		liste = new ListeFormes();
		this.liste = liste;
        nouvellesCoordonnees();
	}
	
	
	/**
	 * Méthode qui permet de changer les coordonnees de la forme
	 * On change toutes les formes precentes dans la liste  a l'aide d'une boucle
	 *
	 */
	private void nouvellesCoordonnees(){
		
		liste.premiere();
		
		for(int i=0; i<=liste.length();i++){
			Forme forme = liste.getNoeudCourant().getForme();
				
			if(forme.getType()==Formes.CARRE ||forme.getType()==Formes.RECTANGLE )
				setCoordonnees(forme,DISTANCE*i, DISTANCE*i);
			
			else if(forme.getType()==Formes.CERCLE || forme.getType()==Formes.OVALE)
				setCoordonnees(forme,DISTANCE*i, DISTANCE*i);
			
			else if(forme.getType()==Formes.LIGNE)
				setCoordonnees(forme,DISTANCE*i,DISTANCE*i);
				
			liste.suivant();	
		}
		 
	}
	
	
	private void setCoordonnees(Forme forme, int x, int y){
		if(forme.getType()==Formes.CARRE||forme.getType()==Formes.RECTANGLE){
			p1.setLocation(x, y);
			forme.setPremiereCoordonnee(p1);
		}
		
		else if(forme.getType()==Formes.CERCLE || forme.getType()==Formes.OVALE){
			pCentre.setLocation(x+forme.getRayonHorizontal(), y+forme.getRayonVertical());
		}
		
		else if(forme.getType()==Formes.LIGNE){
			
			if(x>forme.getDeuxiemeCoordonnee().x)
				p2.x = p2.x - x;
			else
				p2.x = x-p2.x;
			
			if(y>forme.getDeuxiemeCoordonnee().y)
				p2.y = p2.y - y;
			else
				p2.y = y-p2.y;
				
			p1.setLocation(x, y);
			forme.setPremiereCoordonnee(p1);
			forme.setDeuxiemeCoordonnee(p2);
		}
	}	
}
