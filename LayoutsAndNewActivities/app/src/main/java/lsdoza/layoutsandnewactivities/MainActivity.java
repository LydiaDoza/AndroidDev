package lsdoza.layoutsandnewactivities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // reference to this
        RelativeLayout relativeLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams layoutParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        relativeLayout.setLayoutParams(layoutParams);

        relativeLayout.setBackgroundColor(Color.BLUE);

        setContentView(relativeLayout);

        /* 5. Create widgets */
        final TextView textView = new TextView(this);
        textView.setId(R.id.textView);
        textView.setTextSize(24);
        textView.setTextColor(Color.MAGENTA);

        // will access from onclick handler
        // you'll need it to be final/constant
        final Button button = new Button(this);
        button.setId(R.id.button);
        button.setText(R.string.btnClickMe);

        // create params for the widgets
        RelativeLayout.LayoutParams textViewParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        textView.setLayoutParams(textViewParams); // by reference
        button.setLayoutParams(buttonParams);

        // Rules for positioning
        textViewParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.addRule(RelativeLayout.BELOW, R.id.textView);
        buttonParams.setMargins(0, 100, 0, 0);//left, top, right, bottom
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        // add these to the views
        relativeLayout.addView(textView, textViewParams);
        relativeLayout.addView(button, buttonParams);

        // new View.OnClick... being passed as a parameter
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("You clicked the button");
            }
        });

    }
}
