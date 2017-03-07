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
@Table(name="reply")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer rno;
	@Column(nullable=false)
	private Integer bno;
	@Column(nullable=false)
	private String replytext;
	@Column(nullable=false)
	private String replyer;
	@Column(nullable=false)
	private Date regdate;
	@Column(nullable=false)
	private Date updatedate;
}
