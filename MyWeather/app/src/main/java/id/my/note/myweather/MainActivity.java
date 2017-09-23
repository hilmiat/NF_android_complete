package id.my.note.myweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    APIInterface apiInterface;
    TextView nama_kota,txt_cuaca;
    ImageView image_cuaca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama_kota = (TextView) findViewById(R.id.nama_kota);
        txt_cuaca = (TextView) findViewById(R.id.txt_cuaca);
        image_cuaca = (ImageView) findViewById(R.id.image_cuaca);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        Call call = apiInterface.getWeather("Depok","d30e725bba38cbcf7e9eaf3d85e23096");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.message().equalsIgnoreCase("OK")){
                    Log.i("MY_LOG", "Response:"+response.message());
                    Cuaca cuaca = (Cuaca) response.body();
                    Log.i("MY_LOG", "Kota:"+cuaca.getName());
                    nama_kota.setText(cuaca.getName());
                    List<Weather> listcuaca = cuaca.getWeather();
                    Weather weather = listcuaca.get(0);
                    txt_cuaca.setText(weather.getDescription());
                    Picasso.with(getApplicationContext())
                            .load("http://openweathermap.org/img/w/"+weather.getIcon()+".png")
                            .into(image_cuaca);
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.i("MY_LOG", "GAGAL:"+t.getMessage());
            }
        });

    }
}
