package cctv.cn.ipanda.model.pandalive;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lenovo on 2017/4/11.
 */

public class PandaLiveJcyiBean {


    /**
     * videoset : {"0":{"vsid":"VSET100284428834","name":"萌团幼儿园","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/8/5/VSETUqphofiMLWG4H6WRjlF5160805.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100284428834","cd":"","zy":"","bj":"","dy":"","js":"4","nf":"2016年","yz":"","fl":"","sbsj":"42544","sbpd":"其他","desc":"这是一档讲述熊猫宝宝有趣故事的节目，每周四更新。每集由若干小版块组成，每个板块讲述一个小故事。我们的主角都是在雅安碧峰峡基地幼儿园里成长的熊孩子们，我们跟随它们的脚步，见证它们的成长，分享它们的喜怒哀乐，这个过程，也是寻找最初的自己的过程。","playdesc":"","zcr":"","fcl":""},"count":"42"}
     * video : [{"vsid":"VSET100284428834","order":"42","vid":"5a534918fac6450ca9961be088f0252f","t":"《萌团幼儿园》 20170405 第四十一集：四小天王齐聚首","url":"http://tv.cntv.cn/video/VSET100284428834/5a534918fac6450ca9961be088f0252f","ptime":"2017-04-05 16:50:53","img":"http://p1.img.cctvpic.com/fmspic/2017/04/05/5a534918fac6450ca9961be088f0252f-75.jpg","len":"00:02:09","em":"CM01"},{"vsid":"VSET100284428834","order":"41","vid":"5885f9f4c8554ddc944f9b5dc85c2871","t":"《萌团幼儿园》 20170329 第四十集：牵手还是抱抱，这是一个问题","url":"http://tv.cntv.cn/video/VSET100284428834/5885f9f4c8554ddc944f9b5dc85c2871","ptime":"2017-03-29 14:17:45","img":"http://p2.img.cctvpic.com/fmspic/2017/03/29/5885f9f4c8554ddc944f9b5dc85c2871-74.jpg","len":"00:02:08","em":"CM01"},{"vsid":"VSET100284428834","order":"40","vid":"267c5c12a37d4b9b85645f273b85d172","t":"《萌团幼儿园》 20170322 第三十九集：绝地反击","url":"http://tv.cntv.cn/video/VSET100284428834/267c5c12a37d4b9b85645f273b85d172","ptime":"2017-03-22 16:20:52","img":"http://p2.img.cctvpic.com/fmspic/2017/03/22/267c5c12a37d4b9b85645f273b85d172-50.jpg","len":"00:01:40","em":"CM01"},{"vsid":"VSET100284428834","order":"39","vid":"a7e79a4580f349db99e8b7743231b375","t":"《萌团幼儿园》 20170316 第三十八集：完全被无视","url":"http://tv.cntv.cn/video/VSET100284428834/a7e79a4580f349db99e8b7743231b375","ptime":"2017-03-16 10:30:36","img":"http://p3.img.cctvpic.com/fmspic/2017/03/16/a7e79a4580f349db99e8b7743231b375-69.jpg","len":"00:01:57","em":"CM01"},{"vsid":"VSET100284428834","order":"38","vid":"81f0527ff54e4341be52d930105f907a","t":"《萌团幼儿园》 20170308 第三十七集：小红球，我们走！","url":"http://tv.cntv.cn/video/VSET100284428834/81f0527ff54e4341be52d930105f907a","ptime":"2017-03-08 14:25:03","img":"http://p4.img.cctvpic.com/fmspic/2017/03/08/81f0527ff54e4341be52d930105f907a-70.jpg","len":"00:02:00","em":"CM01"},{"vsid":"VSET100284428834","order":"37","vid":"458ada293ac24e8d969a462380d70957","t":"《萌团幼儿园》 20170301 第三十六集：抱个大腿容易吗","url":"http://tv.cntv.cn/video/VSET100284428834/458ada293ac24e8d969a462380d70957","ptime":"2017-03-01 15:35:38","img":"http://p1.img.cctvpic.com/fmspic/2017/03/01/458ada293ac24e8d969a462380d70957-89.jpg","len":"00:02:38","em":"CM01"},{"vsid":"VSET100284428834","order":"36","vid":"14cd021078ec4304b0f062f489621cfa","t":"《萌团幼儿园》 20170222 第三十五集：居家小能手","url":"http://tv.cntv.cn/video/VSET100284428834/14cd021078ec4304b0f062f489621cfa","ptime":"2017-02-22 16:54:01","img":"http://p3.img.cctvpic.com/fmspic/2017/02/22/14cd021078ec4304b0f062f489621cfa-50.jpg","len":"00:01:21","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"vsid":"VSET100284428834","name":"萌团幼儿园","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/8/5/VSETUqphofiMLWG4H6WRjlF5160805.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100284428834","cd":"","zy":"","bj":"","dy":"","js":"4","nf":"2016年","yz":"","fl":"","sbsj":"42544","sbpd":"其他","desc":"这是一档讲述熊猫宝宝有趣故事的节目，每周四更新。每集由若干小版块组成，每个板块讲述一个小故事。我们的主角都是在雅安碧峰峡基地幼儿园里成长的熊孩子们，我们跟随它们的脚步，见证它们的成长，分享它们的喜怒哀乐，这个过程，也是寻找最初的自己的过程。","playdesc":"","zcr":"","fcl":""}
         * count : 42
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * vsid : VSET100284428834
             * name : 萌团幼儿园
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/8/5/VSETUqphofiMLWG4H6WRjlF5160805.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100284428834
             * cd :
             * zy :
             * bj :
             * dy :
             * js : 4
             * nf : 2016年
             * yz :
             * fl :
             * sbsj : 42544
             * sbpd : 其他
             * desc : 这是一档讲述熊猫宝宝有趣故事的节目，每周四更新。每集由若干小版块组成，每个板块讲述一个小故事。我们的主角都是在雅安碧峰峡基地幼儿园里成长的熊孩子们，我们跟随它们的脚步，见证它们的成长，分享它们的喜怒哀乐，这个过程，也是寻找最初的自己的过程。
             * playdesc :
             * zcr :
             * fcl :
             */

            private String vsid;
            private String name;
            private String img;
            private String enname;
            private String url;
            private String cd;
            private String zy;
            private String bj;
            private String dy;
            private String js;
            private String nf;
            private String yz;
            private String fl;
            private String sbsj;
            private String sbpd;
            private String desc;
            private String playdesc;
            private String zcr;
            private String fcl;

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }
        }
    }

    public static class VideoBean {
        /**
         * vsid : VSET100284428834
         * order : 42
         * vid : 5a534918fac6450ca9961be088f0252f
         * t : 《萌团幼儿园》 20170405 第四十一集：四小天王齐聚首
         * url : http://tv.cntv.cn/video/VSET100284428834/5a534918fac6450ca9961be088f0252f
         * ptime : 2017-04-05 16:50:53
         * img : http://p1.img.cctvpic.com/fmspic/2017/04/05/5a534918fac6450ca9961be088f0252f-75.jpg
         * len : 00:02:09
         * em : CM01
         */

        private String vsid;
        private String order;
        private String vid;
        private String t;
        private String url;
        private String ptime;
        private String img;
        private String len;
        private String em;

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }
    }
}
