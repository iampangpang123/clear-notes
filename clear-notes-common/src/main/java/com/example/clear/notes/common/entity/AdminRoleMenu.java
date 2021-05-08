package com.example.clear.notes.common.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 唐涛
 * @description: AdminRoleMenu
 * @date 2021/5/8
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
