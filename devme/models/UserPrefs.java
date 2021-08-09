package com.learn.devme.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserPrefs {
    @Id
//    @SequenceGenerator(
//            name = "idUser",
//            sequenceName = "dog_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "dog_sequence"
//    )
    private Long idUser;
    private Long idDog;
}
