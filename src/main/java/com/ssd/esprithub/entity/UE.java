package com.ssd.esprithub.entity;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class UE {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUE")
    private Long idUE;
    @Column(name = "libelle")
    private String libelle;
    
    @OneToMany(mappedBy = "ue")
    private Set<Question> uequestions;
    
    @OneToMany(mappedBy = "uecours")
    private Set<Cours> cours;

}
