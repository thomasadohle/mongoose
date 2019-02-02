import React from 'react'
import ModuleList from "./ModuleList";
import LessonTabs from "./LessonTabs";
import TopicPills from "./TopicPills";
import WidgetHead from "./WidgetHead";
import WidgetParagraph from "./WidgetParagraph";
import WidgetList from "./WidgetList";
import WidgetImage from "./WidgetImage";
import WidgetLink from "./WidgetLink";
import CourseService from "../services/CourseService";

class CourseEditor extends React.Component {
    constructor(props) {
        super(props);
        this.courseService = new CourseService();
        const courseId = parseInt(props.match.params.id);
        const course = this.courseService.findCourseById(courseId);
        const modules = course.modules;
        const lessons = modules.lessons;

        this.state = {
            course: course,
            module: course.modules[0],
            lesson: course.modules[0].lessons[0],
            topic: course.modules[0].lessons[0].topics[0],
        }
    }

    selectModule = module =>
        this.setState({
            module: module,
            lesson: module.lessons[0],
            topic: module.lessons[0].topics[0]

        });

    selectLesson = lesson => {
        this.setState({
            lesson: lesson,
            topic: lesson.topics[0]

        })
    };


    selectTopic = topic => {
        this.setState({
            topic: this.topics[0]
        })
    };


    updateLesson = (lesson) => {
        lesson.title = prompt("Enter Updated Lesson Name: ");
        this.setState({
            modules: this.state.modules
        })
    };

    updateTopic = (topic) => {
        topic.title = prompt("Enter Updated Topic Name: ");
        this.setState({
            modules: this.state.modules
        })
    };



    createLesson = () => {
        const lessonTitle = prompt("Enter New Lesson Name: ");
        const newLesson = {
            "title": lessonTitle
        };
        this.state.module.lessons.push(newLesson);
        this.setState({
            newModule: true
        })
    };

    createTopic = () => {
        const topicTitle = prompt("Enter New Topic Name: ");
        const newTopic = {
            "title": topicTitle
        }
        this.state.lesson.topics.push(newTopic)
        this.setState({
            newTopic: true
        })
    }


    deleteLesson = (lesson) => {
        const lessonsBefore = this.state.module.lessons;
        const lessonsAfter = lessonsBefore.filter(
            less => less.title !== lesson.title
        );
        var newModule = this.state.module;
        newModule.lessons = lessonsAfter;
        console.log(newModule);
        this.setState(
            {
                module: newModule
            }
        )
    };


    deleteTopic = (topic) => {
        const topicsBefore = this.state.lesson.topics;
        const topicsAfter = topicsBefore.filter(
            top => top.title !== topic.title
        );
        var newLesson = this.state.lesson;
        newLesson.topics = topicsAfter;
        this.setState(
            {
                lesson: newLesson
            }
        )
    };


    render() {
        return (
            <div className="container-fluid col-12">
                <h2>Course Editor: {this.state.course.title}
                <button className="btn btn-primary float-right" id="wbdv-add-widget-button">Add Widget
                </button></h2>

                <div className="row">

                    <div className="col-lg-3">
                        <ModuleList
                            selectModule={this.selectModule}
                            modules={this.state.course.modules}/>
                    </div>


                    <div className="row col-9">
                        <LessonTabs lessons={this.state.module.lessons}
                                    selectLesson={this.selectLesson}
                                    createLesson={this.createLesson}
                                    deleteLesson={this.deleteLesson}
                                    updateLesson={this.updateLesson}/>

                        <div className="row col-12">
                        </div>

                        <br/>
                        <div className="row col-12">
                            <TopicPills topics={this.state.lesson.topics}
                                        selectTopics={this.selectTopic}
                                        updateTopic={this.updateTopic}
                                        createTopic={this.createTopic}
                                        deleteTopic={this.deleteTopic}/>

                        </div>
                        <br/>
                        <div className="row col-12 container"
                             id="wbdv-widget-container">
                            <div>
                                <WidgetHead/>
                                <WidgetParagraph/>
                                <WidgetList/>
                                <WidgetImage/>
                                <WidgetLink/>

                            </div>
                        </div>
                    </div>

                </div>
            </div>

        )
    }
}

export default CourseEditor