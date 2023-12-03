package com.livraison.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Entity
@Data
public class Team extends AuditModel {
@Column(unique = true)
	private String nom;
@OneToOne(optional = true)
@JoinColumn(name="teamLeaderId")
@JsonIgnore

private Employee chef;
@OneToMany(mappedBy = "team")
@JsonIgnoreProperties("team")
@Column(nullable = true)
private List<Employee> employees;
@OneToMany(mappedBy = "team")
@JsonIgnoreProperties("team")
@Column(nullable = true)
private List<Task> task;
}
