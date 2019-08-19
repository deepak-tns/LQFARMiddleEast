package com.india.lhq.lqfarmiddleeast.fragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.india.lhq.lqfarmiddleeast.Database.DatabaseHandler;
import com.india.lhq.lqfarmiddleeast.Database.SiteIdentificationData;
import com.india.lhq.lqfarmiddleeast.R;
import com.india.lhq.lqfarmiddleeast.constants.GoogleGPSService;

/**
 * A simple {@link Fragment} subclass.
 */
public class SiteIdentificationFragment extends Fragment implements View.OnClickListener {
    private final String TAG = SiteIdentificationFragment.class.getSimpleName() ;

    private String SELECT = "-SELECT-";

    private LinearLayout li_other;
    private Button button;

    Handler handler;
    private String time;
    private String getcustomLocation;
    private DatabaseHandler databaseHandler;
    private String lat;
    private String log;
    private Button btn_save,btn_next;
    private TextView tvlat_log,tvdate, tvsiteidentidate,edt_location,edt_sitenumber,edt_lat,edt_long,edt_sitename,edt_sitetype,edt_remark;
    private TextView tv_count_previous;
    private TextView tv_count_after;
    public SiteIdentificationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // String h = DateFormat.format("MMddyyyyhmmssaa", System.currentTimeMillis()).toString();
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_site_identification, container, false);
        findViews(v);
        databaseHandler = new DatabaseHandler(getActivity());
        if (!GoogleGPSService.isRunning) {
            getActivity().startService(new Intent(getActivity(), GoogleGPSService.class));
        }

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time = DateFormat.format("dd-MM-yyyy h:mm:ss:aa", System.currentTimeMillis()).toString();
                tvdate.setText(time);
                tvsiteidentidate.setText(time);
                handler.postDelayed(this, 1000);
            }

        }, 1000);

          tv_count_previous.setText(tv_count_previous.getText().toString()+databaseHandler.getCountSiteIdentification()+"");
          if(databaseHandler.getCountSiteIdentification()> 2){
              databaseHandler.delete_SiteIdentification();
          }

        return v;

    }

    private void  findViews(View v){

        tv_count_previous =v.findViewById(R.id.tv_count_previous);
        tv_count_after =v.findViewById(R.id.tv_count_after);

        tvlat_log =(TextView)v.findViewById(R.id.lat_log);
        tvdate = (TextView) v.findViewById(R.id.tvdate);

        edt_location =(TextView)v.findViewById(R.id.edt_location);
        edt_sitenumber =(TextView)v.findViewById(R.id.edt_sitenumber);
        edt_lat =(TextView)v.findViewById(R.id.edt_lat);
        edt_long =(TextView)v.findViewById(R.id.edt_long);
        edt_sitename =(TextView)v.findViewById(R.id.edt_sitename);
        edt_sitetype =(TextView)v.findViewById(R.id.edt_sitetype);
        tvsiteidentidate =(TextView)v.findViewById(R.id.edtsiteidentidate);
        edt_remark =(TextView)v.findViewById(R.id.edt_remark);

        btn_save =(Button)v.findViewById(R.id.btn_save);
        btn_next =(Button)v.findViewById(R.id.btn_next);
        btn_save.setOnClickListener(this);
        btn_next.setOnClickListener(this);
    }


    @Override
    public void onResume() {
        super.onResume();
        //  GPSTracker.BUS.register(this);
        getActivity().registerReceiver(broadcastReceiver, new IntentFilter(GoogleGPSService.BROADCAST_ACTION));
    }

    @Override
    public void onClick(View v) {

        if(v== btn_save){

          databaseHandler.insertSiteIdentificationData(new SiteIdentificationData(edt_location.getText().toString(),
        edt_sitenumber.getText().toString(),edt_lat.getText().toString(),edt_long.getText().toString(),edt_sitename.getText().toString(),
         edt_sitetype.getText().toString(),tvsiteidentidate.getText().toString(),edt_remark.getText().toString(),1 ));


            int count = databaseHandler.getCountSiteIdentification();
            tv_count_after.setText(count+"");


            Toast.makeText(getActivity(), "All record has been Successfully", Toast.LENGTH_SHORT).show();
        }

        if(v == btn_next){

            getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new SpecificeSummaryFragment()).commit();

        }

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
            tvlat_log.setText(lat + "," + log);
            //  Toast.makeText(getActivity(), "Lat : "+lat+","+ "Long : "+ log, Toast.LENGTH_LONG).show();

        }


    };



}