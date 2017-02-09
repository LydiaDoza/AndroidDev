package com.jblearning.tipcalculatorv4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private TipCalculator tipCalc;
    public NumberFormat money = NumberFormat.getCurrencyInstance( );
    private EditText billEditText;
    private EditText tipEditText;
    private EditText numberOfGuestsEditText;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        tipCalc = new TipCalculator( 0.17f, 100.0f );
        setContentView( R.layout.activity_main );

        billEditText = ( EditText ) findViewById( R.id.amount_bill );
        tipEditText = ( EditText ) findViewById( R.id.amount_tip_percent );
        numberOfGuestsEditText = (EditText) findViewById(R.id.number_of_guests);

        TextChangeHandler tch = new TextChangeHandler( );
        billEditText.addTextChangedListener( tch );
        tipEditText.addTextChangedListener(tch);
        numberOfGuestsEditText.addTextChangedListener(tch);
    }

    public void calculate( ) {
        String billString = billEditText.getText( ).toString( );
        String tipString = tipEditText.getText( ).toString( );
        String numGuestString = numberOfGuestsEditText.getText().toString();

        TextView tipTextView =
                ( TextView ) findViewById( R.id.amount_tip );
        TextView totalTextView =
                (TextView) findViewById( R.id.amount_total );
        TextView guestTipTextView = (TextView)findViewById(R.id.tip_per_guest);
        TextView guestTotalTextView = (TextView)findViewById(R.id.total_per_guest);

        try {
            // convert billString and tipString to floats
            float billAmount = Float.parseFloat( billString );
            int tipPercent = Integer.parseInt( tipString );
            int guests = Integer.parseInt(numGuestString);

            // update the Model
            tipCalc.setBill( billAmount );
            tipCalc.setTip( .01f * tipPercent );
            tipCalc.setGuests(guests);

            // ask Model to calculate tip and total amounts
            float tip = tipCalc.tipAmount();
            float total = tipCalc.totalAmount();
            float tipGuest = tipCalc.tipGuestAmount();
            float totalGuest = tipCalc.totalAmountPerGuest();

            // update the View with formatted tip and total amounts
            tipTextView.setText( money.format( tip ) );
            totalTextView.setText( money.format( total ) );
            guestTipTextView.setText(money.format(tipGuest));
            guestTotalTextView.setText(money.format(totalGuest));

        } catch( NumberFormatException nfe ) {
            // pop up an alert view here

        }
    }

    private class TextChangeHandler implements TextWatcher {
        public void afterTextChanged( Editable e ) {
            calculate( );
        }

        public void beforeTextChanged( CharSequence s, int start,
                                       int count, int after ) {
        }

        public void onTextChanged( CharSequence s, int start,
                                   int before, int after ) {
        }
    }
}
