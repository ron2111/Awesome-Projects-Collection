class AuthenticationsHandler {
  constructor(authenticationsService, usersSerivce, tokenManager, validator) {
    this._authenticationsService = authenticationsService;
    this._usersService = usersSerivce;
    this._tokenManager = tokenManager;
    this._validator = validator;

    this.postAuthenticationHandler = this.postAuthenticationHandler.bind(this);
    this.putAuthenticationHandler = this.putAuthenticationHandler.bind(this);
    this.deleteAuthenticationHandler = this.deleteAuthenticationHandler.bind(this);
  }

  async postAuthenticationHandler(req, h) {
    try {
      this._validator.validatePostAuthenticationPayload(req.payload);

      const { username, password } = req.payload;
      const id = await this._usersService.verifyUserCredential(username, password);

      const accessToken = this._tokenManager.generateAccessToken({ id });
      const refreshToken = this._tokenManager.generateRefreshToken({ id });

      await this._authenticationsService.addRefreshToken(refreshToken);

      return h.response({
        status: 'success',
        message: 'Authentication berhasil ditambahkan',
        data: {
          accessToken,
          refreshToken,
        },
      }).code(201);
    } catch (error) {
      return error;
    }
  }

  async putAuthenticationHandler(req) {
    try {
      this._validator.validatePutAuthenticationPayload(req.payload);

      const { refreshToken } = req.payload;
      await this._authenticationsService.verifyRefreshToken(refreshToken);
      const { id } = this._tokenManager.verifyRefreshToken(refreshToken);

      const accessToken = this._tokenManager.generateAccessToken({ id });
      return {
        status: 'success',
        message: 'Access token berhasil diperbarui',
        data: {
          accessToken,
        },
      };
    } catch (error) {
      return error;
    }
  }

  async deleteAuthenticationHandler(req) {
    try {
      this._validator.validateDeleteAuthenticationPayload(req.payload);

      const { refreshToken } = req.payload;
      await this._authenticationsService.verifyRefreshToken(refreshToken);
      await this._authenticationsService.deleteRefreshToken(refreshToken);

      return {
        status: 'success',
        message: 'Refresh token berhasil diperbarui',
      };
    } catch (error) {
      return error;
    }
  }
}

module.exports = AuthenticationsHandler;
