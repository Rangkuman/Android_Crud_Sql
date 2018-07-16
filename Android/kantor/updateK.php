<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//MEndapatkan Nilai Dari Variable
		$id = $_POST['id'];
		$nama = $_POST['nama'];
		$alamat = $_POST['alamat'];
		$cabang = $_POST['cabang'];

		//import file koneksi database
		require_once('koneksi.php');

		//Membuat SQL Query
		$sql = "UPDATE tb_kantor SET NamaK = '$nama', AlamatK = '$alamat', Cabang = '$cabang' WHERE id = $id;";

		//Meng-update Database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data Pegawai';
		}else{
			echo 'Gagal Update Data Pegawai';
		}

		mysqli_close($con);
	}
?>
