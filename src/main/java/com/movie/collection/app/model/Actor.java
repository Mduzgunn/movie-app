package com.movie.collection.app.model;
import javax.persistence.*;


@Entity
@Table(name = "ACTOR")
public class Actor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ACTOR_ID_SEQ")
    @SequenceGenerator(name = "ACTOR_ID_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ROLE")
    private String role;


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
/*
@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128,nullable = false)
    private String name;

    @Column(length = 128,nullable = false)
    private String role;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Actor() {
    }

    public Actor(Integer id, String name, String role, Movie movie) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.movie = movie;
    }

    public Actor(String name, String role, Movie movie) {
        this.name = name;
        this.role = role;
        this.movie = movie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getMovies() {
        return "Film adı: " + getMovie();
    }

    @Override
    public String toString() {
        return "Oyuncu adı: " + " " + getName() + " - " + "Rol: " + getRole();
    }
}
*/