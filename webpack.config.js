const path = require('path');
const { VueLoaderPlugin } = require('vue-loader');
module.exports = {
  entry: path.resolve(__dirname, 'src/main/js/index.js'),
  output: {
      filename: 'bundle.js',
      path: path.resolve(__dirname, 'src/main/resources/static')
  },
  mode: 'development',
  plugins: [
      // make sure to include the plugin!
      new VueLoaderPlugin()
  ],
  resolve: {
      alias: {
              'vue$': 'vue/dist/vue.esm.js'
      }
  },
  module: {
    rules: [
      {
          test: /\.pug$/,
          oneOf: [
              // this applies to <template lang="pug"> in Vue components
              {
                  resourceQuery: /^\?vue/,
                  use: ['pug-plain-loader']
              },
              // this applies to pug imports inside JavaScript
              {
                  use: ['raw-loader', 'pug-plain-loader']
              }
          ]
      },
      {
          test: /\.vue$/,
          loader: 'vue-loader'
      },
      {
        test: /\.css$/,
        use: ["style-loader", "css-loader"]
      },
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
  }
};