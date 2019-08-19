package com.india.lhq.lqfarmiddleeast.Activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.india.lhq.lqfarmiddleeast.R;
import com.india.lhq.lqfarmiddleeast.constants.CustomClass;
import com.india.lhq.lqfarmiddleeast.fragment.AntennaPlacementInvestigationFragment;
import com.india.lhq.lqfarmiddleeast.fragment.CableInletsFragment;
import com.india.lhq.lqfarmiddleeast.fragment.EquipmentInformationFragment;
import com.india.lhq.lqfarmiddleeast.fragment.EquipmentRoomInvestigationFragment;
import com.india.lhq.lqfarmiddleeast.fragment.GroundingFragment;
import com.india.lhq.lqfarmiddleeast.fragment.HomeFragment;
import com.india.lhq.lqfarmiddleeast.fragment.LocalRegulationFragment;
import com.india.lhq.lqfarmiddleeast.fragment.MaterialTransportHandlingFragment;
import com.india.lhq.lqfarmiddleeast.fragment.PowerBatteryBackupFragment;
import com.india.lhq.lqfarmiddleeast.fragment.SiteAccessFragment;
import com.india.lhq.lqfarmiddleeast.fragment.SiteIdentificationFragment;
import com.india.lhq.lqfarmiddleeast.fragment.SiteInformationFragment;
import com.india.lhq.lqfarmiddleeast.fragment.SitePhotoFragment;
import com.india.lhq.lqfarmiddleeast.fragment.SpecificeSummaryFragment;
import com.india.lhq.lqfarmiddleeast.fragment.TransmissionFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, CustomClass.interfaceCustom {
    private DrawerLayout mDrawerLayout;
    private LinearLayout mDrawerPane;
    private ActionBarDrawerToggle mDrawerToggle;
    Toolbar toolbar;
    private TextView tv_siteidentication;
    private TextView tv_specificesummary;
    private TextView tv_siteinformation;
    private TextView tv_localregulation;
    private TextView tv_siteaccess;

    private TextView tv_materialhandling;
    private TextView tv_equipmentinformation;
    private TextView tv_equipmentroominvestigation;
    private TextView tv_powerbatterbackup;
    private TextView tv_grounding;
    private TextView tv_transmission;
    private TextView tv_cableinlets;
    private TextView tv_antennaplacementinvestigation;
    private TextView tv_sitephotos;

    private LinearLayout linear_siteinformation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_home_frag, new HomeFragment()).commit();
        }
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        navigationdrawer();
        findIds();
        CustomClass.setInterfaceCustom(this);

    }

    private void findIds(){
        tv_siteidentication=(TextView)findViewById(R.id.tv_siteidentication);
        tv_specificesummary=(TextView)findViewById(R.id.tv_specificesummary);

        tv_siteinformation=(TextView)findViewById(R.id.tv_siteinformation);
        tv_localregulation=(TextView)findViewById(R.id.tv_localregulation);
        tv_siteaccess=(TextView)findViewById(R.id.tv_siteaccess);

        tv_materialhandling=(TextView)findViewById(R.id.tv_materialtransporthandling);
        tv_equipmentinformation=(TextView)findViewById(R.id.tv_equipmentinformation);
        tv_equipmentroominvestigation=(TextView)findViewById(R.id.tv_equipmentroominvestigation);
        tv_powerbatterbackup=(TextView)findViewById(R.id.tv_powerbatterybackup);
        tv_grounding=(TextView)findViewById(R.id.tv_grounding);
        tv_transmission=(TextView)findViewById(R.id.tv_transmission);
        tv_cableinlets=(TextView)findViewById(R.id.tv_cableinlets);
        tv_antennaplacementinvestigation=(TextView)findViewById(R.id.tv_antennaplacementinvestigation);
        tv_sitephotos=(TextView)findViewById(R.id.tv_sitephotos);

        linear_siteinformation=(LinearLayout) findViewById(R.id.linear_siteinformation);

        tv_siteidentication.setOnClickListener(this);
        tv_specificesummary.setOnClickListener(this);
        tv_siteinformation.setOnClickListener(this);
        tv_localregulation.setOnClickListener(this);
        tv_siteaccess.setOnClickListener(this);

        tv_materialhandling.setOnClickListener(this);
        tv_equipmentinformation.setOnClickListener(this);
        tv_equipmentroominvestigation.setOnClickListener(this);
        tv_powerbatterbackup.setOnClickListener(this);
        tv_grounding.setOnClickListener(this);
        tv_transmission.setOnClickListener(this);
        tv_cableinlets.setOnClickListener(this);
        tv_antennaplacementinvestigation.setOnClickListener(this);
        tv_sitephotos.setOnClickListener(this);


    }

    private void navigationdrawer() {
        mDrawerPane = (LinearLayout) findViewById(R.id.drawerPane);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        );

    }

    @Override
    public void onClick(View v) {
        if(v == tv_siteidentication){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new SiteIdentificationFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
        }
        if(v == tv_specificesummary){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new SpecificeSummaryFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
        } if(v == tv_siteinformation){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new SiteInformationFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
        }
        if(v == tv_localregulation){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new LocalRegulationFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
        }
        if(v == tv_siteaccess){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new SiteAccessFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
        }
        if(v == tv_materialhandling){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new MaterialTransportHandlingFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
        }
        if(v == tv_equipmentinformation){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new EquipmentInformationFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
        }
        if(v == tv_equipmentroominvestigation){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new EquipmentRoomInvestigationFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
        }
        if(v == tv_powerbatterbackup){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new PowerBatteryBackupFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
        }
        if(v == tv_grounding){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new GroundingFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
        }
        if(v == tv_transmission){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new TransmissionFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
        }
        if(v == tv_cableinlets){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new CableInletsFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
        }
        if(v == tv_antennaplacementinvestigation){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new AntennaPlacementInvestigationFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
        }
        if(v == tv_sitephotos){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new SitePhotoFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);

    }

    @Override
    public void setData(String data) {
        if(data.equals("LOS Survey")){

        }

    }

   /*
   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    */
}
