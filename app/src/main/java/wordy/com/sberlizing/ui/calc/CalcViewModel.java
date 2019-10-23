package wordy.com.sberlizing.ui.calc;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalcViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CalcViewModel() {
        mText = new MutableLiveData<>();
    }

    public void setText(String text) {
        mText.setValue(text);
    }

    public LiveData<String> getText() {
        return mText;
    }
}