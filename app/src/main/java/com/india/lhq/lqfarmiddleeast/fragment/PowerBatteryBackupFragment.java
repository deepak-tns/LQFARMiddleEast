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
import com.india.lhq.lqfarmiddleeast.Database.EquipmentRoomInvestigationData;
import com.india.lhq.lqfarmiddleeast.Database.PowerandBatterybackup;
import com.india.lhq.lqfarmiddleeast.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PowerBatteryBackupFragment extends Fragment implements View.OnClickListener {
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
    private EditText edt_ques15;
    private EditText edt_ques16;
    private EditText edt_ques17;
    private EditText edt_ques18;
    private EditText edt_ques19;
    private EditText edt_ques20;
    private EditText edt_ques21;
    private EditText edt_ques22;
    private EditText edt_ques23;
    private EditText edt_ques24;
    private EditText edt_ques25;
    private EditText edt_ques26;
    private EditText edt_ques27;
    private EditText edt_ques28;
    private EditText edt_ques29;
    private EditText edt_ques30;

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
    private TextView tv_ques15;
    private TextView tv_ques16;
    private TextView tv_ques17;
    private TextView tv_ques18;
    private TextView tv_ques19;
    private TextView tv_ques20;
    private TextView tv_ques21;
    private TextView tv_ques22;
    private TextView tv_ques23;
    private TextView tv_ques24;
    private TextView tv_ques25;
    private TextView tv_ques26;
    private TextView tv_ques27;
    private TextView tv_ques28;
    private TextView tv_ques29;
    private TextView tv_ques30;

    private RadioGroup radioQues1, radioQues2, radioQues3, radioQues4, radioQues5, radioQues6, radioQues7,radioQues8, radioQues9, radioQues10, radioQues11;
    private RadioGroup radioQues12, radioQues13, radioQues14, radioQues15, radioQues16, radioQues17, radioQues18, radioQues19, radioQues20, radioQues21;
    private RadioGroup radioQues22, radioQues23, radioQues24, radioQues25, radioQues26, radioQues27, radioQues28, radioQues29, radioQues30;
    private RadioButton yes1, yes2, yes3, yes4, yes5, yes6, yes7, yes8, yes9, yes10, yes11, yes12, yes13, yes14,yes15,yes16,yes17;
    private RadioButton yes18, yes19, yes20, yes21, yes22, yes23, yes24, yes25, yes26, yes27, yes28, yes29, yes30;
    private TextView tv_count_previous;
    private TextView tv_count_after;
    private Button btn_next,btn_save;
    private DatabaseHandler db;


    public PowerBatteryBackupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_power_battery_backup, container, false);

        db = new DatabaseHandler(getActivity());
        findids(v);
        tv_count_previous.setText(tv_count_previous.getText().toString()+db.getCountPowerandBatteryBackupData()+"");

        if(db.getCountPowerandBatteryBackupData()> 2){
            db.deleteSomeRow_PowerandBatteryBackup();
        }
        return v;
    }

    private void findids(View v) {
        tv_count_previous =v.findViewById(R.id.tv_count_previous);
        tv_count_after =v.findViewById(R.id.tv_count_after);
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
        edt_ques15 = v.findViewById(R.id.edt_ques15);
        edt_ques16 = v.findViewById(R.id.edt_ques16);
        edt_ques17 = v.findViewById(R.id.edt_ques17);
        edt_ques18 = v.findViewById(R.id.edt_ques18);
        edt_ques19 = v.findViewById(R.id.edt_ques19);
        edt_ques20 = v.findViewById(R.id.edt_ques20);
        edt_ques21 = v.findViewById(R.id.edt_ques21);
        edt_ques22 = v.findViewById(R.id.edt_ques22);
        edt_ques23 = v.findViewById(R.id.edt_ques23);
        edt_ques24 = v.findViewById(R.id.edt_ques24);
        edt_ques25 = v.findViewById(R.id.edt_ques25);
        edt_ques26 = v.findViewById(R.id.edt_ques26);
        edt_ques27 = v.findViewById(R.id.edt_ques27);
        edt_ques28 = v.findViewById(R.id.edt_ques28);
        edt_ques29 = v.findViewById(R.id.edt_ques29);
        edt_ques30 = v.findViewById(R.id.edt_ques30);

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
        tv_ques15 = v.findViewById(R.id.tv_ques15);
        tv_ques16 = v.findViewById(R.id.tv_ques16);
        tv_ques17 = v.findViewById(R.id.tv_ques17);
        tv_ques18 = v.findViewById(R.id.tv_ques18);
        tv_ques19 = v.findViewById(R.id.tv_ques19);
        tv_ques20 = v.findViewById(R.id.tv_ques20);
        tv_ques21 = v.findViewById(R.id.tv_ques21);
        tv_ques22 = v.findViewById(R.id.tv_ques22);
        tv_ques23 = v.findViewById(R.id.tv_ques23);
        tv_ques24 = v.findViewById(R.id.tv_ques24);
        tv_ques25 = v.findViewById(R.id.tv_ques25);
        tv_ques26 = v.findViewById(R.id.tv_ques26);
        tv_ques27 = v.findViewById(R.id.tv_ques27);
        tv_ques28 = v.findViewById(R.id.tv_ques28);
        tv_ques29 = v.findViewById(R.id.tv_ques29);
        tv_ques30 = v.findViewById(R.id.tv_ques30);

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
        radioQues15 = (RadioGroup)v. findViewById(R.id.radioQues15);
        radioQues16 = (RadioGroup)v. findViewById(R.id.radioQues16);
        radioQues17 = (RadioGroup)v. findViewById(R.id.radioQues17);
        radioQues18 = v.findViewById(R.id.radioQues18);
        radioQues19 = v.findViewById(R.id.radioQues19);
        radioQues20 = v.findViewById(R.id.radioQues20);
        radioQues21 = v.findViewById(R.id.radioQues21);
        radioQues22 = v.findViewById(R.id.radioQues22);
        radioQues23 = v.findViewById(R.id.radioQues23);
        radioQues24 = v.findViewById(R.id.radioQues24);
        radioQues25 = v.findViewById(R.id.radioQues25);
        radioQues26 = v.findViewById(R.id.radioQues26);
        radioQues27 = v.findViewById(R.id.radioQues27);
        radioQues28 = v.findViewById(R.id.radioQues28);
        radioQues29 = v.findViewById(R.id.radioQues29);
        radioQues30 = v.findViewById(R.id.radioQues30);

        btn_next = v.findViewById(R.id.btn_next);
        btn_save = v.findViewById(R.id.btn_save);
        btn_next.setOnClickListener(this);
        btn_save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btn_save)
        {
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
            int selectedId15 = radioQues15.getCheckedRadioButtonId();
            yes15 = (RadioButton) getView().findViewById(selectedId15);
            int selectedId16 = radioQues16.getCheckedRadioButtonId();
            yes16 = (RadioButton) getView().findViewById(selectedId16);
            int selectedId17 = radioQues17.getCheckedRadioButtonId();
            yes17 = (RadioButton) getView().findViewById(selectedId17);
            int selectedId18 = radioQues18.getCheckedRadioButtonId();
            yes18 = (RadioButton) getView().findViewById(selectedId18);
            int selectedId19 = radioQues19.getCheckedRadioButtonId();
            yes19 = (RadioButton) getView().findViewById(selectedId19);
            int selectedId20 = radioQues20.getCheckedRadioButtonId();
            yes20 = (RadioButton) getView().findViewById(selectedId20);
            int selectedId21 = radioQues21.getCheckedRadioButtonId();
            yes21 = (RadioButton) getView().findViewById(selectedId21);
            int selectedId22 = radioQues22.getCheckedRadioButtonId();
            yes22 = (RadioButton) getView().findViewById(selectedId22);
            int selectedId23 = radioQues23.getCheckedRadioButtonId();
            yes23 = (RadioButton) getView().findViewById(selectedId23);
            int selectedId24 = radioQues24.getCheckedRadioButtonId();
            yes24 = (RadioButton) getView().findViewById(selectedId24);
            int selectedId25 = radioQues25.getCheckedRadioButtonId();
            yes25 = (RadioButton) getView().findViewById(selectedId25);
            int selectedId26 = radioQues26.getCheckedRadioButtonId();
            yes26 = (RadioButton) getView().findViewById(selectedId26);
            int selectedId27 = radioQues27.getCheckedRadioButtonId();
            yes27 = (RadioButton) getView().findViewById(selectedId27);
            int selectedId28 = radioQues28.getCheckedRadioButtonId();
            yes28 = (RadioButton) getView().findViewById(selectedId28);
            int selectedId29 = radioQues29.getCheckedRadioButtonId();
            yes29 = (RadioButton) getView().findViewById(selectedId29);
            int selectedId30 = radioQues30.getCheckedRadioButtonId();
            yes30 = (RadioButton) getView().findViewById(selectedId30);

            db.insertPowerandBatteryBackupData(new PowerandBatterybackup(edt_ques1.getText().toString(),edt_ques2.getText().toString(),edt_ques3.getText().toString(),edt_ques4.getText().toString(),edt_ques5.getText().toString(),edt_ques6.getText().toString(),edt_ques7.getText().toString(),edt_ques8.getText().toString(),edt_ques9.getText().toString(),edt_ques10.getText().toString(),edt_ques11.getText().toString(),edt_ques12.getText().toString(),edt_ques13.getText().toString(),edt_ques14.getText().toString(),edt_ques15.getText().toString(),edt_ques16.getText().toString(),
                    edt_ques17.getText().toString(),edt_ques18.getText().toString(),edt_ques19.getText().toString(),edt_ques20.getText().toString(),edt_ques21.getText().toString(),edt_ques22.getText().toString(),edt_ques23.getText().toString(),edt_ques24.getText().toString(),edt_ques25.getText().toString(),edt_ques26.getText().toString(),edt_ques27.getText().toString(),edt_ques28.getText().toString(),edt_ques29.getText().toString(),edt_ques30.getText().toString(),
                    yes1.getText().toString(),yes2.getText().toString(),yes3.getText().toString(),yes4.getText().toString(),yes5.getText().toString(),yes6.getText().toString(),yes7.getText().toString(),yes8.getText().toString(),yes9.getText().toString(),yes10.getText().toString(),yes11.getText().toString(),yes12.getText().toString(), yes13.getText().toString(),yes14.getText().toString(),yes15.getText().toString(),yes16.getText().toString(),  yes17.getText().toString(), yes18.getText().toString(), yes19.getText().toString(), yes20.getText().toString(),
                    yes21.getText().toString(),yes22.getText().toString(),yes23.getText().toString(),yes24.getText().toString(),yes25.getText().toString(),yes26.getText().toString(),yes27.getText().toString(),yes28.getText().toString(),yes29.getText().toString(),yes30.getText().toString(),1));

            tv_count_after.setText(db.getCountPowerandBatteryBackupData()+"");

            Toast.makeText(getActivity(), "All record has been Successfully", Toast.LENGTH_SHORT).show();
        }
        if (v == btn_next) {

            getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new GroundingFragment()).addToBackStack(null).commit();
        }
    }
}
