package com.codersergg.demo_mongoDB;

import com.codersergg.demo_mongoDB.model.Address;
import com.codersergg.demo_mongoDB.model.Student;
import com.codersergg.demo_mongoDB.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.codersergg.demo_mongoDB.model.Gender.MALE;

@SpringBootApplication
@Slf4j
public class DemoMongoDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMongoDbApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate) {
        return args -> {
            Address address = new Address("Russia", "Moscow", "Krasnaya ploshad, d. 1", "127000");
            String email = "IvanIvanov@gmail.com";
            Student student = new Student(
                    "Иван",
                    "Иванов",
                    email,
                    MALE,
                    address,
                    List.of("Spring in action", "Spring Boot"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
            );

            repository.findStudentByEmail(email).ifPresentOrElse(s -> {
                log.info(s.getEmail() + " already exists");
            }, () -> {
                log.info("Inserting student " + student);
                repository.insert(student);
            });
        };
    }

}
