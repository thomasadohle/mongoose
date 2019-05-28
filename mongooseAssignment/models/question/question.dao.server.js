const mongoose = require('mongoose');
const questionModel = require('./question.model.server')
const questionSchema = require('./question.schema.server');
const multipleChoiceSchema = require('./multiple_choice.schema.server');
const trueFalseSchema = require('./true_false.schema.server');

findAllQuestions = () =>
    questionModel.find();

findQuestionById = (questionId) =>
    questionModel.find({_id: questionId})

createQuestion = question =>
    questionModel.create(question)

updateQuestion = (id, question) =>
    questionModel.updateOne({_id: id}, {
        $set: question
    })

deleteQuestion = id =>
    questionModel.deleteOne({_id: id})

emptyCollection = () =>
    questionModel.deleteMany({}, resp => console.log(resp))

module.exports = {findAllQuestions, findQuestionById, createQuestion, updateQuestion, deleteQuestion, emptyCollection}
