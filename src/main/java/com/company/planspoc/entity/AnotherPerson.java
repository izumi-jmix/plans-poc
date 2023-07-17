package com.company.planspoc.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import io.jmix.core.metamodel.annotation.JmixEntity;

@JmixEntity
@Entity
public class AnotherPerson extends Person {

    @OneToMany(mappedBy = "anotherPerson")
    private List<AnotherGroup> anotherGroups;

    public List<AnotherGroup> getAnotherGroups() {
        return anotherGroups;
    }

    public void setAnotherGroups(List<AnotherGroup> anotherGroups) {
        this.anotherGroups = anotherGroups;
    }
}