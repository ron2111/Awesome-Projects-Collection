// const ClientError = require('../../exceptions/ClientError');

class SongsHandler {
  constructor(service, validator) {
    this._service = service;
    this._validator = validator;

    this.postSongHandler = this.postSongHandler.bind(this);
    this.getSongsHandler = this.getSongsHandler.bind(this);
    this.getSongByIdHandler = this.getSongByIdHandler.bind(this);
    this.putSongByIdHandler = this.putSongByIdHandler.bind(this);
    this.deleteSongByIdHandler = this.deleteSongByIdHandler.bind(this);
  }

  async postSongHandler(req, h) {
    try {
      this._validator.validateSongsPayload(req.payload);
      const {
        title,
        year,
        performer,
        genre,
        duration,
      } = req.payload;

      const songId = await this._service.addSong({
        title,
        year,
        performer,
        genre,
        duration,
      });

      return h
        .response({
          status: 'success',
          message: 'Lagu berhasil ditambahkan',
          data: {
            songId,
          },
        })
        .code(201);
    } catch (error) {
      return error;
    }
  }

  async getSongsHandler() {
    try {
      const songsData = await this._service.getSongs();
      const songs = [];
      songsData.forEach((e) => {
        songs.push({
          id: e.id,
          title: e.title,
          performer: e.performer,
        });
      });

      return {
        status: 'success',
        data: { songs },
      };
    } catch (error) {
      return error;
    }
  }

  async getSongByIdHandler(req) {
    try {
      const { id } = req.params;
      const song = await this._service.getSongById(id);
      return {
        status: 'success',
        data: {
          song,
        },
      };
    } catch (error) {
      return error;
    }
  }

  async putSongByIdHandler(req) {
    try {
      this._validator.validateSongsPayload(req.payload);
      const { id } = req.params;
      await this._service.putSongById(id, req.payload);

      return {
        status: 'success',
        message: 'Lagu berhasil diperbarui',
      };
    } catch (error) {
      return error;
    }
  }

  async deleteSongByIdHandler(req) {
    try {
      const { id } = req.params;
      await this._service.deleteSongById(id);
      return {
        status: 'success',
        message: 'Lagu berhasil dihapus',
      };
    } catch (error) {
      return error;
    }
  }
}

module.exports = SongsHandler;
