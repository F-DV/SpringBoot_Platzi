package com.fundamentosPlatzi.springboot.fundamentos.repository;

import com.fundamentosPlatzi.springboot.fundamentos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Extendemos de JpaRepository, elñ primer párametro de entrada es la entidad, el degundo el tipo de id
     * @Repository : le damos el estereotipo a esta Interface
     * @Query : permite definir una consulta en lenguaje JPQL que es parecido al SQL , solo que SQL trabaj con tablas y
     *   JPQL con objetos
     */

    @Query("Select u from User u WHERE u.email=?1 ")
    Optional<User> findByUserEmail(String email);

}
