const mongoose = require('mongoose');
const answerSchema = require('./answer.schema.server');

const answerModel = require('./answer.model.server')

findAllAnswers = () =>
    answerModel.find()

findAnswerById = (id) =>
    answerModel.find({_id: id})

createAnswer = answer =>
    answerModel.create(answer)

updateAnswer = (id, answer) =>
    answerModel.updateOne({_id: id}, {
        $set: answer
    })

deleteAnswer = id =>
    answerModel.deleteOne({_id: id})

emptyCollection = () =>
    answerModel.deleteMany({}, resp => console.log(resp))

module.exports = {findAllAnswers, findAnswerById, createAnswer, updateAnswer, deleteAnswer, emptyCollection}
