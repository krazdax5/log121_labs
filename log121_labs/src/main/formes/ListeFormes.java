package main.formes;

/**
 * Classe qui cree une liste chainee de formes.
 * @author Mathieu Lachance
 * 2013-10-10 Version Initiale
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
            Forme temp = pos.laForme;

            pos.laForme = pos.suivant.laForme;
            pos.suivant.laForme = temp;

            temp = null;
        }

    }

    /**
     * Methode qui ajoute une forme a la fin de la liste chainee
     *
     * @param f la forme que l'on desire ajouter a la liste chainee
     */
    public void ajouterFormeFin(Forme f) {
        derniere();
        ajouterForme(f);
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
        Noeud temp = premiere;
        premiere = null;
        premiere = temp.suivant;

        temp=null;
    }

    /**
     * Methode qui detruit la forme a la position courante.
     */
    public void detruireForme() {
        precedent();
        pos.suivant=pos.suivant.suivant;
    }

    /**
     * Methode qui detruit la forme a la position envoyee en parametre
     *
     * @param pos la position de la forme que l'on veut detruire
     */
    public void detruireForme(int pos) {
        getForme(pos);
        detruireForme();
    }

    /**
     * Methode qui permet de pointer sur la prochaine forme de la liste chainee.
     */
    public void suivant() {
        if(pos.suivant != null)
            pos = pos.suivant;
    }

    /**
     * Methode qui permet de pointer sur la forme precedente de la position actuelle de la liste chaine
     */
    public void precedent() {
        if(pos.suivant!= null && pos != null) {
            Noeud temp = premiere;

            while(temp.suivant != pos)
                temp = temp.suivant;
            pos=temp;

            temp = null;
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
     * Methode qui retourne la forme a la position desiree (envoyee en parametres)
     * sans detruire le noeud.
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
     * @return le noeud a la position courrante
     */
    public Noeud getPos(){
        return pos;
    }

}
