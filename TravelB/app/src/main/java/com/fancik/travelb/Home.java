package com.fancik.travelb;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by Fandy TIC on 02/12/2017.
 */

public class Home extends AppCompatActivity {

    Button keluar;
    TextView txt_nohp;
    String nohp,id;
    SharedPreferences sharedpreferences;

    public static final String TAG_ID = "id";
    public static final String TAG_NOHP = "nohp";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_nohp = (TextView) findViewById(R.id.txt_nohp);
        keluar = (Button) findViewById(R.id.keluar);

        sharedpreferences = getSharedPreferences(MainActivity.my_shared_preferences, Context.MODE_PRIVATE);

        id = getIntent().getStringExtra(TAG_ID);
        nohp = getIntent().getStringExtra(TAG_NOHP);

        txt_nohp.setText(nohp);

        keluar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // update login session ke FALSE dan mengosongkan nilai id dan username
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(MainActivity.session_status, false);
                editor.putString(TAG_ID, null);
                editor.putString(TAG_NOHP, null);
                editor.commit();

                Intent intent = new Intent(Home.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }

    public void pilihtra(View view) {
        Intent i = new Intent(getApplicationContext(), PilihanTravelA.class);
        i.putExtra(TAG_ID, id);
        i.putExtra(TAG_NOHP, nohp);
        startActivity(i);
    }

    public void travelPadang(View view) {
        Intent i = new Intent(getApplicationContext(), PilihanTravelB.class);
        i.putExtra(TAG_ID, id);
        i.putExtra(TAG_NOHP, nohp);
        startActivity(i);
    }

    public void travelPadangPanjang(View view) {
        Intent i = new Intent(getApplicationContext(), PilihanTravelC.class);
        i.putExtra(TAG_ID, id);
        i.putExtra(TAG_NOHP, nohp);
        startActivity(i);
    }

    public void travelpayakumbuh(View view) {
        Intent i = new Intent(getApplicationContext(), PilihanTravelD.class);
        i.putExtra(TAG_ID, id);
        i.putExtra(TAG_NOHP, nohp);
        startActivity(i);
    }
}
