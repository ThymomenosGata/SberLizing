package wordy.com.sberlizing.ui.retrofitRest;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PortalRest extends Application {

    private static SberApi.MarcetplaceApi marcetplaceApi;

    @Override
    public void onCreate() {
        super.onCreate();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.sberleasing.ru")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        marcetplaceApi = retrofit.create(SberApi.MarcetplaceApi.class);
    }

    public static SberApi.MarcetplaceApi getMarcetplaceApi() {
        return marcetplaceApi;
    }
}
