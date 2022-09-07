package com.ssd.esprithub.entity;

import lombok.Data;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idQuestion")
    private Long idQuestion;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "likes")
    private int likes;
    @Temporal(TemporalType.DATE)
    @Column(name = "datepub")
    private Date datepub;
    
    @ManyToMany(mappedBy = "questiontag")
    private Set<Tag> tags;
    
    @ManyToOne
    private User userquestions;
    
    @OneToMany(mappedBy = "responses")
    private Set<Response> questionresponse;
    
    @OneToMany(mappedBy = "ressources")
    private Set<Ressource> questionressources;
    
    @ManyToOne
    private UE ue;
    

}
