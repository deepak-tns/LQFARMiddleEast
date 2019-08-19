package com.india.lhq.lqfarmiddleeast.Database;

import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class GroundingData {
    private int id;
    private String edtques1,edtques2,edtques3;
    private String radioQues1,radioQues2,radioQues3;
    private int status;

    public GroundingData() {
    }

    public GroundingData(String edtques1, String edtques2, String edtques3, String radioQues1, String radioQues2, String radioQues3, int status) {
        this.edtques1 = edtques1;
        this.edtques2 = edtques2;
        this.edtques3 = edtques3;
        this.radioQues1 = radioQues1;
        this.radioQues2 = radioQues2;
        this.radioQues3 = radioQues3;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEdtques1() {
        return edtques1;
    }

    public void setEdtques1(String edtques1) {
        this.edtques1 = edtques1;
    }

    public String getEdtques2() {
        return edtques2;
    }

    public void setEdtques2(String edtques2) {
        this.edtques2 = edtques2;
    }

    public String getEdtques3() {
        return edtques3;
    }

    public void setEdtques3(String edtques3) {
        this.edtques3 = edtques3;
    }

    public String getRadioQues1() {
        return radioQues1;
    }

    public void setRadioQues1(String radioQues1) {
        this.radioQues1 = radioQues1;
    }

    public String getRadioQues2() {
        return radioQues2;
    }

    public void setRadioQues2(String radioQues2) {
        this.radioQues2 = radioQues2;
    }

    public String getRadioQues3() {
        return radioQues3;
    }

    public void setRadioQues3(String radioQues3) {
        this.radioQues3 = radioQues3;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
