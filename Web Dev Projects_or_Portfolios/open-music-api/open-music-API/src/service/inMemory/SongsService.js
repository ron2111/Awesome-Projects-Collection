const { nanoid } = require('nanoid');
const NotFoundError = require('../../exceptions/NotFoundError');
const InvariantError = require('../../exceptions/InvariantError');

class SongsService {
  constructor() {
    this._songs = [];
  }

  addSong({
    title, year, performer, genre, duration,
  }) {
    const id = nanoid(16);
    const insertedAt = new Date().toISOString();
    const updatedAt = insertedAt;

    const newSong = {
      id,
      title,
      year,
      performer,
      genre,
      duration,
      insertedAt,
      updatedAt,
    };

    this._songs.push(newSong);

    const isSuccess = this._songs.filter((n) => n.id === id).length > 0;

    if (!isSuccess) {
      throw new InvariantError('Lagu gagal ditambahkan');
    }

    return id;
  }

  getSongs() {
    return this._songs;
  }

  getSongById(id) {
    const song = this._songs.findIndex((n) => n.id === id);
    if (!song) {
      throw new NotFoundError('Lagu tidak ditemukan');
    }

    return song;
  }

  putSongById(id, {
    title, year, performer, genre, duration,
  }) {
    const index = this._songs.findIndex((n) => n.id === id);

    if (index === -1) {
      throw new NotFoundError(
        'Gagal memperbarui lagu, Id tidak ditemukan',
      );
    }

    const updatedAt = new Date().toISOString();

    this._songs[index] = {
      ...this._songs[index],
      title,
      year,
      performer,
      genre,
      duration,
      updatedAt,
    };
  }

  deleteSongById(id) {
    const index = this._songs.findIndex((n) => n.id === id);
    if (index === -1) {
      throw new NotFoundError(
        'Lagu gagal dihapus, Id tidak ditemukan',
      );
    }

    this._songs.splice(index, 1);
  }
}

module.exports = SongsService;
