package goriproject.ykjw.com.myapplication.Interfaces;

import goriproject.ykjw.com.myapplication.domain.List_All;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Younkyu on 2017-04-14.
 */

public interface Apply_Doc_Interface {

    @FormUrlEncoded
    @POST("talent/add/registration/")
    Call<ResponseBody> postApply(@Header("Authorization") String Token, @Field("location_pk") String pk,
                                 @Field("student_level") String level,
                                 @Field("message_to_tutor") String msg);

}
