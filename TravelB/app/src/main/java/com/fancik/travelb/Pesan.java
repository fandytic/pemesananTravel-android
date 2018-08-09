package com.fancik.travelb;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Fandy TIC on 03/12/2017.
 */

public class Pesan extends AppCompatActivity {
    TextView txt_nohp;
    String nohp,id;
    SharedPreferences sharedpreferences;

    public static final String TAG_ID = "id";
    public static final String TAG_NOHP = "nohp";

    private String TAG = Register.class.getSimpleName();
    private ProgressDialog pDialog;
    private EditText txt_jumlah, txt_nama, txt_alamat  ;
    private Spinner spinner, spinnerduduk;
    private Button btn_pesan;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pesan);

        txt_nohp = (TextView) findViewById(R.id.txt_nohp);

        sharedpreferences = getSharedPreferences(MainActivity.my_shared_preferences, Context.MODE_PRIVATE);

        id = getIntent().getStringExtra(TAG_ID);
        nohp = getIntent().getStringExtra(TAG_NOHP);

        txt_nohp.setText(nohp);

        txt_nama = (EditText) findViewById(R.id.txt_nama);
        txt_alamat = (EditText) findViewById(R.id.txt_alamat);
        txt_jumlah = (EditText) findViewById(R.id.txt_jumlah);
        spinnerduduk = (Spinner) findViewById(R.id.spinnerduduk);
        spinner = (Spinner) findViewById(R.id.spinner);

        btn_pesan = (Button) findViewById(R.id.btn_pesan);
        btn_pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SendContacts().execute();
                Intent i = new Intent(getApplicationContext(), Pembayaran.class);
                startActivity(i);
            }
        });

    }

    private class SendContacts extends AsyncTask<Void, Void,
            String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Pesan.this);
            pDialog.setMessage("Adding your data...");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        @Override
        protected String doInBackground(Void... params) {
            Pesanan pesanan = new Pesanan();
            pesanan.setNohp(txt_nohp.getText().toString());
            pesanan.setNama(txt_nama.getText().toString());
            pesanan.setAlamat(txt_alamat.getText().toString());
            pesanan.setJumlah(txt_jumlah.getText().toString());
            pesanan.setDuduk(spinnerduduk.getSelectedItem().toString());
            pesanan.setJam(spinner.getSelectedItem().toString());
            String result = "";
            try {
                HttpHandler sj = new HttpHandler();
                JSONObject resObj = new JSONObject(sj.sendJson2(HttpHandler.MYURL + HttpHandler.INSERT2, pesanan));
                JSONArray resArr =
                        resObj.getJSONArray(Static.POSTS);
                result = resArr.getString(0);
            } catch (JSONException e) {
                Log.i(TAG, "JSON parse error " + e.getMessage());
            }
            return result;
        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            Log.d(TAG, result);
            /**
             * Show insert information
             * */
            if (result.equals(Static.SUCCESS)) {
                Toast.makeText(Pesan.this, "Contact added", Toast.LENGTH_LONG).show();
                Intent iMain = new
                        Intent(Pesan.this, Pembayaran.class);
                finish();
                startActivity(iMain);
            } else if (result.equals(Static.FAIL)) {
                Toast.makeText(Pesan.this, "Fail to add contact", Toast.LENGTH_LONG).show();
            } }
    }
}
