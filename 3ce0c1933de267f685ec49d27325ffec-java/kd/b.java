package kd;

import android.view.View;
import com.amap.api.services.core.AMapException;
import com.mobvoi.companion.profile.h;
import com.mobvoi.health.common.data.pojo.DataType;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import jd.k;
/* compiled from: BirthdayQuestionChanger.java */
/* loaded from: classes2.dex */
public class b extends a {
    public b(h hVar, long j10) {
        super(hVar, j10);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Long, E] */
    @Override // kd.a, jd.k
    protected void j(View view) {
        int value = this.f29866f.getValue() + AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR;
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, value);
        calendar.set(2, (this.f29867g.getValue() + 1) - 1);
        calendar.set(5, this.f29868h.getValue() + 1);
        ?? valueOf = Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(calendar.getTimeInMillis()));
        this.f29541c = valueOf;
        m(DataType.InfoBirthday, (float) ((Long) valueOf).longValue());
        k.a aVar = this.f29543e;
        if (aVar != null) {
            aVar.k(2, this.f29541c);
        }
    }
}
