<?php
// Include
include("function/Function.php");

// GET ID
$id = $_GET["id"];

if (hapusOrang($id) > 0) {
    echo "<script>
        Swal.fire({
            icon: 'success',
            title: 'Berhasil',
            text: 'Data berhasil dihapus'
        }).then(function() {
            window.location.href = 'index.php?page=data_orang';
        });
        </script>";
} else {
    echo "<script>
        Swal.fire({
            icon: 'error',
            title: 'Gagal',
            text: 'Data gagal dihapus'
        }).then(function() {
            window.location.href = 'index.php?halaman=data_orang';
            });
        </script>";
}
