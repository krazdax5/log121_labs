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
     * @param listeFormes La liste de formes à ordonner.
     * @param croissant Si vrai, ordonne la liste en ordre croissant de grandeur d'aire.
     * @return Une copie ordonnée de la liste donnée en paramètre.
     */
    public static Forme[] classerParAire(Forme[] listeFormes, boolean croissant){
        return null;
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
