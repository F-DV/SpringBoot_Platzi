package com.fundamentosPlatzi.springboot.fundamentos.entity;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    /**
     * Hybernate es un ORM que nos ayuda al modelamiento de datos SQl sin programar instancias sql
     * @Entity : Annotacion de Hibernate, le dice que haga una tabla con con los atributos de esta clase
     * @Table(name = "post") : Especificamos elñ nombre de la tabla para que no se cree por defecto
     * @Id
     * @GeneratedValue(strategy = GenerationType.IDENTITY) : Creamos un id unico
     * @Column(name = "id_post", nullable = false, unique = true) :Especificamos el nombre de la columna y la configuracion que tendra
     * private Long id :  creamos variable que representara esta columna en la clase
     * @ManyToOne : Especifica que la siguiente entiedad es un usuario puede tener mcuhos posts
     * private User user;
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post", nullable = false, unique = true)
    private Long id;
    @Column(name = "description", length = 255)
    private String description ;
    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(String description, User user) {
        this.description = description;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
