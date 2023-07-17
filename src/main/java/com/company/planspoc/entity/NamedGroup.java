package com.company.planspoc.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

@DiscriminatorValue("NamedGroup")
@JmixEntity
@Entity
public class NamedGroup extends AbstractGroup {

    @InstanceName
    @Column(name = "NAME")
    private String name;

    @JoinColumn(name = "PERSON_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private NamedPerson namedPerson;

    public NamedPerson getNamedPerson() {
        return namedPerson;
    }

    public void setNamedPerson(NamedPerson namedPerson) {
        this.namedPerson = namedPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}