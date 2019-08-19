package com.india.lhq.lqfarmiddleeast.Database;

import android.widget.TextView;
import com.india.lhq.lqfarmiddleeast.R;

public class SiteIdentificationData {

    private int id;
    private String edt_location;
    private String  edt_sitenumber;
    private String edt_lat;
    private String edt_long ;
    private String edt_sitename;
    private String edt_sitetype ;
    private String edt_siteidentidate;
    private String edt_remark ;
    private int status;

    public SiteIdentificationData() {
    }

    public SiteIdentificationData(String edt_location, String edt_sitenumber, String edt_lat, String edt_long, String edt_sitename, String edt_sitetype, String edt_siteidentidate, String edt_remark, int status) {
        this.edt_location = edt_location;
        this.edt_sitenumber = edt_sitenumber;
        this.edt_lat = edt_lat;
        this.edt_long = edt_long;
        this.edt_sitename = edt_sitename;
        this.edt_sitetype = edt_sitetype;
        this.edt_siteidentidate = edt_siteidentidate;
        this.edt_remark = edt_remark;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEdt_location() {
        return edt_location;
    }

    public void setEdt_location(String edt_location) {
        this.edt_location = edt_location;
    }

    public String getEdt_sitenumber() {
        return edt_sitenumber;
    }

    public void setEdt_sitenumber(String edt_sitenumber) {
        this.edt_sitenumber = edt_sitenumber;
    }

    public String getEdt_lat() {
        return edt_lat;
    }

    public void setEdt_lat(String edt_lat) {
        this.edt_lat = edt_lat;
    }

    public String getEdt_long() {
        return edt_long;
    }

    public void setEdt_long(String edt_long) {
        this.edt_long = edt_long;
    }

    public String getEdt_sitename() {
        return edt_sitename;
    }

    public void setEdt_sitename(String edt_sitename) {
        this.edt_sitename = edt_sitename;
    }

    public String getEdt_sitetype() {
        return edt_sitetype;
    }

    public void setEdt_sitetype(String edt_sitetype) {
        this.edt_sitetype = edt_sitetype;
    }

    public String getEdt_siteidentidate() {
        return edt_siteidentidate;
    }

    public void setEdt_siteidentidate(String edt_siteidentidate) {
        this.edt_siteidentidate = edt_siteidentidate;
    }

    public String getEdt_remark() {
        return edt_remark;
    }

    public void setEdt_remark(String edt_remark) {
        this.edt_remark = edt_remark;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
