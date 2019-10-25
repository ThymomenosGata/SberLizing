package wordy.com.sberlizing.ui.car;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Items {
    @SerializedName("img")
    @Expose
    private String img;
    @Expose
    private Properties properties;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
