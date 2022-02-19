package com.fundamentosPlatzi.springboot.fundamentos.repository;

import com.fundamentosPlatzi.springboot.fundamentos.entity.User;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Extendemos de JpaRepository, elñ primer párametro de entrada es la entidad, el degundo el tipo de id
     * @Repository : le damos el estereotipo a esta Interface
     * @Query : permite definir una consulta en lenguaje JPQL que es parecido al SQL , solo que SQL trabaj con tablas y
     *   JPQL con objetos
     *   @Query("SELECT u from User u where u.name like ?1%") : vamos a buscar por nombre y ordenar la lista de usuarios
     */

    @Query("Select u from User u WHERE u.email=?1 ")
    Optional<User> findByUserEmail(String email);

    @Query("SELECT u from User u where u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);

}
