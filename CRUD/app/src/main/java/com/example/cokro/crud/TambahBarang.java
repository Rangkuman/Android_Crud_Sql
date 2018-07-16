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

import java.util.HashMap;

public class TambahBarang extends AppCompatActivity implements View.OnClickListener{

    //Dibawah ini merupakan perintah untuk mendefinikan View
    private EditText editTextkode;
    private EditText editTextNamaB;
    private EditText editTextsatuan;

    private Button buttonAdd;
    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_barang);

        //Inisialisasi dari View
        editTextkode = (EditText) findViewById(R.id.editTextKode);
        editTextNamaB = (EditText) findViewById(R.id.editTextNamaB);
        editTextsatuan = (EditText) findViewById(R.id.editTextSatuan);

        buttonAdd = (Button) findViewById(R.id.buttonAddB);
        buttonView = (Button) findViewById(R.id.buttonView);

        //Setting listeners to button
        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);
    }


    //Dibawah ini merupakan perintah untuk Menambahkan Pegawai (CREATE)
    private void addBarang(){

        final String kode = editTextkode.getText().toString().trim();
        final String nama = editTextNamaB.getText().toString().trim();
        final String harga = editTextsatuan.getText().toString().trim();

        class AddBarang extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TambahBarang.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(TambahBarang.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_BARANG_KODE,kode);
                params.put(konfigurasi.KEY_BARANG_NAMA,nama);
                params.put(konfigurasi.KEY_BARANG_HARGA,harga);


                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_ADD_BARANG, params);
                return res;
            }
        }

        AddBarang ab = new AddBarang();
        ab.execute();
    }

    private void confirmAddBarang(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Apakah Kamu Yakin Ingin Menambah Kantor ini?");

        alertDialogBuilder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        addBarang();
                        startActivity(new Intent(TambahBarang.this,TampilAllBarang.class));
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
        if(v == buttonAdd){
            confirmAddBarang();
        }

        if(v == buttonView){
            startActivity(new Intent(TambahBarang.this,TampilAllBarang.class));
        }
    }
}
