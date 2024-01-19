
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;


import org.testng.annotations.Test;

public class AlgoTest {

    @Test
    void triInsertion() {

        int[] tab = {5, 4, 6, 1, 7, 8, 10};
        int[] resultat = {1, 4, 5, 6, 7, 8, 10};
        int[] tab2 = {1, 7, 6, 0, 7, 8, 10};
        int[] resultat2 = {0, 1, 6, 7, 7, 8, 10};
        int[] tab3 = {1, 7, 6, 0, 7, 8, -10};
        int[] resultat3 = {-10, 0, 1, 6, 7, 7, 8};
        Algo.triInsertion(tab);
        assertArrayEquals(tab, resultat);
        Algo.triInsertion(tab2);
        assertArrayEquals(tab2, resultat2);
        Algo.triInsertion(tab3);
        assertArrayEquals(tab3, resultat3);
    }

    @Test
    void rechercheParDichotomie(){
        int[] tab = {4, 5, 6, 7, 8, 8, 10};
        int[] tab2 = {1, 6, 7, 7, 7, 8, 10};

        assertTrue(Algo.rechercheParDichotomie(5, tab),"Cas présent dans le tableau");
        assertFalse(Algo.rechercheParDichotomie(-4,tab2), "Cas non présent dans le tableau");
    }

    @Test
    void rechercheVal(){
        int[] tab = {5, 4, 6, 1, 7, 8, 10};

        assertTrue(Algo.rechercheVal(1, tab),"Cas moyen avec la plus petite valeur");
        assertTrue(Algo.rechercheVal(10, tab),"Cas moyen avec la plus grande valeur");
        assertFalse(Algo.rechercheVal(0, tab),"Cas non présent");
    }
}