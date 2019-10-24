package wordy.com.sberlizing.ui.calc;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import wordy.com.sberlizing.R;
import wordy.com.sberlizing.ui.request.RequestDialogFragment;

public class CalcFragment extends Fragment {

    private CalcViewModel calcViewModel;
    private SeekBar seekBarPrice, seekBarTerm, seekBarPercent;
    private EditText editTextPrice, editTextTerm, editTextPercent;
    private CalcModel calcModel;
    private TextView mPay;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_calc, container, false);
        seekBarPrice = root.findViewById(R.id.seekBar_price_assets);
        seekBarTerm = root.findViewById(R.id.seekBar_leasing_term);
        seekBarPercent = root.findViewById(R.id.seekBar_percent);
        editTextPrice = root.findViewById(R.id.price_assets);
        editTextTerm = root.findViewById(R.id.leasing_term);
        editTextPercent = root.findViewById(R.id.size_avans);
        mPay = root.findViewById(R.id.every_month_pay);

        calcViewModel = ViewModelProviders.of(this).get(CalcViewModel.class);
        calcModel = new CalcModel(500000, 10, 12);

        calcViewModel.getText().observe(this, new Observer<CalcModel>() {
            @Override
            public void onChanged(CalcModel calcModel) {
                editTextPrice.setText(String.valueOf(calcModel.getSum()));
                editTextPercent.setText(String.valueOf(calcModel.getPercent()));
                editTextTerm.setText(String.valueOf(calcModel.getMonth()));
                mPay.setText(String.valueOf(calcModel.getPay()));
            }
        });

        seekBarPrice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                calcModel.setSum(seekBar.getProgress() + 500000);
                calcViewModel.setText(calcModel);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarPercent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                calcModel.setPercent(seekBar.getProgress() + 10);
                calcViewModel.setText(calcModel);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarTerm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                calcModel.setMonth(seekBar.getProgress() + 12);
                calcViewModel.setText(calcModel);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        editTextPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int sum = Integer.valueOf(s.toString());
                if (sum > 10000000) {
                    sum = 10000000;
                } else if (sum < 500000) {
                    sum = 500000;
                }
                seekBarPrice.setProgress(sum - 500000);
                calcModel.setSum(sum);
            }
        });

        editTextPercent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int percent = Integer.valueOf(s.toString());
                if (percent > 49) {
                    percent = 49;
                } else if (percent < 10) {
                    percent = 10;
                }
                seekBarPercent.setProgress(percent - 10);
                calcModel.setPercent(percent);
            }
        });

        editTextTerm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int month = Integer.valueOf(s.toString());
                if (month > 36) {
                    month = 36;
                } else if (month < 12) {
                    month = 12;
                }
                seekBarTerm.setProgress(month - 12);
                calcModel.setMonth(month);
            }
        });

        Button button = root.findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestDialogFragment requestDialogFragment = RequestDialogFragment.newInstance();
                Bundle bundle = new Bundle();
                bundle.putParcelable("request", calcModel);
                requestDialogFragment.setArguments(bundle);
                requestDialogFragment.show(getActivity().getSupportFragmentManager(), "");
            }
        });

        return root;
    }
}