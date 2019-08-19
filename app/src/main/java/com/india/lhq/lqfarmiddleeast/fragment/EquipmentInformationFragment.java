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
import com.india.lhq.lqfarmiddleeast.Database.EquipmentInformationData;
import com.india.lhq.lqfarmiddleeast.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EquipmentInformationFragment extends Fragment implements View.OnClickListener {

    private EditText typeofEquipmentExi1;
    private EditText rbspowerExi1;
    private EditText quantityExi1;
    private EditText DimensionsExi1;
    private EditText configureExi1;
    private EditText sectorExi1;
    private EditText typeofEquipmentExi2;
    private EditText rbspowerExi2;
    private EditText quantityExi2;
    private EditText DimensionsExi2;
    private EditText configureExi2;
    private EditText sectorExi2;
    private EditText typeofEquipmentExi3;
    private EditText rbspowerExi3;
    private EditText quantityExi3;
    private EditText DimensionsExi3;
    private EditText configureExi3;
    private EditText sectorExi3;
    private EditText typeofEquipmentExi4;
    private EditText rbspowerExi4;
    private EditText quantityExi4;
    private EditText DimensionsExi4;
    private EditText configureExi4;
    private EditText sectorExi4;

    private EditText typeofEquipmentNew1;
    private EditText rbspowerNew1;
    private EditText  quantityNew1;
    private EditText DimensionsNew1;
    private EditText configureNew1;
    private EditText sectorNew1;
    private EditText typeofEquipmentNew2;
    private EditText rbspowerNew2;
    private EditText  quantityNew2;
    private EditText DimensionsNew2;
    private EditText configureNew2;
    private EditText sectorNew2;
    private EditText typeofEquipmentNew3;
    private EditText rbspowerNew3;
    private EditText  quantityNew3;
    private EditText DimensionsNew3;
    private EditText configureNew3;
    private EditText sectorNew3;
    private EditText typeofEquipmentNew4;
    private EditText rbspowerNew4;
    private EditText  quantityNew4;
    private EditText DimensionsNew4;
    private EditText configureNew4;
    private EditText sectorNew4;

    private EditText edtques1,edtques2,edtques3,edtques4,edtques5;
    private TextView ssummaryques1,ssummaryques2,ssummaryques3,ssummaryques4;
    private RadioGroup radioQues1,radioQues2,radioQues3,radioQues4,radioQues5;
    private RadioButton yes1,yes2,yes3,yes4,yes5,no1,no2,no3,no4;
    private Button btn_save,btn_next;
    private DatabaseHandler db;
    private TextView tv_count_previous, tv_count_after;


    public EquipmentInformationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_equipment_information, container, false);
        findIds(v);
        db = new DatabaseHandler(getActivity());
        tv_count_previous.setText(tv_count_previous.getText().toString()+db.getCountEquipmentInformationData());

        if(db.getCountEquipmentInformationData()> 2){
            db.deleteSomeRow_EquipmentInformation();
        }

        return v;
    }

    private void findIds(View v) {

        tv_count_previous =v.findViewById(R.id.tv_count_previous);
        tv_count_after = v.findViewById(R.id.tv_count_after);
        typeofEquipmentExi1 =v.findViewById(R.id.typeofEquipmentExi1);
        rbspowerExi1 =v.findViewById(R.id.rbspowerExi1);
        quantityExi1 =v.findViewById(R.id.quantityExi1);
        DimensionsExi1 =v.findViewById(R.id.DimensionsExi1);
        configureExi1 =v.findViewById(R.id.configureExi1);
        sectorExi1 =v.findViewById(R.id.sectorExi1);
        typeofEquipmentExi2 =v.findViewById(R.id.typeofEquipmentExi2);
        rbspowerExi2 =v.findViewById(R.id.rbspowerExi2);
        quantityExi2 =v.findViewById(R.id.quantityExi2);
        DimensionsExi2 =v.findViewById(R.id.DimensionsExi2);
        configureExi2 =v.findViewById(R.id.configureExi2);
        sectorExi2 =v.findViewById(R.id.sectorExi2);
        typeofEquipmentExi3 =v.findViewById(R.id.typeofEquipmentExi3);
        rbspowerExi3 =v.findViewById(R.id.rbspowerExi3);
        quantityExi3 =v.findViewById(R.id.quantityExi3);
        DimensionsExi3 =v.findViewById(R.id.DimensionsExi3);
        configureExi3 =v.findViewById(R.id.configureExi3);
        sectorExi3 =v.findViewById(R.id.sectorExi3);
        typeofEquipmentExi4 =v.findViewById(R.id.typeofEquipmentExi4);
        rbspowerExi4 =v.findViewById(R.id.rbspowerExi4);
        quantityExi4 =v.findViewById(R.id.quantityExi4);
        DimensionsExi4 =v.findViewById(R.id.DimensionsExi4);
        configureExi4 =v.findViewById(R.id.configureExi4);
        sectorExi4 =v.findViewById(R.id.sectorExi4);

        typeofEquipmentNew1 =v.findViewById(R.id.typeofEquipmentNew1);
        rbspowerNew1 =v.findViewById(R.id.rbspowerNew1);
        quantityNew1 =v.findViewById(R.id.quantityNew1);
        DimensionsNew1 =v.findViewById(R.id.DimensionsNew1);
        configureNew1 =v.findViewById(R.id.configureNew1);
        sectorNew1 =v.findViewById(R.id.sectorNew1);
        typeofEquipmentNew2 =v.findViewById(R.id.typeofEquipmentNew2);
        rbspowerNew2 =v.findViewById(R.id.rbspowerNew2);
        quantityNew2 =v.findViewById(R.id.quantityNew2);
        DimensionsNew2 =v.findViewById(R.id.DimensionsNew2);
        configureNew2 =v.findViewById(R.id.configureNew2);
        sectorNew2 =v.findViewById(R.id.sectorNew2);
        typeofEquipmentNew3 =v.findViewById(R.id.typeofEquipmentNew3);
        rbspowerNew3 =v.findViewById(R.id.rbspowerNew3);
        quantityNew3 =v.findViewById(R.id.quantityNew3);
        DimensionsNew3 =v.findViewById(R.id.DimensionsNew3);
        configureNew3 =v.findViewById(R.id.configureNew3);
        sectorNew3 =v.findViewById(R.id.sectorNew3);
        typeofEquipmentNew4 =v.findViewById(R.id.typeofEquipmentNew4);
        rbspowerNew4 =v.findViewById(R.id.rbspowerNew4);
        quantityNew4 =v.findViewById(R.id.quantityNew4);
        DimensionsNew4 =v.findViewById(R.id.DimensionsNew4);
        configureNew4 =v.findViewById(R.id.configureNew4);
        sectorNew4 =v.findViewById(R.id.sectorNew4);

        radioQues1 = (RadioGroup)v. findViewById(R.id.radioQues1);
        radioQues2 = (RadioGroup)v. findViewById(R.id.radioQues2);
        radioQues3 = (RadioGroup)v. findViewById(R.id.radioQues3);
        radioQues4 = (RadioGroup)v. findViewById(R.id.radioQues4);
        radioQues5 = (RadioGroup)v. findViewById(R.id.radioQues5);

        edtques1 = (EditText)v. findViewById(R.id.edt_ques1);
        edtques2 = (EditText)v. findViewById(R.id.edt_ques2);
        edtques3 = (EditText)v. findViewById(R.id.edt_ques3);
        edtques4 = (EditText)v. findViewById(R.id.edt_ques4);
        edtques5 = (EditText)v. findViewById(R.id.edt_ques5);

        btn_next = v.findViewById(R.id.btn_next);
        btn_save = v.findViewById(R.id.btn_save);
        btn_next.setOnClickListener(this);
        btn_save.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if( v == btn_save){

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

            db.insertEquipmentInformationData(new EquipmentInformationData( typeofEquipmentExi1.getText().toString(), rbspowerExi1.getText().toString(), quantityExi1.getText().toString(), DimensionsExi1.getText().toString(), configureExi1.getText().toString(),sectorExi1.getText().toString(),typeofEquipmentExi2.getText().toString(),rbspowerExi2.getText().toString(),quantityExi2.getText().toString(),DimensionsExi2.getText().toString(),configureExi2.getText().toString(),sectorExi2.getText().toString(),typeofEquipmentExi3.getText().toString(),rbspowerExi3.getText().toString(),quantityExi3.getText().toString(),DimensionsExi3.getText().toString(),configureExi3.getText().toString(),sectorExi3.getText().toString(),typeofEquipmentExi4.getText().toString(),rbspowerExi4.getText().toString(), quantityExi4.getText().toString(),DimensionsExi4.getText().toString(),configureExi4.getText().toString(),sectorExi4.getText().toString(),
                    typeofEquipmentNew1.getText().toString(),rbspowerNew1.getText().toString(),quantityNew1.getText().toString(),DimensionsNew1.getText().toString(),configureNew1.getText().toString(),sectorNew1.getText().toString(),typeofEquipmentNew2.getText().toString(),rbspowerNew2.getText().toString(),quantityNew2.getText().toString(),DimensionsNew2.getText().toString(),configureNew2.getText().toString(),sectorNew2.getText().toString(),typeofEquipmentNew3.getText().toString(),rbspowerNew3.getText().toString(),quantityNew3.getText().toString(), DimensionsNew3.getText().toString(),configureNew3.getText().toString(),sectorNew3.getText().toString(),typeofEquipmentNew4.getText().toString(),rbspowerNew4.getText().toString(),quantityNew4.getText().toString(),DimensionsNew4.getText().toString(),configureNew4.getText().toString(),sectorNew4.getText().toString(),
                    edtques1.getText().toString(), edtques2.getText().toString(),edtques3.getText().toString(),edtques4.getText().toString(),edtques5.getText().toString(),yes1.getText().toString(),yes2.getText().toString(),yes3.getText().toString(), yes4.getText().toString(),yes5.getText().toString(), 1));

            tv_count_after.setText(db.getCountEquipmentInformationData() +"");

            Toast.makeText(getActivity(), "All record has been Successfully", Toast.LENGTH_SHORT).show();

        }
        if (v == btn_next) {

            getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new EquipmentRoomInvestigationFragment()).addToBackStack(null).commit();
        }

    }
}
