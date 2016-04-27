package com.example.liam.finalproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.HashMap;



public class recyclerview extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private int mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ShareActionProvider mShareActionProvider;
    private RecyclerView rview;
    private android.support.v7.widget.Toolbar toolbar;
    private MyFirebaseRecylerAdapter fireAdapter;
    private LinearLayoutManager llm;
    private TeamData teamData = new TeamData();


    public recyclerview() {
        // Required empty public constructor
    }


    public static recyclerview newInstance() {
        Log.d("newInstance", "enter");
        recyclerview fragment = new recyclerview();
        Log.d("newInstance", "exit");
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("onCreate", "enter");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        Log.d("onCreate", "exit");
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("onCreateView", "enter");
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        View newView = inflater.inflate(R.layout.card_layout, container, false);

        rview =(RecyclerView) rootview.findViewById(R.id.cardList);
        final Firebase ref = new Firebase("https://diamond-tracker.firebaseio.com/League");
        fireAdapter = new MyFirebaseRecylerAdapter(Team.class, R.layout.card_layout,MyFirebaseRecylerAdapter.TeamViewHolder.class, ref, getActivity());
        rview.setHasFixedSize(true);
        llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rview.setLayoutManager(llm);
        rview.setAdapter(fireAdapter);

        if(teamData.getSize() == 0){
            teamData.setAdapter(fireAdapter);
            teamData.setContext(getActivity());
            teamData.initializeDataFromCloud();
        }

        fireAdapter.SetOnItemClickListener(new MyFirebaseRecylerAdapter.onItemClickListener() {

            @Override
            public void onItemClick(View view, final int position) {
                HashMap<String, ?>team = teamData.getItem(position);
                String id = (String)team.get("id");
                Firebase ref = teamData.getFireBaseRef();
                ref.child("Team " + id).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        HashMap<String, ?> team = (HashMap<String, ?>) dataSnapshot.getValue();
                        String id = (String) team.get("id");
                        Toast.makeText(getActivity().getApplicationContext(), "Clicked Team " + id, Toast.LENGTH_LONG).show();
                        mListener.onListItemSelected(position);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        Log.d("Error", "The Error reads" + firebaseError.getMessage());
                    }
                });
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(getActivity().getApplicationContext(), "Long Clicked Card Item", Toast.LENGTH_LONG).show();
                //getActivity().startActionMode(new ActionBarCall(position, movieData, fireAdapter));
            }


            @Override
            public void onOverflowMenuClick(View v,final int position){
                PopupMenu popupMenu = new PopupMenu(getActivity(), v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.duplicateItem:
                                //Team cloud = fireAdapter.getItem(position);
                                //cloud.setName(cloud.getName() + "-New");
                                //cloud.setId(cloud.getId() + "-New");
                                //ref.child(cloud.getId()).setValue(cloud);
                                return true;
                            case R.id.deleteItem:
                                //Team cloudDelete = fireAdapter.getItem(position);
                                //ref.child(cloudDelete.getId()).removeValue();
                                //movieData.removeItem(position);
                                //myAdapter.notifyItemRemoved(position);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                MenuInflater inflater1 = popupMenu.getMenuInflater();
                inflater1.inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.show();
            }

        });

        Log.d("onCreateView", "exit");
        return rootview;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
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
        void onListItemSelected(int x);
    }
}
