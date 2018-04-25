package org.holtnet.eaglescourtcounter;

public class Team {

    private int score;

    public Team()
    {
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addPoints(int points) {
        score += points;
    }
}
