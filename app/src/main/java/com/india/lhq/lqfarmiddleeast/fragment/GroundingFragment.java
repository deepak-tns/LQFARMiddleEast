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
import com.india.lhq.lqfarmiddleeast.Database.GroundingData;
import com.india.lhq.lqfarmiddleeast.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroundingFragment extends Fragment implements View.OnClickListener {

    private EditText edtques1,edtques2,edtques3;
    private TextView tv_ques1,tv_ques2,tv_ques3;
    private RadioGroup radioQues1,radioQues2,radioQues3;
    private RadioButton yes1,yes2,yes3,no1,no2,no3;
    private Button btn_save,btn_next;
    private DatabaseHandler db;
    private TextView tv_count_previous, tv_count_after;

    public GroundingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_grounding, container, false);
        findIds(v);
        db = new DatabaseHandler(getActivity());
        tv_count_previous.setText(tv_count_previous.getText().toString()+db.getCountGroundingData());

        if(db.getCountGroundingData()> 2){
            db.deleteSomeRow_Grounding();
        }

        return v;
    }

    private void findIds(View v){
        tv_count_previous =v.findViewById(R.id.tv_count_previous);
        tv_count_after =v.findViewById(R.id.tv_count_after);
        edtques1 =(EditText) v.findViewById(R.id.edt_ques1);
        edtques2 =(EditText) v.findViewById(R.id.edt_ques2);
        edtques3 =(EditText) v.findViewById(R.id.edt_ques3);

        tv_ques1 =(TextView)v.findViewById(R.id.tv_ques1);
        tv_ques2 =(TextView)v.findViewById(R.id.tv_ques2);
        tv_ques3 =(TextView)v.findViewById(R.id.tv_ques3);

        radioQues1 = (RadioGroup)v. findViewById(R.id.radioQues1);
        radioQues2 = (RadioGroup)v. findViewById(R.id.radioQues2);
        radioQues3 = (RadioGroup)v. findViewById(R.id.radioQues3);

        btn_next = (Button)v. findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);
        btn_save = (Button)v. findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int selectedId1 = radioQues1.getCheckedRadioButtonId();
                yes1 = (RadioButton) getView().findViewById(selectedId1);
                int selectedId2 = radioQues2.getCheckedRadioButtonId();
                yes2 = (RadioButton) getView().findViewById(selectedId2);
                int selectedId3 = radioQues3.getCheckedRadioButtonId();
                yes3 = (RadioButton) getView().findViewById(selectedId3);

                db.insertGroundingData(new GroundingData(edtques1.getText().toString(),edtques2.getText().toString(),edtques3.getText().toString(),yes1.getText().toString(),yes2.getText().toString(),yes3.getText().toString(),1));

               tv_count_after.setText( db.getCountGroundingData()+"");

                Toast.makeText(getActivity(), "All record has been Successfully", Toast.LENGTH_SHORT).show();
            }

        });

    }

    @Override
    public void onClick(View v) {
        if (v == btn_next) {

            getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new TransmissionFragment()).addToBackStack(null).commit();
        }
    }
}
