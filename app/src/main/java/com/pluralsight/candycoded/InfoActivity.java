package com.pluralsight.candycoded;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Locale;

public class InfoActivity extends AppCompatActivity {
//    Uri ad = Uri.parse("http://maps.google.com/maps?saddr=20.344,34.34&daddr=20.5666,45.345");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);

    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    public void createMapIntent(View view) {
        Uri address = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801");
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, address);
        intent.setPackage("com.google.android.apps.maps");
        PackageManager packageManager = getPackageManager();
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent);
        } else {
            Log.d("TAG", "No Intent available to handle action");
        }
    }
    // ***



    // ***
    // TODO - Task 3 - Launch the Phone Activity
    /*public void callPhone(View view) {
        Uri phoneUri = Uri.parse("tel:0123456789");
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(phoneUri);
    }*/

    public void createPhoneIntent(View view) {
        Uri phoneUri = Uri.parse("tel:0123456789");
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(phoneUri);
        startActivity(intent);
    }


    // ***
}
