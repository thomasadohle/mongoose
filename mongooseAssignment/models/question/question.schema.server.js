const mongoose = require('mongoose')
const TrueFalseSchema = require('./true_false.schema.server')
const MultipleChoiceSchema = require('./multiple_choice.schema.server.js')
module.exports = mongoose.Schema({
    _id: Number,
    question: String,
    points: Number,
    questionType: String,
    multipleChoice: MultipleChoiceSchema,
    trueFalse: TrueFalseSchema
}, {collection: 'questions'})
