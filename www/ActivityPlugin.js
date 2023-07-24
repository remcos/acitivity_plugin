var exec = require('cordova/exec');

exports.activityMethod = function(message, success, error) {
    exec(success, error, 'JedlixPlugin', 'activityMethod', [message]);
};