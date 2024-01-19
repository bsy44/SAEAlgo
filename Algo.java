import java.util.Arrays;
import java.util.Random;

public class Algo {

    public static void main(String[] args) {

        int[] tab = générerTabAleatoire(300000);
        long tempsDébut = System.nanoTime();

   //     Arrays.sort(tab);

        long tempsFin = System.nanoTime();

        //triInsertion(tab);
        //rechercheVal(55,tab);
        //rechercheParDichotomie(44,tab);
        //rechercheDichotomiqueValProche(tab, 110000);

        System.out.println("Temps de calcul en millisecondes: " + ((tempsFin - tempsDébut) / 1000000) );

       // System.out.println(Arrays.toString(tab));

    }

    /*
        Retourne un tableau de int rempli avec des valeurs aléatoires.
        La longueur du tableau est reçue en paramètre.
        (Valeurs comprises entre Integer.MIN_VALUE=-2^31 et Integer.MAX_VALUE=2^31-1 inclus).
    */
    public static int[] générerTabAleatoire(int longueur) {
        Random random = new Random();
        int[] t = new int[longueur];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = random.nextInt(); // tirage aléatoire d'un int quelconque (compris entre -2^31 et 2^31-1)
        return t;
    }

    /*
        Retourne un tableau de int rempli avec des valeurs aléatoires comprises entre min et max inclus.
        La longueur du tableau est reçue en paramètre.
    */
    public static int[] générerTabAleatoireEntreBornes(int longueur, int min, int max) {
        Random random = new Random();
        int[] t = new int[longueur];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = random.nextInt(max-min+1)+min; // nextInt(borne) retourne un int compris entre 0 inclus et borne exclus.
        return t;
    }

    public static int[] générerTableauTriéParOrdreCroissant (int longueur) {
        int[] t = new int[longueur];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = i;
        return t;
    }

    public static int[] générerTableauTriéParOrdreDecroissant (int longueur) {
        int[] t = new int[longueur];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = t.length-1-i;
        return t;
    }

    /*
        Retourne un tableau contenant les multiples de 4 à partir de 0 ({0, 4, 8, 16...}).
        Utile pour faire des essais de recherche dans un tableau trié.
     */

    public static int[] générerTabMultiplesDe4(int longueur) {
        int[] t = new int[longueur];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = 4*i;
        return t;
    }

    public static int[] triInsertion(int tab[]) {
        int pivot;
        int j;
        for (int i = 0; i < tab.length; i++) {
            j = i;
            pivot = tab[i];
            while (j > 0 && tab[j-1] > pivot) {
                tab[j] = tab[j-1];
                j--;
            }
            tab[j] = pivot;

        }
        return tab;
    }

    public static boolean rechercheVal (int nb, int tab[]){
        for (int i = 0; i < tab.length; i++) {
            if (tab[i]==nb){
                return true;
            }
        }
        return false;
    }

    public static boolean rechercheParDichotomie (int val, int tab []){
        int indDebut=0;
        int indFin=tab.length-1;

        while(indDebut<=indFin){
            System.out.println(indFin);
            int indMilieu=(indFin+indDebut)/2;
            if (tab[indMilieu] == val)
                return true;
            else if (tab[indMilieu] < val)
                indDebut=indMilieu+1;
            else
                indFin = indMilieu-1;
        }
        return false;
    }

    public static int rechercheDichotomiqueValProche(int[] tab, int valeur) {
        int debut = 0;
        int fin = tab.length - 1;

        while (debut <= fin) {
            int milieu = (debut + fin) / 2;

            if (tab[milieu] == valeur) {
                return tab[milieu];
            }

            if (tab[milieu] < valeur) {
                debut = milieu +1;
            } else {
                fin = milieu - 1;
            }
        }

        if (debut == 0|| debut < tab.length && (fin < 0 || Math.abs(tab[debut] - valeur) < Math.abs(tab[fin] - valeur))) {
            return tab[debut];
        }
        else {
            return tab[fin];
        }
    }

    public static int plusProcheValeur(int[] tab, int val) {
        int valPlusProche = tab[0];

        for (int i = 0; i < tab.length; i++) {
            if (tab[i]==val) {
                return tab[i];
            }
            else if (Math.abs(tab[i] - val) < Math.abs(valPlusProche - val)) {
                valPlusProche = tab[i];
            }
        }
        return valPlusProche;
    }

    public static int[] plusGrandVitesse (int [] tab, int val){
        int[] t = new int[val];
        int longueur= t.length-1;
        int[] newTab= new int[val];

        for (int i=0; i< t.length;i++) {
            t[i] = tab[i];
        }
        Arrays.sort(t);

        for (int i=val; i< tab.length;i++){
            if (tab[i]>t[0]){
                t[0]=tab[i];
                Arrays.sort(t);
            }
        }

        for (int i=0; i< newTab.length; i++){
            newTab[i] = t[longueur-i];
        }
        return newTab ;
    }
}

