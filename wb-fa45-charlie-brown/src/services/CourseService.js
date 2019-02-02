import courses from './courses.json';

class CourseService {
    constructor() {
        this.courses = courses;
    }
    addCourse = course => {
        if(course === null) {
            course = {
                id: (new Date()).getTime(),
                title: 'New Course'
            }
        }
        course.id = (new Date()).getTime()
        this.courses.push(course)
        return this.courses
    }

    findCourseById = courseId =>
        this.courses = this.courses.find(
            course => course.id === courseId
        )
  findAllCourses = () =>
    this.courses;
  deleteCourse = deleteCourse =>
    this.courses = this.courses.filter(
      course => course.id !== deleteCourse.id
    )


    findCourseModules = courseId => {
        var modules = []
        for (var key in this.courses){
            if (this.courses[key].id === courseId) {
                modules.push(this.courses[key].modules)
            }
        }
        return modules;
    }

    findLessons = modules => {
        var lessonArr = []
        for (var key in modules){
            lessonArr.push(modules[0][key].lessons)
        }
        return lessonArr
    }

    findTopics = lessons => {
        var topics = []
        for (var key in lessons){
            topics.push(lessons[0][key].topics)
        }
        return topics
    }
}
export default CourseService;