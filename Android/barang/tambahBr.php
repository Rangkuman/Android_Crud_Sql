<?php

 /*

 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/

 */

	if($_SERVER['REQUEST_METHOD']=='POST'){

		//Mendapatkan Nilai Variable
		$kodebr = $_POST['kode'];
		$namabr = $_POST['nama'];
		$harga = $_POST['harga'];

		//Pembuatan Syntax SQL
		$sql = "INSERT INTO tb_barang (KodeBr,NamaBr,HargaSatuan) VALUES ('$kodebr','$namabr','$harga')";

		//Import File Koneksi database
		require_once('koneksi.php');

		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan Pegawai';
		}else{
			echo 'Gagal Menambahkan Pegawai';
		}

		mysqli_close($con);
	}
?>
