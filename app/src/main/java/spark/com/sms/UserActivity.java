package spark.com.sms;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import spark.com.sms.model.User;
import spark.com.sms.util.DbHandler;

public class UserActivity extends AppCompatActivity {

    private EditText editTextusername;
    private EditText editTextemail;
    String userName;
    String userEmail;

    private Button buttonLogin;
    DbHandler userDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        editTextusername = (EditText) findViewById(R.id.editTextUsername);
        editTextemail = (EditText) findViewById(R.id.editTextEmail);
        buttonLogin = (Button) findViewById(R.id.buttonSubmit);
        userDatabase = new DbHandler(this);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = editTextusername.getText().toString().trim();
                userEmail = editTextemail.getText().toString().trim();
                User user = new User();
                user.setUsername(userName);
                user.setEmail(userEmail);
                userDatabase.addUser(user);
                startActivity(new Intent(UserActivity.this, MainActivity.class));

            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
