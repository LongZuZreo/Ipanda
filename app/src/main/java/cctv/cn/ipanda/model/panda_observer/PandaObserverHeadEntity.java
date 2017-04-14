package cctv.cn.ipanda.model.panda_observer;

import java.util.List;

/**
 * Created by hp1 on 2017-04-07.
 */

public class PandaObserverHeadEntity {

    /**
     * data : {"bigImg":[{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/4/14/1492148398988_899.jpg","title":"奶爸竟然也会撒娇","url":"http://live.ipanda.com/2017/04/13/VIDE7aan9pIhzhUU3sK25HtD170413.shtml","id":"TITE1492148401826633","type":"2","stype":"","pid":"1b8e93d2d4a446308bfb1d4e60cc6ee9","vid":"","order":"1"}],"listurl":"http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1449807494852603,PAGE1451473625420136,PAGE1449807502866458,PAGE1451473627439140,PAGE1451473547108278,PAGE1451473628934144&serviceId=panda"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * bigImg : [{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/4/14/1492148398988_899.jpg","title":"奶爸竟然也会撒娇","url":"http://live.ipanda.com/2017/04/13/VIDE7aan9pIhzhUU3sK25HtD170413.shtml","id":"TITE1492148401826633","type":"2","stype":"","pid":"1b8e93d2d4a446308bfb1d4e60cc6ee9","vid":"","order":"1"}]
         * listurl : http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1449807494852603,PAGE1451473625420136,PAGE1449807502866458,PAGE1451473627439140,PAGE1451473547108278,PAGE1451473628934144&serviceId=panda
         */

        private String listurl;
        private List<BigImgBean> bigImg;

        public String getListurl() {
            return listurl;
        }

        public void setListurl(String listurl) {
            this.listurl = listurl;
        }

        public List<BigImgBean> getBigImg() {
            return bigImg;
        }

        public void setBigImg(List<BigImgBean> bigImg) {
            this.bigImg = bigImg;
        }

        public static class BigImgBean {
            /**
             * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/4/14/1492148398988_899.jpg
             * title : 奶爸竟然也会撒娇
             * url : http://live.ipanda.com/2017/04/13/VIDE7aan9pIhzhUU3sK25HtD170413.shtml
             * id : TITE1492148401826633
             * type : 2
             * stype :
             * pid : 1b8e93d2d4a446308bfb1d4e60cc6ee9
             * vid :
             * order : 1
             */

            private String image;
            private String title;
            private String url;
            private String id;
            private String type;
            private String stype;
            private String pid;
            private String vid;
            private String order;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getStype() {
                return stype;
            }

            public void setStype(String stype) {
                this.stype = stype;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getVid() {
                return vid;
            }

            public void setVid(String vid) {
                this.vid = vid;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }
        }
    }
}
