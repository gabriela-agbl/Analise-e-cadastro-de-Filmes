//Listar Filmes
$(document).ready(function() {
    // Buscar filmes
    $.get("https://localhost:8080/", function(data) {
        // Renderizar os dados no front-end
        data.forEach(function(filme) {
            $("#listarFilmes").append(`<li>${filme.titulo}</li>`);
        });
    });
});
//Cadastrar Filme
$("#btn-adicionar").click(function() {
    const novoFilme = {
        titulo: $("#titulo").val(),
        descricao: $("#descricao").val()
    };

    $.post("https://localhost:8080/cadastrar", novoFilme, function(response) {
        alert("Filme cadastrado com sucesso!");
        location.reload(); // Atualizar página
    });
});

// Atualizar Filme
$("#btn-atualizar").click(function() {
    const id = $("#id").val();
    const titulo = $("#titulo").val();
    const descricao = $("#descricao").val();

    $.ajax({
        url: `https://localhost:8080/atualizar/${id}`,
        method: "PUT",
        data: { titulo, descricao },
        success: function() {
            alert("Filme atualizado com sucesso!");
            location.reload();
        },
        error: function() {
            alert("Erro ao atualizar o filme. Verifique o ID e tente novamente.");
        }
    });
});

// Excluir Filme
$("#btn-excluir").click(function() {
    const id = $("#id").val();

    if (confirm("Tem certeza de que deseja excluir este filme?")) {
        $.ajax({
            url: `https://localhost:8080/excluir/${id}`,
            method: "DELETE",
            success: function() {
                alert("Filme excluído com sucesso!");
                location.reload();
            },
            error: function() {
                alert("Erro ao excluir o filme. Verifique o ID e tente novamente.");
            }
        });
    }
});