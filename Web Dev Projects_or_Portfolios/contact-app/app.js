const contacts = require('./contacts')
const yargs = require('yargs')

yargs.command({
    command: 'add',
    describe: 'Menambahkan kontak baru',
    builder: {
        nama: {
            describe: 'Nama lengkap',
            demmandOOption: true,
            type: 'string'
        },
        email: {
            describe: 'Email',
            demmandOOption: true,
            type: 'string'
        },
        nohp: {
            describe: 'Nomor HP',
            demmandOOption: true,
            type: 'string'
        },
    },
    handler(argv) {
        contacts.simpanContact(argv.nama, argv.email, argv.nohp)
    }
}).demandCommand();

// Menampilkan semua nama * no hp kontak

yargs.command({
    command: 'list',
    describe: 'Melihat daftar kontak',
    handler() {
        contacts.listContact();
    }
})

// Menampilkan Detail kontak

yargs.command({
    command: 'detail',
    describe: 'Melihat detail kontak',
    builder: {
        nama: {
            describe: 'Nama lengkap',
            demmandOOption: true,
            type: 'string'
        }
    },
    handler(argv) {
        contacts.detailContact(argv.nama);
    }
})

// Menghapus kontak

yargs.command({
    command: 'delete',
    describe: 'Menghapus kontak berdasarkan nama',
    builder: {
        nama: {
            describe: 'Nama lengkap',
            demmandOOption: true,
            type: 'string'
        }
    },
    handler(argv) {
        contacts.deleteContact(argv.nama);
    }
})


yargs.parse();


// console.log(yargs.argv)

// const main = async () => {
//     const nama = await contacts.tulisPertanyaan('Masukan nama anda :')
//     const email = await contacts.tulisPertanyaan('Masukan email anda :')
//     const nohp = await contacts.tulisPertanyaan('Masukan nohp anda :')

//     contacts.simpanContact(nama, email, nohp)
// }

// main();