package id.my.note.myweather;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hilmiat on 23/09/17.
 */

public class APIClient {
    private static Retrofit retrofit = null;
    static Retrofit getClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.4/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
