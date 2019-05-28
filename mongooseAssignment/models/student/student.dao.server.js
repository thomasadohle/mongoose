const mongoose = require('mongoose');
const studentSchema = require('./student.schema.server');

//Schema chosen is used to validate operations
const studentModel = require('./student.model.server')
//Return JSON with all CRUD methods

findAllStudents = () =>
    studentModel.find();

findStudentById = (userId) =>
    studentModel.find({_id: userId})

createStudent = student =>
    studentModel.create(student)

updateStudent = (id, student) =>
    studentModel.updateOne({_id: id}, {
        $set: student
    })

deleteStudent = id =>
    studentModel.deleteOne({_id: id})

emptyCollection = () =>
    studentModel.deleteMany({}, resp => console.log(resp))

module.exports = {findAllStudents, findStudentById, createStudent, updateStudent, deleteStudent, emptyCollection};
