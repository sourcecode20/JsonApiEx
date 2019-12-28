package com.example.jsonapiex.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonapiex.MainActivity;
import com.example.jsonapiex.R;
import com.example.jsonapiex.model.Worldpopulation;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WorldPopulationAdapter extends RecyclerView.Adapter<WorldPopulationAdapter.ListViewHolder> {
    private List<Worldpopulation> worldpopulationList;
    private Context context;


    public WorldPopulationAdapter(@NonNull List<Worldpopulation> worldpopulationList, Context context) {
        this.worldpopulationList = worldpopulationList;
        this.context = context;
    }


    @NonNull
    @Override
    public WorldPopulationAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.wordpopulation, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.rank.setText(""+worldpopulationList.get(position).getRank());
        holder.country.setText(worldpopulationList.get(position).getCountry());
        holder.population.setText(worldpopulationList.get(position).getPopulation());
        Picasso.get().load(worldpopulationList.get(position).getFlag()).placeholder(R.drawable.ic_launcher_background).into(holder.flag);
    }

    @Override
    public int getItemCount() {
        return worldpopulationList.size();
    }


    class ListViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView flag;
        TextView rank, country, population;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            flag = view.findViewById(R.id.flag);
            rank = view.findViewById(R.id.rank);
            country = view.findViewById(R.id.country);
            population = view.findViewById(R.id.population);

        }
    }
}
