package com.msr.barcodedemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.msr.barcodedemo.R;


public class MainActivity extends AppCompatActivity {

    private static int BAR_CODE_TRACKER_ACTIVITY;
    private ImageButton mCameraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCameraButton = (ImageButton) findViewById(R.id.cameraButton);
        mCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBarcodeTrackerActivity();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BAR_CODE_TRACKER_ACTIVITY && resultCode == RESULT_OK) {
            String barcode = data.getExtras().getString("barcode");
            Toast.makeText(this, String.valueOf(barcode), Toast.LENGTH_SHORT).show();
        }
    }

    private void startBarcodeTrackerActivity() {
        Intent barCodeTrackerIntent = new Intent(this, BarcodeTrackerActivity.class);
        startActivityForResult(barCodeTrackerIntent, BAR_CODE_TRACKER_ACTIVITY);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

}
