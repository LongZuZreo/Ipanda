package cctv.cn.ipanda.common;

/**
 * Created by 张志远 on 2017/4/6.
 */

public class Urls {

    public static final String BASE_URL="http://www.ipanda.com/kehuduan/";
    //熊猫直播
    public static final String PANDALIVE = BASE_URL + "PAGE14501769230331752/index.json";
    //熊猫直播标签
    public static final String PANDALIVEBQ = BASE_URL + "PAGE14501772263221982/index.json";
    //熊猫观察head URl
    public static final String PANDA_OBSERVE_HEAD = BASE_URL + "PAGE14503485387528442/index.json";
    //熊猫观察item URl
    public static final String PANDA_OBSERVE_ITEM = "http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1449807494852603,PAGE1451473625420136,PAGE1449807502866458,PAGE1451473627439140,PAGE1451473547108278,PAGE1451473628934144&serviceId=panda";
    //直播中国Tab
    public static final String PANDA_LIVE_CHINA_TAB=BASE_URL+"PAGE14501775094142282/index.json";
    //熊猫首页
    public static final String HOME_URL = BASE_URL+"PAGE14501749764071042/index.json";
    //CCTV
    public static final String CCTV = BASE_URL+"shipinliebieye/cctvshipindicengye/index.json";

    public static final String PANDACULTURE = "http://www.ipanda.com/kehuduan/xmwh/index.json";


    //互动集合
    public static final String HDJH = BASE_URL+"PAGE14501767715521482/index.json";
    //版本跟新
    public static final String UPDATE_URL = "http://115.182.9.124/index.php?action=release-GetNewVersions&applyName=1426217325";

    public static final String LOGIN_URL="https://reg.cntv.cn/login/login.action";

    //验证码
    public static final String IMAGE_CODE="http://reg.cntv.cn/simple/verificationCode.action";

}
