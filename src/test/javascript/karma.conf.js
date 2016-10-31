
//Karma configuration

module.exports = function(config) {
    config.set({
        basePath: '',

        reporters: ['progress', 'html'],

        htmlReporter: {
            outputFiles: 'test/units.html'
        },

        //frameworks to use
        frameworks : ['jasmine'],

        files: [

        ],

        exclude: [
        ],

        preprocessors: {
        },

        reporters: ['progress'],

        port: 9876,
        colors: true,
        logLevel: config.LOG_INFO,
        autowatch: false,

        browsers: ['PhantomJS'],
        singleRun: false,

        concurrency: Infinity
    })
}