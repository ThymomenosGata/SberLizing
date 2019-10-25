package wordy.com.sberlizing.ui.car;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Properties {
    @SerializedName("mark_id")
    @Expose
    private String mark_id;
    @SerializedName("folder_id")
    @Expose
    private String folder_id;
    @SerializedName("modification_id")
    @Expose
    private String modification_id;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("price")
    @Expose
    private int price;
    @SerializedName("leasing_price")
    @Expose
    private int leasing_price;

    public String getMark_id() {
        return mark_id;
    }

    public void setMark_id(String mark_id) {
        this.mark_id = mark_id;
    }

    public String getFolder_id() {
        return folder_id;
    }

    public void setFolder_id(String folder_id) {
        this.folder_id = folder_id;
    }

    public String getModification_id() {
        return modification_id;
    }

    public void setModification_id(String modification_id) {
        this.modification_id = modification_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLeasing_price() {
        return leasing_price;
    }

    public void setLeasing_price(int leasing_price) {
        this.leasing_price = leasing_price;
    }
}
