package com.infinitivus.project.entity;

public class FormAllEntity {
    private MobileHome mobileHome;
    private Person person;
    private RepairWork repairWork;
    private SpareParts spareParts;

    public FormAllEntity() {
    }

    public FormAllEntity(MobileHome mobileHome, Person person, RepairWork repairWork, SpareParts spareParts) {
        this.mobileHome = mobileHome;
        this.person = person;
        this.repairWork = repairWork;
        this.spareParts = spareParts;
    }

    public MobileHome getMobileHome() {
        return mobileHome;
    }

    public void setMobileHome(MobileHome mobileHome) {
        this.mobileHome = mobileHome;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public RepairWork getRepairWork() {
        return repairWork;
    }

    public void setRepairWork(RepairWork repairWork) {
        this.repairWork = repairWork;
    }

    public SpareParts getSpareParts() {
        return spareParts;
    }

    public void setSpareParts(SpareParts spareParts) {
        this.spareParts = spareParts;
    }
}
