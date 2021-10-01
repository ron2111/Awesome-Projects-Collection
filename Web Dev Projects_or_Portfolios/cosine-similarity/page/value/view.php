<?php
error_reporting(0);

// Include
include("function/Function.php");

$orang = showData("SELECT id, name FROM human");
$pesan = "Pilih Data Terlebih Dahulu";

// Pencarian
if (isset($_POST["kirim"])) {

    // Masukin inputan ke id
    $id = $_POST["id"];

    // Cek apakah id kosong apa tidak
    if ($id == "") {
        $pesan = "Data yang dipilih tidak valid";
    } else {
        $id = $_POST["id"];

        // Query
        $query = showData("SELECT score.id AS id, human.name AS humanName, sub_attribute.name AS subName, score.value FROM score INNER JOIN human ON score.human_id = human.id INNER JOIN sub_attribute ON score.sub_attribute_id = sub_attribute.id WHERE score.human_id = $id");
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
                        <li class="breadcrumb-item active" aria-current="page">Data Nilai</li>
                    </ol>
                </nav>
            </div>
        </div>
        <div class="row justify-content-end mb-3">
            <div class="col-md-6">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <form action="" method="post">
                            <div class="row g-2">
                                <div class="col-md-10">
                                    <div class="form-floating">
                                        <select class="form-select" id="floatingSelect" name="id">
                                            <option selected disabled>Pilih orang</option>
                                            <?php foreach ($orang as $human) : ?>
                                                <option value="<?= $human["id"] ?>"><?= $human["name"] ?></option>
                                            <?php endforeach ?>
                                        </select>
                                        <label for="floatingSelect">Pilih data orang</label>
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <button class="btn btn-primary w-100 h-100" type="submit" name="kirim"><i class="bi bi-search"></i></button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <?php if (!empty($query)) : ?>
            <div class="row">
                <div class="col-md-12">
                    <div class="card shadow-sm">
                        <div class="card-header">
                            Data Nilai
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="table">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Nama</th>
                                            <th>Sub Atribut</th>
                                            <th>Nilai</th>
                                            <th>Aksi</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <?php $i = 1; ?>
                                        <?php foreach ($query as $data) : ?>
                                            <tr>
                                                <td><?= $i++ ?></td>
                                                <td><?= $data["humanName"] ?></td>
                                                <td><?= $data["subName"] ?></td>
                                                <td><?= $data["value"] ?></td>
                                                <td>
                                                    <a class="btn btn-primary btn-sm" href="index.php?page=ubah_data_nilai&id=<?= $data['id']; ?>" title="Ubah"><i class="bi bi-pencil-square"></i></a>
                                                </td>
                                            </tr>
                                        <?php endforeach ?>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <?php else : ?>
            <div class="row">
                <div class="col-md-12">
                    <div class="card shadow-sm">
                        <div class="card-body">
                            <h1><?= $pesan ?></h1>
                        </div>
                    </div>
                </div>
            </div>
        <?php endif ?>
    </div>
</section>