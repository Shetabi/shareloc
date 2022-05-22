package com.shareloc.service;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HelloEntity")
@Data
public class HelloEntity {

    @Id
    private Integer id;

    private String message;
}
