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
 * 2013-10-19 Mathieu Lachance : triAire fonctionnel
 * 2013-10-19 Mathieu Lachance : triDistance fonctionnel
 *******************************************************/
package main.formes.util;

import main.formes.*;
import main.formes.ListeFormes;

/**
 * Classe responsable de classer les formes selon divers critères.
 */
public class ClasseurFormes {
    private ListeFormes listeFormes;

    private boolean changementEffectuer = true;


    /**
     * Accesseur de la liste de formes.
     * @return La liste de formes.
     */
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
     */
    public void classerParNumeroSequence(boolean croissant){
    }

    /**
     * Méthode qui classe une liste de forme par l'aire de sa surface.
     * @param croissant Si vrai, ordonne la liste en ordre croissant de grandeur d'aire.
     */
    public void classerParAire(boolean croissant){

        // Initialisation à 0 du compteur qui sera utilise dans la boucle while
        int compteur = 0;

        while(compteur != listeFormes.length()+1) {

            listeFormes.premiere();

            for(int i = 0; i < listeFormes.length(); i++) {
                if(listeFormes.getNoeudCourant().getSuivant() != null) {

                    int aire1 = listeFormes.getNoeudCourant().getForme().getAire();
                    listeFormes.suivant();
                    int aire2 = listeFormes.getNoeudCourant().getForme().getAire();;

                    listeFormes.precedent();

                    if(croissant) {
                        if(aire1 > aire2) {
                            listeFormes.inverser();
                        }
                    }
                    else {
                        if(aire1 < aire2) {
                            listeFormes.inverser();
                        }
                    }

                }
                listeFormes.suivant();
            }
            compteur++;
        }
    }

    /**
     * Méthode qui classe une liste de formes par sont type. En ordre, le carré, le rectangle, le cercle, l'ovale et la ligne. Inversement,
     * la ligne, l'ovale, le cercle, le rectangle et le carré.
     * @param inverse Si vrai, l'ordre inverse sera appliqué pour le classement.
     */
    public void classerParType(boolean inverse){
        Forme[] tableauOrdonnee = new Forme[listeFormes.length()];

        for (int position = 0; position < tableauOrdonnee.length; position++){
            listeFormes.premiere();

            do{
                if (tableauOrdonnee[position] == null)
                    tableauOrdonnee[position] = listeFormes.getNoeudCourant().getForme();
                else
                    if (!inverse)
                        switch(listeFormes.getNoeudCourant().getForme().getType()){
                            case CARRE:
                                if (tableauOrdonnee[position].getType() != Formes.CARRE)
                                    tableauOrdonnee[position] = listeFormes.getNoeudCourant().getForme();
                                break;
                            case RECTANGLE:
                                if (tableauOrdonnee[position].getType() != Formes.CARRE &&
                                        tableauOrdonnee[position].getType() != Formes.RECTANGLE)
                                    tableauOrdonnee[position] = listeFormes.getNoeudCourant().getForme();
                                break;
                            case CERCLE:
                                if (tableauOrdonnee[position].getType() != Formes.CARRE &&
                                        tableauOrdonnee[position].getType() != Formes.RECTANGLE &&
                                        tableauOrdonnee[position].getType() != Formes.CERCLE)
                                    tableauOrdonnee[position] = listeFormes.getNoeudCourant().getForme();
                                break;
                            case OVALE:
                                if (tableauOrdonnee[position].getType() == Formes.LIGNE)
                                    tableauOrdonnee[position] = listeFormes.getNoeudCourant().getForme();
                                break;
                        }
                    else
                        switch (listeFormes.getNoeudCourant().getForme().getType()){
                           case LIGNE:
                               if (tableauOrdonnee[position].getType() != Formes.LIGNE)
                                   tableauOrdonnee[position] = listeFormes.getNoeudCourant().getForme();
                               break;
                           case OVALE:
                               if (tableauOrdonnee[position].getType() != Formes.LIGNE &&
                                       tableauOrdonnee[position].getType() != Formes.OVALE)
                                   tableauOrdonnee[position] = listeFormes.getNoeudCourant().getForme();
                               break;
                           case CERCLE:
                               if (tableauOrdonnee[position].getType() != Formes.LIGNE &&
                                       tableauOrdonnee[position].getType() != Formes.OVALE &&
                                       tableauOrdonnee[position].getType() != Formes.CERCLE)
                                   tableauOrdonnee[position] = listeFormes.getNoeudCourant().getForme();
                               break;
                           case RECTANGLE:
                               if (tableauOrdonnee[position].getType() == Formes.CARRE)
                                   tableauOrdonnee[position] = listeFormes.getNoeudCourant().getForme();
                               break;
                        }
            } while (listeFormes.suivant() != null);

            listeFormes.detruireForme(tableauOrdonnee[position]);
        }
        listeFormes = new ListeFormes();

        for (Forme laForme : tableauOrdonnee)
            listeFormes.ajouterForme(laForme);
    }

    /**
     * Méthode qui classe une liste de formes par la distance la plus grande de sa diagonnale.
     */
    public void classerParDistance(boolean croissant){

        // Initialisation à 0 du compteur qui sera utilise dans la boucle while
        int compteur = 0;

        while(compteur != listeFormes.length()+1) {

            listeFormes.premiere();

            for(int i = 0; i < listeFormes.length(); i++) {
                if(listeFormes.getNoeudCourant().getSuivant() != null) {

                    double distance1 = listeFormes.getNoeudCourant().getForme().getDistance();
                    listeFormes.suivant();
                    double distance2 = listeFormes.getNoeudCourant().getForme().getDistance();;

                    listeFormes.precedent();

                    if(croissant) {
                        if(distance1 > distance2) {
                            listeFormes.inverser();
                        }
                    }
                    else {
                        if(distance1 < distance2) {
                            listeFormes.inverser();
                        }
                    }

                }
                listeFormes.suivant();
            }
            compteur++;
        }
    }

    /**
     * Place en ordre croissant les formes dans la liste selon leurs numéros de séquences
     * @precondition Qu'il y ait au moins deux formes dans la liste
     * @return Une liste en ordre décroissante classé par rapport au numéro de séquence de chaque forme
     */
    public void classerParNumeroSequenceCroissante(){
        listeFormes.premiere();
        if(listeFormes.getNoeudCourant().getSuivant() != null){
            //Pour entrer dans la boucle si la fonction à déjà été appellé auparavant
            changementEffectuer = true;

            while(changementEffectuer){
                changementEffectuer = false;
                listeFormes.premiere();

                while(listeFormes.getNoeudCourant().getSuivant() != null){
                    if(listeFormes.getNoeudCourant().getForme().getNumeroSequence() > listeFormes.getNoeudCourant().getSuivant().getForme().getNumeroSequence()){
                        listeFormes.inverser();
                        changementEffectuer = true;
                    }
                    listeFormes.suivant();
                }
            }
        }
    }

    /**
     * Place en ordre décroissant les formes dans la liste selon leurs numéros de séquences
     * @precondition Qu'il y ait au moins deux formes dans la liste
     * @return Une liste en ordre décroissante classé par rapport au numéro de séquence de chaque forme
     */
    public void classerParNumeroSequenceDecroissante(){
        listeFormes.premiere();
        if(listeFormes.getNoeudCourant().getSuivant() != null){
            //Pour entrer dans la boucle si la fonction à déjà été appellé auparavant
            changementEffectuer = true;

            while(changementEffectuer){
                changementEffectuer = false;
                listeFormes.premiere();

                while(listeFormes.getNoeudCourant().getSuivant() != null){

                    if(listeFormes.getNoeudCourant().getForme().getNumeroSequence() < listeFormes.getNoeudCourant().getSuivant().getForme().getNumeroSequence()){
                        listeFormes.inverser();
                        changementEffectuer = true;
                    }
                    listeFormes.suivant();
                }
            }
        }
    }
}
