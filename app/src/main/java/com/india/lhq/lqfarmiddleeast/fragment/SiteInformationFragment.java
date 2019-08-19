package com.india.lhq.lqfarmiddleeast.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.india.lhq.lqfarmiddleeast.Database.DatabaseHandler;
import com.india.lhq.lqfarmiddleeast.Database.SiteInformationData;
import com.india.lhq.lqfarmiddleeast.R;


public class SiteInformationFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView tv_count_previous;
    private TextView tv_count_after;
    private EditText edt_site_id;
    private EditText edt_sitename;
    private EditText edt_sitetype;
    private EditText edt_buildingtype;
    private EditText edt_Lat;
    private EditText edt_Long;
    private EditText edt_siteAddress;
    private EditText edt_vendorsite;
    private EditText edt_dateofsitevisit;
    private EditText edt_sitevisitperformed;
    private EditText edt_phoneno;
    private EditText edt_participantssitevisit;
    private EditText edt_phoneno_partcipantssitevisit;
    private Button btn_next, btn_save;
    private DatabaseHandler db;

    public SiteInformationFragment() {
        // Required empty public constructor
    }


    public static SiteInformationFragment newInstance(String param1, String param2) {
        SiteInformationFragment fragment = new SiteInformationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_siteinformation, container, false);
        db = new DatabaseHandler(getActivity());
        findIds(v);
        tv_count_previous.setText(tv_count_previous.getText().toString()+ db.getCountSiteInformationData()+"");

        if(db.getCountSiteInformationData()> 2){
            db.deleteSomeRow_SiteInformationData();
        }
        return v;
    }

    private void findIds(View v) {

        tv_count_previous = v.findViewById(R.id.tv_count_previous);
        tv_count_after = v.findViewById(R.id.tv_count_after);
        edt_site_id = v.findViewById(R.id.edt_site_id);
        edt_sitename = v.findViewById(R.id.edt_sitename);
        edt_sitetype = v.findViewById(R.id.edt_sitetype);
        edt_buildingtype = v.findViewById(R.id.edt_buildingtype22);
        edt_Lat = v.findViewById(R.id.edt_lat);
        edt_Long = v.findViewById(R.id.edt_long);
        edt_siteAddress = v.findViewById(R.id.edt_siteAddress);
        edt_vendorsite = v.findViewById(R.id.edt_vendorsite);
        edt_dateofsitevisit = v.findViewById(R.id.edt_dateofsitevisit);
        edt_sitevisitperformed = v.findViewById(R.id.edt_sitevisitperformed);
        edt_phoneno = v.findViewById(R.id.edt_phoneno);
        edt_participantssitevisit = v.findViewById(R.id.edt_participantssitevisit);
        edt_phoneno_partcipantssitevisit = v.findViewById(R.id.edt_phoneno_partcipantssitevisit);
        btn_next = v.findViewById(R.id.btn_next);
        btn_save = v.findViewById(R.id.btn_save);

        btn_next.setOnClickListener(this);
        btn_save.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
     if(v== btn_save){
       db.insertSiteInformationData(new SiteInformationData(edt_site_id.getText().toString(),edt_sitename.getText().toString(),edt_sitetype.getText().toString(), edt_buildingtype.getText().toString(),edt_Lat.getText().toString(),edt_Long.getText().toString(),edt_siteAddress.getText().toString(),edt_vendorsite.getText().toString(),
        edt_dateofsitevisit.getText().toString(),edt_sitevisitperformed.getText().toString(),edt_phoneno.getText().toString(),edt_participantssitevisit.getText().toString(),
        edt_phoneno_partcipantssitevisit.getText().toString(),1       ));

     /*    db.insertSiteInformationData(new SiteInformationData("1","1","1", "1","1","1","1","1",
                 "1","1","1","1",
                 "1",1       ));*/

        tv_count_after.setText( db.getCountSiteInformationData()+"");

         Toast.makeText(getActivity(), "All record has been Successfully", Toast.LENGTH_SHORT).show();
     }
     if(v == btn_next){
         getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new LocalRegulationFragment()).commit();
     }
    }
}
