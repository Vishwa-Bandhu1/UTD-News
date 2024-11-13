package com.example.utd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<MyModel.Article> modelClassArrayList;

    public Adapter(Context context, ArrayList<MyModel.Article> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,webView.class);
                intent.putExtra("url", modelClassArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        holder.mtime.setText("Published At:-" + modelClassArrayList.get(position).getPublishedAt());
        holder.mauthor.setText(modelClassArrayList.get(position).getAuthor());
        holder.mheading.setText(modelClassArrayList.get(position).getTitle());
        holder.mcontent.setText(modelClassArrayList.get(position).getDescription());
       //Picasso.get().load(modelClassArrayList.get(position).getUrlToImage()).into(holder.imageView);

        System.out.println("aaaaaadddddddddd :-  "+modelClassArrayList.get(position).getUrlToImage());
        if (modelClassArrayList.get(position).getUrlToImage()!=null){
          Picasso.get().load(modelClassArrayList.get(position).getUrlToImage()).into(holder.imageView);
      }else{
          holder.imageView.setImageResource(R.drawable.ic_launcher_background);
      }
    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mheading,mcontent,mauthor,mtime;
        CardView cardView;
        ImageView imageView;

        public  ViewHolder(@NonNull View itemView){
            super(itemView);
            mheading = itemView.findViewById(R.id.mainheading);
            mcontent = itemView.findViewById(R.id.content);
            mauthor = itemView.findViewById(R.id.author);
            mtime = itemView.findViewById(R.id.time);
            imageView = itemView.findViewById(R.id.imageview);
            cardView = itemView.findViewById(R.id.cardview);


        }
    }
}
