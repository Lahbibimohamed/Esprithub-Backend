package com.ssd.esprithub.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Response {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idResponse")
	    private Long idResponse;
	 	@Column(name = "content")
	    private String content;
	    @Column(name = "likes")
	    private int likes;
	    @Temporal(TemporalType.DATE)
	    @Column(name = "datepub")
	    private Date datepub;
	    @Column(name = "idUser")
	    private Long idUser;
	    
	    @ManyToOne
	    private Question responses;

}
