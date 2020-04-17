package com.souvik.noteapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.souvik.noteapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    Toolbar mytoolbar;
   ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
                                                                      @Override
                                                                      public void onBackStackChanged() {
                                                                          if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                                                                              getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                                                                          } else {
                                                                              getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                                                                          }
                                                                      }
                                                                  });

        Fragment fragment_account = new DisplayFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.change_layout, fragment_account).commit();

    }


    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:

                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
        @Override
        public void onBackPressed ()
        {

            FragmentManager fm = getSupportFragmentManager();
            if (fm.getBackStackEntryCount() > 0) {
                fm.popBackStack();
            } else {
                super.onBackPressed();
            }
        }



}

