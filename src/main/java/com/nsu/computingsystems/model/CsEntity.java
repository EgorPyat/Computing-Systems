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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private CsEntity parent;

    @OneToMany(mappedBy = "parent")
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

    public CsEntity getParent() {
        return parent;
    }

    public void setParent(CsEntity parent) {
        this.parent = parent;
    }

    public List<CsEntity> getDescendants() {
        return descendants;
    }

    public void setDescendants(List<CsEntity> descendants) {
        this.descendants = descendants;
    }
}
