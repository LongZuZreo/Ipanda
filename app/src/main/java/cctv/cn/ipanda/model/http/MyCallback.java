package cctv.cn.ipanda.model.http;

/**
 * Created by 张志远 on 2017/4/6.
 */

public interface MyCallback<T> {

    void onSuccess(T t);

    void onError(String msg);
}
