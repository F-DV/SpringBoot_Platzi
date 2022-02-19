package com.fundamentosPlatzi.springboot.fundamentos.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
/**
 * Hybernate es un ORM que nos ayuda al modelamiento de datos SQl sin programar instancias sql
 * @Entity : Annotacion de Hibernate, le dice que haga una tabla con con los atributos de esta clase
 * @Table(name = "user") : Especificamos el nombre de la tabla para que no se cree por defecto.
 * @GeneratedValue(strategy = GenerationType.AUTO) :  Auto singnicia que autoincrementa el id
 *
 *  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER) : Relacionamos con entidad post
 *  un usuario tiene muchos posts, tipo de cascada
 *  @JsonManagedReference : Es para cuando accedamos a este servicio, no nos de un error relacionado con StacOverflow
 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_User", nullable = false, unique = true)
    private Long id;

    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String email;

    private LocalDate birthDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Post> posts = new ArrayList<>();

    public User() {
    }

    public User(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", posts=" + posts +
                '}';
    }
}
