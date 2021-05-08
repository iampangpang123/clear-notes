package com.example.clear.notes.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Relations between users and role.
 *
 * @author Evan
 * @date 2019/11
 */
@Data
@Entity
@Table(name = "admin_user_role")
@ToString
public class AdminUserRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * User id.
     */
    private int uid;

    /**
     * Role id.
     */
    private int rid;
}
