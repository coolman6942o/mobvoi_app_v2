package com.mobvoi.ticcare.common.model.bean;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.companion.TicAppConstants;
import dk.c;
import java.util.List;
/* compiled from: MyCareWatchResult.java */
/* loaded from: classes2.dex */
public class b extends c {
    @h8.c("data")
    public List<a> data;

    /* compiled from: MyCareWatchResult.java */
    /* loaded from: classes2.dex */
    public static class a implements JsonBean {
        @h8.c("accountId")
        public String accountId;
        @h8.c("deviceId")
        public String deviceId;
        @h8.c(TicAppConstants.CARE_DEVICE_NAME)
        public String deviceName;
        @h8.c("headImgUrl")
        public String headImgUrl;
        @h8.c("nickName")
        public String nickName;
        @h8.c(TicAppConstants.CARE_REMARK_NAME)
        public String remarkName;
        @h8.c("settings")
        public List<C0242a> settings;
        @h8.c("wwid")
        public String wwid;

        /* compiled from: MyCareWatchResult.java */
        /* renamed from: com.mobvoi.ticcare.common.model.bean.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0242a implements JsonBean {
            @h8.c("shareDataStatus")
            public boolean shareDataStatus;
            @h8.c("shareDataType")
            public String shareDataType;
        }
    }
}
