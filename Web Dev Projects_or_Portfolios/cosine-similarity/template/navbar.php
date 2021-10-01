<nav class="navbar navbar-expand-lg navbar-dark bg-danger shadow-sm">
    <div class="container">
        <a class="navbar-brand" href="index?page=beranda">CS</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav ms-auto">
                <a class="nav-link <?php if ($_GET['page'] == 'beranda') echo "active" ?>" href="index?page=beranda">Beranda</a>
                <a class="nav-link <?php if ($_GET['page'] == 'data_orang' || $_GET["page"] == 'ubah_data_orang' || $_GET["page"] == 'tambah_data_orang') echo "active" ?>" href="index?page=data_orang">Orang</a>
                <a class="nav-link <?php if ($_GET['page'] == 'data_atribut') echo "active" ?>" href="index?page=data_atribut">Atribut</a>
                <a class="nav-link <?php if ($_GET['page'] == 'data_sub_atribut') echo "active" ?>" href="index?page=data_sub_atribut">Sub Atribut</a>
                <a class="nav-link <?php if ($_GET['page'] == 'data_nilai' || $_GET['page'] == 'ubah_data_nilai') echo "active" ?>" href="index?page=data_nilai">Nilai</a>
                <a class="nav-link <?php if ($_GET['page'] == 'hasil') echo "active" ?>" href="index?page=hasil">Hasil</a>
            </div>
        </div>
    </div>
</nav>