package test;

import main.formes.ListeFormes;
import main.formes.*;
import main.formes.util.ReplacerForme;
import java.awt.Point;


/**
 * Created with IntelliJ IDEA.
 * User: pierre-luclandry
 * Date: 2013-10-22
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
public class ReplacerFormeTest {

    private ListeFormes listeFormes;

    public void testForme(){

        ListeFormes listeFormes = new ListeFormes();
        Point p1 = new Point(0,0);
        Point p2 = new Point(40,40);
        Point p3 = new Point(80,80);
        Point p4 = new Point(120,120);
        Point p5 = new Point(160,160);






        listeFormes.ajouterForme(new Rectangle( 10, 20, 30, 40, 13 )); //carre
        listeFormes.ajouterForme(new Ovale( 10, 20, 30, 14 )); //cercle
        listeFormes.ajouterForme(new Ligne( 10, 20, 30, 40, 45 ));
        listeFormes.ajouterForme(new Rectangle( 30, 20, 50, 90, 12)); //rectangle
        listeFormes.ajouterForme(new Ovale( 40, 30, 10, 20, 34));

        ReplacerForme replaceForme = new ReplacerForme(listeFormes);

        listeFormes.premiere();
        assert listeFormes.getNoeudCourant().getForme().getPremiereCoordonnee() == p1;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getPremiereCoordonnee() == p2;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getPremiereCoordonnee() == p3;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getPremiereCoordonnee() == p4;
        listeFormes.suivant();
        assert listeFormes.getNoeudCourant().getForme().getPremiereCoordonnee() == p5;





    }




}
