package x;

import android.view.View;
import s.c;
import s.f;
/* compiled from: ViewTimeCycle.java */
/* loaded from: classes.dex */
public abstract class d extends f {

    /* compiled from: ViewTimeCycle.java */
    /* loaded from: classes.dex */
    public static class a extends d {
        @Override // x.d
        public boolean b(View view, float f10, long j10, c cVar) {
            return this.f34225h;
        }

        public boolean c(View view, c cVar, float f10, long j10, double d10, double d11) {
            view.setRotation(a(f10, j10, view, cVar) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
            return this.f34225h;
        }
    }

    public float a(float f10, long j10, View view, c cVar) {
        this.f34218a.c(f10, this.f34224g);
        float[] fArr = this.f34224g;
        float f11 = fArr[1];
        if (f11 == 0.0f) {
            this.f34225h = false;
            return fArr[2];
        } else if (Float.isNaN(this.f34227j)) {
            throw null;
        } else {
            this.f34227j = (float) ((this.f34227j + (((j10 - this.f34226i) * 1.0E-9d) * f11)) % 1.0d);
            throw null;
        }
    }

    public abstract boolean b(View view, float f10, long j10, c cVar);
}
