package edu.uisrael.inmersoft;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Encuesta extends AppCompatActivity {
    private Button mEcuesta;
    private TextView mUserName;
    private EditText mP1;
    private CheckBox chkSoccer, chkBike, chkWalk;
    private RadioButton rdbSi, rdbNo;
    private Context mContext;
    private AwesomeValidation awsValidacion;
    private Intent mIntent;
    private String userName;
    private String nameComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encuesta);
        mIntent = getIntent();
        userName = mIntent.getStringExtra(UserControler.USER_YEY);
        nameComplete = mIntent.getStringExtra(UserControler.NAME_COMPLETE);
        mContext = this;
        mUserName = (TextView) findViewById(R.id.userNameLogin);
        mUserName.setText(getString(R.string.username_title) + userName);

        mEcuesta = (Button) findViewById(R.id.button_Sig);
        //P1
        mP1 = (EditText) findViewById(R.id.p1);
        //P2
        chkSoccer = (CheckBox) findViewById(R.id.chkSoccer);
        chkBike = (CheckBox) findViewById(R.id.chkBike);
        chkWalk = (CheckBox) findViewById(R.id.chkWalk);
        //p3
        rdbSi = (RadioButton) findViewById(R.id.rdbOp1Yes);
        rdbNo = (RadioButton) findViewById(R.id.rdbOp1No);

        //awsValidacion = new AwesomeValidation(ValidationStyle.BASIC);
        //awsValidacion.addValidation(this, R.id.p1, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.empty_field);

        mEcuesta.setOnClickListener(new View.OnClickListener() {
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
        Intent intent = new Intent(mContext, Resumen.class);
        intent.putExtra(UserControler.USER_YEY, userName);
        intent.putExtra(UserControler.NAME_COMPLETE ,nameComplete );
        intent.putExtra(UserControler.P1_KEY_TXT ,mP1.getText().toString());
        intent.putExtra(UserControler.P2_KEY_SCC,chkSoccer.isChecked());
        intent.putExtra(UserControler.P2_KEY_BK,chkBike.isChecked());
        intent.putExtra(UserControler.P2_KEY_WK,chkWalk.isChecked());
        intent.putExtra(UserControler.P3_KEY_OPT,rdbSi.isSelected()?true:false);
        startActivity(intent);
        finish();
    }
}
