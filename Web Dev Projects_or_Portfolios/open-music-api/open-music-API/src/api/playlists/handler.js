class PlaylistsHandler {
  constructor(service, validator) {
    this._service = service;
    this._validator = validator;

    this.postPlaylistHandler = this.postPlaylistHandler.bind(this);
    this.getPlaylistHandler = this.getPlaylistHandler.bind(this);
    this.deletePlaylistHandler = this.deletePlaylistHandler.bind(this);
    this.postSongToPlaylistHandler = this.postSongToPlaylistHandler.bind(this);
    this.getSongFromPlaylistHandler = this.getSongFromPlaylistHandler.bind(this);
    this.deleteSongFromPlaylistHandler = this.deleteSongFromPlaylistHandler.bind(this);
  }

  async postPlaylistHandler(req, h) {
    try {
      this._validator.validatePlaylistsPayload(req.payload);

      const { name } = req.payload;

      const { id: credentialId } = req.auth.credentials;

      const playlistId = await this._service.addPlaylist({
        name,
        owner: credentialId,
      });
      return h.response({
        status: 'success',
        message: 'Playlist berhasil ditambahkan',
        data: {
          playlistId,
        },
      }).code(201);
    } catch (error) {
      return error;
    }
  }

  async getPlaylistHandler(req) {
    try {
      const { id: credentialId } = req.auth.credentials;

      const playlists = await this._service.getPlaylists(credentialId);
      return {
        status: 'success',
        data: { playlists },
      };
    } catch (error) {
      console.log(error);
      return error;
    }
  }

  async deletePlaylistHandler(req) {
    try {
      const { playlistId } = req.params;
      const { id: credentialId } = req.auth.credentials;

      await this._service.verifyPlaylistOwner(playlistId, credentialId);
      await this._service.deletePlaylistById(playlistId);

      return {
        status: 'success',
        message: 'Playlist berhasil dihapus',
      };
    } catch (error) {
      return error;
    }
  }

  async postSongToPlaylistHandler(req, h) {
    try {
      this._validator.validateSongPayload(req.payload);
      const { playlistId } = req.params;
      const { songId } = req.payload;
      const { id: credentialId } = req.auth.credentials;

      await this._service.verifyPlaylistAccess(playlistId, credentialId);
      await this._service.addSongToPlaylist(playlistId, songId);
      return h.response({
        status: 'success',
        message: 'Lagu berhasil ditambahkan ke playlist',
      }).code(201);
    } catch (error) {
      return error;
    }
  }

  async getSongFromPlaylistHandler(req) {
    try {
      const { playlistId } = req.params;
      const { id: credentialId } = req.auth.credentials;

      await this._service.verifyPlaylistAccess(playlistId, credentialId);

      const songs = await this._service.getSongsFromPlaylist(playlistId);

      return {
        status: 'success',
        data: {
          songs,
        },
      };
    } catch (error) {
      return error;
    }
  }

  async deleteSongFromPlaylistHandler(req) {
    try {
      const { playlistId } = req.params;
      const { songId } = req.payload;
      const { id: credentialId } = req.auth.credentials;

      await this._service.verifyPlaylistAccess(playlistId, credentialId);
      await this._service.deleteSongFromPlaylist(playlistId, songId);

      return {
        status: 'success',
        message: 'Lagu berhasil dihapus dari playlist',
      };
    } catch (error) {
      return error;
    }
  }
}

module.exports = PlaylistsHandler;
