class ExportsHandler {
  constructor(service, validator, playlistsService) {
    this._service = service;
    this._validator = validator;
    this._playlistsService = playlistsService;

    this.postExportPlaylistsHandler = this.postExportPlaylistsHandler.bind(this);
  }

  async postExportPlaylistsHandler(req, h) {
    try {
      this._validator.validateExportSongsPayload(req.payload);

      const { playlistId } = req.params;
      const { id: userId } = req.auth.credentials;

      await this._playlistsService.verifyPlaylistAccess(playlistId, userId);

      const message = {
        playlistId,
        targetEmail: req.payload.targetEmail,
      };

      await this._service.sendMessage(
        'export:songs',
        JSON.stringify(message),
      );

      return h.response({
        status: 'success',
        message: 'Permintaan Anda sedang kami proses',
      }).code(201);
    } catch (error) {
      return error;
    }
  }
}

module.exports = ExportsHandler;
