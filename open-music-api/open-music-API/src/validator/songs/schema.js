const Joi = require('joi');

const SongspayloadSchema = Joi.object({
  title: Joi.string().required(),
  year: Joi.number().integer().min(1990).max(2021)
    .required(),
  performer: Joi.string().required(),
  genre: Joi.string(),
  duration: Joi.number(),
});

module.exports = SongspayloadSchema;
