package edu.uisrael.inmersoft;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity {
    private Button mRegistro;
    private TextView mUserName;
    private EditText mName;
    private EditText mAmountInitial;
    private EditText mPayMount;
    private Context mContext;
    private Intent mIntent;
    private String userName;
    private AwesomeValidation awsValidacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        mContext = this;
        mIntent = getIntent();
        userName = mIntent.getStringExtra(UserControler.USER_YEY);
        mRegistro = (Button) findViewById(R.id.button_save);
        mUserName = (TextView) findViewById(R.id.userNameLogin);
        mUserName.setText(getString(R.string.username_title).toString() + userName);
        mName = (EditText) findViewById(R.id.name);
        mAmountInitial = (EditText) findViewById(R.id.amontInitial);
        mPayMount = (EditText) findViewById(R.id.payMonth);

        awsValidacion = new AwesomeValidation(ValidationStyle.BASIC);
        awsValidacion.addValidation(this, R.id.name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.empty_field);
        awsValidacion.addValidation(this, R.id.amontInitial, "^*[0-9\\\\.]+$", R.string.empty_field);
        awsValidacion.addValidation(this, R.id.payMonth, "^*[0-9\\\\.]+$", R.string.empty_field);

        mRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (awsValidacion.validate())
                {
                    next();
                }
            }
        });
    }

    private void next() {
        Toast.makeText(mContext, R.string.save_message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(mContext, Encuesta.class);
        intent.putExtra(UserControler.USER_YEY,userName);
        intent.putExtra(UserControler.NAME_COMPLETE, mName.getText().toString());
        startActivity(intent);
        finish();
    }
}