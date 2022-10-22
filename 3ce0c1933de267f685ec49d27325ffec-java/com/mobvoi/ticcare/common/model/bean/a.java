package com.mobvoi.ticcare.common.model.bean;

import com.mobvoi.android.common.json.JsonBean;
import dk.c;
import java.util.List;
/* compiled from: CareMeResult.java */
/* loaded from: classes2.dex */
public class a extends c {
    @h8.c("data")
    public List<C0241a> data;

    /* compiled from: CareMeResult.java */
    /* renamed from: com.mobvoi.ticcare.common.model.bean.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0241a implements JsonBean {
        @h8.c("accountId")
        public String accountId;
        @h8.c("headImgUrl")
        public String headImgUrl;
        @h8.c("nickName")
        public String nickName;
        @h8.c("wwid")
        public String wwid;
    }
}
