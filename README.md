<h1 align="center"> Projeto SpringBoot Terceiro Bimestre </h1>
<p align="center">Este é um projeto feito para o nosso terceiro bimestre em Linguagem Técnica de Programação, no qual utilizamos Spring boot e API Rest.</p>

### Dupla:
* [Luan Tavares de Lima](https://github.com/Tavaress17).
* [Rafael Aparecido Marinho](https://github.com/fael890).

### Tabela de Paths:

Verbo HTTP	| Caminho (EndPoints)   		   | Descrição
:----------:| :---------------------------:|:----------------------------------------:
GET			    |/livros/listagem-livros			 | Retorna todos os livros salvos.
POST			  |/livros/criar				         | Cria um novo livro.
GET		      |/livros/listagem-livros/{id}	 | Retorna um livro salvo.
DELETE			|/livros/deletar/{id}		       | Deleta um livro.
PUT			    |/atualizar/{id}               | Altera um livro pelo seu id. 

### Modelagens de JSON:
GET:
```json
  {
        "id": 1,
        "title": "Livro para testar o codigo",
        "dataHora": null,
        "lido": true,
        "rotulo": {
            "idRotulo": 1,
            "sinopse": "Historia incrivel para testar meu codigo Java",
            "numPages": 890
        },
        "categorias": [
            {
                "idCategoria": 1,
                "categoria": "tensao",
                "descricao": "Um genero capaz de fazer a imaginação fluir"
            },
            {
                "idCategoria": 2,
                "categoria": "acao",
                "descricao": "Um genero capaz de mostrar as aventuras"
            }
        ]
    }
```
POST:
```json
  {
        "title": "Jack Sparow e o Ladrao de raios 222",
        "dataHora": null,
        "lido": true,
        "rotulo": {
            "sinopse": "Historia incrivel para testar meu codigo Java",
            "numPages": 890
        },
        "categorias": [
            {
                "categoria": "romance2",
                "descricao": "Um genero capaz de mostrar o verdadeiro amor222"
            },
            {
                "categoria": "fantasia2",
                "descricao": "Um genero capaz de mostrar as um mundo fantastico222"
            }
        ]
    }
```
