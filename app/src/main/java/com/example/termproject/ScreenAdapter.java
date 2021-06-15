package com.example.termproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScreenAdapter extends RecyclerView.Adapter<ScreenAdapter.CustomViewHolder> {
    String name;
    private ArrayList<ScreenData> arrayList;

    public ScreenAdapter(ArrayList<ScreenData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ScreenAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.screen_item_list,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ScreenAdapter.CustomViewHolder holder, int position) {
        holder.TextView_title.setText(arrayList.get(position).getTextView_title());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            String curName = holder.TextView_title.getText().toString();

            @Override
            public void onClick(View v) { //아이템뷰 클릭시
                String curName = holder.TextView_title.getText().toString();

                ((MainActivity)MainActivity.mContext).show_stock_data(curName); //주식데이터 가져오기

                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v){ //길게 누를시
                        remove(holder.getAdapterPosition()); //요소를 지운다.
                        ((MainActivity)MainActivity.mContext).remove_item(curName);
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


    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView TextView_title;

        public CustomViewHolder(@NonNull View itemView) {
            
            super(itemView);
            this.TextView_title = (TextView) itemView.findViewById(R.id.TextView_title);


        }
    }
}
