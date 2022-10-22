package w7;

import android.graphics.RectF;
import java.util.Arrays;
/* compiled from: AbsoluteCornerSize.java */
/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final float f36009a;

    public a(float f10) {
        this.f36009a = f10;
    }

    @Override // w7.c
    public float a(RectF rectF) {
        return this.f36009a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f36009a == ((a) obj).f36009a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f36009a)});
    }
}
