/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: AbstractForme.java
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
 * Représentation d'un rectangle.
 */
public class Rectangle extends AbstractForme {
	private Point premiereCoordonnee = null;
	private Point secondeCoordonnee = null;
	private int width = -1;
	private int height = -1;
	
	/**
	 * @return La première coordonnée
	 */
	public Point getPremiereCoordonnee() {
		return premiereCoordonnee;
	}

    /**
     * instantie la valeur de la premiere coordonnee
     * @param premiereCoordonnee
     */
    public void setPremiereCoordonnee(Point premiereCoordonnee){
        this.premiereCoordonnee = premiereCoordonnee;
    }

	/**
	 * @return La seconde coordonnée
	 */
	public Point getSecondeCoordonnee() {
		return secondeCoordonnee;
	}

    /**
     * instantie la valeur de la deuxieme coordonnee
     * @param secondeCoordonnee
     */
    public void setSecondeCoordonnee(Point secondeCoordonnee){
        this.secondeCoordonnee = secondeCoordonnee;
    }

    /**
     * @return l'aire du rectangle
     */
    @Override
    public int getAire() {
        return aire;
    }

    /**
     * @return la plus grande distance du rectangle.
     */
    @Override
    public double getDistance() {
        return distance;
    }

    /**
     * @return La largeur
     */
    @Override
    public int getLargeur() {
        return width;
    }

    /**
     * @return La hauteur
     */
    @Override
    public int getHauteur() {
        return height;
    }

    /**
	 * Constructeur d'un rectangle avec 2 coordonnées.
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public Rectangle(int x1, int y1, int x2, int y2, int numeroSequence){
		this.numeroSequence = numeroSequence;
		premiereCoordonnee = new Point(x1, y1);
		secondeCoordonnee = new Point(x2, y2);
		width = (x1 > x2) ? x1 - x2 : x2 - x1;
		height = (y1 > y2) ? y1 - y2 : y2 - y1;

		if (width == height)
			this.type = Formes.CARRE;
		else
			this.type = Formes.RECTANGLE;

        aire = width*height;
        distance = Math.sqrt(width*width+height*height);
	}
}
