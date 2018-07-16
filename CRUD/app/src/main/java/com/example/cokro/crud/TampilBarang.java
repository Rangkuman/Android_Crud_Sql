package com.example.cokro.crud;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class TampilBarang extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextId;
    private EditText editTextkode;
    private EditText editTextnamaB;
    private EditText editTextharga;

    private Button buttonUpdate;
    private Button buttonDelete;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_barang);

        Intent intent = getIntent();

        id = intent.getStringExtra(konfigurasi.BARANG_ID);

        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextkode = (EditText) findViewById(R.id.editTextKode);
        editTextnamaB = (EditText) findViewById(R.id.editTextNamaBr);
        editTextharga = (EditText) findViewById(R.id.editTextHarga);

        buttonUpdate = (Button) findViewById(R.id.buttonUpdateB);
        buttonDelete = (Button) findViewById(R.id.buttonDeleteB);

        buttonUpdate.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);

        editTextId.setText(id);

        getBarang();
    }

    private void getBarang(){
        class GetBarang extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilBarang.this,"Fetching...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_BARANG,id);
                return s;
            }
        }
        GetBarang gb = new GetBarang();
        gb.execute();
    }

    private void showEmployee(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY2);
            JSONObject c = result.getJSONObject(0);
            String kode = c.getString(konfigurasi.TAG_KODE);
            String nama = c.getString(konfigurasi.TAG_NAMA2);
            String harga = c.getString(konfigurasi.TAG_HARGA);

            editTextkode.setText(kode);
            editTextnamaB.setText(nama);
            editTextharga.setText(harga);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void updateBarang(){
        final String kode = editTextkode.getText().toString().trim();
        final String nama = editTextnamaB.getText().toString().trim();
        final String harga = editTextharga.getText().toString().trim();

        class UpdateBarang extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilBarang.this,"Updating...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(TampilBarang.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(konfigurasi.KEY_BARANG_ID,id);
                hashMap.put(konfigurasi.KEY_BARANG_KODE,kode);
                hashMap.put(konfigurasi.KEY_BARANG_NAMA,nama);
                hashMap.put(konfigurasi.KEY_BARANG_HARGA,harga);

                RequestHandler rh = new RequestHandler();

                String s = rh.sendPostRequest(konfigurasi.URL_UPDATE_BARANG,hashMap);

                return s;
            }
        }

        UpdateBarang ub = new UpdateBarang();
        ub.execute();
    }

    private void deleteBarang(){
        class DeleteBarang extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilBarang.this, "Updating...", "Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(TampilBarang.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_DELETE_BARANG, id);
                return s;
            }
        }

        DeleteBarang db = new DeleteBarang();
        db.execute();
    }

    private void confirmDeleteBarang(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Apakah Kamu Yakin Ingin Menghapus Barang ini?");

        alertDialogBuilder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        deleteBarang();
                        startActivity(new Intent(TampilBarang.this,TampilAllBarang.class));
                    }
                });

        alertDialogBuilder.setNegativeButton("Tidak",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void confirmUpdateBarang(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Apakah Kamu Yakin Ingin Mengupdate Barang ini?");

        alertDialogBuilder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        updateBarang();
                        startActivity(new Intent(TampilBarang.this,TampilAllBarang.class));
                    }
                });

        alertDialogBuilder.setNegativeButton("Tidak",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonUpdate){
            confirmUpdateBarang();
        }

        if(v == buttonDelete){
            confirmDeleteBarang();
        }
    }
}
