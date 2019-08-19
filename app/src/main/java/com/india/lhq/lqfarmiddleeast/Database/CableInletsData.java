package com.india.lhq.lqfarmiddleeast.Database;

import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CableInletsData {

    private int id;
    private String edt_ques1;
    private String edt_ques2;
    private String edt_ques3;
    private String edt_ques4;
    private String edt_ques5;
    private String edt_ques6;
    private String edt_ques7;
    private String radioQues1, radioQues2, radioQues3, radioQues4, radioQues5, radioQues6, radioQues7;
    private int status;

    public CableInletsData() {
    }

    public CableInletsData(String edt_ques1, String edt_ques2, String edt_ques3, String edt_ques4, String edt_ques5, String edt_ques6, String edt_ques7, String radioQues1, String radioQues2, String radioQues3, String radioQues4, String radioQues5, String radioQues6, String radioQues7, int status) {
        this.edt_ques1 = edt_ques1;
        this.edt_ques2 = edt_ques2;
        this.edt_ques3 = edt_ques3;
        this.edt_ques4 = edt_ques4;
        this.edt_ques5 = edt_ques5;
        this.edt_ques6 = edt_ques6;
        this.edt_ques7 = edt_ques7;
        this.radioQues1 = radioQues1;
        this.radioQues2 = radioQues2;
        this.radioQues3 = radioQues3;
        this.radioQues4 = radioQues4;
        this.radioQues5 = radioQues5;
        this.radioQues6 = radioQues6;
        this.radioQues7 = radioQues7;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEdt_ques1() {
        return edt_ques1;
    }

    public void setEdt_ques1(String edt_ques1) {
        this.edt_ques1 = edt_ques1;
    }

    public String getEdt_ques2() {
        return edt_ques2;
    }

    public void setEdt_ques2(String edt_ques2) {
        this.edt_ques2 = edt_ques2;
    }

    public String getEdt_ques3() {
        return edt_ques3;
    }

    public void setEdt_ques3(String edt_ques3) {
        this.edt_ques3 = edt_ques3;
    }

    public String getEdt_ques4() {
        return edt_ques4;
    }

    public void setEdt_ques4(String edt_ques4) {
        this.edt_ques4 = edt_ques4;
    }

    public String getEdt_ques5() {
        return edt_ques5;
    }

    public void setEdt_ques5(String edt_ques5) {
        this.edt_ques5 = edt_ques5;
    }

    public String getEdt_ques6() {
        return edt_ques6;
    }

    public void setEdt_ques6(String edt_ques6) {
        this.edt_ques6 = edt_ques6;
    }

    public String getEdt_ques7() {
        return edt_ques7;
    }

    public void setEdt_ques7(String edt_ques7) {
        this.edt_ques7 = edt_ques7;
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

    public String getRadioQues4() {
        return radioQues4;
    }

    public void setRadioQues4(String radioQues4) {
        this.radioQues4 = radioQues4;
    }

    public String getRadioQues5() {
        return radioQues5;
    }

    public void setRadioQues5(String radioQues5) {
        this.radioQues5 = radioQues5;
    }

    public String getRadioQues6() {
        return radioQues6;
    }

    public void setRadioQues6(String radioQues6) {
        this.radioQues6 = radioQues6;
    }

    public String getRadioQues7() {
        return radioQues7;
    }

    public void setRadioQues7(String radioQues7) {
        this.radioQues7 = radioQues7;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
