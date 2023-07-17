package com.company.planspoc.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import io.jmix.core.metamodel.annotation.JmixEntity;

@JmixEntity
@Entity
public class NamedPerson extends Person {


    @OneToMany(mappedBy = "namedPerson")
    private List<NamedGroup> namedGroups;

    public List<NamedGroup> getNamedGroups() {
        return namedGroups;
    }

    public void setNamedGroups(List<NamedGroup> namedGroups) {
        this.namedGroups = namedGroups;
    }
}