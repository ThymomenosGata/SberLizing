package wordy.com.sberlizing.ui.calc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import wordy.com.sberlizing.R;
import wordy.com.sberlizing.ui.request.RequestDialogFragment;

public class CalcFragment extends Fragment {

    private CalcViewModel calcViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        calcViewModel = ViewModelProviders.of(this).get(CalcViewModel.class);
        View root = inflater.inflate(R.layout.fragment_calc, container, false);

        Button button = root.findViewById(R.id.send);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestDialogFragment addPhotoBottomDialogFragment = RequestDialogFragment.newInstance();
                addPhotoBottomDialogFragment.show(getActivity().getSupportFragmentManager(), "");
            }
        });

        return root;
    }
}