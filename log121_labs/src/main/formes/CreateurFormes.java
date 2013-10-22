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

import main.formes.util.AnalyseurTrame;

/**
 * Se charge de créer les formes pour l'affichage.
 */
public class CreateurFormes {
    /**
     * Crée une instance d'une forme à partir d'une trame.
     * @param trame Une trame du serveur de formes.
     * @return La forme correspondant à la trame, sinon null.
     */
	public static AbstractForme creerForme(String trame){
		AnalyseurTrame analyseur = new AnalyseurTrame(trame);
		String typeForme = analyseur.getTypeForme();
		
		if (typeForme.equals("CARRE") || typeForme.equals("RECTANGLE")){
			return new Rectangle(analyseur.getCoordonneeX1(), analyseur.getCoordonneeY1(), analyseur.getCoordonneeX2(), analyseur.getCoordonneeY2(), analyseur.getNumeroSequence());
		} else if (typeForme.equals("OVALE")){
			return new Ovale(analyseur.getCentreX(), analyseur.getCentreY(), analyseur.getRayonH(), analyseur.getRayonV(), analyseur.getNumeroSequence());
		} else if (typeForme.equals("CERCLE")){
			return new Ovale(analyseur.getCentreX(), analyseur.getCentreY(), analyseur.getRayon(), analyseur.getNumeroSequence());
		} else if (typeForme.equals("LIGNE")){
			return new Ligne(analyseur.getCoordonneeX1(), analyseur.getCoordonneeY1(), analyseur.getCoordonneeX2(), analyseur.getCoordonneeY2(), analyseur.getNumeroSequence());
		} else {
			return null;
		}
	}
}
