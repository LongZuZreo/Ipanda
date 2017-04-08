package cctv.cn.ipanda.model.http;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by 张志远 on 2017/4/6.
 */

public interface MyNetRequest {
    @GET
    Call<ResponseBody> getResponseBody(@Url String url, @QueryMap Map<String,String> params);

    @GET
    Call<ResponseBody> getResponseBody(@Url String url);

    @POST
    Call<ResponseBody> postResponseBody(@Url String url, @FieldMap Map<String,String> params);
}
