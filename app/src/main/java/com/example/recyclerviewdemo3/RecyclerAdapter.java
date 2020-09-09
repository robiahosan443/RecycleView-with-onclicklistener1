package com.example.recyclerviewdemo3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    ArrayList<User>userlist;

    private RecycleViewClickListener listener;

    public RecyclerAdapter( ArrayList<User>userlist,RecycleViewClickListener listener){
        this.userlist=userlist;
        this.listener=listener;
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nametext;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nametext=itemView.findViewById(R.id.textview5);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());
        }
    }
    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {

        String name= userlist.get(position).getUsername();
        holder.nametext.setText(name);
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public interface RecycleViewClickListener{
        void onClick(View v, int position);
    }
}
