class CollaborationsHandler {
  constructor(collaborationsService, playlistsService, validator) {
    this._collaborationsService = collaborationsService;
    this._playlistsService = playlistsService;
    this._validator = validator;
    this.postCollaborationHandler = this.postCollaborationHandler.bind(this);
    this.deleteCollaborationHandler = this.deleteCollaborationHandler.bind(this);
  }

  async postCollaborationHandler(req, h) {
    try {
      this._validator.validateCollaborationPayload(req.payload);

      const { id: credentialId } = req.auth.credentials;
      const { playlistId, userId } = req.payload;

      await this._playlistsService.verifyPlaylistOwner(playlistId, credentialId);

      const collaborationId = await this._collaborationsService.addCollaboration(
        playlistId,
        userId,
      );

      return h.response({
        status: 'success',
        message: 'kolaborasi berhasil ditambahkan',
        data: {
          collaborationId,
        },
      }).code(201);
    } catch (error) {
      return error;
    }
  }

  async deleteCollaborationHandler(req) {
    try {
      this._validator.validateCollaborationPayload(req.payload);
      const { id: credentialId } = req.auth.credentials;
      const { playlistId, userId } = req.payload;

      await this._playlistsService.verifyPlaylistOwner(playlistId, credentialId);
      await this._collaborationsService.deleteCollaboration(
        playlistId,
        userId,
      );

      return {
        status: 'success',
        message: 'kolaborasi berhasil dihapus',
      };
    } catch (error) {
      console.log(error);
      return error;
    }
  }
}

module.exports = CollaborationsHandler;
