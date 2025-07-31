<div align="center">

<h1>🎬 Cadastro e Análise de Filmes</h1>

Bem-vindo ao **Cadastro e Análise de Filmes**! Este projeto foi desenvolvido utilizando **Spring Boot** e **Thymeleaf** para criar uma aplicação web capaz de cadastrar e gerenciar informações sobre filmes. 📽️
</div>

<div align="center">
<h2>📝 Funcionalidades</h2>
</div>

- 📥 **Cadastro de filmes e análises**: Permite inserir informações como título, ano de lançamento, gênero, sinopse e nota.
- 🖋️ **Validação de campos**: Garante que os dados fornecidos estão corretos antes de salvar no banco de dados.
- 🔍 **Listagem de filmes e análises**: Exibe uma tabela com todos os filmes e análises cadastrados. Também exibe os detalhes de cada filme em outra página. 
- 🛠️ **Edição e exclusão**: Atualize ou remova informações de filmes e análises existentes.

<div align="center">
<h2>🛠️ Tecnologias Utilizadas</h2>
</div>

- **Java** ☕
- **CSS e JavaScript** 🌐
- **Spring Boot** 🚀
- **Thymeleaf** 🖼️
- **Bootstrap** 🎨
- **Banco de dados H2** 🗄️
- **MySQL**
- **API**

<div align="center">
<h2>📂 Estrutura do Projeto</h2>
</div>

```plaintext
src/
├── main/
│   ├── java/
│   │   └── com.example.cadastrofilmes/
│   │       ├── controller/   # Controladores responsáveis pelas rotas
│   │       ├── model/        # Modelos de dados
│   │       ├── repository/   # Interfaces para comunicação com o banco
│   │       └── service/      # Lógica de negócio
│   ├── resources/
│   │   ├── templates/        # Páginas HTML com Thymeleaf
│   │   ├── static/           # Arquivos estáticos (CSS e JS)
│   │   │   ├── style.css     # Estilização personalizada
│   │   │   └── script.js     # Funcionalidades adicionais
│   │   └── application.yml   # Configurações da aplicação
└── test/
    └── java/                 # Testes unitários
```

<div align="center">
<h2>🚀 Como Rodar o Projeto</h2>
</div>

Siga os passos abaixo para executar o projeto localmente:

1. **Clone o repositório:**

```bash
git clone https://github.com/gabriela-agbl/Analise-e-cadastro-de-Filmes.git
```

2. **Acesse o diretório do projeto:**

``` bash
cd AnaliseFilme
```

3. **Configure o ambiente: _Certifique-se de que o Java 17 ou superior está instalado_.**

4. **Execute o projeto: _Utilize o Maven para rodar a aplicação_:**
```bash
mvn spring-boot:run
```

5. **Acesse no navegador:  `http://localhost:8080`.**

<div align="center">
<h2>✨ Funcionalidades Finais a Implementar</h2>
</div>

- 📊 Filtro de filmes por gênero ou ano.

- 🌐 Internacionalização (i18n) para suporte a múltiplos idiomas.

<div align="center">
<h2>🤝 Contribuindo</h2>

Contribuições são bem-vindas! Siga os passos abaixo:
</div>

1. Faça um fork do repositório.
2. Crie uma branch para sua feature:
  
```bash
git checkout -b minha-feature
```

3. Faça commit das suas alterações:
  
```bash
git commit -m "Minha nova feature"
```

4. Envie para a branch principal:
  
```bash
git push origin minha-feature
```
5. Abra um Pull Request.

<div align="center">
<h2>📝 Licença</h2>
   Este projeto foi desenvolvido para fins educacionais e está disponível para uso e modificação conforme necessário.

   Feito por [Gabriela Rodrigues](https://github.com/gabriela-agbl)
   
</div>
