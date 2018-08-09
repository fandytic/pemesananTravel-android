package com.fancik.travelb;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Fandy TIC on 02/12/2017.
 */

public class Register extends AppCompatActivity {

    private String TAG = Register.class.getSimpleName();
    private ProgressDialog pDialog;
    private EditText txt_no, txt_password,txt_nama, txt_alamat ;
    private Button btn_register;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        txt_no = (EditText) findViewById(R.id.txt_no);
        txt_password = (EditText) findViewById(R.id.txt_password);
        txt_nama = (EditText) findViewById(R.id.txt_nama);
        txt_alamat = (EditText) findViewById(R.id.txt_alamat);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SendContacts().execute();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        // Button Login
        Button login = (Button) findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
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
            pDialog = new ProgressDialog(Register.this);
            pDialog.setMessage("Adding your data...");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        @Override
        protected String doInBackground(Void... params) {
            Member member = new Member();
            member.setNohp(txt_no.getText().toString());
            member.setPass(txt_password.getText().toString());
            member.setNama(txt_nama.getText().toString());
            member.setAlamat(txt_alamat.getText().toString());
            String result = "";
            try {
                HttpHandler sj = new HttpHandler();
                JSONObject resObj = new
                        JSONObject(sj.sendJson(HttpHandler.MYURL + HttpHandler.INSERT,
                        member));
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
                Toast.makeText(Register.this, "Contact added", Toast.LENGTH_LONG).show();
                Intent iMain = new
                        Intent(Register.this, MainActivity.class);
                finish();
                startActivity(iMain);
            } else if (result.equals(Static.FAIL)) {
                Toast.makeText(Register.this, "Fail to add contact", Toast.LENGTH_LONG).show();
            } }
    }
}
