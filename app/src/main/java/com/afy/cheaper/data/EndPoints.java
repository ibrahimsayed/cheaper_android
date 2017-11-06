package com.afy.cheaper.data;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by isayed on 10/29/2017.
 */

public interface EndPoints {
    @GET("CheaperWS/webresources/com.afy.cheaper.offer")
    Call <List<Offer>> getOffers();
    //@Path("offer") String offer;

//    @POST("verification/sendActivationCode")
//    Call<GenerericResponseModel> postSendActivation(@Body ActivationCodeRequestModel req);
}
