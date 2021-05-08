package com.example.clear.notes.common.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Relations between roles and menus.
 *
 * @author Evan
 * @date 2019/11
 */
@Data
@Entity
@Table(name = "admin_role_menu")
@ToString
public class AdminRoleMenu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Role id.
     */
    private int rid;

    /**
     * Menu id.
     */
    private int mid;
}
