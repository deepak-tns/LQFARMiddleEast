package com.india.lhq.lqfarmiddleeast.Activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.india.lhq.lqfarmiddleeast.Database.DatabaseHandler;
import com.india.lhq.lqfarmiddleeast.Database.EquipmentInformationData;
import com.india.lhq.lqfarmiddleeast.R;
import com.india.lhq.lqfarmiddleeast.Utils.AppSingleton;
import com.india.lhq.lqfarmiddleeast.Utils.SharedPreferenceUtils;
import com.india.lhq.lqfarmiddleeast.constants.AppConstants;
import com.india.lhq.lqfarmiddleeast.constants.Validator;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.india.lhq.lqfarmiddleeast.constants.AppConstants.ALERT_TYPE_NO_NETWORK;


public class LoginActivity extends AppCompatActivity {
    String[] permissions = {
            "android.permission.ACCESS_FINE_LOCATION",
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE",
            "android.permission.READ_SMS",
            "android.permission.RECEIVE_SMS",
            "android.permission.READ_PHONE_STATE",
            "android.permission.CAMERA"
    };
    public static final int MULTIPLE_PERMISSIONS = 10;
    private String emino;
    private EditText edt_loginid;
    private EditText edt_password;
    private Button btn_login;
    private TextView tvimeno;
    private SharedPreferenceUtils sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        checkPermissions();
        findIds();
        //JSonobjParameter("18459","18459");

    }

   /* public  String getIMEINumber(Context context) {
        String tmDeviceId;
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
             tmDeviceId = tm.getDeviceId();
        }else{
             tmDeviceId = tm.getDeviceId();
        }

        return tmDeviceId;
    }*/

    public  String getIMEINumber(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return "";
            }
            String imei = telephonyManager.getDeviceId();
            Log.e("imei", "=" + imei);
            if (imei != null && !imei.isEmpty()) {
                return imei;
            } else {
                return android.os.Build.SERIAL;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "not_found";
    }



    private void findIds() {

        tvimeno =(TextView) findViewById(R.id.tvimeno);
        tvimeno.setText(" 11May2019 "+getIMEINumber(LoginActivity.this)+"");

        edt_loginid = findViewById(R.id.editEmail);
        edt_password = findViewById(R.id.editPassword);
        btn_login = findViewById(R.id.buttonLogin);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emino = getIMEINumber(LoginActivity.this);
                Log.v("imeno", emino);
              //  Toast.makeText(getApplicationContext(), emino +"K", Toast.LENGTH_SHORT).show();
                validatelogin();
            }
        });
      //   ( (TextView)  findViewById(R.id.tvimeno)).setText(getIMEINumber(LoginActivity.this));
      //    getnotificationcount();
    }

    private void validatelogin() {
        if (Validator.isNetworkAvailable(this)) {
            if (isMandatoryFields()) {
                // toHideKeyboard();
                //initLoginModel();
                toLogin(edt_loginid.getText().toString(), edt_password.getText().toString());
               // startActivity(new Intent(this, MainActivity.class));
            }
        } else {
            alert(this, getString(R.string.alert_message_no_network), getString(R.string.alert_message_no_network), getString(R.string.labelOk), getString(R.string.labelCancel), false, false, ALERT_TYPE_NO_NETWORK);

        }
    }

    private boolean isMandatoryFields() {
        edt_loginid.setError(null);
        edt_password.setError(null);
        if (edt_loginid.getText().toString().equals("")) {
            edt_loginid.requestFocus();
            edt_loginid.setError("Enter LoginID");
            return false;
        } else if (edt_password.getText().toString().isEmpty()) {
            edt_password.requestFocus();
            edt_password.setError(getResources().getString(R.string.error_password_empty));
            return false;
        }

        return true;
    }

    public void alert(Context context, String title, String message, String positiveButton, String negativeButton, boolean isNegativeButton, boolean isTitle, final int alertType) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (isTitle) {
            builder.setTitle(title);
        }

        builder.setMessage(message);
        builder.setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        if (isNegativeButton) {
            builder.setNegativeButton(negativeButton, null);
        }
        builder.show();
    }

    private void toLogin(String empId, String empPassword) {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.VERIFYLOGINURL, JSonobjParameter(empId, empPassword),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponse(response);
                        Log.v("login response", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("login response error", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(this).addToRequestQueue(jsonObjReq, null);
    }


    private void parseSettingResponse(JSONArray response) {
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");

            if (status.equals("1")) {
                finish();
                startActivity(new Intent(this, MainActivity.class));
                sharedPreferences = SharedPreferenceUtils.getInstance();
                sharedPreferences.setContext(getApplicationContext());
                sharedPreferences.putString(AppConstants.EMPID, edt_loginid.getText().toString());

            } else {
               // startActivity(new Intent(this, MainActivity.class));
                Toast.makeText(this, "Invalid loginid or passsword", Toast.LENGTH_SHORT).show();

            }
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private JSONObject JSonobjParameter(String loginname, String password) {
        JSONObject jsonObject = new JSONObject();
        try {

       /* JSONArray jsonArrayParameter = new JSONArray();
          jsonArrayParameter.put(loginname);
          jsonArrayParameter.put(password);*/

            //jsonObject.put( "SqlQuery","select top 1 * from tbl_opreg");

            // jsonObject.put("DatabaseName", "TNS_HR");
            //  jsonObject.put("ServerName", "bkp-server");
            //  jsonObject.put("UserId", "sanjay");
            // jsonObject.put("Password", "tnssoft");
            //  jsonObject.put("spName", "USP_login");

            jsonObject.put("LoginId", loginname);
            jsonObject.put("password", password);
            jsonObject.put("imeno", emino);

        Log.v("imeno",emino);
            // jsonObject.put("ParameterList",jsonArrayParameter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    private  boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p:permissions)
        {
            result = ContextCompat.checkSelfPermission(this,p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty())
        {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),MULTIPLE_PERMISSIONS );
            return false;
        }
        return true;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MULTIPLE_PERMISSIONS:{
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                } else
                {
                    // no permissions granted.
                    Toast.makeText(this, "permission not Granted", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    private void getnotificationcount() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://13.229.8.149/wmsapiinv/api/login/GetDashboard",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response == null) {

                        } else {
                            String s = response.trim();
                            System.out.println("msgmainactivity:::" + s);
                            Log.v("data",response);

                            try {
                                JSONArray mJsonArray = new JSONArray(s);
                                JSONObject mJsonObject = mJsonArray.getJSONObject(0);
                                String dashtatus = mJsonObject.getString("dashboardstatus");
                                String inward = mJsonObject.getString("inward");

                             //   Log.v("data",dashtatus);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.error_invalid_email_id), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("projectcode","DICWHR1800000");
                params.put("whcode", "WHSHA01");
                params.put("empcode", "OPS1103");
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                //params.put("Content-Type", "application/json");
                // params.put("Synchronized32!_89ioHeader", "Synchronized75!_89ioAppid:Synchronized75!_89ioAppkey");
                return params;
            }
        };

        AppSingleton.getInstance(this).addToRequestQueue(stringRequest, null);

    }



}
