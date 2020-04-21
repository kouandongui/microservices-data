package com.inti.formation.shop.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 *
 * @SpringBootConfiguration: Indique qu'une classe fournit l'application Spring Boot @Configuration.
 *         Peut être utilisé comme alternative à l'annotation @Configuration standard de Spring afin que la configuration
 *         puisse être trouvée automatiquement (par exemple dans les tests). L'application ne doit jamais inclure qu'une seule @SpringBootConfiguration
 *         et la plupart des applications idiomatiques Spring Boot l'hériteront de @SpringBootApplication.
 *
 *
 * @EnableAutoConfiguration : Activez la configuration automatique du contexte de l'application Spring,
 *         en essayant de deviner et de configurer les beans dont vous aurez probablement besoin.
 *         Les classes de configuration automatique sont généralement appliquées en fonction de votre chemin de classe
 *         et des beans que vous avez définis. Par exemple, si vous avez tomcat-embedded.
 *         jar sur votre chemin de classe, vous souhaiterez probablement un TomcatServletWebServerFactory
 *         (sauf si vous avez défini votre propre bean ServletWebServerFactory).
 *         Lorsque vous utilisez @SpringBootApplication,
 *         la configuration automatique du contexte est automatiquement activée et l'ajout de cette annotation n'a donc aucun effet supplémentaire.
 *
 */

@SpringBootConfiguration // Il indique qu'une classe fournit une configuration d'application.
// Spring Boot favorise la configuration basée sur Java.
// Par conséquent, l'annotation
@EnableAutoConfiguration
@ComponentScan // scan tout le package et récupère c'est composant service
@EnableReactiveMongoRepositories // active permet d'activer le thrading rectif de MongoDb // activation de spring mongo reactive
public class ApplicationShop {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationShop.class, args);
    }

}