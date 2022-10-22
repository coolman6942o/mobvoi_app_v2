package d3;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import k3.h;
/* compiled from: CompoundTrimPathContent.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private List<s> f25015a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(s sVar) {
        this.f25015a.add(sVar);
    }

    public void b(Path path) {
        for (int size = this.f25015a.size() - 1; size >= 0; size--) {
            h.b(path, this.f25015a.get(size));
        }
    }
}
