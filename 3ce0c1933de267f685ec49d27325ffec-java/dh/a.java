package dh;

import android.content.Context;
import com.mobvoi.companion.map.h;
import com.mobvoi.companion.map.i;
import com.mobvoi.health.common.data.pojo.SportType;
import ef.z;
import java.util.List;
/* compiled from: MapWrapper.java */
/* loaded from: classes2.dex */
public class a implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private h f25613a;

    /* renamed from: b  reason: collision with root package name */
    private i f25614b;

    public a(Context context, i iVar, SportType sportType) {
        this.f25614b = iVar;
        b.d().f(sportType);
        iVar.a(this);
    }

    public void a() {
        h hVar = this.f25613a;
        if (hVar != null) {
            hVar.e(false);
        }
        this.f25613a = null;
        this.f25614b.onDestroy();
        this.f25614b.release();
    }

    public void b() {
        this.f25614b.onPause();
    }

    public void c() {
        this.f25614b.onResume();
    }

    @Override // com.mobvoi.companion.map.i.a
    public void d(h hVar) {
        this.f25613a = hVar;
        b.d().i(hVar);
    }

    public void e(List<z> list) {
        b.d().j(list, this.f25613a);
    }
}
