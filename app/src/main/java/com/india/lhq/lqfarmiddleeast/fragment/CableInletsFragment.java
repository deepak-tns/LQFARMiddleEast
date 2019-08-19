package com.india.lhq.lqfarmiddleeast.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.india.lhq.lqfarmiddleeast.Database.CableInletsData;
import com.india.lhq.lqfarmiddleeast.Database.DatabaseHandler;
import com.india.lhq.lqfarmiddleeast.Database.TransmissionData;
import com.india.lhq.lqfarmiddleeast.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CableInletsFragment extends Fragment  implements View.OnClickListener {

    private EditText edt_ques1;
    private EditText edt_ques2;
    private EditText edt_ques3;
    private EditText edt_ques4;
    private EditText edt_ques5;
    private EditText edt_ques6;
    private EditText edt_ques7;

    private TextView tv_ques1;
    private TextView tv_ques2;
    private TextView tv_ques3;
    private TextView tv_ques4;
    private TextView tv_ques5;
    private TextView tv_ques6;
    private TextView tv_ques7;

    private RadioGroup radioQues1, radioQues2, radioQues3, radioQues4, radioQues5, radioQues6, radioQues7;
    private RadioButton yes1, yes2, yes3, yes4, yes5, yes6, yes7;
    private TextView tv_count_previous;
    private TextView tv_count_after;
    private Button btn_next,btn_save;
    private DatabaseHandler db;


    public CableInletsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cable_inlets, container, false);
        db = new DatabaseHandler(getActivity());
        findids(v);
        tv_count_previous.setText(tv_count_previous.getText().toString()+db.getCountCableInletsData());

        if(db.getCountCableInletsData()> 2){
            db.deleteSomeRow_CableInlets();
        }

        return v;
    }

    private void findids(View v) {
        tv_count_previous=v.findViewById(R.id.tv_count_previous);
        tv_count_after=v.findViewById(R.id.tv_count_after);
        edt_ques1 = v.findViewById(R.id.edt_ques1);
        edt_ques2 = v.findViewById(R.id.edt_ques2);
        edt_ques3 = v.findViewById(R.id.edt_ques3);
        edt_ques4 = v.findViewById(R.id.edt_ques4);
        edt_ques5 = v.findViewById(R.id.edt_ques5);
        edt_ques6 = v.findViewById(R.id.edt_ques6);
        edt_ques7 = v.findViewById(R.id.edt_ques7);

        tv_ques1 = v.findViewById(R.id.tv_ques1);
        tv_ques2 = v.findViewById(R.id.tv_ques2);
        tv_ques3 = v.findViewById(R.id.tv_ques3);
        tv_ques4 = v.findViewById(R.id.tv_ques4);
        tv_ques5 = v.findViewById(R.id.tv_ques5);
        tv_ques6 = v.findViewById(R.id.tv_ques6);
        tv_ques7 = v.findViewById(R.id.tv_ques7);

        radioQues1 = (RadioGroup)v. findViewById(R.id.radioQues1);
        radioQues2 = (RadioGroup)v. findViewById(R.id.radioQues2);
        radioQues3 = (RadioGroup)v. findViewById(R.id.radioQues3);
        radioQues4 = (RadioGroup)v. findViewById(R.id.radioQues4);
        radioQues5 = (RadioGroup)v. findViewById(R.id.radioQues5);
        radioQues6 = (RadioGroup)v. findViewById(R.id.radioQues6);
        radioQues7 = (RadioGroup)v. findViewById(R.id.radioQues7);

        btn_next = v.findViewById(R.id.btn_next);
        btn_save = v.findViewById(R.id.btn_save);
        btn_next.setOnClickListener(this);
        btn_save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btn_save) {

            int selectedId1 = radioQues1.getCheckedRadioButtonId();
            yes1 = (RadioButton) getView().findViewById(selectedId1);
            int selectedId2 = radioQues2.getCheckedRadioButtonId();
            yes2 = (RadioButton) getView().findViewById(selectedId2);
            int selectedId3 = radioQues3.getCheckedRadioButtonId();
            yes3 = (RadioButton) getView().findViewById(selectedId3);
            int selectedId4 = radioQues4.getCheckedRadioButtonId();
            yes4 = (RadioButton) getView().findViewById(selectedId4);
            int selectedId5 = radioQues5.getCheckedRadioButtonId();
            yes5 = (RadioButton) getView().findViewById(selectedId5);
            int selectedId6 = radioQues6.getCheckedRadioButtonId();
            yes6 = (RadioButton) getView().findViewById(selectedId6);
            int selectedId7 = radioQues7.getCheckedRadioButtonId();
            yes7 = (RadioButton) getView().findViewById(selectedId7);

            Toast.makeText(getActivity(), "All record has been Successfully", Toast.LENGTH_SHORT).show();

            db.insertCableInletsData(new CableInletsData(edt_ques1.getText().toString(),edt_ques2.getText().toString(),edt_ques3.getText().toString(),edt_ques4.getText().toString(),edt_ques5.getText().toString(),edt_ques6.getText().toString(),edt_ques7.getText().toString(),
                    yes1.getText().toString(),yes2.getText().toString(),yes3.getText().toString(),yes4.getText().toString(),yes5.getText().toString(),yes6.getText().toString(),yes7.getText().toString(),1));

            tv_count_after.setText(db.getCountCableInletsData()+"");
        }
        if (v == btn_next) {

            getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new AntennaPlacementInvestigationFragment()).addToBackStack(null).commit();
        }
    }
}
