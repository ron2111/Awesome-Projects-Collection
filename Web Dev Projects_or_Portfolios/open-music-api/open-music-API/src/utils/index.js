const ClientError = require('../exceptions/ClientError');

const mapDBToModel = ({
  id,
  title,
  year,
  performer,
  genre,
  duration,
  inserted_at,
  updated_at,
}) => ({
  id,
  title,
  year,
  performer,
  genre,
  duration,
  insertedAt: inserted_at,
  updatedAt: updated_at,
});

const errorHandler = (error, h) => {
  if (error instanceof ClientError) {
    return h.response({
      status: 'fail',
      message: error.message,
    }).code(error.statusCode);
  }

  const response = h.response({
    status: 'error',
    message: 'Maaf, terjadi kegagalan pada server kami.',
  });
  response.code(500);
  console.error(error);
  return response;
};

module.exports = { mapDBToModel, errorHandler };
