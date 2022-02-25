import React, { Component } from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import moment from 'moment';
import MessageService from '../../api/message/MessageService'
import ViewMessageComponent from './ViewMessageComponent'

class MessageComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {

            messages: [],
            id: '',
            email: '',
            message: '',
            date: ''
        }
    }

    componentDidMount() {
        this.refereshData()

    }
    refereshData = () => {
        MessageService.getAllMessages().then(response =>
            this.setState({ messages: response.data.content }))
            .catch(error => console.log(error))
    }

    resetForm = () => {
        this.setState({
            id: '',
            email: '',
            message: '',
            date: ''
        })
    }

    handleMessage = (message) => {
        if (message > 0) {
            console.log("DELETE")
            MessageService.deleteMessageById(message).then(response =>
                this.refereshData()
            )
        }
        else {
            console.log("EDIT")
            MessageService.findMessageById(message.id).then(response => {
                console.log(response.data)
                this.setState({
                    id: response.data.id,
                    email: response.data.email,
                    message: response.data.message,
                    date: moment(response.data.date).format('YYYY-MM-DD')
                })
            }
            )
        }


    }

    onSubmit = (values) => {
        console.log(values)
        if (!values.id) {
            console.log("POST")
            MessageService.saveMessage(values).then(response => {
                this.refereshData()
                this.resetForm()
            })

        } else {
            console.log("PUT")
            MessageService.udateMessage(values.id,values).then(response => {
                this.refereshData()
                this.resetForm()
            })
            
        }
    }

    onValidate = (values) => {
        let errors = {}
        if (!values.email) {
            errors.email = 'Enter an email address'
        } else if (values.email.length < 2) {
            errors.email = '"Email address should have atleast two characters'
        }
        if (!values.message) {
            errors.message = 'Please enter the message '
        } else if (values.message.length < 10) {
            errors.email = 'The minimum characters in the Message should be 10'
        } else if (values.message.length > 500) {
            errors.message = 'The characters in the Message should not exceed 500'
        }
        if (!values.date) {
            errors.date = 'Please select a date '
        }
        return errors
    }

    render() {
        let { id, email, message, date } = this.state
        return (

            <>
                <div className="container">
                    <h3>Add/Edit Messages</h3>
                    <Formik
                        initialValues={{
                            id,
                            email,
                            message,
                            date
                        }}
                        onSubmit={this.onSubmit}
                        validate={this.onValidate}
                        enableReinitialize={true}
                    >
                        <Form >
                            <div className="mb-3">
                                <ErrorMessage name="email" className="alert alert-warning mt-2 mb-2"
                                    component="div" value={this.state.email} />
                                <label htmlFor="email" className="form-label">Email</label>
                                <Field type="email"
                                    id="email" className="form-control"
                                    name="email" placeholder="info@example.com"
                                    values={this.state.email} />
                            </div>
                            <div className="mb-3">
                                <ErrorMessage name="message" className="alert alert-warning mt-2 mb-2"
                                    component="div" value={this.state.message} />
                                <label htmlFor="message" className="form-label">message</label>
                                <Field id="message" className="form-control" name="message" placeholder="Message" />
                            </div>
                            <div className="mb-3">
                                <ErrorMessage name="date" className="alert alert-warning mt-2 mb-2"
                                    component="div" value={this.state.date} />
                                <label htmlFor="date" className="form-label">message</label>
                                <Field type="date" id="date" className="form-control" name="date" placeholder="Message" />
                            </div>
                            <button type="submit" className="btn btn-success">Save</button>
                        </Form>
                    </Formik>

                </div>

                <div className="container">
                    {this.state.messages.map(message =>
                        <div className="mt-2 mb-2" key={message.id}>
                            <ViewMessageComponent message={message} callback={this.handleMessage} />
                        </div>


                    )}
                </div>

            </>
        );
    }
}

export default MessageComponent;