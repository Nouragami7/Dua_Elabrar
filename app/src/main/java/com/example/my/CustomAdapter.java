package com.example.my;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    final Activity activity;
    final ArrayList<status>state;
    private int[] colorArray = {R.drawable.tale,R.drawable.white,R.drawable.black};

    public CustomAdapter(Activity activity, ArrayList<status> state) {
        this.activity = activity;
        this.state = state;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View v= inflater.inflate(R.layout.list_view,parent,false);
        MyViewHolder hold = new MyViewHolder(v);
        return hold;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
      //  holder.layout.setBackgroundColor(state.get(colorArray[position % colorArray.length]);
        holder.text.setText(state.get(position).getText());
    }



    @Override
    public int getItemCount() {
        return state.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
       final TextView text;
       private LinearLayout layout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.txt);
            layout = itemView.findViewById(R.id.color);
        }
    }
}
