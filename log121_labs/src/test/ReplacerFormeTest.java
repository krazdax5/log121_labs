package test;

import main.formes.*;
import main.formes.util.ReplacerForme;
import org.junit.Test;

import java.awt.Point;

public class ReplacerFormeTest {

    @Test
    public void testReplacerForme() throws Exception{
        ListeFormes listeFormes = new ListeFormes();
        Point p1 = new Point(0,0);
        Point p2 = new Point(40,40);
        Point p3 = new Point(80,80);
        Point p4 = new Point(120,120);
        Point p5 = new Point(160,160);

        listeFormes.ajouterForme(new main.formes.Rectangle(10, 20, 30, 40, 13)); //carre
        listeFormes.ajouterForme(new Ovale(10, 20, 30, 14)); //cercle
        listeFormes.ajouterForme(new Ligne(10, 20, 30, 40, 45));
        listeFormes.ajouterForme(new main.formes.Rectangle(30, 20, 50, 90, 12)); //rectangle
        listeFormes.ajouterForme(new Ovale(40, 30, 10, 20, 34));

        ReplacerForme replaceForme = new ReplacerForme(listeFormes);

        replaceForme.getListe().premiere();

        Rectangle rectangleTest = (Rectangle)replaceForme.getListe().getNoeudCourant().getForme();
        assert rectangleTest.getPremiereCoordonnee() == p1;
        replaceForme.getListe().suivant();

        Ovale ovaleTest = (Ovale)replaceForme.getListe().getNoeudCourant().getForme();
        assert ovaleTest.getCoordonneeCentre() == p2;
        replaceForme.getListe().suivant();

        Ligne ligneTest = (Ligne)replaceForme.getListe().getNoeudCourant().getForme();
        assert ligneTest.getPremiereCoordonnee() == p3;
        replaceForme.getListe().suivant();

        Rectangle rectangleTest2 = (Rectangle)replaceForme.getListe().getNoeudCourant().getForme();
        assert rectangleTest2.getPremiereCoordonnee() == p4;
        replaceForme.getListe().suivant();

        Ovale ovaleTest2 = (Ovale)replaceForme.getListe().getNoeudCourant().getForme();
        assert ovaleTest2.getCoordonneeCentre() == p5;
    }

}
