package web;

import entities.Compte;
import entities.EtatCompte;
import entities.TypeCompte;
import jakarta.persistence.Entity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.CompteRepository;

import java.util.Date;
@EnableJpaRepositories(basePackages={"repositories"})
@SpringBootApplication
@EntityScan(basePackages = "entities")
public class Tp6Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp6Application.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository)
	{
		return args ->
		{
			compteRepository.save(new Compte(null,30,new Date(), TypeCompte.EPARGNE, EtatCompte.ACTIVE));
			compteRepository.save(new Compte(null,70,new Date(), TypeCompte.COURANT,EtatCompte.ACTIVE));


			System.out.println("solde des comptes");
			Iterable <Compte> comptes = compteRepository.findAll();
			for(Compte compte : comptes)
			{
				System.out.println("solde"+compte.getSolde());
			}
		};
	}
}


