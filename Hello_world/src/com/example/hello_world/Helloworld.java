package com.example.hello_world;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Helloworld extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helloworld);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_helloworld, menu);
        return true;
    }
}
