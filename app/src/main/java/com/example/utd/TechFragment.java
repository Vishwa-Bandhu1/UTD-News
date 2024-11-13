package com.example.utd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TechFragment extends Fragment {

    String api = "809d1e15d27d4d44b9c4680c03933340";
    ArrayList<MyModel.Article> modelClassArrayList;
    Adapter adapter;
    String country ="us";
    private RecyclerView recyclerViewoftech;
    private String category = "technology";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.technologyfragment,null);


        recyclerViewoftech = v.findViewById(R.id.recyclerviewoftech);
        modelClassArrayList = new ArrayList<>();
        recyclerViewoftech.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassArrayList);
        recyclerViewoftech.setAdapter(adapter);

        findNews();
        return v;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getNews(country, "technology", api).enqueue(new Callback<MyModel.Root>() {
            @Override
            public void onResponse(Call<MyModel.Root> call, Response<MyModel.Root> response) {
                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MyModel.Root> call, Throwable t) {

            }
        });
    }
}