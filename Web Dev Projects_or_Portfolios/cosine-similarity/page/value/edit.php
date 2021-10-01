<?php
// Include
include("function/Function.php");

// AMBIL ID
$id = $_GET["id"];

// QUERY
$query = showData("SELECT * FROM score WHERE id = $id");

// Melakukan Foreach
foreach ($query as $data) {
    $value = $data["value"];
}

// Fungsi Ubah
if (isset($_POST["ubah"])) {
    if (ubahNilai($_POST) > 0) {
        echo "<script>
        Swal.fire({
            icon: 'success',
            title: 'Berhasil',
            text: 'Data berhasil diubah'
        }).then(function() {
            window.location.href = 'index.php?page=data_nilai';
        });
        </script>";
    } else {
        echo "<script>
        Swal.fire({
            icon: 'error',
            title: 'Gagal',
            text: 'Data gagal diubah'
        }).then(function() {
            window.location.href = 'index.php?page=data_nilai';
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
                        <li class="breadcrumb-item"><a href="index?page=data_nilai">Data Nilai</a></li>
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
                                <input type="number" class="form-control" id="value" name="value" required min="0" max="5" value="<?= $value ?>">
                                <input type="hidden" name="id" value="<?= $id ?>">
                                <label for="value">Nilai</label>
                            </div>
                            <div class="float-end mb-3">
                                <button class="btn btn-primary" type="submit" name="ubah">Ubah</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card shadow-sm">
                    <div class="card-header">
                        Perhatian
                    </div>
                    <div class="card-body">
                        Isi dengan angka 1-5.
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>