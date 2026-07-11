import "./Button.css";

import {Link} from "react-router-dom";

function Button({texto, destino = "/listagem"}) {
    return (
        <Link className="button">
            {texto}
        </Link>
    )
}

export default Button;