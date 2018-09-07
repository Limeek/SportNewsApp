
package ru.limeek.sportnewsapp.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.limeek.sportnewsapp.BR;

public class Event extends BaseObservable implements Parcelable {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("coefficient")
    @Expose
    private String coefficient;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("place")
    @Expose
    private String place;
    @SerializedName("preview")
    @Expose
    private String preview;
    @SerializedName("article")
    @Expose
    private String article;

    private Event(Parcel in){
        title = in.readString();
        coefficient = in.readString();
        time = in.readString();
        place = in.readString();
        preview = in.readString();
        article = in.readString();
    }

    Event(String title, String coefficient, String time, String place, String preview, String article){
        this.title = title;
        this.coefficient = coefficient;
        this.time = time;
        this.place = place;
        this.preview = preview;
        this.article = article;
    }

    public final static Parcelable.Creator<Event> CREATOR = new Creator<Event>(){
        @Override
        public Event createFromParcel(Parcel source) {
            return new Event(source);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    @Bindable
    public String getTitle() {
        return title;
    }

    @Bindable
    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getCoefficient() {
        return coefficient;
    }

    @Bindable
    public void setCoefficient(String coefficient) {
        this.coefficient = coefficient;
        notifyPropertyChanged(BR.coefficient);
    }

    @Bindable
    public String getTime() {
        return time;
    }

    @Bindable
    public void setTime(String time) {
        this.time = time;
        notifyPropertyChanged(BR.time);
    }

    @Bindable
    public String getPlace() {
        return place;
    }

    @Bindable
    public void setPlace(String place) {
        this.place = place;
        notifyPropertyChanged(BR.place);
    }

    @Bindable
    public String getPreview() {
        return preview;
    }

    @Bindable
    public void setPreview(String preview) {
        this.preview = preview;
        notifyPropertyChanged(BR.preview);
    }

    @Bindable
    public String getArticle() {
        return article;
    }

    @Bindable
    public void setArticle(String article) {
        this.article = article;
        notifyPropertyChanged(BR.article);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(coefficient);
        dest.writeString(time);
        dest.writeString(place);
        dest.writeString(preview);
        dest.writeString(article);
    }
}
