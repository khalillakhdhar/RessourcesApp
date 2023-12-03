package com.livraison.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Task extends AuditModel {
private String titre;
private String Description;
private String debut,fin;
@Enumerated(EnumType.STRING)
private TaskStatus etat;
@ManyToOne(optional = true)
@JsonIgnoreProperties("task")
private Employee employee;
@ManyToOne(optional = true)
@JsonIgnoreProperties("task")

private Team team;

}
