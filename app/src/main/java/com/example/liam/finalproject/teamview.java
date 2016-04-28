package com.example.liam.finalproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.HashMap;

public class teamview extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private int mParam2;
    private ImageView icon;
    private int wins,loss;
    private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,title,record;
    private TeamData teamData = new TeamData();

    public teamview() {
        // Required empty public constructor
    }


    public static teamview newInstance(int param2) {
        teamview fragment = new teamview();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam2 = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teamview, container, false);
        t1 = (TextView)view.findViewById(R.id.player1);
        t2 = (TextView)view.findViewById(R.id.player2);
        t3 = (TextView)view.findViewById(R.id.player3);
        t4 = (TextView)view.findViewById(R.id.player4);
        t5 = (TextView)view.findViewById(R.id.player5);
        t6 = (TextView)view.findViewById(R.id.player6);
        t7 = (TextView)view.findViewById(R.id.player7);
        t8 = (TextView)view.findViewById(R.id.player8);
        t9 = (TextView)view.findViewById(R.id.player9);
        title = (TextView)view.findViewById(R.id.team);
        icon = (ImageView)view.findViewById(R.id.teamIcon);
        record = (TextView)view.findViewById(R.id.record);
        //Query queryRef = mRef.orderByKey().equalTo(mParam2);

        if (teamData.getSize() == 0){
            teamData.setContext(getActivity());
            Firebase tRef = teamData.getFireBaseRef();
            teamData.initializeDataFromCloud();
            Log.d("teamData size", ""+teamData.getSize());
        }
        Log.d("mparam", mParam2+"");
        HashMap<String, ?>team = teamData.getItem(mParam2);

        //t1.setText((String)team.get("pitcher"));
        //t2.setText((String)team.get("catcher"));
        //t3.setText((String)team.get("first"));

        //team.toString();

        return view;
    }
}
