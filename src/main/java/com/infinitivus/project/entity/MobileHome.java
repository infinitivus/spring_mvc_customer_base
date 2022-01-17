package com.infinitivus.project.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mobile_home")
public class MobileHome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "vin")
    private String vin;

    @Column(name = "year_of_release")
    private String yearOfRelease;

    @Column(name = "license_plate")
    private String licensePlate;

    @OneToOne(mappedBy = "mobileHome")
    private Person homePerson;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "mobileHomeRepair")
    private List<RepairWork> repairWorkList;


    public MobileHome() {
    }

    public MobileHome(String type, String brand, String model, String vin, String yearOfRelease, String licensePlate) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.vin = vin;
        this.yearOfRelease = yearOfRelease;
        this.licensePlate = licensePlate;
    }

    public RepairWork addRepairWorkToMobileHome(RepairWork repairWork) {
        if (repairWorkList == null) {
            repairWorkList = new ArrayList<>();
        }
        repairWorkList.add(repairWork);
        repairWork.setMobileHomeRepair(this);
        return repairWork;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Person getHomePerson() {
        return homePerson;
    }

    public void setHomePerson(Person homePerson) {
        this.homePerson = homePerson;
    }

    public List<RepairWork> getRepairWorkList() {
        return repairWorkList;
    }

    public void setRepairWorkList(List<RepairWork> repairWorkList) {
        this.repairWorkList = repairWorkList;
    }

    @Override
    public String toString() {
        return "MobileHome{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", yearOfRelease='" + yearOfRelease + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
}
