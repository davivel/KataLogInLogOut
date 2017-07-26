package com.karumi.training.kataloginlogout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    private Button logInButton;
    private EditText usernameField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        logInButton = (Button)findViewById(R.id.logInButton);
        usernameField = (EditText)findViewById(R.id.username);
        passwordField = (EditText)findViewById(R.id.password);

        usernameField.addTextChangedListener(
            new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    LogInActivity.this.updateLogInButtonState();
                }
            }
        );

        passwordField.addTextChangedListener(
            new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    LogInActivity.this.updateLogInButtonState();
                }
            }
        );

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (new ApiClient(new Clock()).login(
                        usernameField.getText().toString(),
                        passwordField.getText().toString()
                    )) {
                    startActivity(new Intent(LogInActivity.this, LogOutActivity.class));

                } else {
                    Toast.makeText(LogInActivity.this, "Ups!", Toast.LENGTH_SHORT).show();
                }
            }
        });

}

    private void updateLogInButtonState() {
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        logInButton.setEnabled(!username.isEmpty() && !password.isEmpty());
    }
}
