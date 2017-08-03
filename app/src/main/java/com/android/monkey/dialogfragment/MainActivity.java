package com.android.monkey.dialogfragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Button btnShowSmallDialog = (Button) findViewById(R.id.btn_show_small_dialog);
        btnShowSmallDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSmallDialogFragment();
            }
        });
        Button btnShowBigDialog = (Button) findViewById(R.id.btn_show_big_dialog);
        btnShowBigDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBigDialogFragment();
            }
        });
    }

    private void showBigDialogFragment() {
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.rl_root,myDialogFragment,MyDialogFragment.TAG);
        transaction.addToBackStack(MyDialogFragment.TAG);
        transaction.commit();
    }

    private void showSmallDialogFragment() {
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        myDialogFragment.show(getSupportFragmentManager(),MyDialogFragment.TAG);
        //myDialogFragment.show(getSupportFragmentManager().beginTransaction(),MyDialogFragment.TAG);
    }
}
