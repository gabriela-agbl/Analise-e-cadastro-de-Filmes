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
    
    // Listar análises
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
    };

//adicionar uma análise
$("#btn-adicionar-analise").click(function() {
        const nota = $("#nota").val();
        const analise = $("#analise").val();
        
        const novaAnalise = { nota, analise };

        $.post("https://localhost:8080/api/analises/cadastrar", novaAnalise, function() {
            alert("Analise cadastrada com sucesso!");
            listarAnalises(); // Atualiza a lista de análises
        }).fail(function() {
            alert("Erro ao cadastrar a análise. Tente novamente.");
        });
    });

//excluir uma análise
$("#btn-excluir-analise").click(function() {
        const id_a = $("#id_a").val();

        if (!id_a) {
            alert("Informe o ID da análise a ser excluído.");
            return;
        }

        if (confirm("Tem certeza de que deseja excluir esta analise?")) {
            $.ajax({
                url: `https://localhost:8080/api/analises/excluir/${id_a}`,
                method: "DELETE",
                success: function() {
                    alert("Análise excluída com sucesso!");
                    listarAnalises();
                },
                error: function() {
                    alert("Erro ao excluir a análise. Verifique o ID e tente novamente.");
                }
            });
        }
    });
    
});