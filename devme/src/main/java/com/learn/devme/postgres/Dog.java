package com.learn.devme.postgres;
import javax.persistence.*;


@Entity
@Table
public class Dog {
    @Id
    @SequenceGenerator(
            name = "name",
            sequenceName = "dog_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "dog_sequence"
    )
    private Long id;
    private String name;

    public Dog() {
    }

    public Dog(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Dog(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", breed='" + name + '\'' +
                '}';
    }
}
