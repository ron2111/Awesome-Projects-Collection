<?php
error_reporting(0);

// Include
include("function/Function.php");
include("function/CosineSimilarity.php");

// Query
$pria = showData("SELECT id, name FROM human WHERE jenis_kelamin = 'pria'");
$wanita = showData("SELECT id, name FROM human WHERE jenis_kelamin = 'wanita'");

// Push Vektor 1 dan Vektor 2 Kedalam Array
$array1 = [];
$array2 = [];

// Pesan
$pesan = "Pilih Data Terlebih Dahulu";

// Tombol Kirim
if (isset($_POST["kirim"])) {

    // Masukin inputan ke id
    $id_pria = $_POST["id_pria"];
    $id_wanita = $_POST["id_wanita"];

    // Cek apakah id kosong atau tidak
    if ($id_pria == "" || $id_wanita == "") {
        $pesan = "Data yang dipilih tidak valid";
    } else {
        // Query
        $vektor1 = showData("SELECT score.id AS id, human.name AS humanName, sub_attribute.name AS subName, score.value FROM score INNER JOIN human ON score.human_id = human.id INNER JOIN sub_attribute ON score.sub_attribute_id = sub_attribute.id WHERE human.id = $id_pria");
        $vektor2 = showData("SELECT score.id AS id, human.name AS humanName, sub_attribute.name AS subName, score.value FROM score INNER JOIN human ON score.human_id = human.id INNER JOIN sub_attribute ON score.sub_attribute_id = sub_attribute.id WHERE human.id = $id_wanita");

        // Cek apakah data kosong atau tidak
        if (!empty($vektor1) && !empty($vektor2)) {
            foreach ($vektor1 as $pektor1) {
                $array1["nilai"][] = $pektor1["value"];
            }

            foreach ($vektor2 as $pektor2) {
                $array2["nilai"][] = $pektor2["value"];
            }

            // Hasil
            $result = CosineSimilarity::calc($array1["nilai"], $array2["nilai"]);
        } else {
            $pesan = "Belom ada data";
        }
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
                        <li class="breadcrumb-item active" aria-current="page">Data Hasil</li>
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
                                <div class="col-md-5">
                                    <div class="form-floating">
                                        <select class="form-select" id="floatingSelect" name="id_pria">
                                            <option selected disabled>Pilih data aku</option>
                                            <?php foreach ($pria as $man) : ?>
                                                <option value="<?= $man["id"] ?>"><?= $man["name"] ?></option>
                                            <?php endforeach ?>
                                        </select>
                                        <label for="floatingSelect">Pilih data aku</label>
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <div class="form-floating">
                                        <select class="form-select" id="floatingSelect" name="id_wanita">
                                            <option selected disabled>Pilih data dia</option>
                                            <?php foreach ($wanita as $women) : ?>
                                                <option value="<?= $women["id"] ?>"><?= $women["name"] ?></option>
                                            <?php endforeach ?>
                                        </select>
                                        <label for="floatingSelect">Pilih data dia</label>
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
        <?php if (!empty($vektor1) && !empty($vektor2)) : ?>
            <div class="row">
                <div class="col-md-12">
                    <div class="card shadow-sm mb-5">
                        <div class="card-header">
                            Data Aku
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
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <?php $i = 1; ?>
                                        <?php foreach ($vektor1 as $data) : ?>
                                            <tr>
                                                <td><?= $i++ ?></td>
                                                <td><?= $data["humanName"] ?></td>
                                                <td><?= $data["subName"] ?></td>
                                                <td><?= $data["value"] ?></td>
                                            </tr>
                                        <?php endforeach ?>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="card shadow-sm mb-5">
                        <div class="card-header">
                            Data Dia
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="table1">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Nama</th>
                                            <th>Sub Atribut</th>
                                            <th>Nilai</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <?php $j = 1; ?>
                                        <?php foreach ($vektor2 as $kamu) : ?>
                                            <tr>
                                                <td><?= $j++ ?></td>
                                                <td><?= $kamu["humanName"] ?></td>
                                                <td><?= $kamu["subName"] ?></td>
                                                <td><?= $kamu["value"] ?></td>
                                            </tr>
                                        <?php endforeach ?>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="card shadow-sm mb-5">
                        <div class="card-body">
                            <p>Hasil Kecocokan antara <span><?= $data["humanName"] ?></span> dan <span><?= $kamu["humanName"] ?></span> adalah <span><?= $result ?></span> atau <span><?= bcdiv(persentase($result), 1, 0) . "%" ?></span></p>
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