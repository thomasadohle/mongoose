import React, {Component} from 'react'
import {BrowserRouter as Router, Link, Route} from 'react-router-dom'
import CourseGrid from './CourseGrid'
import CourseTable from './CourseTable'
import CourseService from '../services/CourseService'
import CourseEditor from "./CourseEditor"
import './WhiteBoard.style.css'


class WhiteBoard extends Component {
    constructor() {
        super();
        this.courseService = new CourseService()
        this.state = {
            courses: this.courseService.findAllCourses()
        }
    }

    deleteCourse = course =>
        this.setState({
            courses: this.courseService.deleteCourse(course)
        })
    addCourse = () =>
        this.setState({
            courses: this.courseService.addCourse(null)
        })

    render() {
        return (
            <div className="container-fluid" id="wbdv-page-container">
                <div className="container-fluid">
                    <div className="row" id="wbdv-top-nav">

                        <div className="col-lg-10 col-sm-8" id="wbdv-course-title">CS5610 - Web Dev</div>
                    </div>

                    <Router>
                        <div id="wbdv-page-link">
                            <Link to="/">Course Grid </Link> |
                            <Link to="/table"> Course Table </Link>
                            <Route path='/' exact
                                   render={() =>
                                       <CourseGrid
                                           addCourse={this.addCourse}
                                           deleteCourse={this.deleteCourse}
                                           courses={this.state.courses}/>}/>
                            <Route path="/course/:id"
                                   exact
                                   component={CourseEditor}/>
                            <Route path='/table'
                                   render={() => <CourseTable courses={this.state.courses}/>}/>
                        </div>
                    </Router>
                </div>
            </div>


        )
    }
}

export default WhiteBoard;