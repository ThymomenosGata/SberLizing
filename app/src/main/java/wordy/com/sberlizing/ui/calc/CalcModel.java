package wordy.com.sberlizing.ui.calc;

import android.os.Parcel;
import android.os.Parcelable;

public class CalcModel implements Parcelable {

    private int sum;
    private int percent;
    private int month;
    private int pay;
    private float finance;
    private static final float stavka = 0.1865f;

    public CalcModel(int sum, int percent, int month) {
        this.sum = sum;
        this.percent = percent;
        this.month = month;
        newPay();
    }

    protected CalcModel(Parcel in) {
        sum = in.readInt();
        percent = in.readInt();
        month = in.readInt();
        pay = in.readInt();
    }

    public static final Creator<CalcModel> CREATOR = new Creator<CalcModel>() {
        @Override
        public CalcModel createFromParcel(Parcel in) {
            return new CalcModel(in);
        }

        @Override
        public CalcModel[] newArray(int size) {
            return new CalcModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(sum);
        dest.writeInt(percent);
        dest.writeInt(month);
        dest.writeInt(pay);
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
        newPay();
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
        newPay();
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
        newPay();
    }

    public int getPay() {
        return pay;
    }

    private void newPay() {
        finance = sum - sum * (percent / 100f);
        pay = (int) (((stavka / 12) * (finance * Math.pow((stavka / 12 + 1), month))) / ((Math.pow((stavka / 12 + 1), month)) - 1));
    }
}
