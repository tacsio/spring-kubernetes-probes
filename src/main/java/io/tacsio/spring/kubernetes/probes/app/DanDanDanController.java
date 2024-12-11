package io.tacsio.spring.kubernetes.probes.app;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class DanDanDanController {

    private final PersonRepository personRepository;

    @GetMapping
    public ResponseEntity<List<Person>> index() {
        var result = personRepository.findAll();
        return ResponseEntity.ok(result);
    }

}
