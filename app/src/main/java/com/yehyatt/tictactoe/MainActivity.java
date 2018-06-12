package com.yehyatt.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{


    Button block1, block2, block3, block4, block5, block6, block7, block8, block9, restart;
    TextView result;

    int[] SelectedLocations = new int[9];
    int CurrentPlayer = 1;
    int numberOfMoves = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ////Ads/////////
        MobileAds.initialize(this, "ca-app-pub-7056772252838511~4864726405");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-7056772252838511/1510714419");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        /////////////////////////////

        block1 = (Button) findViewById(R.id.bt_block1);
        block1.setOnClickListener(this);

        block2 = (Button) findViewById(R.id.bt_block2);
        block2.setOnClickListener(this);

        block3 = (Button) findViewById(R.id.bt_block3);
        block3.setOnClickListener(this);

        block4 = (Button) findViewById(R.id.bt_block4);
        block4.setOnClickListener(this);

        block5 = (Button) findViewById(R.id.bt_block5);
        block5.setOnClickListener(this);

        block6 = (Button) findViewById(R.id.bt_block6);
        block6.setOnClickListener(this);

        block7 = (Button) findViewById(R.id.bt_block7);
        block7.setOnClickListener(this);

        block8 = (Button) findViewById(R.id.bt_block8);
        block8.setOnClickListener(this);

        block9 = (Button) findViewById(R.id.bt_block9);
        block9.setOnClickListener(this);

        restart = (Button) findViewById(R.id.bt_restart_game);
        restart.setOnClickListener(this);

        result = (TextView) findViewById(R.id.tv_show_result);

    }

    void RecordMove(int SelectedButton)
    {
        SelectedLocations[SelectedButton] = CurrentPlayer;
        numberOfMoves = numberOfMoves + 1;
        CheckIfPlayerIsWinner();
    }

    void CheckIfPlayerIsWinner()
    {

        if (SelectedLocations[0] == CurrentPlayer && SelectedLocations[1] == CurrentPlayer && SelectedLocations[2] == CurrentPlayer)
        {
            endGame(CurrentPlayer, false);
        }
        else if (SelectedLocations[3] == CurrentPlayer && SelectedLocations[4] == CurrentPlayer && SelectedLocations[5] == CurrentPlayer)
        {
            endGame(CurrentPlayer, false);
        }
        else if (SelectedLocations[6] == CurrentPlayer && SelectedLocations[7] == CurrentPlayer && SelectedLocations[8] == CurrentPlayer)
        {
            endGame(CurrentPlayer, false);
        }
        else if (SelectedLocations[2] == CurrentPlayer && SelectedLocations[5] == CurrentPlayer && SelectedLocations[8] == CurrentPlayer)
        {
            endGame(CurrentPlayer, false);
        }
        else if (SelectedLocations[1] == CurrentPlayer && SelectedLocations[4] == CurrentPlayer && SelectedLocations[7] == CurrentPlayer)
        {
            endGame(CurrentPlayer, false);
        }
        else if (SelectedLocations[0] == CurrentPlayer && SelectedLocations[3] == CurrentPlayer && SelectedLocations[6] == CurrentPlayer)
        {
            endGame(CurrentPlayer, false);
        }
        else if (SelectedLocations[2] == CurrentPlayer && SelectedLocations[4] == CurrentPlayer && SelectedLocations[6] == CurrentPlayer)
        {
            endGame(CurrentPlayer, false);
        }
        else if (SelectedLocations[0] == CurrentPlayer && SelectedLocations[4] == CurrentPlayer && SelectedLocations[8] == CurrentPlayer)
        {
            endGame(CurrentPlayer, false);
        }
        else if (numberOfMoves == 9)
        {
            endGame(CurrentPlayer, true);
        }
        else
        {
            if (CurrentPlayer == 1)
            {
                CurrentPlayer = 2;
                result.setText(R.string.player_1_move);
            }
            else
            {
                CurrentPlayer = 1;
                result.setText(R.string.player_2_move);
            }
        }


    }

    void endGame(int winningPlayer, boolean isTie)
    {
        if (isTie)
        {
            result.setText(R.string.draw);
        }
        else if(winningPlayer == 1)
        {
            result.setText(R.string.player_1_wins);
        }
        else if(winningPlayer == 2)
        {
            result.setText(R.string.player_2_wins);
        }

        block1.setEnabled(false);
        block2.setEnabled(false);
        block3.setEnabled(false);
        block4.setEnabled(false);
        block5.setEnabled(false);
        block6.setEnabled(false);
        block7.setEnabled(false);
        block8.setEnabled(false);
        block9.setEnabled(false);
    }

    void restartGame()
    {
        SelectedLocations = new int[9];
        CurrentPlayer = 1;
        numberOfMoves = 0;

        block1.setEnabled(true);
        block2.setEnabled(true);
        block3.setEnabled(true);
        block4.setEnabled(true);
        block5.setEnabled(true);
        block6.setEnabled(true);
        block7.setEnabled(true);
        block8.setEnabled(true);
        block9.setEnabled(true);


        block1.setText("");
        block2.setText("");
        block3.setText("");
        block4.setText("");
        block5.setText("");
        block6.setText("");
        block7.setText("");
        block8.setText("");
        block9.setText("");
        result.setText("");

    }

    String GetButtonText()
    {
        if (CurrentPlayer == 1)
        {
            return "X";
        }
        else
        {
            return "O";
        }
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.bt_block1:
                block1.setText(GetButtonText());
                block1.setEnabled(false);
                RecordMove(0);
                break;
            case R.id.bt_block2:
                block2.setText(GetButtonText());
                block2.setEnabled(false);
                RecordMove(1);
                break;
            case R.id.bt_block3:
                block3.setText(GetButtonText());
                block3.setEnabled(false);
                RecordMove(2);
                break;
            case R.id.bt_block4:
                block4.setText(GetButtonText());
                block4.setEnabled(false);
                RecordMove(3);
                break;
            case R.id.bt_block5:
                block5.setText(GetButtonText());
                block5.setEnabled(false);
                RecordMove(4);
                break;
            case R.id.bt_block6:
                block6.setText(GetButtonText());
                block6.setEnabled(false);
                RecordMove(5);
                break;
            case R.id.bt_block7:
                block7.setText(GetButtonText());
                block7.setEnabled(false);
                RecordMove(6);
                break;
            case R.id.bt_block8:
                block8.setText(GetButtonText());
                block8.setEnabled(false);
                RecordMove(7);
                break;
            case R.id.bt_block9:
                block9.setText(GetButtonText());
                block9.setEnabled(false);
                RecordMove(8);
                break;
            case R.id.bt_restart_game:
                restartGame();
                break;
        }
    }
}
