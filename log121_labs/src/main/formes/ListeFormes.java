package main.formes;

/**
 * Classe qui cree une liste chainee de formes.
 * @author Mathieu Lachance et Pierre-Luc Landry
 * 2013-10-10 Version Initiale
 * 
 * Modification:
 * 1-Pierre-Luc Landry 15/10/2013
 * 2-Charles Levesque 18/10/13
 */
public class ListeFormes {

    private Noeud position;
    private Noeud premiere;
    private int length = 0;

    /**
     * Methode qui retourne la derniere forme de la liste chainee.
     *
     * @return La derniere forme de la liste chainee
     */
    public Forme getDerniereForme() {
        derniere();
        return position.laForme;
    }

    /**
     * Methode qui retourne la forme a la position desiree (envoyee en parametres)
     *
     * @param num La position de la forme desiree
     * @return la forme a la postion envoye en parametres
     */
    public Forme getForme(int num) {
        Forme forme = null;
        if(length() != 0) {
            position = premiere;
            for(int i = 0; i < num; i++)
                suivant();
            forme = position.laForme;
        }
        return forme;
    }


    /**
     * Methode qui permet de retrouver la position courante dans la liste
     * @return le noeud a la position courrante
     */
    public Noeud getPosition(){
        return position;
    }

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
        while(liste.position.suivant != null){
            position = new Noeud(liste.position.laForme, liste.position.suivant);
        }
    }

    /**
     * Methode qui retourne le nombre de formes qu'il ya dans la liste chainee
     * @return le nombre de forme dans la liste chainee
     */
    public int length() {
        return length;
    }

    /**
     * Methode qui inverse les valeurs des formes a la position courante
     */
    public void inverser() {
        if(position.suivant != null) {
            Forme temp = position.laForme;

            position.laForme = position.suivant.laForme;
            position.suivant.laForme = temp;

            temp = null;
        }
    }

    /**
     * Methode qui ajoute une forme a la fin de la liste chainee
     * @param f la forme que l'on desire ajouter a la liste chainee
     */
    public void ajouterFormeFin(Forme f) {
        derniere();
        ajouterForme(f);
    }

    /**
     * Methode qui permet d'ajouter une forme a la fin de la  liste chainee.
     *
     * @param forme La forme que l'on veut ajouter
     */
    public void ajouterForme(Forme forme) {

        if(length() != 10) {
            if(length() == 0)
                premiere = position = new Noeud(forme, null);
            else if(length() == 1)
                position = premiere.suivant = new Noeud(forme, position.suivant);
            else if(length() > 1)
                position = position.suivant = new Noeud(forme, position.suivant);

            length++;
        }
        else {
            detruirePremiereForme();
            position = position.suivant = new Noeud(forme, position.suivant);
        }
    }
    
    /**
     * Methode qui detruit la premiere forme
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
        position = position.suivant;
    }

    /**
     * Methode qui detruit la forme a la position envoyee en parametre
     *
     * @param position la position de la forme que l'on veut detruire
     */
    public void detruireForme(int position) {
        getForme(position);
        detruireForme();
    }

    /**
     * Methode qui permet de pointer sur la prochaine forme de la liste chainee.
     */
    public void suivant() {
        if(position.suivant != null)
            position = position.suivant;
    }

    /**
     * Methode qui permet de pointer sur la premiere forme de la liste chainee.
     */
    public void premiere() {
        position =premiere;
    }

    /**
     * Methode qui permet de pointer sur la derniere forme de la liste chainee.
     */
    public void derniere() {
        if(premiere != null) {
            position =premiere;
            while(position.suivant != null) {
                suivant();
            }
        }
    }

    /**
     * Classe interne qui cree un noeud de la liste chainee.
     */
    public class Noeud {

        private Forme laForme;
        private Noeud suivant;

        /**
         * Constructeur par défaut.
         */
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

