package com.example.termproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    String name;
    private ArrayList<MainData> arrayList;


    public MainAdapter(ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.CustomViewHolder holder, int position) {
        holder.TextView_title.setText(arrayList.get(position).getTextView_title());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            String curName = holder.TextView_title.getText().toString();

            @Override
            public void onClick(View v) { //아이템뷰 클릭시
                String curName = holder.TextView_title.getText().toString();



                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v){ //길게 누를시


                        ((MainActivity)MainActivity.mContext).add_item(curName);
                        return true;
                    }
                });


            }
        });



    }



    @Override
    public int getItemCount() {
        return (null !=arrayList?arrayList.size():0);
    }

    public void remove(int position){
        try {
            arrayList.remove(position);
            notifyItemRemoved(position);
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    //필터 추가
    public void filterList(ArrayList<MainData> filteredList) {
        arrayList = filteredList;
        notifyDataSetChanged();
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView TextView_title;

        public CustomViewHolder(@NonNull View itemView) {
            
            super(itemView);
            this.TextView_title = (TextView) itemView.findViewById(R.id.TextView_title);


        }
    }
}
