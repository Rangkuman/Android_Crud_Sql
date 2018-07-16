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

public class TambahKantor extends AppCompatActivity implements View.OnClickListener {

    //Dibawah ini merupakan perintah untuk mendefinikan View
    private EditText editTextkantor;
    private EditText editTextAlamat;
    private EditText editTextCabang;

    private Button buttonAdd;
    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kantor);


        //Inisialisasi dari View
        editTextkantor = (EditText) findViewById(R.id.editTextKantor);
        editTextAlamat = (EditText) findViewById(R.id.editTextAlamat);
        editTextCabang = (EditText) findViewById(R.id.editTextCabang);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonView = (Button) findViewById(R.id.buttonView);

        //Setting listeners to button
        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);
    }


    //Dibawah ini merupakan perintah untuk Menambahkan Pegawai (CREATE)
    private void addEmployee(){

        final String nama = editTextkantor.getText().toString().trim();
        final String alamat = editTextAlamat.getText().toString().trim();
        final String cabang = editTextCabang.getText().toString().trim();

        class AddEmployee extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TambahKantor.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(TambahKantor.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_KANTOR_NAMA,nama);
                params.put(konfigurasi.KEY_KANTOR_ALAMAT,alamat);
                params.put(konfigurasi.KEY_KANTOR_CABANG,cabang);


                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_ADD_KANTOR, params);
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    private void confirmAddEmployee(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Apakah Kamu Yakin Ingin Menambah Kantor ini?");

        alertDialogBuilder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        addEmployee();
                        startActivity(new Intent(TambahKantor.this,TampilAllKantor.class));
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
            confirmAddEmployee();
        }

        if(v == buttonView){
            startActivity(new Intent(TambahKantor.this,TampilAllKantor.class));
        }
    }
}

