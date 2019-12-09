package edu.uisrael.inmersoft;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private Button mLogin;
    private EditText mUsername;
    private EditText mPassword;
    private Context mContext;
    private UserControler mManager;
    private AwesomeValidation awsValidacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mManager = new UserControler(this);
        mContext = this;
        mLogin = (Button) findViewById(R.id.button_login);
        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        awsValidacion = new AwesomeValidation(ValidationStyle.BASIC);
        awsValidacion.addValidation(this, R.id.username, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.empty_field);
        awsValidacion.addValidation(this, R.id.password, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.empty_field);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (awsValidacion.validate())
                {
                    checkLogin();
                }
            }
        });
    }

    private void checkLogin() {
        String username = mUsername.getText().toString().trim().toLowerCase();
        String password = mPassword.getText().toString().trim();
        boolean isSuccess = mManager.checkLoginValidate(username, password);
        if (isSuccess) {
            Intent intent = new Intent(mContext, Registro.class);
            intent.putExtra(UserControler.USER_YEY, username);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(mContext, R.string.save_message, Toast.LENGTH_SHORT).show();
        }
    }
}