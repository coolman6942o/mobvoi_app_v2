package e3;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* compiled from: MaskKeyframeAnimation.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<i3.g, Path>> f25743a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a<Integer, Integer>> f25744b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Mask> f25745c;

    public g(List<Mask> list) {
        this.f25745c = list;
        this.f25743a = new ArrayList(list.size());
        this.f25744b = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.f25743a.add(list.get(i10).b().a());
            this.f25744b.add(list.get(i10).c().a());
        }
    }

    public List<a<i3.g, Path>> a() {
        return this.f25743a;
    }

    public List<Mask> b() {
        return this.f25745c;
    }

    public List<a<Integer, Integer>> c() {
        return this.f25744b;
    }
}
