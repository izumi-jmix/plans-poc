package com.company.planspoc.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.jmix.core.metamodel.annotation.JmixEntity;

@DiscriminatorValue("AnotherGroup")
@JmixEntity
@Entity
public class AnotherGroup extends AbstractGroup {

    @JoinColumn(name = "PERSON_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AnotherPerson anotherPerson;

    @Column(name = "ANOTHER")
    private Boolean another;

    public Boolean getAnother() {
        return another;
    }

    public void setAnother(Boolean another) {
        this.another = another;
    }

    public AnotherPerson getAnotherPerson() {
        return anotherPerson;
    }

    public void setAnotherPerson(AnotherPerson anotherPerson) {
        this.anotherPerson = anotherPerson;
    }
}