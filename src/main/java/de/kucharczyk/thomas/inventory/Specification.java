package de.kucharczyk.thomas.inventory;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

//@MappedSuperclass
public abstract class Specification {

    @Id
    @GeneratedValue
    @Column(name = "specification_id", unique = true, nullable = false, updatable = false, columnDefinition = "uniqueidentifier")
    private int specificationId;


    private ItemType specificationType;
}
