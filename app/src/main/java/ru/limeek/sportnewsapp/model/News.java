
package ru.limeek.sportnewsapp.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ru.limeek.sportnewsapp.BR;

public class News extends BaseObservable implements Parcelable {
    @SerializedName("events")
    @Expose
    private List<Event> events = null;

    @Bindable
    public List<Event> getEvents() {
        return events;
    }

    @Bindable
    public void setEvents(List<Event> events) {
        this.events = events;
        notifyPropertyChanged(BR.events);
    }

    public News(List<Event> events){
        this.events = events;
    }

    private News(Parcel in){
        in.readList(events, Event.class.getClassLoader());
    }

    public static final Parcelable.Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(events);
    }
}
