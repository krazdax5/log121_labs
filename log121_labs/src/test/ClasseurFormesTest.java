package test;

import org.junit.Test;
import main.formes.*;
import main.formes.util.ClasseurFormes;

/**
 * @author Charles Levesque
 * Date: 2013-10-14
 * @author Mathieu Lachance
 * Date: 2013-10-22 Ajout des test pour triAire et triDistance
 */
public class ClasseurFormesTest {
    @Test
    public void testClasserParNumeroSequence() throws Exception {
        ListeFormes listeFormes = new ListeFormes();
        ClasseurFormes classeur;

        listeFormes.ajouterForme(new Rectangle( 10, 20, 30, 40, 13 )); //carre
        listeFormes.ajouterForme(new Ovale( 10, 20, 30, 14 )); //cercle
        listeFormes.ajouterForme(new Ligne( 10, 20, 30, 40, 45 ));
        listeFormes.ajouterForme(new Rectangle( 30, 20, 50, 90, 12)); //rectangle
        listeFormes.ajouterForme(new Ovale( 40, 30, 10, 20, 34));

        classeur = new ClasseurFormes(listeFormes);

        boolean croissant = true;

        classeur.classerParNumeroSequence(croissant);
        listeFormes = classeur.getListeFormes();
        listeFormes.premiere();
        assert listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 12;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 13;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 14;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 34;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 45;

        classeur.classerParNumeroSequence(!croissant);
        listeFormes = classeur.getListeFormes();
        listeFormes.premiere();
        assert listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 45;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 34;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 14;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 13;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 12;


    }



    @Test
    public void testClasserParAire() throws Exception {

        ListeFormes listeFormes = new ListeFormes();
        ClasseurFormes classeur;

        listeFormes.ajouterForme(new Rectangle( 10, 20, 30, 50, 13 )); //carre
        listeFormes.ajouterForme(new Ovale( 10, 20, 30, 14 )); //cercle a=3600
        listeFormes.ajouterForme(new Ligne( 10, 20, 30, 40, 45 )); // ligne
        listeFormes.ajouterForme(new Rectangle( 30, 20, 50, 90, 12)); //rectangle
        listeFormes.ajouterForme(new Ovale( 40, 30, 10, 20, 34)); // ovale a=800

        classeur = new ClasseurFormes(listeFormes);
        listeFormes = classeur.getListeFormes();

        classeur.classerParAire(true);
        listeFormes.premiere();
        assert listeFormes.getNoeudCourant().getForme().getAire() == (int)Math.sqrt(20*20+20*20) && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 45;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getAire() == 600 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 13;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getAire() == (int)(Math.PI*20*10) && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 34;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getAire() == 1400 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 12;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getAire() == (int)(Math.PI*30*30) && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 14;


        classeur.classerParAire(false);
        listeFormes.premiere();
        assert listeFormes.getNoeudCourant().getForme().getAire() == (int)(Math.PI*30*30) && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 14;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getAire() == 1400 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 12;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getAire() == (int)(Math.PI*20*10) && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 34;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getAire() == 600 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 13;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getAire() == (int)Math.sqrt(20*20+20*20) && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 45;
    }

    @Test
    public void testClasserParType() throws Exception {
        ListeFormes listeFormes = new ListeFormes();
        ClasseurFormes classeur;

        listeFormes.ajouterForme(new Rectangle( 10, 20, 30, 40, 13 )); //carre
        listeFormes.ajouterForme(new Ovale( 10, 20, 30, 14 )); //cercle
        listeFormes.ajouterForme(new Ligne( 10, 20, 30, 40, 45 )); // ligne
        listeFormes.ajouterForme(new Rectangle( 30, 20, 50, 90, 12)); //rectangle
        listeFormes.ajouterForme(new Ovale( 40, 30, 10, 20, 34)); //ovale

        classeur = new ClasseurFormes(listeFormes);

        classeur.classerParType(false);
        listeFormes = classeur.getListeFormes();
        listeFormes.premiere();
        assert listeFormes.getNoeudCourant().getForme().getType() == Formes.CARRE && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 13;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getType() == Formes.RECTANGLE && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 12;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getType() == Formes.CERCLE && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 14;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getType() == Formes.OVALE && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 34;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getType() == Formes.LIGNE && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 45;

        classeur.classerParType(true);
        listeFormes = classeur.getListeFormes();
        listeFormes.premiere();
        assert listeFormes.getNoeudCourant().getForme().getType() == Formes.LIGNE && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 45;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getType() == Formes.OVALE && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 34;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getType() == Formes.CERCLE && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 14;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getType() == Formes.RECTANGLE && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 12;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getType() == Formes.CARRE && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 13;
    }

    @Test
    public void testClasserParDistance() throws Exception {
        ListeFormes listeFormes = new ListeFormes();
        ClasseurFormes classeur;

        listeFormes.ajouterForme(new Rectangle( 10, 20, 30, 50, 13 )); //carre
        listeFormes.ajouterForme(new Ovale( 10, 20, 30, 14 )); //cercle d=60
        listeFormes.ajouterForme(new Ligne( 10, 20, 30, 40, 45 )); // ligne
        listeFormes.ajouterForme(new Rectangle( 30, 20, 50, 90, 12)); //rectangle
        listeFormes.ajouterForme(new Ovale( 40, 30, 10, 20, 34)); // ovale d=40

        classeur = new ClasseurFormes(listeFormes);

        classeur.classerParDistance(true);
        listeFormes.premiere();
        assert listeFormes.getNoeudCourant().getForme().getDistance() == Math.sqrt(20*20+20*20) && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 45;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getDistance() == Math.sqrt(20*20+30*30) && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 13;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getDistance() == 40 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 34;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getDistance() == 60 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 14;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getDistance() == Math.sqrt(20*20+70*70) && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 12;

        classeur.classerParDistance(false);
        listeFormes.premiere();
        assert listeFormes.getNoeudCourant().getForme().getDistance() == Math.sqrt(20*20+70*70) && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 12;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getDistance() == 60 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 14;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getDistance() == 40 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 34;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getDistance() == Math.sqrt(20*20+30*30) && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 13;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getDistance() == Math.sqrt(20*20+20*20) && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 45;
    }


    @Test
    public void testClasserParHauteur() throws Exception {
        ListeFormes listeFormes = new ListeFormes();
        ClasseurFormes classeur;

        listeFormes.ajouterForme(new Rectangle( 10, 20, 30, 50, 13 )); //carre h=30
        listeFormes.ajouterForme(new Ovale( 10, 20, 30, 14 )); //cercle h=60
        listeFormes.ajouterForme(new Ligne( 10, 20, 30, 40, 45 )); // ligne h=20
        listeFormes.ajouterForme(new Rectangle( 30, 20, 50, 90, 12)); //rectangle h=70
        listeFormes.ajouterForme(new Ovale( 40, 30, 10, 20, 34)); // ovale h =40

        classeur = new ClasseurFormes(listeFormes);
        listeFormes = classeur.getListeFormes();

        classeur.classerParHauteur(true);
        listeFormes.premiere();
        assert listeFormes.getNoeudCourant().getForme().getHauteur() == 20 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 45;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getHauteur() == 30 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 13;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getHauteur() == 40 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 34;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getHauteur() == 60 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 14;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getHauteur() == 70 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 12;

        classeur.classerParHauteur(false);
        listeFormes.premiere();
        assert listeFormes.getNoeudCourant().getForme().getHauteur() == 70 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 12;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getHauteur() == 60 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 14;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getHauteur() == 40 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 34;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getHauteur() == 30 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 13;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getHauteur() == 20 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 45;
    }

    @Test
    public void testClasserParLargeur() throws Exception {
        ListeFormes listeFormes = new ListeFormes();
        ClasseurFormes classeur;

        listeFormes.ajouterForme(new Rectangle( 15, 20, 30, 50, 13 )); //carre h=15
        listeFormes.ajouterForme(new Ovale( 10, 20, 30, 14 )); //cercle h=60
        listeFormes.ajouterForme(new Ligne( 5, 20, 30, 40, 45 )); // ligne h=25
        listeFormes.ajouterForme(new Rectangle( 20, 20, 50, 90, 12)); //rectangle l=30
        listeFormes.ajouterForme(new Ovale( 40, 30, 10, 20, 34)); // ovale l=20

        classeur = new ClasseurFormes(listeFormes);
        listeFormes = classeur.getListeFormes();

        classeur.classerParLargeur(true);
        listeFormes.premiere();
        assert listeFormes.getNoeudCourant().getForme().getLargeur() == 15 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 13;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getLargeur() == 20 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 34;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getLargeur() == 25 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 45;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getLargeur() == 30 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 12;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getLargeur() == 60 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 14;

        classeur.classerParLargeur(false);
        listeFormes.premiere();
        assert listeFormes.getNoeudCourant().getForme().getLargeur() == 60 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 14;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getLargeur() == 30 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 12;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getLargeur() == 25 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 45;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getLargeur() == 20 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 34;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getLargeur() == 15 && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 13;
    }
}
