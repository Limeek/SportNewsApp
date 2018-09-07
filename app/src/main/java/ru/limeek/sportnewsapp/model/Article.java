
package ru.limeek.sportnewsapp.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.limeek.sportnewsapp.BR;

public class Article extends BaseObservable implements Parcelable {

    @SerializedName("header")
    @Expose
    private String header;
    @SerializedName("text")
    @Expose
    private String text;

    public final static Parcelable.Creator<Article> CREATOR = new Creator<Article>() {
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        public Article[] newArray(int size) {
            return (new Article[size]);
        }
    };

    private Article(Parcel in) {
        this.header = in.readString();
        this.text = in.readString();
    }

    public Article(String header, String text) {
        this.header = header;
        this.text = text;
    }

    public Boolean isEmpty(){
        return this.header.equals("") && this.getText().equals("");
    }

    @Bindable
    public String getHeader() {
        return header;
    }

    @Bindable
    public void setHeader(String header) {
        this.header = header;
        notifyPropertyChanged(BR.header);
    }

    @Bindable
    public String getText() {
        return text;
    }

    @Bindable
    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(header);
        dest.writeValue(text);
    }

    public int describeContents() {
        return  0;
    }
}
