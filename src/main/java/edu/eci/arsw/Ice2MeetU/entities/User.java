package edu.eci.arsw.Ice2MeetU.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

/**
 * The type User.
 */
@Entity
@Table(name = "Usuario")
public class User {

    // <editor-fold defaultstate="collapsed" desc="Attributes">
    @Id
    private UUID id;
    private String nombre;
    private String username;
    private String email;
    private String birthday;
    private String password;
    private String language;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param nombre   the nombre
     * @param username the username
     * @param email    the email
     * @param birthday the birthday
     * @param password the password
     * @param language the language
     */
    public User(String nombre, String username, String email, String birthday, String password, String language) {
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.birthday = birthday;
        this.password = password;
        this.language = language;
    }

    /**
     * Instantiates a new User.
     *
     * @param id       the id
     * @param nombre   the nombre
     * @param username the username
     * @param email    the email
     * @param birthday the birthday
     * @param password the password
     * @param language the language
     */
    public User(UUID id, String nombre, String username, String email, String birthday, String password, String language) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.birthday = birthday;
        this.password = password;
        this.language = language;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">

    /**
     * Gets id.
     *
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets birthday.
     *
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets language.
     *
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Setters">

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Sets nombre.
     *
     * @param nombre the nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets birthday.
     *
     * @param birthday the birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets language.
     *
     * @param language the language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Methods">

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(nombre, user.nombre) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(birthday, user.birthday) && Objects.equals(password, user.password) && Objects.equals(language, user.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, username, email, birthday, password, language);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", password='" + password + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
    // </editor-fold>
}
