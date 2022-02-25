import { Formik, Form, Field } from 'formik';
import React, { Component } from 'react';

class FormikComponent extends Component {

    onSubmit =(values)=>{
        alert(JSON.stringify(values,null,2))
    }
    render() {
        return (
            <div>
                <h1>Sign Up</h1>
                <Formik
                    initialValues={{
                        firstName:'',
                        lastName:'',
                        email:''
                    }}
                    onSubmit={this.onSubmit}
                    >
                        <Form>

                            <label htmlFor="firstName">First Name</label>
                            <Field id="firstName" name="firstName" placeholder="Sha" />

                            <label htmlFor="lastName">First Name</label>
                            <Field id="lastName" name="lastName" placeholder="Jahan" />

                            <label htmlFor="email">Email</label>
                            <Field id="email" name="email" placeholder="sha@example.com" type="email" />

                            <button type="submit">Submit</button>

                        </Form>
                </Formik>
            </div>
        );
    }
}

export default FormikComponent;