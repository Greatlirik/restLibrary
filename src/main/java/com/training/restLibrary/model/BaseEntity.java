package com.training.restLibrary.model;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base class with property ID
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@MappedSuperclass
@Data
public class BaseEntity {

    /**
     * Field id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
