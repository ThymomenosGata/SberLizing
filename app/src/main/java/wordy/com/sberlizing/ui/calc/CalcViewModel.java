package wordy.com.sberlizing.ui.calc;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalcViewModel extends ViewModel {

    private MutableLiveData<CalcModel> calcModel;

    public CalcViewModel() {
        calcModel = new MutableLiveData<>();
        calcModel.setValue(new CalcModel(500000, 10, 12));
    }

    public void setText(CalcModel text) {
        calcModel.setValue(text);
    }

    public LiveData<CalcModel> getText() {
        return calcModel;
    }
}