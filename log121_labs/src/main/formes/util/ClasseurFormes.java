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
 *******************************************************/
package main.formes.util;

import main.formes.Forme;

/**
 * Classe responsable de classer les formes selon divers critères.
 *
 * ***La classe n'est pas conçue pour être instancier.
 */
public class ClasseurFormes {
    public static Forme classerParNumeroSequence(Forme listeForme[], boolean croissant){
        Forme listeOrdonnee[] = {null, null, null, null, null, null, null, null, null, null};
        byte position = 0;

        for (Forme laForme: listeForme){
            if (laForme != null){
                if (listeOrdonnee[position] == null)
                    listeOrdonnee[position] = laForme;
            }
        }
    }
}
