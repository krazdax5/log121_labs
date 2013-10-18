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
        assert listeFormes.getPosition().getForme().getType() == Formes.CARRE && listeFormes.getPosition().getForme().getNumeroSequence() == 13;
        listeFormes.suivant();
        assert listeFormes.getPosition().getForme().getType() == Formes.RECTANGLE && listeFormes.getPosition().getForme().getNumeroSequence() == 12;
        listeFormes.suivant();
        assert listeFormes.getPosition().getForme().getType() == Formes.CERCLE && listeFormes.getPosition().getForme().getNumeroSequence() == 14;
        listeFormes.suivant();
        assert listeFormes.getPosition().getForme().getType() == Formes.OVALE && listeFormes.getPosition().getForme().getNumeroSequence() == 34;
        listeFormes.suivant();
        assert listeFormes.getPosition().getForme().getType() == Formes.LIGNE && listeFormes.getPosition().getForme().getNumeroSequence() == 45;

        classeur.classerParType(true);
        listeFormes.premiere();
        assert listeFormes.getPosition().getForme().getType() == Formes.LIGNE && listeFormes.getPosition().getForme().getNumeroSequence() == 45;
        assert listeFormes.getPosition().getForme().getType() == Formes.OVALE && listeFormes.getPosition().getForme().getNumeroSequence() == 34;
        assert listeFormes.getPosition().getForme().getType() == Formes.CERCLE && listeFormes.getPosition().getForme().getNumeroSequence() == 14;
        assert listeFormes.getPosition().getForme().getType() == Formes.RECTANGLE && listeFormes.getPosition().getForme().getNumeroSequence() == 12;
        assert listeFormes.getPosition().getForme().getType() == Formes.CARRE && listeFormes.getPosition().getForme().getNumeroSequence() == 13;
    }

    @Test
    public void testClasserParDistance() throws Exception {

    }
}
