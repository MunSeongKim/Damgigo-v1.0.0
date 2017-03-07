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
@Table(name="board")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bno;
	@Column(nullable=false)
	private String title;
	@Column(nullable=true)
	private String content;
	@Column(nullable=false)
	private String writer;
	@Column(nullable=false)
	private Date regdate;
	@Column(nullable=false)
	private int viewcnt;
}
