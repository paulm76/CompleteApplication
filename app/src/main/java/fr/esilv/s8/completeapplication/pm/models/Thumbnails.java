package fr.esilv.s8.completeapplication.pm.models;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Paul on 18/03/2017.
 */

public class Thumbnails {
    @SerializedName("default")
    private Default _default;
    @SerializedName("medium")
    private Medium medium;
    @SerializedName("high")
    private High high;

    public Default getDefault() {
        return _default;
    }

    public void setDefault(Default _default) {
        this._default = _default;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public High getHigh() {
        return high;
    }

    public void setHigh(High high) {
        this.high = high;
    }
}
