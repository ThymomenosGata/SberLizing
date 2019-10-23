package wordy.com.sberlizing.ui.request;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.annotation.Nullable;
import wordy.com.sberlizing.R;

public class RequestDialogFragment extends BottomSheetDialogFragment {

    public static RequestDialogFragment newInstance() {
        return new RequestDialogFragment();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.request_dialog_fragment, container,false);

        return root;

    }
}
