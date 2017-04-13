package cctv.cn.ipanda.model.pandalive;

/**
 * Created by lenovo on 2017/4/13.
 */

public class PandaLiveKanLiaoBean {


    /**
     * code : 0
     * msg : success
     * time : 1492066926
     * data : {"src":"cache","fid":"113718","pid":40803409}
     */

    private String code;
    private String msg;
    private int time;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * src : cache
         * fid : 113718
         * pid : 40803409
         */

        private String src;
        private String fid;
        private int pid;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getFid() {
            return fid;
        }

        public void setFid(String fid) {
            this.fid = fid;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }
    }
}
