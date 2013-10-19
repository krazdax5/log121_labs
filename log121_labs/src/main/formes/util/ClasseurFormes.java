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

/**
 * Classe responsable de classer les formes selon divers critères.
 *
 * ***La classe n'est pas conçue pour être instancier.
 */
public class ClasseurFormes {


    /**
     * Méthode qui classe une liste de forme par son numéro de séquence.
     * @param listeFormes La liste de formes à ordonner.
     * @param croissant Si vrai, ordonne la liste de formes en ordre croissant de numéro de séquence.
     * @return Une copie ordonnée de la liste donnée en paramètre.
     */
    public static Forme[] classerParNumeroSequence(Forme[] listeFormes, boolean croissant){
        return null;
    }

    /**
     * Méthode qui classe une liste de forme par l'aire de sa surface.
     *
     * @param listeFormes La liste de formes à ordonner.
     * @param croissant Si vrai, ordonne la liste en ordre croissant de grandeur d'aire.
     * @return Une copie ordonnée de la liste donnée en paramètre.
     */
    public static ListeFormes classerParAire(ListeFormes listeFormes, boolean croissant){

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
     * @param listeFormes La liste à ordonner.
     * @param inverse Si vrai, l'ordre inverse sera appliqué pour le classement.
     * @return Une copie ordonnée de la liste donnée en paramètre.
     */
    public static Forme[] classerParType(Forme[] listeFormes, boolean inverse){
        Forme[] listeOrdonnee = new Forme[listeFormes.length];

        for (byte position = 0; position < listeOrdonnee.length; position++){
            for (Forme laForme : listeFormes){
                if (laForme == null)
                    continue;

                if (listeOrdonnee[position] == null)
                    listeOrdonnee[position] = laForme;
                else{
                    if (!inverse)
                        switch (laForme.getType()){
                            case CARRE:
                                if (listeOrdonnee[position].getType() != Formes.CARRE)
                                    listeOrdonnee[position] = laForme;
                                break;
                            case RECTANGLE:
                                if (listeOrdonnee[position].getType() != Formes.CARRE &&
                                        listeOrdonnee[position].getType() != Formes.RECTANGLE)
                                    listeOrdonnee[position] = laForme;
                                break;
                            case CERCLE:
                                if (listeOrdonnee[position].getType() != Formes.CARRE &&
                                        listeOrdonnee[position].getType() != Formes.RECTANGLE &&
                                        listeOrdonnee[position].getType() != Formes.CERCLE)
                                    listeOrdonnee[position] = laForme;
                                break;
                            case OVALE:
                                if (listeOrdonnee[position].getType() == Formes.LIGNE)
                                    listeOrdonnee[position] = laForme;
                                break;
                        }
                    else
                        switch (laForme.getType()){
                            case LIGNE:
                                if (listeOrdonnee[position].getType() != Formes.LIGNE)
                                    listeOrdonnee[position] = laForme;
                                break;
                            case OVALE:
                                if (listeOrdonnee[position].getType() != Formes.LIGNE &&
                                        listeOrdonnee[position].getType() != Formes.OVALE)
                                    listeOrdonnee[position] = laForme;
                                break;
                            case CERCLE:
                                if (listeOrdonnee[position].getType() != Formes.LIGNE &&
                                        listeOrdonnee[position].getType() != Formes.OVALE &&
                                        listeOrdonnee[position].getType() != Formes.CERCLE)
                                    listeOrdonnee[position] = laForme;
                                break;
                            case RECTANGLE:
                                if (listeOrdonnee[position].getType() == Formes.CARRE)
                                    listeOrdonnee[position] = laForme;
                                break;
                        }
                }
            }
            listeFormes = ClasseurFormes.supprimerFormeDeLaListe(listeOrdonnee[position], listeFormes);
        }
        return listeOrdonnee;
    }

    /**
     * Méthode qui classe une liste de formes par la distance la plus grande de sa diagonnale.
     * @param listeFormes La liste de formes à ordonner.
     * @return Une copie ordonnée de la liste donnée en paramètre.
     */
    public static Forme[] classerParDistance(Forme[] listeFormes){
        return null;
    }

    /**
     * Méthode d'aide qui supprime une forme d'une liste.
     * @param formeASupprimer La forme à retirer de la liste.
     * @param listeFormes La liste de laquelle retirer la forme.
     * @precondition formeASupprimer != null
     * @return Une copie mise à jour de la liste passée en paramètre.
     */
    public static Forme[] supprimerFormeDeLaListe(Forme formeASupprimer, Forme[] listeFormes){
        for (byte position = 0; position < listeFormes.length; position++){
            if (listeFormes[position] != null)
                if (listeFormes[position].getNumeroSequence() == formeASupprimer.getNumeroSequence()){
                    listeFormes[position] = null;
                    break;
                }
        }
        return listeFormes;
    }
}
