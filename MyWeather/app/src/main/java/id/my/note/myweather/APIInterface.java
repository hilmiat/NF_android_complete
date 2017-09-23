package id.my.note.myweather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by hilmiat on 23/09/17.
 */

public interface APIInterface {
    @GET("weather")
    Call<Cuaca> getWeather(@Query("q") String city,
                           @Query("appid") String apiid);
}
