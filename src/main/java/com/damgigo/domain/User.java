package com.damgigo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	private String id;
	@Column(nullable=true)
	private String password;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String email;
	@Column(nullable=true)
	private String classify;
	@Column(nullable=true)
	private String department;
	@Column(nullable=true)
	private Integer year;
	@Column(nullable=true)
	private String position;
	@Column(nullable=false)
	private String type;
}
