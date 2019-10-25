package wordy.com.sberlizing.ui.car;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import wordy.com.sberlizing.R;

public class CarRecyclerViewAdapter extends RecyclerView.Adapter<CarRecyclerViewAdapter.ViewHolder> {

    private List<Items> items;
    private Context context;

    public CarRecyclerViewAdapter(Context context, List<Items> items) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CarRecyclerViewAdapter.ViewHolder holder, int position) {
        Items item = items.get(position);
        if (item != null) {
            holder.carModify.setText(item.getProperties().getModification_id());
            holder.carName.setText(item.getProperties().getMark_id() + " " + item.getProperties().getFolder_id());
            holder.location.setText(item.getProperties().getCity());
            holder.priceL.setText(String.valueOf(item.getProperties().getLeasing_price()));
            holder.priceFull.setText(String.valueOf(item.getProperties().getPrice()));
            Picasso.with(context)
                    .load(item.getImg())
                    .error(R.drawable.ic_directions_car_black_24dp)
                    .into(holder.carImage);

            holder.localImage.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_room_black_24dp));
        }
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView carName, carModify, priceL, priceFull, location;
        ImageView carImage, localImage;

        public ViewHolder(View itemView) {
            super(itemView);
            carName = itemView.findViewById(R.id.car_name);
            carModify = itemView.findViewById(R.id.car_character);
            priceL = itemView.findViewById(R.id.price_in_month);
            priceFull = itemView.findViewById(R.id.price_car);
            location = itemView.findViewById(R.id.location);
            carImage = itemView.findViewById(R.id.car_image);
            localImage = itemView.findViewById(R.id.localImage);
        }
    }
}
