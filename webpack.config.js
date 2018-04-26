const path = require('path');
const { VueLoaderPlugin } = require('vue-loader');
module.exports = {
  entry: './src/main/js/index.js',
  output: {
    filename: 'bundle.js',
    path: path.resolve(__dirname, 'src/main/resources/static')
  },
  module: {
      rules: [
          { test: /\.vue$/, loader: "vue-loader" },
          { test: /\.css$/, use: [ "style-loader", "css-loader"]},
          {
              test: /\.js$/,
              exclude: /(node_modules|bower_components)/,
              use: {
                  loader: 'babel-loader',
                  options: {
                      presets: ['@babel/preset-env']
                  }
              }
          }
      ]
  },
  resolve:{
      alias: {
          'vue$': 'vue/dist/vue.esm.js'
      }
  },
  plugins: [
      // make sure to include the plugin!
      new VueLoaderPlugin()
  ]
};