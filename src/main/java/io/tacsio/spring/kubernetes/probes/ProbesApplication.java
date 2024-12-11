package io.tacsio.spring.kubernetes.probes;

import io.tacsio.spring.kubernetes.probes.app.Person;
import io.tacsio.spring.kubernetes.probes.app.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ProbesApplication {

    @Bean
    @Transactional
    CommandLineRunner runner(PersonRepository repository) {
        return args -> {
            var data = Stream.of(
                    new Person("Momo Ayase", "Momo", "Psychokinesis"),
                    new Person("Takakura Ken", "Okarun", " Turbo Baba Spiritual Power"),
                    new Person("Ayase Seiko", "Seikoo", "Psychokinesis"),
                    new Person("Turbo Baba", "100 km/h", "Spiritual Power")
            ).toList();
            repository.saveAll(data);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ProbesApplication.class, args);
    }

}
