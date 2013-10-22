package main;
/******************************************************
 Cours:  LOG121
 Projet: Squelette du laboratoire #1
 Nom du fichier: FenetreFormes.java
 Date créé: 2013-05-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Patrice Boucher
2013-05-03 Version initiale
 *******************************************************/

import main.formes.*;

import main.formes.Rectangle;

import javax.swing.*;
import java.awt.*;
<<<<<<< HEAD
import java.awt.geom.RoundRectangle2D;
=======
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
>>>>>>> e6760c689fc87ef118f04888b42215d42216646f
import java.util.HashMap;
import java.util.Map;

/**
 * Cette fenêtre gère l'affichage des formes 
 * @author Patrice Boucher
<<<<<<< HEAD
 * @date 2013/05/04
 * 
 * Modification:
 * 1-Pierre-Luc Landry
 * @date 2013/10/17
 * 
 */
public class FenetreFormes extends JComponent{
	
	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(500,500);
	private Forme[] listeFormes;
	private Map<Formes, Color> colorDictionary;
	
	final static float dash1[] = {10.0f};
	final static BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f, dash1, 0.0f);
		
	/**
	 * Constructeur
	 */
	public FenetreFormes(){
		listeFormes = new Forme[10];
		colorDictionary = new HashMap<Formes, Color>();
		for (int pos = 0; pos < listeFormes.length; pos++)
			listeFormes[pos] = null;
		
		colorDictionary.put(Formes.CARRE, Color.BLACK);
		colorDictionary.put(Formes.CERCLE, Color.BLUE);
		colorDictionary.put(Formes.LIGNE, Color.CYAN);
		colorDictionary.put(Formes.OVALE, Color.DARK_GRAY);
		colorDictionary.put(Formes.RECTANGLE, Color.GREEN);
	}
	
	
	/*
	 * Affiche la liste de formes 
	 */
	public void paintComponent(Graphics g){
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for (int pos = 0; pos < listeFormes.length; pos++){
			if (listeFormes[pos] != null){
				Forme laForme = listeFormes[pos];
                g.setColor(colorDictionary.get(laForme.getType()));

				switch(laForme.getType()){
				case CARRE:
					Rectangle leCarre = (Rectangle) laForme;
					g.fillRect(leCarre.getPremiereCoordonnee().x, leCarre.getPremiereCoordonnee().y, leCarre.getWidth(), leCarre.getHeight());
					((Graphics2D)g).setStroke(dashed);
					g.drawRect(leCarre.getPremiereCoordonnee().x, leCarre.getPremiereCoordonnee().y, leCarre.getWidth(), leCarre.getHeight());
					break;
					
				case RECTANGLE:
					Rectangle leRectangle = (Rectangle) laForme;
					g.fillRect(leRectangle.getPremiereCoordonnee().x, leRectangle.getPremiereCoordonnee().y, leRectangle.getWidth(), leRectangle.getHeight());
					((Graphics2D)g).setStroke(dashed);
					g.drawRect(leRectangle.getPremiereCoordonnee().x, leRectangle.getPremiereCoordonnee().y, leRectangle.getWidth(), leRectangle.getHeight());
					break;
					
				case OVALE:
					Ovale lOvale = (Ovale) laForme;
					g.fillOval(lOvale.getCoordonneeCentre().x, lOvale.getCoordonneeCentre().y, lOvale.getRayonHorizontal() * 2, lOvale.getRayonVertical() * 2);
					((Graphics2D)g).setStroke(dashed);
					g.drawRect(lOvale.getCoordonneeCentre().x+lOvale.getRayonHorizontal(), lOvale.getCoordonneeCentre().y+lOvale.getRayonVertical(), lOvale.getRayonHorizontal() * 2, lOvale.getRayonVertical() * 2);
					break;
					
				case CERCLE:
					Ovale leCercle = (Ovale) laForme;
					g.fillOval(leCercle.getCoordonneeCentre().x, leCercle.getCoordonneeCentre().y, leCercle.getRayonHorizontal() * 2, leCercle.getRayonHorizontal() * 2);
					((Graphics2D)g).setStroke(dashed);
					g.drawRect(leCercle.getCoordonneeCentre().x+leCercle.getRayonHorizontal(), leCercle.getCoordonneeCentre().y+leCercle.getRayonVertical(), leCercle.getRayonHorizontal() * 2, leCercle.getRayonVertical() * 2);
					break;
					
				case LIGNE:
					Ligne laLigne = (Ligne) laForme;
					g.drawLine(laLigne.getPremiereCoordonnee().x, laLigne.getPremiereCoordonnee().y, laLigne.getSecondeCoordonnee().x, laLigne.getSecondeCoordonnee().y);
					((Graphics2D)g).setStroke(dashed);
					g.drawRect(laLigne.getPremiereCoordonnee().x, laLigne.getPremiereCoordonnee().y, laLigne.getSecondeCoordonnee().x-laLigne.getPremiereCoordonnee().x, laLigne.getPremiereCoordonnee().y-laLigne.getSecondeCoordonnee().y);
					break;
				}
			}
		}
	}
	
	/*
	 * Le Layout qui utilise (contient) FenetreFormes doit réserver 
	 * l'espace nécessaire à son affichage
	 */
	@Override 
	public Dimension getPreferredSize(){
		return dimension;
	}
	
	/**
	 * Ajoute une forme à la liste de formes.
	 * @param laForme La forme de type Forme à ajouter
	 */
	public void ajouterForme(Forme laForme){
		int pos = -1;
		do{
			pos++;
			if (pos == 10){
				System.arraycopy(listeFormes, 1, listeFormes, 0, 9);
				listeFormes[listeFormes.length - 1] = laForme;
			}else
				if (listeFormes[pos] == null){
					listeFormes[pos] = laForme;
					break;
				}
		} while(pos < listeFormes.length);
		paintComponent(getGraphics());
	}
=======
 * date 2013/05/04
 */
public class FenetreFormes extends JComponent{

    private static final long serialVersionUID = -2262235643903749505L;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static final Dimension dimension = new Dimension(500,500);
    //private Forme[] listeFormes;
    private ListeFormes listeFormes;
    private Map<Formes, Color> colorDictionary;

    /**
     * Constructeur
     */
    public FenetreFormes(ListeFormes liste){

        colorDictionary = new HashMap<Formes, Color>();

        this.listeFormes = liste;

        colorDictionary.put(Formes.CARRE, Color.RED);
        colorDictionary.put(Formes.CERCLE, Color.BLUE);
        colorDictionary.put(Formes.LIGNE, Color.BLACK);
        colorDictionary.put(Formes.OVALE, Color.YELLOW);
        colorDictionary.put(Formes.RECTANGLE, Color.GREEN);
    }

    /**
     * Affiche la liste de formes
     *
     * @param g L'element graphique qui permettra l'affichage.
     */
    @Override
    public void paintComponent(Graphics g){
//        Graphics2D g2D = (Graphics2D)g;
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(Color.BLACK);
        g.drawString("NbFormes : " + listeFormes.length(), 10,15);
//
//        float dash1[] = {5.0f};
//        BasicStroke dashed = new BasicStroke(1.0f,
//                        BasicStroke.CAP_BUTT,
//                        BasicStroke.JOIN_MITER,
//                        10.0f, dash1, 0.0f);

        if (listeFormes != null){

            listeFormes.premiere();

            for (int pos = 0; pos < listeFormes.length(); pos++){

                Forme laForme = listeFormes.getNoeudCourant().getForme();

                listeFormes.suivant();

                g.setColor(colorDictionary.get(laForme.getType()));

                Formes typeForme = laForme.getType();

                if(typeForme == Formes.CARRE){
                    Rectangle leCarre = (Rectangle) laForme;
                    g.fillRect(leCarre.getPremiereCoordonnee().x, leCarre.getPremiereCoordonnee().y, leCarre.getWidth(), leCarre.getHeight());
                    g.setColor(Color.BLACK);
                    g.drawRect(leCarre.getPremiereCoordonnee().x, leCarre.getPremiereCoordonnee().y, leCarre.getWidth(), leCarre.getHeight());
//                    g2D.setStroke(dashed);
//                    g2D.drawRect(leCarre.getPremiereCoordonnee().x, leCarre.getPremiereCoordonnee().y, leCarre.getWidth(), leCarre.getHeight());
                }
                else if(typeForme == Formes.RECTANGLE) {
                    Rectangle leRectangle = (Rectangle) laForme;
                    g.fillRect(leRectangle.getPremiereCoordonnee().x, leRectangle.getPremiereCoordonnee().y, leRectangle.getWidth(), leRectangle.getHeight());
                    g.setColor(Color.BLACK);
                    g.drawRect(leRectangle.getPremiereCoordonnee().x, leRectangle.getPremiereCoordonnee().y, leRectangle.getWidth(), leRectangle.getHeight());
//                    g2D.setStroke(dashed);
//                    g2D.drawRect(leRectangle.getPremiereCoordonnee().x, leRectangle.getPremiereCoordonnee().y, leRectangle.getWidth(), leRectangle.getHeight());
                }
                else if(typeForme == Formes.OVALE) {
                    Ovale lOvale = (Ovale) laForme;
                    g.fillOval(lOvale.getCoordonneeCentre().x, lOvale.getCoordonneeCentre().y, lOvale.getRayonHorizontal() * 2, lOvale.getRayonVertical() * 2);
                    g.setColor(Color.BLACK);
                    g.drawOval(lOvale.getCoordonneeCentre().x, lOvale.getCoordonneeCentre().y, lOvale.getRayonHorizontal() * 2, lOvale.getRayonVertical() * 2);
//                    g2D.setStroke(dashed);
//                    g2D.drawRect(lOvale.getCoordonneeCentre().x-lOvale.getRayonHorizontal()/2,
//                            lOvale.getCoordonneeCentre().y+lOvale.getRayonVertical()/2,
//                            lOvale.getRayonHorizontal() * 2, lOvale.getRayonVertical() * 2);
                }
                else if(typeForme == Formes.CERCLE) {
                    Ovale leCercle = (Ovale) laForme;
                    g.fillOval(leCercle.getCoordonneeCentre().x, leCercle.getCoordonneeCentre().y, leCercle.getRayonHorizontal() * 2, leCercle.getRayonHorizontal() * 2);
                    g.setColor(Color.BLACK);
                    g.drawOval(leCercle.getCoordonneeCentre().x, leCercle.getCoordonneeCentre().y, leCercle.getRayonHorizontal() * 2, leCercle.getRayonHorizontal() * 2);
//                    g2D.setStroke(dashed);
//                    g2D.drawRect(leCercle.getCoordonneeCentre().x-leCercle.getRayonHorizontal()/2,
//                            leCercle.getCoordonneeCentre().y+leCercle.getRayonVertical()/2,
//                            leCercle.getRayonHorizontal() * 2, leCercle.getRayonHorizontal() * 2);
                } else if(typeForme == Formes.LIGNE) {
                    Ligne laLigne = (Ligne) laForme;
                    g.drawLine(laLigne.getPremiereCoordonnee().x, laLigne.getPremiereCoordonnee().y, laLigne.getSecondeCoordonnee().x, laLigne.getSecondeCoordonnee().y);
                    //g2D.setStroke(dashed);
                    //g.drawRect(laLigne.getPremiereCoordonnee().x, laLigne.getPremiereCoordonnee().y, laLigne.getSecondeCoordonnee().x, laLigne.getSecondeCoordonnee().y);
                }
            }
        }
    }

    /*
     * Le Layout qui utilise (contient) FenetreFormes doit réserver
     * l'espace nécessaire à son affichage
     */
    @Override
    public Dimension getPreferredSize(){
        return dimension;
    }

    /**
     * Ajoute une forme à la liste de formes.
     * @param laForme La forme de type Forme à ajouter
     */
    public void ajouterForme(Forme laForme){
//		int pos = -1;
//		do{
//			pos++;
//			if (pos == 10){
//				System.arraycopy(listeFormes, 1, listeFormes, 0, 9);
//				listeFormes[listeFormes.length - 1] = laForme;
//			}else
//				if (listeFormes[pos] == null){
//					listeFormes[pos] = laForme;
//					break;
//				}
//		} while(pos < listeFormes.length);

        listeFormes.ajouterFormeFin(laForme);

    }
>>>>>>> e6760c689fc87ef118f04888b42215d42216646f
}
