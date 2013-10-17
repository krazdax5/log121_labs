package main.triFormes;

import main.formes.ListeFormes;

/**
 * Classe qui gere le tri de formes selon l'aire des formes
 *
 * @author Mathieu Lachance
 * 2013-10-12 : Creation de la classe
 */
public class triAire {

    private ListeFormes liste;

    public triAire() {
        liste = null;
    }

    public triAire(ListeFormes liste) {
        this.liste = liste;
    }


    public ListeFormes trierCroissant() {

        liste.premiere();

        int compteur = 0;

        while(compteur != liste.length()+1) {

            for(int i = 0; i < liste.length(); i++) {
                if(liste.getPos().getSuivant() != null) {

                    if(liste.getForme(i).getAire() > liste.getForme(i+1).getAire()) {
                        liste.inverser();
                    }

                }
                liste.suivant();
            }
            compteur++;
        }



        return liste;
    }

    public ListeFormes trierDecroissant() {

        liste.premiere();

        int compteur = 0;

        while(compteur != liste.length()+1) {

            for(int i = 0; i < liste.length(); i++) {
                if(liste.getPos().getSuivant() != null) {

                    if(liste.getForme(i).getAire() > liste.getForme(i+1).getAire()) {
                        liste.inverser();
                    }

                }
                liste.suivant();
            }
            compteur++;
        }

        return liste;
    }


}
