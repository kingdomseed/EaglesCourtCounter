package org.holtnet.eaglescourtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String TEAM_A = "team_a";
    static final String TEAM_B = "team_b";
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    private TextView scoreViewTeamA;
    private TextView scoreViewTeamB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save custom values into the bundle
        savedInstanceState.putInt(TEAM_A, scoreTeamA);
        savedInstanceState.putInt(TEAM_B, scoreTeamB);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        // Restore state members from saved instance
        scoreTeamA = savedInstanceState.getInt(TEAM_A);
        scoreTeamB = savedInstanceState.getInt(TEAM_B);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    public void displayForTeamA(int score) {
        scoreViewTeamA = findViewById(R.id.team_a_score);
        scoreViewTeamA.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        scoreViewTeamB = findViewById(R.id.team_b_score);
        scoreViewTeamB.setText(String.valueOf(score));
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
