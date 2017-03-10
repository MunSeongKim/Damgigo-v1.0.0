package com.damgigo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	private String uid;
	@Column(nullable=false)
	private String upw;
	@Column(nullable=false)
	private String uname;
	@Column(nullable=false)
	private int upoint;
}
