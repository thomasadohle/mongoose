const mongoose = require('mongoose')

const multipleChoiceSchema = mongoose.Schema({
    choices: [String],
    correct: Number
}, {collection: 'multiple_choice'});
module.exports = multipleChoiceSchema;
