const { errorHandler } = require('../../utils');

class UploadsHandler {
  constructor(service, validator) {
    this._service = service;
    this._validator = validator;

    this.postUploadImageHandler = this.postUploadImageHandler.bind(this);
  }

  async postUploadImageHandler(req, h) {
    try {
      const { data } = req.payload;
      this._validator.validateImageHeaders(data.hapi.headers);

      const filename = await this._service.writeFile(data, data.hapi);

      return h.response({
        status: 'success',
        data: {
          pictureUrl: `http://${process.env.HOST}:${process.env.PORT}/upload/pictures/${filename}`,
        },
      }).code(201);
    } catch (error) {
      return errorHandler(error, h);
    }
  }
}

module.exports = UploadsHandler;
