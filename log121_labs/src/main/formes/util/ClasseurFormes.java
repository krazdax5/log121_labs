/******************************************************
 Cours:  LOG121
 Projet: Squelette du laboratoire #1
 Nom du fichier: ClasseurFormes.java
 Date créé: 2013-10-11
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Charles Levesque
 *2013-10-11 Version initiale
 * 2013-10-14 Charles Levesque
 *******************************************************/
package main.formes.util;

import main.formes.Forme;
import main.formes.Formes;
import main.formes.ListeFormes;

/**
 * Classe responsable de classer les formes selon divers critères.
 */
public class ClasseurFormes {
    private ListeFormes listeFormes;

    public ListeFormes getListeFormes(){
        return listeFormes;
    }

    /**
     * Constructeur de base pour classer une liste de formes.
     * @param listeFormes La liste de formes.
     */
    public ClasseurFormes(ListeFormes listeFormes){
        this.listeFormes = listeFormes;
    }

    /**
     * Méthode qui classe une liste de forme par son numéro de séquence.
     * @param croissant Si vrai, ordonne la liste de formes en ordre croissant de numéro de séquence.
     * @return Une copie ordonnée de la liste donnée en paramètre.
     */
    public void classerParNumeroSequence(boolean croissant){
    }

    /**
     * Méthode qui classe une liste de forme par l'aire de sa surface.
     * @param croissant Si vrai, ordonne la liste en ordre croissant de grandeur d'aire.
     * @return Une copie ordonnée de la liste donnée en paramètre.
     */
    public void classerParAire(boolean croissant){
    }

    /**
     * Méthode qui classe une liste de formes par sont type. En ordre, le carré, le rectangle, le cercle, l'ovale et la ligne. Inversement,
     * la ligne, l'ovale, le cercle, le rectangle et le carré.
     * @param inverse Si vrai, l'ordre inverse sera appliqué pour le classement.
     * @return Une copie ordonnée de la liste donnée en paramètre.
     */
    public void classerParType(boolean inverse){

    }

    /**
     * Méthode qui classe une liste de formes par la distance la plus grande de sa diagonnale.
     * @return Une copie ordonnée de la liste donnée en paramètre.
     */
    public void classerParDistance(){
    }
}
