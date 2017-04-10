package goriproject.ykjw.com.myapplication.Interfaces;

import org.json.JSONObject;

import goriproject.ykjw.com.myapplication.domain.SignUpModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface SignUpInterface {

    @Headers("Content-Type:application/json")
    @POST("member/signup")
    Call<ResponseBody> createUser(
            @Body SignUpModel model
    );

    @FormUrlEncoded
    @POST("member/signup")
    public void signup(@Field("username") String username, @Field("password1") String password1, @Field("password2") String password2,
                       @Field("name") String name, Callback<JSONObject> callback);

    @POST("member/login")
    Call<Result> login(@Field("name") String username, @Field("password") String password);
}
