import java.util.Arrays;
import java.util.Random;
import java.util.Arrays;
import java.util.Random;

public class Algo {

    public static void main(String[] args) {

        int[] tab =générerTableauTriéParOrdreCroissant(10000000);
        long tempsDébut = System.nanoTime();

        Arrays.sort(tab);

        long tempsFin = System.nanoTime();
        System.out.println(rechercheDichotomiqueValProche(tab,11000000));

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

    public static void TriInsertion(int tab[]) {
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
        int indMilieu= tab.length/2;
        int indDebut=0;
        int indFin=tab.length;
        boolean trouve= false;

        while(indDebut<=indFin && trouve==false){
            if (tab[indMilieu] == val)
                trouve =true;
            else if (tab[indMilieu] < val)
                indDebut=indMilieu++;
            else
                indFin = indMilieu--;
            indMilieu=(indFin+indDebut)/2;
        }
        return trouve;
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
                debut = milieu + 1;
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
                if (tab[i]==val)
                    return tab[i];

                else if (Math.abs(tab[i] - val) < Math.abs(valPlusProche - val)) {
                    valPlusProche = tab[i];
                }
            }

            return valPlusProche;
    }

    public static int[] PlusGrandVitesse (int [] tab, int val){
        int [] T= new int[val];
        for (int i=0; i< T.length;i++)
            T[i]=tab[i];
        Arrays.sort(T);

        for (int i=val; i< tab.length;i++){
            if (tab[i]>T[0]){
                T[0]=tab[i];
                Arrays.sort(T);
            }
        }
        int longueur= T.length-1;
        int [] Tab= new int[val];
        for (int i=0; i< Tab.length; i++){
            Tab[i]=T[longueur-i];
        }
        return Tab ;

    }
}

