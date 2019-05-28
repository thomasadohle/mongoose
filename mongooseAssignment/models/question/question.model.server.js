const mongoose = requre('mongoose')
const questionSchema = requre('./question.schema.server')
module.exports = mongoose.model('QuestionModel', questionSchema)
