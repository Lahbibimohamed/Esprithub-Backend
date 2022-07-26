package com.ssd.esprithub.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
@Entity
@Data
public class LienUtile {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLien")
    private Long idLien;
	 @Column(name = "libelle")
	 private String libelle;
	 @Column(name = "content")
	 private String content;
	 
	 @ManyToOne
	 private Cours courslien;
	
	
}
