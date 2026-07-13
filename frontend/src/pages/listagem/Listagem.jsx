import Header from "../../components/header/Header";
import {useState, useEffect} from "react";

import Botao from "../../components/button/Button";
import Campo from "../../components/campo/Campo";

import {calcularInvestimento, salvarInvestimento, listarInvestimentos} from "../../services/InvestimentoService";

import "./Listagem.css";

const Listagem = () => {

    const [valorFinal, setValorFinal] = useState(null);

    const [formulario, setFormulario] = useState({
        valorInicial: "",
        prazoMeses: "",
        jurosMensal: ""
    })

    const [erro, setErro] = useState("");
    const [carregando, setCarregando] = useState(false);
    const [mensagem, setMensagem] = useState("");
    const [investimentos, setInvestimentos] = useState([]);

    useEffect(() => {
        carregarInvestimentos();
    },[])

    async function carregarInvestimentos() {
        try {
            const dados = await listarInvestimentos();
            setInvestimentos(dados);
        } catch (error) {
            setErro(error.message);
        }
    }

    function validarFormulario() {
        const valorInicial = Number(formulario.valorInicial);
        const prazoMeses = Number(formulario.prazoMeses);
        const jurosMensal = Number(formulario.jurosMensal);

        if(formulario.valorInicial === "" || formulario.prazoMeses === "" || formulario.jurosMensal === "") {
            setErro("Preencha todos os campos");
            return false;
        }

        if(valorInicial <= 0) {
            setErro("Valor inicial tem que ser maior que 0.");
            return false;
        }

        if(prazoMeses <= 0) {
            setErro("O prazo tem que ser maior que 0.");
            return false;
        }

        if(!Number.isInteger(prazoMeses)) {
            setErro("O prazo tem que ser um número inteiro.");
            return false;
        }

        if(jurosMensal <= 0) {
            setErro("O juros tem que ser maior que 0.");
            return false;
        }

        return true;
    }

    function montarDados() {
        return {
            valorInicial: Number(formulario.valorInicial),
            prazoMeses: Number(formulario.prazoMeses),
            jurosMensal: Number(formulario.jurosMensal)
        }
    }

    async function handleCalcular(event) {
        event.preventDefault();

        if(!validarFormulario()) {
            return;
        }

        try {
            setCarregando(true);
            const resposta = await calcularInvestimento(montarDados());
            setValorFinal(resposta.valorFinal);

            setErro("");
        } catch (error) {
            setErro(error.message);
            setMensagem("");
        } finally {
            setCarregando(false);
        }
    }

    async function handleSalvar(event) {
        event.preventDefault();

        if(valorFinal === null) {
            setErro("Não há valor para ser salvo.");
            return;
        }

        try {
            setCarregando(true);

            const investimentoSalvo = await salvarInvestimento(montarDados());

            setInvestimentos((investimentosAtuais) => [
                ...investimentosAtuais,
                investimentoSalvo
            ])
            
            setErro("");
            setMensagem("Cálculo salvo com sucesso!");
        } catch (error) {
            setErro(error.message);
            setMensagem("");
        } finally {
            setCarregando(false);
        }
    }

    function handleChange(event) {
        const {name, value} = event.target;

        setFormulario(formularioAtual => ({
            ...formularioAtual,
            [name]: value
        }));

        setValorFinal(null);
        setErro("");
        setMensagem("");
    }

    return (
        <div className="listagem">
            <Header subtitulo="Listagem"/>

            <form onSubmit={handleCalcular}>
                <Campo name="valorInicial" value={formulario.valorInicial} handleChange={handleChange} label="Valor Inicial"/>
                <Campo name="prazoMeses" value={formulario.prazoMeses} handleChange={handleChange} label="Prazo em Meses"/>
                <Campo name="jurosMensal" value={formulario.jurosMensal} handleChange={handleChange} label="Juros Mensal"/>

                <p className="erro">{erro}</p>

                <Botao texto={carregando ? "Carregando..." : "Calcular"} disabled={carregando} largura="15rem" tipo="submit"/>
            </form>

            {valorFinal !== null && (
                <p className="valor-final">O valor final será de {valorFinal}</p>
            )}

            <Botao texto={carregando ? "Carregando..." : "Salvar Cálculo"} disabled={carregando} onClick={handleSalvar} largura="15rem"/>

            <p className="mensagem">{mensagem}</p>

            

            <section className="ultimos-calculos">
                <h2>ÚLTIMOS CÁLCULOS REALIZADOS</h2>

                {investimentos.length === 0 
                    ? (<p>Nenhum dado encontrado</p>) 
                    : <table>
                        <thead>
                            <tr>
                                <th>Data Cálculo</th>
                                <th>Valor Inicial</th>
                                <th>Prazo Juros</th>
                                <th>Juro</th>
                                <th>Valor Final</th>
                            </tr>
                        </thead>

                        <tbody>
                            {investimentos.map(investimento => (
                                    <tr key={investimento.id}>
                                        <td>{investimento.dataCalculo}</td>
                                        <td>{investimento.valorInicial}</td>
                                        <td>{investimento.prazoMeses}</td>
                                        <td>{investimento.jurosMensal}</td>
                                        <td>{investimento.valorFinal}</td>
                                    </tr>
                                ))
                            }
                        </tbody>
                    </table>
                }

                
            </section>
            
        </div>
    )
}

export default Listagem;