package com.github.victorleitecosta10.todo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static javax.persistence.GenerationType.IDENTITY;

@Table(name = "Todo")
@Entity
@Getter
@Setter
public class Todo {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String description;

    @Column
    private boolean done;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime createdDate;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime doneDate;

    @PrePersist
    public void beforeSave() {
        setCreatedDate(now());
    }

}
