package com.example.liam.finalproject;

import android.content.Context;
import android.util.Log;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Liam on 4/27/16.
 */
public class TeamData {
    static private String server = "https://diamond-tracker.firebaseio.com/League";
    private Firebase mRef;
    private MyFirebaseRecylerAdapter mAdapter;
    private Context context;
    List<Map<String, ?>> teamData;

    public TeamData(){
        mRef = new Firebase(server);
        teamData = new ArrayList<Map<String, ?>>();
    }
    public void setAdapter(MyFirebaseRecylerAdapter a){ mAdapter = a;}
    public void setContext(Context c){ context = c;}
    public void initializeDataFromCloud(){
        teamData.clear();

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                HashMap<String, ?> team = (HashMap<String, ?>) dataSnapshot.getValue();
                onItemAdded(team);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                HashMap<String, ?> team = (HashMap<String, ?>) dataSnapshot.getValue();
                onItemRemoved(team);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                HashMap<String, ?> team = (HashMap<String, ?>) dataSnapshot.getValue();
                onItemChanged(team);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
    private void onItemAdded(HashMap<String, ?> team){
        Log.d("added", team.toString());
        teamData.add(team);
        if (mAdapter != null){
            mAdapter.notifyDataSetChanged();
        }
    }
    private void onItemRemoved(HashMap team){
        int position = -1;
        String id = (String)team.get("id");

        for (int i = 0; i < teamData.size(); i++){
            HashMap temp = (HashMap) teamData.get(i);
            String mid = (String)temp.get("id");

            if (id.equals(mid)){
                position = i;
                break;
            }
        }
        if (position != -1){
            Log.d("Removed", (String)teamData.get(position).get("name"));
            teamData.remove(position);
            if (mAdapter != null){
                mAdapter.notifyDataSetChanged();
            }
        }
    }
    private void onItemChanged(HashMap team){
        Log.d("changed", team.toString());
    }
    public int getSize(){
        return teamData.size();
    }
    public Firebase getFireBaseRef(){return mRef;}
    public HashMap getItem(int i){
        if (i >=0 && i < teamData.size()){
            return (HashMap) teamData.get(i);
        } else return null;
    }
}
