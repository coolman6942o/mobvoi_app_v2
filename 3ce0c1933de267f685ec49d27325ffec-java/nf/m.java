package nf;

import java.util.ArrayList;
import java.util.List;
/* compiled from: RegistrationHub.java */
/* loaded from: classes2.dex */
public class m implements l {

    /* renamed from: a  reason: collision with root package name */
    private final List<l> f31242a = new ArrayList();

    public void a(l lVar) {
        this.f31242a.add(lVar);
    }

    @Override // nf.l
    public void clear() {
        for (l lVar : this.f31242a) {
            if (!lVar.d()) {
                lVar.clear();
            }
        }
        this.f31242a.clear();
    }

    @Override // nf.l
    public boolean d() {
        return this.f31242a.isEmpty();
    }
}
