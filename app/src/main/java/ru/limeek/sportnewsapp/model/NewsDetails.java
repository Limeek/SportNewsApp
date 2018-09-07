
package ru.limeek.sportnewsapp.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ru.limeek.sportnewsapp.BR;

public class NewsDetails extends BaseObservable implements Parcelable {

    @SerializedName("team1")
    @Expose
    private String team1;
    @SerializedName("team2")
    @Expose
    private String team2;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("tournament")
    @Expose
    private String tournament;
    @SerializedName("place")
    @Expose
    private String place;
    @SerializedName("article")
    @Expose
    private List<Article> article = null;
    @SerializedName("prediction")
    @Expose
    private String prediction;

    public final static Parcelable.Creator<NewsDetails> CREATOR = new Creator<NewsDetails>() {
        public NewsDetails createFromParcel(Parcel in) {
            return new NewsDetails(in);
        }

        public NewsDetails[] newArray(int size) {
            return (new NewsDetails[size]);
        }
    };

    private NewsDetails(Parcel in) {
        this.team1 = in.readString();
        this.team2 = in.readString();
        this.time = in.readString();
        this.tournament = in.readString();
        this.place = in.readString();
        in.readList(this.article, Article.class.getClassLoader());
        this.prediction = in.readString();
    }

    public NewsDetails(String team1, String team2, String time, String tournament, String place, List<Article> article, String prediction){
        this.team1 = team1;
        this.team2 = team2;
        this.time = time;
        this.tournament = tournament;
        this.place = place;
        this.article = article;
        this.prediction = prediction;
    }

    public NewsDetails(){}

    @Bindable
    public String getTeam1() {
        return team1;
    }

    @Bindable
    public void setTeam1(String team1) {
        this.team1 = team1;
        notifyPropertyChanged(BR.team1);
    }

    @Bindable
    public String getTeam2() {
        return team2;
    }

    @Bindable
    public void setTeam2(String team2) {
        this.team2 = team2;
        notifyPropertyChanged(BR.team2);
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
    public String getTournament() {
        return tournament;
    }

    @Bindable
    public void setTournament(String tournament) {
        this.tournament = tournament;
        notifyPropertyChanged(BR.tournament);
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
    public List<Article> getArticle() {
        return article;
    }

    @Bindable
    public void setArticle(List<Article> article) {
        this.article = article;
        notifyPropertyChanged(BR.article);
    }

    @Bindable
    public String getPrediction() {
        return prediction;
    }

    @Bindable
    public void setPrediction(String prediction) {
        this.prediction = prediction;
        notifyPropertyChanged(BR.prediction);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(team1);
        dest.writeValue(team2);
        dest.writeValue(time);
        dest.writeValue(tournament);
        dest.writeValue(place);
        dest.writeList(article);
        dest.writeValue(prediction);
    }

    public void updateValues(NewsDetails newsDetails){
        setTournament(newsDetails.getTournament());
        setTime(newsDetails.getTime());
        setTeam1(newsDetails.getTeam1());
        setTeam2(newsDetails.getTeam2());
        setPrediction(newsDetails.getPrediction());
        setPlace(newsDetails.getPlace());
        setArticle(newsDetails.getArticle());
    }

    public int describeContents() {
        return  0;
    }
}
