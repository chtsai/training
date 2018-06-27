package com.example.demo;

public class Tennis {

    private String[] players = {"joey", "joseph"};

    private int[] scores = {0, 0};

    public Tennis() {

    }

    public void add1Point(int index) {
        scores[index] += 1;
    }

    public void setPoints(int point1, int point2) {
        scores[0] = point1;
        scores[1] = point2;
    }

    public String getScore() {
        int diff = Math.abs(scores[0]-scores[1]);

        String[] stringMap = {"love", "fifteen", "thirty", "forty"};

        switch (diff) {
            case 0:
                if (scoreZero()) {
                    return "love all";
                } else if (scoreOne()) {
                    return "fifteen all";
                } else if (scores[0] == 2) {
                    return "thirty all";
                } else {
                    return "deuce";
                }
            case 1:
                if (scores[0] < stringMap.length && scores[1] < stringMap.length) {
                    return stringMap[scores[0]] + " " + stringMap[scores[1]];
                } else {
                    return scores[0]>scores[1] ? players[0]+" adv" : players[1] + " adv";
                }
            case 2:
            default:
                if (scores[0] > 3 || scores[1] > 3) {
                    return scores[0] > scores[1] ? players[0] + " win" : players[1] + " win";
                } else {
                    return stringMap[scores[0]] + " " + stringMap[scores[1]];
                }
        }
    }

    private boolean scoreZero() {
        return scores[0] == 0;
    }

    private boolean scoreOne() {
        return scores[0] == 1;
    }
}
