package wc;

import com.mobvoi.android.common.json.JsonBean;
/* compiled from: CheckStateResponseBean.java */
/* loaded from: classes2.dex */
public class c extends sa.c {
    public a runkeeper;
    public b strava;

    /* compiled from: CheckStateResponseBean.java */
    /* loaded from: classes2.dex */
    public static class a implements JsonBean {
        private boolean oauth;

        public boolean a() {
            return this.oauth;
        }
    }

    /* compiled from: CheckStateResponseBean.java */
    /* loaded from: classes2.dex */
    public static class b implements JsonBean {
        private boolean oauth;

        public boolean a() {
            return this.oauth;
        }
    }

    public boolean g() {
        a aVar = this.runkeeper;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    public boolean h() {
        b bVar = this.strava;
        if (bVar != null) {
            return bVar.a();
        }
        return false;
    }
}
