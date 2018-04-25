package org.holtnet.eaglescourtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    static final String TEAM_A = "team_a";
    static final String TEAM_B = "team_b";
    private Team TeamA;
    private Team TeamB;

    @BindView(R.id.team_a_score) TextView scoreViewTeamA;
    @BindView(R.id.team_b_score) TextView scoreViewTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        TeamA = new Team();
        TeamB = new Team();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save custom values into the bundle
        savedInstanceState.putInt(TEAM_A, TeamA.getScore());
        savedInstanceState.putInt(TEAM_B, TeamB.getScore());
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        // Restore state members from saved instance
        TeamA.setScore(savedInstanceState.getInt(TEAM_A));
        TeamB.setScore(savedInstanceState.getInt(TEAM_B));
        displayForTeamA(TeamA.getScore());
        displayForTeamB(TeamB.getScore());
    }

    public void displayForTeamA(int score) {
        scoreViewTeamA.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        scoreViewTeamB.setText(String.valueOf(score));
    }

    public void addThreePoints(View view) {
        if (view.getId() == R.id.teamAThree) {
            TeamA.addPoints(3);
            displayForTeamA(TeamA.getScore());
        }
        if (view.getId() == R.id.teamBThree) {
            TeamB.addPoints(3);
            displayForTeamB(TeamB.getScore());
        }
    }

    public void addTwoPoints(View view) {
        if (view.getId() == R.id.teamATwo) {
            TeamA.addPoints(2);
            displayForTeamA(TeamA.getScore());
        }
        if (view.getId() == R.id.teamBTwo) {
            TeamB.addPoints(2);
            displayForTeamB(TeamB.getScore());
        }
    }

    public void addOnePoint(View view) {
        if (view.getId() == R.id.teamAFree) {
            TeamA.addPoints(1);
            displayForTeamA(TeamA.getScore());
        }
        if (view.getId() == R.id.teamBFree) {
            TeamB.addPoints(1);
            displayForTeamB(TeamB.getScore());
        }
    }

    public void resetScoreButton(View view) {
        TeamA.setScore(0);
        TeamB.setScore(0);
        displayForTeamA(TeamA.getScore());
        displayForTeamB(TeamB.getScore());
    }
}
