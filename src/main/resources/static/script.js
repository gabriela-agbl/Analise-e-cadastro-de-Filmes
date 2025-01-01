$(document).ready(function() {
    // Listar Filmes
    function listarFilmes() {
        $.get("https://localhost:8080/api/filmes/", function(data) {
            $("#listarFilmes").empty(); // Limpa a lista antes de renderizar
            data.forEach(function(filme) {
                $("#listarFilmes").append(`<li>${filme.titulo}</li>`);
            });
        }).fail(function() {
            alert("Erro ao carregar a lista de filmes.");
        });
    }

    listarFilmes(); // Chama a função ao carregar a página

    // Cadastrar Filme
    $("#btn-adicionar").click(function() {
        const titulo = $("#titulo").val();
        const sinopse = $("#sinopse").val();
        const genero = $("#genero").val();
        const anoLancamento = $("#anoLancamento").val();

        const novoFilme = { titulo, sinopse, genero, anoLancamento };

        $.post("https://localhost:8080/api/filmes/", novoFilme, function() {
            alert("Filme cadastrado com sucesso!");
            listarFilmes(); // Atualiza a lista de filmes
            $("#titulo").val("");
            $("#sinopse").val("");
            $("#genero").val("");
            $("#anoLancamento").val("");// Limpa os campos
        }).fail(function() {
            alert("Erro ao cadastrar o filme. Tente novamente.");
        });
    });

    // Atualizar Filme
    $("#btn-atualizar").click(function() {
        const id = $("#id").val();
        const titulo = $("#titulo").val();
        const sinopse = $("#sinopse").val();
        const genero = $("#genero").val();
        const anoLancamento = $("#anoLancamento").val();

        $.ajax({
            url: `https://localhost:8080/api/filmes/atualizar/${id}`,
            method: "PUT",
            contentType: "application/json",
            data: JSON.stringify({ titulo, sinopse, genero, anoLancamento }),
            success: function() {
                alert("Filme atualizado com sucesso!");
                listarFilmes();
            },
            error: function() {
                alert("Erro ao atualizar o filme. Verifique o ID e tente novamente.");
            }
        });
    });

    // Excluir Filme
    $("#btn-excluir").click(function() {
        const id = $("#id").val();

        if (!id) {
            alert("Informe o ID do filme a ser excluído.");
            return;
        }

        if (confirm("Tem certeza de que deseja excluir este filme?")) {
            $.ajax({
                url: `https://localhost:8080/api/filmes/excluir/${id}`,
                method: "DELETE",
                success: function() {
                    alert("Filme excluído com sucesso!");
                    listarFilmes();
                },
                error: function() {
                    alert("Erro ao excluir o filme. Verifique o ID e tente novamente.");
                }
            });
        }
    });
    
    $(document).ready(function() 
    {
    // Listar Filmes
    function listarAnalises() {
        $.get("https://localhost:8080/api/analises/", function(data) {
            $("#listarAnalises").empty(); // Limpa a lista antes de renderizar
            data.forEach(function(analise) {
                $("#listarAnalises").append(`<li>${analise.analise}</li>`
                                            `<li>${analise.nota}</li>`);
            });
        }).fail(function() {
            alert("Erro ao carregar a lista de análises.");
        });
    }});

// Função para criar uma nova análise
function adicionarAnalise(id) {
    const nota = document.getElementById('nota').value;
    const analise = document.getElementById('analise').value;

    const dadosAnalise = {
        nota: parseInt(nota),
        analise: analise
    };

    fetch(`/detalhes/${id}/adicionar-analise`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dadosAnalise)
    })
    .then(response => response.json())
    .then(data => {
        alert('Análise adicionada com sucesso!');
        carregarAnalises(id); // Atualiza a lista de análises
    })
    .catch(error => console.error('Erro ao adicionar análise:', error));
}

// Função para editar uma análise
function atualizarAnalise(id_a) {
    const id = document.getElementById('id').value;
    const nota = document.getElementById('nota').value;
    const analise = document.getElementById('analise').value;

    const dadosAtualizados = {
        nota: parseInt(nota),
        analise: analise
    };

    fetch(`/detalhes/${id}/atualizar-analise/${id_a}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dadosAtualizados)
    })
    .then(response => response.json())
    .then(data => {
        alert('Análise atualizada com sucesso!');
        carregarAnalises(id); // Atualiza a lista de análises
    })
    .catch(error => console.error('Erro ao atualizar análise:', error));
}

// Função para excluir uma análise
function excluirAnalise(id_a) {
    const id = document.getElementById('id').value;

    if (confirm('Tem certeza que deseja excluir esta análise?')) {
        fetch(`/detalhes/${id}/excluir-analise/${id_a}`, {
            method: 'DELETE'
        })
        .then(response => response.json())
        .then(data => {
            alert('Análise excluída com sucesso!');
            carregarAnalises(id); // Atualiza a lista de análises
        })
        .catch(error => console.error('Erro ao excluir análise:', error));
    }
}
    
});