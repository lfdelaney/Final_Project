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
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link teamview.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link teamview#newInstance} factory method to
 * create an instance of this fragment.
 */
public class teamview extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private int mParam2;
    private ImageView icon;
    private int wins,loss;
    private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,title,record;
    private Firebase ref = new Firebase("https://diamond-tracker.firebasio.com/League");
   // private String serv = "https://diamond-tracker.firebasio.com/League";

    public teamview() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment teamview.
     */
    // TODO: Rename and change types and number of parameters
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

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d("snapshotadded: ", dataSnapshot.toString());
                HashMap<String, ?> temp = (HashMap<String, ?>) dataSnapshot.getValue();
                String flag = (String)temp.get("key");

                title.setText((String)temp.get("name"));
                Picasso.with(getContext()).load((String)temp.get("url")).into(icon);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.d("snapshotchanged: ", dataSnapshot.toString());
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        return view;
    }
}
