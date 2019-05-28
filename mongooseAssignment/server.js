var express = require('express');
var app = express();
var bodyParser = require('body-parser')
require('./data/db')();
const studentDao = require('./models/student/student.dao.server');
const questionDao = require('./models/question/question.dao.server');
const answerDao = require('./models/answer/answer.dao.server');
const uniDao = require('./data/daos/university.dao.server')
app.use(bodyParser.json());

//University API endpoints at end of file

//Student API endpoints
app.post('/api/student', function(req, res){
    const newStudent = req.body;
    console.log(newStudent);
    studentDao.createStudent(newStudent).then(studentDao.findAllStudents().then(resp => res.send(resp)));
})

app.get('/api/student', function(req, res){
    studentDao.findAllStudents().then(resp => res.send(resp));
});

app.get('/api/student/:studentId', function(req, res){
    var id = req.params['studentId'];
    studentDao.findStudentById(id).then(resp => res.send(resp));
});

app.put('/api/student/:studentId', function(req, res){
    const id  = req.params['studentId'];
    const update = req.body;
    studentDao.updateStudent(id, update)
        .then(studentDao.findAllStudents()
            .then(response => res.send(response)));
})

app.delete('/api/student/:studentId', function(req, res){
    const id = req.params['studentId'];
    studentDao.deleteStudent(id).
    then(studentDao.findAllStudents().
    then(response => res.send(response)))
})



//Question API endpoints
app.post('/api/question', function(req, res){
    const newQuestion = req.body;
    questionDao.createQuestion(newQuestion)
        .then(questionDao.findAllQuestions()
            .then(resp => res.send(resp)));
})

app.get('/api/question', function(req, res){
    questionDao.findAllQuestions()
        .then(resp => res.send(resp));
});

app.get('/api/question/:questionId', function(req, res){
    var id = req.params['questionId'];
    questionDao.findQuestionById(id)
        .then(resp => res.send(resp));
});

app.put('/api/question/:questionId', function(req, res){
    const id  = req.params['questionId'];
    const update = req.body;
    questionDao.updateQuestion(id, update)
        .then(questionDao.findAllQuestions()
            .then(response => res.send(response)));
})

app.delete('/api/question/:questionId', function(req, res){
    const id = req.params['questionId'];
    questionDao.deleteQuestion(id).
    then(questionDao.findAllQuestions().
    then(response => res.send(response)))
})


//Answer API endpoints

app.post('/api/answer', function(req, res){
    const newAnswer = req.body;
    answerDao.createAnswer(newAnswer)
        .then(answerDao.findAllAnswers()
            .then(resp => res.send(resp)));
})

app.get('/api/answer', function(req, res){
    answerDao.findAllAnswers()
        .then(resp => {
            console.log(resp);
            res.send(resp)
        });
});

app.get('/api/answer/:answerId', function(req, res){
    var id = req.params['answerId'];
    answerDao.findAnswerById(id)
        .then(resp => res.send(resp));
});

app.put('/api/answer/:answerId', function(req, res){
    const id  = req.params['answerId'];
    const update = req.body;
    answerDao.updateAnswer(id, update)
        .then(answerDao.findAllAnswers()
            .then(response => res.send(response)));
})

app.delete('/api/answer/:answerId', function(req, res){
    const id = req.params['answerId'];
    answerDao.deleteAnswer(id).
    then(answerDao.findAllAnswers().
    then(response => res.send(response)))
})



//University API endpoints
app.delete('/api/all', function(req, res){
    answerDao.emptyCollection().then(resp =>
        questionDao.emptyCollection().then(resp =>
            studentDao.emptyCollection().then(resp => console.log(resp))))
        .then(resp => res.send(resp))})

const alice = {
    _id: 123, firstName: 'Alice', lastName: 'Wonderland', username: 'alice', password: 'alice', gradYear: 2020, scholarship: 15000
}
const bob = {
    _id: 234, firstName: "Bob", lastName: "Hope", username: "bob", password: "bob", gradYear: 2021, scholarship: 12000
}
const q1 = {
    _id: 321, question: "Is the following schema valid?", points: 10, type: 'TRUE_FALSE', trueFalse: {isTrue: false}
}
const q2 = {
    _id: 432, question: "DAO stands for Dynamic Access Object", points: 10, type: 'TRUE_FALSE', trueFalse: {isTrue: false}
}
const q3 = {
    _id: 543, question: "What does JPA stand for?", points: 10, type: 'MULTIPLE_CHOICE',
    multipleChoice: {choices: ["Java Persistence API", "Java Persisted Application", "JavaScript Persistence API", "JSON Persistent Applications"],
    correct: 1}
}
const q4 = {
    _id: 654, question: "What does ORM stand for?", points: 10, type: 'MULTIPLE_CHOICE',
    multipleChoice: {choices: ["Object Relational Model", "Object Relative Markup", "Object Reflexive Model", "Object Relational Mapping"],
        correct: 4}
}
const a1 = {_id: 123, trueFalseAnswer: true, student: 123, question: 321}
const a2 = {_id: 234, trueFalseAnswer: false, student: 123, question: 432}
const a3 = {_id: 345, MultipleChoiceAnswer: 1, student: 123, question: 543}
const a4 = {_id: 456, MultipleChoiceAnswer: 2, student: 123, question: 654}

const b1 = {_id: 567, trueFalseAnswer: false, student: 234, question: 321}
const b2 = {_id: 678, trueFalseAnswer: true, student: 234, question: 432}
const b3 = {_id: 789, MultipleChoiceAnswer: 3, student: 234, question: 543}
const b4 = {_id: 890, MultipleChoiceAnswer: 4, student: 234, question: 654}

app.post('/api/populate', function(req, response){
    studentDao.createStudent(alice).then(res =>
    studentDao.createStudent(bob).then(res =>
    questionDao.createQuestion(q1).then(res =>
    questionDao.createQuestion(q2).then(res =>
    questionDao.createQuestion(q3).then(res =>
    questionDao.createQuestion(q4).then(res =>
        answerDao.createAnswer(a1).then(res =>
        answerDao.createAnswer(a2).then(res =>
        answerDao.createAnswer(a3).then(res =>
        answerDao.createAnswer(a4).then(res =>
        answerDao.createAnswer(b1).then(res =>
        answerDao.createAnswer(b2).then(res =>
        answerDao.createAnswer(b3).then(res =>
        answerDao.createAnswer(b4).then(resp => response.send(resp)))))))))
    ))))))

})

app.listen(3000);
