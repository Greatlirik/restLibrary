package com.training.restLibrary.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Account entity
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Account extends BaseEntity {

    /**
     * Field name
     */
    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Field password
     */
    @NotBlank
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * Field active
     */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name = "active")
    private boolean active;

    /**
     * Field roles
     */
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
    private List<Role> roles;

}
