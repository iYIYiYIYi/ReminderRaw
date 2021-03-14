package com.clarques.reminderraw.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;

import com.clarques.reminderraw.R;
import com.clarques.reminderraw.items.plan_fragment;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private RadioGroup bottom;

    private HashMap<Integer,Fragment> fragments = new HashMap<>();

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.MainContainer,fragment);
        transaction.commit();
    }

    private void setFragment(int id) {
        Log.d("clicked:","id:"+id);
        if (fragments.containsKey(id)) {
            replaceFragment(fragments.get(id));
        } else {
            Fragment fragment;
            switch (id) {
                //底部选择栏，选中了TODO页面
                case R.id.plan_bottom :{
                    fragment = new plan_fragment();
                    break;
                }
                default: {
                    fragment = new plan_fragment();
                    break;
                }
            }
            fragments.put(id,fragment);
            replaceFragment(fragment);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottom = (RadioGroup) findViewById(R.id.bottom_navigation);
        bottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                setFragment(checkedId);
                Log.d("clicked:","id:"+checkedId);
            }
        });

        setFragment(bottom.getCheckedRadioButtonId());
    }
}