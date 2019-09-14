package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.NoSuchElementException;


public class Oblig1 {
    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if (a.length < 1)
            throw new NoSuchElementException("Listen er tom");
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                bytt(a,i,i+1);
            }
        }
        return a[a.length-1];
    }

    //Oppgave 1 b)
    public static int ombyttinger(int[] a){
        if (a.length < 1)
            throw new NoSuchElementException("Listen er tom");
        int count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                bytt(a,i,i+1);
                count++;
            }
        }
        return count;
    }

    public static void bytt(int[] a, int fra, int til){
        int temp = a[fra];
        a[fra] = a[til];
        a[til] = temp;
    }

    /*  Sporsmal oppgave 1:

      i)·Nar blir det flest ombyttinger?
         Nar det storste tallet er forst i arrayet.

      ii)·Nar blir det faerrest?
          Nar det storste tallet er sist i arrayet.

      iii)·Hvor mange blir det i gjennomsnitt?
           Det vil variere utifra hvor mange tall arrayet inneholder.

      */

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        int count = 0;
        int m = 0;
        if (a.length < 1) {
            return 0;
        }
        for (int i = 0; i < a.length; i++) {
            // sjekke hvis array er sortert i stigende rekkfølge

            if (a[i] >= m) {
                if (a[i] != m) {
                    count++;
                }
                m = a[i];
            } else {
                throw new IllegalStateException ("Array er ikke sortert i stigende rekkfølge");
            }

        }
        return count ;
    }



    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        int count = a.length;

        int verdi1 =0 ;
        int verdi2 = 0;
        if (a.length < 1) {
            return 0;
        }
        for (int i = 0; i < a.length; i++) {
            verdi1 = a[i];
            for (int j = i + 1; j < a.length; j++) {
                verdi2 = a[j];
                if (verdi1 == verdi2) {
                    count--;
                    break;
                }

            }
        }
        return count;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a){
        int countO = 0;
        //Oddetall sorteres til venstre
        for(int i = 0; i < a.length; i++){
            if(a[i]%2 != 0){
                bytt(a,countO,i);
                countO++;
            }
        }
        if (countO == 0 || countO == a.length){
            Arrays.sort(a);
        }
        else {
            Arrays.sort(a,0,countO);
            Arrays.sort(a,countO,a.length);
        }
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new NotImplementedException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new NotImplementedException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new NotImplementedException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new NotImplementedException();
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NotImplementedException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new NotImplementedException();
    }

}  // Oblig1
