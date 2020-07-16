package com.example.aiboidi.adapters;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aiboidi.R;
import com.example.aiboidi.models.BoiData;

import java.util.ArrayList;

public class BoiAdapter extends RecyclerView.Adapter<BoiAdapter.ViewHolder> {
    ArrayList<BoiData> boidatas;

    public BoiAdapter(ArrayList<BoiData> boidatas) {
        this.boidatas = boidatas;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvRow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvRow = itemView.findViewById(R.id.tvRow);
        }
    }

    @NonNull
    @Override
    public BoiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoiAdapter.ViewHolder holder, int position) {
       BoiData boidata = boidatas.get(position);
        holder.tvRow.setText(boidata.getName());
    }

    @Override
    public int getItemCount() {
        return boidatas.size();
    }
}
