package w7;

import android.graphics.RectF;
import java.util.Arrays;
/* compiled from: AdjustedCornerSize.java */
/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final c f36010a;

    /* renamed from: b  reason: collision with root package name */
    private final float f36011b;

    public b(float f10, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f36010a;
            f10 += ((b) cVar).f36011b;
        }
        this.f36010a = cVar;
        this.f36011b = f10;
    }

    @Override // w7.c
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f36010a.a(rectF) + this.f36011b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f36010a.equals(bVar.f36010a) && this.f36011b == bVar.f36011b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f36010a, Float.valueOf(this.f36011b)});
    }
}
