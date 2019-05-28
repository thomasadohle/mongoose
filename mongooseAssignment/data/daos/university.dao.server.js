const mongoose = require('mongoose');
const answerDao = require('../../models/answer/answer.dao.server')

truncateDatabase = () =>
    console.log('truncate')
    // answerDao.emptyCollection().then(res => {
    //     answerDao.findAllAnswers().then(res => console.log("answers: " + res))
    // })

populateDatabase = () =>
    console.log('populate')

createStudent = (student) =>
    //insert student

createQuestion = (question) =>
    //create new question

answerQuestion = (studentId, questionId, answer) =>
    //inserts an answer by student to question

module.exports = {truncateDatabase, populateDatabase, createStudent, createQuestion, answerQuestion};
