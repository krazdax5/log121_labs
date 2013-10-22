//package main.formes.util;
//import java.awt.Point;
//
//import main.formes.util.AnalyseurTrame;
//import main.formes.Rectangle;
//import main.formes.AbstractForme;
//import main.formes.Formes;
//import main.formes.ListeFormes;;
//
///**
//* Classe qui permet de repositionner les formes au bon endroit dans la fenetre
//* @author Pierre-Luc Landry
//* 2013/10/16 Version Initiale
//*
//*/
//public class ReplacerForme {
//
//
//	private int rayonH, rayonV,x2, y2;
//	final int DISTANCE = 40;
//
//	/**
//	 * Constructeur qui permet de changer les coordonnees de la forme
//	 * On change toutes les formes precentes dans la liste  a l'aide d'une boucle
//	 * @param liste liste chainee dont les formes ne sont pas encore dans l'ordre d'affichage desire
//	 * @return liste on retourne la liste chainee dont les formes on maintenant des nouvelles coordonnees
//	 */
//	public ListeFormes replacerForme(ListeFormes liste){
//
//		try{
//			liste.premiere();
//			for(int i=0; i<=liste.getLength();i++){
//				AbstractForme forme = liste.getForme(i);
//
//				if(forme.getType()==Formes.CARRE ||forme.getType()==Formes.RECTANGLE )
//					setCoordCarre(forme,DISTANCE*i, DISTANCE*i);
//
//				else if(forme.getType()==Formes.CERCLE)
//					setCoordCercle(forme,DISTANCE*i, DISTANCE*i);
//
//				else if(forme.getType()==Formes.OVALE)
//					setCoordCercle(forme, DISTANCE*i, DISTANCE*i);
//
//				else if(forme.getType()==Formes.LIGNE)
//					setCoordLigne(forme,DISTANCE*i,DISTANCE*i);
//
//			}
//		}catch(Exception e){
//			System.out.print(e);
//		}
//		return liste;
//	}
//
//	/**
//	 * Methode qui permet de changer les coordonnees d'une ligne
//	 * @param forme la forme
//	 * @param x premiere coordonnee en x
//	 * @param y premiere coordonnee en y
//	 * @return un tableau qui contient les coordonnees x1, y1, x2 et y2 changees
//	 */
//	private int[] setCoordLigne(AbstractForme forme, int x1, int y1) {
//
//		int[] tab = new int [4];
//
//		x1=forme.getPremiereCoordonnee().x;
//
//		y1=forme.getPremiereCoordonnee().y;
//
//		if(x1>x2)
//			x2=forme.getDeuxiemeCoordonnee().x-forme.getPremiereCoordonnee().x;
//		else if(x2>x1)
//			x2=forme.getPremiereCoordonnee().x-forme.getDeuxiemeCoordonnee().x;
//
//		if(y1>y2)
//			y2=forme.getDeuxiemeCoordonnee().y-forme.getPremiereCoordonnee().y;
//		else if(y2>y1)
//			y2=forme.getPremiereCoordonnee().y-forme.getDeuxiemeCoordonnee().y;
//
//		x1=tab[0];
//		y1=tab[1];
//		x2=tab[2];
//		y2=tab[3];
//
//		return tab;
//	}
//
//	/**
//	 * Methode qui permet de changer les coordonnees d'un cercle et d'un ovale
//	 * @param forme
//	 * @param x
//	 * @param y
//	 */
//	private Object setCoordCercle(AbstractForme forme, int x, int y) {
//		rayonH = forme.getRayonHorizontal();
//		rayonV = forme.getRayonVertical();
//
//		x=forme.getCoordonneeCentre().x+rayonH;
//		y=forme.getCoordonneeCentre().y+rayonV;
//
//		return forme;
//	}
//
//	/**
//	 * Methode qui permet de changer les coordonnees d'un carre et d'un rectangle
//	 * @param forme
//	 * @param x
//	 * @param y
//	 */
//
//	private void setCoordCarre(AbstractForme forme, int x, int y) {
//		x=forme.getPremiereCoordonnee().x;
//		y=forme.getPremiereCoordonnee().y;
//	}
//
//
//
//}
