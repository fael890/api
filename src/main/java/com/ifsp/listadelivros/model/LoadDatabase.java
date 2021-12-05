package com.ifsp.listadelivros.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDatabase {
    
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDataBase(LivroRepository repository){
        return args ->{

            //! load do primeiro dado
            Rotulo rotulo1 = new Rotulo("Historia incrivel para testar meu codigo Java", 890);
            Livro livro1 = new Livro("Livro para testar o codigo", true, rotulo1);
            List<Categoria> categorias = new ArrayList<>();
            Categoria categoria1 = new Categoria("tensao", "Um genero capaz de fazer a imaginação fluir");
            categoria1.setLivro(livro1); //necesário adicionar para sincronizar a conexão bidirecional
            categorias.add(categoria1);
            Categoria categoria2 = new Categoria("acao", "Um genero capaz de mostrar as aventuras");
            categoria2.setLivro(livro1); //necesário adicionar para sincronizar a conexão bidirecional entre Lista e Tarefa
            categorias.add(categoria2); 
            livro1.setCategorias(categorias);

            //! load do segundo dado
            Rotulo rotulo2 = new Rotulo("Livro de grandes aventuras no mar", 890);
            Livro livro2 = new Livro("Jack Sparow e o Ladrao de raios", true, rotulo2);
            categorias = new ArrayList<>();
            categoria1 = new Categoria("aventura", "Um genero capaz de mostrar a venrdadeira aventura");
            categoria1.setLivro(livro2); //necesário adicionar para sincronizar a conexão bidirecional
            categorias.add(categoria1);
            categoria2 = new Categoria("fantasia", "Um genero capaz de mostrar as um mundo fantastico");
            categoria2.setLivro(livro2); //necesário adicionar para sincronizar a conexão bidirecional entre Lista e Tarefa
            categorias.add(categoria2); 
            livro2.setCategorias(categorias);

            log.info("Inserindo: " + repository.save(livro1));
            log.info("Inserindo: " + repository.save(livro2));
        };
    }
}    
