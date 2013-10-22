package main.formes;

/**
 * Classe qui cree une liste chainee de formes.
<<<<<<< HEAD
 * @author Mathieu Lachance et Pierre-Luc Landry
 * 2013-10-10 Version Initiale
 * 
 * Modification:
 * 1-Pierre-Luc Landry 15/10/2013
 */
public class ListeFormes {

    private Noeud pos;
    private Noeud premiere;

    private int length = 0;
    
    
    /**
     * Constructeur pas défaut
     */
    public ListeFormes() {}
    
    /**
     * Constructeur qui permet de creer les noeuds entre chaque element de la liste
     * @param liste
     */

    public ListeFormes(ListeFormes liste) {
        liste.premiere();
        while(liste.pos.suivant != null){
            pos = new Noeud(liste.pos.laForme, liste.pos.suivant);
        }
    }
=======
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

>>>>>>> e6760c689fc87ef118f04888b42215d42216646f

    /**
     * Methode qui retourne le nombre de formes qu'il ya dans la liste chainee
     * @return le nombre de forme dans la liste chainee
     */
    public int length() {

        return length;

    }

    /**
<<<<<<< HEAD
     * Methode qui inverse les valeurs des formes a la position courante
=======
     * Methode qui inverse la valeur de la forme a la position courante
     * avec celle du prochain noeud.
>>>>>>> e6760c689fc87ef118f04888b42215d42216646f
     */
    public void inverser() {

        if(pos.suivant != null) {
<<<<<<< HEAD
            Forme temp = pos.laForme;

            pos.laForme = pos.suivant.laForme;
            pos.suivant.laForme = temp;

            temp = null;
=======

            Forme copieForme = pos.laForme;

            pos.laForme = pos.suivant.laForme;
            pos.suivant.laForme = copieForme;

            copieForme = null; // Le garbage collector viendra supprimer cette instance de forme.

>>>>>>> e6760c689fc87ef118f04888b42215d42216646f
        }

    }

    /**
     * Methode qui ajoute une forme a la fin de la liste chainee
<<<<<<< HEAD
     * @param f la forme que l'on desire ajouter a la liste chainee
     */
    public void ajouterFormeFin(Forme f) {
        derniere();
        ajouterForme(f);
=======
     *
     * @param nouvelleForme la forme que l'on desire ajouter a la liste chainee
     */
    public void ajouterFormeFin(Forme nouvelleForme) {
        derniere();
        ajouterForme(nouvelleForme);
>>>>>>> e6760c689fc87ef118f04888b42215d42216646f
    }

    /**
     * Methode qui permet d'ajouter une forme a la fin de la  liste chainee.
<<<<<<< HEAD
=======
     * Gere aussi la mise en mémoire d'une liste chainee de 10 formes seulement.
>>>>>>> e6760c689fc87ef118f04888b42215d42216646f
     *
     * @param forme La forme que l'on veut ajouter
     */
    public void ajouterForme(Forme forme) {

<<<<<<< HEAD
=======
        // Si la longeur n'est pas égale à 10, ajoute normalement.
        // Sinon detruit la premiere forme et ajouter

>>>>>>> e6760c689fc87ef118f04888b42215d42216646f
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
<<<<<<< HEAD
    
    /**
     * Methode qui detruit la premiere forme
     */

    public void detruirePremiereForme() {
        Noeud temp = premiere;
        premiere = null;
        premiere = temp.suivant;

        temp=null;
=======

    /**
     * Methode qui detruit la premiere forme sans modifier le pointeur de position de la liste.
     */
    public void detruirePremiereForme() {
        Noeud noeudTemporaire = premiere;
        premiere = null;
        premiere = noeudTemporaire.suivant;

        noeudTemporaire=null; // Le garbage collector viendra supprimer cette instance de Noeaud.
>>>>>>> e6760c689fc87ef118f04888b42215d42216646f
    }

    /**
     * Methode qui detruit la forme a la position courante.
     */
    public void detruireForme() {
<<<<<<< HEAD
        pos=pos.suivant;
    }

    /**
     * Methode qui detruit la forme a la position envoyee en parametre
     *
     * @param pos la position de la forme que l'on veut detruire
     */
    public void detruireForme(int pos) {
        getForme(pos);
        detruireForme();
=======
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

>>>>>>> e6760c689fc87ef118f04888b42215d42216646f
    }

    /**
     * Methode qui permet de pointer sur la prochaine forme de la liste chainee.
     */
<<<<<<< HEAD
    public void suivant() {
        if(pos.suivant != null)
            pos = pos.suivant;
=======
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
>>>>>>> e6760c689fc87ef118f04888b42215d42216646f
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
<<<<<<< HEAD
     * Methode qui retourne la derniere forme de la liste chainee.
     *
     * @return La derniere forme de la liste chainee
     */
    public Forme getDerniereForme() {
=======
     * Methode qui retourne la derniere forme de la liste chainee
     * sans detruire le noeud.
     *
     * @return La derniere forme de la liste chainee
     */
    public Forme getderniereForme() {
>>>>>>> e6760c689fc87ef118f04888b42215d42216646f
        derniere();
        return pos.laForme;
    }

    /**
<<<<<<< HEAD
     * Methode qui retourne la forme a la position desiree (envoyee en parametres)
     *
     * @param num La position de la forme desiree
     * @return la forme a la postion envoye en parametres
     */
    public Forme getForme(int num) {
        Forme forme = null;
        if(length() != 0) {
            pos = premiere;
            for(int i = 0; i < num; i++)
                suivant();
            forme = pos.laForme;
        }
        return forme;
    }


    /**
     * Methode qui permet de retrouver la position courante dans la liste
     * @return le noeud a la position courrante
     */
    public Noeud getPos(){
        return pos;
    }

    /**
     * Classe interne qui cree un noeud de la liste chainee.
     */
    public class Noeud {

        private Forme laForme;
        private Noeud suivant;

        public Noeud() {
            laForme = null;
            suivant = null;
        }
        public Noeud(Forme formeNoeud, Noeud suivant) {
            this.laForme = formeNoeud;
            this.suivant = suivant;
        }

        public Forme getForme() {
            return laForme;
        }

        public Noeud getSuivant() {
            return suivant;
        }


    }

}

=======
     * @return le noeud a la position courrante
     */
    public Noeud getNoeudCourant(){
        return pos;
    }

}
>>>>>>> e6760c689fc87ef118f04888b42215d42216646f
