import React from 'react'

const LessonTabs = ({lessons, selectLesson, createLesson, deleteLesson, updateLesson}) =>
    <ul className="nav nav-tabs">
        {
            lessons.map(lesson =>
                <li key={lesson.id} className="nav-item " id="lessonListItem">

                    <div className="col-12" id="wbdv-lesson-tabs">
                        <button type="nav-item nav" className="wbdv-lesson-link" id={lesson.title}
                                onClick={() => {
                                    document.getElementById(lesson.title).classList.add("active")
                                    selectLesson(lesson)
                                }
                                }>{lesson.title}</button>
                        <ion-icon  name="close-circle-outline" size="xsmall" id="delete-lesson-tabs"
                                  onClick={() => {
                                      deleteLesson(lesson)
                                  }}/>
                        <ion-icon  name="create" size="xsmall" id="update-lesson-tabs"
                                  onClick={() => {
                                      updateLesson(lesson)
                                  }}/>
                    </div>
                </li>
            )
        }
        <li className="list-group-item nav-item" id="addNewLesson">
            <div className="col-12" id="addNewLessonDiv">
                <ion-icon name="add" size="small"
                          onClick={() => {
                              createLesson()
                          }}/>
            </div>
        </li>
    </ul>
export default LessonTabs



