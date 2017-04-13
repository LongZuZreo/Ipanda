package cctv.cn.ipanda.model.panda_login;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 张志远 on 2017/4/13.
 */

public class LoginEntity {


    /**
     * timestamp : 2017-04-13 14:25:36
     * ticket : ca7290a1-2c4d-4abc-b9fc-c4696389dded
     * errType : 0
     * errMsg : 成功
     * sso : []
     * user_seq_id : 54310896
     * usrid : 543108961492054582684
     */

    @SerializedName("timestamp")
    private String timestamp;
    @SerializedName("ticket")
    private String ticket;
    @SerializedName("errType")
    private String errType;
    @SerializedName("errMsg")
    private String errMsg;
    @SerializedName("user_seq_id")
    private String userSeqId;
    @SerializedName("usrid")
    private String usrid;
    @SerializedName("sso")
    private List<?> sso;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getErrType() {
        return errType;
    }

    public void setErrType(String errType) {
        this.errType = errType;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getUserSeqId() {
        return userSeqId;
    }

    public void setUserSeqId(String userSeqId) {
        this.userSeqId = userSeqId;
    }

    public String getUsrid() {
        return usrid;
    }

    public void setUsrid(String usrid) {
        this.usrid = usrid;
    }

    public List<?> getSso() {
        return sso;
    }

    public void setSso(List<?> sso) {
        this.sso = sso;
    }
}
