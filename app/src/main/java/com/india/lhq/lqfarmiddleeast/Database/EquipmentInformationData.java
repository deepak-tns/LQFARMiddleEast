package com.india.lhq.lqfarmiddleeast.Database;

import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class EquipmentInformationData {
    private int id;
    private String typeofEquipmentExi1;
    private String rbspowerExi1;
    private String quantityExi1;
    private String dimensionsExi1;
    private String configureExi1;
    private String sectorExi1;
    private String typeofEquipmentExi2;
    private String rbspowerExi2;
    private String quantityExi2;
    private String dimensionsExi2;
    private String configureExi2;
    private String sectorExi2;
    private String typeofEquipmentExi3;
    private String rbspowerExi3;
    private String quantityExi3;
    private String dimensionsExi3;
    private String configureExi3;
    private String sectorExi3;
    private String typeofEquipmentExi4;
    private String rbspowerExi4;
    private String quantityExi4;
    private String dimensionsExi4;
    private String configureExi4;
    private String sectorExi4;

    private String typeofEquipmentNew1;
    private String rbspowerNew1;
    private String quantityNew1;
    private String dimensionsNew1;
    private String configureNew1;
    private String sectorNew1;
    private String typeofEquipmentNew2;
    private String rbspowerNew2;
    private String quantityNew2;
    private String dimensionsNew2;
    private String configureNew2;
    private String sectorNew2;
    private String typeofEquipmentNew3;
    private String rbspowerNew3;
    private String quantityNew3;
    private String dimensionsNew3;
    private String configureNew3;
    private String sectorNew3;
    private String typeofEquipmentNew4;
    private String rbspowerNew4;
    private String quantityNew4;
    private String dimensionsNew4;
    private String configureNew4;
    private String sectorNew4;

    private String edtques1,edtques2,edtques3,edtques4,edtques5;
 //   private String tvques1,tvques2,tvques3,tvques4,tvques5;
    private String radioQues1,radioQues2,radioQues3,radioQues4,radioQues5;
    private int status;

    public EquipmentInformationData() {
    }

    public EquipmentInformationData(String typeofEquipmentExi1, String rbspowerExi1, String quantityExi1, String dimensionsExi1, String configureExi1, String sectorExi1, String typeofEquipmentExi2, String rbspowerExi2, String quantityExi2, String dimensionsExi2, String configureExi2, String sectorExi2, String typeofEquipmentExi3, String rbspowerExi3, String quantityExi3, String dimensionsExi3, String configureExi3, String sectorExi3, String typeofEquipmentExi4, String rbspowerExi4, String quantityExi4, String dimensionsExi4, String configureExi4, String sectorExi4, String typeofEquipmentNew1, String rbspowerNew1, String quantityNew1, String dimensionsNew1, String configureNew1, String sectorNew1, String typeofEquipmentNew2, String rbspowerNew2, String quantityNew2, String dimensionsNew2, String configureNew2, String sectorNew2, String typeofEquipmentNew3, String rbspowerNew3, String quantityNew3, String dimensionsNew3, String configureNew3, String sectorNew3, String typeofEquipmentNew4, String rbspowerNew4, String quantityNew4, String dimensionsNew4, String configureNew4, String sectorNew4, String edtques1, String edtques2, String edtques3, String edtques4, String edtques5,  String radioQues1, String radioQues2, String radioQues3, String radioQues4, String radioQues5, int status) {
        this.typeofEquipmentExi1 = typeofEquipmentExi1;
        this.rbspowerExi1 = rbspowerExi1;
        this.quantityExi1 = quantityExi1;
        this.dimensionsExi1 = dimensionsExi1;
        this.configureExi1 = configureExi1;
        this.sectorExi1 = sectorExi1;
        this.typeofEquipmentExi2 = typeofEquipmentExi2;
        this.rbspowerExi2 = rbspowerExi2;
        this.quantityExi2 = quantityExi2;
        this.dimensionsExi2 = dimensionsExi2;
        this.configureExi2 = configureExi2;
        this.sectorExi2 = sectorExi2;
        this.typeofEquipmentExi3 = typeofEquipmentExi3;
        this.rbspowerExi3 = rbspowerExi3;
        this.quantityExi3 = quantityExi3;
        this.dimensionsExi3 = dimensionsExi3;
        this.configureExi3 = configureExi3;
        this.sectorExi3 = sectorExi3;
        this.typeofEquipmentExi4 = typeofEquipmentExi4;
        this.rbspowerExi4 = rbspowerExi4;
        this.quantityExi4 = quantityExi4;
        this.dimensionsExi4 = dimensionsExi4;
        this.configureExi4 = configureExi4;
        this.sectorExi4 = sectorExi4;
        this.typeofEquipmentNew1 = typeofEquipmentNew1;
        this.rbspowerNew1 = rbspowerNew1;
        this.quantityNew1 = quantityNew1;
        this.dimensionsNew1 = dimensionsNew1;
        this.configureNew1 = configureNew1;
        this.sectorNew1 = sectorNew1;
        this.typeofEquipmentNew2 = typeofEquipmentNew2;
        this.rbspowerNew2 = rbspowerNew2;
        this.quantityNew2 = quantityNew2;
        this.dimensionsNew2 = dimensionsNew2;
        this.configureNew2 = configureNew2;
        this.sectorNew2 = sectorNew2;
        this.typeofEquipmentNew3 = typeofEquipmentNew3;
        this.rbspowerNew3 = rbspowerNew3;
        this.quantityNew3 = quantityNew3;
        this.dimensionsNew3 = dimensionsNew3;
        this.configureNew3 = configureNew3;
        this.sectorNew3 = sectorNew3;
        this.typeofEquipmentNew4 = typeofEquipmentNew4;
        this.rbspowerNew4 = rbspowerNew4;
        this.quantityNew4 = quantityNew4;
        this.dimensionsNew4 = dimensionsNew4;
        this.configureNew4 = configureNew4;
        this.sectorNew4 = sectorNew4;
        this.edtques1 = edtques1;
        this.edtques2 = edtques2;
        this.edtques3 = edtques3;
        this.edtques4 = edtques4;
        this.edtques5 = edtques5;
        this.radioQues1 = radioQues1;
        this.radioQues2 = radioQues2;
        this.radioQues3 = radioQues3;
        this.radioQues4 = radioQues4;
        this.radioQues5 = radioQues5;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeofEquipmentExi1() {
        return typeofEquipmentExi1;
    }

    public void setTypeofEquipmentExi1(String typeofEquipmentExi1) {
        this.typeofEquipmentExi1 = typeofEquipmentExi1;
    }

    public String getRbspowerExi1() {
        return rbspowerExi1;
    }

    public void setRbspowerExi1(String rbspowerExi1) {
        this.rbspowerExi1 = rbspowerExi1;
    }

    public String getQuantityExi1() {
        return quantityExi1;
    }

    public void setQuantityExi1(String quantityExi1) {
        this.quantityExi1 = quantityExi1;
    }

    public String getDimensionsExi1() {
        return dimensionsExi1;
    }

    public void setDimensionsExi1(String dimensionsExi1) {
        this.dimensionsExi1 = dimensionsExi1;
    }

    public String getConfigureExi1() {
        return configureExi1;
    }

    public void setConfigureExi1(String configureExi1) {
        this.configureExi1 = configureExi1;
    }

    public String getSectorExi1() {
        return sectorExi1;
    }

    public void setSectorExi1(String sectorExi1) {
        this.sectorExi1 = sectorExi1;
    }

    public String getTypeofEquipmentExi2() {
        return typeofEquipmentExi2;
    }

    public void setTypeofEquipmentExi2(String typeofEquipmentExi2) {
        this.typeofEquipmentExi2 = typeofEquipmentExi2;
    }

    public String getRbspowerExi2() {
        return rbspowerExi2;
    }

    public void setRbspowerExi2(String rbspowerExi2) {
        this.rbspowerExi2 = rbspowerExi2;
    }

    public String getQuantityExi2() {
        return quantityExi2;
    }

    public void setQuantityExi2(String quantityExi2) {
        this.quantityExi2 = quantityExi2;
    }

    public String getDimensionsExi2() {
        return dimensionsExi2;
    }

    public void setDimensionsExi2(String dimensionsExi2) {
        this.dimensionsExi2 = dimensionsExi2;
    }

    public String getConfigureExi2() {
        return configureExi2;
    }

    public void setConfigureExi2(String configureExi2) {
        this.configureExi2 = configureExi2;
    }

    public String getSectorExi2() {
        return sectorExi2;
    }

    public void setSectorExi2(String sectorExi2) {
        this.sectorExi2 = sectorExi2;
    }

    public String getTypeofEquipmentExi3() {
        return typeofEquipmentExi3;
    }

    public void setTypeofEquipmentExi3(String typeofEquipmentExi3) {
        this.typeofEquipmentExi3 = typeofEquipmentExi3;
    }

    public String getRbspowerExi3() {
        return rbspowerExi3;
    }

    public void setRbspowerExi3(String rbspowerExi3) {
        this.rbspowerExi3 = rbspowerExi3;
    }

    public String getQuantityExi3() {
        return quantityExi3;
    }

    public void setQuantityExi3(String quantityExi3) {
        this.quantityExi3 = quantityExi3;
    }

    public String getDimensionsExi3() {
        return dimensionsExi3;
    }

    public void setDimensionsExi3(String dimensionsExi3) {
        this.dimensionsExi3 = dimensionsExi3;
    }

    public String getConfigureExi3() {
        return configureExi3;
    }

    public void setConfigureExi3(String configureExi3) {
        this.configureExi3 = configureExi3;
    }

    public String getSectorExi3() {
        return sectorExi3;
    }

    public void setSectorExi3(String sectorExi3) {
        this.sectorExi3 = sectorExi3;
    }

    public String getTypeofEquipmentExi4() {
        return typeofEquipmentExi4;
    }

    public void setTypeofEquipmentExi4(String typeofEquipmentExi4) {
        this.typeofEquipmentExi4 = typeofEquipmentExi4;
    }

    public String getRbspowerExi4() {
        return rbspowerExi4;
    }

    public void setRbspowerExi4(String rbspowerExi4) {
        this.rbspowerExi4 = rbspowerExi4;
    }

    public String getQuantityExi4() {
        return quantityExi4;
    }

    public void setQuantityExi4(String quantityExi4) {
        this.quantityExi4 = quantityExi4;
    }

    public String getDimensionsExi4() {
        return dimensionsExi4;
    }

    public void setDimensionsExi4(String dimensionsExi4) {
        this.dimensionsExi4 = dimensionsExi4;
    }

    public String getConfigureExi4() {
        return configureExi4;
    }

    public void setConfigureExi4(String configureExi4) {
        this.configureExi4 = configureExi4;
    }

    public String getSectorExi4() {
        return sectorExi4;
    }

    public void setSectorExi4(String sectorExi4) {
        this.sectorExi4 = sectorExi4;
    }

    public String getTypeofEquipmentNew1() {
        return typeofEquipmentNew1;
    }

    public void setTypeofEquipmentNew1(String typeofEquipmentNew1) {
        this.typeofEquipmentNew1 = typeofEquipmentNew1;
    }

    public String getRbspowerNew1() {
        return rbspowerNew1;
    }

    public void setRbspowerNew1(String rbspowerNew1) {
        this.rbspowerNew1 = rbspowerNew1;
    }

    public String getQuantityNew1() {
        return quantityNew1;
    }

    public void setQuantityNew1(String quantityNew1) {
        this.quantityNew1 = quantityNew1;
    }

    public String getDimensionsNew1() {
        return dimensionsNew1;
    }

    public void setDimensionsNew1(String dimensionsNew1) {
        this.dimensionsNew1 = dimensionsNew1;
    }

    public String getConfigureNew1() {
        return configureNew1;
    }

    public void setConfigureNew1(String configureNew1) {
        this.configureNew1 = configureNew1;
    }

    public String getSectorNew1() {
        return sectorNew1;
    }

    public void setSectorNew1(String sectorNew1) {
        this.sectorNew1 = sectorNew1;
    }

    public String getTypeofEquipmentNew2() {
        return typeofEquipmentNew2;
    }

    public void setTypeofEquipmentNew2(String typeofEquipmentNew2) {
        this.typeofEquipmentNew2 = typeofEquipmentNew2;
    }

    public String getRbspowerNew2() {
        return rbspowerNew2;
    }

    public void setRbspowerNew2(String rbspowerNew2) {
        this.rbspowerNew2 = rbspowerNew2;
    }

    public String getQuantityNew2() {
        return quantityNew2;
    }

    public void setQuantityNew2(String quantityNew2) {
        this.quantityNew2 = quantityNew2;
    }

    public String getDimensionsNew2() {
        return dimensionsNew2;
    }

    public void setDimensionsNew2(String dimensionsNew2) {
        this.dimensionsNew2 = dimensionsNew2;
    }

    public String getConfigureNew2() {
        return configureNew2;
    }

    public void setConfigureNew2(String configureNew2) {
        this.configureNew2 = configureNew2;
    }

    public String getSectorNew2() {
        return sectorNew2;
    }

    public void setSectorNew2(String sectorNew2) {
        this.sectorNew2 = sectorNew2;
    }

    public String getTypeofEquipmentNew3() {
        return typeofEquipmentNew3;
    }

    public void setTypeofEquipmentNew3(String typeofEquipmentNew3) {
        this.typeofEquipmentNew3 = typeofEquipmentNew3;
    }

    public String getRbspowerNew3() {
        return rbspowerNew3;
    }

    public void setRbspowerNew3(String rbspowerNew3) {
        this.rbspowerNew3 = rbspowerNew3;
    }

    public String getQuantityNew3() {
        return quantityNew3;
    }

    public void setQuantityNew3(String quantityNew3) {
        this.quantityNew3 = quantityNew3;
    }

    public String getDimensionsNew3() {
        return dimensionsNew3;
    }

    public void setDimensionsNew3(String dimensionsNew3) {
        this.dimensionsNew3 = dimensionsNew3;
    }

    public String getConfigureNew3() {
        return configureNew3;
    }

    public void setConfigureNew3(String configureNew3) {
        this.configureNew3 = configureNew3;
    }

    public String getSectorNew3() {
        return sectorNew3;
    }

    public void setSectorNew3(String sectorNew3) {
        this.sectorNew3 = sectorNew3;
    }

    public String getTypeofEquipmentNew4() {
        return typeofEquipmentNew4;
    }

    public void setTypeofEquipmentNew4(String typeofEquipmentNew4) {
        this.typeofEquipmentNew4 = typeofEquipmentNew4;
    }

    public String getRbspowerNew4() {
        return rbspowerNew4;
    }

    public void setRbspowerNew4(String rbspowerNew4) {
        this.rbspowerNew4 = rbspowerNew4;
    }

    public String getQuantityNew4() {
        return quantityNew4;
    }

    public void setQuantityNew4(String quantityNew4) {
        this.quantityNew4 = quantityNew4;
    }

    public String getDimensionsNew4() {
        return dimensionsNew4;
    }

    public void setDimensionsNew4(String dimensionsNew4) {
        this.dimensionsNew4 = dimensionsNew4;
    }

    public String getConfigureNew4() {
        return configureNew4;
    }

    public void setConfigureNew4(String configureNew4) {
        this.configureNew4 = configureNew4;
    }

    public String getSectorNew4() {
        return sectorNew4;
    }

    public void setSectorNew4(String sectorNew4) {
        this.sectorNew4 = sectorNew4;
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

    public String getEdtques4() {
        return edtques4;
    }

    public void setEdtques4(String edtques4) {
        this.edtques4 = edtques4;
    }

    public String getEdtques5() {
        return edtques5;
    }

    public void setEdtques5(String edtques5) {
        this.edtques5 = edtques5;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
