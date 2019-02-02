import React from 'react'
import TopicPillsItem from "./TopicPillsItem"

const TopicPills = ({topics, createTopic, deleteTopic, updateTopic}) =>
    <div>

        <ul className="nav nav-pills">
            {
                topics.map(topic =>
                    <li key={topic.id} className="nav-item active" id="topicPillsItem">

                        <div className="col-12">
                            <button type="nav-item nav" className="wbdv-topic-link" id={topic.title}
                                    onClick={() => {
                                        document.getElementById(topic.title).classList.add("active")

                                    }}>{topic.title}</button>


                            <ion-icon name="create" size="x-small" id="update-topic-pills"
                                      onClick={() => {
                                          updateTopic(topic)
                                      }}/>

                            <ion-icon name="close-circle-outline" size="x-small" id="delete-topic-pills"
                                      onClick={() => {
                                          deleteTopic(topic)
                                      }}/>
                        </div>
                    </li>)
            }
            <li className="list-group-item nav-item" id="addNewTopic">
                <div className="col-12" id="addNewTopicDiv">
                    <ion-icon name="add" size="small"
                              onClick={() => {
                                  createTopic()
                              }}/>
                </div>
            </li>
        </ul>
    </div>;
export default TopicPills


