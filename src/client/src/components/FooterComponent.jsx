import React, { Component } from 'react';

class FooterComponent extends Component {
    render() {
        return (
            <footer className="footer">
                © {new Date().getFullYear()}  messageboard.com & Co. All rights reserved.
            </footer>
        );
    }
}

export default FooterComponent;