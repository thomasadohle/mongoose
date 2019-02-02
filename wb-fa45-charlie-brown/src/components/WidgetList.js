import React from 'react'

export default class WidgetList
    extends React.Component {
    render() {
        return (

            <div
                className="row col-10 container wbdv-heading-widget centered wbdv-widget"
                data-name="sample-list-widget">
                <div className="row col-lg-12 wbdv-widget-first-row">
                    <div className="col-lg-6 wbdv-widget-title sign">
                        <h3>List Widget</h3>
                    </div>
                    <div className="col-lg-1 ">
                        <ion-icon name="arrow-round-up" className="ion-icon"></ion-icon>
                    </div>
                    <div className="col-lg-1 ">
                        <ion-icon name="arrow-round-down" className="ion-icon"></ion-icon>
                    </div>
                    <div className="col-md-3 wbdv-widget-select-widget-type">
                        <select className="custom-select custom-select-md mb-3">
                            <option selected>List</option>
                            <option value="1">Heading</option>
                            <option value="2">List</option>
                            <option value="3">Image</option>
                            <option value="4">Link</option>
                        </select>
                    </div>
                    <div className="col-lg-1">
                        <ion-icon name="close-circle-outline" className="ion-icon"></ion-icon>
                    </div>
                </div>
                <div className="row col-lg-12 wbdv-heading-widget-enter-heading">
                    <div className="form-group col-12">
								<textarea name="list" type="text" className="form-control"
                                          placeholder="Enter each list item on a separate row.">

					  </textarea>
                    </div>
                </div>
                <div className="row col-lg-12 wbdv-heading-widget-select-size">
                    <div className="col-12">
                        <select className="custom-select custom-select-sm">
                            <option selected>Unordered list</option>
                            <option value="1">Ordered list</option>
                        </select>
                    </div>
                </div>
                <div className="row col-lg-12 wbdv-heading-widget-enter-name">
                    <div className="form-group col-12">
                        <input type="text" className="form-control"
                               placeholder="Widget name"></input>
                    </div>
                </div>
                <div className="row col-lg-12 preview">
                    <h3>Preview</h3>
                </div>
                <div className="row col-lg-12">
                    <ul>
                        <li>Put each</li>
                        <li>list item</li>
                        <li>in a separate</li>
                        <li>row</li>
                    </ul>
                </div>
            </div>
    );
    }
    }