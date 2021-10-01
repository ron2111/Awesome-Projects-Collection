<?php

$id_human = rand(1, 9999);

// Koneksi Ke Database
function Connection()
{
    return mysqli_connect("localhost", "root", "", "cocok");
}

// Menampilkan Data
function showData($query)
{
    $con = Connection();
    $result = mysqli_query($con, $query);
    $rows = [];
    while ($row = mysqli_fetch_assoc($result)) {
        $rows[] = $row;
    }
    return $rows;
}

// Tambah Data Orang
function tambahOrang($data)
{
    global $id_human;
    $con = Connection();
    $name = htmlspecialchars($data["name"]);
    $jenis_kelamin = htmlspecialchars($data["jenis_kelamin"]);

    // Query
    tambahNilai();
    $query = "INSERT INTO human VALUES ('$id_human','$name','$jenis_kelamin')";
    mysqli_query($con, $query);
    return mysqli_affected_rows($con);
}

// Ubah Data Orang
function ubahOrang($data)
{
    $con = Connection();
    $id = htmlspecialchars($data["id"]);
    $name = htmlspecialchars($data["name"]);

    // Query
    $query = "UPDATE human SET name = '$name' WHERE id = '$id'";
    mysqli_query($con, $query);
    return mysqli_affected_rows($con);
}

// Hapus Data Orang
function hapusOrang($id)
{
    $con = Connection();

    // Query
    hapusNilai($id);
    $query = "DELETE FROM human WHERE id = $id";
    mysqli_query($con, $query);
    return mysqli_affected_rows($con);
}

// Tambah Data Nilai Otomatis Menjadi 0
function tambahNilai()
{
    global $id_human;

    $con = Connection();

    //Data
    $data = "0";

    //Query
    for ($i = 1; $i <= 20; $i++) {
        $query = "INSERT INTO score VALUES (null, '$id_human', '$i','$data')";
        mysqli_query($con, $query);
    }
    return mysqli_affected_rows($con);
}

// Ubah Data Nilai
function ubahNilai($data)
{
    $con = Connection();
    $id = htmlspecialchars($data["id"]);
    $score = htmlspecialchars($data["value"]);

    // Query
    $query = "UPDATE score SET value = '$score' WHERE id = '$id'";
    mysqli_query($con, $query);
    return mysqli_affected_rows($con);
}

// Hapus Data Nilai Berdasarkan Id Orang
function hapusNilai($id)
{
    $con = Connection();

    // Query
    $query = "DELETE FROM score WHERE human_id = $id";
    mysqli_query($con, $query);
    return mysqli_affected_rows($con);
}

// Menghitung Persentase
function persentase($number)
{
    return $number * 100;
}
