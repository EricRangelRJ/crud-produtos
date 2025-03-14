package br.com.crud_produtos.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Configuration
public class DataBaseInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DataBaseInitializer.class);

    @Bean
    public CommandLineRunner initDatabase(DataSource dataSource) {
        logger.info("::: Iniciando carga nas tabelas :::");
         return args -> {

            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement()) {

                logger.info("::: Iniciando carga na tabela de produtos :::");
                statement.execute("INSERT INTO public.produtos (id,descricao,fabricante,preco) VALUES" +
                        " ('ca341327-6986-477d-ac09-f024e1f4a792','Geladeira','Brastemp', 2348.99)," +
                        " ('ca341347-6986-477d-ac09-f024e1f4a792','Microondas','Eletroluz', 759.90)," +
                        " ('ca341357-6986-477d-ac09-f024e1f4a792','Ferro de Passar Roupa','Arno', 89.90)," +
                        " ('ca341367-6986-477d-ac09-f024e1f4a792','Ventilador','Arno', 299.99);");
            }
             logger.info("::: Finalizada carga nas tabelas :::");
        };

    }

}