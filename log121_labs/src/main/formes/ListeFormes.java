package main.formes;

/**
 * Classe qui cree une liste chainee de formes.
 *
 * @author Mathieu Lachance
 * 2013-10-10 Version Initiale
 * 2013-10-19 Modifications des methodes.
 */
public class ListeFormes {


    /**
     * Classe interne qui cree un noeud de la liste chainee.
     */
    public class Noeud {

        private Forme laForme;
        private Noeud suivant;

        /**
         * Constructeur par defaut, initialise laForme et suivant à null.
         */
        public Noeud() {}

        /**
         * Constructeur par copie d'attribut.
         * Permet de pouvoir ajouter une forme à la liste,
         * ainsi que le forme sur laquelle elle pointe.
         *
         * @param formeNoeud    une forme
         * @param suivant       le noeud qui suit ce noeud.
         */
        public Noeud(Forme formeNoeud, Noeud suivant) {
            this.laForme = formeNoeud;
            this.suivant = suivant;
        }

        /**
         * Accesseur de la forme
         *
         * @return  la forme stockee dans ce noeud
         */
        public Forme getForme() {
            return laForme;
        }

        /**
         * Accesseur du noeud suivant.
         *
         * @return  le noeud suivant celui-ci
         */
        public Noeud getSuivant() {
            return suivant;
        }


    }

    /**
     * Pointeur du noeud courrant.
     */
    private Noeud pos;
    /**
     * Pointeur du premier noeud.
     */
    private Noeud premiere;

    /**
     * Initialisation de la longueur de la liste à 0.
     */
    private int length = 0;

    /**
     * Constructeur par defaut.
     */
    public ListeFormes() {}


    /**
     * Methode qui retourne le nombre de formes qu'il ya dans la liste chainee
     * @return le nombre de forme dans la liste chainee
     */
    public int length() {

        return length;

    }

    /**
     * Methode qui inverse la valeur de la forme a la position courante
     * avec celle du prochain noeud.
     */
    public void inverser() {

        if(pos.suivant != null) {

            Forme copieForme = pos.laForme;

            pos.laForme = pos.suivant.laForme;
            pos.suivant.laForme = copieForme;

            copieForme = null; // Le garbage collector viendra supprimer cette instance de forme.

        }

    }

    /**
     * Methode qui ajoute une forme a la fin de la liste chainee
     *
     * @param nouvelleForme la forme que l'on desire ajouter a la liste chainee
     */
    public void ajouterFormeFin(Forme nouvelleForme) {
        derniere();
        ajouterForme(nouvelleForme);
    }

    /**
     * Methode qui permet d'ajouter une forme a la fin de la  liste chainee.
     * Gere aussi la mise en mémoire d'une liste chainee de 10 formes seulement.
     *
     * @param forme La forme que l'on veut ajouter
     */
    public void ajouterForme(Forme forme) {

        // Si la longeur n'est pas égale à 10, ajoute normalement.
        // Sinon detruit la premiere forme et ajouter

        if(length() != 10) {
            if(length() == 0)
                premiere = pos = new Noeud(forme, null);
            else if(length() == 1)
                pos = premiere.suivant = new Noeud(forme, pos.suivant);
            else if(length() > 1)
                pos = pos.suivant = new Noeud(forme, pos.suivant);

            length++;
        }
        else {
            detruirePremiereForme();
            pos = pos.suivant = new Noeud(forme, pos.suivant);
        }
    }

    /**
     * Methode qui detruit la premiere forme sans modifier le pointeur de position de la liste.
     */
    public void detruirePremiereForme() {
        Noeud noeudTemporaire = premiere;
        premiere = null;
        premiere = noeudTemporaire.suivant;

        noeudTemporaire=null; // Le garbage collector viendra supprimer cette instance de Noeaud.
    }

    /**
     * Methode qui detruit la forme a la position courante.
     */
    public void detruireForme() {
    	if (pos.getForme().getNumeroSequence() == premiere.getForme().getNumeroSequence()){
    		suivant();
    		premiere = pos;
    	}else{
	        precedent();
	        pos.suivant=pos.suivant.suivant;
    	}
    }


    /**
     * Permet d'aller detruire la forme equivalente a celle que l'on envoie en parametre
     *
     * @param formeADetruire la forme que l'on veut detruire dans la liste.
     */
    public void detruireForme(Forme formeADetruire) {

        boolean matchFound = false;

        Noeud miseEnMemoirePosition = pos;

        pos = premiere;

        while(!matchFound) {

            if(pos.getForme().getNumeroSequence() != formeADetruire.getNumeroSequence())
                suivant();
            else {
                detruireForme();
                matchFound = true;
            }

        }

        pos=miseEnMemoirePosition;

    }

    /**
     * Methode qui permet de pointer sur la prochaine forme de la liste chainee.
     */
    public Noeud suivant() {
        if(pos.suivant != null){
            pos = pos.suivant;
            return pos;
        }
        else
        	return null;
    }

    /**
     * Methode qui permet de pointer sur la forme precedente de la position actuelle de la liste chaine
     */
    public void precedent() {
        if(pos != null && premiere != null) {
        	Noeud elementPrecedent = premiere;
        	
        	while (elementPrecedent.suivant.getForme().getNumeroSequence() != pos.getForme().getNumeroSequence())
        		elementPrecedent = elementPrecedent.suivant;
        	
        	pos = elementPrecedent;
        }
    }

    /**
     * Methode qui permet de pointer sur la premiere forme de la liste chainee.
     */
    public void premiere() {
        pos=premiere;
    }

    /**
     * Methode qui permet de pointer sur la derniere forme de la liste chainee.
     */
    public void derniere() {
        if(premiere != null) {
            pos=premiere;
            while(pos.suivant != null) {
                suivant();
            }
        }
    }

    /**
     * Methode qui retourne la derniere forme de la liste chainee
     * sans detruire le noeud.
     *
     * @return La derniere forme de la liste chainee
     */
    public Forme getderniereForme() {
        derniere();
        return pos.laForme;
    }

    /**
     * @return le noeud a la position courrante
     */
    public Noeud getNoeudCourant(){
        return pos;
    }

}
