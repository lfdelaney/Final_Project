package com.example.liam.finalproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlayerCard.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlayerCard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayerCard extends Fragment {

    private OnFragmentInteractionListener mListener;

    public PlayerCard() {
        // Required empty public constructor
    }

    public static PlayerCard newInstance() {
        PlayerCard fragment = new PlayerCard();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_card, container, false);

        TextView name = (TextView) view.findViewById(R.id.playerName);
        TextView team = (TextView) view.findViewById(R.id.teamName);
        TextView position = (TextView) view.findViewById(R.id.position);

        name.setText("Mookie Betts");
        team.setText("Boston Red Sox");
        position.setText("Right Field");

        return view;
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

    }
}
