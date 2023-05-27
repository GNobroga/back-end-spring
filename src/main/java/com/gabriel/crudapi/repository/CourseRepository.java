package com.gabriel.crudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.crudapi.models.Course;

/*
 * @Repository 
 *  - Serve para marcar classes, interfaces que lidam com persistencia de dados. E um DAO moderno.
 * 
 * JpaRepository<Classe, Tipo do id da classe>
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
