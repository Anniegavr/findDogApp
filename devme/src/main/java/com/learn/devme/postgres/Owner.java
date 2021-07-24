package com.learn.devme.postgres;
import javax.persistence.*;


@Entity
@Table
public class Owner {
    @Id
    @SequenceGenerator(
            name = "name",
            sequenceName = "owner_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "owner_sequence"
    )
    private Long id;
    private String name;
    private String password;

    public Owner() {
    }

    public Owner(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }


    public Owner(String name, String password) {
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = ""+password.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
