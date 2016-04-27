package com.example.liam.finalproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ShareActionProvider;
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

import com.firebase.client.Firebase;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link recycler_view.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link recycler_view#newInstance} factory method to
 * create an instance of this fragment.
 */
public class recyclerview extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ShareActionProvider mShareActionProvider;
    private RecyclerView rview;
    private android.support.v7.widget.Toolbar toolbar;
    private ImageView imageView;
    private MyFirebaseRecylerAdapter fireAdapter;
    private LinearLayoutManager llm;
    final Firebase ref = new Firebase("https://diamond-tracker.firebaseio.com/League/");



    public recyclerview() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment recyclerView.
     */
    // TODO: Rename and change types and number of parameters
    public static recyclerview newInstance() {
        recyclerview fragment = new recyclerview();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        View newView = inflater.inflate(R.layout.card_layout, container, false);

        rview =(RecyclerView) rootview.findViewById(R.id.cardList);
        fireAdapter = new MyFirebaseRecylerAdapter(Team.class, R.layout.card_layout,MyFirebaseRecylerAdapter.TeamViewHolder.class, ref, getActivity());
        rview.setHasFixedSize(true);
        llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rview.setLayoutManager(llm);
        rview.setAdapter(fireAdapter);
        imageView = (ImageView) newView.findViewById(R.id.cardClick);


        fireAdapter.SetOnItemClickListener(new MyFirebaseRecylerAdapter.onItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity().getApplicationContext(), "Clicked Card Item", Toast.LENGTH_LONG).show();
                //HashMap<String, ?> mov = (HashMap<String, ?>) movieData.getItem(position) ;
                //mListener.onListItemSelected(position, mov);
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
                                Team cloud = fireAdapter.getItem(position);
                                //cloud.setName(cloud.getName() + "-New");
                                //cloud.setId(cloud.getId() + "-New");
                                //ref.child(cloud.getId()).setValue(cloud);
                                return true;
                            case R.id.deleteItem:
                                Team cloudDelete = fireAdapter.getItem(position);
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


        return rootview;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListItemSelected(int x, HashMap<String, ?> book);
    }
}
