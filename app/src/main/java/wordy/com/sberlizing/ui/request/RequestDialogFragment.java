package wordy.com.sberlizing.ui.request;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.annotation.Nullable;
import wordy.com.sberlizing.R;
import wordy.com.sberlizing.ui.calc.CalcModel;

public class RequestDialogFragment extends BottomSheetDialogFragment {

    private int month, percent, pay;
    private EditText editName, editPhone;

    public static RequestDialogFragment newInstance() {
        return new RequestDialogFragment();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            CalcModel calcModel = bundle.getParcelable("request");
            percent = calcModel.getPercent();
            month = calcModel.getMonth();
            pay = calcModel.getPay();
        }

        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.request_dialog_fragment, container, false);

        editName = root.findViewById(R.id.name);
        editPhone = root.findViewById(R.id.phone_number);
        ImageButton close = root.findViewById(R.id.close_button);
        Button send = root.findViewById(R.id.send_email);


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("text/html");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"kostaki97@mail.ru"});
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml(new StringBuilder()
                        .append("<p><b>NAME: ")
                        .append(editName.getText().toString())
                        .append("</b></p>")
                        .append("<p><b>Phone: ")
                        .append(editPhone.getText().toString())
                        .append("</b></p>")
                        .append("<p><b>Avans: ")
                        .append(percent)
                        .append("%</b></p>")
                        .append("<p><b>Count month: ")
                        .append(month)
                        .append("</b></p>")
                        .append("<p><b>Final pay: ")
                        .append(pay)
                        .append("</b></p>").toString()));
                startActivity(Intent.createChooser(emailIntent, "Email:"));
                dismiss();
            }
        });

        return root;

    }
}
