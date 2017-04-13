package cctv.cn.ipanda.model.db.db_dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 张志远 on 2017/4/13.
 */
@Entity
public class LoginEntityDb {

    @Id(autoincrement = true)
    private Long id;
    private String timestamp;
    private String ticket;
    private String errType;
    private String errMsg;
    private String userSeqId;
    private String usrid;
    @Generated(hash = 1498594597)
    public LoginEntityDb(Long id, String timestamp, String ticket, String errType,
            String errMsg, String userSeqId, String usrid) {
        this.id = id;
        this.timestamp = timestamp;
        this.ticket = ticket;
        this.errType = errType;
        this.errMsg = errMsg;
        this.userSeqId = userSeqId;
        this.usrid = usrid;
    }
    @Generated(hash = 96095618)
    public LoginEntityDb() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTimestamp() {
        return this.timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public String getTicket() {
        return this.ticket;
    }
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    public String getErrType() {
        return this.errType;
    }
    public void setErrType(String errType) {
        this.errType = errType;
    }
    public String getErrMsg() {
        return this.errMsg;
    }
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
    public String getUserSeqId() {
        return this.userSeqId;
    }
    public void setUserSeqId(String userSeqId) {
        this.userSeqId = userSeqId;
    }
    public String getUsrid() {
        return this.usrid;
    }
    public void setUsrid(String usrid) {
        this.usrid = usrid;
    }


}
