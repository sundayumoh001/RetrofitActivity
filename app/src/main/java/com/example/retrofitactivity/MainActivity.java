package com.example.retrofitactivity;


//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    String name;
    String pass;
//    ListView listView;
EditText ed1,ed2;



Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText)findViewById(R.id.email);
        ed2 = (EditText)findViewById(R.id.pass);
        button = (Button)findViewById(R.id.cirLoginButton);
//        listView = (ListView) findViewById(R.id.listViewHeroes);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          ed1 = (EditText)findViewById(R.id.email);
                                          ed2 = (EditText)findViewById(R.id.pass);
                                          name = ed1.getText().toString();
                                          pass = ed2.getText().toString();
                                          getHeroes(name,pass);
                                      }


                                  });
        //calling the method to display the heroes
//        getHeroes();
    }

    private void getHeroes(String email,String pass) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);
//   Call<Hero> call = api.hero("postman","password");
        Call<LoginInfo> call = api.hero(email,pass);
//        Call<LoginInfo> call = api.hero("admin@gmail.com","Hamlet2020");

        call.enqueue(new Callback<LoginInfo>() {
            @Override
            public void onResponse(Call<LoginInfo> call, Response<LoginInfo> response) {
                LoginInfo loginInfoList = response.body();
if (response.isSuccessful())
    Toast.makeText(getApplicationContext(),"Logged in", Toast.LENGTH_SHORT).show();
else
    Toast.makeText(getApplicationContext(), "bad", Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), pass, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<LoginInfo> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}