/******************************************************
 * Cours:  LOG121
 * Projet: Squelette du laboratoire #1
 * Nom du fichier: ApplicationFormes.java
 * Date créé: 2013-05-03
 *******************************************************
 * Historique des modifications
 *******************************************************
 * @author Patrice Boucher
 * 2013-05-03 Version initiale
 *
 * @author Charles Levesque
 * 2013-10-01 Version finale TP1
 *******************************************************/
package main;

import javax.swing.*;

/**
 * Cette classe représente l'application dans son ensemble. 
 * @author Patrice Boucher
 * 2013/05/04
 */
public class ApplicationFormes{
	
	/**
	 * main de l'application
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationFormes application = new ApplicationFormes();
	}
	
	/**
	 * Constructeur
	 */
	public ApplicationFormes(){
		String serverLocation = JOptionPane.showInputDialog(LangueConfig.getResource("app.optionPane.message"));
		if (serverLocation != null){
			CommBase comm = new CommBase(serverLocation);
			FenetrePrincipale fenetre = new FenetrePrincipale(comm);
			comm.setPropertyChangeListener(fenetre);
		} else
			System.exit(0);
	}
}
