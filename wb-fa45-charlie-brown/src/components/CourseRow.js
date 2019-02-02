import React, {Component} from 'react'
import {Link} from 'react-router-dom'

const CourseRow = ({course_, deleteCourse, courseDeleted}) =>
    <tr>
        <td scope="row">
            <Link to={`/course/${course_.id}`}>
                <a
                    href="../course-editor/course-editor.template.client.html">
                    <ion-icon name="paper" size="large" className="wbdv-options-icon"></ion-icon>
                </a>
            </Link>
        </td>
        <td>{course_.title}</td>
        <td>me</td>
        <td>6:45</td>
        <td>

            <ion-icon name="close-circle-outline" size="large" id="delete-course"
                      onClick={() => {
                          deleteCourse(course_)
                          courseDeleted();
                      }}/>
        </td>
    </tr>;
export default CourseRow;


