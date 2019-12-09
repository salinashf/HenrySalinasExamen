package edu.uisrael.inmersoft;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Resumen extends AppCompatActivity {
    private Button mSalir;
    private TextView mUserName;
    private TextView mName;
    private TextView mResumen;
    private Context mContext;
    private Intent mIntent;
    private String userName;
    private String nameComplete;
    private StringBuilder resumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.resumen);
        mContext = this;
        mIntent = getIntent();
        userName = mIntent.getStringExtra(UserControler.USER_YEY);
        nameComplete = mIntent.getStringExtra(UserControler.NAME_COMPLETE);

        mUserName = (TextView) findViewById(R.id.userNameLogin);
        mUserName.setText(getString(R.string.username_title) + userName);

        mName = (TextView) findViewById(R.id.nameComplete);
        mName.setText(getString(R.string.name_title).toString() + nameComplete);

        mResumen = (TextView) findViewById(R.id.resumenEncuesta);

        resumen = new StringBuilder();
        resumen.append(getString(R.string.resumen_title));
        resumen.append("\n");

        resumen.append(getString(R.string.encuesta_P1));
        resumen.append("\n");
        resumen.append(mIntent.getStringExtra(UserControler.P1_KEY_TXT));

        resumen.append("\n");
        resumen.append(getString(R.string.encuesta_P2));
        resumen.append("\n");

        if (mIntent.getBooleanExtra(UserControler.P2_KEY_SCC, false)) {
            resumen.append(getString(R.string.encuesta_Soccer));
            resumen.append("\n");
        }

        if (mIntent.getBooleanExtra(UserControler.P2_KEY_BK, false)) {
            resumen.append(getString(R.string.encuesta_Bike));
            resumen.append("\n");
        }

        if (mIntent.getBooleanExtra(UserControler.P2_KEY_WK, false)) {
            resumen.append(getString(R.string.encuesta_Walk));
            resumen.append("\n");
        }

        resumen.append("\n");
        resumen.append(getString(R.string.encuesta_P3));
        resumen.append("\n");
        if (mIntent.getBooleanExtra(UserControler.P3_KEY_OPT, false)) {
            resumen.append(getString(R.string.encuesta_SI));
            resumen.append("\n");
        } else {
            resumen.append(getString(R.string.encuesta_NO));
            resumen.append("\n");
        }
        mResumen.setText(resumen.toString());
        mSalir = (Button) findViewById(R.id.button_exit);
        mSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}