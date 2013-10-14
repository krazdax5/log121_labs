package test;

import org.junit.Test;
import main.formes.*;
import main.formes.util.ClasseurFormes;

/**
 * Created with IntelliJ IDEA.
 * User: charleslevesque
 * Date: 2013-10-14
 * Time: 17:36
 * To change this template use File | Settings | File Templates.
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
        Forme[] listeFormes = {
                new Rectangle( 10, 20, 30, 40, 13 ), //carre
                new Ovale( 10, 20, 30, 14 ), //cercle
                new Ligne( 10, 20, 30, 40, 45 ),
                new Rectangle( 30, 20, 50, 90, 12), //rectangle
                new Ovale( 40, 30, 10, 20, 34) //ovale
        };

        Forme[] listeOrdonneeDroite = ClasseurFormes.classerParType(listeFormes.clone(), false);
        assert listeOrdonneeDroite[0].getType() == Formes.CARRE && listeOrdonneeDroite[0].getNumeroSequence() == 13;
        assert listeOrdonneeDroite[1].getType() == Formes.RECTANGLE && listeOrdonneeDroite[1].getNumeroSequence() == 12;
        assert listeOrdonneeDroite[2].getType() == Formes.CERCLE && listeOrdonneeDroite[2].getNumeroSequence() == 14;
        assert listeOrdonneeDroite[3].getType() == Formes.OVALE && listeOrdonneeDroite[3].getNumeroSequence() == 34;
        assert listeOrdonneeDroite[4].getType() == Formes.LIGNE && listeOrdonneeDroite[4].getNumeroSequence() == 45;

        Forme[] listeOrdonneeInverse = ClasseurFormes.classerParType(listeFormes.clone(), true);
        assert listeOrdonneeInverse[0].getType() == Formes.LIGNE && listeOrdonneeInverse[0].getNumeroSequence() == 45;
        assert listeOrdonneeInverse[1].getType() == Formes.OVALE && listeOrdonneeInverse[1].getNumeroSequence() == 34;
        assert listeOrdonneeInverse[2].getType() == Formes.CERCLE && listeOrdonneeInverse[2].getNumeroSequence() == 14;
        assert listeOrdonneeInverse[3].getType() == Formes.RECTANGLE && listeOrdonneeInverse[3].getNumeroSequence() == 12;
        assert listeOrdonneeInverse[4].getType() == Formes.CARRE && listeOrdonneeInverse[4].getNumeroSequence() == 13;
    }

    @Test
    public void testClasserParDistance() throws Exception {

    }

    @Test
    public void testSupprimerFormeDeLaListe() throws Exception {
        Forme formeASupprimer = new Rectangle( 10, 20, 30, 40, 13 );
        Forme[] listeFormes = {
                new Rectangle( 10, 20, 30, 40, 13 ),
                new Ovale( 10, 20, 30, 14 ),
                new Ligne( 10, 20, 30, 40, 45 )
        };
        listeFormes = ClasseurFormes.supprimerFormeDeLaListe(formeASupprimer, listeFormes);

        assert listeFormes[0] == null;
    }
}
