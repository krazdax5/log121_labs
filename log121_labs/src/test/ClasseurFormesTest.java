package test;

import org.junit.Test;
import main.formes.*;
import main.formes.util.ClasseurFormes;

/**
 * @author Charles Levesque
 * Date: 2013-10-14
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

        classeur.classerParNumeroSequenceCroissante();
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

        classeur.classerParNumeroSequenceDecroissante();
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
    }

    @Test
    public void testClasserParType() throws Exception {
        ListeFormes listeFormes = new ListeFormes();
        ClasseurFormes classeur;

        listeFormes.ajouterForme(new Rectangle( 10, 20, 30, 40, 13 )); //carre
        listeFormes.ajouterForme(new Ovale( 10, 20, 30, 14 )); //cercle
        listeFormes.ajouterForme(new Ligne( 10, 20, 30, 40, 45 ));
        listeFormes.ajouterForme(new Rectangle( 30, 20, 50, 90, 12)); //rectangle
        listeFormes.ajouterForme(new Ovale( 40, 30, 10, 20, 34));

        classeur = new ClasseurFormes(listeFormes);

        classeur.classerParType(false);
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
        listeFormes.premiere();
        assert listeFormes.getNoeudCourant().getForme().getType() == Formes.LIGNE && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 45;
        assert listeFormes.getNoeudCourant().getForme().getType() == Formes.OVALE && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 34;
        assert listeFormes.getNoeudCourant().getForme().getType() == Formes.CERCLE && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 14;
        assert listeFormes.getNoeudCourant().getForme().getType() == Formes.RECTANGLE && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 12;
        assert listeFormes.getNoeudCourant().getForme().getType() == Formes.CARRE && listeFormes.getNoeudCourant().getForme().getNumeroSequence() == 13;
    }

    @Test
    public void testClasserParDistance() throws Exception {

    }
}
