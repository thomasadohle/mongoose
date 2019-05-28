const mongoose = require('mongoose');
const trueFalseSchema = require('./true_false.schema.server')

const trueFalseModel = mongoose.model('TrueFalseModel',trueFalseSchema);

addTrue = () =>
    trueFalseModel.create({_id: 123, isTrue: true})

addFalse = () =>
    trueFalseModel.create({_id: 456, isTrue: false})

getTrueFalse = () =>
    trueFalseModel.find()

module.exports = {addTrue, addFalse, getTrueFalse}
