package com.example.liam.finalproject;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;


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
    ImageButton img1,img2,img3,img4,img5,img6,img7,img8,img9;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;

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

        img1 = (ImageButton)view.findViewById(R.id.diamond1);
        img2 = (ImageButton)view.findViewById(R.id.diamond2);
        img3 = (ImageButton)view.findViewById(R.id.diamond3);
        img4 = (ImageButton)view.findViewById(R.id.diamond4);
        img5 = (ImageButton)view.findViewById(R.id.diamond5);
        img6 = (ImageButton)view.findViewById(R.id.diamond6);
        img7 = (ImageButton)view.findViewById(R.id.diamond7);
        img8 = (ImageButton)view.findViewById(R.id.diamond8);
        img9 = (ImageButton)view.findViewById(R.id.diamond9);

        t1 = (TextView)view.findViewById(R.id.t1);
        t2 = (TextView)view.findViewById(R.id.t2);
        t3 = (TextView)view.findViewById(R.id.t3);
        t4 = (TextView)view.findViewById(R.id.t4);
        t5 = (TextView)view.findViewById(R.id.t5);
        t6 = (TextView)view.findViewById(R.id.t6);
        t7 = (TextView)view.findViewById(R.id.t7);
        t8 = (TextView)view.findViewById(R.id.t8);
        t9 = (TextView)view.findViewById(R.id.t9);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getActivity(), v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.singleItem:
                                t1.setText("S");
                                return true;
                            case R.id.doubleItem:
                                t1.setText("D");
                                return true;
                            case R.id.tripleItem:
                                t1.setText("T");
                                return true;
                            case R.id.hrItem:
                                t1.setText("HR");
                                return true;
                            case R.id.outItem:
                                t1.setText("X");
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

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getActivity(), v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.singleItem:
                                t2.setText("S");
                                return true;
                            case R.id.doubleItem:
                                t2.setText("D");
                                return true;
                            case R.id.tripleItem:
                                t2.setText("T");
                                return true;
                            case R.id.hrItem:
                                t2.setText("HR");
                                return true;
                            case R.id.outItem:
                                t2.setText("X");
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

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getActivity(), v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.singleItem:
                                t3.setText("S");
                                return true;
                            case R.id.doubleItem:
                                t3.setText("D");
                                return true;
                            case R.id.tripleItem:
                                t3.setText("T");
                                return true;
                            case R.id.hrItem:
                                t3.setText("HR");
                                return true;
                            case R.id.outItem:
                                t3.setText("X");
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

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getActivity(), v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.singleItem:
                                t4.setText("S");
                                return true;
                            case R.id.doubleItem:
                                t4.setText("D");
                                return true;
                            case R.id.tripleItem:
                                t4.setText("T");
                                return true;
                            case R.id.hrItem:
                                t4.setText("HR");
                                return true;
                            case R.id.outItem:
                                t4.setText("X");
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

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getActivity(), v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.singleItem:
                                t5.setText("S");
                                return true;
                            case R.id.doubleItem:
                                t5.setText("D");
                                return true;
                            case R.id.tripleItem:
                                t5.setText("T");
                                return true;
                            case R.id.hrItem:
                                t5.setText("HR");
                                return true;
                            case R.id.outItem:
                                t5.setText("X");
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

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getActivity(), v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.singleItem:
                                t6.setText("S");
                                return true;
                            case R.id.doubleItem:
                                t6.setText("D");
                                return true;
                            case R.id.tripleItem:
                                t6.setText("T");
                                return true;
                            case R.id.hrItem:
                                t6.setText("HR");
                                return true;
                            case R.id.outItem:
                                t6.setText("X");
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

        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getActivity(), v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.singleItem:
                                t7.setText("S");
                                return true;
                            case R.id.doubleItem:
                                t7.setText("D");
                                return true;
                            case R.id.tripleItem:
                                t7.setText("T");
                                return true;
                            case R.id.hrItem:
                                t7.setText("HR");
                                return true;
                            case R.id.outItem:
                                t7.setText("X");
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

        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getActivity(), v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.singleItem:
                                t8.setText("S");
                                return true;
                            case R.id.doubleItem:
                                t8.setText("D");
                                return true;
                            case R.id.tripleItem:
                                t8.setText("T");
                                return true;
                            case R.id.hrItem:
                                t8.setText("HR");
                                return true;
                            case R.id.outItem:
                                t8.setText("X");
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

        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getActivity(), v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.singleItem:
                                t9.setText("S");
                                return true;
                            case R.id.doubleItem:
                                t9.setText("D");
                                return true;
                            case R.id.tripleItem:
                                t9.setText("T");
                                return true;
                            case R.id.hrItem:
                                t9.setText("HR");
                                return true;
                            case R.id.outItem:
                                t9.setText("X");
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
        void onImageButtonClicked(int x);
    }
}
