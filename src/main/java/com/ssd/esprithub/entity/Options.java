package com.ssd.esprithub.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Options {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOption")
    private Long idOption;
	 @Column(name = "libelle")
	 private String libelle;
	@Column(name = "discription")
	private String discription;


	@OneToMany(mappedBy = "option_id")
	@JsonIgnore
	private List<User> users ;
	public  Options( Long idOption ){
		this.idOption=idOption;
	}
}
