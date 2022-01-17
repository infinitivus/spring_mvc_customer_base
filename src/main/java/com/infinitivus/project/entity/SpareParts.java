package com.infinitivus.project.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="spare_parts")
public class SpareParts {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name_spare_part")
    private String nameSparePart;

    @Column(name="cost_part")
    private long costPart;

    @Column(name="article")
    private String article;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="parts_work", joinColumns = @JoinColumn(name="spare_parts_id"),
            inverseJoinColumns = @JoinColumn(name="repair_work_id"))
    private List<RepairWork> repairWorkList;

    public SpareParts() {
    }

    public SpareParts(String nameSparePart, long costPart, String article) {
        this.nameSparePart = nameSparePart;
        this.costPart = costPart;
        this.article = article;
    }

    public void addRepairWorkToSpareParts(RepairWork repairWork){
        if(repairWorkList==null){
            repairWorkList=new ArrayList<>();
        }
        repairWorkList.add(repairWork);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSparePart() {
        return nameSparePart;
    }

    public void setNameSparePart(String nameSparePart) {
        this.nameSparePart = nameSparePart;
    }

    public long getCostPart() {
        return costPart;
    }

    public void setCostPart(long costPart) {
        this.costPart = costPart;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public List<RepairWork> getRepairWorkList() {
        return repairWorkList;
    }

    public void setRepairWorkList(List<RepairWork> repairWorkList) {
        this.repairWorkList = repairWorkList;
    }

    @Override
    public String toString() {
        return "SpareParts{" +
                "id=" + id +
                ", nameSparePart='" + nameSparePart + '\'' +
                ", costPart=" + costPart +
                ", article='" + article + '\'' +
                '}';
    }
}
