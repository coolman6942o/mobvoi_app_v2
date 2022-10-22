package gf;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.mobvoi.fitness.core.data.bt.d;
import com.mobvoi.health.common.data.pojo.SportType;
import com.mobvoi.wear.common.base.WearPath;
/* compiled from: BtShareServer.java */
/* loaded from: classes2.dex */
public abstract class e extends d {

    /* renamed from: f  reason: collision with root package name */
    private Context f27451f;

    public e(Context context) {
        super(WearPath.Sports.SPORTS_SHARE);
        this.f27451f = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // gf.d
    public void k(String str) {
        d b10 = d.b(str);
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.putExtra("sportId", b10.f17904id);
        intent.putExtra("type", SportType.from(b10.type));
        intent.setComponent(new ComponentName(this.f27451f.getPackageName(), "com.mobvoi.companion.health.share.HealthShareActivity"));
        this.f27451f.startActivity(intent);
    }
}
