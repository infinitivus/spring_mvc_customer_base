package com.infinitivus.project.entity.person_entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "spare_part")
public class SpareParts {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 100, message = "Error! Enter the sample data")
    @Column(name = "name_spare_part")
    private String nameSparePart;

    @Min(value = 0, message = "Error !")
    @Max(value = 999999999, message = "Error !")
    @Column(name = "cost_part")
    private int costPart;

    @Size(max = 15, message = "Error!")
    @Column(name = "article")
    private String article;

    @ManyToMany(mappedBy = "sparePartsList")
    private List<RepairWork> repairWorkList;

    public SpareParts() {
    }

    public SpareParts(String nameSparePart, int costPart, String article) {
        this.nameSparePart = nameSparePart;
        this.costPart = costPart;
        this.article = article;
    }

    public void addRepairWorkToSpareParts(RepairWork repairWork) {
        if (repairWorkList == null) {
            repairWorkList = new ArrayList<>();
        }
        repairWorkList.add(repairWork);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSparePart() {
        return nameSparePart;
    }

    public void setNameSparePart(String nameSparePart) {
        this.nameSparePart = nameSparePart;
    }

    public int getCostPart() {
        return costPart;
    }

    public void setCostPart(int costPart) {
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
}
