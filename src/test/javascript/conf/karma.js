

/**
 * Karma configuration
 * Generated on Mon Sep 22 2014 14:21:14 GMT+0400 (MSK)
 * @param {!Object} config
 */
module.exports = function(config) {

  config.set({
    // base path that will be used to resolve all patterns (eg. files, exclude)
    basePath: '../../../..',

    // frameworks to use
    // available frameworks: https://npmjs.org/browse/keyword/karma-adapter
    frameworks: ['mocha', 'chai', 'sinon', 'sinon-chai'],

    // list of files / patterns to load in the browser
    files: [
      './src/main/javascript/**/*.js',
      './src/test/javascript/*.js',
      './src/test/javascript/**/*-spec.js'
    ],

    // list of files to exclude
    exclude: [
      '**/*.swp'
    ],

    // preprocess matching files before serving them to the browser
    // available preprocessors:
    // https://npmjs.org/browse/keyword/karma-preprocessor
    preprocessors: {
      'src/main/javascript/**/*.js': ['coverage']
    },

    // test results reporter to use
    // possible values: 'dots', 'progress', 'spec'
    // available reporters: https://npmjs.org/browse/keyword/karma-reporter
    reporters: ['dots', 'coverage'],

    coverageReporter: {
      reporters: [{
        type: 'text-summary',
        dir: './test/coverage',
        file: 'report.txt'
      }]
    },

    // web server port
    port: 9876,

    hostname: 'karma.dev',

    // enable / disable colors in the output (reporters and logs)
    colors: false,

    // level of logging
    // possible values:
    // config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN ||
    // config.LOG_INFO || config.LOG_DEBUG
    logLevel: config.LOG_INFO,

    // enable / disable watching file and executing tests
    // whenever any file changes
    autoWatch: false,

    // start these browsers
    // available browser launchers:
    // https://npmjs.org/browse/keyword/karma-launcher
    //browsers: ['Chrome'],
    browsers: ['Chrome'],

    // Continuous Integration mode
    // if true, Karma captures browsers, runs the tests and exits
    singleRun: true
  });
};
