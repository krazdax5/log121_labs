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

/**
 * Abstraction d'une forme géométrique.
 */
public abstract class AbstractForme {

	protected Formes type = Formes.INDETERMINE;
	protected int numeroSequence;
    protected int aire;
    protected double distance;
    protected int hauteur;
    protected int largeur;

	/**
	 * @return le numéro de séquence
	 */
	public int getNumeroSequence() {
		return numeroSequence;
	}

	/**
	 * @return Le type de forme.
	 */
	public Formes getType() {
		return type;
	}

    /**
     * Accesseur de l'aire de la forme
     * @return l'aire de la forme.
     */
    public int getAire() {
        return aire;
    }

    /**
     * Accesseur de la plus grande distance d'une forme
     * @return la plus grande distance de la forme.
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Accesseur de l'hauteur de la forme
     * @return  l'hauteur de la forme.
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * Accesseur de la largeur de la forme.
     * @return  la largeur de la forme.
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Vérifie si la forme envoye en paramètre est égale à la forme actuelle.
     * @param abstractFormeAVerifier    la forme que l'on desire comparee
     * @return  true/false dependemment du resultat de la comparaison.
     */
    public boolean estEgale(AbstractForme abstractFormeAVerifier) {
        return this.getType() == abstractFormeAVerifier.getType();
    }

}
