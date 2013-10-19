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
 * Représente une forme ronde.
 */
public class Ovale extends Forme {

	private Point coordonneeCentre = null;
	private int rayonHorizontal = -1;
	private int rayonVertical = -1;
    //private int aire;
	
	/**
	 * @return La coordonnée du centre de la forme ronde.
	 */
	public Point getCoordonneeCentre() {
		return coordonneeCentre;
	}

	/**
	 * @return Le rayon horizontal
	 */
	public int getRayonHorizontal() {
		return rayonHorizontal;
	}

	/**
	 * @return Le rayon vertical
	 */
	public int getRayonVertical() {
		return rayonVertical;
	}

    /**
     * @return l'aire de la forme ovale.
     */
    @Override
    public int getAire() {
        return aire;
    }

	/**
	 * Constructeur d'une forme ronde avec une coordonnée et deux rayons.
	 * @param x
	 * @param y
	 * @param rayonH Rayon horizontal
	 * @param rayonV Rayon vertical
	 */
	public Ovale(int x, int y, int rayonH, int rayonV, int numeroSequence){
		this.numeroSequence = numeroSequence;
		coordonneeCentre = new Point(x, y);
		rayonHorizontal = rayonH;
		rayonVertical = rayonV;
		type = Formes.OVALE;

        aire = rayonH*rayonV;
	}
	
	/**
	 * Constructeur d'un cercle avec une coordonnée et son rayon.
	 * @param x
	 * @param y
	 * @param rayon
	 */
	public Ovale(int x, int y, int rayon, int numeroSequence){
        this(x, y, rayon, rayon, numeroSequence);
		type = Formes.CERCLE;

        aire = rayon*rayon;
	}
}
