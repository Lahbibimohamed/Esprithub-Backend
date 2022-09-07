package com.ssd.esprithub.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Cours {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCours")
    private Long idCours;
	 @Column(name = "libelle")
	 private String libelle;
	 @Column(name = "content")
	 private String content;
	 
	 @ManyToOne
	 private UE uecours;
	 
	 @OneToMany(mappedBy = "courslien")
	 private Set<LienUtile> liens;
	

}
