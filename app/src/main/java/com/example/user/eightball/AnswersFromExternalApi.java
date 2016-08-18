package com.example.user.eightball;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by user on 17/08/2016.
 */
public class AnswersFromExternalApi extends Answers {

    private final static String API_URL="https://andruxnet-random-famous-quotes.p.mashape.com/endpoint?mashape-key=LAUh7bl572mshxx2ZWlsNfLwBDQwp1JgiD5jsnu4yMVw2qcqaR";

    public AnswersFromExternalApi(){
        super();
    }

    public AnswersFromExternalApi(ArrayList<String> answers){
        mAnswers = answers;
    }

    @Override
    public void setupAnswers(){
        AsyncHttpClient client = new AsyncHttpClient();

        client.get(API_URL, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(JSONObject jsonObject){
                JSONObject object = jsonObject;
                String answer = object.optString("quote");
                mAnswers.add(answer);
            }
            @Override
            public void onFailure(int statusCode, Throwable throwable, JSONObject error){
                Log.e("Eightball:", "failure: " + statusCode + " " + throwable.getMessage());
            }
        });
    }
}
