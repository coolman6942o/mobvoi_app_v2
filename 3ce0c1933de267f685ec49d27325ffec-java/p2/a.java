package p2;

import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import f2.c;
import f2.d;
import g2.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ List<d> f32540a = new ArrayList();

    public void a(d dVar) {
        this.f32540a.add(dVar);
    }

    public int b() {
        return this.f32540a.size();
    }

    public c c() throws FMCommunicationMessageException {
        b b10 = d.b();
        if (this.f32540a.size() > 0) {
            return b10.k(this.f32540a.get(0).d());
        }
        return null;
    }

    public c d() throws FMCommunicationMessageException {
        b b10 = d.b();
        g2.d i10 = b10.c((byte) -93);
        for (d dVar : this.f32540a) {
            if (dVar != null) {
                i10.i(b10.k(dVar.d()));
            }
        }
        return i10;
    }
}
