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

import com.india.lhq.lqfarmiddleeast.Database.DatabaseHandler;
import com.india.lhq.lqfarmiddleeast.Database.MaterialTransportHandlingData;
import com.india.lhq.lqfarmiddleeast.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MaterialTransportHandlingFragment extends Fragment implements View.OnClickListener {

    private EditText edt_ques1;
    private EditText edt_ques2;
    private EditText edt_ques3;
    private EditText edt_ques4;
    private EditText edt_ques5;
    private EditText edt_ques6;
    private EditText edt_ques7;
    private EditText edt_ques8;
    private EditText edt_ques9;
    private EditText edt_ques10;
    private EditText edt_ques11;
    private EditText edt_ques12;
    private EditText edt_ques13;
    private EditText edt_ques14;

    private TextView tv_ques1;
    private TextView tv_ques2;
    private TextView tv_ques3;
    private TextView tv_ques4;
    private TextView tv_ques5;
    private TextView tv_ques6;
    private TextView tv_ques7;
    private TextView tv_ques8;
    private TextView tv_ques9;
    private TextView tv_ques10;
    private TextView tv_ques11;
    private TextView tv_ques12;
    private TextView tv_ques13;
    private TextView tv_ques14;
    private RadioGroup radioQues1, radioQues2, radioQues3, radioQues4, radioQues5, radioQues6, radioQues7;
    private RadioGroup radioQues8, radioQues9, radioQues10, radioQues11, radioQues12, radioQues13, radioQues14;
    private RadioButton yes1, yes2, yes3, yes4, yes5, yes6, yes7, yes8, yes9, yes10, yes11, yes12, yes13, yes14;
    private TextView tv_count_previous;
    private TextView tv_count_after;
    private Button btn_next,btn_save;
    private DatabaseHandler db;


    public MaterialTransportHandlingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_material_transport_handling, container, false);
        db = new DatabaseHandler(getActivity());
        findids(v);
        tv_count_previous.setText(tv_count_previous.getText().toString()+db.getCountMTHData());

        if(db.getCountMTHData()> 2){
            db.deleteSomeRow_MTHData();
        }
        return v;
    }

    private void findids(View v) {
        tv_count_previous = v.findViewById(R.id.tv_count_previous);
        tv_count_after = v.findViewById(R.id.tv_count_after);

        edt_ques1 = v.findViewById(R.id.edt_ques1);
        edt_ques2 = v.findViewById(R.id.edt_ques2);
        edt_ques3 = v.findViewById(R.id.edt_ques3);
        edt_ques4 = v.findViewById(R.id.edt_ques4);
        edt_ques5 = v.findViewById(R.id.edt_ques5);
        edt_ques6 = v.findViewById(R.id.edt_ques6);
        edt_ques7 = v.findViewById(R.id.edt_ques7);
        edt_ques8 = v.findViewById(R.id.edt_ques8);
        edt_ques9 = v.findViewById(R.id.edt_ques9);
        edt_ques10 = v.findViewById(R.id.edt_ques10);
        edt_ques11 = v.findViewById(R.id.edt_ques11);
        edt_ques12 = v.findViewById(R.id.edt_ques12);
        edt_ques13 = v.findViewById(R.id.edt_ques13);
        edt_ques14 = v.findViewById(R.id.edt_ques14);

        tv_ques1 = v.findViewById(R.id.tv_ques1);
        tv_ques2 = v.findViewById(R.id.tv_ques2);
        tv_ques3 = v.findViewById(R.id.tv_ques3);
        tv_ques4 = v.findViewById(R.id.tv_ques4);
        tv_ques5 = v.findViewById(R.id.tv_ques5);
        tv_ques6 = v.findViewById(R.id.tv_ques6);
        tv_ques7 = v.findViewById(R.id.tv_ques7);
        tv_ques8 = v.findViewById(R.id.tv_ques8);
        tv_ques9 = v.findViewById(R.id.tv_ques9);
        tv_ques10 = v.findViewById(R.id.tv_ques10);
        tv_ques11 = v.findViewById(R.id.tv_ques11);
        tv_ques12 = v.findViewById(R.id.tv_ques12);
        tv_ques13 = v.findViewById(R.id.tv_ques13);
        tv_ques14 = v.findViewById(R.id.tv_ques14);

        radioQues1 = (RadioGroup)v. findViewById(R.id.radioQues1);
        radioQues2 = (RadioGroup)v. findViewById(R.id.radioQues2);
        radioQues3 = (RadioGroup)v. findViewById(R.id.radioQues3);
        radioQues4 = (RadioGroup)v. findViewById(R.id.radioQues4);
        radioQues5 = (RadioGroup)v. findViewById(R.id.radioQues5);
        radioQues6 = (RadioGroup)v. findViewById(R.id.radioQues6);
        radioQues7 = (RadioGroup)v. findViewById(R.id.radioQues7);
        radioQues8 = (RadioGroup)v. findViewById(R.id.radioQues8);
        radioQues9 = (RadioGroup)v. findViewById(R.id.radioQues9);
        radioQues10 = (RadioGroup)v. findViewById(R.id.radioQues10);
        radioQues11 = (RadioGroup)v. findViewById(R.id.radioQues11);
        radioQues12 = (RadioGroup)v. findViewById(R.id.radioQues12);
        radioQues13 = (RadioGroup)v. findViewById(R.id.radioQues13);
        radioQues14 = (RadioGroup)v. findViewById(R.id.radioQues14);

        btn_next = v.findViewById(R.id.btn_next);
        btn_save = v.findViewById(R.id.btn_save);
        btn_next.setOnClickListener(this);
        btn_save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btn_save){
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
            int selectedId8 = radioQues8.getCheckedRadioButtonId();
            yes8 = (RadioButton) getView().findViewById(selectedId8);
            int selectedId9 = radioQues9.getCheckedRadioButtonId();
            yes9 = (RadioButton) getView().findViewById(selectedId9);
            int selectedId10 = radioQues10.getCheckedRadioButtonId();
            yes10 = (RadioButton) getView().findViewById(selectedId10);
            int selectedId11 = radioQues11.getCheckedRadioButtonId();
            yes11 = (RadioButton) getView().findViewById(selectedId11);
            int selectedId12 = radioQues12.getCheckedRadioButtonId();
            yes12 = (RadioButton) getView().findViewById(selectedId12);
            int selectedId13 = radioQues13.getCheckedRadioButtonId();
            yes13 = (RadioButton) getView().findViewById(selectedId13);
            int selectedId14 = radioQues14.getCheckedRadioButtonId();
            yes14 = (RadioButton) getView().findViewById(selectedId14);


            db.insertMTHData(new MaterialTransportHandlingData(edt_ques1.getText().toString(),  edt_ques2.getText().toString(),  edt_ques3.getText().toString(),  edt_ques4.getText().toString(),  edt_ques5.getText().toString(), edt_ques6.getText().toString(),
                    edt_ques7.getText().toString(), edt_ques8.getText().toString(),  edt_ques9.getText().toString(),  edt_ques10.getText().toString(),  edt_ques11.getText().toString(),  edt_ques12.getText().toString(),  edt_ques13.getText().toString(),  edt_ques14.getText().toString(),
                    yes1.getText().toString(), yes2.getText().toString(), yes3.getText().toString(),  yes4.getText().toString(),  yes5.getText().toString(), yes6.getText().toString(), yes7.getText().toString(), yes8.getText().toString(), yes9.getText().toString(),
                    yes10.getText().toString(), yes11.getText().toString(), yes12.getText().toString(), yes13.getText().toString(), yes14.getText().toString(), 1));

            tv_count_after.setText(db.getCountMTHData()+"");

            Toast.makeText(getActivity(), "All record has been Successfully", Toast.LENGTH_SHORT).show();
        }
        if (v == btn_next) {

            getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new EquipmentInformationFragment()).addToBackStack(null).commit();
        }
    }
}
