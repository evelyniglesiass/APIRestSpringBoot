package br.com.evelyniglesiass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// marca a classe com a configuracao do spring
// habilita a configuracao automatica
// ativa a varredura de componentes no pacote e subpacotes onde ela esta localizada
@SpringBootApplication
public class Startup {

	// inicializa o contexto da aplicacao
	// configura automaticamente os componentes necessarios com base nas dependencias
	// sobe um servidor embutido (se for o caso)
	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
	}

}
