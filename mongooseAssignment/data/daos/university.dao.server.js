const mongoose = require('mongoose');

truncateDatabase = () =>
    //remove all data

populateDatabase = () =>
    //populate with test data

createStudent = (student) =>
    //insert student

createQuestion = (question) =>
    //create new question

answerQuestion = (studentId, questionId, answer) =>
    //inserts an answer by student to question

module.exports = {truncateDatabase, populateDatabase, createStudent, createQuestion, answerQuestion};
