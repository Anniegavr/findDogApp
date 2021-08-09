package com.learn.devme.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Filters {
    @Id
    @SequenceGenerator(
            name = "filter_sequence",
            sequenceName = "filter_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "filter_sequence"
    )
    private Long idFilter;
    private String name;
    private boolean important;
    private long idGroup;
}
