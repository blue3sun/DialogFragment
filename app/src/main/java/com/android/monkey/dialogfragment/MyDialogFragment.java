package com.android.monkey.dialogfragment;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowAnimationFrameStats;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Description:对话框
 * Author: Lanjing
 * Time: 2016/11/25 15:44
 */
public class MyDialogFragment extends DialogFragment {
    public final static String TAG = MyDialogFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.my_dialog_fragment2,null);
        final EditText etInfo = (EditText)view.findViewById(R.id.et_info);
        Button btnSure = (Button) view.findViewById(R.id.btn_sure);
        Button btnCancel = (Button) view.findViewById(R.id.btn_cancel);
        btnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),etInfo.getText(), Toast.LENGTH_LONG).show();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.my_dialog_fragment1,null);
        final EditText etInfo = (EditText)view.findViewById(R.id.et_info);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setPositiveButton("sure", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(),etInfo.getText(),Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       dismiss();
                    }
                });
        return builder.create();
    }
}
