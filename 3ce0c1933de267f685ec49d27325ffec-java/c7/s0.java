package c7;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.a;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.d;
import com.google.android.gms.wearable.h;
import com.google.android.gms.wearable.internal.g;
import com.google.android.gms.wearable.internal.zzah;
import com.google.android.gms.wearable.internal.zzaw;
import com.google.android.gms.wearable.internal.zzfe;
import com.google.android.gms.wearable.internal.zzfo;
import com.google.android.gms.wearable.internal.zzi;
import com.google.android.gms.wearable.internal.zzl;
import java.util.List;
/* loaded from: classes.dex */
public final class s0<T> extends g {

    /* renamed from: a  reason: collision with root package name */
    private i<d> f5592a;

    /* renamed from: b  reason: collision with root package name */
    private i<h.a> f5593b;

    /* renamed from: c  reason: collision with root package name */
    private i<c> f5594c;

    /* renamed from: d  reason: collision with root package name */
    private i<a.AbstractC0116a> f5595d;

    /* renamed from: e  reason: collision with root package name */
    private final IntentFilter[] f5596e;

    /* renamed from: f  reason: collision with root package name */
    private final String f5597f;

    @Override // com.google.android.gms.wearable.internal.f
    public final void C0(zzfe zzfeVar) {
        i<h.a> iVar = this.f5593b;
        if (iVar != null) {
            iVar.c(new u0(zzfeVar));
        }
    }

    @Override // com.google.android.gms.wearable.internal.f
    public final void D(DataHolder dataHolder) {
        i<d> iVar = this.f5592a;
        if (iVar != null) {
            iVar.c(new t0(dataHolder));
        } else {
            dataHolder.close();
        }
    }

    @Override // com.google.android.gms.wearable.internal.f
    public final void M1(zzl zzlVar) {
    }

    @Override // com.google.android.gms.wearable.internal.f
    public final void T(zzfo zzfoVar) {
    }

    public final String U1() {
        return this.f5597f;
    }

    @Override // com.google.android.gms.wearable.internal.f
    public final void a(zzaw zzawVar) {
        i<c> iVar = this.f5594c;
        if (iVar != null) {
            iVar.c(new v0(zzawVar));
        }
    }

    @Override // com.google.android.gms.wearable.internal.f
    public final void a0(zzah zzahVar) {
        i<a.AbstractC0116a> iVar = this.f5595d;
        if (iVar != null) {
            iVar.c(new w0(zzahVar));
        }
    }

    public final IntentFilter[] m1() {
        return this.f5596e;
    }

    @Override // com.google.android.gms.wearable.internal.f
    public final void s1(zzfo zzfoVar) {
    }

    @Override // com.google.android.gms.wearable.internal.f
    public final void t0(zzi zziVar) {
    }

    @Override // com.google.android.gms.wearable.internal.f
    public final void z2(List<zzfo> list) {
    }
}
