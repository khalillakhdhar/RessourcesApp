package com.livraison.entities;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Employee extends AuditModel {
private String nom,prenom,dateNaissance;
@Enumerated(EnumType.STRING)
private Grade grade;
private double salaire;
@Column(unique = true)
private String email,telephone;
private String embauche,adresse;
@ManyToOne(optional = false)
@JsonIgnoreProperties("employees")
@JoinColumn(name = "team",referencedColumnName = "nom")
private Team team;
@OneToMany(mappedBy = "employee")
@JsonIgnoreProperties("employee")
private Set<Task> tasks;

}
