const mongoose = requre('mongoose')
const answerSchema = requre('./answer.schema.server')
module.exports = mongoose.model('AnswerModel', answerSchema)
