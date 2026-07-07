import "./Header.css";

function Header(props) {
    return (
        <div className="header">
            <h1>Cálculo de Investimento</h1>
            {props.subtitulo !== null && (
                <h2>- {props.subtitulo}</h2>
            )}
        </div>
    )
}

export default Header;