package com.estsoft.springdemoproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@Setter
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "`desc`")
    private String desc;
    @Column(name = "created_at", updatable = false, columnDefinition = "datetime(3)")
    //@CreatedDate
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }

    // 이 필드는 DB 컬럼으로는 미존재하는 상태지만 이 entity class에서는 개발자가 사용할 필드야.
    @Transient
    private String nickName;

    public String getNickName() {
        return this.name+"_(" + this.age + ")";
    }
}