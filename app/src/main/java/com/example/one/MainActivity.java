package com.example.one;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
        private int player = 0;
//        private int scoreRed = 0;
//        private int scoreBlue = 0;
    int[] gameState = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int[][] winningPositions = {
            {-1,0,12,13,3}, {-1,1,13,14,4},{-1,2,5,14,15},{-1,3,6,16,17},{-1,4,7,17,18},{-1,5,8,18,19},{-1,6,9,20,21},
            {-1,7,10,21,22},{-1,8,11,22,23}
    };
    boolean isActive = true;

    public void playagain(View v){
        Button playagainbutton = (Button)findViewById(R.id.playagain);
        playagainbutton.setVisibility(v.INVISIBLE);
        player = 0;
        int[] gameStatehere = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        gameState = gameStatehere;
        int[][] winningPositionshere = {
                {-1,0,12,13,3}, {-1,1,13,14,4},{-1,2,5,14,15},{-1,3,6,16,17},{-1,4,7,17,18},{-1,5,8,18,19},{-1,6,9,20,21},
                {-1,7,10,21,22},{-1,8,11,22,23}
        };
        winningPositions = winningPositionshere;
        TextView bluepoints = (TextView)findViewById(R.id.bluepoints);
        bluepoints.setText("Blue: 0");
        TextView redpoints = (TextView)findViewById(R.id.redpoints);
        redpoints.setText("Red: 0");
        isActive = true;
        TextView turns = (TextView) findViewById(R.id.turns);
        turns.setText("Red's turn");

        ImageView imageview = (ImageView)findViewById(R.id.imageView0);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView0);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView1);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView2);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView3);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView4);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView5);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView6);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView7);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView8);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView9);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView10);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView11);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView12);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView13);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView14);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView15);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView16);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView17);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView18);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView19);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView20);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView21);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView22);
        imageview.setImageResource(0);

        imageview = (ImageView)findViewById(R.id.imageView23);
        imageview.setImageResource(0);
    }

    public void dropImage(View v) {

        try{
            ImageView imageView = (ImageView) v;
            int state = Integer.parseInt(imageView.getTag().toString());
            TextView turns = (TextView) findViewById(R.id.turns);
            if (gameState[state] == -1 && isActive) {
                gameState[state] = player;
                imageView.setTranslationY(-2000);
                if (player == 0) {
                    imageView.setImageResource(R.color.Red);
                    player = 1;
                } else {
                    imageView.setImageResource(R.color.Blue);
                    player = 0;
                }
                imageView.animate().translationYBy(2000).setDuration(300);
                int indexToChange = -1;
                for(int i = 0; i<winningPositions.length; i++){
                    int[] winningPosition = winningPositions[i];
                //-1,0,12,13,3

                    if(gameState[winningPosition[4]] != -1 && gameState[winningPosition[1]] != -1
                            && gameState[winningPosition[2]] != -1 && gameState[winningPosition[3]] != -1 && winningPosition[0] == -1){
                        String winner = (player == 0) ? "Blue" : "Red";
                        if(winner == "Blue") {
                            TextView bluepoints = (TextView)findViewById(R.id.bluepoints);
                            String string2 = bluepoints.getText() + "";
                            String[] strings = string2.split(" ");
                            int scoreBlue = Integer.parseInt(strings[1]);
                            scoreBlue++;
                            bluepoints.setText("Blue: " + scoreBlue);
                            Toast.makeText(this, "Point for Blue", Toast.LENGTH_SHORT).show();
                        }else{
                            TextView redpoints = (TextView)findViewById(R.id.redpoints);
                            String string2 = redpoints.getText() + "";
                            String[] strings = string2.split(" ");
                            int scoreRed = Integer.parseInt(strings[1]);
                            scoreRed++;
                            redpoints.setText("Red: " + scoreRed);
                            Toast.makeText(this, "Point for Red", Toast.LENGTH_SHORT).show();
                        }
                        indexToChange = i;
                        //turns.setText("The Winner is " + winner);
                    }
                }
                if(indexToChange != -1){
                    int[] copied = winningPositions[indexToChange];
                    copied[0] = 1;
                    winningPositions[indexToChange] = copied;
                }
                boolean isDone = true;
                for(int numState: gameState){
                    if(numState == -1){
                        isDone = false;
                    }
                }
                TextView redpoints = (TextView)findViewById(R.id.redpoints);
                String string2 = redpoints.getText() + "";
                String[] strings = string2.split(" ");
                int scoreRed = Integer.parseInt(strings[1]);

                TextView bluepoints = (TextView)findViewById(R.id.bluepoints);
                string2 = bluepoints.getText() + "";
                strings = string2.split(" ");
                int scoreBlue = Integer.parseInt(strings[1]);
                if(isDone){
                    isActive = false;
                    if(scoreBlue<scoreRed){
                        turns.setText("The Winner is Red");
                    }else if(scoreBlue>scoreRed){
                        turns.setText("The Winner is Blue");
                    }else{
                        turns.setText("The Game is a tie!");
                    }
                    Button playagainbutton = (Button)findViewById(R.id.playagain);
                    playagainbutton.setVisibility(v.VISIBLE);
                }
                if(player == 0 && isActive){
                    turns.setText("Red's turn");
                }else if(player != 0 && isActive){
                    turns.setText("Blue's turn");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}