package wordy.com.sberlizing.ui.retrofitRest;

import retrofit2.Call;
import retrofit2.http.GET;
import wordy.com.sberlizing.ui.car.CarInfo;

public class SberApi {
    public interface MarcetplaceApi {
        @GET("/api/marketplace")
        Call<CarInfo> getData();
    }
}
