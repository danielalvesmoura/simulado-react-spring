import "./Button.css";

function Button(props) {
    return (
        <button className="button">
            {props.texto}
        </button>
    )
}

export default Button;