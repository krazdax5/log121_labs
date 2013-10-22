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
package main.formes.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe analyseuse de trame
 */
public class AnalyseurTrame {
	private final String REGEX_TRAME = "([0-9]+[\\s]?)<(CARRE|RECTANGLE|CERCLE|OVALE|LIGNE)>(.+?)</(CARRE|RECTANGLE|CERCLE|OVALE|LIGNE)>";
	private final String REGEX_RECTANGLE = "([\\s]?[0-9]+) ([0-9]+) ([0-9]+) ([0-9]+[\\s]?)";
	private final String REGEX_OVALE = "([\\s]?[0-9]+) ([0-9]+) ([0-9]+)([\\s][0-9]+)?[\\s]?";
	private String typeForme = "INDETERMINE";
	private int coordonneeX1, coordonneeY1, coordonneeX2, coordonneeY2, centreX, centreY, rayonH, rayonV, rayon, numeroSequence;
	
	/**
	 * @return Le type de forme
	 */
	public String getTypeForme() {
		return typeForme;
	}

	/**
	 * @return coordonneeX1
	 */
	public int getCoordonneeX1() {
		return coordonneeX1;
	}

	/**
	 * @return coordonneeY1
	 */
	public int getCoordonneeY1() {
		return coordonneeY1;
	}

	/**
	 * @return coordonneeX2
	 */
	public int getCoordonneeX2() {
		return coordonneeX2;
	}

	/**
	 * @return coordonneeY2
	 */
	public int getCoordonneeY2() {
		return coordonneeY2;
	}

	/**
	 * @return Le centre x de la forme circulaire
	 */
	public int getCentreX() {
		return centreX;
	}

	/**
	 * @return Le centre y de la forme circulaire
	 */
	public int getCentreY() {
		return centreY;
	}

	/**
	 * @return le rayon horizontal
	 */
	public int getRayonH() {
		return rayonH;
	}

	/**
	 * @return le rayon vertical
	 */
	public int getRayonV() {
		return rayonV;
	}

	/**
	 * @return le rayon
	 */
	public int getRayon() {
		return rayon;
	}

	/**
	 * @return le numéro de séquence
	 */
	public int getNumeroSequence() {
		return numeroSequence;
	}

	/**
	 * Constructeur de l'analyseur.
	 * @param trame la trame du serveur
	 */
	public AnalyseurTrame(String trame){
		Pattern tramePattern = Pattern.compile(REGEX_TRAME);
		Matcher trameMatcher = tramePattern.matcher(trame);
		
		if(trameMatcher.find()){
			String nomTag = trameMatcher.group(2);
			numeroSequence = Integer.parseInt(trameMatcher.group(1).trim());
			Pattern coordinatePattern;
			Matcher coordinateMatcher;
			
			if (nomTag.equals("CARRE") || nomTag.equals("RECTANGLE") || nomTag.equals("LIGNE")){
				coordinatePattern = Pattern.compile(REGEX_RECTANGLE);
				coordinateMatcher = coordinatePattern.matcher(trameMatcher.group(3).trim());
				
				if (coordinateMatcher.find()){
					coordonneeX1 = Integer.parseInt(coordinateMatcher.group(1).trim());
					coordonneeY1 = Integer.parseInt(coordinateMatcher.group(2).trim());
					coordonneeX2 = Integer.parseInt(coordinateMatcher.group(3).trim());
					coordonneeY2 = Integer.parseInt(coordinateMatcher.group(4).trim());
					typeForme = nomTag;
				}
			} else if (nomTag.equals("CERCLE") || nomTag.equals("OVALE")){
				coordinatePattern = Pattern.compile(REGEX_OVALE);
				coordinateMatcher = coordinatePattern.matcher(trameMatcher.group(3).trim());
				
				if (coordinateMatcher.find()){
					centreX = Integer.parseInt(coordinateMatcher.group(1).trim());
					centreY = Integer.parseInt(coordinateMatcher.group(2).trim());
					
					if (coordinateMatcher.group(4) == null){
						rayon = Integer.parseInt(coordinateMatcher.group(3).trim());
					} else {
						rayonH = Integer.parseInt(coordinateMatcher.group(3).trim());
						rayonV = Integer.parseInt(coordinateMatcher.group(4).trim());
					}
					typeForme = nomTag;
				}
			}
		}
	}
}
