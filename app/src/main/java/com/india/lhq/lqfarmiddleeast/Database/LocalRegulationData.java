package com.india.lhq.lqfarmiddleeast.Database;

public class LocalRegulationData {
    private int id;
    private String q1;
    private String q2;
    private String q3;
    private String a1;
    private String a2;
    private String a3;
    private int status;

    public LocalRegulationData() {

    }

    public LocalRegulationData(String q1, String q2, String q3, String a1, String a2, String a3, int status) {
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
