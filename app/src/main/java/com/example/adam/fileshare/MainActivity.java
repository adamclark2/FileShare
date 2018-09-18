package com.example.adam.fileshare;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnLoadImage(View v){
        Log.e("woot", "btnLoadImage!");

        Intent i = new Intent();
        i.setType("image/*");
        i.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        i.setAction(Intent.ACTION_GET_CONTENT);


        Intent chooseImg = Intent.createChooser(i, "Select Image");
        startActivityForResult(chooseImg, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            // Pick img...
            Log.e("Got img", "Got img");

            if(data.getClipData() != null) {
                for (int i = 0; i < data.getClipData().getItemCount(); i++) {
                    Log.e("Title", "" + data.getClipData().getItemAt(i).getUri().getPath());
                }
            }else{
                Log.e("Title", "" + data.getData().getPath());
            }

        }
    }
}
