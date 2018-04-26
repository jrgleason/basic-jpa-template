const path = require('path');

module.exports = {
  entry: './src/main/js/index.js',
  output: {
    filename: 'bundle.js',
    path: path.resolve(__dirname, 'src/main/resources/static')
  }
};