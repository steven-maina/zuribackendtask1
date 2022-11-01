package com.jpaturial.jpaturorial.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode
@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class User implements Serializable {
    @Id
   // @SequenceGenerator( name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String slackUsername;
    private boolean backend;
    private Integer age;
    private String bio;

    public User(String slackUsername, boolean backend, String bio, Integer age) {
        this.slackUsername = slackUsername;
        this.backend = backend;
        this.bio = bio;
        this.age = age;
    }
}
