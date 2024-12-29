# 🎬 Projeto de Cadastro e Análise de Filmes

Bem-vindo ao **Projeto de Cadastro e Análise de Filmes**! Este projeto foi desenvolvido utilizando **Spring Boot** e **Thymeleaf** para criar uma aplicação web capaz de cadastrar e gerenciar informações sobre filmes. 📽️

## 📝 Funcionalidades
- 📥 **Cadastro de filmes e análises**: Permite inserir informações como título, ano de lançamento, gênero, sinopse e nota.
- 🖋️ **Validação de campos**: Garante que os dados fornecidos estão corretos antes de salvar no banco de dados.
- 🔍 **Listagem de filmes e análises**: Exibe uma tabela com todos os filmes e análises cadastrados. Também exibe os detalhes de cada filme em outra página. 
- 🛠️ **Edição e exclusão**: Atualize ou remova informações de filmes e análises existentes.

## 🛠️ Tecnologias Utilizadas
- **Java** ☕
- **CSS e JavaScript** 🌐 (para personalização e interatividade)
- **Spring Boot** 🚀
- **Thymeleaf** 🖼️
- **Bootstrap** 🎨
- **Banco de dados H2** 🗄️ (em memória)
- **MySQL**
- **API**

## 📂 Estrutura do Projeto
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
## 🚀 Como Rodar o Projeto

Siga os passos abaixo para executar o projeto localmente:

1. **Clone o repositório:**

```bash
git clone https://github.com/Agbl09/Analise-e-cadastro-de-Filmes.git
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

5. **Acesse no navegador: _Acesse a aplicação em http://localhost:8080_.**

## ✨ Funcionalidades Finais a Implementar

📊 Filtro de filmes por gênero ou ano.

🌐 Internacionalização (i18n) para suporte a múltiplos idiomas.

## 🤝 Contribuindo

Contribuições são bem-vindas! Siga os passos abaixo:

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

## 📝 Licença
   Este projeto foi desenvolvido para fins educacionais e está disponível para uso e modificação conforme necessário.

   Feito por [Gabriela Rodrigues](https://github.com/Agbl09)
