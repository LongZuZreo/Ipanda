package cctv.cn.ipanda.model.panada_hdjh;

import java.util.List;

/**
 * Created by ASUS on 2017/4/12.
 */

public class PanadaInterfactionBean {

    private List<InteractiveBean> interactive;

    public List<InteractiveBean> getInteractive() {
        return interactive;
    }

    public void setInteractive(List<InteractiveBean> interactive) {
        this.interactive = interactive;
    }

    public static class InteractiveBean {
        /**
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/4/11/1491874112281_168.jpg
         * title : 最美人间四月天 这里的春天你还没看过？
         * url : http://webapp.cctv.com/h5/livechina/U8032835S99J.html
         * order : 1
         */

        private String image;
        private String title;
        private String url;
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

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
