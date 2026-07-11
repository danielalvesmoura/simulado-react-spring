const API_URL = "http://localhost:8080/api/investimentos";

async function tratarResposta(response) {
    if(!response.ok) {
        const erro = response.json().catch(() => null);

        const mensagem = erro?.mensagem || "não deu bom";

        throw new Error(mensagem);
    }

    if(resposta.status === 204) {
        return null
    }

    return response.json();
}

export async function calcularInvestimento(dados) {
    const response = await
}