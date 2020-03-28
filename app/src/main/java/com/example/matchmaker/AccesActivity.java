package com.example.matchmaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccesActivity extends Activity {

    private Button help_button, login_button, register_button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acces);

        help_button     = findViewById(R.id.ConfigAccessActivity);
        login_button    = findViewById(R.id.Login);
        register_button = findViewById(R.id.Register);

        help_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToHelpActivity();
            }
        });
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToLoginActivity();
            }
        });
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToRegisterActivity();
            }
        });
    }

    private void moveToRegisterActivity() {
        Intent intent = new Intent(AccesActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    private void moveToLoginActivity() {
        Intent intent = new Intent(AccesActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    private void moveToHelpActivity() {
        Intent intent = new Intent(AccesActivity.this, HelpActivity.class);
        startActivity(intent);
    }

}
