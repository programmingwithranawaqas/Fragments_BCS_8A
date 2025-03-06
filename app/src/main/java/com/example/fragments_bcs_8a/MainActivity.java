package com.example.fragments_bcs_8a;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    LinearLayout portrait, landscape;
    FragmentManager manager;

    ListFrag listFrag;
    DetailFrag detailFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        init();

        if(portrait!=null)
        {
            // portrait mode
            manager.beginTransaction()
                    .show(listFrag)
                    .hide(detailFrag)
                    .commit();
        }
        else
        {
            // landscape mode
            manager.beginTransaction()
                    .show(listFrag)
                    .show(detailFrag)
                    .commit();
        }

    }

    private  void init()
    {
        landscape = findViewById(R.id.landscape);
        portrait = findViewById(R.id.portrait);
        manager = getSupportFragmentManager();
        listFrag = (ListFrag) manager.findFragmentById(R.id.listfrag);
        detailFrag = (DetailFrag) manager.findFragmentById(R.id.detailfrag);
    }
}