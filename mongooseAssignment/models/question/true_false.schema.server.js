const mongoose = require('mongoose')
modules.exports = mongoose.Schema({
    _id: Number,
    isTrue: Boolean
}, {collection: 'questions'})
