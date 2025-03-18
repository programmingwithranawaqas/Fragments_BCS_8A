package com.example.fragments_bcs_8a;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.OnContactNameClicked {

    ArrayList<Contact> contacts;

    LinearLayout portrait, landscape;
    FragmentManager manager;

    // hooks of detail fragment views
    TextView tvPhone, tvName, tvAddress;
    View viewOfDetailFragment;

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
        viewOfDetailFragment = detailFrag.getView();

        tvPhone = viewOfDetailFragment.findViewById(R.id.tvPhoneNumber);
        tvName = viewOfDetailFragment.findViewById(R.id.tvName);
        tvAddress = viewOfDetailFragment.findViewById(R.id.tvAddress);

        contacts = new ArrayList<>();
        contacts.add(new Contact("Waqas","333","444"));
        contacts.add(new Contact("Ali Raza","222","333"));
        contacts.add(new Contact("Muzammil hussain","111","222"));
        contacts.add(new Contact("Kashif Zafar","000","111"));
        contacts.add(new Contact("Kashif Zafar","000","111"));
        contacts.add(new Contact("Kashif Zafar","000","111"));
        contacts.add(new Contact("Kashif Zafar","000","111"));
        contacts.add(new Contact("Kashif Zafar","000","111"));
        contacts.add(new Contact("Kashif Zafar","000","111"));

        onContactNameItemClicked(0);
    }

    @Override
    public void onContactNameItemClicked(int position) {
        Contact contact = contacts.get(position);
        tvAddress.setText(contact.getAddress());
        tvPhone.setText(contact.getPhone());
        tvName.setText(contact.getName());

        if(portrait!=null)
        {
            // portrait mode
            manager.beginTransaction()
                    .hide(listFrag)
                    .show(detailFrag)
                    .addToBackStack(null)
                    .commit();
        }

    }
}