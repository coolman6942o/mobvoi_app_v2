package i3;

import com.airbnb.lottie.f;
import com.airbnb.lottie.model.layer.a;
import d3.c;
import d3.d;
import java.util.Arrays;
import java.util.List;
/* compiled from: ShapeGroup.java */
/* loaded from: classes.dex */
public class i implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f28056a;

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f28057b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f28058c;

    public i(String str, List<b> list, boolean z10) {
        this.f28056a = str;
        this.f28057b = list;
        this.f28058c = z10;
    }

    @Override // i3.b
    public c a(f fVar, a aVar) {
        return new d(fVar, aVar, this);
    }

    public List<b> b() {
        return this.f28057b;
    }

    public String c() {
        return this.f28056a;
    }

    public boolean d() {
        return this.f28058c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f28056a + "' Shapes: " + Arrays.toString(this.f28057b.toArray()) + '}';
    }
}
