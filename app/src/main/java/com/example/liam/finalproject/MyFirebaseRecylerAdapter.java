
package com.example.liam.finalproject;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Query;
import com.firebase.ui.FirebaseRecyclerAdapter;
import com.squareup.picasso.Picasso;


public class MyFirebaseRecylerAdapter extends FirebaseRecyclerAdapter<Team,MyFirebaseRecylerAdapter.TeamViewHolder> {

    private Context mContext ;

    public MyFirebaseRecylerAdapter(Class<Team> modelClass, int modelLayout,
                                    Class<TeamViewHolder> holder, Query ref, Context context) {
        super(modelClass,modelLayout,holder,ref);
        this.mContext = context;
    }

    private static onItemClickListener mItemClickListener;

    public void SetOnItemClickListener(final onItemClickListener m)
    {
        this.mItemClickListener = m;
    }

    public interface onItemClickListener
    {
        void onItemClick(View view, int position);
        void onOverflowMenuClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    @Override
    protected void populateViewHolder(TeamViewHolder teamViewHolder, Team team, int i) {

        //TODO: Populate viewHolder by setting the book's attributes to cardview fields
         teamViewHolder.vTitle.setText(team.getName());
         Picasso.with(mContext).load(team.getUrl()).into(teamViewHolder.vImg);
        //movieViewHolder.vDesc.setText(movie.getDescription());
        teamViewHolder.vImg.setImageBitmap(BitmapFactory.decodeFile(team.getUrl()));
        int wins = team.getWins();
        int losses = team.getLosses();
        teamViewHolder.record.setText(wins+ " - " + losses);
    }

    //TODO: Populate ViewHolder and add listeners.
    public static class TeamViewHolder extends RecyclerView.ViewHolder{


        protected TextView vTitle;
        protected ImageView vImg;
        protected TextView record;
        protected ImageView vMenu;


        public TeamViewHolder(View v) {
            super(v);
            vTitle =  (TextView) v.findViewById(R.id.title);
            vImg = (ImageView)  v.findViewById(R.id.image);
            //vDesc = (TextView)  v.findViewById(R.id.description);
            vMenu = (ImageView) v.findViewById(R.id.cardClick);
            record = (TextView) v.findViewById(R.id.teamRecord);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemClickListener != null) {
                        mItemClickListener.onItemClick(v, getAdapterPosition());
                    }
                }
            });

            v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (mItemClickListener != null) {
                        mItemClickListener.onItemLongClick(v, getAdapterPosition());
                    }
                    return true;
                }
            });

            if(vMenu!=null){
                vMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mItemClickListener != null) {
                            mItemClickListener.onOverflowMenuClick(v, getAdapterPosition());
                        }
                    }
                });
            }
        }
    }

}
