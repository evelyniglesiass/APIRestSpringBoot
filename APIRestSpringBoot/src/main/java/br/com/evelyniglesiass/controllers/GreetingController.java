package br.com.evelyniglesiass.controllers;

import br.com.evelyniglesiass.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

// serve para abstrair duas anotacoes
// Controller: indica que a classe é um controlador (componente que lida com requisicoes http)
///ResponseBody: indica que o retorno do método será serializado diretamente como resposta http (JSON, XML, etc)
@RestController
public class GreetingController {

    // constante de template que terá o %s substituido pelo parametro
    private static final String template = "Hello, %s!";
    // AtomicLong é utilizado para incrementar numeros (contador) e vai simular o id
    private final AtomicLong counter = new AtomicLong() ;

    // mapeia o metodo para responder a url (por padrao responde a qualquer metodo http: GET, POST, etc)
    @RequestMapping("/greeting") // greeting é url (completa: http://localhost:8080/greeting?name=Evelyn)
    public Greeting greeting(
            // le o parametro name informado na url, caso nao exista utiliza um valor default "world
            @RequestParam(value = "name", defaultValue = "World")
            String name
    ) {
        // counter.incrementAndGet() retorna o proximo numero do contador
        // String.format(template, name) substitui %s na template por name
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
