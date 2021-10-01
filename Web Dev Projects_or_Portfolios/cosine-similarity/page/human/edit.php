<?php
// Include
include("function/Function.php");

// Variabel
$id_orang = "";
$nama_orang = "";

// AMBIL ID
$id = $_GET["id"];

// QUERY
$query = showData("SELECT * FROM human WHERE id = $id");

// Melakukan Foreach
foreach ($query as $data) {
    $id_orang = $data["id"];
    $nama_orang = $data["name"];
}

// Fungsi Ubah
if (isset($_POST["ubah"])) {
    if (ubahOrang($_POST) > 0) {
        echo "<script>
        Swal.fire({
            icon: 'success',
            title: 'Berhasil',
            text: 'Data berhasil diubah'
        }).then(function() {
            window.location.href = 'index.php?page=data_orang';
        });
        </script>";
    } else {
        echo "<script>
        Swal.fire({
            icon: 'error',
            title: 'Gagal',
            text: 'Data gagal diubah'
        }).then(function() {
            window.location.href = 'index.php?page=data_orang';
        });
        </script>";
    }
}
?>
<section class="py-5">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">Beranda</li>
                        <li class="breadcrumb-item"><a href="index.php?page=data_orang">Data Orang</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Ubah Data</li>
                    </ol>
                </nav>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8">
                <div class="card shadow-sm">
                    <div class="card-header">
                        Form Ubah
                    </div>
                    <div class="card-body">
                        <form action="" method="post">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="name" placeholder="Nama Lengkap" name="name" value="<?= $nama_orang ?>" required autocomplete="off">
                                <input type="hidden" name="id" value="<?= $id_orang ?>">
                                <label for="name">Nama Lengkap</label>
                            </div>
                            <div class="float-end mb-3">
                                <button class="btn btn-primary" type="submit" name="ubah">Ubah</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>