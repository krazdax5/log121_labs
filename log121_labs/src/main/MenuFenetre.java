/******************************************************
 * Cours:  LOG121
 * Projet: Squelette du laboratoire #1
 * Nom du fichier: MenuFenetre.java
 * Date créé: 2013-05-03
 *******************************************************
 * Historique des modifications
 *******************************************************
 * @author Patrice Boucher
 * 2013-05-03 Version initiale
 *
 * @author Charles Levesque
 * 2013-10-01 Version finale TP1
 *
 * @author Mathieu Lachance
 * 2013-10-09 Ajout des sous-menus "Connecter" et "Deconnecter"
 *******************************************************/

package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import main.formes.util.ClasseurFormes;
import main.formes.ListeFormes;

/**
 * Cree le menu de la fenetre de l'application
 */
public class MenuFenetre extends JMenuBar{
	
	private static final long serialVersionUID = 1536336192561843187L;
	private static final int  MENU_DESSIN_ARRETER_TOUCHE_MASK  = ActionEvent.CTRL_MASK;
	private static final char MENU_DESSIN_ARRETER_TOUCHE_RACC  = KeyEvent.VK_A;
	private static final int  MENU_DESSIN_DEMARRER_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_DESSIN_DEMARRER_TOUCHE_RACC = KeyEvent.VK_D;
	private static final int  MENU_FICHIER_QUITTER_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_FICHIER_QUITTER_TOUCHE_RACC = KeyEvent.VK_Q;
    private static final int  MENU_FICHIER_OBTENIR_TOUCHE_MASK = ActionEvent.CTRL_MASK;
    private static final char MENU_FICHIER_OBTENIR_TOUCHE_RACC = KeyEvent.VK_O;
	private static final String
			MENU_FICHIER_TITRE = "app.frame.menus.file.title",
			MENU_FICHIER_QUITTER = "app.frame.menus.file.exit",
            MENU_FICHIER_OBTENIR_FORMES = "app.frame.menus.file.getShapes",
			MENU_DESSIN_TITRE = "app.frame.menus.draw.title",
			MENU_DESSIN_DEMARRER = "app.frame.menus.draw.start",
			MENU_DESSIN_ARRETER = "app.frame.menus.draw.stop",
            MENU_DESSIN_CONNECTER = "app.frame.menus.file.connect",
            MENU_DESSIN_DECONNECTER = "app.frame.menus.file.disconnect",
            MENU_ORDRE_TITLE = "app.frame.menus.order.title",
            MENU_ORDRE_AIRECROISSANTE ="app.frame.menus.order.growingarea",
            MENU_ORDRE_AIREDECROISSANTE = "app.frame.menus.order.decreasingarea",
			MENU_AIDE_TITRE = "app.frame.menus.help.title",
			MENU_AIDE_PROPOS = "app.frame.menus.help.about";
	private static final String MESSAGE_DIALOGUE_A_PROPOS = "app.frame.dialog.about";  

	private JMenuItem arreterMenuItem, demarrerMenuItem, connecterMenuItem, deconnecterMenuItem, quitterMenuItem, obtenirFormesMenuItem;
	private static final int DELAI_QUITTER_MSEC = 200, LIMITE_DE_FORMES = 10;
 	   
	private CommBase comm; // Pour activer/désactiver la communication avec le serveur
    private ListeFormes liste;

    private boolean croissant = true;
	
	/**
	 * Constructeur
	 */
	public MenuFenetre(CommBase comm, ListeFormes liste) {
		this.comm = comm;
        this.liste = liste;
		addMenuDessiner();
        addMenuOrdre();
		addMenuFichier();
		addMenuAide();
	}

	/**
	 *  Creer le menu "Draw"/"Dessiner".
	 */
	protected void addMenuDessiner() {
		JMenu menu = creerMenu(MENU_DESSIN_TITRE,new String[] { MENU_DESSIN_DEMARRER, MENU_DESSIN_ARRETER,
                MENU_DESSIN_CONNECTER, MENU_DESSIN_DECONNECTER });

		demarrerMenuItem = menu.getItem(0);
		demarrerMenuItem.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent arg0) {
			comm.start();
			rafraichirMenus();
		  }
		});
		demarrerMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				MENU_DESSIN_DEMARRER_TOUCHE_RACC,
				MENU_DESSIN_DEMARRER_TOUCHE_MASK));

		arreterMenuItem = menu.getItem(1);
		arreterMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			comm.stop();
			rafraichirMenus();
		    }
	    });
		
		arreterMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				MENU_DESSIN_ARRETER_TOUCHE_RACC,
				MENU_DESSIN_ARRETER_TOUCHE_MASK));

        connecterMenuItem = menu.getItem(2);
        connecterMenuItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
            comm.connect();
            rafraichirMenus();
            }
        });

        deconnecterMenuItem = menu.getItem(3);
        deconnecterMenuItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                comm.disconnect();
                rafraichirMenus();
            }
        });

		add(menu);
        rafraichirMenus();

	}

    protected void addMenuOrdre() {
        JMenu menu = creerMenuOrdre(MENU_ORDRE_TITLE,
                new String[]{MENU_ORDRE_AIRECROISSANTE, MENU_ORDRE_AIREDECROISSANTE});

        ButtonGroup groupeTri = new ButtonGroup();
        menu.getItem(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                comm.stop();

//                ClasseurFormes.classerParAire(liste, croissant);

                rafraichirMenus();


            }
        });
        menu.getItem(1).setSelected(false);
        groupeTri.add(menu.getItem(0));

        menu.getItem(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                comm.stop();

//                ClasseurFormes.classerParAire(liste, !croissant);

                rafraichirMenus();

            }
        });
        menu.getItem(1).setSelected(false);
        groupeTri.add(menu.getItem(1));

        menu.addSeparator();

        add(menu);
        rafraichirMenus();
    }

	/** 
	 * Creer le menu "File"/"Fichier".
	 */
	protected void addMenuFichier() {
		JMenu menu = creerMenu(MENU_FICHIER_TITRE, new String[] { MENU_FICHIER_OBTENIR_FORMES, MENU_FICHIER_QUITTER });

        obtenirFormesMenuItem = menu.getItem(0);
        obtenirFormesMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                comm.start(LIMITE_DE_FORMES);
            }
        });
        obtenirFormesMenuItem.setAccelerator(
                KeyStroke.getKeyStroke(MENU_FICHIER_OBTENIR_TOUCHE_RACC, MENU_FICHIER_OBTENIR_TOUCHE_MASK)
        );

        quitterMenuItem = menu.getItem(1);
        quitterMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comm.getClient() != null && !comm.getClient().isClosed())
					comm.disconnect();
			    try {
						Thread.sleep(DELAI_QUITTER_MSEC);
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
				System.exit(0);
			}
		});
		quitterMenuItem.setAccelerator(
				KeyStroke.getKeyStroke(MENU_FICHIER_QUITTER_TOUCHE_RACC,
						MENU_FICHIER_QUITTER_TOUCHE_MASK));
		add(menu);
	}

	/**
	 *  Creer le menu "Help"/"Aide".
	 */
	private void addMenuAide() {
		JMenu menu = creerMenu(MENU_AIDE_TITRE, new String[] { MENU_AIDE_PROPOS });
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,  LangueConfig.getResource(MESSAGE_DIALOGUE_A_PROPOS), 
						LangueConfig.getResource(MENU_AIDE_PROPOS), JOptionPane.INFORMATION_MESSAGE);
			}
		});
		add(menu);
	}

	/**
	 *  Activer ou desactiver les items du menu selon la sélection.
	 */
	private void rafraichirMenus() {

		demarrerMenuItem.setEnabled(!comm.isActif());
		arreterMenuItem.setEnabled(comm.isActif());
        connecterMenuItem.setEnabled(!comm.isConnected());
        deconnecterMenuItem.setEnabled(comm.isConnected());
	}
	
	/**
	 * Créer un élément de menu à partir d'un champs principal et ses éléments
	 * @param titleKey champs principal
	 * @param itemKeys éléments
	 * @return le menu
	 */
	private static JMenu creerMenu(String titleKey,String[] itemKeys) {
        JMenu menu = new JMenu(LangueConfig.getResource(titleKey));
        for(int i=0; i < itemKeys.length; ++i) {
           menu.add(new JMenuItem(LangueConfig.getResource(itemKeys[i])));
        }
        return menu;
   }

    /**
     * Créer un élément de menu à partir d'un champs principal et ses éléments
     * @param titleKey champs principal
     * @param itemKeys éléments
     * @return le menu
     */
    private static JMenu creerMenuOrdre(String titleKey,String[] itemKeys) {
        JMenu menu = new JMenu(LangueConfig.getResource(titleKey));
        ButtonGroup groupTri = new ButtonGroup();
        for(int i=0; i < itemKeys.length; ++i) {
            JRadioButtonMenuItem radioButtonMenu = new JRadioButtonMenuItem(LangueConfig.getResource(itemKeys[i]));
            groupTri.add(radioButtonMenu);
            menu.add(radioButtonMenu);
        }
        return menu;
    }

}
