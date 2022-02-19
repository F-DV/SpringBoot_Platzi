package com.fundamentosPlatzi.springboot.fundamentos.repository;

import com.fundamentosPlatzi.springboot.fundamentos.entity.Post;
import com.fundamentosPlatzi.springboot.fundamentos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
/**
 * Extendemos de JpaRepository, elñ primer párametro de entrada es la entidad, el degundo el tipo de id
 * @Repository : le damos el estereotipo a esta Interface
 *
 */


}
