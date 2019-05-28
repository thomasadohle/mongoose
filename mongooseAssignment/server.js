var express = require('express');
var app = express();
var bodyParser = require('body-parser')
require('./data/db')();
const studentDao = require('./models/student/student.dao.server');
const questionDao = require('./models/question/question.dao.server');
app.use(bodyParser.json());

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


app.listen(3000);
