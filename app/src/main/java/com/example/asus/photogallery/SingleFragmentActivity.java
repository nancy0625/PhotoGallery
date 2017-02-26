package com.example.asus.photogallery;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ASUS on 2016/11/26.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity{
    protected abstract Fragment createFragment();
    @LayoutRes
    protected int getLayoutResId(){
        return R.layout.activity_fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragment);
        setContentView(getLayoutResId());
        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null){
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }


    }
}