package wordy.com.sberlizing.ui.car;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wordy.com.sberlizing.R;
import wordy.com.sberlizing.ui.retrofitRest.PortalRest;

public class CarFragment extends Fragment {

    private CarViewModel carViewModel;
    private RecyclerView carRecyclView;
    private List<Items> items;

    @SuppressLint("StaticFieldLeak")
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_car, container, false);
        items = new ArrayList<>();

        carRecyclView = root.findViewById(R.id.car_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        carRecyclView.setLayoutManager(layoutManager);

        CarRecyclerViewAdapter adapter = new CarRecyclerViewAdapter(getContext(), items);
        carRecyclView.setAdapter(adapter);

        PortalRest.getMarcetplaceApi().getData().enqueue(new Callback<CarInfo>() {
            @Override
            public void onResponse(Call<CarInfo> call, Response<CarInfo> response) {
                items.addAll(response.body().getItems());
                carRecyclView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<CarInfo> call, Throwable t) {
                Toast.makeText(getContext(), "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}