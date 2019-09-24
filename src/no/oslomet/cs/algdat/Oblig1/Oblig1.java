package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

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
                bytt(a, i, i + 1);
            }
        }
        return a[a.length - 1];
    }

    //Oppgave 1 b)
    public static int ombyttinger(int[] a) {
        if (a.length < 1)
            throw new NoSuchElementException("Listen er tom");
        int count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                bytt(a, i, i + 1);
                count++;
            }
        }
        return count;
    }

    public static void bytt(int[] a, int fra, int til) {
        int temp = a[fra];
        a[fra] = a[til];
        a[til] = temp;
    }

    /*  Sporsmal oppgave 1:

      i)·Nar blir det flest ombyttinger?
         Nar det tabellen er sortert synkynde.

      ii)·Nar blir det faerrest?
          Nar tabellen er sortert stigende.

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
                throw new IllegalStateException("Array er ikke sortert i stigende rekkfølge");
            }

        }
        return count;
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        int count = a.length;

        int verdi1 = 0;
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
    public static int parter(int []a, int v,int h, int skilleverdi){
        while (true)                                  // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) bytt(a,v++,h--);                 // bytter om a[v] og a[h]
            else  return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }
    private static int sparter0(int []a, int v, int h, int indeks){
        bytt(a,indeks,h); // indeks er skilleverdi
        int pos = parter(a,v,h-1,a[h]); //partisjoner a[v:h-1]
        bytt(a,pos,h);// bytt for åfå skilleverdi på rett plass
        return pos;
    }
    private static void kvikksortering0(int[] a, int v, int h)  // en privat metode
    {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = sparter0(a, v, h, (v + h)/2);  // bruker midtverdien
        kvikksortering0(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        kvikksortering0(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }
    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    public static void kvikksortering(int[] a, int fra, int til) // a[fra:til>
    {
        fratilKontroll(a.length, fra, til);  // sjekker når metoden er offentlig
        kvikksortering0(a, fra, til - 1);  // v = fra, h = til - 1
    }

    public static void kvikksortering(int[] a)   // sorterer hele tabellen
    {
        kvikksortering0(a, 0, a.length - 1);
    }
    public static void delsortering(int[] a) {
        int countO = 0;
        //Oddetall sorteres til venstre
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0) {
                bytt(a, countO, i);
                countO++;
            }
        }
        if (countO == 0 || countO == a.length) {
            kvikksortering (a);
        } else {
            kvikksortering(a, 0, countO);
            kvikksortering(a, countO, a.length);
        }
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        if (a.length == 0) {
            return;
        }
        char sist;


        sist = a[a.length - 1];

        for (int j = a.length - 1; j > 0; j--) {

            a[j] = a[j - 1];
        }

        a[0] = sist;
        System.out.print(Arrays.toString(a));
    }


    ///// Oppgave 6 //////////////////////////////////////
    public static void bytt(char[] a, int i, int j)
    {
        char temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
    public static void rotasjon(char[] a, int d) {
        int n = a.length;
        if (n < 2) return;                                     // tomt eller en verdi

        if ((d %= n) < 0) d += n;                              // motsatt vei?

        for (int v = 0, h = n - 1; v < h; bytt(a, v++, h--));  // snur a[a:n>
        for (int v = 0, h = d - 1; v < h; bytt(a, v++, h--));  // snur a[0:d>
        for (int v = d, h = n - 1; v < h; bytt(a, v++, h--));  // snur a[d:n>

    }


    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        String resultat = "";
        int minstlength = (s.length() < t.length()) ? s.length() : t.length();
        int indeks;

        if (s.length() == 0) {
            resultat = t;
            return resultat;
        } else if (t.length() == 0) {
            resultat = s;
            return resultat;
        }

        for (indeks = 0; indeks < minstlength; indeks++) {
            resultat = resultat + s.charAt(indeks) + t.charAt(indeks);
        }

        if (s.length() > t.length()) {
            for (; indeks < s.length(); ++indeks) {
                resultat = resultat + s.charAt(indeks);
            }
        } else if (s.length() < t.length()) {

            for (; indeks < t.length(); ++indeks) {
                resultat = resultat + t.charAt(indeks);
            }

        }
        return resultat;
    }

    /// 7b)
    public static String flett(String... l) {
        int str = 0;
        if (l.length == 0) return "";

        StringBuilder obj = new StringBuilder();

        for (int x = 0; x < l.length; x++) {
            if (l[x].length() > str) {
                str = l[x].length();
            }
        }

        for (int i = 1; i <= str; i++) {
            for (int j = 0; j < l.length; j++) {
                if (i <= l[j].length()) {
                    obj.append(l[j].charAt(i - 1));
                }
            }
        }
        return obj.toString();
    }


    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {

        int[] temp_a = new int[a.length];
        int[] indeks_a = new int[a.length];
        int minst_indeks = 0;
        //int  []temp_a =  a. Arrays.copyOf(a, a.length);
        for (int e = 0; e < a.length; e++) {
            temp_a[e] = a[e];
        }//kopiere a til en temp ararry

        if (a.length == 0) return a;
        for (int j = 0; j < temp_a.length; j++) {

            for (int i = 0; i < temp_a.length; i++) {
                if (temp_a[minst_indeks] > temp_a[i])
                    minst_indeks = i; //&& minst_indeks!=i      lagre indeksen til miste verdi
            }
            indeks_a[j] = minst_indeks; //legge   minsteverdis indeksen til arrayen som skal retuneres
            temp_a[minst_indeks] = 2147483647; //bytte verdi til  minsteverdis indeksen slik at vi
        }

        return indeks_a;


    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        int n = a.length;     // tabellens lengde

        if (n < 3)     // må ha minst tre verdier
        {
            throw new NoSuchElementException("a.length(" + n + ") < 3!");
        }

        int m = 0;     // m er posisjonen til min verdi
        int nm = 1;    // nm er posisjonen til nest min verdi
        int tm = 2;    // tm er posisjonen til tredje min verdi


        if (a[nm] < a[m]) {
            m = 1;
            nm = 0;
        }

        if (a[tm] < a[m]) {
            int temp = tm;
            tm = m;
            m = temp;
        }

        if (a[tm] < a[nm]) {
            int temp = tm;
            tm = nm;
            nm = temp;
        }

        int minVerdi = a[m];                // min verdi
        int nestminVerdi = a[nm];           // nest min verdi
        int tredjeminVerdi = a[tm];         // tredje min verdi

        for (int i = 3; i < n; i++) {
            int verdi = a[i];

            if (verdi < tredjeminVerdi) {
                if (verdi < nestminVerdi) {
                    if (verdi < minVerdi) {
                        tm = nm;
                        tredjeminVerdi = nestminVerdi;

                        nm = m;
                        nestminVerdi = minVerdi;

                        m = i;
                        minVerdi = verdi;
                    } else  // verdi >= minverdi && verdi < nestminverdi
                    {
                        tm = nm;
                        tredjeminVerdi = nestminVerdi;

                        nm = i;
                        nestminVerdi = verdi;
                    }
                } else // verdi >= nestminverdi && verdi < tredjeminverdi
                {
                    tm = i;
                    tredjeminVerdi = verdi;
                }
            }

        }

        return new int[]{m, nm, tm};
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int parter1(char []a, int v,int h, int skilleverdi){
        while (true)                                  // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) bytt(a,v++,h--);                 // bytter om a[v] og a[h]
            else  return  v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }
    private static int sparter1(char []a, int v, int h, int indeks){
        bytt(a,indeks,h); // indeks er skilleverdi
       int pos = parter1(a,v, (h-1),a[h]); //partisjoner a[v:h-1]
        bytt(a,pos,h);// bytt for åfå skilleverdi på rett plass
        return pos;
    }

   public static void kvikksortering11(char[] a, int d, int s)  // en privat metode
    {
        if (d >= s) return;  // a[v:h] er tomt eller har maks ett element
        int k = sparter1(a, d, s, (d + s)/2);  // bruker midtverdien
        kvikksortering1(a, d, k - 1);     // sorterer intervallet a[v:k-1]
        kvikksortering1(a, k + 1, s);     // sorterer intervallet a[k+1:h]
    }

    public static void kvikksortering1(char[] a, int fra, int til) // a[fra:til>
    {
      //  fratilKontroll(a.length, fra, til);  // sjekker når metoden er offentlig
        kvikksortering1(a, fra, til - 1);  // v = fra, h = til - 1
    }

    public static void kvikksortering1(char[] a)   // sorterer hele tabellen
    {
        kvikksortering1(a, 0, a.length - 1);
    }
    public static boolean inneholdt(String a, String b) {

        if (a.length() > b.length()) return false;

        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();


        kvikksortering1(a1);
        kvikksortering1(b1);

        int i = 0;
        int j = 0;

        while (i < a1.length && j < b1.length) {
            if (a1[i] > b1[j]) j++;
            else if (a1[i] == b1[j]) {
                i++;
                j++;
            } else return false;
        }

        return i == a1.length;
    }

}  // Oblig1