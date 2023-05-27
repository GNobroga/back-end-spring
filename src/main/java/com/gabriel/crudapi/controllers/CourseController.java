package com.gabriel.crudapi.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.crudapi.models.Course;
import com.gabriel.crudapi.repository.CourseRepository;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
@CrossOrigin
public class CourseController {

    private final CourseRepository courseRepository;

    @GetMapping
    public List<Course> list() {
        return courseRepository.findAll();
    }

    // Se tiver um campo diferente do mapeamento do Spring e necessario usar o
    // JsonProperty do Jackson.
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    // @ResponseStatus(code = HttpStatus.CREATED)
    public Course save(@RequestBody Course course) {
        /*
         * ResponseEntity - Serve para mandar resposta e status
         */

        return courseRepository.save(course);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND) // Se o parametro for igual variable nao e necessario por o value
    public ResponseEntity<Course> findById(@PathVariable Long id) {
        return courseRepository.findById(id).map( data -> ResponseEntity.ok().body(data))
        .orElse(ResponseEntity.notFound().build());
     
    }

}
