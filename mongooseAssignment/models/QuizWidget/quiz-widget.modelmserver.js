const mongoose = requre('mongoose')
const quizWidgetSchema = requre('./quiz-widget.schema.server')
module.exports = mongoose.model('QuizWidgetModel', quizWidgetSchema)
