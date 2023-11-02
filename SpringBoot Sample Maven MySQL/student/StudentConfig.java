package com.example.demo.student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Configuration
public class StudentConfig {
@Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student katy = new Student(  1L,
                    "Katy",
                    "katy@stdnt.com",
                    LocalDate.of(1987, Month.AUGUST, 5)
            );
            Student kevin = new Student(
                    "Kevin",
                    "kevin@stdnt.com",
                    LocalDate.of(1989, Month.FEBRUARY, 25)
            );
            repository.saveAll(List.of(katy, kevin));
        };
    }
}


