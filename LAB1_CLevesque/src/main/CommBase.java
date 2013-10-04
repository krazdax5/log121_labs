/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: CommBase.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  
package main;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Base d'une communication via un fil d'exécution parallèle.
 */
public class CommBase {
	
	private final int DELAI = 1000;
	private SwingWorker threadComm = null;
	private PropertyChangeListener listener = null;
	private boolean isActif = false;
	private int PORT_SERVEUR = -1;
	private String ADRESSE_SERVEUR = null;
	private final String END_TRAME = "END";
	private final String GET_TRAME = "GET";
	private Socket client = null;
	private PrintWriter fluxEcriture = null;
	private BufferedReader fluxLecture = null;
	
	/**
	 * @return le socket client
	 */
	public Socket getClient() {
		return client;
	}

	/**
	 * Constructeur
	 */
	public CommBase(String serverLocation){
		try{
			this.ADRESSE_SERVEUR = serverLocation.split(":")[0];
			this.PORT_SERVEUR = Integer.parseInt(serverLocation.split(":")[1]);			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Mauvais nom de serveur.");
			System.exit(1);
		}
	}
	
	/**
	 * D�finir le r�cepteur de l'information re�ue dans la communication avec le serveur
	 * @param listener sera alerté lors de l'appel de "firePropertyChanger" par le SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener){
		this.listener = listener;
	}
	
	/**
	 * Démarre la communication
	 */
	public void start(){
		try{
			client = new Socket(ADRESSE_SERVEUR, PORT_SERVEUR);
			fluxLecture = new BufferedReader(new InputStreamReader(client.getInputStream()));
			fluxEcriture = new PrintWriter(client.getOutputStream(), true);
			creerCommunication();
		}catch(IOException ex){
			JOptionPane.showMessageDialog(null, "\nL'application n'a pas pu se connecter au serveur à l'adresse " + this.ADRESSE_SERVEUR + ", au port " + this.PORT_SERVEUR + "\n" + ex.getMessage());
		}
	}
	
	/**
	 * Arrête la communication
	 */
	public void stop(){
		if(threadComm!=null)
			threadComm.cancel(true); 
		isActif = false;
		if (client != null && client.isConnected()){
			try{
				fluxEcriture.println(END_TRAME);
				if (!client.isClosed())
					client.close();
			}catch(IOException ex){
				JOptionPane.showMessageDialog(null, "\nLa connexion n'a pas pu être fermée.\n".concat(ex.getMessage()));
			}
		}
	}
	
	/**
	 * Créer le nécessaire pour la communication avec le serveur
	 */
	protected void creerCommunication(){		
		// Crée un fil d'exécusion parallèle au fil courant,
		threadComm = new SwingWorker(){
			@Override
			protected Object doInBackground() throws Exception {
				System.out.println("Le fils d'execution parallele est lance");
				int compteur = 0;
				while(true){
					if (client.isConnected()){
						Thread.sleep(DELAI);
	  					fluxEcriture.println(GET_TRAME);
	  					fluxLecture.readLine();
	  					String trame = fluxLecture.readLine();
						
	 					//La méthode suivante alerte l'observateur 
						if(listener!=null){
							firePropertyChange("ENVOIE-TEST", null, (Object) ".");
							firePropertyChange("NOUVELLE-TRAME", null, (Object) trame);
						} else {
							JOptionPane.showMessageDialog(null, "Le serveur a interrompue la connexion.");
						}
					}
				}
			}
		};
		if(listener!=null)
		   threadComm.addPropertyChangeListener(listener); // La méthode "propertyChange" de ApplicationFormes sera donc appelée lorsque le SwinkWorker invoquera la méthode "firePropertyChanger" 		
		threadComm.execute(); // Lance le fil d'exécution parallèle.
		isActif = true;
	}
	
	/**
	 * @return si le fil d'exécution parallèle est actif
	 */
	public boolean isActif(){
		return isActif;
	}
}
