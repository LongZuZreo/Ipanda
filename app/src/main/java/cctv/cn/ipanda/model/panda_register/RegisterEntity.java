package cctv.cn.ipanda.model.panda_register;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 张志远 on 2017/4/14.
 */

public class RegisterEntity {


    /**
     * timestamp : 2017-04-14 01:35:30
     * usrid :
     * email : 582864983@qq.com
     * errtype : 101
     * msg : 验证码错误
     * addons : ipanda.android
     * seqid :
     * signature :
     */

    @SerializedName("timestamp")
    private String timestamp;
    @SerializedName("usrid")
    private String usrid;
    @SerializedName("email")
    private String email;
    @SerializedName("errtype")
    private String errtype;
    @SerializedName("msg")
    private String msg;
    @SerializedName("addons")
    private String addons;
    @SerializedName("seqid")
    private String seqid;
    @SerializedName("signature")
    private String signature;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsrid() {
        return usrid;
    }

    public void setUsrid(String usrid) {
        this.usrid = usrid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getErrtype() {
        return errtype;
    }

    public void setErrtype(String errtype) {
        this.errtype = errtype;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getAddons() {
        return addons;
    }

    public void setAddons(String addons) {
        this.addons = addons;
    }

    public String getSeqid() {
        return seqid;
    }

    public void setSeqid(String seqid) {
        this.seqid = seqid;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
