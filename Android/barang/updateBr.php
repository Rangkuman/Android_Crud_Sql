<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//MEndapatkan Nilai Dari Variable
		$id = $_POST['id'];
		$kodebr = $_POST['kode'];
		$namabr = $_POST['nama'];
		$harga = $_POST['harga'];

		//import file koneksi database
		require_once('koneksi.php');

		//Membuat SQL Query
		$sql = "UPDATE tb_barang SET KodeBr = '$kodebr', NamaBr = '$namabr', HargaSatuan = '$harga' WHERE id = $id;";

		//Meng-update Database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data Pegawai';
		}else{
			echo 'Gagal Update Data Pegawai';
		}

		mysqli_close($con);
	}
?>
