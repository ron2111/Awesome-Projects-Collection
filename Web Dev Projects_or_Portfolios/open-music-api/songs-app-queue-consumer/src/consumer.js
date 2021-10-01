require('dotenv').config();
const amqp = require('amqplib');
const SongsService = require('./SongsService');
const MailSender = require('./MailSender');
const Listener = require('./Listener');

const init = async () => {
  const songsService = new SongsService();
  const mailSender = new MailSender();
  const listener = new Listener(songsService, mailSender);

  const connection = await amqp.connect(process.env.RABBITMQ_SERVER);
  const channel = await connection.createChannel();

  const queueName = 'export:songs';

  await channel.assertQueue(queueName, {
    durable: true,
  });

  channel.consume(queueName, listener.listen, { noAck: true });
};

init();
