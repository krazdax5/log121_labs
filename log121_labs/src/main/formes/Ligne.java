/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: Forme.java
Date créé: 2013-09-17
*******************************************************
Historique des modifications
*******************************************************
*@author Charles Levesque
2013-09-17 Version initiale
*******************************************************/ 
package main.formes;

import java.awt.*;

/**
 * Représente une ligne.
 */
public class Ligne extends Forme {
	private Point premiereCoordonnee = null;
	private Point secondeCoordonnee = null;
	private double longueur = -1;

	/**
	 * @return La première coordonnée
	 */
	public Point getPremiereCoordonnee() {
		return premiereCoordonnee;
	}

	/**
	 * @return La seconde coordonnée
	 */
	public Point getSecondeCoordonnee() {
		return secondeCoordonnee;
	}

	/**
	 * @return La longueur de la ligne
	 */
	public double getLongueur() {
		return longueur;
	}

    /**
     * @return l'aire de la ligne (carre autour)
     */
    public int getAire() {
        int aire = (int)((secondeCoordonnee.getX() - premiereCoordonnee.getX()) *
                (secondeCoordonnee.getY() - premiereCoordonnee.getY()));
        if(aire < 0)
            aire = aire *(-1);

        return aire;
    }


	/**
	 * Constructeur d'une ligne
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public Ligne(int x1, int y1, int x2, int y2, int numeroSequence){
		this.numeroSequence = numeroSequence;
		premiereCoordonnee = new Point(x1, y1);
		secondeCoordonnee = new Point(x2, y2);
		longueur = Math.sqrt(
					Math.pow((y1 > y2) ? y1 - y2 : y2 - y1, 2) +
					Math.pow((x1 > x2) ? x1 - x2 : x2 - x1, 2)
				); //Théorème de Pythagore
		type = Formes.LIGNE;
	}
}
