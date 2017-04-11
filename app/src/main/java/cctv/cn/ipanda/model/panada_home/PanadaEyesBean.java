package cctv.cn.ipanda.model.panada_home;

import java.util.List;

/**
 * Created by ASUS on 2017/4/11.
 */

public class PanadaEyesBean {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * url : http://panview.ipanda.com/2017/04/11/VIDEtbcKqQFot7cncyca090M170411.shtml
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/4/11/1491879130175_933.jpg
         * title : 四川卧龙：大熊猫“星雅”“武雯”将赴荷兰
         * videoLength : 01:43
         * id : TITE1491879061349288
         * daytime : 2017-04-11
         * type : 2
         * pid : 1df7af06af2545c6abc39138d85248b3
         * vid :
         * order : 1
         */

        private String url;
        private String image;
        private String title;
        private String videoLength;
        private String id;
        private String daytime;
        private String type;
        private String pid;
        private String vid;
        private String order;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

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

        public String getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(String videoLength) {
            this.videoLength = videoLength;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDaytime() {
            return daytime;
        }

        public void setDaytime(String daytime) {
            this.daytime = daytime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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
