package cd;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.mobvoi.companion.map.d;
import com.mobvoi.companion.map.f;
import com.mobvoi.companion.map.g;
import com.mobvoi.companion.map.i;
import dd.c;
/* compiled from: GoogleMapViewHelper.java */
/* loaded from: classes2.dex */
public class b implements h {

    /* renamed from: a  reason: collision with root package name */
    private d f5717a;

    @Override // cd.h
    public i a(ViewGroup viewGroup) {
        return new f().d(LayoutInflater.from(viewGroup.getContext()).inflate(c.a_res_0x7f0e01a1, viewGroup, true), dd.b.f25607a);
    }

    @Override // cd.h
    public g b() {
        if (this.f5717a == null) {
            this.f5717a = new d();
        }
        return this.f5717a;
    }
}
