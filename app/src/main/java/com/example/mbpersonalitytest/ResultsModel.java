package com.example.mbpersonalitytest;

//class to model structure of rows in the database
public class ResultsModel {

    private int id;
    private String result;
    private String date;

    public ResultsModel(int id, String result, String date) {
        this.id = id;
        this.result = result;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ResultsModel{" +
                "id=" + id +
                ", result='" + result + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
