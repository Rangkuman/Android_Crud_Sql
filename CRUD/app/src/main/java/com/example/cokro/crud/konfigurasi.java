package com.example.cokro.crud;

public class konfigurasi {

    //Dibawah ini merupakan Pengalamatan dimana Lokasi Skrip CRUD PHP disimpan
    //Pada tutorial Kali ini, karena kita membuat localhost maka alamatnya tertuju ke IP komputer
    //dimana File PHP tersebut berada
    //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
    public static final String URL_ADD="http://192.168.100.11/Android/pegawai/tambahPgw.php";
    public static final String URL_GET_ALL = "http://192.168.100.11/Android/pegawai/tampilSemuaPgw.php";
    public static final String URL_GET_EMP = "http://192.168.100.11/Android/pegawai/tampilPgw.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.100.11/Android/pegawai/updatePgw.php";
    public static final String URL_DELETE_EMP = "http://192.168.100.11/Android/pegawai/hapusPgw.php?id=";
    //
    public static final String URL_ADD_KANTOR="http://192.168.100.11/Android/kantor/tambahK.php";
    public static final String URL_GET_ALL_KANTOR = "http://192.168.100.11/Android/kantor/tampilSemuaK.php";
    public static final String URL_GET_KANTOR = "http://192.168.100.11/Android/kantor/tampilK.php?id=";
    public static final String URL_UPDATE_KANTOR = "http://192.168.100.11/Android/kantor/updateK.php";
    public static final String URL_DELETE_KANTOR = "http://192.168.100.11/Android/kantor/hapusK.php?id=";
    //
    public static final String URL_ADD_BARANG="http://192.168.100.11/Android/barang/tambahBr.php";
    public static final String URL_GET_ALL_BARANG = "http://192.168.100.11/Android/barang/tampilSemuaBr.php";
    public static final String URL_GET_BARANG = "http://192.168.100.11/Android/barang/tampilBr.php?id=";
    public static final String URL_UPDATE_BARANG = "http://192.168.100.11/Android/barang/updateBr.php";
    public static final String URL_DELETE_BARANG = "http://192.168.100.11/Android/barang/hapusBr.php?id=";
    //

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAMA = "name";
    public static final String KEY_EMP_POSISI = "desg";
    public static final String KEY_EMP_GAJIH = "salary";
    //
    public static final String KEY_KANTOR_ID = "id";
    public static final String KEY_KANTOR_NAMA = "nama";
    public static final String KEY_KANTOR_ALAMAT = "alamat";
    public static final String KEY_KANTOR_CABANG = "cabang";
    //
    public static final String KEY_BARANG_ID = "id";
    public static final String KEY_BARANG_KODE = "kode";
    public static final String KEY_BARANG_NAMA = "nama";
    public static final String KEY_BARANG_HARGA = "harga";
    //

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAMA = "name";
    public static final String TAG_POSISI = "desg";
    public static final String TAG_GAJIH = "salary";
    //Kantor
    public static final String TAG_JSON_ARRAY1="result";
    public static final String TAG_ID1 = "id";
    public static final String TAG_NAMA1 = "nama";
    public static final String TAG_ALAMAT = "alamat";
    public static final String TAG_CABANG= "cabang";
    //Barang
    public static final String TAG_JSON_ARRAY2="result";
    public static final String TAG_ID2 = "id";
    public static final String TAG_KODE = "kode";
    public static final String TAG_NAMA2 = "nama";
    public static final String TAG_HARGA = "harga";
    //

    //ID karyawan
    //emp itu singkatan dari Employee
    public static final String EMP_ID = "emp_id";
    //
    public static final String KANTOR_ID = "kantor_id";
    //
    public static final String BARANG_ID = "barang_id";

}
