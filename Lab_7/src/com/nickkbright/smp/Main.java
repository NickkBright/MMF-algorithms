package com.nickkbright.smp;
public class Main {
    public static void main(String[] args) {
        System.out.println("Gale Shapley Marriage Algorithm\n");

        String[] man = {"John", "Adam", "Max", "Nick", "Stan"};

        String[] woman = {"Annie", "Kate", "Mary", "Lucy", "Sarah"};

        String[][] menPreference = {{woman[4], woman[1], woman[2], woman[3], woman[0]},
                                    {woman[1], woman[4], woman[0], woman[2], woman[3]},
                                    {woman[3], woman[2], woman[1], woman[0], woman[4]},
                                    {woman[0], woman[1], woman[2], woman[3], woman[4]},
                                    {woman[4], woman[1], woman[3], woman[0], woman[2]}};

        String[][] womenPreference = {{man[4], man[2], man[3], man[0], man[1]},
                                      {man[0], man[1], man[4], man[4], man[3]},
                                      {man[3], man[4], man[2], man[1], man[0]},
                                      {man[4], man[1], man[0], man[3], man[2]},
                                      {man[1], man[0], man[3], man[2], man[4]}};

        StableMarriageProblem findCouples = new StableMarriageProblem(man, woman, menPreference, womenPreference);
        findCouples.calcMatches();
    }
}
