package com.sproggo.sproggo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Button button = findViewById(R.id.createAccount);
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        final EditText repeatPassword = findViewById(R.id.repeatPassword);
        final EditText email = findViewById(R.id.email);
        final EditText repeatEmail = findViewById(R.id.repeatEmail);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (repeatEmail.equals(email) && repeatPassword.equals(password)) {
                    PlayerList.createAccount(username, password, email);
                }
            }
        });
    }
}
