package com.nickkbright.smp;

public class StableMarriageProblem {

    private int N, engagedCount;
    private String[][] menPref;
    private String[][] womenPref;
    private String[] men;
    private String[] women;
    private String[] womenPartner;
    private boolean[] menEngaged;

    public StableMarriageProblem(String[] m, String[] w, String[][] mp, String[][] wp) {
        N = mp.length;
        engagedCount = 0;
        men = m;
        women = w;
        menPref = mp;
        womenPref = wp;
        menEngaged = new boolean[N];
        womenPartner = new String[N];
    }

    public void calcMatches() {
        while (engagedCount < N) {
            int free;
            for (free = 0; free < N; free++) {
                if (!menEngaged[free]) {
                    break;
                }
            }

            for (int i = 0; i < N && !menEngaged[free]; i++) {
                int index = getWomenIndex(menPref[free][i]);
                if (womenPartner[index] == null) {
                    womenPartner[index] = men[free];
                    menEngaged[free] = true;
                    engagedCount++;
                }
                else {
                    String currentPartner = womenPartner[index];
                    if (anotherPreference(currentPartner, men[free], index)) {
                        womenPartner[index] = men[free];
                        menEngaged[free] = true;
                        menEngaged[getMenIndex(currentPartner)] = false;
                    }
                }
            }
        }
        showCouples();
    }
    private boolean anotherPreference(String curPartner, String newPartner, int index) {
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
    private int getMenIndex(String str) {
        for (int i = 0; i < N; i++) {
            if (men[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }
    // get women index
    private int getWomenIndex(String str) {
        for (int i = 0; i < N; i++) {
            if (women[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }
    // print couples
    public void showCouples() {
        for (int i = 0; i < N; i++) {
            System.out.println(womenPartner[i] +" & "+ women[i]);
        }
    }


}