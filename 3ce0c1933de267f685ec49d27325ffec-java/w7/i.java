package w7;

import android.graphics.RectF;
import java.util.Arrays;
/* compiled from: RelativeCornerSize.java */
/* loaded from: classes.dex */
public final class i implements c {

    /* renamed from: a  reason: collision with root package name */
    private final float f36062a;

    public i(float f10) {
        this.f36062a = f10;
    }

    @Override // w7.c
    public float a(RectF rectF) {
        return this.f36062a * rectF.height();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f36062a == ((i) obj).f36062a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f36062a)});
    }
}
