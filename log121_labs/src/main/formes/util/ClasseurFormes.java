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
 *******************************************************/
package main.formes.util;

import main.formes.*;
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

        // Initialisation à 0 du compteur qui sera utilise dans la boucle while
        int compteur = 0;

        while(compteur != listeFormes.length()+1) {

            // Pointe sur la premiere forme de la liste
            listeFormes.premiere();

            // Tri les elements de la liste
            for(int i = 0; i < listeFormes.length(); i++) {
                if(listeFormes.getNoeudCourrant().getSuivant() != null) {

                    int aire1 = listeFormes.getNoeudCourrant().getForme().getAire();
                    listeFormes.suivant();
                    int aire2 = listeFormes.getNoeudCourrant().getForme().getAire();;

                    listeFormes.precedent();

                    // Tri croissant
                    if(croissant) {
                        if(aire1 > aire2) {
                            listeFormes.inverser();
                        }
                    }
                    // Tri decroissant
                    else {
                        if(aire1 < aire2) {
                            listeFormes.inverser();
                        }
                    }

                }
                // Deplace le pointeur sur la forme suivante
                listeFormes.suivant();
            }
            // Incrementation du compteur de la boucle while
            compteur++;
        }

        // Affiche la liste ordonnee dans la console.
        listeFormes.premiere();
        for(int i = 0; i < listeFormes.length();i++) {
            System.out.println(listeFormes.getNoeudCourrant().getForme().getType() + " : " +
                    listeFormes.getNoeudCourrant().getForme().getAire());
            listeFormes.suivant();
        }
        System.out.println();

        // retourne la liste ordonnee
        return listeFormes;
    }

    /**
     * Méthode qui classe une liste de formes par sont type. En ordre, le carré, le rectangle, le cercle, l'ovale et la ligne. Inversement,
     * la ligne, l'ovale, le cercle, le rectangle et le carré.
     * @param inverse Si vrai, l'ordre inverse sera appliqué pour le classement.
     * @return Une copie ordonnée de la liste donnée en paramètre.
     */
    public void classerParType(boolean inverse){
        Forme[] tableauOrdonnee = new Forme[listeFormes.length()];

        for (int position = 0; position < tableauOrdonnee.length; position++){
            listeFormes.premiere();

            do{
                if (tableauOrdonnee[position] == null)
                    tableauOrdonnee[position] = listeFormes.getPosition().getForme();
                else
                    if (!inverse)
                        switch(listeFormes.getPosition().getForme().getType()){
                            case CARRE:
                                if (tableauOrdonnee[position].getType() != Formes.CARRE)
                                    tableauOrdonnee[position] = listeFormes.getPosition().getForme();
                                break;
                            case RECTANGLE:
                                if (tableauOrdonnee[position].getType() != Formes.CARRE &&
                                        tableauOrdonnee[position].getType() != Formes.RECTANGLE)
                                    tableauOrdonnee[position] = listeFormes.getPosition().getForme();
                                break;
                            case CERCLE:
                                if (tableauOrdonnee[position].getType() != Formes.CARRE &&
                                        tableauOrdonnee[position].getType() != Formes.RECTANGLE &&
                                        tableauOrdonnee[position].getType() != Formes.CERCLE)
                                    tableauOrdonnee[position] = listeFormes.getPosition().getForme();
                                break;
                            case OVALE:
                                if (tableauOrdonnee[position].getType() == Formes.LIGNE)
                                    tableauOrdonnee[position] = listeFormes.getPosition().getForme();
                                break;
                        }
                    else
                        switch (listeFormes.getPosition().getForme().getType()){
                           case LIGNE:
                               if (tableauOrdonnee[position].getType() != Formes.LIGNE)
                                   tableauOrdonnee[position] = listeFormes.getPosition().getForme();
                               break;
                           case OVALE:
                               if (tableauOrdonnee[position].getType() != Formes.LIGNE &&
                                       tableauOrdonnee[position].getType() != Formes.OVALE)
                                   tableauOrdonnee[position] = listeFormes.getPosition().getForme();
                               break;
                           case CERCLE:
                               if (tableauOrdonnee[position].getType() != Formes.LIGNE &&
                                       tableauOrdonnee[position].getType() != Formes.OVALE &&
                                       tableauOrdonnee[position].getType() != Formes.CERCLE)
                                   tableauOrdonnee[position] = listeFormes.getPosition().getForme();
                               break;
                           case RECTANGLE:
                               if (tableauOrdonnee[position].getType() == Formes.CARRE)
                                   tableauOrdonnee[position] = listeFormes.getPosition().getForme();
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
     * @return Une copie ordonnée de la liste donnée en paramètre.
     */
    public void classerParDistance(){
    }
}
