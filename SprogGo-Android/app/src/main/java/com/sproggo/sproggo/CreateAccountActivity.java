package com.sproggo.sproggo;

import android.content.Intent;
import android.content.SharedPreferences;
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
                if (email.getText().toString().equals(repeatEmail.getText().toString()) && password.getText().toString().equals(repeatPassword.getText().toString())) {
                    PlayerList.createAccount(username.getText().toString(), password.getText().toString(), email.getText().toString());
                    SharedPreferences pref = getSharedPreferences("sproggo", 0);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString(username.getText().toString(), password.getText().toString());
                    editor.commit();
                    startActivity(new Intent(CreateAccountActivity.this, MainActivity.class));
                }
            }
        });
    }
}
