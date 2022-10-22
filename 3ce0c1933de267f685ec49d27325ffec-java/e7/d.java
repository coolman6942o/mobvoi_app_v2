package e7;

import android.util.Property;
import android.view.ViewGroup;
import d7.f;
/* compiled from: ChildrenAlphaProperty.java */
/* loaded from: classes.dex */
public class d extends Property<ViewGroup, Float> {

    /* renamed from: a  reason: collision with root package name */
    public static final Property<ViewGroup, Float> f25839a = new d("childrenAlpha");

    private d(String str) {
        super(Float.class, str);
    }

    /* renamed from: a */
    public Float get(ViewGroup viewGroup) {
        Float f10 = (Float) viewGroup.getTag(f.N);
        return f10 != null ? f10 : Float.valueOf(1.0f);
    }

    /* renamed from: b */
    public void set(ViewGroup viewGroup, Float f10) {
        float floatValue = f10.floatValue();
        viewGroup.setTag(f.N, Float.valueOf(floatValue));
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            viewGroup.getChildAt(i10).setAlpha(floatValue);
        }
    }
}
