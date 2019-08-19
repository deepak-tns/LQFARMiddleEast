package com.india.lhq.lqfarmiddleeast.fragment;


import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.india.lhq.lqfarmiddleeast.Activity.CameraSurfaceViewActivity;
import com.india.lhq.lqfarmiddleeast.Database.AntennaPlacementInvestigationData;
import com.india.lhq.lqfarmiddleeast.Database.CableInletsData;
import com.india.lhq.lqfarmiddleeast.Database.DatabaseHandler;
import com.india.lhq.lqfarmiddleeast.Database.EquipmentInformationData;
import com.india.lhq.lqfarmiddleeast.Database.EquipmentRoomInvestigationData;
import com.india.lhq.lqfarmiddleeast.Database.GroundingData;
import com.india.lhq.lqfarmiddleeast.Database.LocalRegulationData;
import com.india.lhq.lqfarmiddleeast.Database.MaterialTransportHandlingData;
import com.india.lhq.lqfarmiddleeast.Database.PowerandBatterybackup;
import com.india.lhq.lqfarmiddleeast.Database.SiteAccessData;
import com.india.lhq.lqfarmiddleeast.Database.SiteIdentificationData;
import com.india.lhq.lqfarmiddleeast.Database.SiteInformationData;
import com.india.lhq.lqfarmiddleeast.Database.SitePhotosData;
import com.india.lhq.lqfarmiddleeast.Database.SpecificSummaryData;
import com.india.lhq.lqfarmiddleeast.Database.TransmissionData;
import com.india.lhq.lqfarmiddleeast.R;
import com.india.lhq.lqfarmiddleeast.Utils.AppSingleton;
import com.india.lhq.lqfarmiddleeast.Utils.SharedPreferenceUtils;
import com.india.lhq.lqfarmiddleeast.constants.AppConstants;
import com.india.lhq.lqfarmiddleeast.constants.BitmapEncodedDecoded;
import com.india.lhq.lqfarmiddleeast.constants.GoogleGPSService;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static android.app.Activity.RESULT_CANCELED;
import static com.india.lhq.lqfarmiddleeast.constants.BitmapEncodedDecoded.encodeToBase64;

/*
 * A simple {@link Fragment} subclass.
 */
public class SitePhotoFragment extends Fragment implements View.OnClickListener {
    private EditText edt_Siteview;
    private EditText edt_MicroWaveTRMlink;
    private EditText edt_ODEquipmentElevation2;
    private EditText edt_Transmission;
    private EditText edt_AC_PowerDistributionUnitDB;
    private EditText edt_DC_PowerDistributionUnitType;
    private EditText edt_DC_PowerDistributionUnitDB;
    private EditText edt_ExistingEquipment;
    private EditText edt_ExistingEquipmentonTower;
    private EditText edt_ExistingEquipmentTowerView;
    private EditText edt_FreeSpaceAvailable;
    private EditText edt_ProposedlocationforRRU;
    private EditText edt_ProposedG900RUSinstallatRBS6201;
    private EditText edt_ProposedU900RUSinstallatRBS6201;
    private EditText edt_ProposedlocationforRRUS;
    private EditText edt_CableLadder;
    private EditText edt_ProposedaddCableLadder;
    private EditText edt_DistributionFrames;
    private EditText edt_Roxtec;
    private EditText edt_AdditionalPhotos;

    private ImageView iv_Siteview;
    private ImageView iv_MicroWaveTRMlink;
    private ImageView iv_ODEquipmentElevation2;
    private ImageView iv_Transmission;
    private ImageView iv_AC_PowerDistributionUnitDB;
    private ImageView iv_DC_PowerDistributionUnitType;
    private ImageView iv_DC_PowerDistributionUnitDB;
    private ImageView iv_ExistingEquipment;
    private ImageView iv_ExistingEquipmentonTower;
    private ImageView iv_ExistingEquipmentTowerView;
    private ImageView iv_FreeSpaceAvailable;
    private ImageView iv_ProposedlocationforRRU;
    private ImageView iv_ProposedG900RUSinstallatRBS6201;
    private ImageView iv_ProposedU900RUSinstallatRBS6201;
    private ImageView iv_ProposedlocationforRRUS;
    private ImageView iv_CableLadder;
    private ImageView iv_ProposedaddCableLadder;
    private ImageView iv_DistributionFrames;
    private ImageView iv_Roxtec;
    private ImageView iv_AdditionalPhotos;

    private ImageButton ib_Siteview;
    private ImageButton ib_MicroWaveTRMlink;
    private ImageButton ib_ODEquipmentElevation2;
    private ImageButton ib_Transmission;
    private ImageButton ib_AC_PowerDistributionUnitDB;
    private ImageButton ib_DC_PowerDistributionUnitType;
    private ImageButton ib_DC_PowerDistributionUnitDB;
    private ImageButton ib_ExistingEquipment;
    private ImageButton ib_ExistingEquipmentonTower;
    private ImageButton ib_ExistingEquipmentTowerView;
    private ImageButton ib_FreeSpaceAvailable;
    private ImageButton ib_ProposedlocationforRRU;
    private ImageButton ib_ProposedG900RUSinstallatRBS6201;
    private ImageButton ib_ProposedU900RUSinstallatRBS6201;
    private ImageButton ib_ProposedlocationforRRUS;
    private ImageButton ib_CableLadder;
    private ImageButton ib_ProposedaddCableLadder;
    private ImageButton ib_DistributionFrames;
    private ImageButton ib_Roxtec;
    private ImageButton ib_AdditionalPhotos;

    private String img_Siteview = "";
    private String img_MicroWaveTRMlink = "";
    private String img_ODEquipmentElevation2 = "";
    private String img_Transmission = "";
    private String img_AC_PowerDistributionUnitDB = "";
    private String img_DC_PowerDistributionUnitType = "";
    private String img_DC_PowerDistributionUnitDB = "";
    private String img_ExistingEquipment = "";
    private String img_ExistingEquipmentonTower = "";
    private String img_ExistingEquipmentTowerView = "";
    private String img_FreeSpaceAvailable = "";
    private String img_ProposedlocationforRRU = "";
    private String img_ProposedG900RUSinstallatRBS6201 = "";
    private String img_ProposedU900RUSinstallatRBS6201 = "";
    private String img_ProposedlocationforRRUS = "";
    private String img_CableLadder = "";
    private String img_ProposedaddCableLadder = "";
    private String img_DistributionFrames = "";
    private String img_Roxtec = "";
    private String img_AdditionalPhotos = "";
    private TextView tv_count_previous, tv_count_after ,tv_show_status;
    private Button btn_save,btn_upload;
    private DatabaseHandler db;
    private SharedPreferenceUtils sharedPreferences;
    List<SiteIdentificationData> siteIdentificationData;
    private String lat = "none", log="20", time;

    public SitePhotoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_site_photo, container, false);
        db = new DatabaseHandler(getActivity());
        findIds(v);
        sharedPreferences = SharedPreferenceUtils.getInstance();
        sharedPreferences.setContext(getActivity());

      tv_count_previous.setText(tv_count_previous.getText().toString() + db.getCountSitePhotosData() + "");
      //  db.deleteSomeRow_SitePhoto();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time = DateFormat.format("dd-MM-yyyy h:mm:ss:aa", System.currentTimeMillis()).toString();
                handler.postDelayed(this, 1000);
            }

        }, 1000);

        if (db.getCountSitePhotosData() > 2) {
            db.deleteSomeRow_SitePhoto();
        }

        siteIdentificationData = db.getLastSiteIdentification();

        return v;
    }

    private void findIds(View v) {
        tv_count_previous = v.findViewById(R.id.tv_count_previous);
        tv_count_after = v.findViewById(R.id.tv_count_after);
        tv_show_status =v.findViewById(R.id.tv_show_status);

        edt_Siteview = v.findViewById(R.id.edt_siteview);
        edt_MicroWaveTRMlink = v.findViewById(R.id.edt_MicroWaveTRMlink);
        edt_ODEquipmentElevation2 = v.findViewById(R.id.edt_ODEquipmentElevation2);
        edt_Transmission = v.findViewById(R.id.edt_Transmission);
        edt_AC_PowerDistributionUnitDB = v.findViewById(R.id.edt_AC_PowerDistributionUnitDB);
        edt_DC_PowerDistributionUnitType = v.findViewById(R.id.edt_DC_PowerDistributionUnitType);
        edt_DC_PowerDistributionUnitDB = v.findViewById(R.id.edt_DC_PowerDistributionUnitDB);
        edt_ExistingEquipment = v.findViewById(R.id.edt_ExistingEquipment);
        edt_ExistingEquipmentonTower = v.findViewById(R.id.edt_ExistingEquipmentonTower);
        edt_ExistingEquipmentTowerView = v.findViewById(R.id.edt_ExistingEquipmentTowerView);
        edt_FreeSpaceAvailable = v.findViewById(R.id.edt_FreeSpaceAvailable);
        edt_ProposedlocationforRRU = v.findViewById(R.id.edt_ProposedlocationforRRU);
        edt_ProposedG900RUSinstallatRBS6201 = v.findViewById(R.id.edt_ProposedG900RUSinstallatRBS6201);
        edt_ProposedU900RUSinstallatRBS6201 = v.findViewById(R.id.edt_ProposedU900RUSinstallatRBS6201);
        edt_ProposedlocationforRRUS = v.findViewById(R.id.edt_ProposedlocationforRRUS);
        edt_CableLadder = v.findViewById(R.id.edt_CableLadder);
        edt_ProposedaddCableLadder = v.findViewById(R.id.edt_ProposedaddCableLadder);
        edt_DistributionFrames = v.findViewById(R.id.edt_DistributionFrames);
        edt_Roxtec = v.findViewById(R.id.edt_Roxtec);
        edt_AdditionalPhotos = v.findViewById(R.id.edt_AdditionalPhotos);

        iv_Siteview = v.findViewById(R.id.iv_siteview);
        iv_MicroWaveTRMlink = v.findViewById(R.id.iv_MicroWaveTRMlink);
        iv_ODEquipmentElevation2 = v.findViewById(R.id.iv_ODEquipmentElevation2);
        iv_Transmission = v.findViewById(R.id.iv_Transmission);
        iv_AC_PowerDistributionUnitDB = v.findViewById(R.id.iv_AC_PowerDistributionUnitDB);
        iv_DC_PowerDistributionUnitType = v.findViewById(R.id.iv_DC_PowerDistributionUnitType);
        iv_DC_PowerDistributionUnitDB = v.findViewById(R.id.iv_DC_PowerDistributionUnitDB);
        iv_ExistingEquipment = v.findViewById(R.id.iv_ExistingEquipment);
        iv_ExistingEquipmentonTower = v.findViewById(R.id.iv_ExistingEquipmentonTower);
        iv_ExistingEquipmentTowerView = v.findViewById(R.id.iv_ExistingEquipmentTowerView);
        iv_FreeSpaceAvailable = v.findViewById(R.id.iv_FreeSpaceAvailable);
        iv_ProposedlocationforRRU = v.findViewById(R.id.iv_ProposedlocationforRRU);
        iv_ProposedG900RUSinstallatRBS6201 = v.findViewById(R.id.iv_ProposedG900RUSinstallatRBS6201);
        iv_ProposedU900RUSinstallatRBS6201 = v.findViewById(R.id.iv_ProposedU900RUSinstallatRBS6201);
        iv_ProposedlocationforRRUS = v.findViewById(R.id.iv_ProposedlocationforRRUS);
        iv_CableLadder = v.findViewById(R.id.iv_CableLadder);
        iv_ProposedaddCableLadder = v.findViewById(R.id.iv_ProposedaddCableLadder);
        iv_DistributionFrames = v.findViewById(R.id.iv_DistributionFrames);
        iv_Roxtec = v.findViewById(R.id.iv_Roxtec);
        iv_AdditionalPhotos = v.findViewById(R.id.iv_AdditionalPhotos);

        ib_Siteview = v.findViewById(R.id.ib_siteview);
        ib_MicroWaveTRMlink = v.findViewById(R.id.ib_MicroWaveTRMlink);
        ib_ODEquipmentElevation2 = v.findViewById(R.id.ib_ODEquipmentElevation2);
        ib_Transmission = v.findViewById(R.id.ib_Transmission);
        ib_AC_PowerDistributionUnitDB = v.findViewById(R.id.ib_AC_PowerDistributionUnitDB);
        ib_DC_PowerDistributionUnitType = v.findViewById(R.id.ib_DC_PowerDistributionUnitType);
        ib_DC_PowerDistributionUnitDB = v.findViewById(R.id.ib_DC_PowerDistributionUnitDB);
        ib_ExistingEquipment = v.findViewById(R.id.ib_ExistingEquipment);
        ib_ExistingEquipmentonTower = v.findViewById(R.id.ib_ExistingEquipmentonTower);
        ib_ExistingEquipmentTowerView = v.findViewById(R.id.ib_ExistingEquipmentTowerView);
        ib_FreeSpaceAvailable = v.findViewById(R.id.ib_FreeSpaceAvailable);
        ib_ProposedlocationforRRU = v.findViewById(R.id.ib_ProposedlocationforRRU);
        ib_ProposedG900RUSinstallatRBS6201 = v.findViewById(R.id.ib_ProposedG900RUSinstallatRBS6201);
        ib_ProposedU900RUSinstallatRBS6201 = v.findViewById(R.id.ib_ProposedU900RUSinstallatRBS6201);
        ib_ProposedlocationforRRUS = v.findViewById(R.id.ib_ProposedlocationforRRUS);
        ib_CableLadder = v.findViewById(R.id.ib_CableLadder);
        ib_ProposedaddCableLadder = v.findViewById(R.id.ib_ProposedaddCableLadder);
        ib_DistributionFrames = v.findViewById(R.id.ib_DistributionFrames);
        ib_Roxtec = v.findViewById(R.id.ib_Roxtec);
        ib_AdditionalPhotos = v.findViewById(R.id.ib_AdditionalPhotos);

        btn_save = v.findViewById(R.id.btn_save);
        btn_upload = v.findViewById(R.id.btn_upload);
        btn_save.setOnClickListener(this);
        btn_upload.setOnClickListener(this);

        ib_Siteview.setOnClickListener(this);
        ib_MicroWaveTRMlink.setOnClickListener(this);
        ib_ODEquipmentElevation2.setOnClickListener(this);
        ib_Transmission.setOnClickListener(this);
        ib_AC_PowerDistributionUnitDB.setOnClickListener(this);
        ib_DC_PowerDistributionUnitType.setOnClickListener(this);
        ib_DC_PowerDistributionUnitDB.setOnClickListener(this);
        ib_ExistingEquipment.setOnClickListener(this);
        ib_ExistingEquipmentonTower.setOnClickListener(this);
        ib_ExistingEquipmentTowerView.setOnClickListener(this);
        ib_FreeSpaceAvailable.setOnClickListener(this);
        ib_ProposedlocationforRRU.setOnClickListener(this);
        ib_ProposedG900RUSinstallatRBS6201.setOnClickListener(this);
        ib_ProposedU900RUSinstallatRBS6201.setOnClickListener(this);
        ib_ProposedlocationforRRUS.setOnClickListener(this);
        ib_CableLadder.setOnClickListener(this);
        ib_ProposedaddCableLadder.setOnClickListener(this);
        ib_DistributionFrames.setOnClickListener(this);
        ib_Roxtec.setOnClickListener(this);
        ib_AdditionalPhotos.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view == btn_save) {
            db.insertSitePhotoData(new SitePhotosData(edt_Siteview.getText().toString(), edt_MicroWaveTRMlink.getText().toString(), edt_ODEquipmentElevation2.getText().toString(), edt_Transmission.getText().toString(), edt_AC_PowerDistributionUnitDB.getText().toString(), edt_DC_PowerDistributionUnitType.getText().toString(), edt_DC_PowerDistributionUnitDB.getText().toString(), edt_ExistingEquipment.getText().toString(), edt_ExistingEquipmentonTower.getText().toString(), edt_ExistingEquipmentTowerView.getText().toString(), edt_FreeSpaceAvailable.getText().toString(), edt_ProposedlocationforRRU.getText().toString(), edt_ProposedG900RUSinstallatRBS6201.getText().toString(), edt_ProposedU900RUSinstallatRBS6201.getText().toString(), edt_ProposedlocationforRRUS.getText().toString(), edt_CableLadder.getText().toString(), edt_ProposedaddCableLadder.getText().toString(), edt_DistributionFrames.getText().toString(), edt_Roxtec.getText().toString(), edt_AdditionalPhotos.getText().toString(), img_Siteview, img_MicroWaveTRMlink, img_ODEquipmentElevation2, img_Transmission, img_AC_PowerDistributionUnitDB, img_DC_PowerDistributionUnitType, img_DC_PowerDistributionUnitDB, img_ExistingEquipment, img_ExistingEquipmentonTower, img_ExistingEquipmentTowerView, img_FreeSpaceAvailable, img_ProposedlocationforRRU, img_ProposedG900RUSinstallatRBS6201, img_ProposedU900RUSinstallatRBS6201, img_ProposedlocationforRRUS, img_CableLadder, img_ProposedaddCableLadder, img_DistributionFrames, img_Roxtec, img_AdditionalPhotos, 1));
            tv_count_after.setText(db.getCountSitePhotosData() + "");
            Toast.makeText(getActivity(), "All record has been Successfully", Toast.LENGTH_SHORT).show();
        //    saveTextFileGPSStatus(db.getAllSiteIdentificationData(), db.getLastSiteInformationData());
        }

        if (view == btn_upload) {

            toSendDataSiteIdentification();
            toSendDataSpecificeSummary();
            toSendDataSiteInformation();
            toSendDataLocalRegulation();
            toSendDataSiteAccess();
            toSendDataMTH();
            toSendDataequipmentInformationData();
            toSendDataEquipmentRoomInvestigation();
            toSendDataPowerandBattery();
            toSendDataGrounding();
            toSendDataTransmission();
            toSendDataCableInlets();
            toSendDataAntennaPlacementInvestigation();
            toSendDataSitePhoto();

        }

        if (view == ib_Siteview) {
            selectImage("1");
        }
        if (view == ib_MicroWaveTRMlink) {

            selectImage("2");
        }
        if (view == ib_ODEquipmentElevation2) {
            selectImage("3");
        }
        if (view == ib_Transmission) {
            selectImage("4");
        }
        if (view == ib_AC_PowerDistributionUnitDB) {

            selectImage("5");
        }
        if (view == ib_DC_PowerDistributionUnitType) {

            selectImage("6");
        }
        if (view == ib_DC_PowerDistributionUnitDB) {

            selectImage("7");
        }
        if (view == ib_ExistingEquipment) {

            selectImage("8");
        }
        if (view == ib_ExistingEquipmentonTower) {

            selectImage("9");
        }
        if (view == ib_ExistingEquipmentTowerView) {

            selectImage("10");
        }
        if (view == ib_FreeSpaceAvailable) {

            selectImage("11");
        }
        if (view == ib_ProposedlocationforRRU) {

            selectImage("12");
        }
        if (view == ib_ProposedG900RUSinstallatRBS6201) {

            selectImage("13");
        }
        if (view == ib_ProposedU900RUSinstallatRBS6201) {

            selectImage("14");
        }
        if (view == ib_ProposedlocationforRRUS) {

            selectImage("15");
        }
        if (view == ib_CableLadder) {

            selectImage("16");
        }
        if (view == ib_ProposedaddCableLadder) {

            selectImage("17");
        }
        if (view == ib_DistributionFrames) {

            selectImage("18");
        }
        if (view == ib_Roxtec) {

            selectImage("19");
        }
        if (view == ib_AdditionalPhotos) {

            selectImage("20");
        }
    }

    private void selectImage(String Value) {

        if (Value.equals("1")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 1);
            startActivityForResult(i, 1);
        }
        if (Value.equals("2")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 2);
            startActivityForResult(i, 2);

        }
        if (Value.equals("3")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 3);
            startActivityForResult(i, 3);
        }
        if (Value.equals("4")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 4);
            startActivityForResult(i, 4);
        }
        if (Value.equals("5")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 5);
            startActivityForResult(i, 5);
        }
        if (Value.equals("6")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 6);
            startActivityForResult(i, 6);
        }
        if (Value.equals("7")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 7);
            startActivityForResult(i, 7);
        }
        if (Value.equals("8")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 8);
            startActivityForResult(i, 8);
        }
        if (Value.equals("9")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 9);
            startActivityForResult(i, 9);
        }
        if (Value.equals("10")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 10);
            startActivityForResult(i, 10);
        }
        if (Value.equals("11")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 11);
            startActivityForResult(i, 11);
        }
        if (Value.equals("12")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 12);
            startActivityForResult(i, 12);
        }
        if (Value.equals("13")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 13);
            startActivityForResult(i, 13);
        }
        if (Value.equals("14")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 14);
            startActivityForResult(i, 14);
        }
        if (Value.equals("15")) {
            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 15);
            startActivityForResult(i, 15);
        }

        if (Value.equals("16")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 16);
            startActivityForResult(i, 16);
        }
        if (Value.equals("17")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 17);
            startActivityForResult(i, 17);
        }
        if (Value.equals("18")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 18);
            startActivityForResult(i, 18);
        }
        if (Value.equals("19")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 19);
            startActivityForResult(i, 19);
        }
        if (Value.equals("20")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 20);
            startActivityForResult(i, 20);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            //  Log.v("logtest", data.getStringExtra("path")+","+requestCode);
            if (requestCode == 1) {
                // onCaptureImageResult(data, "1");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "1", angle);
            }
            if (requestCode == 2) {
                // onCaptureImageResult(data, "2");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "2", angle);
            }
            if (requestCode == 3) {
                //  onCaptureImageResult(data, "3");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "3", angle);
            }
            if (requestCode == 4) {
                // onCaptureImageResult(data, "4");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "4", angle);
            }
            if (requestCode == 5) {
                //  onCaptureImageResult(data, "5");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "5", angle);
            }
            if (requestCode == 6) {
                //   onCaptureImageResult(data, "6");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "6", angle);
            }
            if (requestCode == 7) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "7", angle);
            }
            if (requestCode == 8) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "8", angle);
            }
            if (requestCode == 9) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "9", angle);
            }
            if (requestCode == 10) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "10", angle);
            }
            if (requestCode == 11) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "11", angle);
            }
            if (requestCode == 12) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "12", angle);
            }
            if (requestCode == 13) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "13", angle);
            }
            if (requestCode == 14) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "14", angle);
            }
            if (requestCode == 15) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "15", angle);
            }
            if (requestCode == 16) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "16", angle);
            }
            if (requestCode == 17) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "17", angle);
            }
            if (requestCode == 18) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "18", angle);
            }
            if (requestCode == 19) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "19", angle);
            }
            if (requestCode == 20) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "20", angle);
            }
        }
    }


    private void onCameraSurfaceViewActivity(String thumbnail, String name, String angle) {

        if (name.equals("1")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Siteview.setImageBitmap(out);
              //  img_Siteview = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Siteview = thumbnail;
                Log.v("img-encode", img_Siteview);
            }
        }
        if (name.equals("2")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_MicroWaveTRMlink.setImageBitmap(out);
              //  img_MicroWaveTRMlink = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_MicroWaveTRMlink = thumbnail;
                Log.v("img-encode", img_MicroWaveTRMlink);
            }
        }
        if (name.equals("3")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_ODEquipmentElevation2.setImageBitmap(out);
             //   img_ODEquipmentElevation2 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_ODEquipmentElevation2= thumbnail;
                Log.v("img-encode", img_ODEquipmentElevation2);
            }
        }
        if (name.equals("4")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Transmission.setImageBitmap(out);
             //   img_Transmission = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Transmission = thumbnail;
                Log.v("img-encode", img_Transmission);
            }
        }

        if (name.equals("5")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_AC_PowerDistributionUnitDB.setImageBitmap(out);
                //  img_AC_PowerDistributionUnitDB = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_AC_PowerDistributionUnitDB = thumbnail;
                Log.v("img-encode", img_AC_PowerDistributionUnitDB);
            }
        }


        if (name.equals("6")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_DC_PowerDistributionUnitType.setImageBitmap(out);
             //   img_DC_PowerDistributionUnitType = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_DC_PowerDistributionUnitType = thumbnail;
                Log.v("img-encode", img_DC_PowerDistributionUnitType);
            }
        }
        if (name.equals("7")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_DC_PowerDistributionUnitDB.setImageBitmap(out);
              //  img_DC_PowerDistributionUnitDB = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_DC_PowerDistributionUnitDB = thumbnail;
                Log.v("img-encode", img_DC_PowerDistributionUnitDB);
            }
        }
        if (name.equals("8")){

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_ExistingEquipment.setImageBitmap(out);
         //       img_ExistingEquipment = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_ExistingEquipment = thumbnail;
                Log.v("img-encode", img_ExistingEquipment);
            }
    }
            if (name.equals("9")) {

                if (lat == null) {
                    Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
                } else {

                    Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                    iv_ExistingEquipmentonTower.setImageBitmap(out);
              //      img_ExistingEquipmentonTower = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                    img_ExistingEquipmentonTower = thumbnail;
                    Log.v("img-encode", img_ExistingEquipmentonTower);
                }
            }
            if (name.equals("10")) {

                if (lat == null) {
                    Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
                } else {

                    Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                    iv_ExistingEquipmentTowerView.setImageBitmap(out);
               //     img_ExistingEquipmentTowerView = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                    img_ExistingEquipmentTowerView = thumbnail;
                    Log.v("img-encode", img_ExistingEquipmentTowerView);
                }
            }
            if (name.equals("11")) {

                if (lat == null) {
                    Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
                } else {

                    Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                    iv_FreeSpaceAvailable.setImageBitmap(out);
             //       img_FreeSpaceAvailable = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                    img_FreeSpaceAvailable = thumbnail;
                    Log.v("img-encode", img_FreeSpaceAvailable);
                }
            }
            if (name.equals("12")) {

                if (lat == null) {
                    Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
                } else {

                    Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                    iv_ProposedlocationforRRU.setImageBitmap(out);
               //     img_ProposedlocationforRRU = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                    img_ProposedlocationforRRU = thumbnail;
                    Log.v("img-encode", img_ProposedlocationforRRU);
                }
            }

            if (name.equals("13")) {

                if (lat == null) {
                    Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
                } else {

                    Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                    iv_ProposedG900RUSinstallatRBS6201.setImageBitmap(out);
                //    img_ProposedG900RUSinstallatRBS6201 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                    img_ProposedG900RUSinstallatRBS6201 = thumbnail;
                    Log.v("img-encode", img_ProposedG900RUSinstallatRBS6201);
                }
            }
            if (name.equals("14")) {

                if (lat == null) {
                    Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
                } else {

                    Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                    iv_ProposedU900RUSinstallatRBS6201.setImageBitmap(out);
             //       img_ProposedU900RUSinstallatRBS6201 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                    img_ProposedU900RUSinstallatRBS6201 = thumbnail;
                    Log.v("img-encode", img_ProposedU900RUSinstallatRBS6201);
                }
            }
            if (name.equals("15")) {

                if (lat == null) {
                    Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
                } else {

                    Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                    iv_ProposedlocationforRRUS.setImageBitmap(out);
                //    img_ProposedlocationforRRUS = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                    img_ProposedlocationforRRUS = thumbnail;
                    Log.v("img-encode", img_ProposedlocationforRRUS);
                }
            }
            if (name.equals("16")) {

                if (lat == null) {
                    Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
                } else {

                    Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                    iv_CableLadder.setImageBitmap(out);
               //     img_CableLadder = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                    img_CableLadder = thumbnail;
                    Log.v("img-encode", img_CableLadder);
                }
            }
            if (name.equals("17")) {

                if (lat == null) {
                    Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
                } else {

                    Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                    iv_ProposedaddCableLadder.setImageBitmap(out);
              //      img_ProposedaddCableLadder = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                    img_ProposedaddCableLadder = thumbnail;
                    Log.v("img-encode", img_ProposedaddCableLadder);
                }
            }

            if (name.equals("18")) {

                if (lat == null) {
                    Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
                } else {

                    Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                    iv_DistributionFrames.setImageBitmap(out);
                 //   img_DistributionFrames = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                    img_DistributionFrames = thumbnail;
                    Log.v("img-encode", img_DistributionFrames);
                }
            }
            if (name.equals("19")) {

                if (lat == null) {
                    Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
                } else {

                    Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                    iv_Roxtec.setImageBitmap(out);
             //       img_Roxtec = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                    img_Roxtec = thumbnail;
                    Log.v("img-encode", img_Roxtec);
                }
            }
            if (name.equals("20")) {

                if (lat == null) {
                    Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
                } else {

                    Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                    iv_AdditionalPhotos.setImageBitmap(out);
                    //img_AdditionalPhotos = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                    img_AdditionalPhotos = thumbnail;
                    Log.v("img-encode", img_AdditionalPhotos);
                }
            }
        }



    @Override
    public void onResume() {
        super.onResume();
        //  GPSTracker.BUS.register(this);
        getActivity().registerReceiver(broadcastReceiver, new IntentFilter(GoogleGPSService.BROADCAST_ACTION));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            getActivity().unregisterReceiver(broadcastReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // mContact = (Contact)getIntent().getExtras().getSerializable(EXTRA_CONTACT);
            lat = intent.getStringExtra("LAT");
            log = intent.getStringExtra("LOG");

            //   Toast.makeText(getActivity(), "Lat : "+lat+","+ "Long : "+ log, Toast.LENGTH_LONG).show();
        }


    };

    private void saveTextFileGPSStatus(List<SiteIdentificationData> dataList, List<SiteInformationData> siteInformationData) {
        try {
            //  String projectno= latLongDataList.get(0).getFormno().replace("/","");
            // Log.v("projectno",projectno);
            String h = DateFormat.format("MM-dd-yyyy-h-mmssaa", System.currentTimeMillis()).toString();
            // this will create a new name everytime and unique
            File root = new File(Environment.getExternalStorageDirectory() + "/TextDatabase/");
            // if external memory exists and folder with name Notes
            if (!root.exists()) {
                root.mkdirs(); // this will create folder.
            }
            File filepath = new File(root, "SiteIdentification" + h + ".txt");  // file path to save
            FileWriter writer = new FileWriter(filepath);
            for (SiteIdentificationData data : dataList) {
                writer.append(data.getId() + "," + data.getEdt_location() + "," + data.getEdt_sitenumber() + "," + data.getEdt_lat() + "," + data.getEdt_long()
                        + "," + data.getEdt_sitename() + "," + data.getEdt_sitetype() + "," + data.getEdt_siteidentidate() + "," + data.getEdt_remark());
                writer.append("\n\r");
            }

            for (SiteInformationData data : siteInformationData) {
                writer.append(data.getId() + "," + data.getSiteID() + "," + data.getSiteName() + "," + data.getSiteType() + "," + data.getBuildingType()
                        + "," + data.getLAT() + "," + data.getLONG() + "," + data.getSiteAddress() + "," + data.getVendorsite() + "," + data.getSitevisitperformedby() + "," + data.getPhoneNo() + "," + data.getParticipantsatthesitevisit() + "," + data.getPhoneNoparticipantssitevist() + "," + data.getStatus());
                writer.append("\n\r");
            }
            writer.flush();
            writer.close();

            String path = filepath.getPath();
            String m = "File generated with name " + path;
            Toast.makeText(getActivity(), m, Toast.LENGTH_LONG).show();

          /*  Intent intent =new Intent(getActivity(),getActivity().class);
            intent.putExtra("attachmentpathdata",path);
            startActivity(intent);*/

        } catch (IOException e) {
            Toast.makeText(getActivity(), "error", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    //...........................site Identification.......................
    private JSONObject jsondataSiteIdentification() {
        JSONObject jsonObject = new JSONObject();

        if (siteIdentificationData.size() > 0) {
            Log.v("SiteIdentification", siteIdentificationData.toString());
            try {
                // jsonObject.put("siteid", siteDetailData.get(0).getSiteid());
                jsonObject.put("edt_location", siteIdentificationData.get(0).getEdt_location());
                //   jsonObject.put("edt_siteid", siteIdentificationData.get(0).getEdt_sitenumber());
                jsonObject.put("edt_lat", siteIdentificationData.get(0).getEdt_lat());
                jsonObject.put("edt_long", siteIdentificationData.get(0).getEdt_long());
                jsonObject.put("edt_sitename", siteIdentificationData.get(0).getEdt_sitename());
                jsonObject.put("edt_sitetype", siteIdentificationData.get(0).getEdt_sitetype());
                jsonObject.put("edt_siteidentidate", siteIdentificationData.get(0).getEdt_siteidentidate());
                jsonObject.put("edt_remark", siteIdentificationData.get(0).getEdt_remark());
                jsonObject.put("status", siteIdentificationData.get(0).getStatus());

                jsonObject.put("date", siteIdentificationData.get(0).getEdt_siteidentidate());
                jsonObject.put("siteid", siteIdentificationData.get(0).getEdt_sitenumber());
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.EMPID)+ siteIdentificationData.get(0).getEdt_sitenumber()+siteIdentificationData.get(0).getEdt_siteidentidate());

            } catch (Exception e) {

            }
        }
        Log.v("json site Identi", jsonObject.toString());
        return jsonObject;
    }

    private void toSendDataSiteIdentification() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.SITEIDENTIFICATION, jsondataSiteIdentification(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseSiteIdentification(response);
                        Log.v("res site Identi", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res error site Identi", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseSiteIdentification(JSONArray response) {
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            tv_show_status.append("Site Identification :" +status+"\n");
            Toast.makeText(getActivity(), status + " Site Identification", Toast.LENGTH_LONG).show();
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
            tv_show_status.append("Site Identification :" +e.getMessage()+"\n");
        }
    }
    //..........................END SiteIdentification.............................

    //...........................Specifice Summary.......................
    private JSONObject jsondataSpecificeSummary() {
        JSONObject jsonObject = new JSONObject();
        List<SpecificSummaryData> specificSummaryData = db.getLastSpecificSummaryData();
        if (specificSummaryData.size() > 0) {
            Log.v("Specifice Summary", specificSummaryData.toString());
            try {

                jsonObject.put("edt_ans1", specificSummaryData.get(0).getQues1());
                jsonObject.put("edt_ans2", specificSummaryData.get(0).getQues2());
                jsonObject.put("edt_ans3", specificSummaryData.get(0).getQues3());
                jsonObject.put("edt_ans4", specificSummaryData.get(0).getQues4());
                jsonObject.put("ans1", specificSummaryData.get(0).getAns1());
                jsonObject.put("ans2", specificSummaryData.get(0).getAns2());
                jsonObject.put("ans3", specificSummaryData.get(0).getAns3());
                jsonObject.put("ans4", specificSummaryData.get(0).getAns4());
                jsonObject.put("status", specificSummaryData.get(0).getStatus());

                jsonObject.put("date", siteIdentificationData.get(0).getEdt_siteidentidate());
                jsonObject.put("siteid", siteIdentificationData.get(0).getEdt_sitenumber());
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.EMPID)+ siteIdentificationData.get(0).getEdt_sitenumber()+siteIdentificationData.get(0).getEdt_siteidentidate());


            } catch (Exception e) {

            }
        }
        Log.v("json specificesummay", jsonObject.toString());
        return jsonObject;
    }

    private void toSendDataSpecificeSummary() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.SPECIFICSUMMARY, jsondataSpecificeSummary(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseSpecificeSummary(response);
                        Log.v("res SpecificeSummary", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res error SpecSummary", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseSpecificeSummary(JSONArray response) {
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");

              tv_show_status.append("Specifice Summary :" +status+"\n");
            Toast.makeText(getActivity(), status + " SpecificeSummary", Toast.LENGTH_LONG).show();
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
            tv_show_status.append("Specifice Summary :" +e.getMessage()+"\n");
        }
    }
//..........................END SpecificeSummary.............................

    //...........................Site Information.......................
    private JSONObject jsondataSiteInformation() {
        JSONObject jsonObject = new JSONObject();
        List<SiteInformationData> siteInformationData = db.getLastSiteInformationData();
        if (siteInformationData.size() > 0) {
            Log.v("Site Information", siteInformationData.toString());
            try {

                jsonObject.put("siteName", siteInformationData.get(0).getSiteName());
                jsonObject.put("siteType", siteInformationData.get(0).getSiteType());
                jsonObject.put("buildingType", siteInformationData.get(0).getBuildingType());
                jsonObject.put("LAT", siteInformationData.get(0).getLAT());
                jsonObject.put("LONG", siteInformationData.get(0).getLONG());
                jsonObject.put("SiteAddress", siteInformationData.get(0).getSiteAddress());
                jsonObject.put("vendorsite", siteInformationData.get(0).getVendorsite());
                jsonObject.put("Dateofsitevisit", siteInformationData.get(0).getDateofsitevisit());
                jsonObject.put("Sitevisitperformedby", siteInformationData.get(0).getSitevisitperformedby());
                jsonObject.put("PhoneNo", siteInformationData.get(0).getPhoneNo());
                jsonObject.put("Participantsatthesitevisit", siteInformationData.get(0).getParticipantsatthesitevisit());
                jsonObject.put("PhoneNoparticipantssitevist", siteInformationData.get(0).getPhoneNoparticipantssitevist());
                jsonObject.put("status", siteInformationData.get(0).getStatus());

                jsonObject.put("date", siteIdentificationData.get(0).getEdt_siteidentidate());
                jsonObject.put("siteid", siteIdentificationData.get(0).getEdt_sitenumber());
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.EMPID)+ siteIdentificationData.get(0).getEdt_sitenumber()+siteIdentificationData.get(0).getEdt_siteidentidate());


            } catch (Exception e) {

            }
        }
        Log.v("json site infor", jsonObject.toString());
        return jsonObject;
    }

    private void toSendDataSiteInformation() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.SITEINFORMATION, jsondataSiteInformation(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseSiteInformation(response);
                        Log.v("res SiteInformation", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res error SiteInfo", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseSiteInformation(JSONArray response) {
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");

              tv_show_status.append("Site Information :" +status+"\n");
            Toast.makeText(getActivity(), status + " SiteInformation", Toast.LENGTH_LONG).show();
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
            tv_show_status.append("Site Information :" +e.getMessage()+"\n");
        }
    }
//..........................END SiteInformation.............................

    // .......................... Local Regulation.............................
    private JSONObject jsondataLocalRegulation() {
        JSONObject jsonObject = new JSONObject();
        List<LocalRegulationData> localRegulationData = db.getLastLocalRegulationData();
        if (localRegulationData.size() > 0) {
            Log.v("Local Regulation", localRegulationData.toString());
            try {

                jsonObject.put("edt_ans1", localRegulationData.get(0).getQ1());
                jsonObject.put("edt_ans2", localRegulationData.get(0).getQ2());
                jsonObject.put("edt_ans3", localRegulationData.get(0).getQ3());
                jsonObject.put("ans1", localRegulationData.get(0).getA1());
                jsonObject.put("ans2", localRegulationData.get(0).getA2());
                jsonObject.put("NA", localRegulationData.get(0).getA3());
                jsonObject.put("status", localRegulationData.get(0).getStatus());

                jsonObject.put("date", siteIdentificationData.get(0).getEdt_siteidentidate());
                jsonObject.put("siteid", siteIdentificationData.get(0).getEdt_sitenumber());
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.EMPID)+ siteIdentificationData.get(0).getEdt_sitenumber()+siteIdentificationData.get(0).getEdt_siteidentidate());


            } catch (Exception e) {

            }
        }
        Log.v("json local regul", jsonObject.toString());
        return jsonObject;
    }

    private void toSendDataLocalRegulation() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.LOCALREGULATION, jsondataLocalRegulation(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseLocalRegulation(response);
                        Log.v("res LocalRegulation", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res err LocalRegulation", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseLocalRegulation(JSONArray response) {
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");

              tv_show_status.append("Local Regulation :" +status+"\n");
            Toast.makeText(getActivity(), status + " LocalRegulation", Toast.LENGTH_LONG).show();
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
            tv_show_status.append("Local Regulation :" +e.getMessage()+"\n");
        }
    }
//..........................END LocalRegulation.............................

    // .......................... SiteAccess.............................
    private JSONObject jsondataSiteAccess() {
        JSONObject jsonObject = new JSONObject();
        List<SiteAccessData> siteAccessData = db.getLastSiteAccess();
        if (siteAccessData.size() > 0) {
            Log.v("SiteAccess", siteAccessData.toString());
            try {

                jsonObject.put("edt_propertycontactrefrence", siteAccessData.get(0).getEdt_propertycontactrefrence());
                jsonObject.put("edt_parkingarea", siteAccessData.get(0).getEdt_parkingarea());
                jsonObject.put("edt_siteaccessibility", siteAccessData.get(0).getEdt_siteaccessibility());
                jsonObject.put("edt_markonthemap", siteAccessData.get(0).getEdt_markonthemap());
                jsonObject.put("edt_noteroaddescription", siteAccessData.get(0).getEdt_noteroaddescription());
                jsonObject.put("edt_visitorneed", siteAccessData.get(0).getEdt_visitorneed());
                jsonObject.put("edt_workinghourres", siteAccessData.get(0).getEdt_workinghourres());
                jsonObject.put("edt_othersiteaccess", siteAccessData.get(0).getEdt_othersiteaccess());
                jsonObject.put("edt_photographyallowed", siteAccessData.get(0).getEdt_photographyallowed());
                jsonObject.put("img_propertycontactrefrence", siteAccessData.get(0).getImg_propertycontactrefrence());
                jsonObject.put("img_parkingarea", siteAccessData.get(0).getImg_parkingarea());
                jsonObject.put("img_siteaccessibility", siteAccessData.get(0).getImg_siteaccessibility());
                jsonObject.put("img_markonthemap", siteAccessData.get(0).getImg_markonthemap());
                jsonObject.put("img_noteroaddescription", siteAccessData.get(0).getImg_noteroaddescription());
                jsonObject.put("img_visitorneed", siteAccessData.get(0).getImg_visitorneed());
                jsonObject.put("img_workinghourres", siteAccessData.get(0).getImg_workinghourres());
                jsonObject.put("img_othersiteaccess", siteAccessData.get(0).getImg_othersiteaccess());
                jsonObject.put("img_photographyallowed", siteAccessData.get(0).getImg_photographyallowed());

                jsonObject.put("status", siteAccessData.get(0).getStatus());

                jsonObject.put("date", siteIdentificationData.get(0).getEdt_siteidentidate());
                jsonObject.put("siteid", siteIdentificationData.get(0).getEdt_sitenumber());
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.EMPID)+ siteIdentificationData.get(0).getEdt_sitenumber()+siteIdentificationData.get(0).getEdt_siteidentidate());


            } catch (Exception e) {

            }
        }
        Log.v("json site access", jsonObject.toString());
        return jsonObject;
    }

    private void toSendDataSiteAccess() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.SITEACCESS, jsondataSiteAccess(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseSiteAccess(response);
                        Log.v("res SiteAccess", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res err SiteAccess", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseSiteAccess(JSONArray response) {
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");

              tv_show_status.append("Site Access :" +status+"\n");
            Toast.makeText(getActivity(), status + " SiteAccess", Toast.LENGTH_LONG).show();
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
            tv_show_status.append("Site Access :" +e.getMessage()+"\n");
        }
    }
//..........................END SiteAccess.............................

// .......................... MTH.............................
    private JSONObject jsondataMTH() {
        JSONObject jsonObject = new JSONObject();
        List<MaterialTransportHandlingData> mthData = db.getLastMTHData();
        if (mthData.size() > 0) {
            Log.v("MTH", mthData.toString());
            try {

                jsonObject.put("edt_ans1", mthData.get(0).getEdt_ques1());
                jsonObject.put("edt_ans2", mthData.get(0).getEdt_ques2());
                jsonObject.put("edt_ans3", mthData.get(0).getEdt_ques3());
                jsonObject.put("edt_ans4", mthData.get(0).getEdt_ques4());
                jsonObject.put("edt_ans5", mthData.get(0).getEdt_ques5());
                jsonObject.put("edt_ans6", mthData.get(0).getEdt_ques6());
                jsonObject.put("edt_ans7", mthData.get(0).getEdt_ques7());
                jsonObject.put("edt_ans8", mthData.get(0).getEdt_ques8());
                jsonObject.put("edt_ans9", mthData.get(0).getEdt_ques9());
                jsonObject.put("edt_ans10", mthData.get(0).getEdt_ques10());
                jsonObject.put("edt_ans11", mthData.get(0).getEdt_ques11());
                jsonObject.put("edt_ans12", mthData.get(0).getEdt_ques12());
                jsonObject.put("edt_ans13", mthData.get(0).getEdt_ques13());
                jsonObject.put("edt_ans14", mthData.get(0).getEdt_ques14());

                jsonObject.put("ans1", mthData.get(0).getRadioQues1());
                jsonObject.put("ans2", mthData.get(0).getRadioQues2());
                jsonObject.put("ans3", mthData.get(0).getRadioQues3());
                jsonObject.put("ans4", mthData.get(0).getRadioQues4());
                jsonObject.put("ans5", mthData.get(0).getRadioQues5());
                jsonObject.put("ans6", mthData.get(0).getRadioQues6());
                jsonObject.put("ans7", mthData.get(0).getRadioQues7());
                jsonObject.put("ans8", mthData.get(0).getRadioQues8());
                jsonObject.put("ans9", mthData.get(0).getRadioQues9());
                jsonObject.put("ans10", mthData.get(0).getRadioQues10());
                jsonObject.put("ans11", mthData.get(0).getRadioQues11());
                jsonObject.put("ans12", mthData.get(0).getRadioQues12());
                jsonObject.put("ans13", mthData.get(0).getRadioQues13());
                jsonObject.put("ans14", mthData.get(0).getRadioQues14());

                jsonObject.put("status", mthData.get(0).getStatus());

                jsonObject.put("date", siteIdentificationData.get(0).getEdt_siteidentidate());
                jsonObject.put("siteid", siteIdentificationData.get(0).getEdt_sitenumber());
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.EMPID)+ siteIdentificationData.get(0).getEdt_sitenumber()+siteIdentificationData.get(0).getEdt_siteidentidate());


            } catch (Exception e) {

            }
        }
        Log.v("json Mth", jsonObject.toString());
        return jsonObject;
    }

    private void toSendDataMTH() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.MTH, jsondataMTH(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseMTH(response);
                        Log.v("res MTH", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res err MTH", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseMTH(JSONArray response) {
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");

             tv_show_status.append("MTH :" +status+"\n");
            Toast.makeText(getActivity(), status + " MTH", Toast.LENGTH_LONG).show();
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
            tv_show_status.append("MTH :" +e.getMessage()+"\n");
        }
    }
//..........................END MTH.............................

    // .......................... EquipmentInformation.............................
    private JSONObject jsondataEquipmentInformation() {
        JSONObject jsonObject = new JSONObject();
        List<EquipmentInformationData> equipmentInformationData = db.getLastEquipmentInformationData();
        if (equipmentInformationData.size() > 0) {
            Log.v("equipmentInformation", equipmentInformationData.toString());
            try {

                jsonObject.put("typeofEquipmentExi1", equipmentInformationData.get(0).getTypeofEquipmentExi1());
                jsonObject.put("rbspowerExi1", equipmentInformationData.get(0).getRbspowerExi1());
                jsonObject.put("quantityExi1", equipmentInformationData.get(0).getQuantityExi1());
                jsonObject.put("dimensionsExi1", equipmentInformationData.get(0).getDimensionsExi1());
                jsonObject.put("configureExi1", equipmentInformationData.get(0).getConfigureExi1());
                jsonObject.put("sectorExi1", equipmentInformationData.get(0).getSectorExi1());

                jsonObject.put("typeofEquipmentExi2", equipmentInformationData.get(0).getTypeofEquipmentExi2());
                jsonObject.put("rbspowerExi2", equipmentInformationData.get(0).getRbspowerExi2());
                jsonObject.put("quantityExi2", equipmentInformationData.get(0).getQuantityExi2());
                jsonObject.put("dimensionsExi2", equipmentInformationData.get(0).getDimensionsExi2());
                jsonObject.put("configureExi2", equipmentInformationData.get(0).getConfigureExi2());
                jsonObject.put("sectorExi2", equipmentInformationData.get(0).getSectorExi2());

                jsonObject.put("typeofEquipmentExi3", equipmentInformationData.get(0).getTypeofEquipmentExi3());
                jsonObject.put("rbspowerExi3", equipmentInformationData.get(0).getRbspowerExi3());
                jsonObject.put("quantityExi3", equipmentInformationData.get(0).getQuantityExi3());
                jsonObject.put("dimensionsExi3", equipmentInformationData.get(0).getDimensionsExi3());
                jsonObject.put("configureExi3", equipmentInformationData.get(0).getConfigureExi3());
                jsonObject.put("sectorExi3", equipmentInformationData.get(0).getSectorExi3());

                jsonObject.put("typeofEquipmentExi4", equipmentInformationData.get(0).getTypeofEquipmentExi4());
                jsonObject.put("rbspowerExi4", equipmentInformationData.get(0).getRbspowerExi4());
                jsonObject.put("quantityExi4", equipmentInformationData.get(0).getQuantityExi4());
                jsonObject.put("dimensionsExi4", equipmentInformationData.get(0).getDimensionsExi4());
                jsonObject.put("configureExi4", equipmentInformationData.get(0).getConfigureExi4());
                jsonObject.put("sectorExi4", equipmentInformationData.get(0).getSectorExi4());

                jsonObject.put("typeofEquipmentNew1", equipmentInformationData.get(0).getTypeofEquipmentNew1());
                jsonObject.put("rbspowerNew1", equipmentInformationData.get(0).getRbspowerNew1());
                jsonObject.put("quantityNew1", equipmentInformationData.get(0).getQuantityNew1());
                jsonObject.put("dimensionsNew1", equipmentInformationData.get(0).getDimensionsNew1());
                jsonObject.put("configureNew1", equipmentInformationData.get(0).getConfigureNew1());
                jsonObject.put("sectorNew1", equipmentInformationData.get(0).getSectorNew1());

                jsonObject.put("typeofEquipmentNew2", equipmentInformationData.get(0).getTypeofEquipmentNew2());
                jsonObject.put("rbspowerNew2", equipmentInformationData.get(0).getRbspowerNew2());
                jsonObject.put("quantityNew2", equipmentInformationData.get(0).getQuantityNew2());
                jsonObject.put("dimensionsNew2", equipmentInformationData.get(0).getDimensionsNew2());
                jsonObject.put("configureNew2", equipmentInformationData.get(0).getConfigureNew2());
                jsonObject.put("sectorNew2", equipmentInformationData.get(0).getSectorNew2());

                jsonObject.put("typeofEquipmentNew3", equipmentInformationData.get(0).getTypeofEquipmentNew3());
                jsonObject.put("rbspowerNew3", equipmentInformationData.get(0).getRbspowerNew3());
                jsonObject.put("quantityNew3", equipmentInformationData.get(0).getQuantityNew3());
                jsonObject.put("dimensionsNew3", equipmentInformationData.get(0).getDimensionsNew3());
                jsonObject.put("configureNew3", equipmentInformationData.get(0).getConfigureNew3());
                jsonObject.put("sectorNew3", equipmentInformationData.get(0).getSectorNew3());

                jsonObject.put("typeofEquipmentNew4", equipmentInformationData.get(0).getTypeofEquipmentNew4());
                jsonObject.put("rbspowerNew4", equipmentInformationData.get(0).getRbspowerNew4());
                jsonObject.put("quantityNew4", equipmentInformationData.get(0).getQuantityNew4());
                jsonObject.put("dimensionsNew4", equipmentInformationData.get(0).getDimensionsNew4());
                jsonObject.put("configureNew4", equipmentInformationData.get(0).getConfigureNew4());
                jsonObject.put("sectorNew4", equipmentInformationData.get(0).getSectorNew4());


                jsonObject.put("edt_ans1", equipmentInformationData.get(0).getEdtques1());
                jsonObject.put("edt_ans2", equipmentInformationData.get(0).getEdtques2());
                jsonObject.put("edt_ans3", equipmentInformationData.get(0).getEdtques3());
                jsonObject.put("edt_ans4", equipmentInformationData.get(0).getEdtques4());
                jsonObject.put("edt_ans5", equipmentInformationData.get(0).getEdtques5());
                jsonObject.put("ans1", equipmentInformationData.get(0).getRadioQues1());
                jsonObject.put("ans2", equipmentInformationData.get(0).getRadioQues2());
                jsonObject.put("ans3", equipmentInformationData.get(0).getRadioQues3());
                jsonObject.put("ans4", equipmentInformationData.get(0).getRadioQues4());
                jsonObject.put("ans5", equipmentInformationData.get(0).getRadioQues5());
                jsonObject.put("status", equipmentInformationData.get(0).getStatus());

                jsonObject.put("date", siteIdentificationData.get(0).getEdt_siteidentidate());
                jsonObject.put("siteid", siteIdentificationData.get(0).getEdt_sitenumber());
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.EMPID)+ siteIdentificationData.get(0).getEdt_sitenumber()+siteIdentificationData.get(0).getEdt_siteidentidate());


            } catch (Exception e) {

            }
        }
        Log.v("json equipment information", jsonObject.toString());
        return jsonObject;
    }

    private void toSendDataequipmentInformationData() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.EQUIPMENTINFORMATION, jsondataEquipmentInformation(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseEquipmentInformation(response);
                        Log.v("res EquipmentInfo", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res err EquipmentInfo", error.toString());
                tv_show_status.append("Equipment Information :" +error.toString()+"\n");

                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseEquipmentInformation(JSONArray response) {
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");

              tv_show_status.append("Equipment Information :" +status+"\n");
            Toast.makeText(getActivity(), status + " EquipmentInformation", Toast.LENGTH_LONG).show();
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
            tv_show_status.append("Equipment Information :" +e.getMessage()+"\n");
        }
    }
//..........................END EquipmentInformation.............................

// .......................... EquipmentRoomInvestigation.............................
    private JSONObject jsondataEquipmentRoomInvestigation() {
        JSONObject jsonObject = new JSONObject();
        List<EquipmentRoomInvestigationData> mthData = db.getLastEQUIPMENTROOMINVESTIGATIONData();
        if (mthData.size() > 0) {
            Log.v("EquipmentRoomInvestigation", mthData.toString());
            try {

                jsonObject.put("edt_ans1", mthData.get(0).getEdt_ques1());
                jsonObject.put("edt_ans2", mthData.get(0).getEdt_ques2());
                jsonObject.put("edt_ans3", mthData.get(0).getEdt_ques3());
                jsonObject.put("edt_ans4", mthData.get(0).getEdt_ques4());
                jsonObject.put("edt_ans5_type", mthData.get(0).getEdt_ques5_Type());
                jsonObject.put("edt_ans5_dimension", mthData.get(0).getEdt_ques5_Dimension());
                jsonObject.put("edt_ans6", mthData.get(0).getEdt_ques6());
                jsonObject.put("edt_ans7", mthData.get(0).getEdt_ques7());
                jsonObject.put("edt_ans8", mthData.get(0).getEdt_ques8());
                jsonObject.put("edt_ans9", mthData.get(0).getEdt_ques9());
                jsonObject.put("edt_ans10", mthData.get(0).getEdt_ques10());
                jsonObject.put("edt_ans11", mthData.get(0).getEdt_ques11());
                jsonObject.put("edt_ans12", mthData.get(0).getEdt_ques12());
                jsonObject.put("edt_ans13", mthData.get(0).getEdt_ques13());
                jsonObject.put("edt_ans14", mthData.get(0).getEdt_ques14());
                jsonObject.put("edt_ans15", mthData.get(0).getEdt_ques15());
                jsonObject.put("edt_ans16", mthData.get(0).getEdt_ques16());
                jsonObject.put("edt_ans17", mthData.get(0).getEdt_ques17());

                jsonObject.put("ans1", mthData.get(0).getRadioQues1());
                jsonObject.put("ans2", mthData.get(0).getRadioQues2());
                jsonObject.put("ans3", mthData.get(0).getRadioQues3());
                jsonObject.put("ans4", mthData.get(0).getRadioQues4());
                jsonObject.put("ans5", mthData.get(0).getRadioQues5());
                jsonObject.put("ans6", mthData.get(0).getRadioQues6());
                jsonObject.put("ans7", mthData.get(0).getRadioQues7());
                jsonObject.put("ans8", mthData.get(0).getRadioQues8());
                jsonObject.put("ans9", mthData.get(0).getRadioQues9());
                jsonObject.put("ans10", mthData.get(0).getRadioQues10());
                jsonObject.put("ans11", mthData.get(0).getRadioQues11());
                jsonObject.put("ans12", mthData.get(0).getRadioQues12());
                jsonObject.put("ans13", mthData.get(0).getRadioQues13());
                jsonObject.put("ans14", mthData.get(0).getRadioQues14());
                jsonObject.put("ans15", mthData.get(0).getRadioQues15());
                jsonObject.put("ans16", mthData.get(0).getRadioQues16());
                jsonObject.put("ans17", mthData.get(0).getRadioQues17());

                jsonObject.put("status", mthData.get(0).getStatus());

                jsonObject.put("date", siteIdentificationData.get(0).getEdt_siteidentidate());
                jsonObject.put("siteid", siteIdentificationData.get(0).getEdt_sitenumber());
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.EMPID)+ siteIdentificationData.get(0).getEdt_sitenumber()+siteIdentificationData.get(0).getEdt_siteidentidate());


            } catch (Exception e) {

            }
        }
        Log.v("json euiproominvesti", jsonObject.toString());
        return jsonObject;
    }

    private void toSendDataEquipmentRoomInvestigation() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.EQUIPMENTROOMINVESTIGATION, jsondataEquipmentRoomInvestigation(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseEquipmentRoomInvestigation(response);
                        Log.v("res EquipmentRoomInvestigation", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res err EquipmentRoomInvestigation", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseEquipmentRoomInvestigation(JSONArray response) {
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");

            tv_show_status.append("Equipment Room Investigation :" +status+"\n");
            Toast.makeText(getActivity(), status + " EquipmentRoomInvestigation", Toast.LENGTH_LONG).show();
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
            tv_show_status.append("Equipment Room Investigation :" +e.getMessage()+"\n");
        }
    }
//..........................END EquipmentRoomInvestigation.............................

// .......................... PowerandBattery.............................
    private JSONObject jsondataPowerandBattery() {
        JSONObject jsonObject = new JSONObject();
        List<PowerandBatterybackup> mthData = db.getLastPowerandBatteryBackupData();
        if (mthData.size() > 0) {
            Log.v("PowerandBattery", mthData.toString());
            try {

                jsonObject.put("edt_ans1", mthData.get(0).getEdt_ques1());
                jsonObject.put("edt_ans2", mthData.get(0).getEdt_ques2());
                jsonObject.put("edt_ans3", mthData.get(0).getEdt_ques3());
                jsonObject.put("edt_ans4", mthData.get(0).getEdt_ques4());
                jsonObject.put("edt_ans5", mthData.get(0).getEdt_ques5());
                jsonObject.put("edt_ans6", mthData.get(0).getEdt_ques6());
                jsonObject.put("edt_ans7", mthData.get(0).getEdt_ques7());
                jsonObject.put("edt_ans8", mthData.get(0).getEdt_ques8());
                jsonObject.put("edt_ans9", mthData.get(0).getEdt_ques9());
                jsonObject.put("edt_ans10", mthData.get(0).getEdt_ques10());
                jsonObject.put("edt_ans11", mthData.get(0).getEdt_ques11());
                jsonObject.put("edt_ans12", mthData.get(0).getEdt_ques12());
                jsonObject.put("edt_ans13", mthData.get(0).getEdt_ques13());
                jsonObject.put("edt_ans14", mthData.get(0).getEdt_ques14());
                jsonObject.put("edt_ans15", mthData.get(0).getEdt_ques15());
                jsonObject.put("edt_ans16", mthData.get(0).getEdt_ques16());
                jsonObject.put("edt_ans17", mthData.get(0).getEdt_ques17());
                jsonObject.put("edt_ans18", mthData.get(0).getEdt_ques18());
                jsonObject.put("edt_ans19", mthData.get(0).getEdt_ques19());
                jsonObject.put("edt_ans20", mthData.get(0).getEdt_ques20());
                jsonObject.put("edt_ans21", mthData.get(0).getEdt_ques21());
                jsonObject.put("edt_ans22", mthData.get(0).getEdt_ques22());
                jsonObject.put("edt_ans23", mthData.get(0).getEdt_ques23());
                jsonObject.put("edt_ans24", mthData.get(0).getEdt_ques24());
                jsonObject.put("edt_ans25", mthData.get(0).getEdt_ques25());
                jsonObject.put("edt_ans26", mthData.get(0).getEdt_ques26());
                jsonObject.put("edt_ans27", mthData.get(0).getEdt_ques27());
                jsonObject.put("edt_ans28", mthData.get(0).getEdt_ques28());
                jsonObject.put("edt_ans29", mthData.get(0).getEdt_ques29());
                jsonObject.put("edt_ans30", mthData.get(0).getEdt_ques30());

                jsonObject.put("ans1", mthData.get(0).getRadioQues1());
                jsonObject.put("ans2", mthData.get(0).getRadioQues2());
                jsonObject.put("ans3", mthData.get(0).getRadioQues3());
                jsonObject.put("ans4", mthData.get(0).getRadioQues4());
                jsonObject.put("ans5", mthData.get(0).getRadioQues5());
                jsonObject.put("ans6", mthData.get(0).getRadioQues6());
                jsonObject.put("ans7", mthData.get(0).getRadioQues7());
                jsonObject.put("ans8", mthData.get(0).getRadioQues8());
                jsonObject.put("ans9", mthData.get(0).getRadioQues9());
                jsonObject.put("ans10", mthData.get(0).getRadioQues10());
                jsonObject.put("ans11", mthData.get(0).getRadioQues11());
                jsonObject.put("ans12", mthData.get(0).getRadioQues12());
                jsonObject.put("ans13", mthData.get(0).getRadioQues13());
                jsonObject.put("ans14", mthData.get(0).getRadioQues14());
                jsonObject.put("ans15", mthData.get(0).getRadioQues15());
                jsonObject.put("ans16", mthData.get(0).getRadioQues16());
                jsonObject.put("ans17", mthData.get(0).getRadioQues17());
                jsonObject.put("ans18", mthData.get(0).getRadioQues18());
                jsonObject.put("ans19", mthData.get(0).getRadioQues19());
                jsonObject.put("ans20", mthData.get(0).getRadioQues20());
                jsonObject.put("ans21", mthData.get(0).getRadioQues21());
                jsonObject.put("ans22", mthData.get(0).getRadioQues22());
                jsonObject.put("ans23", mthData.get(0).getRadioQues23());
                jsonObject.put("ans24", mthData.get(0).getRadioQues24());
                jsonObject.put("ans25", mthData.get(0).getRadioQues25());
                jsonObject.put("ans26", mthData.get(0).getRadioQues26());
                jsonObject.put("ans27", mthData.get(0).getRadioQues27());
                jsonObject.put("ans28", mthData.get(0).getRadioQues28());
                jsonObject.put("ans29", mthData.get(0).getRadioQues29());
                jsonObject.put("ans30", mthData.get(0).getRadioQues30());

                jsonObject.put("status", mthData.get(0).getStatus());

                jsonObject.put("date", siteIdentificationData.get(0).getEdt_siteidentidate());
                jsonObject.put("siteid", siteIdentificationData.get(0).getEdt_sitenumber());
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.EMPID)+ siteIdentificationData.get(0).getEdt_sitenumber()+siteIdentificationData.get(0).getEdt_siteidentidate());


            } catch (Exception e) {

            }
        }
        Log.v("json powerbattery", jsonObject.toString());
        return jsonObject;
    }

    private void toSendDataPowerandBattery() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.POWERBATTERY, jsondataPowerandBattery(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponsePowerandBattery(response);
                        Log.v("res PowerandBattery", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res err PowerandBattery", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponsePowerandBattery(JSONArray response) {
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");

              tv_show_status.append("PowerandBattery :" +status+"\n");
            Toast.makeText(getActivity(), status + " PowerandBattery", Toast.LENGTH_LONG).show();
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
            tv_show_status.append("PowerandBattery :" +e.getMessage()+"\n");
        }
    }
//..........................END PowerandBattey.............................

    // .......................... Grounding.............................
    private JSONObject jsondataGrounding() {
        JSONObject jsonObject = new JSONObject();
        List<GroundingData> groundingData = db.getLastGroundingData();
        if (groundingData.size() > 0) {
            Log.v("Grounding", groundingData.toString());
            try {

                jsonObject.put("edt_ans1", groundingData.get(0).getEdtques1());
                jsonObject.put("edt_ans2", groundingData.get(0).getEdtques2());
                jsonObject.put("edt_ans3", groundingData.get(0).getEdtques3());
                jsonObject.put("ans1", groundingData.get(0).getRadioQues1());
                jsonObject.put("ans2", groundingData.get(0).getRadioQues2());
                jsonObject.put("ans3", groundingData.get(0).getRadioQues3());

                jsonObject.put("status", groundingData.get(0).getStatus());

                jsonObject.put("date", siteIdentificationData.get(0).getEdt_siteidentidate());
                jsonObject.put("siteid", siteIdentificationData.get(0).getEdt_sitenumber());
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.EMPID)+ siteIdentificationData.get(0).getEdt_sitenumber()+siteIdentificationData.get(0).getEdt_siteidentidate());


            } catch (Exception e) {

            }
        }
        Log.v("json grounding", jsonObject.toString());
        return jsonObject;
    }

    private void toSendDataGrounding() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.GROUNDING, jsondataGrounding(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseGrounding(response);
                        Log.v("res Grounding", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res err Grounding", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseGrounding(JSONArray response) {
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");

              tv_show_status.append("Grounding :" +status+"\n");
            Toast.makeText(getActivity(), status + "Grounding", Toast.LENGTH_LONG).show();
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
            tv_show_status.append("Grounding :" +e.getMessage()+"\n");
        }
    }
//..........................END Grounding.............................

    // .......................... Transmission.............................
    private JSONObject jsondataTransmission() {
        JSONObject jsonObject = new JSONObject();
        List<TransmissionData> transmissionData = db.getLastTransmissionData();
        if (transmissionData.size() > 0) {
            Log.v("Transmission", transmissionData.toString());
            try {
                jsonObject.put("edt_ans1", transmissionData.get(0).getEdt_ques1());
                jsonObject.put("edt_ans2", transmissionData.get(0).getEdt_ques2());
                jsonObject.put("edt_ans3", transmissionData.get(0).getEdt_ques3());
                jsonObject.put("edt_ans4", transmissionData.get(0).getEdt_ques4());
                jsonObject.put("edt_ans5", transmissionData.get(0).getEdt_ques5());
                jsonObject.put("edt_ans6", transmissionData.get(0).getEdt_ques6());
                jsonObject.put("edt_ans7", transmissionData.get(0).getEdt_ques7());
                jsonObject.put("edt_ans8", transmissionData.get(0).getEdt_ques8());
                jsonObject.put("edt_ans9", transmissionData.get(0).getEdt_ques9());
                jsonObject.put("edt_ans10", transmissionData.get(0).getEdt_ques10());
                jsonObject.put("edt_ans11", transmissionData.get(0).getEdt_ques11());
                jsonObject.put("edt_ans12", transmissionData.get(0).getEdt_ques12());
                jsonObject.put("edt_ans13", transmissionData.get(0).getEdt_ques13());
                jsonObject.put("edt_ans14", transmissionData.get(0).getEdt_ques14());
                jsonObject.put("edt_ans15", transmissionData.get(0).getEdt_ques15());
                jsonObject.put("edt_ans16", transmissionData.get(0).getEdt_ques16());
                jsonObject.put("edt_ans17", transmissionData.get(0).getEdt_ques17());
                jsonObject.put("edt_ans18", transmissionData.get(0).getEdt_ques18());
                jsonObject.put("edt_ans19", transmissionData.get(0).getEdt_ques19());
                jsonObject.put("edt_ans20", transmissionData.get(0).getEdt_ques20());
                jsonObject.put("edt_ans21", transmissionData.get(0).getEdt_ques21());
                jsonObject.put("edt_ans22", transmissionData.get(0).getEdt_ques22());

                jsonObject.put("ans1", transmissionData.get(0).getRadioQues1());
                jsonObject.put("ans2", transmissionData.get(0).getRadioQues2());
                jsonObject.put("ans3", transmissionData.get(0).getRadioQues3());
                jsonObject.put("ans4", transmissionData.get(0).getRadioQues4());
                jsonObject.put("ans5", transmissionData.get(0).getRadioQues5());
                jsonObject.put("ans6", transmissionData.get(0).getRadioQues6());
                jsonObject.put("ans7", transmissionData.get(0).getRadioQues7());
                jsonObject.put("ans8", transmissionData.get(0).getRadioQues8());
                jsonObject.put("ans9", transmissionData.get(0).getRadioQues9());
                jsonObject.put("ans10", transmissionData.get(0).getRadioQues10());
                jsonObject.put("ans11", transmissionData.get(0).getRadioQues11());
                jsonObject.put("ans12", transmissionData.get(0).getRadioQues12());
                jsonObject.put("ans13", transmissionData.get(0).getRadioQues13());
                jsonObject.put("ans14", transmissionData.get(0).getRadioQues14());
                jsonObject.put("ans15", transmissionData.get(0).getRadioQues15());
                jsonObject.put("ans16", transmissionData.get(0).getRadioQues16());
                jsonObject.put("ans17", transmissionData.get(0).getRadioQues17());
                jsonObject.put("ans18", transmissionData.get(0).getRadioQues18());
                jsonObject.put("ans19", transmissionData.get(0).getRadioQues19());
                jsonObject.put("ans20", transmissionData.get(0).getRadioQues20());
                jsonObject.put("ans21", transmissionData.get(0).getRadioQues21());
                jsonObject.put("ans22", transmissionData.get(0).getRadioQues22());

                jsonObject.put("status", transmissionData.get(0).getStatus());


                jsonObject.put("date", siteIdentificationData.get(0).getEdt_siteidentidate());
                jsonObject.put("siteid", siteIdentificationData.get(0).getEdt_sitenumber());
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.EMPID)+ siteIdentificationData.get(0).getEdt_sitenumber()+siteIdentificationData.get(0).getEdt_siteidentidate());


            } catch (Exception e) {

            }
        }
        Log.v("json Transmission", jsonObject.toString());
        return jsonObject;
    }

    private void toSendDataTransmission() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.TRANSMISSION, jsondataTransmission(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseTransmission(response);
                        Log.v("res Transmission", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res err Transmission", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseTransmission(JSONArray response) {
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");

            tv_show_status.append("Transmission :" +status+"\n");
            Toast.makeText(getActivity(), status + "Transmission", Toast.LENGTH_LONG).show();
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
            tv_show_status.append("Transmission :" +e.getMessage()+"\n");
        }
    }
//..........................END Transmission.............................

    // .......................... Cable Inlets.............................
    private JSONObject jsondataCableInlets() {
        JSONObject jsonObject = new JSONObject();
        List<CableInletsData> cableInletsData = db.getLastCableInletsData();
        if (cableInletsData.size() > 0) {
            Log.v("CableInlets", cableInletsData.toString());
            try {
                jsonObject.put("edt_ans1", cableInletsData.get(0).getEdt_ques1());
                jsonObject.put("edt_ans2", cableInletsData.get(0).getEdt_ques2());
                jsonObject.put("edt_ans3", cableInletsData.get(0).getEdt_ques3());
                jsonObject.put("edt_ans4", cableInletsData.get(0).getEdt_ques4());
                jsonObject.put("edt_ans5", cableInletsData.get(0).getEdt_ques5());
                ;
                jsonObject.put("edt_ans6", cableInletsData.get(0).getEdt_ques6());
                jsonObject.put("edt_ans7", cableInletsData.get(0).getEdt_ques7());

                jsonObject.put("ans1", cableInletsData.get(0).getRadioQues1());
                jsonObject.put("ans2", cableInletsData.get(0).getRadioQues2());
                jsonObject.put("ans3", cableInletsData.get(0).getRadioQues3());
                jsonObject.put("ans4", cableInletsData.get(0).getRadioQues4());
                jsonObject.put("ans5", cableInletsData.get(0).getRadioQues5());
                jsonObject.put("ans6", cableInletsData.get(0).getRadioQues6());
                jsonObject.put("ans7", cableInletsData.get(0).getRadioQues7());

                jsonObject.put("status", cableInletsData.get(0).getStatus());


                jsonObject.put("date", siteIdentificationData.get(0).getEdt_siteidentidate());
                jsonObject.put("siteid", siteIdentificationData.get(0).getEdt_sitenumber());
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.EMPID)+ siteIdentificationData.get(0).getEdt_sitenumber()+siteIdentificationData.get(0).getEdt_siteidentidate());


            } catch (Exception e) {

            }
        }
        Log.v("json cableinlets", jsonObject.toString());
        return jsonObject;
    }

    private void toSendDataCableInlets() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.CABLEINLETS, jsondataCableInlets(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseCableInlets(response);
                        Log.v("res CableInlets", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res err CableInlets", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseCableInlets(JSONArray response) {
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");

            tv_show_status.append("Cable Inlets :" +status+"\n");
            Toast.makeText(getActivity(), status + " CableInlets", Toast.LENGTH_LONG).show();
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
            tv_show_status.append("Cable Inlets :" +e.getMessage()+"\n");
        }
    }
//..........................END Cable Inlets.............................

    // .......................... AntennaPlacementInvestigation.............................
    private JSONObject jsondataAntennaPlacementInvestigation() {
        JSONObject jsonObject = new JSONObject();
        List<AntennaPlacementInvestigationData> antennaPlacementInvestigationData = db.getLastAntennaPlacementInvestigationData();
        if (antennaPlacementInvestigationData.size() > 0) {
            Log.v("AntennaPlacementInvestigation", antennaPlacementInvestigationData.toString());
            try {
                jsonObject.put("edt_ans1", antennaPlacementInvestigationData.get(0).getEdt_ques1());
                jsonObject.put("edt_ans2", antennaPlacementInvestigationData.get(0).getEdt_ques2());
                jsonObject.put("edt_ans3", antennaPlacementInvestigationData.get(0).getEdt_ques3());
                jsonObject.put("edt_ans4", antennaPlacementInvestigationData.get(0).getEdt_ques4());
                jsonObject.put("edt_ans5", antennaPlacementInvestigationData.get(0).getEdt_ques5());
                jsonObject.put("edt_ans6", antennaPlacementInvestigationData.get(0).getEdt_ques6());
                jsonObject.put("edt_ans7", antennaPlacementInvestigationData.get(0).getEdt_ques7());
                jsonObject.put("edt_ans8", antennaPlacementInvestigationData.get(0).getEdt_ques8());
                jsonObject.put("edt_ans9", antennaPlacementInvestigationData.get(0).getEdt_ques9());
                jsonObject.put("edt_ans10", antennaPlacementInvestigationData.get(0).getEdt_ques10());
                jsonObject.put("edt_ans11", antennaPlacementInvestigationData.get(0).getEdt_ques11());
                jsonObject.put("edt_ans12", antennaPlacementInvestigationData.get(0).getEdt_ques12());
                jsonObject.put("edt_ans13", antennaPlacementInvestigationData.get(0).getEdt_ques13());
                jsonObject.put("edt_ans14", antennaPlacementInvestigationData.get(0).getEdt_ques14());
                jsonObject.put("edt_ans15", antennaPlacementInvestigationData.get(0).getEdt_ques15());
                jsonObject.put("ans1", antennaPlacementInvestigationData.get(0).getRadioQues1());
                jsonObject.put("ans2", antennaPlacementInvestigationData.get(0).getRadioQues2());
                jsonObject.put("ans3", antennaPlacementInvestigationData.get(0).getRadioQues3());
                jsonObject.put("ans4", antennaPlacementInvestigationData.get(0).getRadioQues4());
                jsonObject.put("ans5", antennaPlacementInvestigationData.get(0).getRadioQues5());
                jsonObject.put("ans6", antennaPlacementInvestigationData.get(0).getRadioQues6());
                jsonObject.put("ans7", antennaPlacementInvestigationData.get(0).getRadioQues7());
                jsonObject.put("ans8", antennaPlacementInvestigationData.get(0).getRadioQues8());
                jsonObject.put("ans9", antennaPlacementInvestigationData.get(0).getRadioQues9());
                jsonObject.put("ans10", antennaPlacementInvestigationData.get(0).getRadioQues10());
                jsonObject.put("ans11", antennaPlacementInvestigationData.get(0).getRadioQues11());
                jsonObject.put("ans12", antennaPlacementInvestigationData.get(0).getRadioQues12());
                jsonObject.put("ans13", antennaPlacementInvestigationData.get(0).getRadioQues13());
                jsonObject.put("ans14", antennaPlacementInvestigationData.get(0).getRadioQues14());
                jsonObject.put("ans15", antennaPlacementInvestigationData.get(0).getRadioQues15());

                jsonObject.put("edt_sectorA_azimuth", antennaPlacementInvestigationData.get(0).getEdt_sectorA_azimuth());
                jsonObject.put("edt_sectorA_height", antennaPlacementInvestigationData.get(0).getEdt_sectorA_height());
                jsonObject.put("edt_sectorB_azimuth", antennaPlacementInvestigationData.get(0).getEdt_sectorB_azimuth());
                jsonObject.put("edt_sectorB_height", antennaPlacementInvestigationData.get(0).getEdt_sectorB_height());
                jsonObject.put("edt_sectorC_azimuth", antennaPlacementInvestigationData.get(0).getEdt_sectorC_azimuth());
                jsonObject.put("edt_sectorC_height", antennaPlacementInvestigationData.get(0).getEdt_sectorC_height());
                jsonObject.put("edt_sectorD_azimuth", antennaPlacementInvestigationData.get(0).getEdt_sectorD_azimuth());
                jsonObject.put("edt_sectorD_height", antennaPlacementInvestigationData.get(0).getEdt_sectorD_height());

                jsonObject.put("status", antennaPlacementInvestigationData.get(0).getStatus());

                jsonObject.put("date", siteIdentificationData.get(0).getEdt_siteidentidate());
                jsonObject.put("siteid", siteIdentificationData.get(0).getEdt_sitenumber());
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.EMPID)+ siteIdentificationData.get(0).getEdt_sitenumber()+siteIdentificationData.get(0).getEdt_siteidentidate());


            } catch (Exception e) {

            }
        }
        Log.v("json AntennaPlacementinves", jsonObject.toString());
        return jsonObject;
    }

    private void toSendDataAntennaPlacementInvestigation() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.ANTENNAPLACEMENTINVESTMENT, jsondataAntennaPlacementInvestigation(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseAntennaPlacementInvestigation(response);
                        Log.v("res AntennaPlacementInvestigation", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res err AntennaPlacementInvestigation", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseAntennaPlacementInvestigation(JSONArray response) {
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");

            tv_show_status.append("AntennaPlacementInvestigation :" +status+"\n");
            Toast.makeText(getActivity(), status + " AntennaPlacementInvestigation", Toast.LENGTH_LONG).show();
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
            tv_show_status.append("AntennaPlacementInvestigation :" +e.getMessage()+"\n");
        }
    }
//..........................END AntennaPlacementIvestigation.............................

    // .......................... Site Photo.................................................
    private JSONObject jsondataSitePhoto() {
        JSONObject jsonObject = new JSONObject();
        List<SitePhotosData> sitePhotosData = db.getLastSitephotosData();
        if (sitePhotosData.size() > 0) {
            Log.v("SitePhoto", sitePhotosData.toString());
            try {

                jsonObject.put("edt_Siteview", sitePhotosData.get(0).getEdt_Siteview());
                jsonObject.put("edt_MicroWaveTRMlink", sitePhotosData.get(0).getEdt_MicroWaveTRMlink());
                jsonObject.put("edt_ODEquipmentElevation2", sitePhotosData.get(0).getEdt_ODEquipmentElevation2());
                jsonObject.put("edt_Transmission", sitePhotosData.get(0).getEdt_Transmission());
                jsonObject.put("edt_AC_PowerDistributionUnitDB", sitePhotosData.get(0).getEdt_AC_PowerDistributionUnitDB());
                jsonObject.put("edt_DC_PowerDistributionUnitType", sitePhotosData.get(0).getEdt_DC_PowerDistributionUnitType());
                jsonObject.put("edt_DC_PowerDistributionUnitDB", sitePhotosData.get(0).getEdt_DC_PowerDistributionUnitDB());
                jsonObject.put("edt_ExistingEquipment", sitePhotosData.get(0).getEdt_ExistingEquipment());
                jsonObject.put("edt_ExistingEquipmentonTower", sitePhotosData.get(0).getEdt_ExistingEquipmentonTower());
                jsonObject.put("edt_ExistingEquipmentTowerView", sitePhotosData.get(0).getEdt_ExistingEquipmentTowerView());
                jsonObject.put("edt_FreeSpaceAvailable", sitePhotosData.get(0).getEdt_FreeSpaceAvailable());
                jsonObject.put("edt_ProposedlocationforRRU", sitePhotosData.get(0).getEdt_ProposedlocationforRRU());
                jsonObject.put("edt_ProposedG900RUSinstallatRBS6201", sitePhotosData.get(0).getEdt_ProposedG900RUSinstallatRBS6201());
                jsonObject.put("edt_ProposedU900RUSinstallatRBS6201", sitePhotosData.get(0).getEdt_ProposedU900RUSinstallatRBS6201());
                jsonObject.put("edt_ProposedlocationforRRUS", sitePhotosData.get(0).getEdt_ProposedlocationforRRUS());
                jsonObject.put("edt_CableLadder", sitePhotosData.get(0).getEdt_CableLadder());
                jsonObject.put("edt_ProposedaddCableLadder", sitePhotosData.get(0).getEdt_ProposedaddCableLadder());
                jsonObject.put("edt_DistributionFrames", sitePhotosData.get(0).getEdt_DistributionFrames());
                jsonObject.put("edt_Roxtec", sitePhotosData.get(0).getEdt_Roxtec());
                jsonObject.put("edt_AdditionalPhotos", sitePhotosData.get(0).getEdt_AdditionalPhotos());

                if(!sitePhotosData.get(0).getImg_Siteview().equals("")){
                    jsonObject.put("img_Siteview", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_Siteview()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_Siteview",sitePhotosData.get(0).getImg_Siteview() );
                }

                if(!sitePhotosData.get(0).getImg_MicroWaveTRMlink().equals("")){
                    jsonObject.put("img_MicroWaveTRMlink", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_MicroWaveTRMlink()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_MicroWaveTRMlink",sitePhotosData.get(0).getImg_MicroWaveTRMlink() );
                }

                if(!sitePhotosData.get(0).getImg_ODEquipmentElevation2().equals("")){
                    jsonObject.put("img_ODEquipmentElevation2", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_ODEquipmentElevation2()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_ODEquipmentElevation2", sitePhotosData.get(0).getImg_ODEquipmentElevation2());
                }
                if(!sitePhotosData.get(0).getImg_Transmission().equals("")){
                    jsonObject.put("img_Transmission", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_Transmission()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_Transmission", sitePhotosData.get(0).getImg_Transmission());
                }

                if(!sitePhotosData.get(0).getImg_AC_PowerDistributionUnitDB().equals("")){
                    jsonObject.put("img_AC_PowerDistributionUnitDB", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_AC_PowerDistributionUnitDB()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_AC_PowerDistributionUnitDB", sitePhotosData.get(0).getImg_AC_PowerDistributionUnitDB());
                }
                if(!sitePhotosData.get(0).getImg_DC_PowerDistributionUnitType().equals("")){
                    jsonObject.put("img_DC_PowerDistributionUnitType", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_DC_PowerDistributionUnitType()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_DC_PowerDistributionUnitType", sitePhotosData.get(0).getImg_DC_PowerDistributionUnitType());
                }
                if(!sitePhotosData.get(0).getImg_DC_PowerDistributionUnitDB().equals("")){
                    jsonObject.put("img_DC_PowerDistributionUnitDB", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_DC_PowerDistributionUnitDB()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_DC_PowerDistributionUnitDB", sitePhotosData.get(0).getImg_DC_PowerDistributionUnitDB());
                }
                if(!sitePhotosData.get(0).getImg_ExistingEquipment().equals("")){
                    jsonObject.put("img_ExistingEquipment", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_ExistingEquipment()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_ExistingEquipment", sitePhotosData.get(0).getImg_ExistingEquipment());
                }
                if(!sitePhotosData.get(0).getImg_ExistingEquipmentonTower().equals("")){
                    jsonObject.put("img_ExistingEquipmentonTower", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_ExistingEquipmentonTower()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_ExistingEquipmentonTower", sitePhotosData.get(0).getImg_ExistingEquipmentonTower());
                }
                if(!sitePhotosData.get(0).getImg_ExistingEquipmentTowerView().equals("")){
                    jsonObject.put("img_ExistingEquipmentTowerView", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_ExistingEquipmentTowerView()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_ExistingEquipmentTowerView", sitePhotosData.get(0).getImg_ExistingEquipmentTowerView());
                }
                if(!sitePhotosData.get(0).getImg_FreeSpaceAvailable().equals("")){
                    jsonObject.put("img_FreeSpaceAvailable", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_FreeSpaceAvailable()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_FreeSpaceAvailable", sitePhotosData.get(0).getImg_FreeSpaceAvailable());
                }
                if(!sitePhotosData.get(0).getImg_ProposedlocationforRRU().equals("")){
                    jsonObject.put("img_ProposedlocationforRRU", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_ProposedlocationforRRU()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_ProposedlocationforRRU", sitePhotosData.get(0).getImg_ProposedlocationforRRU());
                }
                if(!sitePhotosData.get(0).getImg_ProposedG900RUSinstallatRBS6201().equals("")){
                    jsonObject.put("img_ProposedG900RUSinstallatRBS6201", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_ProposedG900RUSinstallatRBS6201()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_ProposedG900RUSinstallatRBS6201", sitePhotosData.get(0).getImg_ProposedG900RUSinstallatRBS6201());
                }

                if(!sitePhotosData.get(0).getImg_ProposedU900RUSinstallatRBS6201().equals(""))
                {
                    jsonObject.put("img_ProposedU900RUSinstallatRBS6201", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_ProposedU900RUSinstallatRBS6201()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_ProposedU900RUSinstallatRBS6201", sitePhotosData.get(0).getImg_ProposedU900RUSinstallatRBS6201());
                }

                if(!sitePhotosData.get(0).getImg_ProposedlocationforRRUS().equals(""))
                {
                    jsonObject.put("img_ProposedlocationforRRUS", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_ProposedlocationforRRUS()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_ProposedlocationforRRUS", sitePhotosData.get(0).getImg_ProposedlocationforRRUS());
                }

                if(!sitePhotosData.get(0).getImg_CableLadder().equals("")){

                    jsonObject.put("img_CableLadder", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_CableLadder()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_CableLadder", sitePhotosData.get(0).getImg_CableLadder());
                }
                if(!sitePhotosData.get(0).getImg_ProposedaddCableLadder().equals("")){
                    jsonObject.put("img_ProposedaddCableLadder", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_ProposedaddCableLadder()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_ProposedaddCableLadder", sitePhotosData.get(0).getImg_ProposedaddCableLadder());
                }
                if(!sitePhotosData.get(0).getImg_DistributionFrames().equals("")){
                    jsonObject.put("img_DistributionFrames", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_DistributionFrames()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_DistributionFrames", sitePhotosData.get(0).getImg_DistributionFrames());
                }
                if(!sitePhotosData.get(0).getImg_Roxtec().equals("")){
                    jsonObject.put("img_Roxtec", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_Roxtec()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_Roxtec", sitePhotosData.get(0).getImg_Roxtec());
                }
                if(!sitePhotosData.get(0).getImg_AdditionalPhotos().equals("")){
                    jsonObject.put("img_AdditionalPhotos", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePhotosData.get(0).getImg_AdditionalPhotos()), Bitmap.CompressFormat.JPEG, 100));
                }
                else
                    {
                    jsonObject.put("img_AdditionalPhotos", sitePhotosData.get(0).getImg_AdditionalPhotos());
                }
                jsonObject.put("status", sitePhotosData.get(0).getStatus());
                jsonObject.put("date", siteIdentificationData.get(0).getEdt_siteidentidate());


                jsonObject.put("siteid", siteIdentificationData.get(0).getEdt_sitenumber());

                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));


                jsonObject.put("idall", sharedPreferences.getString(AppConstants.EMPID)+ siteIdentificationData.get(0).getEdt_sitenumber()+siteIdentificationData.get(0).getEdt_siteidentidate());


            } catch (Exception e) {
                Log.v("json exception", e.getMessage());
            }
        }
        Log.v("json site photos", jsonObject.toString());
        return jsonObject;
    }

    private void toSendDataSitePhoto() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.SITEPHOTOS, jsondataSitePhoto(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseSitePhoto(response);
                        Log.v("res SitePhoto", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res err SitePhoto", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseSitePhoto(JSONArray response) {
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");

             tv_show_status.append("Site photos :" +status+"\n");
             Toast.makeText(getActivity(), status + "Site Photos", Toast.LENGTH_LONG).show();
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
            tv_show_status.append("Site photos :" +e.getMessage()+"\n");
        }
    }


//..........................END SitePhotos.............................

}
