import "./Button.css";

import {Link} from "react-router-dom";

function Button(props) {
    return (
        <Link to="/listagem" className="button">
            {props.texto}
        </Link>
    )
}

export default Button;