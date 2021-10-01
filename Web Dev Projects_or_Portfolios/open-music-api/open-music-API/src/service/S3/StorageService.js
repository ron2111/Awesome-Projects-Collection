const AWS = require('aws-sdk');

class StoragesService {
  constructor() {
    this._S3 = new AWS.S3();
  }

  writeFile(file, meta) {
    const params = {
      Bucket: process.env.AWS_BUCKET_NAME,
      Key: +new Date() + meta.filename,
      Body: file._data,
      ContentType: meta.headers['content-type'],
    };

    return new Promise((resolve, reject) => {
      this._S3.upload(params, (error, data) => {
        if (error) return reject(error);

        return resolve(data.Location);
      });
    });
  }
}

module.exports = StoragesService;
