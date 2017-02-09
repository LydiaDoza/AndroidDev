package lsdoza.petfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //determine what you're collecting from the user
        //name, email
        final EditText name = (EditText) findViewById(R.id.editName);
        final EditText email = (EditText) findViewById(R.id.editEmail);
        final EditText phone = (EditText) findViewById(R.id.editPhone);
        final EditText date = (EditText) findViewById(R.id.editDate);
        final EditText time = (EditText) findViewById(R.id.editTime);
        final EditText quest = (EditText) findViewById(R.id.editComments);

        Button button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserData data =
                        new UserData(
                                name.getText().toString(),
                                phone.getText().toString(),
                                email.getText().toString(),
                                date.getText().toString(),
                                time.getText().toString(),
                                quest.getText().toString());

                Intent intent = new Intent(getBaseContext(), Confirmation.class);
                intent.putExtra("UserData",data);
                startActivity(intent);
            }
        });

        //


        //


    }
}
