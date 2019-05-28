const mongoose = require('mongoose')
const trueFalseSchema = mongoose.Schema({
    isTrue: Boolean
}, {collection: 'true_false'});
module.exports= trueFalseSchema;
