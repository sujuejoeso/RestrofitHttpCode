package com.joeso.restrofithttpcode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private String baseUrl="http://dummy.restapiexample.com/";;
    private List<Employee> responseList;
    private ListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview1);
        mAdapter = new ListAdapter(MainActivity.this, responseList);
        mRecyclerView.setLayoutManager( new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
        fetchData();
    }

    private void fetchData(){

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        ApiService service = retrofit.create(ApiService.class);
        Call<List<Employee>> call = service.GetEmployeeData();

       //calling the api
        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                responseList = response.body();
                mAdapter.setEmployeeList(responseList);
            }
            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Log.d("jjjj",t.getMessage());
            }
        });

    }
}
