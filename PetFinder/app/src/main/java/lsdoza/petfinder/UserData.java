package lsdoza.petfinder;

import java.io.Serializable;

/**
 * Created by lsdoza on 2/1/2017.
 */

public class UserData implements Serializable {
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String date;
    private String time;
    private String commentsOrQuestions;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setCommentsOrQuestions(String commentsOrQuestions) {
        this.commentsOrQuestions = commentsOrQuestions;
    }

    public String getName() {

        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getCommentsOrQuestions() {
        return commentsOrQuestions;
    }

    public UserData(String name, String phoneNumber, String emailAddress, String date, String time, String commentsOrQuestions) {

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.date = date;
        this.time = time;
        this.commentsOrQuestions = commentsOrQuestions;
    }
}
