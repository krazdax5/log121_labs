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

        private AbstractForme laAbstractForme;
        private Noeud suivant;

        /**
         * Constructeur par defaut, initialise laAbstractForme et suivant à null.
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
        public Noeud(AbstractForme formeNoeud, Noeud suivant) {
            this.laAbstractForme = formeNoeud;
            this.suivant = suivant;
        }

        /**
         * Accesseur de la forme
         *
         * @return  la forme stockee dans ce noeud
         */
        public AbstractForme getForme() {
            return laAbstractForme;
        }

        /**
         * Accesseur du noeud suivant.
         *
         * @return  le noeud suivant celui-ci
         */
        public Noeud getSuivant() {
            return suivant;
        }

        /**
         * Mutateur de la forme au noeud courant
         * @param nouvelleForme La nouvelle forme du noeud
         */
        public void setForme(AbstractForme nouvelleForme) {
            this.laAbstractForme = nouvelleForme;
        }

        /**
         * Mutateur du noeud suivant du noeud courant
         * @param noeudSuivant le nouveau noeud
         */
        public void setSuivant(Noeud noeudSuivant) {
            this.suivant = noeudSuivant;
        }

    }

    /**
     * Pointeur du noeud courant.
     */
    private Noeud noeudCourant;

    /**
     * Pointeur du premier noeud.
     */
    private Noeud premierNoeud;

    /**
     * Initialisation de la longueur de la liste à 0.
     */
    private int length = 0;

    /**
     * Constructeur par defaut.
     */
    public ListeFormes() {}


    /**
     * Accesseur de getLength
     * @return le nombre de forme dans la liste chainee
     */
    public int getLength() {

        return length;

    }

    /**
     * Methode qui inverse la valeur de la forme a la position courante
     * avec celle du prochain noeud.
     */
    public void inverser() {

        if(noeudCourant.suivant != null) {

            AbstractForme copieForme = noeudCourant.laAbstractForme;

            noeudCourant.laAbstractForme = noeudCourant.suivant.laAbstractForme;
            noeudCourant.suivant.laAbstractForme = copieForme;

            copieForme = null; // Le garbage collector viendra supprimer cette instance de forme.

        }

    }

    /**
     * Methode qui ajoute une forme a la fin de la liste chainee
     *
     * @param nouvelleForme la forme que l'on desire ajouter a la liste chainee
     */
    public void ajouterFormeFin(AbstractForme nouvelleForme) {
        derniere();
        ajouterForme(nouvelleForme);
    }

    /**
     * Methode qui permet d'ajouter une abstractForme a la fin de la  liste chainee.
     * Gere aussi la mise en mémoire d'une liste chainee de 10 formes seulement.
     *
     * @param abstractForme La abstractForme que l'on veut ajouter
     */
    public void ajouterForme(AbstractForme abstractForme) {

        // Si la longeur n'est pas égale à 10, ajoute normalement.
        // Sinon detruit la premierNoeud abstractForme et ajouter

        if(getLength() != 10) {
            if(getLength() == 0)
                premierNoeud = noeudCourant = new Noeud(abstractForme, null);
            else if(getLength() == 1)
                noeudCourant = premierNoeud.suivant = new Noeud(abstractForme, noeudCourant.suivant);
            else if(getLength() > 1)
                noeudCourant = noeudCourant.suivant = new Noeud(abstractForme, noeudCourant.suivant);

            length++;
        }
        else {
            detruirePremiereForme();
            noeudCourant = noeudCourant.suivant = new Noeud(abstractForme, noeudCourant.suivant);
        }
    }

    /**
     * Methode qui detruit la premierNoeud forme sans modifier le pointeur de position de la liste.
     */
    public void detruirePremiereForme() {
        Noeud noeudTemporaire = premierNoeud;
        premierNoeud = null;
        premierNoeud = noeudTemporaire.suivant;

        noeudTemporaire=null; // Le garbage collector viendra supprimer cette instance de Noeaud.
    }

    /**
     * Methode qui detruit la forme a la position courante.
     */
    public void detruireForme() {
    	if (noeudCourant.getForme().getNumeroSequence() == premierNoeud.getForme().getNumeroSequence()){
    		suivant();
    		premierNoeud = noeudCourant;
    	}else{
	        precedent();
	        noeudCourant.suivant=noeudCourant.suivant.suivant;
    	}
    }


    /**
     * Permet d'aller detruire la forme equivalente a celle que l'on envoie en parametre
     *
     * @param formeADetruire la forme que l'on veut detruire dans la liste.
     */
    public void detruireForme(AbstractForme formeADetruire) {

        boolean matchFound = false;

        Noeud memoirePosition = noeudCourant;

        noeudCourant = premierNoeud;

        while(!matchFound) {

            if(noeudCourant.getForme().getNumeroSequence() != formeADetruire.getNumeroSequence())
                suivant();
            else {
                detruireForme();
                matchFound = true;
            }

        }

        noeudCourant=memoirePosition;

    }

    /**
     * Methode qui permet de pointer sur la prochaine forme de la liste chainee.
     */
    public Noeud suivant() {
        if(noeudCourant.suivant != null){
            noeudCourant = noeudCourant.suivant;
            return noeudCourant;
        }
        else
        	return null;
    }

    /**
     * Methode qui permet de pointer sur la forme precedente de la position actuelle de la liste chaine
     */
    public void precedent() {
        if(noeudCourant != null && premierNoeud != null) {
        	Noeud elementPrecedent = premierNoeud;
        	
        	while (elementPrecedent.suivant.getForme().getNumeroSequence() != noeudCourant.getForme().getNumeroSequence())
        		elementPrecedent = elementPrecedent.suivant;
        	
        	noeudCourant = elementPrecedent;
        }
    }

    /**
     * Methode qui permet de pointer sur la premierNoeud forme de la liste chainee.
     */
    public void premiere() {
        noeudCourant= premierNoeud;
    }

    /**
     * Methode qui permet de pointer sur la derniere forme de la liste chainee.
     */
    public void derniere() {
        if(premierNoeud != null) {
            noeudCourant= premierNoeud;
            while(noeudCourant.suivant != null) {
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
    public AbstractForme getderniereForme() {
        derniere();
        return noeudCourant.laAbstractForme;
    }

    /**
     * @return le noeud a la position courrante
     */
    public Noeud getNoeudCourant(){
        return noeudCourant;
    }

}
