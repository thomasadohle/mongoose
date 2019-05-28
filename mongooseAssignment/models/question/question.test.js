require('../../data/db')();
const questionDao = require('./question.dao.server');
const trueFalseDao = require('./true_false.dao.server')

// trueFalseDao.addFalse().then(response => {
//         trueFalseDao.addTrue().then(response => {
//             trueFalseDao.getTrueFalse().then(response => console.log(response))
//         })
//
//     }
// )
//
// questionDao.createQuestion({
//     _id: 321,
//     points: 10,
//     type: "TRUE_FALSE",
//     trueFalse: {
//         _id: 282,
//         isTrue: false
//     }
// })

trueFalseDao.getTrueFalse().then(res => console.log(res))
