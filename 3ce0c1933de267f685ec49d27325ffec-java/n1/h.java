package n1;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;
/* compiled from: PathProperty.java */
/* loaded from: classes.dex */
class h<T> extends Property<T, Float> {

    /* renamed from: a  reason: collision with root package name */
    private final Property<T, PointF> f30905a;

    /* renamed from: b  reason: collision with root package name */
    private final PathMeasure f30906b;

    /* renamed from: c  reason: collision with root package name */
    private final float f30907c;

    /* renamed from: d  reason: collision with root package name */
    private final float[] f30908d = new float[2];

    /* renamed from: e  reason: collision with root package name */
    private final PointF f30909e = new PointF();

    /* renamed from: f  reason: collision with root package name */
    private float f30910f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f30905a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f30906b = pathMeasure;
        this.f30907c = pathMeasure.getLength();
    }

    /* renamed from: a */
    public Float get(T t10) {
        return Float.valueOf(this.f30910f);
    }

    /* renamed from: b */
    public void set(T t10, Float f10) {
        this.f30910f = f10.floatValue();
        this.f30906b.getPosTan(this.f30907c * f10.floatValue(), this.f30908d, null);
        PointF pointF = this.f30909e;
        float[] fArr = this.f30908d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f30905a.set(t10, pointF);
    }
}
