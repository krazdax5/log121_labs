package test;

import main.formes.*;
import main.formes.util.ReplacerFormes;
import org.junit.Test;

import java.awt.Point;

public class ReplacerFormesTest {

    @Test
    public void testReplacerForme() throws Exception{
        ListeFormes listeFormes = new ListeFormes();
        Point carrePoint1 = new Point(0,0);
        Point cerclePoint1 = new Point(70,70);
        Point lignePoint1 = new Point(80,80);
        Point rectanglePoint1 = new Point(120,120);
        Point ovalePoint1 = new Point(170,180);

        listeFormes.ajouterForme(new main.formes.Rectangle(10, 20, 30, 40, 13)); //carre
        listeFormes.ajouterForme(new Ovale(10, 20, 30, 14)); //cercle
        listeFormes.ajouterForme(new Ligne(10, 20, 30, 40, 45));//ligne
        listeFormes.ajouterForme(new main.formes.Rectangle(30, 20, 50, 90, 12)); //rectangle
        listeFormes.ajouterForme(new Ovale(40, 30, 10, 20, 34));//ovale

        ReplacerFormes replaceForme = new ReplacerFormes(listeFormes);

        replaceForme.getListe().premiere();

        Rectangle carreTest = (Rectangle)replaceForme.getListe().getNoeudCourant().getForme();
        assert carreTest.getPremiereCoordonnee().equals(carrePoint1);
        replaceForme.getListe().suivant();

        Ovale cercleTest = (Ovale)replaceForme.getListe().getNoeudCourant().getForme();
        assert cercleTest.getCoordonneeCentre().getX() == cerclePoint1.getX();
        assert cercleTest.getCoordonneeCentre().getY() == cerclePoint1.getY();
        replaceForme.getListe().suivant();

        Ligne ligneTest = (Ligne)replaceForme.getListe().getNoeudCourant().getForme();
        assert ligneTest.getPremiereCoordonnee().getX() == lignePoint1.getX();
        assert ligneTest.getPremiereCoordonnee().getY() == lignePoint1.getY();
        replaceForme.getListe().suivant();

        Rectangle rectangleTest = (Rectangle)replaceForme.getListe().getNoeudCourant().getForme();
        assert rectangleTest.getPremiereCoordonnee().getX() == rectanglePoint1.getX();
        assert rectangleTest.getPremiereCoordonnee().getY() == rectanglePoint1.getY();
        replaceForme.getListe().suivant();

        Ovale ovaleTest = (Ovale)replaceForme.getListe().getNoeudCourant().getForme();
        assert ovaleTest.getCoordonneeCentre().getX() == ovalePoint1.getX();
        assert ovaleTest.getCoordonneeCentre().getY() == ovalePoint1.getY();
    }

}
