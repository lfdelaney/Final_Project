package com.example.liam.finalproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link rosterfragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link rosterfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class rosterfragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private Bundle mParam1;
    private TextView lf,rf,cf,first,second,third,ss,ca,pi;

    public rosterfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment rosterfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static rosterfragment newInstance(Bundle team) {
        rosterfragment fragment = new rosterfragment();
        Bundle args = new Bundle();
        args.putBundle("team",team);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getBundle("team");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rosterfragment, container, false);
        lf = (TextView)view.findViewById(R.id.player1);
        lf.setText((String)mParam1.get("leftField"));

        cf = (TextView)view.findViewById(R.id.player2);
        cf.setText((String)mParam1.get("centerField"));

        rf = (TextView)view.findViewById(R.id.player3);
        rf.setText((String)mParam1.get("rightField"));

        ss = (TextView)view.findViewById(R.id.player4);
        ss.setText((String)mParam1.get("shortStop"));

        third = (TextView)view.findViewById(R.id.player5);
        third.setText((String)mParam1.get("third"));

        second = (TextView)view.findViewById(R.id.player6);
        second.setText((String)mParam1.get("second"));

        first = (TextView)view.findViewById(R.id.player7);
        first.setText((String)mParam1.get("first"));

        pi = (TextView)view.findViewById(R.id.player8);
        pi.setText((String)mParam1.get("pitcher"));

        ca = (TextView)view.findViewById(R.id.player9);
        ca.setText((String)mParam1.get("catcher"));


        return view;
    }
}
