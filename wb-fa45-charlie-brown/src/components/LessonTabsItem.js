import React from 'react'

const LessonTabsItem = ({lesson, selectLesson}) =>
    <li onClick={() => selectLesson(lesson)} className="nav-link active">
        {lesson.title}
    </li>

export default LessonTabsItem;


