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


    public void trierCroissant() {

        liste.premiere();

        int compteur = 0;

        while(compteur != liste.length()+1) {

            for(int i = 0; i < liste.length(); i++) {
                if(liste.getPos().getSuivant() != null) {

                    int aire1 = liste.getForme(i).getAire();
                    int aire2 = liste.getForme(i+1).getAire();

                    if(aire1 < aire2) {
                        liste.inverser();
                    }

                }
                liste.suivant();
            }
            compteur++;
        }

        for(int i = 0; i < liste.length();i++) {
            System.out.println(liste.getForme(i).getType() + " : " + liste.getForme(i).getAire());
        }
        System.out.println();

    }

    public void trierDecroissant() {

        liste.premiere();

        //int compteur = 0;

        boolean sorted = true;

        //while(compteur != liste.length()+1) {
        for(int j = 0; j <= liste.length()+1; j++) {

            sorted = false;

            for(int i = 0; i < liste.length(); i++) {
                if(liste.getPos().getSuivant() != null) {

                    int aire1 = liste.getForme(i).getAire();
                    int aire2 = liste.getForme(i+1).getAire();

                    if(aire1 < aire2) {
                        liste.inverser();
                        sorted=true;
                    }

                }
                liste.suivant();
            }
            //compteur++;
        }

        for(int i = 0; i < liste.length();i++) {
            System.out.println(liste.getForme(i).getType() + " : " + liste.getForme(i).getAire());
        }
        System.out.println();
    }


}
