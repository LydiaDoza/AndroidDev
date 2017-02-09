package lsdoza.petfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import junit.framework.Test;

import org.w3c.dom.Text;

public class Confirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        UserData data = (UserData) getIntent().getSerializableExtra("UserData");

        TextView name = (TextView) findViewById(R.id.NameConfirm);
        TextView email = (TextView) findViewById(R.id.EmailConfirm);
        TextView phone = (TextView) findViewById(R.id.PhoneConfirm);
        TextView date = (TextView) findViewById(R.id.DateConfirm);
        TextView time = (TextView) findViewById(R.id.TimeConfirm);
        TextView comments = (TextView) findViewById(R.id.QuestionConfirm);

        name.setText(data.getName());
        email.setText(data.getEmailAddress());
        phone.setText(data.getPhoneNumber());
        date.setText(data.getDate());
        time.setText(data.getTime());
        comments.setText(data.getCommentsOrQuestions());

    }
}
