package com.nsu.computingsystems.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cs_entity")
public class CsEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cs_entity_hierarchy", joinColumns = @JoinColumn(name = "entity_id"), inverseJoinColumns = @JoinColumn(name = "parent_entity_id"))
    private List<CsEntity> parents;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cs_entity_hierarchy", joinColumns = @JoinColumn(name = "parent_entity_id"), inverseJoinColumns = @JoinColumn(name = "entity_id"))
    private List<CsEntity> descendants;

    protected CsEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CsEntity> getDescendants() {
        return descendants;
    }

    public void setDescendants(List<CsEntity> descendants) {
        this.descendants = descendants;
    }

    public List<CsEntity> getParents() {
        return parents;
    }

    public void setParents(List<CsEntity> parents) {
        this.parents = parents;
    }
}
