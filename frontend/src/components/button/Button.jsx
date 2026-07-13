import "./Button.css";

import {Link} from "react-router-dom";

function Button({texto, largura, destino, tipo, disabled, onClick}) {
    if(destino) {
        return (
            <Link className="button" to={destino}>
                {texto}
            </Link>
        )
    }

    return (
        <button 
            className="button" 
            type={tipo} 
            style={{"--largura": largura}}
            disabled={disabled}
            onClick={onClick}
        >
            {texto}
        </button>
    )
    
    
}

export default Button;