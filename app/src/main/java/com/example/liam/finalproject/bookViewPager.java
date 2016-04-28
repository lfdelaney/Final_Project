package com.example.liam.finalproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link bookViewPager.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link bookViewPager#newInstance} factory method to
 * create an instance of this fragment.
 */
public class bookViewPager extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int mParam1;
    private int mParam2;

    private OnFragmentInteractionListener mListener;

    public bookViewPager() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment bookViewPager.
     */
    // TODO: Rename and change types and number of parameters
    public static bookViewPager newInstance() {
        bookViewPager fragment = new bookViewPager();
        Bundle args = new Bundle();
        //args.putInt(ARG_PARAM1, param1);
        //args.putInt(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book_view_pager, container, false);


        return view;
    }

    @Override
    public void onAttach(Context context) {
        Log.d("onAttach", "enter");
        super.onAttach(context);

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        Log.d("onAttach", "exit");
    }
    @Override
    public void onDetach() {
        Log.d("onDetach", "enter");
        super.onDetach();
        mListener = null;
        Log.d("onDetach", "exit");
    }

    public interface OnFragmentInteractionListener {
        void onImageButtonClicked();
    }
}
