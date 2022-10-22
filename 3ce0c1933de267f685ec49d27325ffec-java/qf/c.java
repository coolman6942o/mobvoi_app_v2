package qf;

import ag.d;
import android.text.TextUtils;
import com.mobvoi.health.common.data.pojo.ActivityType;
import java.util.Locale;
import yf.e;
/* compiled from: DataSession.java */
/* loaded from: classes2.dex */
public class c extends b<ActivityType> {

    /* renamed from: i  reason: collision with root package name */
    public String f33133i = "";

    public c() {
        super(ActivityType.class);
    }

    public static c d(d dVar) {
        c cVar = new c();
        cVar.f33127c = dVar.activity;
        String str = dVar.device_id;
        if (str == null) {
            str = "";
        }
        cVar.f33125a = str;
        cVar.f33126b = dVar.wwid;
        cVar.f33129e = dVar.time_from;
        cVar.f33128d = dVar.time_to;
        cVar.f33133i = dVar.sid;
        cVar.f33131g = dVar.deleted;
        cVar.f33130f = 1;
        return cVar;
    }

    public boolean e() {
        if (this.f33127c != -1) {
            long j10 = this.f33129e;
            if (j10 > e.f37076a) {
                long j11 = this.f33128d;
                if ((j11 == 0 || j10 <= j11) && (j11 == 0 || j11 - j10 < e.f37078c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f33127c == cVar.f33127c && this.f33129e == cVar.f33129e && this.f33128d == cVar.f33128d && this.f33131g == cVar.f33131g && this.f33130f == cVar.f33130f && this.f33133i.equals(cVar.f33133i) && TextUtils.equals(this.f33126b, cVar.f33126b) && TextUtils.equals(this.f33125a, cVar.f33125a);
    }

    public String toString() {
        return String.format(Locale.US, "DataSession[{%s ~ %s}, %s, synced=%s, deleted=%s, wwid=%s, did=%s, sid=%s]", com.mobvoi.android.common.utils.d.a(this.f33129e), com.mobvoi.android.common.utils.d.a(this.f33128d), c(), Integer.valueOf(this.f33130f), Integer.valueOf(this.f33131g), this.f33126b, this.f33125a, this.f33133i);
    }

    public c(ActivityType activityType, long j10, long j11) {
        super(activityType, j10, j11);
    }
}
