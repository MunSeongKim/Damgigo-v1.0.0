package com.damgigo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_message")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer mid;
	@Column(nullable=false)
	private String targetid;
	@Column(nullable=false)
	private String sender;
	@Column(nullable=false)
	private String message;
	@Column(nullable=false)
	private Date opendate;
	@Column(nullable=false)
	private Date senddate;
}
