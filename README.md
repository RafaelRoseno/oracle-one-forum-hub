# Forum Hub

![Badge concluido](https://img.shields.io/static/v1?label=STATUS&message=Conclu%C3%ADdo&color=GREEN&style=for-the-badge)

Este projeto foi desenvolvido utilizando Java como parte do desafio proposto durante o programa [Oracle One](https://www.oracle.com/br/education/oracle-next-education/) em colaboração com a [Alura](https://www.alura.com.br/).

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

## Descrição

O Forum Hub é uma aplicação que simula o ambiente de um fórum online. Permite aos usuários criar tópicos de discussão e interagir com ele.

### Requisitos
- **Java 17** 
- **Maven 3.9.6**
- **Postgres**

## Endpoints Disponíveis

### POST `/user`
Cria um novo usuário.
É necessário criar um usuário antes de um tópico.
```
{
  "nome": "Nome do usuario",
  "email": "usuario@email.com",
  "password": "senha123"
}  
```

### POST `/topic`

Cria um novo tópico de discussão.

```
{
  "titulo": "Título do tópico",
  "mensagem": "Mensagem do tópico",
  "autor": {
    "id": 2,
    "nome":"Nome do Autor"      
  },
  "curso": {
    "name": "Nome do curso",
    "category": "Categoria do curso"
  }
}
```

### GET `/topic`

Retorna todos os tópicos existentes.

### GET `/topic/{id}`

Retorna um tópico específico pelo seu ID.

### PUT `/topic/{id}`

Atualiza um tópico existente com base no ID fornecido.

### DELETE `/topic/{id}`

Remove um tópico existente pelo seu ID.

# Autor
<table>
  <tbody>
        <tr>
            <td rowspan="4">
                <a href="https://www.linkedin.com/in/rafaelroseno/" target="_blank">
                    <img loading="lazy" src="https://avatars.githubusercontent.com/u/57376680?v=4" style="border-radius: 50%" width=100>
                    <br>
                    Rafael Roseno 
                </a>
            </td>
            <td rowspan="1">
                <a href="https://github.com/RafaelRoseno" target="_blank">
                    <img loading="lazy" src="https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white">
                </a>
            </td>
        </tr>
        <tr>
            <td>
                <a href="https://www.linkedin.com/in/rafaelroseno/" target="_blank">
                    <img loading="lazy" src="https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white">
                </a>
            </td>
        </tr>
        <tr>
            <td>
                <a href="https://rafaelroseno.com" target="_blank">
                    <img loading="lazy" src="https://img.shields.io/badge/personal-000?style=for-the-badge&logo=Microsoft-edge&logoColor=%23F7DF1E">
                </a>
            </td>
        </tr>

  </tbody>
</table>
