package com.nickkbright.matches;
public class Main {
    public static void main(String[] args) {
        System.out.println("Gale Shapley Marriage Algorithm\n");

        // list of men
        String[] m = {"M1", "M2", "M3", "M4", "M5"};

        // list of women
        String[] w = {"W1", "W2", "W3", "W4", "W5"};

        // men preference
        String[][] mp = {{"W5", "W2", "W3", "W4", "W1"},
                {"W2", "W5", "W1", "W3", "W4"},
                {"W4", "W3", "W2", "W1", "W5"},
                {"W1", "W2", "W3", "W4", "W5"},
                {"W5", "W2", "W3", "W4", "W1"}};

        // women preference
        String[][] wp = {{"M5", "M3", "M4", "M1", "M2"},
                {"M1", "M2", "M3", "M5", "M4"},
                {"M4", "M5", "M3", "M2", "M1"},
                {"M5", "M2", "M1", "M4", "M3"},
                {"M2", "M1", "M4", "M3", "M5"}};

        Matches gs = new Matches(m, w, mp, wp);
    }
}
