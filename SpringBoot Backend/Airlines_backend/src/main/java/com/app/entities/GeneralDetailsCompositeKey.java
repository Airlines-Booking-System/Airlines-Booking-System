package com.app.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Embeddable
public class GeneralDetailsCompositeKey implements Serializable{
    
    @OneToOne
    private Customers cid;

    @OneToMany
    private List<PassangerDetails> pid;
}
