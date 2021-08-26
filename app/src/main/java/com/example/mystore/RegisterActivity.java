package com.example.mystore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class RegisterActivity extends AppCompatActivity {
    private FrameLayout frameLayout;

    public static boolean setsignupfragment=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        frameLayout=findViewById(R.id.frame);

        if(setsignupfragment)
        {
            setsignupfragment=false;
            setFragment(new SignUpFragment());
        }
        else {
            setFragment(new SignInFragment());
        }



    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}