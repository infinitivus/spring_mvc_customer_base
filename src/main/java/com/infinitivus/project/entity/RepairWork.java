package com.infinitivus.project.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "repair_work")
public class RepairWork {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_the_work")
    private String nameTheWork;

    @Column(name = "master")
    private String master;

    @Column(name = "cost_work")
    private long costWork;

    @Column(name = "date")
    private String date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "home_id")
    private MobileHome mobileHome;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "parts_work", joinColumns = @JoinColumn(name = "repair_work_id"),
            inverseJoinColumns = @JoinColumn(name = "spare_parts_id"))
    private List<SpareParts> sparePartsList;

    public RepairWork() {
    }

    public RepairWork(String nameTheWork, String master, long costWork, String date) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTheWork() {
        return nameTheWork;
    }

    public void setNameTheWork(String nameTheWork) {
        this.nameTheWork = nameTheWork;
    }

    public long getCostWork() {
        return costWork;
    }

    public void setCostWork(long costWork) {
        this.costWork = costWork;
    }

    public List<SpareParts> getSpareParts() {
        return sparePartsList;
    }

    public void setSpareParts(List<SpareParts> spareParts) {
        this.sparePartsList = spareParts;
    }

    public MobileHome getMobileHome() {
        return mobileHome;
    }

    public void setMobileHome(MobileHome mobileHome) {
        this.mobileHome = mobileHome;
    }

    public List<SpareParts> getSparePartsList() {
        return sparePartsList;
    }

    public void setSparePartsList(List<SpareParts> sparePartsList) {
        this.sparePartsList = sparePartsList;
    }

    public String getMaster() {return master;}

    public void setMaster(String master) {this.master = master;}

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

    @Override
    public String toString() {
        return "RepairWork{" +
                "id=" + id +
                ", nameTheWork='" + nameTheWork + '\'' +
                ", costWork=" + costWork +
                ", spareParts=" + sparePartsList +
                '}';
    }
}
