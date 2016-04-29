package com.example.liam.finalproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link dialogBox.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link dialogBox#newInstance} factory method to
 * create an instance of this fragment.
 */
public class dialogBox extends DialogFragment {

    private String mParam1;
    private String name;

    public dialogBox(){

    }

    public static dialogBox newInstance(String s){
        dialogBox frag = new dialogBox();
        Bundle args = new Bundle();
        args.putString("name",s);
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString("name");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        String text = getArguments().getString("name");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("The " + text +" Won!")
                .setPositiveButton("Return to Home Screen", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(getActivity().getApplicationContext(), AppActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}