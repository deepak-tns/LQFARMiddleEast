package com.india.lhq.lqfarmiddleeast.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String TAG = DatabaseHandler.class.getSimpleName();
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    public static final String DATABASE_NAME = "lqmiddleeastdatabase";
    private static final String TABLE_SITEIDENTIFICATION = "SiteIdentification";
    private static final String TABLE_SPECIFICSUMMYARY = "Specificsummary";
    private static final String TABLE_SITEINFORMATION = "SiteInformation";
    private static final String TABLE_LOCALREGULATION = "LocalRegulation";
    private static final String TABLE_SITEACCESS = "SiteAccess";
    private static final String TABLE_MATERIALTRANSHANDLING = "MTH";
    private static final String TABLE_EQUIPMENTINFORMATION = "EquipmentInformation";
    private static final String TABLE_EQUIPMENTROOMINVESTIGATION = "EquipmentRoomInvestigation";
    private static final String TABLE_POWERANDBATTERBACKUP = "PowerandBatterbackup";
    private static final String TABLE_GROUNDING = "Grounding";
    private static final String TABLE_TRASMISSION = "Transmission";
    private static final String TABLE_CABLEINLETS = "CableInlets";
    private static final String TABLE_ANTENNAPLACEMENTINVESTIGATION = "AntennaPlacementInvestigation";
    private static final String TABLE_SITEPHOTO = "SitePhoto";

    //  Table Columns names for add post Site Identification
    private static final String KEY_INCRI_ID = "Id";
    private static final String KEY_LOCATION = "Location";
    private static final String KEY_SITENUMBER = "SiteNumber";
    private static final String KEY_LAT = "Lat";
    private static final String KEY_LONG = "Long";
    private static final String KEY_SITENAME = "SiteName";
    private static final String KEY_SITETYPE = "SiteType";
    private static final String KEY_DATE = "Date";
    private static final String KEY_REMARK = "Remark";
    private static final String KEY_STATUS = "Status";

    //  Table Columns names for add post Specific Summary
    private static String KEY_SS_ID = "Id";
    private String KEY_SS_QUES1 = "Ques1";
    private String KEY_SS_QUES2 = "Ques2";
    private String KEY_SS_QUES3 = "Ques3";
    private String KEY_SS_QUES4 = "Ques4";
    private String KEY_SS_ANS1 = "Ans1";
    private String KEY_SS_ANS2 = "Ans2";
    private String KEY_SS_ANS3 = "Ans3";
    private String KEY_SS_ANS4 = "Ans4";
    private String KEY_SS_STATUS = "Status";

    //  Table Columns names for add post Site Information
    private static final String KEY_SI_INCRI_ID = "Id";
    private static final String KEY_SI_SITEID = "siteID";
    private static final String KEY_SI_SITENAME = "siteName";
    private static final String KEY_SI_SITETYPE = "SiteType";
    private static final String KEY_SI_BUILDINGTYPE = "BuildingType";
    private static final String KEY_SI_LAT = "Lat";
    private static final String KEY_SI_LONG = "Long";
    private static final String KEY_SI_SITEADDRESS = "Siteaddress";
    private static final String KEY_SI_VENDORSITE = "VenderSite";
    private static final String KEY_SI_DATE = "Date";
    private static final String KEY_SITEVISITPERFORMED = "SiteVisitperfomed";
    private static final String KEY_SI_PHONENO = "phoneno";
    private static final String KEY_SI_PARTICIPENT = "Participent";
    private static final String KEY_SI_PARTICIPENTPHONENO = "ParticipentPhoneno";
    private static final String KEY_SI_STATUS = "Status";

    //  Table Columns names for add post Local Regulation
    private static final String KEY_LR_INCRI_ID = "Id";
    private static final String KEY_LR_QUES1 = "QUES1";
    private static final String KEY_LR_QUES2 = "QUES2";
    private static final String KEY_LR_QUES3 = "QUES3";
    private static final String KEY_LR_ANS1 = "ANS1";
    private static final String KEY_LR_ANS2 = "ANS2";
    private static final String KEY_LR_ANS3 = "ANS3";
    private static final String KEY_LR_STATUS = "STATUS";

    //  Table Columns names for add post Site Access
    private String id = "id";
    private String edt_propertycontactrefrence = "edt_propertycontactrefrence";
    private String edt_parkingarea = "edt_parkingarea";
    private String edt_siteaccessibility = "edt_siteaccessibility";
    private String edt_markonthemap = "edt_markonthemap";
    private String edt_noteroaddescription = "edt_noteroaddescription";
    private String edt_visitorneed = "edt_visitorneed";
    private String edt_workinghourres = "edt_workinghourres";
    private String edt_othersiteaccess = "edt_othersiteaccess";
    private String edt_photographyallowed = "edt_photographyallowed";
    private String img_propertycontactrefrence = "img_propertycontactrefrence";
    private String img_parkingarea = "img_parkingarea";
    private String img_siteaccessibility = "img_siteaccessibility";
    private String img_markonthemap = "img_markonthemap";
    private String img_noteroaddescription = "img_noteroaddescription";
    private String img_visitorneed = "img_visitorneed";
    private String img_workinghourres = "img_workinghourres";
    private String img_othersiteaccess = "img_othersiteaccess";
    private String img_photographyallowed = "img_photographyallowed";
    private String status = "status";

    //  Table Columns names for add post MTH
    private String edt_ques1 = "edt_ques1";
    private String edt_ques2 = "edt_ques2";
    private String edt_ques3 = "edt_ques3";
    private String edt_ques4 = "edt_ques4";
    private String edt_ques5 = "edt_ques5";
    private String edt_ques6 = "edt_ques6";
    private String edt_ques7 = "edt_ques7";
    private String edt_ques8 = "edt_ques8";
    private String edt_ques9 = "edt_ques9";
    private String edt_ques10 = "edt_ques10";
    private String edt_ques11 = "edt_ques11";
    private String edt_ques12 = "edt_ques12";
    private String edt_ques13 = "edt_ques13";
    private String edt_ques14 = "edt_ques14";
    //need only 14..............................
    private String edt_ques15 = "edt_ques15";
    private String edt_ques16 = "edt_ques16";
    private String edt_ques17 = "edt_ques17";
    private String edt_ques18 = "edt_ques18";
    private String edt_ques19 = "edt_ques19";
    private String edt_ques20 = "edt_ques20";
    private String edt_ques21 = "edt_ques21";
    private String edt_ques22 = "edt_ques22";
    private String edt_ques23 = "edt_ques23";
    private String edt_ques24 = "edt_ques24";
    private String edt_ques25 = "edt_ques25";
    private String edt_ques26 = "edt_ques26";
    private String edt_ques27 = "edt_ques27";
    private String edt_ques28 = "edt_ques28";
    private String edt_ques29 = "edt_ques29";
    private String edt_ques30 = "edt_ques30";
    private String radioQues1 = "radioQues1", radioQues2 = "radioQues2", radioQues3 = "radioQues3", radioQues4 = "radioQues4", radioQues5 = "radioQues5",
            radioQues6 = "radioQues6", radioQues7 = "radioQues7", radioQues8 = "radioQues8", radioQues9 = "radioQues9", radioQues10 = "radioQues10", radioQues11 = "radioQues11",
            radioQues12 = "radioQues12", radioQues13 = "radioQues13", radioQues14 = "radioQues14", radioQues15 = "radioQues15", radioQues16 = "radioQues16",
            radioQues17 = "radioQues17", radioQues18 = "radioQues18", radioQues19 = "radioQues19", radioQues20 = "radioQues20", radioQues21 = "radioQues21",
            radioQues22 = "radioQues22", radioQues23 = "radioQues23", radioQues24 = "radioQues24", radioQues25 = "radioQues25", radioQues26 = "radioQues26",
            radioQues27 = "radioQues27", radioQues28 = "radioQues28", radioQues29 = "radioQues29", radioQues30 = "radioQues30";

    // Table Coloumn name for Post Equipment Information
    private String typeofEquipmentExi1 = "typeofEquipmentExi1";
    private String rbspowerExi1 = "rbspowerExi1";
    private String quantityExi1 = "quantityExi1";
    private String dimensionsExi1 = "dimensionsExi1";
    private String configureExi1 = "configureExi1";
    private String sectorExi1 = "sectorExi1";
    private String typeofEquipmentExi2 = "typeofEquipmentExi2";
    private String rbspowerExi2 = "rbspowerExi2";
    private String quantityExi2 = "quantityExi2";
    private String dimensionsExi2 = "dimensionsExi2";
    private String configureExi2 = "configureExi2";
    private String sectorExi2 = "sectorExi2";
    private String typeofEquipmentExi3 = "typeofEquipmentExi3";
    private String rbspowerExi3 = "rbspowerExi3";
    private String quantityExi3 = "quantityExi3";
    private String dimensionsExi3 = "dimensionsExi3";
    private String configureExi3 = "configureExi3";
    private String sectorExi3 = "sectorExi3";
    private String typeofEquipmentExi4 = "typeofEquipmentExi4";
    private String rbspowerExi4 = "rbspowerExi4";
    private String quantityExi4 = "quantityExi4";
    private String dimensionsExi4 = "dimensionsExi4";
    private String configureExi4 = "configureExi4";
    private String sectorExi4 = "sectorExi4";
    private String typeofEquipmentNew1 = "typeofEquipmentNew1";
    private String rbspowerNew1 = "rbspowerNew1";
    private String quantityNew1 = "quantityNew1";
    private String dimensionsNew1 = "dimensionsNew1";
    private String configureNew1 = "configureNew1";
    private String sectorNew1 = "sectorNew1";
    private String typeofEquipmentNew2 = "typeofEquipmentNew2";
    private String rbspowerNew2 = "rbspowerNew2";
    private String quantityNew2 = "quantityNew2";
    private String dimensionsNew2 = "dimensionsNew2";
    private String configureNew2 = "configureNew2";
    private String sectorNew2 = "sectorNew2";
    private String typeofEquipmentNew3 = "typeofEquipmentNew3";
    private String rbspowerNew3 = "rbspowerNew3";
    private String quantityNew3 = "quantityNew3";
    private String dimensionsNew3 = "dimensionsNew3";
    private String configureNew3 = "configureNew3";
    private String sectorNew3 = "sectorNew3";
    private String typeofEquipmentNew4 = "typeofEquipmentNew4";
    private String rbspowerNew4 = "rbspowerNew4";
    private String quantityNew4 = "quantityNew4";
    private String dimensionsNew4 = "dimensionsNew4";
    private String configureNew4 = "configureNew4";
    private String sectorNew4 = "sectorNew4";
    // private String edtques1,edtques2,edtques3,edtques4,edtques5;
    // private String radioQues1,radioQues2,radioQues3,radioQues4,radioQues5;

    // Table Coloumn name for Post Equipment Room Investigation
    // Need only 17....................
    private String edt_ques5_Type = "edt_ques5_Type";
    private String edt_ques5_Dimension = "edt_ques5_Dimension";
    // Table Coloumn name for Post Power and BatteryBackup
    // Need only 30....................
    // Table Coloumn name for Post Grounding Data
    // Need only 3....................
    // Table Coloumn name for Post Transmission
    // Need only 22....................
    // Table Coloumn name for Post Cable Inlets
    // Need only 7....................
    // Table Coloumn name for Post Antenna Placement Investigation
    // Need only 15....................
    private String edt_sectorA_azimuth = "edt_sectorA_azimuth";
    private String edt_sectorA_height = "edt_sectorA_height";
    private String edt_sectorB_azimuth = "edt_sectorB_azimuth";
    private String edt_sectorB_height = "edt_sectorB_height";
    private String edt_sectorC_azimuth = "edt_sectorC_azimuth";
    private String edt_sectorC_height = "edt_sectorC_height";
    private String edt_sectorD_azimuth = "edt_sectorD_azimuth";
    private String edt_sectorD_height = "edt_sectorD_height";

    // Table Coloumn name for Post Site Photos
    private String edt_Siteview = "edt_Siteview";
    private String edt_MicroWaveTRMlink = "edt_MicroWaveTRMlink";
    private String edt_ODEquipmentElevation2 = "edt_ODEquipmentElevation2";
    private String edt_Transmission = "edt_Transmission";
    private String edt_AC_PowerDistributionUnitDB = "edt_AC_PowerDistributionUnitDB";
    private String edt_DC_PowerDistributionUnitType = "edt_DC_PowerDistributionUnitType";
    private String edt_DC_PowerDistributionUnitDB = "edt_DC_PowerDistributionUnitDB";
    private String edt_ExistingEquipment = "edt_ExistingEquipment";
    private String edt_ExistingEquipmentonTower = "edt_ExistingEquipmentonTower";
    private String edt_ExistingEquipmentTowerView = "edt_ExistingEquipmentTowerView";
    private String edt_FreeSpaceAvailable = "edt_FreeSpaceAvailable";
    private String edt_ProposedlocationforRRU = "edt_ProposedlocationforRRU";
    private String edt_ProposedG900RUSinstallatRBS6201 = "edt_ProposedG900RUSinstallatRBS6201";
    private String edt_ProposedU900RUSinstallatRBS6201 = "edt_ProposedU900RUSinstallatRBS6201";
    private String edt_ProposedlocationforRRUS = "edt_ProposedlocationforRRUS";
    private String edt_CableLadder = "edt_CableLadder";
    private String edt_ProposedaddCableLadder = "edt_ProposedaddCableLadder";
    private String edt_DistributionFrames = "edt_DistributionFrames";
    private String edt_Roxtec = "edt_Roxtec";
    private String edt_AdditionalPhotos = "edt_AdditionalPhotos";
    private String img_Siteview = "img_Siteview";
    private String img_MicroWaveTRMlink = "img_MicroWaveTRMlink";
    private String img_ODEquipmentElevation2 = "img_ODEquipmentElevation2";
    private String img_Transmission = "img_Transmission";
    private String img_AC_PowerDistributionUnitDB = "img_AC_PowerDistributionUnitDB";
    private String img_DC_PowerDistributionUnitType = "img_DC_PowerDistributionUnitType";
    private String img_DC_PowerDistributionUnitDB = "img_DC_PowerDistributionUnitDB";
    private String img_ExistingEquipment = "img_ExistingEquipment";
    private String img_ExistingEquipmentonTower = "img_ExistingEquipmentonTower";
    private String img_ExistingEquipmentTowerView = "img_ExistingEquipmentTowerView";
    private String img_FreeSpaceAvailable = "img_FreeSpaceAvailable";
    private String img_ProposedlocationforRRU = "img_ProposedlocationforRRU";
    private String img_ProposedG900RUSinstallatRBS6201 = "img_ProposedG900RUSinstallatRBS6201";
    private String img_ProposedU900RUSinstallatRBS6201 = "img_ProposedU900RUSinstallatRBS6201";
    private String img_ProposedlocationforRRUS = "img_ProposedlocationforRRUS";
    private String img_CableLadder = "img_CableLadder";
    private String img_ProposedaddCableLadder = "img_ProposedaddCableLadder";
    private String img_DistributionFrames = "img_DistributionFrames";
    private String img_Roxtec = "img_Roxtec";
    private String img_AdditionalPhotos = "img_AdditionalPhotos";


    public DatabaseHandler(Context context) {
        super(context, "/mnt/sdcard/lqmiddleeastdatabase.db", null, DATABASE_VERSION);
        // super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.v(TAG, "Databaser object created");
    }

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_SITEIDENTIFICATION = "CREATE TABLE " + TABLE_SITEIDENTIFICATION + "(" + KEY_INCRI_ID + " integer primary key autoincrement,"
                + KEY_LOCATION + " TEXT," + KEY_SITENUMBER + " TEXT," + KEY_LAT + " TEXT," + KEY_LONG + " TEXT,"
                + KEY_SITENAME + " TEXT," + KEY_SITETYPE + " TEXT," + KEY_DATE + " TEXT," + KEY_REMARK + " TEXT," + KEY_STATUS + " integer" + ")";

        String CREATE_TABLE_SPECIFICSUMMYARY = "CREATE TABLE " + TABLE_SPECIFICSUMMYARY + "(" + KEY_SS_ID + " integer primary key autoincrement,"
                + KEY_SS_QUES1 + " TEXT," + KEY_SS_QUES2 + " TEXT," + KEY_SS_QUES3 + " TEXT," + KEY_SS_QUES4 + " TEXT,"
                + KEY_SS_ANS1 + " TEXT," + KEY_SS_ANS2 + " TEXT," + KEY_SS_ANS3 + " TEXT," + KEY_SS_ANS4 + " TEXT," + KEY_STATUS + " integer" + ")";

        String CREATE_TABLE_SITEINFORMATION = "CREATE TABLE " + TABLE_SITEINFORMATION + "(" + KEY_SI_INCRI_ID + " integer primary key autoincrement,"
                + KEY_SI_SITEID + " TEXT," + KEY_SI_SITENAME + " TEXT," + KEY_SI_SITETYPE + " TEXT," + KEY_SI_BUILDINGTYPE + " TEXT," + KEY_SI_LAT + " TEXT," + KEY_SI_LONG + " TEXT,"
                + KEY_SI_SITEADDRESS + " TEXT," + KEY_SI_VENDORSITE + " TEXT," + KEY_SI_DATE + " TEXT," + KEY_SITEVISITPERFORMED + " TEXT,"
                + KEY_SI_PHONENO + " TEXT," + KEY_SI_PARTICIPENT + " TEXT," + KEY_SI_PARTICIPENTPHONENO + " TEXT," + KEY_SI_STATUS + " integer" + ")";

        String CREATE_TABLE_LOCALREGULATION = "CREATE TABLE " + TABLE_LOCALREGULATION + "(" + KEY_LR_INCRI_ID + " integer primary key autoincrement,"
                + KEY_LR_QUES1 + " TEXT," + KEY_LR_QUES2 + " TEXT," + KEY_LR_QUES3 + " TEXT,"
                + KEY_LR_ANS1 + " TEXT," + KEY_LR_ANS2 + " TEXT," + KEY_LR_ANS3 + " TEXT," + KEY_LR_STATUS + " integer" + ")";

        String CREATE_TABLE_SITEACCESS = "CREATE TABLE " + TABLE_SITEACCESS + "(" + id + " integer primary key autoincrement," + edt_propertycontactrefrence + " TEXT,"
                + edt_parkingarea + " TEXT," + edt_siteaccessibility + " TEXT," + edt_markonthemap + " TEXT," + edt_noteroaddescription + " TEXT," + edt_visitorneed + " TEXT,"
                + edt_workinghourres + " TEXT," + edt_othersiteaccess + " TEXT," + edt_photographyallowed + " TEXT,"
                + img_propertycontactrefrence + " TEXT," + img_parkingarea + " TEXT," + img_siteaccessibility + " TEXT," + img_markonthemap + " TEXT," + img_noteroaddescription + " TEXT," + img_visitorneed + " TEXT,"
                + img_workinghourres + " TEXT," + img_othersiteaccess + " TEXT," + img_photographyallowed + " TEXT,"
                + status + " integer" + ")";

        String CREATE_TABLE_MTH = "CREATE TABLE " + TABLE_MATERIALTRANSHANDLING + "(" + id + " integer primary key autoincrement," + edt_ques1 + " TEXT,"
                + edt_ques2 + " TEXT," + edt_ques3 + " TEXT," + edt_ques4 + " TEXT," + edt_ques5 + " TEXT," + edt_ques6 + " TEXT," + edt_ques7 + " TEXT,"
                + edt_ques8 + " TEXT," + edt_ques9 + " TEXT," + edt_ques10 + " TEXT," + edt_ques11 + " TEXT," + edt_ques12 + " TEXT," + edt_ques13 + " TEXT," + edt_ques14 + " TEXT,"
                + radioQues1 + " TEXT," + radioQues2 + " TEXT," + radioQues3 + " TEXT," + radioQues4 + " TEXT," + radioQues5 + " TEXT," + radioQues6 + " TEXT," + radioQues7 + " TEXT,"
                + radioQues8 + " TEXT," + radioQues9 + " TEXT," + radioQues10 + " TEXT," + radioQues11 + " TEXT," + radioQues12 + " TEXT," + radioQues13 + " TEXT," + radioQues14 + " TEXT,"
                + status + " integer" + ")";

        String CREATE_TABLE_EQUIPMENTINFORMATION = "CREATE TABLE " + TABLE_EQUIPMENTINFORMATION + "(" + id + " integer primary key autoincrement," + typeofEquipmentExi1 + " TEXT,"
                + rbspowerExi1 + " TEXT," + quantityExi1 + " TEXT," + dimensionsExi1 + " TEXT," + configureExi1 + " TEXT," + sectorExi1 + " TEXT," + typeofEquipmentExi2 + " TEXT,"
                + rbspowerExi2 + " TEXT," + quantityExi2 + " TEXT," + dimensionsExi2 + " TEXT," + configureExi2 + " TEXT," + sectorExi2 + " TEXT," + typeofEquipmentExi3 + " TEXT,"
                + rbspowerExi3 + " TEXT," + quantityExi3 + " TEXT," + dimensionsExi3 + " TEXT," + configureExi3 + " TEXT," + sectorExi3 + " TEXT," + typeofEquipmentExi4 + " TEXT,"
                + rbspowerExi4 + " TEXT," + quantityExi4 + " TEXT," + dimensionsExi4 + " TEXT," + configureExi4 + " TEXT," + sectorExi4 + " TEXT," + typeofEquipmentNew1 + " TEXT,"
                + rbspowerNew1 + " TEXT," + quantityNew1 + " TEXT," + dimensionsNew1 + " TEXT," + configureNew1 + " TEXT," + sectorNew1 + " TEXT," + typeofEquipmentNew2 + " TEXT,"
                + rbspowerNew2 + " TEXT," + quantityNew2 + " TEXT," + dimensionsNew2 + " TEXT," + configureNew2 + " TEXT," + sectorNew2 + " TEXT," + typeofEquipmentNew3 + " TEXT,"
                + rbspowerNew3 + " TEXT," + quantityNew3 + " TEXT," + dimensionsNew3 + " TEXT," + configureNew3 + " TEXT," + sectorNew3 + " TEXT," + typeofEquipmentNew4 + " TEXT,"
                + rbspowerNew4 + " TEXT," + quantityNew4 + " TEXT," + dimensionsNew4 + " TEXT," + configureNew4 + " TEXT," + sectorNew4 + " TEXT,"
                + edt_ques1 + " TEXT,"  + edt_ques2 + " TEXT," + edt_ques3 + " TEXT," + edt_ques4 + " TEXT," + edt_ques5 + " TEXT," + radioQues1 + " TEXT," + radioQues2 + " TEXT," + radioQues3 + " TEXT," + radioQues4 + " TEXT," + radioQues5 + " TEXT,"
                + status + " integer" + ")";

        String CREATE_TABLE_EQUIPMENTROOMINVESTIGATION = "CREATE TABLE " + TABLE_EQUIPMENTROOMINVESTIGATION + "(" + id + " integer primary key autoincrement," + edt_ques1 + " TEXT,"
                + edt_ques2 + " TEXT," + edt_ques3 + " TEXT," + edt_ques4 + " TEXT," + edt_ques5_Type + " TEXT," + edt_ques5_Dimension + " TEXT," + edt_ques6 + " TEXT," + edt_ques7 + " TEXT," + edt_ques8 + " TEXT,"
                + edt_ques9 + " TEXT," + edt_ques10 + " TEXT," + edt_ques11 + " TEXT," + edt_ques12 + " TEXT," + edt_ques13 + " TEXT," + edt_ques14 + " TEXT," + edt_ques15 + " TEXT," + edt_ques16 + " TEXT," + edt_ques17 + " TEXT,"
                + radioQues1 + " TEXT," + radioQues2 + " TEXT," + radioQues3 + " TEXT," + radioQues4 + " TEXT," + radioQues5 + " TEXT," + radioQues6 + " TEXT," + radioQues7 + " TEXT,"
                + radioQues8 + " TEXT," + radioQues9 + " TEXT," + radioQues10 + " TEXT," + radioQues11 + " TEXT," + radioQues12 + " TEXT," + radioQues13 + " TEXT," + radioQues14 + " TEXT," + radioQues15 + " TEXT," + radioQues16 + " TEXT," + radioQues17 + " TEXT,"
                + status + " integer" + ")";
        String CREATE_TABLE_POWERANDBATTERBACKUP = "CREATE TABLE " + TABLE_POWERANDBATTERBACKUP + "(" + id + " integer primary key autoincrement," + edt_ques1 + " TEXT,"
                + edt_ques2 + " TEXT," + edt_ques3 + " TEXT," + edt_ques4 + " TEXT," + edt_ques5 + " TEXT," + edt_ques6 + " TEXT," + edt_ques7 + " TEXT," + edt_ques8 + " TEXT,"
                + edt_ques9 + " TEXT," + edt_ques10 + " TEXT," + edt_ques11 + " TEXT," + edt_ques12 + " TEXT," + edt_ques13 + " TEXT," + edt_ques14 + " TEXT," + edt_ques15 + " TEXT," + edt_ques16 + " TEXT,"
                + edt_ques17 + " TEXT," + edt_ques18 + " TEXT," + edt_ques19 + " TEXT," + edt_ques20 + " TEXT," + edt_ques21 + " TEXT," + edt_ques22 + " TEXT," + edt_ques23 + " TEXT,"
                + edt_ques24 + " TEXT," + edt_ques25 + " TEXT," + edt_ques26 + " TEXT," + edt_ques27 + " TEXT," + edt_ques28 + " TEXT," + edt_ques29 + " TEXT," + edt_ques30 + " TEXT,"
                + radioQues1 + " TEXT," + radioQues2 + " TEXT," + radioQues3 + " TEXT," + radioQues4 + " TEXT," + radioQues5 + " TEXT," + radioQues6 + " TEXT," + radioQues7 + " TEXT,"
                + radioQues8 + " TEXT," + radioQues9 + " TEXT," + radioQues10 + " TEXT," + radioQues11 + " TEXT," + radioQues12 + " TEXT," + radioQues13 + " TEXT," + radioQues14 + " TEXT," + radioQues15 + " TEXT,"
                + radioQues16 + " TEXT," + radioQues17 + " TEXT," + radioQues18 + " TEXT," + radioQues19 + " TEXT," + radioQues20 + " TEXT," + radioQues21 + " TEXT," + radioQues22 + " TEXT,"
                + radioQues23 + " TEXT," + radioQues24 + " TEXT," + radioQues25 + " TEXT," + radioQues26 + " TEXT," + radioQues27 + " TEXT," + radioQues28 + " TEXT," + radioQues29 + " TEXT," + radioQues30 + " TEXT,"
                + status + " integer" + ")";

        String CREATE_TABLE_GROUNDING = "CREATE TABLE " + TABLE_GROUNDING + "(" + id + " integer primary key autoincrement,"
                + edt_ques1 + " TEXT," + edt_ques2 + " TEXT," + edt_ques3 + " TEXT,"
                + radioQues1 + " TEXT," + radioQues2 + " TEXT," + radioQues3 + " TEXT,"
                + status + " integer" + ")";

        String CREATE_TABLE_TRANSMISSION = "CREATE TABLE " + TABLE_TRASMISSION + "(" + id + " integer primary key autoincrement," + edt_ques1 + " TEXT,"
                + edt_ques2 + " TEXT," + edt_ques3 + " TEXT," + edt_ques4 + " TEXT," + edt_ques5 + " TEXT," + edt_ques6 + " TEXT," + edt_ques7 + " TEXT," + edt_ques8 + " TEXT,"
                + edt_ques9 + " TEXT," + edt_ques10 + " TEXT," + edt_ques11 + " TEXT," + edt_ques12 + " TEXT," + edt_ques13 + " TEXT," + edt_ques14 + " TEXT," + edt_ques15 + " TEXT," + edt_ques16 + " TEXT,"
                + edt_ques17 + " TEXT," + edt_ques18 + " TEXT," + edt_ques19 + " TEXT," + edt_ques20 + " TEXT," + edt_ques21 + " TEXT," + edt_ques22 + " TEXT,"
                + radioQues1 + " TEXT," + radioQues2 + " TEXT," + radioQues3 + " TEXT," + radioQues4 + " TEXT," + radioQues5 + " TEXT," + radioQues6 + " TEXT," + radioQues7 + " TEXT,"
                + radioQues8 + " TEXT," + radioQues9 + " TEXT," + radioQues10 + " TEXT," + radioQues11 + " TEXT," + radioQues12 + " TEXT," + radioQues13 + " TEXT," + radioQues14 + " TEXT," + radioQues15 + " TEXT,"
                + radioQues16 + " TEXT," + radioQues17 + " TEXT," + radioQues18 + " TEXT," + radioQues19 + " TEXT," + radioQues20 + " TEXT," + radioQues21 + " TEXT," + radioQues22 + " TEXT,"
                + status + " integer" + ")";

        String CREATE_TABLE_CABLEINLETS = "CREATE TABLE " + TABLE_CABLEINLETS + "(" + id + " integer primary key autoincrement," + edt_ques1 + " TEXT,"
                + edt_ques2 + " TEXT," + edt_ques3 + " TEXT," + edt_ques4 + " TEXT," + edt_ques5 + " TEXT," + edt_ques6 + " TEXT," + edt_ques7 + " TEXT,"
                + radioQues1 + " TEXT," + radioQues2 + " TEXT," + radioQues3 + " TEXT," + radioQues4 + " TEXT," + radioQues5 + " TEXT," + radioQues6 + " TEXT," + radioQues7 + " TEXT,"
                + status + " integer" + ")";
        String CREATE_TABLE_ANTENNAPLACEMENTINVESTIGATION = "CREATE TABLE " + TABLE_ANTENNAPLACEMENTINVESTIGATION + "(" + id + " integer primary key autoincrement," + edt_ques1 + " TEXT,"
                + edt_ques2 + " TEXT," + edt_ques3 + " TEXT," + edt_ques4 + " TEXT," + edt_ques5 + " TEXT," + edt_ques6 + " TEXT," + edt_ques7 + " TEXT,"
                + edt_ques8 + " TEXT," + edt_ques9 + " TEXT," + edt_ques10 + " TEXT," + edt_ques11 + " TEXT," + edt_ques12 + " TEXT," + edt_ques13 + " TEXT," + edt_ques14 + " TEXT," + edt_ques15 + " TEXT,"
                + radioQues1 + " TEXT," + radioQues2 + " TEXT," + radioQues3 + " TEXT," + radioQues4 + " TEXT," + radioQues5 + " TEXT," + radioQues6 + " TEXT," + radioQues7 + " TEXT,"
                + radioQues8 + " TEXT," + radioQues9 + " TEXT," + radioQues10 + " TEXT," + radioQues11 + " TEXT," + radioQues12 + " TEXT," + radioQues13 + " TEXT," + radioQues14 + " TEXT," + radioQues15 + " TEXT,"
                + edt_sectorA_azimuth + " TEXT," + edt_sectorA_height + " TEXT," + edt_sectorB_azimuth + " TEXT," + edt_sectorB_height + " TEXT," + edt_sectorC_azimuth + " TEXT," + edt_sectorC_height + " TEXT," + edt_sectorD_azimuth + " TEXT," + edt_sectorD_height + " TEXT,"
                + status + " integer" + ")";
        String CREATE_TABLE_TABLE_SITEPHOTO = "CREATE TABLE " + TABLE_SITEPHOTO + "(" + id + " integer primary key autoincrement," + edt_Siteview + " TEXT,"
                + edt_MicroWaveTRMlink + " TEXT," + edt_ODEquipmentElevation2 + " TEXT," + edt_Transmission + " TEXT," + edt_AC_PowerDistributionUnitDB + " TEXT," + edt_DC_PowerDistributionUnitType + " TEXT," + edt_DC_PowerDistributionUnitDB + " TEXT,"
                + edt_ExistingEquipment + " TEXT," + edt_ExistingEquipmentonTower + " TEXT," + edt_ExistingEquipmentTowerView + " TEXT," + edt_FreeSpaceAvailable + " TEXT," + edt_ProposedlocationforRRU + " TEXT," + edt_ProposedG900RUSinstallatRBS6201 + " TEXT," + edt_ProposedU900RUSinstallatRBS6201 + " TEXT," + edt_ProposedlocationforRRUS + " TEXT,"
                + edt_CableLadder + " TEXT," + edt_ProposedaddCableLadder + " TEXT," + edt_DistributionFrames + " TEXT," + edt_Roxtec + " TEXT," + edt_AdditionalPhotos + " TEXT,"
                + img_Siteview + " TEXT," + img_MicroWaveTRMlink + " TEXT," + img_ODEquipmentElevation2 + " TEXT," + img_Transmission + " TEXT," + img_AC_PowerDistributionUnitDB + " TEXT," + img_DC_PowerDistributionUnitType + " TEXT," + img_DC_PowerDistributionUnitDB + " TEXT,"
                + img_ExistingEquipment + " TEXT," + img_ExistingEquipmentonTower + " TEXT," + img_ExistingEquipmentTowerView + " TEXT," + img_FreeSpaceAvailable + " TEXT," + img_ProposedlocationforRRU + " TEXT," + img_ProposedG900RUSinstallatRBS6201 + " TEXT," + img_ProposedU900RUSinstallatRBS6201 + " TEXT," + img_ProposedlocationforRRUS + " TEXT,"
                + img_CableLadder + " TEXT," + img_ProposedaddCableLadder + " TEXT," + img_DistributionFrames + " TEXT," + img_Roxtec + " TEXT," + img_AdditionalPhotos + " TEXT,"
                + status + " integer" + ")";

        db.execSQL(CREATE_TABLE_SITEIDENTIFICATION);
        db.execSQL(CREATE_TABLE_SPECIFICSUMMYARY);
        db.execSQL(CREATE_TABLE_SITEINFORMATION);
        db.execSQL(CREATE_TABLE_LOCALREGULATION);
        db.execSQL(CREATE_TABLE_SITEACCESS);
        db.execSQL(CREATE_TABLE_MTH);
        db.execSQL(CREATE_TABLE_EQUIPMENTINFORMATION);
        db.execSQL(CREATE_TABLE_EQUIPMENTROOMINVESTIGATION);
        db.execSQL(CREATE_TABLE_POWERANDBATTERBACKUP);
        db.execSQL(CREATE_TABLE_GROUNDING);
        db.execSQL(CREATE_TABLE_TRANSMISSION);
        db.execSQL(CREATE_TABLE_CABLEINLETS);
        db.execSQL(CREATE_TABLE_ANTENNAPLACEMENTINVESTIGATION);
        db.execSQL(CREATE_TABLE_TABLE_SITEPHOTO);

        Log.v(TAG, "Database table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SITEIDENTIFICATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SPECIFICSUMMYARY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SITEINFORMATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCALREGULATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SITEACCESS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATERIALTRANSHANDLING);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EQUIPMENTINFORMATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EQUIPMENTROOMINVESTIGATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POWERANDBATTERBACKUP);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROUNDING);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRASMISSION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CABLEINLETS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANTENNAPLACEMENTINVESTIGATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SITEPHOTO);

        onCreate(db);
    }

    // code to add the new siteidentification
    public void insertSiteIdentificationData(SiteIdentificationData siteIdentification) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_LOCATION, siteIdentification.getEdt_location());
        values.put(KEY_SITENUMBER, siteIdentification.getEdt_sitenumber());
        values.put(KEY_LAT, siteIdentification.getEdt_lat());
        values.put(KEY_LONG, siteIdentification.getEdt_long());
        values.put(KEY_SITENAME, siteIdentification.getEdt_sitename());
        values.put(KEY_SITETYPE, siteIdentification.getEdt_sitetype());
        values.put(KEY_DATE, siteIdentification.getEdt_siteidentidate());
        values.put(KEY_REMARK, siteIdentification.getEdt_remark());
        values.put(KEY_STATUS, siteIdentification.getStatus());
        // Inserting Row
        db.insert(TABLE_SITEIDENTIFICATION, null, values);
        Log.v(TAG, "Databaser insert siteidentification table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }


    public void deleteSingleRowSiteIdentificationData(String value) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_SITEIDENTIFICATION + " WHERE " + KEY_INCRI_ID + "='" + value + "'");
        db.close();
    }

    public void delete_SiteIdentification() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_SITEIDENTIFICATION + " ;");
        db.close();
    }

    public List<SiteIdentificationData> getAllSiteIdentificationData() {
        List<SiteIdentificationData> List = new ArrayList<SiteIdentificationData>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_SITEIDENTIFICATION;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                SiteIdentificationData data = new SiteIdentificationData();
                data.setId(cursor.getInt(0));
                data.setEdt_location(cursor.getString(1));
                data.setEdt_sitenumber(cursor.getString(2));
                data.setEdt_lat(cursor.getString(3));
                data.setEdt_long(cursor.getString(4));
                data.setEdt_sitename(cursor.getString(5));
                data.setEdt_sitetype(cursor.getString(6));
                data.setEdt_siteidentidate(cursor.getString(7));
                data.setEdt_remark(cursor.getString(8));
                data.setStatus(cursor.getInt(9));
                // Adding contact to list
                List.add(data);
            } while (cursor.moveToNext());
        }
        // return contact list
        return List;
    }

    public List<SiteIdentificationData> getLastSiteIdentification() {
        ArrayList<SiteIdentificationData> list = new ArrayList<SiteIdentificationData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";
        String selectQuery = "SELECT  * FROM " + TABLE_SITEIDENTIFICATION + " ORDER BY " + KEY_INCRI_ID + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        SiteIdentificationData data = new SiteIdentificationData();
                        data.setId(cursor.getInt(0));
                        data.setEdt_location(cursor.getString(1));
                        data.setEdt_sitenumber(cursor.getString(2));
                        data.setEdt_lat(cursor.getString(3));
                        data.setEdt_long(cursor.getString(4));
                        data.setEdt_sitename(cursor.getString(5));
                        data.setEdt_sitetype(cursor.getString(6));
                        data.setEdt_siteidentidate(cursor.getString(7));
                        data.setEdt_remark(cursor.getString(8));
                        data.setStatus(cursor.getInt(9));

                        // Adding contact to list
                        list.add(data);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    public int getLastInsertIdTABLE_SiteIdentification() {
        int index = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + TABLE_SITEIDENTIFICATION, null);
        if (cursor.moveToLast()) {
            index = cursor.getInt(0);//to get id, 0 is the column index
        }
        cursor.close();
        return index;
    }

    public boolean updateSiteIdentification(int incriid, int flag) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues args = new ContentValues();

        args.put(KEY_STATUS, flag);
        //  args.put(KEY_LATLONG_TOTALDIST,dis);


        int i = db.update(TABLE_SITEIDENTIFICATION, args, KEY_INCRI_ID + "=" + incriid, null);
        return i > 0;
    }

    // Getting AddBusData Count
    public int getCountSiteIdentification() {
        String countQuery = "SELECT  * FROM " + TABLE_SITEIDENTIFICATION;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    // code to add the new specificsummary
    public void insertSpecificSummaryData(SpecificSummaryData specificSummaryData) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_SS_QUES1, specificSummaryData.getQues1());
        values.put(KEY_SS_QUES2, specificSummaryData.getQues2());
        values.put(KEY_SS_QUES3, specificSummaryData.getQues3());
        values.put(KEY_SS_QUES4, specificSummaryData.getQues4());
        values.put(KEY_SS_ANS1, specificSummaryData.getAns1());
        values.put(KEY_SS_ANS2, specificSummaryData.getAns2());
        values.put(KEY_SS_ANS3, specificSummaryData.getAns3());
        values.put(KEY_SS_ANS4, specificSummaryData.getAns4());
        values.put(KEY_SS_STATUS, specificSummaryData.getStatus());
        // Inserting Row
        db.insert(TABLE_SPECIFICSUMMYARY, null, values);
        Log.v(TAG, "Databaser insert specificsummary table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<SpecificSummaryData> getLastSpecificSummaryData() {
        ArrayList<SpecificSummaryData> list = new ArrayList<SpecificSummaryData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";
        String selectQuery = "SELECT  * FROM " + TABLE_SPECIFICSUMMYARY + " ORDER BY " + KEY_SS_ID + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        SpecificSummaryData data = new SpecificSummaryData();
                        data.setId(cursor.getInt(0));
                        data.setQues1(cursor.getString(1));
                        data.setQues2(cursor.getString(2));
                        data.setQues3(cursor.getString(3));
                        data.setQues4(cursor.getString(4));
                        data.setAns1(cursor.getString(5));
                        data.setAns2(cursor.getString(6));
                        data.setAns3(cursor.getString(7));
                        data.setAns4(cursor.getString(8));
                        data.setStatus(cursor.getInt(9));

                        // Adding contact to list
                        list.add(data);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    public int getLastInsertIdTABLE_SpecificSummaryData() {
        int index = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + TABLE_SPECIFICSUMMYARY, null);
        if (cursor.moveToLast()) {
            index = cursor.getInt(0);//to get id, 0 is the column index
        }
        cursor.close();
        return index;
    }

    public boolean updateSpecificSummaryData(int incriid, int flag) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues args = new ContentValues();

        args.put(KEY_SS_STATUS, flag);
        //  args.put(KEY_LATLONG_TOTALDIST,dis);


        int i = db.update(TABLE_SPECIFICSUMMYARY, args, KEY_SS_ID + "=" + incriid, null);
        return i > 0;
    }

    // Getting AddBusData Count
    public int getCountSpecificSummaryData() {
        String countQuery = "SELECT  * FROM " + TABLE_SPECIFICSUMMYARY;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }
    public void deleteSomeRow_SpecificSummary() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_SPECIFICSUMMYARY + " ;");
        db.close();
    }

    // code to add the new siteInformation
    public void insertSiteInformationData(SiteInformationData siteInformationData) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_SI_SITEID, siteInformationData.getSiteID());
        values.put(KEY_SI_SITENAME, siteInformationData.getSiteName());
        values.put(KEY_SI_SITETYPE, siteInformationData.getSiteType());
        values.put(KEY_SI_BUILDINGTYPE, siteInformationData.getBuildingType());
        values.put(KEY_SI_LAT, siteInformationData.getLAT());
        values.put(KEY_SI_LONG, siteInformationData.getLONG());
        values.put(KEY_SI_SITEADDRESS, siteInformationData.getSiteAddress());
        values.put(KEY_SI_VENDORSITE, siteInformationData.getVendorsite());
        values.put(KEY_SI_DATE, siteInformationData.getDateofsitevisit());
        values.put(KEY_SITEVISITPERFORMED, siteInformationData.getSitevisitperformedby());
        values.put(KEY_SI_PHONENO, siteInformationData.getPhoneNo());
        values.put(KEY_SI_PARTICIPENT, siteInformationData.getParticipantsatthesitevisit());
        values.put(KEY_SI_PARTICIPENTPHONENO, siteInformationData.getPhoneNoparticipantssitevist());
        values.put(KEY_SI_STATUS, siteInformationData.getStatus());
        // Inserting Row
        db.insert(TABLE_SITEINFORMATION, null, values);
        Log.v(TAG, "Databaser insert siteinformation table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public void deleteSingleRowSiteInformationData(String value) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_SITEINFORMATION + " WHERE " + KEY_SI_INCRI_ID + "='" + value + "'");
        db.close();
    }

    public void deleteSomeRow_SiteInformationData() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_SITEINFORMATION + " ;");
        db.close();
    }


    public List<SiteInformationData> getLastSiteInformationData() {
        ArrayList<SiteInformationData> list = new ArrayList<SiteInformationData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";
        String selectQuery = "SELECT  * FROM " + TABLE_SITEINFORMATION + " ORDER BY " + KEY_SI_INCRI_ID + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        SiteInformationData data = new SiteInformationData();
                        data.setId(cursor.getInt(0));
                        data.setSiteID(cursor.getString(1));
                        data.setSiteName(cursor.getString(2));
                        data.setSiteType(cursor.getString(3));
                        data.setBuildingType(cursor.getString(4));
                        data.setLAT(cursor.getString(5));
                        data.setLONG(cursor.getString(6));
                        data.setSiteAddress(cursor.getString(7));
                        data.setVendorsite(cursor.getString(8));
                        data.setDateofsitevisit(cursor.getString(9));
                        data.setSitevisitperformedby(cursor.getString(10));
                        data.setPhoneNo(cursor.getString(11));
                        data.setParticipantsatthesitevisit(cursor.getString(12));
                        data.setPhoneNoparticipantssitevist(cursor.getString(13));
                        data.setStatus(cursor.getInt(14));


                        // Adding contact to list
                        list.add(data);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    public int getLastInsertIdTABLE_SiteInformationData() {
        int index = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + TABLE_SITEINFORMATION, null);
        if (cursor.moveToLast()) {
            index = cursor.getInt(0);//to get id, 0 is the column index
        }
        cursor.close();
        return index;
    }

    public boolean updateSiteInformationData(int incriid, int flag) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues args = new ContentValues();

        args.put(KEY_SI_STATUS, flag);
        //  args.put(KEY_LATLONG_TOTALDIST,dis);


        int i = db.update(TABLE_SITEINFORMATION, args, KEY_SI_INCRI_ID + "=" + incriid, null);
        return i > 0;
    }

    // Getting AddBusData Count
    public int getCountSiteInformationData() {
        String countQuery = "SELECT  * FROM " + TABLE_SITEINFORMATION;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    // code to add the new Local Regulation
    public void insertLocalRegulationData(LocalRegulationData localRegulationData) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_LR_QUES1, localRegulationData.getQ1());
        values.put(KEY_LR_QUES2, localRegulationData.getQ2());
        values.put(KEY_LR_QUES3, localRegulationData.getA3());
        values.put(KEY_LR_ANS1, localRegulationData.getA1());
        values.put(KEY_LR_ANS2, localRegulationData.getA2());
        values.put(KEY_LR_ANS3, localRegulationData.getA3());
        values.put(KEY_SS_STATUS, localRegulationData.getStatus());
        // Inserting Row
        db.insert(TABLE_LOCALREGULATION, null, values);
        Log.v(TAG, "Databaser insert localregulation table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<LocalRegulationData> getLastLocalRegulationData() {
        ArrayList<LocalRegulationData> list = new ArrayList<LocalRegulationData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";
        String selectQuery = "SELECT  * FROM " + TABLE_LOCALREGULATION + " ORDER BY " + KEY_LR_INCRI_ID + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        LocalRegulationData data = new LocalRegulationData();
                        data.setId(cursor.getInt(0));
                        data.setQ1(cursor.getString(1));
                        data.setQ2(cursor.getString(2));
                        data.setQ3(cursor.getString(3));
                        data.setA1(cursor.getString(4));
                        data.setA2(cursor.getString(5));
                        data.setA3(cursor.getString(6));
                        data.setStatus(cursor.getInt(7));

                        // Adding contact to list
                        list.add(data);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    public int getLastInsertIdTABLE_LocalRegulationData() {
        int index = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + TABLE_LOCALREGULATION, null);
        if (cursor.moveToLast()) {
            index = cursor.getInt(0);//to get id, 0 is the column index
        }
        cursor.close();
        return index;
    }

    public boolean updateLocalRegulationData(int incriid, int flag) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues args = new ContentValues();

        args.put(KEY_LR_STATUS, flag);
        //  args.put(KEY_LATLONG_TOTALDIST,dis);


        int i = db.update(TABLE_LOCALREGULATION, args, KEY_LR_INCRI_ID + "=" + incriid, null);
        return i > 0;
    }

    // Getting AddBusData Count
    public int getCountLocalRegulationData() {
        String countQuery = "SELECT  * FROM " + TABLE_LOCALREGULATION;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    public void deleteSomeRow_LocalRegulation() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_LOCALREGULATION + " ;");
        db.close();
    }

    // code to add the new Site Access
    public void insertSiteAccess(SiteAccessData siteAccessData) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(edt_propertycontactrefrence, siteAccessData.getEdt_propertycontactrefrence());
        values.put(edt_parkingarea, siteAccessData.getEdt_parkingarea());
        values.put(edt_siteaccessibility, siteAccessData.getEdt_siteaccessibility());
        values.put(edt_markonthemap, siteAccessData.getEdt_markonthemap());
        values.put(edt_noteroaddescription, siteAccessData.getEdt_noteroaddescription());
        values.put(edt_visitorneed, siteAccessData.getEdt_visitorneed());
        values.put(edt_workinghourres, siteAccessData.getEdt_workinghourres());
        values.put(edt_othersiteaccess, siteAccessData.getEdt_othersiteaccess());
        values.put(edt_photographyallowed, siteAccessData.getEdt_photographyallowed());
        values.put(img_propertycontactrefrence, siteAccessData.getImg_propertycontactrefrence());
        values.put(img_parkingarea, siteAccessData.getImg_parkingarea());
        values.put(img_siteaccessibility, siteAccessData.getImg_siteaccessibility());
        values.put(img_markonthemap, siteAccessData.getImg_markonthemap());
        values.put(img_noteroaddescription, siteAccessData.getImg_noteroaddescription());
        values.put(img_visitorneed, siteAccessData.getImg_visitorneed());
        values.put(img_workinghourres, siteAccessData.getImg_workinghourres());
        values.put(img_othersiteaccess, siteAccessData.getImg_othersiteaccess());
        values.put(img_photographyallowed, siteAccessData.getImg_photographyallowed());
        values.put(status, siteAccessData.getStatus());


        // Inserting Row
        db.insert(TABLE_SITEACCESS, null, values);
        Log.v(TAG, "Databaser insert siteAccess table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<SiteAccessData> getLastSiteAccess() {
        ArrayList<SiteAccessData> list = new ArrayList<SiteAccessData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";
        String selectQuery = "SELECT  * FROM " + TABLE_SITEACCESS + " ORDER BY " + id + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        SiteAccessData data = new SiteAccessData();
                        data.setId(cursor.getInt(0));
                        data.setEdt_propertycontactrefrence(cursor.getString(1));
                        data.setEdt_parkingarea(cursor.getString(2));
                        data.setEdt_siteaccessibility(cursor.getString(3));
                        data.setEdt_markonthemap(cursor.getString(4));
                        data.setEdt_noteroaddescription(cursor.getString(5));
                        data.setEdt_visitorneed(cursor.getString(6));
                        data.setEdt_workinghourres(cursor.getString(7));
                        data.setEdt_othersiteaccess(cursor.getString(8));
                        data.setEdt_photographyallowed(cursor.getString(9));
                        data.setImg_propertycontactrefrence(cursor.getString(10));
                        data.setImg_parkingarea(cursor.getString(11));
                        data.setImg_siteaccessibility(cursor.getString(12));
                        data.setImg_markonthemap(cursor.getString(13));
                        data.setImg_noteroaddescription(cursor.getString(14));
                        data.setImg_visitorneed(cursor.getString(15));
                        data.setImg_workinghourres(cursor.getString(16));
                        data.setImg_othersiteaccess(cursor.getString(17));
                        data.setImg_photographyallowed(cursor.getString(18));
                        data.setStatus(cursor.getInt(19));


                        // Adding contact to list
                        list.add(data);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    public int getLastInsertIdTABLE_SiteAccess() {
        int index = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + TABLE_SITEACCESS, null);
        if (cursor.moveToLast()) {
            index = cursor.getInt(0);//to get id, 0 is the column index
        }
        cursor.close();
        return index;
    }


    // Getting AddBusData Count
    public int getCountSiteAccess() {
        String countQuery = "SELECT  * FROM " + TABLE_SITEACCESS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }
    public void deleteSomeRow_SiteAccess() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_SITEACCESS + " ;");
        db.close();
    }

    // code to add the new MTH Data Table
    public void insertMTHData(MaterialTransportHandlingData mth) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(edt_ques1, mth.getEdt_ques1());
        values.put(edt_ques2, mth.getEdt_ques2());
        values.put(edt_ques3, mth.getEdt_ques3());
        values.put(edt_ques4, mth.getEdt_ques4());
        values.put(edt_ques5, mth.getEdt_ques5());
        values.put(edt_ques6, mth.getEdt_ques6());
        values.put(edt_ques7, mth.getEdt_ques7());
        values.put(edt_ques8, mth.getEdt_ques8());
        values.put(edt_ques9, mth.getEdt_ques9());
        values.put(edt_ques10, mth.getEdt_ques10());
        values.put(edt_ques11, mth.getEdt_ques11());
        values.put(edt_ques12, mth.getEdt_ques12());
        values.put(edt_ques13, mth.getEdt_ques13());
        values.put(edt_ques14, mth.getEdt_ques14());
        values.put(radioQues1, mth.getRadioQues1());
        values.put(radioQues2, mth.getRadioQues2());
        values.put(radioQues3, mth.getRadioQues3());
        values.put(radioQues4, mth.getRadioQues4());
        values.put(radioQues5, mth.getRadioQues5());
        values.put(radioQues6, mth.getRadioQues6());
        values.put(radioQues7, mth.getRadioQues7());
        values.put(radioQues8, mth.getRadioQues8());
        values.put(radioQues9, mth.getRadioQues9());
        values.put(radioQues10, mth.getRadioQues10());
        values.put(radioQues11, mth.getRadioQues11());
        values.put(radioQues12, mth.getRadioQues12());
        values.put(radioQues13, mth.getRadioQues13());
        values.put(radioQues14, mth.getRadioQues14());


        values.put(status, mth.getStatus());
        // Inserting Row
        db.insert(TABLE_MATERIALTRANSHANDLING, null, values);
        Log.v(TAG, "Databaser insert MTH table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<MaterialTransportHandlingData> getLastMTHData() {
        ArrayList<MaterialTransportHandlingData> list = new ArrayList<MaterialTransportHandlingData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";
        String selectQuery = "SELECT  * FROM " + TABLE_MATERIALTRANSHANDLING + " ORDER BY " + id + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        MaterialTransportHandlingData data = new MaterialTransportHandlingData();
                        data.setId(cursor.getInt(0));
                        data.setEdt_ques1(cursor.getString(1));
                        data.setEdt_ques2(cursor.getString(2));
                        data.setEdt_ques3(cursor.getString(3));
                        data.setEdt_ques4(cursor.getString(4));
                        data.setEdt_ques5(cursor.getString(5));
                        data.setEdt_ques6(cursor.getString(6));
                        data.setEdt_ques7(cursor.getString(7));
                        data.setEdt_ques8(cursor.getString(8));
                        data.setEdt_ques9(cursor.getString(9));
                        data.setEdt_ques10(cursor.getString(10));
                        data.setEdt_ques11(cursor.getString(11));
                        data.setEdt_ques12(cursor.getString(12));
                        data.setEdt_ques13(cursor.getString(13));
                        data.setEdt_ques14(cursor.getString(14));
                        data.setRadioQues1(cursor.getString(15));
                        data.setRadioQues2(cursor.getString(16));
                        data.setRadioQues3(cursor.getString(17));
                        data.setRadioQues4(cursor.getString(18));
                        data.setRadioQues5(cursor.getString(19));
                        data.setRadioQues6(cursor.getString(20));
                        data.setRadioQues7(cursor.getString(21));
                        data.setRadioQues8(cursor.getString(22));
                        data.setRadioQues9(cursor.getString(23));
                        data.setRadioQues10(cursor.getString(24));
                        data.setRadioQues11(cursor.getString(25));
                        data.setRadioQues12(cursor.getString(26));
                        data.setRadioQues13(cursor.getString(27));
                        data.setRadioQues14(cursor.getString(28));

                        data.setStatus(cursor.getInt(29));

                        // Adding contact to list
                        list.add(data);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    public int getLastInsertIdTABLE_MTHData() {
        int index = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + TABLE_MATERIALTRANSHANDLING, null);
        if (cursor.moveToLast()) {
            index = cursor.getInt(0);//to get id, 0 is the column index
        }
        cursor.close();
        return index;
    }
    public void deleteSomeRow_MTHData() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_MATERIALTRANSHANDLING + " ;");
        db.close();
    }

    // Getting AddBusData Count
    public int getCountMTHData() {
        String countQuery = "SELECT  * FROM " + TABLE_MATERIALTRANSHANDLING;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    // code to add the new Equipment Information Data Table
    public void insertEquipmentInformationData(EquipmentInformationData equipmentInformationData) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(typeofEquipmentExi1, equipmentInformationData.getTypeofEquipmentExi1());
        values.put(rbspowerExi1, equipmentInformationData.getRbspowerExi1());
        values.put(quantityExi1, equipmentInformationData.getQuantityExi1());
        values.put(dimensionsExi1, equipmentInformationData.getDimensionsExi1());
        values.put(configureExi1, equipmentInformationData.getConfigureExi1());
        values.put(sectorExi1, equipmentInformationData.getSectorExi1());

        values.put(typeofEquipmentExi2, equipmentInformationData.getTypeofEquipmentExi2());
        values.put(rbspowerExi2, equipmentInformationData.getRbspowerExi2());
        values.put(quantityExi2, equipmentInformationData.getQuantityExi2());
        values.put(dimensionsExi2, equipmentInformationData.getDimensionsExi2());
        values.put(configureExi2, equipmentInformationData.getConfigureExi2());
        values.put(sectorExi2, equipmentInformationData.getSectorExi2());

        values.put(typeofEquipmentExi3, equipmentInformationData.getTypeofEquipmentExi3());
        values.put(rbspowerExi3, equipmentInformationData.getRbspowerExi3());
        values.put(quantityExi3, equipmentInformationData.getQuantityExi3());
        values.put(dimensionsExi3, equipmentInformationData.getDimensionsExi3());
        values.put(configureExi3, equipmentInformationData.getConfigureExi3());
        values.put(sectorExi3, equipmentInformationData.getSectorExi3());

        values.put(typeofEquipmentExi4, equipmentInformationData.getTypeofEquipmentExi4());
        values.put(rbspowerExi4, equipmentInformationData.getRbspowerExi4());
        values.put(quantityExi4, equipmentInformationData.getQuantityExi4());
        values.put(dimensionsExi4, equipmentInformationData.getDimensionsExi4());
        values.put(configureExi4, equipmentInformationData.getConfigureExi4());
        values.put(sectorExi4, equipmentInformationData.getSectorExi4());

        values.put(typeofEquipmentNew1, equipmentInformationData.getTypeofEquipmentNew1());
        values.put(rbspowerNew1, equipmentInformationData.getRbspowerNew1());
        values.put(quantityNew1, equipmentInformationData.getQuantityNew1());
        values.put(dimensionsNew1, equipmentInformationData.getDimensionsNew1());
        values.put(configureNew1, equipmentInformationData.getConfigureNew1());
        values.put(sectorNew1, equipmentInformationData.getSectorNew1());

        values.put(typeofEquipmentNew2, equipmentInformationData.getTypeofEquipmentNew2());
        values.put(rbspowerNew2, equipmentInformationData.getRbspowerNew2());
        values.put(quantityNew2, equipmentInformationData.getQuantityNew2());
        values.put(dimensionsNew2, equipmentInformationData.getDimensionsNew2());
        values.put(configureNew2, equipmentInformationData.getConfigureNew2());
        values.put(sectorNew2, equipmentInformationData.getSectorNew2());

        values.put(typeofEquipmentNew3, equipmentInformationData.getTypeofEquipmentNew3());
        values.put(rbspowerNew3, equipmentInformationData.getRbspowerNew3());
        values.put(quantityNew3, equipmentInformationData.getQuantityNew3());
        values.put(dimensionsNew3, equipmentInformationData.getDimensionsNew3());
        values.put(configureNew3, equipmentInformationData.getConfigureNew3());
        values.put(sectorNew3, equipmentInformationData.getSectorNew3());

        values.put(typeofEquipmentNew4, equipmentInformationData.getTypeofEquipmentNew4());
        values.put(rbspowerNew4, equipmentInformationData.getRbspowerNew4());
        values.put(quantityNew4, equipmentInformationData.getQuantityNew4());
        values.put(dimensionsNew4, equipmentInformationData.getDimensionsNew4());
        values.put(configureNew4, equipmentInformationData.getConfigureNew4());
        values.put(sectorNew4, equipmentInformationData.getSectorNew4());

        values.put(edt_ques1, equipmentInformationData.getEdtques1());
        values.put(edt_ques2, equipmentInformationData.getEdtques2());
        values.put(edt_ques3, equipmentInformationData.getEdtques3());
        values.put(edt_ques4, equipmentInformationData.getEdtques4());
        values.put(edt_ques5, equipmentInformationData.getEdtques5());
        values.put(radioQues1, equipmentInformationData.getRadioQues1());
        values.put(radioQues2, equipmentInformationData.getRadioQues2());
        values.put(radioQues3, equipmentInformationData.getRadioQues3());
        values.put(radioQues4, equipmentInformationData.getRadioQues4());
        values.put(radioQues5, equipmentInformationData.getRadioQues5());

        values.put(status, equipmentInformationData.getStatus());
        // Inserting Row
        db.insert(TABLE_EQUIPMENTINFORMATION, null, values);
        Log.v(TAG, "Databaser insert equipmentinformation table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<EquipmentInformationData> getLastEquipmentInformationData() {
        ArrayList<EquipmentInformationData> list = new ArrayList<EquipmentInformationData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";
        String selectQuery = "SELECT  * FROM " + TABLE_EQUIPMENTINFORMATION + " ORDER BY " + id + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        EquipmentInformationData data = new EquipmentInformationData();
                        data.setId(cursor.getInt(0));
                        data.setTypeofEquipmentExi1(cursor.getString(1));
                        data.setRbspowerExi1(cursor.getString(2));
                        data.setQuantityExi1(cursor.getString(3));
                        data.setDimensionsExi1(cursor.getString(4));
                        data.setConfigureExi1(cursor.getString(5));
                        data.setSectorExi1(cursor.getString(6));
                        data.setTypeofEquipmentExi2(cursor.getString(7));
                        data.setRbspowerExi2(cursor.getString(8));
                        data.setQuantityExi2(cursor.getString(9));
                        data.setDimensionsExi2(cursor.getString(10));
                        data.setConfigureExi2(cursor.getString(11));
                        data.setSectorExi2(cursor.getString(12));
                        data.setTypeofEquipmentExi3(cursor.getString(13));
                        data.setRbspowerExi3(cursor.getString(14));
                        data.setQuantityExi3(cursor.getString(15));
                        data.setDimensionsExi3(cursor.getString(16));
                        data.setConfigureExi3(cursor.getString(17));
                        data.setSectorExi3(cursor.getString(18));

                        data.setTypeofEquipmentExi4(cursor.getString(19));
                        data.setRbspowerExi4(cursor.getString(20));
                        data.setQuantityExi4(cursor.getString(21));
                        data.setDimensionsExi4(cursor.getString(22));
                        data.setConfigureExi4(cursor.getString(23));
                        data.setSectorExi4(cursor.getString(24));

                        data.setTypeofEquipmentNew1(cursor.getString(25));
                        data.setRbspowerNew1(cursor.getString(26));
                        data.setQuantityNew1(cursor.getString(27));
                        data.setDimensionsNew1(cursor.getString(28));
                        data.setConfigureNew1(cursor.getString(29));
                        data.setSectorNew1(cursor.getString(30));

                        data.setTypeofEquipmentNew2(cursor.getString(31));
                        data.setRbspowerNew2(cursor.getString(32));
                        data.setQuantityNew2(cursor.getString(33));
                        data.setDimensionsNew2(cursor.getString(34));
                        data.setConfigureNew2(cursor.getString(35));
                        data.setSectorNew2(cursor.getString(36));

                        data.setTypeofEquipmentNew3(cursor.getString(37));
                        data.setRbspowerNew3(cursor.getString(38));
                        data.setQuantityNew3(cursor.getString(39));
                        data.setDimensionsNew3(cursor.getString(40));
                        data.setConfigureNew3(cursor.getString(41));
                        data.setSectorNew3(cursor.getString(42));

                        data.setTypeofEquipmentNew4(cursor.getString(43));
                        data.setRbspowerNew4(cursor.getString(44));
                        data.setQuantityNew4(cursor.getString(45));
                        data.setDimensionsNew4(cursor.getString(46));
                        data.setConfigureNew4(cursor.getString(47));
                        data.setSectorNew4(cursor.getString(48));

                        data.setEdtques1(cursor.getString(49));
                        data.setEdtques2(cursor.getString(50));
                        data.setEdtques3(cursor.getString(51));
                        data.setEdtques4(cursor.getString(52));
                        data.setEdtques5(cursor.getString(53));
                        data.setRadioQues1(cursor.getString(54));
                        data.setRadioQues2(cursor.getString(55));
                        data.setRadioQues3(cursor.getString(56));
                        data.setRadioQues4(cursor.getString(57));
                        data.setRadioQues5(cursor.getString(58));

                        data.setStatus(cursor.getInt(59));

                        // Adding contact to list
                        list.add(data);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    public int getLastInsertIdTABLE_EquipmentInformationData() {
        int index = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + TABLE_EQUIPMENTINFORMATION, null);
        if (cursor.moveToLast()) {
            index = cursor.getInt(0);//to get id, 0 is the column index
        }
        cursor.close();
        return index;
    }
    public void deleteSomeRow_EquipmentInformation() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_EQUIPMENTINFORMATION + " ;");
        db.close();
    }

    // Getting AddBusData Count
    public int getCountEquipmentInformationData() {
        String countQuery = "SELECT  * FROM " + TABLE_EQUIPMENTINFORMATION;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    // code to add the new Equipmentroom InvestigationData Data Table
    public void insertEQUIPMENTROOMINVESTIGATIONData(EquipmentRoomInvestigationData mth) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(edt_ques1, mth.getEdt_ques1());
        values.put(edt_ques2, mth.getEdt_ques2());
        values.put(edt_ques3, mth.getEdt_ques3());
        values.put(edt_ques4, mth.getEdt_ques4());
        values.put(edt_ques5_Type, mth.getEdt_ques5_Type());
        values.put(edt_ques5_Dimension, mth.getEdt_ques5_Dimension());
        values.put(edt_ques6, mth.getEdt_ques6());
        values.put(edt_ques7, mth.getEdt_ques7());
        values.put(edt_ques8, mth.getEdt_ques8());
        values.put(edt_ques9, mth.getEdt_ques9());
        values.put(edt_ques10, mth.getEdt_ques10());
        values.put(edt_ques11, mth.getEdt_ques11());
        values.put(edt_ques12, mth.getEdt_ques12());
        values.put(edt_ques13, mth.getEdt_ques13());
        values.put(edt_ques14, mth.getEdt_ques14());
        values.put(edt_ques15, mth.getEdt_ques15());
        values.put(edt_ques16, mth.getEdt_ques16());
        values.put(edt_ques17, mth.getEdt_ques17());

        values.put(radioQues1, mth.getRadioQues1());
        values.put(radioQues2, mth.getRadioQues2());
        values.put(radioQues3, mth.getRadioQues3());
        values.put(radioQues4, mth.getRadioQues4());
        values.put(radioQues5, mth.getRadioQues5());
        values.put(radioQues6, mth.getRadioQues6());
        values.put(radioQues7, mth.getRadioQues7());
        values.put(radioQues8, mth.getRadioQues8());
        values.put(radioQues9, mth.getRadioQues9());
        values.put(radioQues10, mth.getRadioQues10());
        values.put(radioQues11, mth.getRadioQues11());
        values.put(radioQues12, mth.getRadioQues12());
        values.put(radioQues13, mth.getRadioQues13());
        values.put(radioQues14, mth.getRadioQues14());
        values.put(radioQues15, mth.getRadioQues15());
        values.put(radioQues16, mth.getRadioQues16());
        values.put(radioQues17, mth.getRadioQues17());


        values.put(status, mth.getStatus());
        // Inserting Row
        db.insert(TABLE_EQUIPMENTROOMINVESTIGATION, null, values);
        Log.v(TAG, "Databaser insert EQUIPMENTROOMINVESTIGATION table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<EquipmentRoomInvestigationData> getLastEQUIPMENTROOMINVESTIGATIONData() {
        ArrayList<EquipmentRoomInvestigationData> list = new ArrayList<EquipmentRoomInvestigationData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";
        String selectQuery = "SELECT  * FROM " + TABLE_EQUIPMENTROOMINVESTIGATION + " ORDER BY " + id + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        EquipmentRoomInvestigationData data = new EquipmentRoomInvestigationData();
                        data.setId(cursor.getInt(0));
                        data.setEdt_ques1(cursor.getString(1));
                        data.setEdt_ques2(cursor.getString(2));
                        data.setEdt_ques3(cursor.getString(3));
                        data.setEdt_ques4(cursor.getString(4));
                        data.setEdt_ques5_Type(cursor.getString(5));
                        data.setEdt_ques5_Dimension(cursor.getString(6));
                        data.setEdt_ques6(cursor.getString(7));
                        data.setEdt_ques7(cursor.getString(8));
                        data.setEdt_ques8(cursor.getString(9));
                        data.setEdt_ques9(cursor.getString(10));
                        data.setEdt_ques10(cursor.getString(11));
                        data.setEdt_ques11(cursor.getString(12));
                        data.setEdt_ques12(cursor.getString(13));
                        data.setEdt_ques13(cursor.getString(14));
                        data.setEdt_ques14(cursor.getString(15));
                        data.setEdt_ques15(cursor.getString(16));
                        data.setEdt_ques16(cursor.getString(17));
                        data.setEdt_ques17(cursor.getString(18));

                        data.setRadioQues1(cursor.getString(19));
                        data.setRadioQues2(cursor.getString(20));
                        data.setRadioQues3(cursor.getString(21));
                        data.setRadioQues4(cursor.getString(22));
                        data.setRadioQues5(cursor.getString(23));
                        data.setRadioQues6(cursor.getString(24));
                        data.setRadioQues7(cursor.getString(25));
                        data.setRadioQues8(cursor.getString(26));
                        data.setRadioQues9(cursor.getString(27));
                        data.setRadioQues10(cursor.getString(28));
                        data.setRadioQues11(cursor.getString(29));
                        data.setRadioQues12(cursor.getString(30));
                        data.setRadioQues13(cursor.getString(31));
                        data.setRadioQues14(cursor.getString(32));
                        data.setRadioQues15(cursor.getString(33));
                        data.setRadioQues16(cursor.getString(34));
                        data.setRadioQues17(cursor.getString(35));

                        data.setStatus(cursor.getInt(36));

                        // Adding contact to list
                        list.add(data);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    public int getLastInsertIdTABLE_EQUIPMENTROOMINVESTIGATIONData() {
        int index = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + TABLE_EQUIPMENTROOMINVESTIGATION, null);
        if (cursor.moveToLast()) {
            index = cursor.getInt(0);//to get id, 0 is the column index
        }
        cursor.close();
        return index;
    }

    // Getting AddBusData Count
    public int getCountTABLE_EQUIPMENTROOMINVESTIGATIONData() {
        String countQuery = "SELECT  * FROM " + TABLE_EQUIPMENTROOMINVESTIGATION;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }
    public void deleteSomeRow_EquipmentRoomInvestigation() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_EQUIPMENTROOMINVESTIGATION + " ;");
        db.close();
    }

    // code to add the new Power and BatteryBackup Data Table
    public void insertPowerandBatteryBackupData(PowerandBatterybackup mth) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(edt_ques1, mth.getEdt_ques1());
        values.put(edt_ques2, mth.getEdt_ques2());
        values.put(edt_ques3, mth.getEdt_ques3());
        values.put(edt_ques4, mth.getEdt_ques4());
        values.put(edt_ques5, mth.getEdt_ques5());
        values.put(edt_ques6, mth.getEdt_ques6());
        values.put(edt_ques7, mth.getEdt_ques7());
        values.put(edt_ques8, mth.getEdt_ques8());
        values.put(edt_ques9, mth.getEdt_ques9());
        values.put(edt_ques10, mth.getEdt_ques10());
        values.put(edt_ques11, mth.getEdt_ques11());
        values.put(edt_ques12, mth.getEdt_ques12());
        values.put(edt_ques13, mth.getEdt_ques13());
        values.put(edt_ques14, mth.getEdt_ques14());
        values.put(edt_ques15, mth.getEdt_ques15());
        values.put(edt_ques16, mth.getEdt_ques16());
        values.put(edt_ques17, mth.getEdt_ques17());
        values.put(edt_ques18, mth.getEdt_ques18());
        values.put(edt_ques19, mth.getEdt_ques19());
        values.put(edt_ques20, mth.getEdt_ques20());
        values.put(edt_ques21, mth.getEdt_ques21());
        values.put(edt_ques22, mth.getEdt_ques22());
        values.put(edt_ques23, mth.getEdt_ques23());
        values.put(edt_ques24, mth.getEdt_ques24());
        values.put(edt_ques25, mth.getEdt_ques25());
        values.put(edt_ques26, mth.getEdt_ques26());
        values.put(edt_ques27, mth.getEdt_ques27());
        values.put(edt_ques28, mth.getEdt_ques28());
        values.put(edt_ques29, mth.getEdt_ques29());
        values.put(edt_ques30, mth.getEdt_ques30());
        values.put(radioQues1, mth.getRadioQues1());
        values.put(radioQues2, mth.getRadioQues2());
        values.put(radioQues3, mth.getRadioQues3());
        values.put(radioQues4, mth.getRadioQues4());
        values.put(radioQues5, mth.getRadioQues5());
        values.put(radioQues6, mth.getRadioQues6());
        values.put(radioQues7, mth.getRadioQues7());
        values.put(radioQues8, mth.getRadioQues8());
        values.put(radioQues9, mth.getRadioQues9());
        values.put(radioQues10, mth.getRadioQues10());
        values.put(radioQues11, mth.getRadioQues11());
        values.put(radioQues12, mth.getRadioQues12());
        values.put(radioQues13, mth.getRadioQues13());
        values.put(radioQues14, mth.getRadioQues14());
        values.put(radioQues15, mth.getRadioQues15());
        values.put(radioQues16, mth.getRadioQues16());
        values.put(radioQues17, mth.getRadioQues17());
        values.put(radioQues18, mth.getRadioQues18());
        values.put(radioQues19, mth.getRadioQues19());
        values.put(radioQues20, mth.getRadioQues20());
        values.put(radioQues21, mth.getRadioQues21());
        values.put(radioQues22, mth.getRadioQues22());
        values.put(radioQues23, mth.getRadioQues23());
        values.put(radioQues24, mth.getRadioQues24());
        values.put(radioQues25, mth.getRadioQues25());
        values.put(radioQues26, mth.getRadioQues26());
        values.put(radioQues27, mth.getRadioQues27());
        values.put(radioQues28, mth.getRadioQues28());
        values.put(radioQues29, mth.getRadioQues29());
        values.put(radioQues30, mth.getRadioQues30());


        values.put(status, mth.getStatus());
        // Inserting Row
        db.insert(TABLE_POWERANDBATTERBACKUP, null, values);
        Log.v(TAG, "Databaser insert Power and BatteryBackup table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<PowerandBatterybackup> getLastPowerandBatteryBackupData() {
        ArrayList<PowerandBatterybackup> list = new ArrayList<PowerandBatterybackup>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";
        String selectQuery = "SELECT  * FROM " + TABLE_POWERANDBATTERBACKUP + " ORDER BY " + id + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        PowerandBatterybackup data = new PowerandBatterybackup();
                        data.setId(cursor.getInt(0));
                        data.setEdt_ques1(cursor.getString(1));
                        data.setEdt_ques2(cursor.getString(2));
                        data.setEdt_ques3(cursor.getString(3));
                        data.setEdt_ques4(cursor.getString(4));
                        data.setEdt_ques5(cursor.getString(5));
                        data.setEdt_ques6(cursor.getString(6));
                        data.setEdt_ques7(cursor.getString(7));
                        data.setEdt_ques8(cursor.getString(8));
                        data.setEdt_ques9(cursor.getString(9));
                        data.setEdt_ques10(cursor.getString(10));
                        data.setEdt_ques11(cursor.getString(11));
                        data.setEdt_ques12(cursor.getString(12));
                        data.setEdt_ques13(cursor.getString(13));
                        data.setEdt_ques14(cursor.getString(14));
                        data.setEdt_ques15(cursor.getString(15));
                        data.setEdt_ques16(cursor.getString(16));
                        data.setEdt_ques17(cursor.getString(17));
                        data.setEdt_ques18(cursor.getString(18));
                        data.setEdt_ques19(cursor.getString(19));
                        data.setEdt_ques20(cursor.getString(20));
                        data.setEdt_ques21(cursor.getString(21));
                        data.setEdt_ques22(cursor.getString(22));
                        data.setEdt_ques23(cursor.getString(23));
                        data.setEdt_ques24(cursor.getString(24));
                        data.setEdt_ques25(cursor.getString(25));
                        data.setEdt_ques26(cursor.getString(26));
                        data.setEdt_ques27(cursor.getString(27));
                        data.setEdt_ques28(cursor.getString(28));
                        data.setEdt_ques29(cursor.getString(29));
                        data.setEdt_ques30(cursor.getString(30));
                        data.setRadioQues1(cursor.getString(31));
                        data.setRadioQues2(cursor.getString(32));
                        data.setRadioQues3(cursor.getString(33));
                        data.setRadioQues4(cursor.getString(34));
                        data.setRadioQues5(cursor.getString(35));
                        data.setRadioQues6(cursor.getString(36));
                        data.setRadioQues7(cursor.getString(37));
                        data.setRadioQues8(cursor.getString(38));
                        data.setRadioQues9(cursor.getString(39));
                        data.setRadioQues10(cursor.getString(40));
                        data.setRadioQues11(cursor.getString(41));
                        data.setRadioQues12(cursor.getString(42));
                        data.setRadioQues13(cursor.getString(43));
                        data.setRadioQues14(cursor.getString(44));
                        data.setRadioQues15(cursor.getString(45));
                        data.setRadioQues16(cursor.getString(46));
                        data.setRadioQues17(cursor.getString(47));
                        data.setRadioQues18(cursor.getString(48));
                        data.setRadioQues19(cursor.getString(49));
                        data.setRadioQues20(cursor.getString(50));
                        data.setRadioQues21(cursor.getString(51));
                        data.setRadioQues22(cursor.getString(52));
                        data.setRadioQues23(cursor.getString(53));
                        data.setRadioQues24(cursor.getString(54));
                        data.setRadioQues25(cursor.getString(55));
                        data.setRadioQues26(cursor.getString(56));
                        data.setRadioQues27(cursor.getString(57));
                        data.setRadioQues28(cursor.getString(58));
                        data.setRadioQues29(cursor.getString(59));
                        data.setRadioQues30(cursor.getString(60));

                        data.setStatus(cursor.getInt(61));

                        // Adding contact to list
                        list.add(data);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    public int getLastInsertIdTABLE_PowerandbatterbackupData() {
        int index = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + TABLE_POWERANDBATTERBACKUP, null);
        if (cursor.moveToLast()) {
            index = cursor.getInt(0);//to get id, 0 is the column index
        }
        cursor.close();
        return index;
    }

    // Getting AddBusData Count
    public int getCountPowerandBatteryBackupData() {
        String countQuery = "SELECT  * FROM " + TABLE_POWERANDBATTERBACKUP;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }
    public void deleteSomeRow_PowerandBatteryBackup() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_POWERANDBATTERBACKUP + " ;");
        db.close();
    }
    // code to add the new Grounding Data Table
    public void insertGroundingData(GroundingData mth) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(edt_ques1, mth.getEdtques1());
        values.put(edt_ques2, mth.getEdtques2());
        values.put(edt_ques3, mth.getEdtques3());
        values.put(radioQues1, mth.getRadioQues1());
        values.put(radioQues2, mth.getRadioQues2());
        values.put(radioQues3, mth.getRadioQues3());

        values.put(status, mth.getStatus());
        // Inserting Row
        db.insert(TABLE_GROUNDING, null, values);
        Log.v(TAG, "Databaser insert Grounding table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<GroundingData> getLastGroundingData() {
        ArrayList<GroundingData> list = new ArrayList<GroundingData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";
        String selectQuery = "SELECT  * FROM " + TABLE_GROUNDING + " ORDER BY " + id + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        GroundingData data = new GroundingData();
                        data.setId(cursor.getInt(0));
                        data.setEdtques1(cursor.getString(1));
                        data.setEdtques2(cursor.getString(2));
                        data.setEdtques3(cursor.getString(3));
                        data.setRadioQues1(cursor.getString(4));
                        data.setRadioQues2(cursor.getString(5));
                        data.setRadioQues3(cursor.getString(6));

                        data.setStatus(cursor.getInt(7));

                        // Adding contact to list
                        list.add(data);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    public int getLastInsertIdTABLE_GroundingData() {
        int index = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + TABLE_GROUNDING, null);
        if (cursor.moveToLast()) {
            index = cursor.getInt(0);//to get id, 0 is the column index
        }
        cursor.close();
        return index;
    }
    public void deleteSomeRow_Grounding() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_GROUNDING + " ;");
        db.close();
    }

    // Getting AddBusData Count
    public int getCountGroundingData() {
        String countQuery = "SELECT  * FROM " + TABLE_GROUNDING;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    // code to add the Transmission Data Table
    public void insertTransmissionData(TransmissionData mth) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(edt_ques1, mth.getEdt_ques1());
        values.put(edt_ques2, mth.getEdt_ques2());
        values.put(edt_ques3, mth.getEdt_ques3());
        values.put(edt_ques4, mth.getEdt_ques4());
        values.put(edt_ques5, mth.getEdt_ques5());
        values.put(edt_ques6, mth.getEdt_ques6());
        values.put(edt_ques7, mth.getEdt_ques7());
        values.put(edt_ques8, mth.getEdt_ques8());
        values.put(edt_ques9, mth.getEdt_ques9());
        values.put(edt_ques10, mth.getEdt_ques10());
        values.put(edt_ques11, mth.getEdt_ques11());
        values.put(edt_ques12, mth.getEdt_ques12());
        values.put(edt_ques13, mth.getEdt_ques13());
        values.put(edt_ques14, mth.getEdt_ques14());
        values.put(edt_ques15, mth.getEdt_ques15());
        values.put(edt_ques16, mth.getEdt_ques16());
        values.put(edt_ques17, mth.getEdt_ques17());
        values.put(edt_ques18, mth.getEdt_ques18());
        values.put(edt_ques19, mth.getEdt_ques19());
        values.put(edt_ques20, mth.getEdt_ques20());
        values.put(edt_ques21, mth.getEdt_ques21());
        values.put(edt_ques22, mth.getEdt_ques22());

        values.put(radioQues1, mth.getRadioQues1());
        values.put(radioQues2, mth.getRadioQues2());
        values.put(radioQues3, mth.getRadioQues3());
        values.put(radioQues4, mth.getRadioQues4());
        values.put(radioQues5, mth.getRadioQues5());
        values.put(radioQues6, mth.getRadioQues6());
        values.put(radioQues7, mth.getRadioQues7());
        values.put(radioQues8, mth.getRadioQues8());
        values.put(radioQues9, mth.getRadioQues9());
        values.put(radioQues10, mth.getRadioQues10());
        values.put(radioQues11, mth.getRadioQues11());
        values.put(radioQues12, mth.getRadioQues12());
        values.put(radioQues13, mth.getRadioQues13());
        values.put(radioQues14, mth.getRadioQues14());
        values.put(radioQues15, mth.getRadioQues15());
        values.put(radioQues16, mth.getRadioQues16());
        values.put(radioQues17, mth.getRadioQues17());
        values.put(radioQues18, mth.getRadioQues18());
        values.put(radioQues19, mth.getRadioQues19());
        values.put(radioQues20, mth.getRadioQues20());
        values.put(radioQues21, mth.getRadioQues21());
        values.put(radioQues22, mth.getRadioQues22());

        values.put(status, mth.getStatus());
        // Inserting Row
        db.insert(TABLE_TRASMISSION, null, values);
        Log.v(TAG, "Databaser insert Transmission table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<TransmissionData> getLastTransmissionData() {
        ArrayList<TransmissionData> list = new ArrayList<TransmissionData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";
        String selectQuery = "SELECT  * FROM " + TABLE_TRASMISSION + " ORDER BY " + id + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        TransmissionData data = new TransmissionData();
                        data.setId(cursor.getInt(0));
                        data.setEdt_ques1(cursor.getString(1));
                        data.setEdt_ques2(cursor.getString(2));
                        data.setEdt_ques3(cursor.getString(3));
                        data.setEdt_ques4(cursor.getString(4));
                        data.setEdt_ques5(cursor.getString(5));
                        data.setEdt_ques6(cursor.getString(6));
                        data.setEdt_ques7(cursor.getString(7));
                        data.setEdt_ques8(cursor.getString(8));
                        data.setEdt_ques9(cursor.getString(9));
                        data.setEdt_ques10(cursor.getString(10));
                        data.setEdt_ques11(cursor.getString(11));
                        data.setEdt_ques12(cursor.getString(12));
                        data.setEdt_ques13(cursor.getString(13));
                        data.setEdt_ques14(cursor.getString(14));
                        data.setEdt_ques15(cursor.getString(15));
                        data.setEdt_ques16(cursor.getString(16));
                        data.setEdt_ques17(cursor.getString(17));
                        data.setEdt_ques18(cursor.getString(18));
                        data.setEdt_ques19(cursor.getString(19));
                        data.setEdt_ques20(cursor.getString(20));
                        data.setEdt_ques21(cursor.getString(21));
                        data.setEdt_ques22(cursor.getString(22));

                        data.setRadioQues1(cursor.getString(23));
                        data.setRadioQues2(cursor.getString(24));
                        data.setRadioQues3(cursor.getString(25));
                        data.setRadioQues4(cursor.getString(26));
                        data.setRadioQues5(cursor.getString(27));
                        data.setRadioQues6(cursor.getString(28));
                        data.setRadioQues7(cursor.getString(29));
                        data.setRadioQues8(cursor.getString(30));
                        data.setRadioQues9(cursor.getString(31));
                        data.setRadioQues10(cursor.getString(32));
                        data.setRadioQues11(cursor.getString(33));
                        data.setRadioQues12(cursor.getString(34));
                        data.setRadioQues13(cursor.getString(35));
                        data.setRadioQues14(cursor.getString(36));
                        data.setRadioQues15(cursor.getString(37));
                        data.setRadioQues16(cursor.getString(38));
                        data.setRadioQues17(cursor.getString(39));
                        data.setRadioQues18(cursor.getString(40));
                        data.setRadioQues19(cursor.getString(41));
                        data.setRadioQues20(cursor.getString(42));
                        data.setRadioQues21(cursor.getString(43));
                        data.setRadioQues22(cursor.getString(44));

                        data.setStatus(cursor.getInt(45));

                        // Adding contact to list
                        list.add(data);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    public int getLastInsertIdTABLE_TransmissionData() {
        int index = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + TABLE_TRASMISSION, null);
        if (cursor.moveToLast()) {
            index = cursor.getInt(0);//to get id, 0 is the column index
        }
        cursor.close();
        return index;
    }


    // Getting AddBusData Count
    public int getCountTransmissionData() {
        String countQuery = "SELECT  * FROM " + TABLE_TRASMISSION;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }
    public void deleteSomeRow_Transmission() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_TRASMISSION + " ;");
        db.close();
    }

    // code to add the new CableInlets Data Table
    public void insertCableInletsData(CableInletsData mth) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(edt_ques1, mth.getEdt_ques1());
        values.put(edt_ques2, mth.getEdt_ques2());
        values.put(edt_ques3, mth.getEdt_ques3());
        values.put(edt_ques4, mth.getEdt_ques4());
        values.put(edt_ques5, mth.getEdt_ques5());
        values.put(edt_ques6, mth.getEdt_ques6());
        values.put(edt_ques7, mth.getEdt_ques7());
        values.put(radioQues1, mth.getRadioQues1());
        values.put(radioQues2, mth.getRadioQues2());
        values.put(radioQues3, mth.getRadioQues3());
        values.put(radioQues4, mth.getRadioQues4());
        values.put(radioQues5, mth.getRadioQues5());
        values.put(radioQues6, mth.getRadioQues6());
        values.put(radioQues7, mth.getRadioQues7());

        values.put(status, mth.getStatus());
        // Inserting Row
        db.insert(TABLE_CABLEINLETS, null, values);
        Log.v(TAG, "Databaser insert CableInlets table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<CableInletsData> getLastCableInletsData() {
        ArrayList<CableInletsData> list = new ArrayList<CableInletsData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";
        String selectQuery = "SELECT  * FROM " + TABLE_CABLEINLETS + " ORDER BY " + id + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        CableInletsData data = new CableInletsData();
                        data.setId(cursor.getInt(0));
                        data.setEdt_ques1(cursor.getString(1));
                        data.setEdt_ques2(cursor.getString(2));
                        data.setEdt_ques3(cursor.getString(3));
                        data.setEdt_ques4(cursor.getString(4));
                        data.setEdt_ques5(cursor.getString(5));
                        data.setEdt_ques6(cursor.getString(6));
                        data.setEdt_ques7(cursor.getString(7));
                        data.setRadioQues1(cursor.getString(8));
                        data.setRadioQues2(cursor.getString(9));
                        data.setRadioQues3(cursor.getString(10));
                        data.setRadioQues4(cursor.getString(11));
                        data.setRadioQues5(cursor.getString(12));
                        data.setRadioQues6(cursor.getString(13));
                        data.setRadioQues7(cursor.getString(14));

                        data.setStatus(cursor.getInt(15));

                        // Adding contact to list
                        list.add(data);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    public int getLastInsertIdTABLE_CableInletsData() {
        int index = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + TABLE_CABLEINLETS, null);
        if (cursor.moveToLast()) {
            index = cursor.getInt(0);//to get id, 0 is the column index
        }
        cursor.close();
        return index;
    }

    // Getting AddBusData Count
    public int getCountCableInletsData() {
        String countQuery = "SELECT  * FROM " + TABLE_CABLEINLETS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }
    public void deleteSomeRow_CableInlets() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_CABLEINLETS + " ;");
        db.close();
    }

    // code to add the new AntennaPlacementInvestigation Data Table
    public void insertAntennaPlacementInvestigationData(AntennaPlacementInvestigationData mth) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(edt_ques1, mth.getEdt_ques1());
        values.put(edt_ques2, mth.getEdt_ques2());
        values.put(edt_ques3, mth.getEdt_ques3());
        values.put(edt_ques4, mth.getEdt_ques4());
        values.put(edt_ques5, mth.getEdt_ques5());
        values.put(edt_ques6, mth.getEdt_ques6());
        values.put(edt_ques7, mth.getEdt_ques7());
        values.put(edt_ques8, mth.getEdt_ques8());
        values.put(edt_ques9, mth.getEdt_ques9());
        values.put(edt_ques10, mth.getEdt_ques10());
        values.put(edt_ques11, mth.getEdt_ques11());
        values.put(edt_ques12, mth.getEdt_ques12());
        values.put(edt_ques13, mth.getEdt_ques13());
        values.put(edt_ques14, mth.getEdt_ques14());
        values.put(edt_ques15, mth.getEdt_ques15());
        values.put(radioQues1, mth.getRadioQues1());
        values.put(radioQues2, mth.getRadioQues2());
        values.put(radioQues3, mth.getRadioQues3());
        values.put(radioQues4, mth.getRadioQues4());
        values.put(radioQues5, mth.getRadioQues5());
        values.put(radioQues6, mth.getRadioQues6());
        values.put(radioQues7, mth.getRadioQues7());
        values.put(radioQues8, mth.getRadioQues8());
        values.put(radioQues9, mth.getRadioQues9());
        values.put(radioQues10, mth.getRadioQues10());
        values.put(radioQues11, mth.getRadioQues11());
        values.put(radioQues12, mth.getRadioQues12());
        values.put(radioQues13, mth.getRadioQues13());
        values.put(radioQues14, mth.getRadioQues14());
        values.put(radioQues15, mth.getRadioQues15());
        values.put(edt_sectorA_azimuth, mth.getEdt_sectorA_azimuth());
        values.put(edt_sectorA_height, mth.getEdt_sectorA_height());
        values.put(edt_sectorB_azimuth, mth.getEdt_sectorB_azimuth());
        values.put(edt_sectorB_height, mth.getEdt_sectorB_height());
        values.put(edt_sectorC_azimuth, mth.getEdt_sectorC_azimuth());
        values.put(edt_sectorC_height, mth.getEdt_sectorC_height());
        values.put(edt_sectorD_azimuth, mth.getEdt_sectorD_azimuth());
        values.put(edt_sectorD_height, mth.getEdt_sectorD_height());


        values.put(status, mth.getStatus());
        // Inserting Row
        db.insert(TABLE_ANTENNAPLACEMENTINVESTIGATION, null, values);
        Log.v(TAG, "Databaser insert AntennaPlacementInvestigation table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<AntennaPlacementInvestigationData> getLastAntennaPlacementInvestigationData() {
        ArrayList<AntennaPlacementInvestigationData> list = new ArrayList<AntennaPlacementInvestigationData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";
        String selectQuery = "SELECT  * FROM " + TABLE_ANTENNAPLACEMENTINVESTIGATION + " ORDER BY " + id + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        AntennaPlacementInvestigationData data = new AntennaPlacementInvestigationData();
                        data.setId(cursor.getInt(0));
                        data.setEdt_ques1(cursor.getString(1));
                        data.setEdt_ques2(cursor.getString(2));
                        data.setEdt_ques3(cursor.getString(3));
                        data.setEdt_ques4(cursor.getString(4));
                        data.setEdt_ques5(cursor.getString(5));
                        data.setEdt_ques6(cursor.getString(6));
                        data.setEdt_ques7(cursor.getString(7));
                        data.setEdt_ques8(cursor.getString(8));
                        data.setEdt_ques9(cursor.getString(9));
                        data.setEdt_ques10(cursor.getString(10));
                        data.setEdt_ques11(cursor.getString(11));
                        data.setEdt_ques12(cursor.getString(12));
                        data.setEdt_ques13(cursor.getString(13));
                        data.setEdt_ques14(cursor.getString(14));
                        data.setEdt_ques15(cursor.getString(15));
                        data.setRadioQues1(cursor.getString(16));
                        data.setRadioQues2(cursor.getString(17));
                        data.setRadioQues3(cursor.getString(18));
                        data.setRadioQues4(cursor.getString(19));
                        data.setRadioQues5(cursor.getString(20));
                        data.setRadioQues6(cursor.getString(21));
                        data.setRadioQues7(cursor.getString(22));
                        data.setRadioQues8(cursor.getString(23));
                        data.setRadioQues9(cursor.getString(24));
                        data.setRadioQues10(cursor.getString(25));
                        data.setRadioQues11(cursor.getString(26));
                        data.setRadioQues12(cursor.getString(27));
                        data.setRadioQues13(cursor.getString(28));
                        data.setRadioQues14(cursor.getString(29));
                        data.setRadioQues15(cursor.getString(30));
                        data.setEdt_sectorA_azimuth(cursor.getString(31));
                        data.setEdt_sectorA_height(cursor.getString(32));
                        data.setEdt_sectorB_azimuth(cursor.getString(33));
                        data.setEdt_sectorB_height(cursor.getString(34));
                        data.setEdt_sectorC_azimuth(cursor.getString(35));
                        data.setEdt_sectorC_height(cursor.getString(36));
                        data.setEdt_sectorD_azimuth(cursor.getString(37));
                        data.setEdt_sectorD_height(cursor.getString(38));

                        data.setStatus(cursor.getInt(31));

                        // Adding contact to list
                        list.add(data);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    public int getLastInsertIdTABLE_AntennaPlacementInvestigationData() {
        int index = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + TABLE_ANTENNAPLACEMENTINVESTIGATION, null);
        if (cursor.moveToLast()) {
            index = cursor.getInt(0);//to get id, 0 is the column index
        }
        cursor.close();
        return index;
    }


    // Getting AddBusData Count
    public int getCountAntennaPlacementInvestigationData() {
        String countQuery = "SELECT  * FROM " + TABLE_ANTENNAPLACEMENTINVESTIGATION;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }
    public void deleteSomeRow_AntennaPlacementInvestigation() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_ANTENNAPLACEMENTINVESTIGATION + " ;");
        db.close();
    }

    // code to add the new SitePhotos Data Table
    public void insertSitePhotoData(SitePhotosData mth) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(edt_Siteview, mth.getEdt_Siteview());
        values.put(edt_MicroWaveTRMlink, mth.getEdt_MicroWaveTRMlink());
        values.put(edt_ODEquipmentElevation2, mth.getEdt_ODEquipmentElevation2());
        values.put(edt_Transmission, mth.getEdt_Transmission());
        values.put(edt_AC_PowerDistributionUnitDB, mth.getEdt_AC_PowerDistributionUnitDB());
        values.put(edt_DC_PowerDistributionUnitType, mth.getEdt_DC_PowerDistributionUnitType());
        values.put(edt_DC_PowerDistributionUnitDB, mth.getEdt_DC_PowerDistributionUnitDB());
        values.put(edt_ExistingEquipment, mth.getEdt_ExistingEquipment());
        values.put(edt_ExistingEquipmentonTower, mth.getEdt_ExistingEquipmentonTower());
        values.put(edt_ExistingEquipmentTowerView, mth.getEdt_ExistingEquipmentTowerView());
        values.put(edt_FreeSpaceAvailable, mth.getEdt_FreeSpaceAvailable());
        values.put(edt_ProposedlocationforRRU, mth.getEdt_ProposedlocationforRRU());
        values.put(edt_ProposedG900RUSinstallatRBS6201, mth.getEdt_ProposedG900RUSinstallatRBS6201());
        values.put(edt_ProposedU900RUSinstallatRBS6201, mth.getEdt_ProposedU900RUSinstallatRBS6201());
        values.put(edt_ProposedlocationforRRUS, mth.getEdt_ProposedlocationforRRUS());
        values.put(edt_CableLadder, mth.getEdt_CableLadder());
        values.put(edt_ProposedaddCableLadder, mth.getEdt_ProposedaddCableLadder());
        values.put(edt_DistributionFrames, mth.getEdt_DistributionFrames());
        values.put(edt_Roxtec, mth.getEdt_Roxtec());
        values.put(edt_AdditionalPhotos, mth.getEdt_AdditionalPhotos());
        values.put(img_Siteview, mth.getImg_Siteview());
        values.put(img_MicroWaveTRMlink, mth.getImg_MicroWaveTRMlink());
        values.put(img_ODEquipmentElevation2, mth.getImg_ODEquipmentElevation2());
        values.put(img_Transmission, mth.getImg_Transmission());
        values.put(img_AC_PowerDistributionUnitDB, mth.getImg_AC_PowerDistributionUnitDB());
        values.put(img_DC_PowerDistributionUnitType, mth.getImg_DC_PowerDistributionUnitType());
        values.put(img_DC_PowerDistributionUnitDB, mth.getImg_DC_PowerDistributionUnitDB());
        values.put(img_ExistingEquipment, mth.getImg_ExistingEquipment());
        values.put(img_ExistingEquipmentonTower, mth.getImg_ExistingEquipmentonTower());
        values.put(img_ExistingEquipmentTowerView, mth.getImg_ExistingEquipmentTowerView());
        values.put(img_FreeSpaceAvailable, mth.getImg_FreeSpaceAvailable());
        values.put(img_ProposedlocationforRRU, mth.getImg_ProposedlocationforRRU());
        values.put(img_ProposedG900RUSinstallatRBS6201, mth.getImg_ProposedG900RUSinstallatRBS6201());
        values.put(img_ProposedU900RUSinstallatRBS6201, mth.getImg_ProposedU900RUSinstallatRBS6201());
        values.put(img_ProposedlocationforRRUS, mth.getImg_ProposedlocationforRRUS());
        values.put(img_CableLadder, mth.getImg_CableLadder());
        values.put(img_ProposedaddCableLadder, mth.getImg_ProposedaddCableLadder());
        values.put(img_DistributionFrames, mth.getImg_DistributionFrames());
        values.put(img_Roxtec, mth.getImg_Roxtec());
        values.put(img_AdditionalPhotos, mth.getImg_AdditionalPhotos());

        values.put(status, mth.getStatus());
        // Inserting Row
        db.insert(TABLE_SITEPHOTO, null, values);
        Log.v(TAG, "Databaser insert sitephotos table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<SitePhotosData> getLastSitephotosData() {
        ArrayList<SitePhotosData> list = new ArrayList<SitePhotosData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";
        String selectQuery = "SELECT  * FROM " + TABLE_SITEPHOTO + " ORDER BY " + id + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {

                        SitePhotosData data = new SitePhotosData();
                        data.setId(cursor.getInt(0));
                        data.setEdt_Siteview(cursor.getString(1));
                        data.setEdt_MicroWaveTRMlink(cursor.getString(2));
                        data.setEdt_ODEquipmentElevation2(cursor.getString(3));
                        data.setEdt_Transmission(cursor.getString(4));
                        data.setEdt_AC_PowerDistributionUnitDB(cursor.getString(5));
                        data.setEdt_DC_PowerDistributionUnitType(cursor.getString(6));
                        data.setEdt_DC_PowerDistributionUnitDB(cursor.getString(7));
                        data.setEdt_ExistingEquipment(cursor.getString(8));
                        data.setEdt_ExistingEquipmentonTower(cursor.getString(9));
                        data.setEdt_ExistingEquipmentTowerView(cursor.getString(10));
                        data.setEdt_FreeSpaceAvailable(cursor.getString(11));
                        data.setEdt_ProposedlocationforRRU(cursor.getString(12));
                        data.setEdt_ProposedG900RUSinstallatRBS6201(cursor.getString(13));
                        data.setEdt_ProposedU900RUSinstallatRBS6201(cursor.getString(14));
                        data.setEdt_ProposedlocationforRRUS(cursor.getString(15));
                        data.setEdt_CableLadder(cursor.getString(16));
                        data.setEdt_ProposedaddCableLadder(cursor.getString(17));
                        data.setEdt_DistributionFrames(cursor.getString(18));
                        data.setEdt_Roxtec(cursor.getString(19));
                        data.setEdt_AdditionalPhotos(cursor.getString(20));
                        data.setImg_Siteview(cursor.getString(21));
                        data.setImg_MicroWaveTRMlink(cursor.getString(22));
                        data.setImg_ODEquipmentElevation2(cursor.getString(23));
                        data.setImg_Transmission(cursor.getString(24));
                        data.setImg_AC_PowerDistributionUnitDB(cursor.getString(25));
                        data.setImg_DC_PowerDistributionUnitType(cursor.getString(26));
                        data.setImg_DC_PowerDistributionUnitDB(cursor.getString(27));
                        data.setImg_ExistingEquipment(cursor.getString(28));
                        data.setImg_ExistingEquipmentonTower(cursor.getString(29));
                        data.setImg_ExistingEquipmentTowerView(cursor.getString(30));
                        data.setImg_FreeSpaceAvailable(cursor.getString(31));
                        data.setImg_ProposedlocationforRRU(cursor.getString(32));
                        data.setImg_ProposedG900RUSinstallatRBS6201(cursor.getString(33));
                        data.setImg_ProposedU900RUSinstallatRBS6201(cursor.getString(34));
                        data.setImg_ProposedlocationforRRUS(cursor.getString(35));
                        data.setImg_CableLadder(cursor.getString(36));
                        data.setImg_ProposedaddCableLadder(cursor.getString(37));
                        data.setImg_DistributionFrames(cursor.getString(38));
                        data.setImg_Roxtec(cursor.getString(39));
                        data.setImg_AdditionalPhotos(cursor.getString(40));

                        data.setStatus(cursor.getInt(41));

                        // Adding contact to list
                        list.add(data);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    public int getLastInsertIdTABLE_SitePhotosData() {
        int index = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + TABLE_SITEPHOTO, null);
        if (cursor.moveToLast()) {
            index = cursor.getInt(0);//to get id, 0 is the column index
        }
        cursor.close();
        return index;
    }


    // Getting AddBusData Count
    public int getCountSitePhotosData() {
        String countQuery = "SELECT  * FROM " + TABLE_SITEPHOTO;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    public void deleteSomeRow_SitePhoto() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_SITEPHOTO + " ;");
        db.close();
    }

}