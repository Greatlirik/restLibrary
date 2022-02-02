package com.training.restLibrary.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class AccountEntity extends BaseEntity{

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank
    @Column(name = "password", nullable = false)
    private String password;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name = "active")
    private boolean active;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(
            name = "account_role",
            joinColumns = {
                    @JoinColumn(name = "account_id", nullable = false)
            }
    )
    @Column(name = "role_id", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Set<Role> roles = new HashSet<>();

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "account_book",
            joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id")
    )
    private Set<BookEntity> books;
}
