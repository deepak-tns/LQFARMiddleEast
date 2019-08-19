package com.india.lhq.lqfarmiddleeast.Database;

public class SiteInformationData {

    private int id;
    private String siteID;
    private String siteName;
    private String siteType;
    private String buildingType;
    private String LAT;
    private String LONG;
    private String SiteAddress;
    private String vendorsite;
    private String Dateofsitevisit;
    private String Sitevisitperformedby;
    private String PhoneNo;
    private String Participantsatthesitevisit;
    private String PhoneNoparticipantssitevist;
    private int status;

    public SiteInformationData() {
    }

    public SiteInformationData(String siteID, String siteName, String siteType, String buildingType, String LAT, String LONG, String siteAddress, String vendorsite, String dateofsitevisit, String sitevisitperformedby, String phoneNo, String participantsatthesitevisit, String phoneNoparticipantssitevist, int status) {
        this.siteID = siteID;
        this.siteName = siteName;
        this.siteType = siteType;
        this.buildingType = buildingType;
        this.LAT = LAT;
        this.LONG = LONG;
        SiteAddress = siteAddress;
        this.vendorsite = vendorsite;
        Dateofsitevisit = dateofsitevisit;
        Sitevisitperformedby = sitevisitperformedby;
        PhoneNo = phoneNo;
        Participantsatthesitevisit = participantsatthesitevisit;
        PhoneNoparticipantssitevist = phoneNoparticipantssitevist;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSiteID() {
        return siteID;
    }

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public String getLAT() {
        return LAT;
    }

    public void setLAT(String LAT) {
        this.LAT = LAT;
    }

    public String getLONG() {
        return LONG;
    }

    public void setLONG(String LONG) {
        this.LONG = LONG;
    }

    public String getSiteAddress() {
        return SiteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        SiteAddress = siteAddress;
    }

    public String getVendorsite() {
        return vendorsite;
    }

    public void setVendorsite(String vendorsite) {
        this.vendorsite = vendorsite;
    }

    public String getDateofsitevisit() {
        return Dateofsitevisit;
    }

    public void setDateofsitevisit(String dateofsitevisit) {
        Dateofsitevisit = dateofsitevisit;
    }

    public String getSitevisitperformedby() {
        return Sitevisitperformedby;
    }

    public void setSitevisitperformedby(String sitevisitperformedby) {
        Sitevisitperformedby = sitevisitperformedby;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getParticipantsatthesitevisit() {
        return Participantsatthesitevisit;
    }

    public void setParticipantsatthesitevisit(String participantsatthesitevisit) {
        Participantsatthesitevisit = participantsatthesitevisit;
    }

    public String getPhoneNoparticipantssitevist() {
        return PhoneNoparticipantssitevist;
    }

    public void setPhoneNoparticipantssitevist(String phoneNoparticipantssitevist) {
        PhoneNoparticipantssitevist = phoneNoparticipantssitevist;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
