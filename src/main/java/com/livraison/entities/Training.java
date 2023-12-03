package com.livraison.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Training extends AuditModel {
	private String titre;
	private String Description;
	private String debut,fin;
	@ManyToMany
	@Column(nullable = true)
	private List<Employee> employees;
	@ManyToMany
	@Column(nullable = true)
	private List<Task> tasks;
}
