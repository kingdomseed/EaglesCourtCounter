package org.holtnet.eaglescourtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void threePointAdd(View view) {
        if (view.getId() == R.id.teamAThree) {
            scoreTeamA += 3;
            displayForTeamA(scoreTeamA);
        }
        if (view.getId() == R.id.teamBThree) {
            scoreTeamB += 3;
            displayForTeamB(scoreTeamB);
        }
    }

    public void twoPointAdd(View view) {
        if (view.getId() == R.id.teamATwo) {
            scoreTeamA += 2;
            displayForTeamA(scoreTeamA);
        }
        if (view.getId() == R.id.teamBTwo) {
            scoreTeamB += 2;
            displayForTeamB(scoreTeamB);
        }
    }

    public void freeThrowAdd(View view) {
        if (view.getId() == R.id.teamAFree) {
            scoreTeamA++;
            displayForTeamA(scoreTeamA);
        }
        if (view.getId() == R.id.teamBFree) {
            scoreTeamB++;
            displayForTeamB(scoreTeamB);
        }
    }

    public void resetButton(View view) {
        scoreTeamB = 0;
        scoreTeamA = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
