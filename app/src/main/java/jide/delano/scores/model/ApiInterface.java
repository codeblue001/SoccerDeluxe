package jide.delano.scores.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    //https://www.scorebat.com/video-api/v1/
    @GET("video-api/v1/")
    Call<MatchResult> getMatchData(
            @Query("side1")String side1,
            @Query("side2")String side2,
            @Query("competition")String competition);
}
