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

    public int getAire() {
        return 0;
    }

}
