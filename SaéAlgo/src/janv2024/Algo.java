package janv2024;

import java.util.Arrays;
import java.util.Random;
public class Algo {



            int[] tab = générerTabAleatoire(300000);

            long tempsDébut = System.nanoTime();

            Arrays.sort(tab); // trie le tableau en utilisant un algorithme de type Quicksort

            long tempsFin = System.nanoTime();

            System.out.println("Temps de calcul en millisecondes: " + ((tempsFin - tempsDébut) / 1000000) );

            //System.out.println(Arrays.toString(tab));

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

        public static boolean rechercheParDichotomie (int nb, int tab []){
            int indMilieu= tab.length/2;
            int indDebut=0;
            int indFin=tab.length;
            boolean trouve= false;

            while(indDebut<=indFin && trouve==false){
                if (tab[indMilieu] = val)
                    trouve =true;
                else if (tab[indMilieu] < val)
                    indDebut=indMilieu++;
                else
                    indFin = indMilieu--;
                indMilieu=(indFin+indDebut)/2
            }
            return trouve;
    }
}
