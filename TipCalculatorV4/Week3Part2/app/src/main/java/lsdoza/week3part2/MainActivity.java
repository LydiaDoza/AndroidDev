package lsdoza.week3part2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private lsdoza.week3part2.BlackJack blackJack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        blackJack = new BlackJack();
        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams layoutParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);

        relativeLayout.setLayoutParams(layoutParams);
        setContentView(relativeLayout);



        final TextView card1 = new TextView(this);
        card1.setId(R.id.card1);
        card1.setText(R.string.labelCard1);
        card1.setTextSize(30);

        RelativeLayout.LayoutParams card1Params =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        card1Params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        card1.setLayoutParams(card1Params);

        final TextView card2 = new TextView(this);
        card2.setId(R.id.card2);
        card2.setText(R.string.labelCard2);
        card2.setTextSize(30);

        RelativeLayout.LayoutParams card2Params =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        card2Params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        card2Params.addRule(RelativeLayout.BELOW, R.id.card1);
        card2.setLayoutParams(card2Params);

        final TextView card3 = new TextView(this);
        card3.setId(R.id.card3);
        card3.setText(R.string.labelCard3);
        card3.setTextSize(30);

        RelativeLayout.LayoutParams card3Params =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        card3Params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        card3Params.addRule(RelativeLayout.BELOW, R.id.card2);
        card3.setLayoutParams(card3Params);


        final Button drawButton = new Button(this);
        drawButton.setId(R.id.drawButton);
        drawButton.setText(R.string.textDrawButton);
        drawButton.setTextSize(35);

        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        drawButton.setLayoutParams(buttonParams);


        final TextView total = new TextView(this);
        total.setId(R.id.total);
        total.setText(R.string.textTotal);
        total.setTextSize(32);

        RelativeLayout.LayoutParams totalParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        totalParams.addRule(RelativeLayout.ABOVE, R.id.drawButton);
        totalParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        total.setLayoutParams(totalParams);

        drawButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (blackJack.GetTotal() < 15) {
                    blackJack.DrawCard3();
                    TextView card3 = (TextView) findViewById(R.id.card3);
                    TextView total = (TextView) findViewById(R.id.total);
                    card3.setText(String.format("%d",blackJack.GetCard3()));
                    total.setText(String.format("%d",blackJack.GetTotal()));
                }
            }
        });

        card1.setText(Integer.toString(blackJack.GetCard1()));
        card2.setText(Integer.toString(blackJack.GetCard2()));
        total.setText(Integer.toString(blackJack.GetTotal()));
    }
}
