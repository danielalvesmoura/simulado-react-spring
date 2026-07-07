import Header from "./../../components/header/Header";
import {useState, useEffect} from "react";

import Button from "./../../components/button/Button";

import "./Home.css";

const Home = () => {
    const [data, setData] = useState("");
    const [hora, setHora] = useState("");

    useEffect(() => {
        const agora = new Date();

        setData(agora.toLocaleDateString("pt-BR"));
        setHora(agora.toLocaleTimeString("pt-BR"));
    },[]);

    return (
        <div className="home">
            <Header/>
            <div className="container">
                <p>Olá, você acessou esta página dia {data} às {hora}</p>
                <Button texto="Realizar o Cálculo de Investimento"/>
            </div>
        </div>
    )
}

export default Home;