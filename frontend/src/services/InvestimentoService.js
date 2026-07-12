API_URL = "http://localhost:8080/api/investimentos"

async function tratarResposta(response) {
    if(!response.ok) {
        const erro = response.json().catch(() => null);

        const mensagem = erro?.mensagem || "Não foi possível concluir a operação.";

        throw new Error(mensagem);
    }

    if(response.status === 204) {
        return null;
    }

    return response.json();
}

export async function calcularInvestimento(dados) {
    const response = await fetch(`${API_URL}/calcular`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(dados)
    });

    return tratarResposta(response);
}

export async function salvarInvestimento(dados) {
    const response = await fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(dados)
    });

    return tratarResposta(response);
}

export async function listarInvestimentos() {
    const response = await fetch(API_URL);

    return tratarResposta(response);
}

export async function excluirInvestimento() {
    const response = await fetch(API_URL, {
        method: "DELETE"
    });

    return tratarResposta(response);
}

