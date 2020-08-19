package main.model;

public class Subject {
    String subId;
    String subName;
    int offeredYearSem;
    int noLecHrs;
    int noTutHrs;
    int noEvalHrs;
    String yearSem;

    public Subject(String subId, String subName, int offeredYearSem, int noLecHrs, int noTutHrs, int noEvalHrs) {
        this.subId = subId;
        this.subName = subName;
        this.offeredYearSem = offeredYearSem;
        this.noLecHrs = noLecHrs;
        this.noTutHrs = noTutHrs;
        this.noEvalHrs = noEvalHrs;
    }

    public Subject() {
    }

    public String getYearSem() {
        return yearSem;
    }

    public void setYearSem(String yearSem) {
        this.yearSem = yearSem;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getOfferedYearSem() {
        return offeredYearSem;
    }

    public void setOfferedYearSem(int offeredYearSem) {
        this.offeredYearSem = offeredYearSem;
    }

    public int getNoLecHrs() {
        return noLecHrs;
    }

    public void setNoLecHrs(int noLecHrs) {
        this.noLecHrs = noLecHrs;
    }

    public int getNoTutHrs() {
        return noTutHrs;
    }

    public void setNoTutHrs(int noTutHrs) {
        this.noTutHrs = noTutHrs;
    }

    public int getNoEvalHrs() {
        return noEvalHrs;
    }

    public void setNoEvalHrs(int noEvalHrs) {
        this.noEvalHrs = noEvalHrs;
    }
}