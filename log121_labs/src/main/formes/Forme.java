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

/**
 * Abstraction d'une forme géométrique.
 */
public abstract class Forme {

	protected Formes type = Formes.INDETERMINE;
	protected int numeroSequence;
    protected int aire;
    protected double distance;

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

    public boolean equals(Forme formeAVerifier) {
        return this.getType() == formeAVerifier.getType();
    }

}
