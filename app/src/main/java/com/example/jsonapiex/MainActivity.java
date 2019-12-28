package com.example.jsonapiex;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonapiex.adapter.WorldPopulationAdapter;
import com.example.jsonapiex.model.Worldpopulation;
import com.example.jsonapiex.network.GetReq;
import com.example.jsonapiex.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Worldpopulation> worldpopulationList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String baseUrl = "http://androchef.com";


        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RetrofitClient.getClient(baseUrl)
                .create(GetReq.class)
                .loadWordPopulationList()
                .enqueue(new Callback<List<Worldpopulation>>() {
                    @Override
                    public void onResponse(Call<List<Worldpopulation>> call, Response<List<Worldpopulation>> response) {
                        Log.i("sdjgfjsdj", "onResponse: " + response.body().toString());

                        worldpopulationList = response.body();
                        recyclerView.setAdapter(new WorldPopulationAdapter(worldpopulationList, MainActivity.this));

                    }

                    @Override
                    public void onFailure(Call<List<Worldpopulation>> call, Throwable t) {
                        Log.i("sdjgfjsdj", "onFailure: " + t.toString());
                    }
                });

//        HashMap<String, Object> map = new HashMap<>();
//        map.put("name", "bll");
//        map.put("salary", "32572");
//        map.put("age", "23");
//
//
//        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), (new JSONObject(map)).toString());
//
//
//        RetrofitClient.getClient("http://dummy.restapiexample.com/api/v1/")
//                .create(PostReq.class)
//                .getPost(body)
//                .enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        try {
//                            JSONObject jsonObject=new JSONObject(response.body().toString());
//                            Log.i("sjkasjhdj", "onResponse: "+jsonObject.get("name").toString());
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                        try {
//                            //JSONArray jsonArray = new JSONArray((response.body().string()));
//                            Log.i("sjkasjhdj", "onResponse: " + response.body().string());
//
//
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        Log.i("sjkasjhdj", "onFailure: " + t.toString());
//                    }
//                });


    }
}
