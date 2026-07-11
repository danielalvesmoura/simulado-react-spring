import "./Header.css";

function Header({subtitulo}) {
    return (
        <div className="header">
            <h1>Cálculo de Investimento</h1>
            {subtitulo && (
                <h2>- {subtitulo}</h2>
            )}
        </div>
    )
}

export default Header;