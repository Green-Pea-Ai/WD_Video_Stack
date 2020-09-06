/*
package com.example.demo.entity.vd_stk_entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@JsonIgnoreProperties(value = "hibernateLazyInitializer")
@Getter
@Setter
@EqualsAndHashCode(of = "userNo")
@ToString
@Entity
@Table(name = "vid_member")
public class SignUpVidMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Long userNo;

    @Column(length = 50, nullable = false)
    private String userId;

    @Column(length = 100, nullable = false)
    private String userName;
}
*/
