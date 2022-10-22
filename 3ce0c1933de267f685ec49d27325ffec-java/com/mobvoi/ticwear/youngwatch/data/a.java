package com.mobvoi.ticwear.youngwatch.data;

import com.mobvoi.android.common.json.JsonBean;
import java.util.List;
/* compiled from: McuSportBean.java */
/* loaded from: classes2.dex */
public class a implements JsonBean {
    public List<C0243a> sportPointBeanList;
    public long sportStartTime;

    /* compiled from: McuSportBean.java */
    /* renamed from: com.mobvoi.ticwear.youngwatch.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0243a implements JsonBean {
        public float accuracy;
        public int distance;
        public double latitude;
        public double longitude;
        public float speed;
        public long time;
        public long timestamp;
    }
}
