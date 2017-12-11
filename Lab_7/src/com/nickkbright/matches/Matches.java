package com.nickkbright.matches;

public class Matches {

    private int N, engagedCount;
    private String[][] menPref;
    private String[][] womenPref;
    private String[] men;
    private String[] women;
    private String[] womenPartner;
    private boolean[] menEngaged;

    public Matches(String[] m, String[] w, String[][] mp, String[][] wp) {
        N = mp.length;
        engagedCount = 0;
        men = m;
        women = w;
        menPref = mp;
        womenPref = wp;
        menEngaged = new boolean[N];
        womenPartner = new String[N];
        calcMatches();
    }

    // function to calculate all matches
    private void calcMatches() {
        while (engagedCount < N) {
            int free;
            for (free = 0; free < N; free++) {
                if (!menEngaged[free]) {
                    break;
                }
            }

            for (int i = 0; i < N && !menEngaged[free]; i++) {
                int index = womenIndexOf(menPref[free][i]);
                if (womenPartner[index] == null) {
                    womenPartner[index] = men[free];
                    menEngaged[free] = true;
                    engagedCount++;
                }
                else {
                    String currentPartner = womenPartner[index];
                    if (morePreference(currentPartner, men[free], index)) {
                        womenPartner[index] = men[free];
                        menEngaged[free] = true;
                        menEngaged[menIndexOf(currentPartner)] = false;
                    }
                }
            }
        }
        printCouples();
    }
    // function to check if women prefers new partner over old assigned partner
    private boolean morePreference(String curPartner, String newPartner, int index) {
        for (int i = 0; i < N; i++) {
            if (womenPref[index][i].equals(newPartner)) {
                return true;
            }
            if (womenPref[index][i].equals(curPartner)) {
                return false;
            }
        }
        return false;
    }
    // get men index
    private int menIndexOf(String str) {
        for (int i = 0; i < N; i++) {
            if (men[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }
    // get women index
    private int womenIndexOf(String str) {
        for (int i = 0; i < N; i++) {
            if (women[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }
    // print couples
    public void printCouples() {
        for (int i = 0; i < N; i++) {
            System.out.println(womenPartner[i] +" "+ women[i]);
        }
    }


}