package Notes_App.src.main.java.com.example.Notes_App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // Enable Spring Scheduling for tasks
@EntityScan("com.example.Notes_App.entity") // Scan for JPA entities in this package
@EnableJpaAuditing// Enable JPA entity auditing for automatically populating "created_at" and "updated_at" fields
public class NotesAppApplication {

    public static void main(String[] args) {
        // Start the Spring Boot application
        SpringApplication.run(NotesAppApplication.class, args);
    }

}
