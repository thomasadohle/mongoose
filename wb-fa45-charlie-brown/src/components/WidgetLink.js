import React from 'react'
export default class WidgetLink
    extends React.Component {
    render() {
        return (


            <div
                className="row col-10 container wbdv-heading-widget centered wbdv-widget"
                data-name="sample-link-widget">
                <div className="row col-lg-12 wbdv-widget-first-row">
                    <div className="col-lg-6 wbdv-widget-title sign">
                        <h3>Link Widget</h3>
                    </div>
                    <div className="col-lg-1 ">
                        <ion-icon name="arrow-round-up" className="ion-icon"></ion-icon>
                    </div>
                    <div className="col-lg-1 ">
                        <ion-icon name="arrow-round-down" className="ion-icon"></ion-icon>
                    </div>
                    <div className="col-lg-3 wbdv-widget-select-widget-type">
                        <select className="custom-select custom-select-md mb-3">
                            <option selected>Link</option>
                            <option value="1">Paragraph</option>
                            <option value="2">List</option>
                            <option value="3">Image</option>
                            <option value="4">Heading</option>
                        </select>
                    </div>
                    <div className="col-lg-1">
                        <ion-icon name="close-circle-outline" className="ion-icon">"</ion-icon>
                    </div>
                </div>
                <div className="row col-lg-12 wbdv-heading-widget-enter-link">
                    <div className="form-group col-12">
                        <input type="text" className="form-control"
                               placeholder="http://lynda.northeastern.edu/"></input>
                    </div>
                </div>
                <div className="row col-lg-12 wbdv-heading-widget-enter-link">
                    <div className="form-group col-12">
                        <input type="text" className="form-control" placeholder="Link text"></input>
                    </div>
                </div>
                <div className="row col-lg-12 wbdv-heading-widget-enter-link">
                    <div className="form-group col-12">

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
                    <a href="http://lynda.northeastern.edu/">Link text</a>
                </div>
            </div>


        );
    }
}