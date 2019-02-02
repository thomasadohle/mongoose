import React, {Component} from 'react'
import {Link} from 'react-router-dom'

const CourseCard = ({course, deleteCourse, courseDeleted}) =>
    <div className="card"
         styles={{width: '18rem'}}>
        <img className="card-img-top"
             src="https://www.eschoolnews.com/files/2017/07/computer-science-600x400.jpg"/>
        <div className="card-body">
            <h4 className="card-title">{course.title}</h4>
            <p className="card-text">Card text.</p>

            <Link className="btn btn-primary" to={`/course/${course.id}`}>Edit</Link>
            <a onClick={() => {
                deleteCourse(course);

            }}
               className="btn btn-danger" id="wbdv-delete-button">Delete</a>
        </div>
    </div>;
export default CourseCard;


