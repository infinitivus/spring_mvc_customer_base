package com.infinitivus.project.entity.person_entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "repair_work")
public class RepairWork {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_the_work")
    private String nameTheWork;

    @Column(name = "master")
    private String master;

    @Column(name = "cost_work")
    private long costWork;

    @Column(name = "date")
    private String date;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "home_id")
    private MobileHome mobileHomeRepair;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "parts_work", joinColumns = @JoinColumn(name = "repair_work_id"),
            inverseJoinColumns = @JoinColumn(name = "spare_parts_id"))
    private List<SpareParts> sparePartsList;

    public RepairWork() {
    }

    public RepairWork(Integer id, String nameTheWork, String master, long costWork, String date) {
        this.id = id;
        this.nameTheWork = nameTheWork;
        this.master = master;
        this.costWork = costWork;
        this.date = date;
    }

    public void addSparePartsToRepairWork(SpareParts spareParts) {
        if (sparePartsList == null) {
            sparePartsList = new ArrayList<>();
        }
        sparePartsList.add(spareParts);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameTheWork() {
        return nameTheWork;
    }

    public void setNameTheWork(String nameTheWork) {
        this.nameTheWork = nameTheWork;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public long getCostWork() {
        return costWork;
    }

    public void setCostWork(long costWork) {
        this.costWork = costWork;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public MobileHome getMobileHomeRepair() {
        return mobileHomeRepair;
    }

    public void setMobileHomeRepair(MobileHome mobileHomeRepair) {
        this.mobileHomeRepair = mobileHomeRepair;
    }

    public List<SpareParts> getSparePartsList() {
        return sparePartsList;
    }

    public void setSparePartsList(List<SpareParts> sparePartsList) {
        this.sparePartsList = sparePartsList;
    }
}
