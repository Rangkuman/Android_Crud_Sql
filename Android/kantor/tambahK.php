<?php

 /*

 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/

 */

	if($_SERVER['REQUEST_METHOD']=='POST'){

		//Mendapatkan Nilai Variable
		$nama = $_POST['nama'];
		$alamat = $_POST['alamat'];
		$cabang = $_POST['cabang'];

		//Pembuatan Syntax SQL
		$sql = "INSERT INTO tb_kantor (NamaK,AlamatK,Cabang) VALUES ('$nama','$alamat','$cabang')";

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
