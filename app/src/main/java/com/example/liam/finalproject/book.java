package com.example.liam.finalproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.client.Firebase;


public class book extends Fragment {
    private static final String PARAM1 = "key";
    private static final String FIREBASEREF = "https://diamond-tracker.firebaseio.com/";
    private String mParam1;
    private Firebase firebaseRef;

    private OnFragmentInteractionListener mListener;

    public book() {
        // Required empty public constructor
    }

    public static book newInstance(String param1) {
        Log.d("book", "called");
        book fragment = new book();
        Bundle args = new Bundle();
        args.putString(PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Firebase.setAndroidContext(getContext());

        Log.d("book", "onCreate");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(PARAM1);
        }
        firebaseRef = new Firebase(FIREBASEREF);
        Firebase mRef = firebaseRef.child("users").child(mParam1);

        if(mRef.child("team") == null){
            Log.d("team", "null");
//            createTeam();
        }
        else{
            Log.d("team", "not null");
//            pullTeam();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
