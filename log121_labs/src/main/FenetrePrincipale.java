package main;
/******************************************************
 Cours:  LOG121
 Projet: Squelette du laboratoire #1
 Nom du fichier: FenetrePrincipale.java
 Date créé: 2013-05-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Patrice Boucher
2013-05-03 Version initiale
 *******************************************************/

import ca.etsmtl.log.util.IDLogger;
import main.formes.CreateurFormes;
import main.formes.AbstractForme;
import main.formes.ListeFormes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Cette classe représente la fenêtre principale de l'application 
 * @author Patrice Boucher
 * date 2013/05/04
 */
public class FenetrePrincipale extends JFrame implements PropertyChangeListener{

    private static final long serialVersionUID = -1210804336046370508L;
    private FenetreFormes fenetreFormes;
    private IDLogger log;
    private ListeFormes liste;
    private CommBase comm;
    private MenuFenetre menu;

    /**
     * Constructeur
     */
    public FenetrePrincipale(final CommBase comm){
        this.comm = comm;
        this.liste = new ListeFormes();
        menu = new MenuFenetre(comm, liste);
        this.setLayout(new BorderLayout());
        this.add(menu, BorderLayout.NORTH);
        fenetreFormes = new FenetreFormes(liste);
        this.add(fenetreFormes, BorderLayout.CENTER); // Ajoute la fenêtre de forme à la fenètre principale
        this.pack(); // Ajuste la dimension de la fenêtre principale selon celle de ses composants
        this.setVisible(true); // Rend la fenêtre principale visible.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //... à réviser selon le comportement que vous désirez ...
        log = IDLogger.getInstance();

        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent windowEvent){
                if (comm.isActif()){
                    comm.disconnect();
                }
            }
        });
    }

    // Appelé lorsque le sujet lance "firePropertyChanger"
    @Override
    public void propertyChange(PropertyChangeEvent arg0) {

        if(arg0.getPropertyName().equals("ENVOIE-TEST")){
            System.out.print((String) arg0.getNewValue());
        } else if (arg0.getPropertyName().equals("NOUVELLE-TRAME")){
            AbstractForme nouvelleAbstractForme = CreateurFormes.creerForme((String) arg0.getNewValue());

            fenetreFormes.ajouterForme(nouvelleAbstractForme);
            log.logID(nouvelleAbstractForme.getNumeroSequence());

            fenetreFormes.setListeFormes(menu.getListeFormes());

            fenetreFormes.repaint();
        }

    }

}
