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
import com.india.lhq.lqfarmiddleeast.Database.LocalRegulationData;
import com.india.lhq.lqfarmiddleeast.Database.SpecificSummaryData;
import com.india.lhq.lqfarmiddleeast.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocalRegulationFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView ques1,ques2,tv_other;
    private EditText edt_ques1,edt_ques2,edt_ques3;
    private RadioGroup radioQues1,radioQues2;
    private RadioButton yes1,yes2;
    private Button btn_save,btn_next;
    private DatabaseHandler db;
    private TextView tv_count_previous,tv_count_after;

    public LocalRegulationFragment() {
        // Required empty public constructor
    }

    public static LocalRegulationFragment newInstance(String param1, String param2) {
        LocalRegulationFragment fragment = new LocalRegulationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_local_regulation, container, false);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
      findIds(v);
        db = new DatabaseHandler(getActivity());
        tv_count_previous.setText(tv_count_previous.getText().toString()+ db.getCountLocalRegulationData()+"");

        if(db.getCountLocalRegulationData()> 2){
            db.deleteSomeRow_LocalRegulation();
        }
        return v;
    }


    private void findIds(View v){
        tv_count_previous = v.findViewById(R.id.tv_count_previous);
        tv_count_after = v.findViewById(R.id.tv_count_after);
        ques1 =(TextView)v.findViewById(R.id.tv_ques1);
        ques2 =(TextView)v.findViewById(R.id.tv_ques2);
        tv_other =(TextView)v.findViewById(R.id.tv_ques3);

        edt_ques1 =(EditText) v.findViewById(R.id.edt_ques1);
        edt_ques2 =(EditText) v.findViewById(R.id.edt_ques2);
        edt_ques3 =(EditText) v.findViewById(R.id.edt_ques3);

        radioQues1 = (RadioGroup)v. findViewById(R.id.radioQues1);
        radioQues2 = (RadioGroup)v. findViewById(R.id.radioQues2);

        btn_save = (Button)v. findViewById(R.id.btn_save);
        btn_next = (Button)v. findViewById(R.id.btn_next);
        btn_save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int selectedId1 = radioQues1.getCheckedRadioButtonId();
                yes1 = (RadioButton) getView().findViewById(selectedId1);
                int selectedId2 = radioQues2.getCheckedRadioButtonId();
                yes2 = (RadioButton) getView().findViewById(selectedId2);

                db.insertLocalRegulationData(new LocalRegulationData(edt_ques1.getText().toString(),edt_ques2.getText().toString(),edt_ques3.getText().toString(),
                        yes1.getText()+"",yes2.getText()+"","NA",1));

                tv_count_after.setText( db.getCountLocalRegulationData()+"");

                Toast.makeText(getActivity(), "All record has been Successfully", Toast.LENGTH_SHORT).show();
            }

        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new SiteAccessFragment()).commit();

            }
        });

    }

}
