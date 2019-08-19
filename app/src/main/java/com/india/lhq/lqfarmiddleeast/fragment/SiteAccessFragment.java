package com.india.lhq.lqfarmiddleeast.fragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.india.lhq.lqfarmiddleeast.Activity.CameraSurfaceViewActivity;
import com.india.lhq.lqfarmiddleeast.Database.DatabaseHandler;
import com.india.lhq.lqfarmiddleeast.Database.SiteAccessData;
import com.india.lhq.lqfarmiddleeast.R;
import com.india.lhq.lqfarmiddleeast.constants.GoogleGPSService;

import java.io.ByteArrayOutputStream;

import static android.app.Activity.RESULT_CANCELED;
import static com.india.lhq.lqfarmiddleeast.constants.BitmapEncodedDecoded.encodeToBase64;

/**
 * A simple {@link Fragment} subclass.
 */
public class SiteAccessFragment extends Fragment implements View.OnClickListener {
    private TextView tv_count_previous, tv_count_after;
    private Button btn_save, btn_next;

    private EditText edt_propertycontactrefrence;
    private EditText edt_parkingarea;
    private EditText edt_siteaccessibility;
    private EditText edt_markonthemap;
    private EditText edt_noteroaddescription;
    private EditText edt_visitorneed;
    private EditText edt_workinghourres;
    private EditText edt_othersiteaccess;
    private EditText edt_photographyallowed;

    private ImageView iv_propertycontactrefrence;
    private ImageView iv_parkingarea;
    private ImageView iv_siteaccessibility;
    private ImageView iv_markonthemap;
    private ImageView iv_noteroaddescription;
    private ImageView iv_visitorneed;
    private ImageView iv_workinghourres;
    private ImageView iv_othersiteaccess;
    private ImageView iv_photographyallowed;

    private ImageButton ib_propertycontactrefrence;
    private ImageButton ib_parkingarea;
    private ImageButton ib_siteaccessibility;
    private ImageButton ib_markonthemap;
    private ImageButton ib_noteroaddescription;
    private ImageButton ib_visitorneed;
    private ImageButton ib_workinghourres;
    private ImageButton ib_othersiteaccess;
    private ImageButton ib_photographyallowed;

    private String img_propertycontactrefrence = "";
    private String img__parkingarea = "";
    private String img__siteaccessibility = "";
    private String img__markonthemap = "";
    private String img__noteroaddescription = "";
    private String img__visitorneed = "";
    private String img__workinghourres = "";
    private String img__othersiteaccess = "";
    private String img__photographyallowed = "";

    private DatabaseHandler db;
    private String lat, log, time;


    public SiteAccessFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_site_access, container, false);
        db = new DatabaseHandler(getActivity());
        findIds(v);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time = DateFormat.format("dd-MM-yyyy h:mm:ss:aa", System.currentTimeMillis()).toString();
                handler.postDelayed(this, 1000);
            }

        }, 1000);

        tv_count_previous.setText(tv_count_previous.getText().toString()+db.getCountSiteAccess()+"");

        if(db.getCountSiteAccess()> 2){
            db.deleteSomeRow_SiteAccess();
        }
        return v;
    }

    private void findIds(View v) {
        tv_count_previous = v.findViewById(R.id.tv_count_previous);
        tv_count_after = v.findViewById(R.id.tv_count_after);
        btn_next = v.findViewById(R.id.btn_next);
        btn_save = v.findViewById(R.id.btn_save);

        edt_parkingarea = v.findViewById(R.id.edt_parkingarea);
        edt_siteaccessibility = v.findViewById(R.id.edt_siteaccessibility);
        edt_markonthemap = v.findViewById(R.id.edt_markonthemap);
        edt_noteroaddescription = v.findViewById(R.id.edt_noteroaddescription);
        edt_visitorneed = v.findViewById(R.id.edt_visitorneed);
        edt_workinghourres = v.findViewById(R.id.edt_workinghourres);
        edt_othersiteaccess = v.findViewById(R.id.edt_othersiteaccess);
        edt_photographyallowed = v.findViewById(R.id.edt_photographyallowed);
        edt_propertycontactrefrence = v.findViewById(R.id.edt_propertycontactrefrence);

        iv_parkingarea = v.findViewById(R.id.iv_parkingarea);
        iv_siteaccessibility = v.findViewById(R.id.iv_siteaccessibility);
        iv_markonthemap = v.findViewById(R.id.iv_markonthemap);
        iv_noteroaddescription = v.findViewById(R.id.iv_noteroaddescription);
        iv_visitorneed = v.findViewById(R.id.iv_visitorneed);
        iv_workinghourres = v.findViewById(R.id.iv_workinghourres);
        iv_othersiteaccess = v.findViewById(R.id.iv_othersiteaccess);
        iv_photographyallowed = v.findViewById(R.id.iv_photographyallowed);
        iv_propertycontactrefrence = v.findViewById(R.id.iv_propertycontactrefrence);

        ib_parkingarea = v.findViewById(R.id.img_parkingarea);
        ib_siteaccessibility = v.findViewById(R.id.img_siteaccessibility);
        ib_markonthemap = v.findViewById(R.id.img_markonthemap);
        ib_noteroaddescription = v.findViewById(R.id.img_noteroaddescription);
        ib_visitorneed = v.findViewById(R.id.img_visitorneed);
        ib_workinghourres = v.findViewById(R.id.img_workinghourres);
        ib_othersiteaccess = v.findViewById(R.id.img_othersiteaccess);
        ib_photographyallowed = v.findViewById(R.id.img_photographyallowed);
        ib_propertycontactrefrence = v.findViewById(R.id.img_propertycontactrefrence);
        btn_save.setOnClickListener(this);
        btn_next.setOnClickListener(this);

/*
        iv_parkingarea.setOnClickListener(this);
        iv_siteaccessibility.setOnClickListener(this);
        iv_markonthemap.setOnClickListener(this);
        iv_noteroaddescription.setOnClickListener(this);
        iv_visitorneed.setOnClickListener(this);
        iv_workinghourres.setOnClickListener(this);
        iv_othersiteaccess.setOnClickListener(this);
        iv_photographyallowed.setOnClickListener(this);
*/
        ib_parkingarea.setOnClickListener(this);
        ib_siteaccessibility.setOnClickListener(this);
        ib_markonthemap.setOnClickListener(this);
        ib_noteroaddescription.setOnClickListener(this);
        ib_visitorneed.setOnClickListener(this);
        ib_workinghourres.setOnClickListener(this);
        ib_othersiteaccess.setOnClickListener(this);
        ib_photographyallowed.setOnClickListener(this);
        ib_propertycontactrefrence.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view == ib_parkingarea) {
            selectImage("1");
        }
        if (view == ib_siteaccessibility) {

            selectImage("2");
        }
        if (view == ib_markonthemap) {
            selectImage("3");
        }
        if (view == ib_noteroaddescription) {
            selectImage("4");
        }
        if (view == ib_visitorneed) {

            selectImage("5");
        }
        if (view == ib_workinghourres) {

            selectImage("6");
        }
        if (view == ib_othersiteaccess) {

            selectImage("7");
        }
        if (view == ib_photographyallowed) {

            selectImage("8");
        }
        if (view == ib_propertycontactrefrence) {

            selectImage("9");
        }

        if (view == btn_save) {

            db.insertSiteAccess(new SiteAccessData( edt_propertycontactrefrence.getText().toString(),  edt_parkingarea.getText().toString(),  edt_siteaccessibility.getText().toString(),  edt_markonthemap.getText().toString(),  edt_noteroaddescription.getText().toString(),  edt_visitorneed.getText().toString(),  edt_workinghourres.getText().toString(),  edt_othersiteaccess.getText().toString(),  edt_photographyallowed.getText().toString(),  img_propertycontactrefrence,  img__parkingarea,  img__siteaccessibility,  img__markonthemap,  img__noteroaddescription,  img__visitorneed,  img__workinghourres,  img__othersiteaccess,  img__photographyallowed,  1));

            tv_count_after.setText(db.getCountSiteAccess()+"");

            Toast.makeText(getActivity(), "All record has been Successfully", Toast.LENGTH_SHORT).show();
        }
        if (view == btn_next) {

            getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new MaterialTransportHandlingFragment()).addToBackStack(null).commit();
        }


    }

    private void selectImage(String Value) {

        if (Value.equals("1")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 1);
            startActivityForResult(i, 1);
        }
        if (Value.equals("2")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 2);
            startActivityForResult(i, 2);

        }
        if (Value.equals("3")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 3);
            startActivityForResult(i, 3);
        }
        if (Value.equals("4")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 4);
            startActivityForResult(i, 4);
        }
        if (Value.equals("5")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 5);
            startActivityForResult(i, 5);
        }
        if (Value.equals("6")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 6);
            startActivityForResult(i, 6);
        }
        if (Value.equals("7")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 7);
            startActivityForResult(i, 7);
        }
        if (Value.equals("8")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 8);
            startActivityForResult(i, 8);
        }
        if (Value.equals("9")) {

            Intent i = new Intent(getActivity(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 9);
            startActivityForResult(i, 9);
        }


    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            //  Log.v("logtest", data.getStringExtra("path")+","+requestCode);
            if (requestCode == 1) {
                // onCaptureImageResult(data, "1");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "1", angle);
            }
            if (requestCode == 2) {
                // onCaptureImageResult(data, "2");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "2", angle);
            }
            if (requestCode == 3) {
                //  onCaptureImageResult(data, "3");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "3", angle);
            }
            if (requestCode == 4) {
                // onCaptureImageResult(data, "4");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "4", angle);
            }
            if (requestCode == 5) {
                //  onCaptureImageResult(data, "5");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "5", angle);
            }
            if (requestCode == 6) {
                //   onCaptureImageResult(data, "6");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "6", angle);
            }
            if (requestCode == 7) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "7", angle);
            }
            if (requestCode == 8) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "8", angle);
            }
            if (requestCode == 9) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "9", angle);
            }

        }
    }

    private void onCameraSurfaceViewActivity(String thumbnail, String name, String angle) {

        if (name.equals("1")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_parkingarea.setImageBitmap(out);
                img__parkingarea = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img__parkingarea);
            }
        }
        if (name.equals("2")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_siteaccessibility.setImageBitmap(out);
                //  imgBearing30 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img__siteaccessibility = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img__siteaccessibility);
            }
        }
        if (name.equals("3")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_markonthemap.setImageBitmap(out);
                //  imgBearing60 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img__markonthemap = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img__markonthemap);
            }
        }
        if (name.equals("4")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_noteroaddescription.setImageBitmap(out);
                //   imgBearing90 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img__noteroaddescription = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img__noteroaddescription);
            }
        }

        if (name.equals("5")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_visitorneed.setImageBitmap(out);
                //  imgBearing120 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img__visitorneed = thumbnail;
                Log.v("img-encode", img__visitorneed);
            }
        }
        if (name.equals("6")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_workinghourres.setImageBitmap(out);
                //    imgBearing150 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img__workinghourres = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img__workinghourres);
            }
        }
        if (name.equals("7")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_othersiteaccess.setImageBitmap(out);
                //     imgBearing180 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img__othersiteaccess = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img__othersiteaccess);
            }
        }
        if (name.equals("8")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_photographyallowed.setImageBitmap(out);
                //    imgBearing150 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img__photographyallowed = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img__photographyallowed);
            }

        }
        if (name.equals("9")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_propertycontactrefrence.setImageBitmap(out);
                //    imgBearing150 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_propertycontactrefrence = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_propertycontactrefrence);
            }

        }
    }

    public static String encodeToBase64(Bitmap image, Bitmap.CompressFormat compressFormat, int quality) {
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        image.compress(compressFormat, quality, byteArrayOS);
        return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);
    }

    public static Bitmap decodeBase64(String input) {
        byte[] decodedBytes = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }

    @Override
    public void onResume() {
        super.onResume();
        //  GPSTracker.BUS.register(this);
        getActivity().registerReceiver(broadcastReceiver, new IntentFilter(GoogleGPSService.BROADCAST_ACTION));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            getActivity().unregisterReceiver(broadcastReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // mContact = (Contact)getIntent().getExtras().getSerializable(EXTRA_CONTACT);
            lat = intent.getStringExtra("LAT");
            log = intent.getStringExtra("LOG");

            //   Toast.makeText(getActivity(), "Lat : "+lat+","+ "Long : "+ log, Toast.LENGTH_LONG).show();
        }


    };
}
