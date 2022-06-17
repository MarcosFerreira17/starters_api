package com.gft.starters_api.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TB_users")
@Getter @Setter @ToString
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String fourLetters;
    private String email;
    @OneToOne
    private Role roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User starter = (User) o;
        return id != null && Objects.equals(id, starter.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
