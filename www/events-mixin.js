var Mixin = require('./mixin'),
    channel = require("cordova/channel"),
    channelIds = 0;

module.exports = Mixin({
    initEvents: function (prefix) {
        if (!this._channelPrefix) {
            this._channelPrefix = prefix + "." + (channelIds++);
        }
    },

    _prefix: function (type) {
        return this._channelPrefix + "." + type;
    },

    _channel: function (type, sticky) {
        var t = this._prefix(type);
        if (!this._channels) {
            this._channels = {};
        }
        if (sticky !== undefined) {
            this._channels[t] = sticky ?
                channel.createSticky(t) :
                channel.create(t);
        }
        return this._channels[t];
    },

    createChannel: function (type) {
        this._channel(type, false);
    },

    createStickyChannel: function (type) {
        this._channel(type, true);
    },

    once: function (type, listener) {
        var onEvent = function (e) {
                listener(e);
                this.off(type, onEvent);
            };
        this.on(type, onEvent.bind(this));
    },

    on: function (type, listener) {
        this._channel(type).subscribe(listener);
    },

    off: function (type, listener) {
        this._channel(type).unsubscribe(listener);
    },

    fire: function (type, e) {
        this._channel(type).fire(e);
    }
});
