import React, { Component } from 'react';

class ViewMessageComponent extends Component {

    edit = (message) => {
        this.props.callback(message, "EDIT");
    }

    delete = (id) => {
        this.props.callback(id,"DEL");
    }

    render() {
        return (
            <div className="card" >
                <div className="card-body">
                    
                    <h5 className="card-title">{this.props.message.email} </h5>
                    <p className="card-text">{this.props.message.message}</p>
                    <p><span>{this.props.message.date}</span></p>
                    <button className="btn btn-info" onClick={()=> this.edit(this.props.message)}>Edit</button>
                    <button className="btn btn-danger" onClick={()=> this.delete(this.props.message.id)}>Delete</button>
                    
                </div>
          </div>
        );
    }
}

export default ViewMessageComponent;