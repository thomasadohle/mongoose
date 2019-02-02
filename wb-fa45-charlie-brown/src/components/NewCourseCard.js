import React, {Component} from 'react'

const NewCourseCard = ({course, addCourse}) =>
  <div className="card"
       styles={{width: '18rem'}}>
    <img className="card-img-top"
         src="http://www.indiaeducation.net/imagesvr_ce/2027/Computer%20Science%201.jpg"/>
    <div className="card-body">
      <h4 className="card-title" id="wbdv-page=text">New Course</h4>
      <p className="card-text">Card text</p>
      <a onClick={() => addCourse()}
         className="btn btn-success" id="wbdv-create-button">Add Course</a>
    </div></div>
export default NewCourseCard;