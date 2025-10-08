
package com.k48.managing.stock;

import com.k48.managing.stock.model.Roles;
import com.k48.managing.stock.model.Utilisateur;
import com.k48.managing.stock.repository.RolesRepository;
import com.k48.managing.stock.repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;
import java.util.Collections;

@SpringBootApplication
@EnableJpaAuditing
public class ManagingStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagingStockApplication.class, args);
	}
   /*
	// This will run once after the app starts
	@Bean
	CommandLineRunner init(UtilisateurRepository utilisateurRepository,
						   RolesRepository rolesRepository,
						   PasswordEncoder passwordEncoder) {
		return args -> {
			if (utilisateurRepository.findUtilisateurByEmail("admin@gestiondestock.com").isEmpty()) {
				Utilisateur admin = new Utilisateur();
				admin.setNom("Administrator");
				admin.setPrenom("System");
				admin.setEmail("admin@gestiondestock.com");
				admin.setMoteDePasse(passwordEncoder.encode("admin123"));
				admin.setDateDeNaissance(Instant.parse("1990-01-01T00:00:00Z"));
				admin.setPhoto(null);
				admin.setAdresse(null);
				admin.setEntreprise(null);

				Utilisateur savedAdmin = utilisateurRepository.save(admin);

				Roles roleAdmin = new Roles();
				roleAdmin.setRoleName("ROLE_ADMIN");;
				roleAdmin.setUtilisateur(savedAdmin);
				rolesRepository.save(roleAdmin);

				savedAdmin.setRoles(Collections.singletonList(roleAdmin));
				utilisateurRepository.save(savedAdmin);

				System.out.println("✅ Admin user created: ");
			} else {
				System.out.println("ℹ️ Admin user already exists");
			}
		};
	} */

}

	/*// This runs once after Spring Boot starts
	@Bean
	CommandLineRunner run() {
		return args -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String hashedPassword = encoder.encode("admin123"); // your new password
			System.out.println("Hashed password for admin@mail.com: " + hashedPassword);
		};
	}*/
