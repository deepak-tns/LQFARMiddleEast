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
import com.india.lhq.lqfarmiddleeast.Database.SpecificSummaryData;
import com.india.lhq.lqfarmiddleeast.R;


public class SpecificeSummaryFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private EditText edtques1,edtques2,edtques3,edtques4;
    private TextView ssummaryques1,ssummaryques2,ssummaryques3,ssummaryques4;
    private RadioGroup radioQues1,radioQues2,radioQues3,radioQues4;
    private RadioButton yes1,yes2,yes3,yes4,no1,no2,no3,no4;
    private Button btn_save,btn_next;
    private DatabaseHandler db;
    private TextView tv_count_previous, tv_count_after;

    public SpecificeSummaryFragment() {
        // Required empty public constructor
    }


    public static SpecificeSummaryFragment newInstance(String param1, String param2) {
        SpecificeSummaryFragment fragment = new SpecificeSummaryFragment();
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
        View v= inflater.inflate(R.layout.fragment_specificsummary, container, false);
        findIds(v);
        db = new DatabaseHandler(getActivity());
        tv_count_previous.setText(tv_count_previous.getText().toString()+db.getCountSpecificSummaryData()+"");
        if(db.getCountSpecificSummaryData()> 2){
            db.deleteSomeRow_SpecificSummary();
        }
        return v;
    }

private void findIds(View v){
    tv_count_previous =v.findViewById(R.id.tv_count_previous);
    tv_count_after =v.findViewById(R.id.tv_count_after);
    edtques1 =(EditText) v.findViewById(R.id.edt_ques1);
    edtques2 =(EditText) v.findViewById(R.id.edt_ques2);
    edtques3 =(EditText) v.findViewById(R.id.edt_ques3);
    edtques4 =(EditText) v.findViewById(R.id.edt_ques4);

    ssummaryques1 =(TextView)v.findViewById(R.id.tv_ssummaryques1);
    ssummaryques2 =(TextView)v.findViewById(R.id.tv_ssummaryques2);
    ssummaryques3 =(TextView)v.findViewById(R.id.tv_ssummaryques3);
    ssummaryques4 =(TextView)v.findViewById(R.id.tv_ssummaryques4);

    radioQues1 = (RadioGroup)v. findViewById(R.id.radioQues1);
    radioQues2 = (RadioGroup)v. findViewById(R.id.radioQues2);
    radioQues3 = (RadioGroup)v. findViewById(R.id.radioQues3);
    radioQues4 = (RadioGroup)v. findViewById(R.id.radioQues4);

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
            int selectedId4 = radioQues4.getCheckedRadioButtonId();
            yes4 = (RadioButton) getView().findViewById(selectedId4);

/*
db.insertSpecificSummaryData(new SpecificSummaryData(edtques1.getText().toString(), edtques2.getText().toString(),
        edtques3.getText().toString(), edtques4.getText().toString(),yes1.getText()+"",yes2.getText()+"",yes3.getText()+"",yes4.getText()+"",1));*/

       db.insertSpecificSummaryData(new SpecificSummaryData( edtques1.getText()+"",  edtques2.getText()+"",  edtques3.getText()+"",edtques4.getText()+"", yes1.getText()+"", yes2.getText()+"",yes3.getText()+"",yes4.getText()+"", 1));
       tv_count_after.setText(db.getCountSpecificSummaryData()+"");


            Toast.makeText(getActivity(), "All record has been Successfully", Toast.LENGTH_SHORT).show();
        }

    });

}

    @Override
    public void onClick(View v) {
      if(v == btn_next){

              getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new SiteInformationFragment()).commit();

      }
    }
}


