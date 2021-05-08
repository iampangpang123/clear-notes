package com.example.clear.notes.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Category entity.
 *
 * @author Evan
 * @date 2019/4
 */
@Data
@Entity
@Table(name = "category")
@ToString
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Category name in Chinese.
     */
    private String name;
}
