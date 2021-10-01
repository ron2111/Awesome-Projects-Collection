const fs = require('fs');
const chalk = require('chalk')
const validator = require('validator')

// Membuat folder data jika belum ada
const dirPath = './data'
if (!fs.existsSync(dirPath)) {
    fs.mkdirSync(dirPath)
}

// membuat contact json jika belum ada
const dataPath = `${dirPath}/contacts.json`;
console.log(dataPath)
if (!fs.existsSync(dataPath)) {
    fs.writeFileSync(dataPath, '[]', 'utf-8');
}

const loadContact = () => {
    const file = fs.readFileSync('./data/contacts.json', 'utf8')
    const contacts = JSON.parse(file);
    return contacts;
}

const simpanContact = (nama, email, nohp) => {
    const contact = {
        nama,
        email,
        nohp
    }

    const contacts = loadContact();

    // Cek duplikat
    const duplikat = contacts.find((contact) => contact.nama === nama);

    if (duplikat) {
        console.log(chalk.red.inverse.bold('Data sudah terdaftar, gunakan nama lain !'));
        return false;
    }

    // Cek email
    if (email) {
        if (!validator.isEmail(email)) {
            console.log(chalk.red.inverse.bold('Email tidak valid !'));
            return false;
        }
    }

    // cek nomor hp
    if (!validator.isMobilePhone(nohp, 'id-ID')) {
        console.log(chalk.red.inverse.bold('Nomor HP tidak valid !'));
        return false;
    }

    contacts.push(contact)

    fs.writeFileSync('./data/contacts.json', JSON.stringify(contacts));

    console.log(chalk.green.inverse.bold('Terima kasih sudah memasukan data'))
}

const listContact = () => {
    const contacts = loadContact();
    console.log(chalk.bgBlackBright.inverse.bold('Daftar kontak : '))
    contacts.forEach((contact, i) => {
        console.log(`${i+1}. ${contact.nama} - ${contact.nohp}`);
    })
}

const detailContact = (nama) => {
    const contacts = loadContact();
    const contact = contacts.find((contact) => contact.nama.toLowerCase() === nama.toLowerCase());

    if (!contact) {
        console.log(chalk.red.inverse.bold(`${nama} tidak ditemukan !`));
        return false;
    }

    console.log(chalk.cyan.inverse.bold(contact.nama));
    console.log(contact.nohp)
    if (contact.email) {
        console.log(contact.email)
    }
}

const deleteContact = (nama) => {
    const contacts = loadContact();
    const newContacts = contacts.filter((contact) => contact.nama.toLowerCase() !== nama.toLowerCase())

    if (contacts.length === newContacts.length) {
        console.log(chalk.red.inverse.bold(`${nama} tidak ditemukan !`));
        return false;
    }

    fs.writeFileSync('./data/contacts.json', JSON.stringify(newContacts));

    console.log(chalk.green.inverse.bold(`${nama} Berhasil dihapus !`))

}

module.exports = {
    simpanContact,
    listContact,
    detailContact,
    deleteContact
}