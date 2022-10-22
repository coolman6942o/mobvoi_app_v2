package v9;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.util.TelephonyUtil;
import com.unionpay.tsmservice.data.Constant;
/* compiled from: WeatherInfoResponse.java */
/* loaded from: classes2.dex */
public class e implements JsonBean {
    @h8.c("errCode")
    public int errCode;
    @h8.c("errMsg")
    public String errMsg;
    @h8.c("result")
    public d result;

    /* compiled from: WeatherInfoResponse.java */
    /* loaded from: classes2.dex */
    public static class a implements JsonBean {
        @h8.c("data")
        public b data;
    }

    /* compiled from: WeatherInfoResponse.java */
    /* loaded from: classes2.dex */
    public static class b implements JsonBean {
        @h8.c("detailUrl")
        public String detailUrl;
        @h8.c(Constant.KEY_PARAMS)
        public c params;
        @h8.c(TelephonyUtil.KEY_SIM_ACTIVITIED_SOURCE)
        public String source;
        @h8.c("sourceHost")
        public String sourceHost;
        @h8.c("type")
        public String type;
    }

    /* compiled from: WeatherInfoResponse.java */
    /* loaded from: classes2.dex */
    public static class c implements JsonBean {
        @h8.c("hourlyData")
        public v9.a[] hourlyData;
        @h8.c("queryDate")
        public v9.d mQueriesDay;
        @h8.c("pageData")
        public v9.a[] pageData;
        @h8.c("weatherType")
        public String weatherType;
    }

    /* compiled from: WeatherInfoResponse.java */
    /* loaded from: classes2.dex */
    public static class d implements JsonBean {
        @h8.c("clientData")
        public a clientData;
    }
}
