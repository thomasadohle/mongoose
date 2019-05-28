require('../../data/db')();
const answerDao = require('./answer.dao.server');
const mongoose = require('mongoose');

answerDao.createAnswer({
    _id: 888,
    multipleChoiceAnswer: 1,
     student: mongoose.Schema.Types.ObjectId(123),
     question:  mongoose.Schema.Types.ObjectId(2342343242)
}).then(answerDao.findAllAnswers().then(resp => console.log(resp)))
