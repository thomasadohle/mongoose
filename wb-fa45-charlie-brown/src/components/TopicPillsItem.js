import React from 'react'

const TopicPillsItem = ({topic, selectTopic}) =>
    <li onClick={() => selectTopic(topic)} className="nav nav-link">
        {topic.title}
    </li>

export default TopicPillsItem;


