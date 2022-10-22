package g3;

import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* compiled from: KeyPath.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f27237a;

    /* renamed from: b  reason: collision with root package name */
    private e f27238b;

    public d(String... strArr) {
        this.f27237a = Arrays.asList(strArr);
    }

    private boolean b() {
        List<String> list = this.f27237a;
        return list.get(list.size() - 1).equals("**");
    }

    private boolean f(String str) {
        return "__container".equals(str);
    }

    public d a(String str) {
        d dVar = new d(this);
        dVar.f27237a.add(str);
        return dVar;
    }

    public boolean c(String str, int i10) {
        if (i10 >= this.f27237a.size()) {
            return false;
        }
        boolean z10 = i10 == this.f27237a.size() - 1;
        String str2 = this.f27237a.get(i10);
        if (!str2.equals("**")) {
            return (z10 || (i10 == this.f27237a.size() + (-2) && b())) && (str2.equals(str) || str2.equals(MessageProxyConstants.NODE_ID_ANY));
        }
        if (!z10 && this.f27237a.get(i10 + 1).equals(str)) {
            return i10 == this.f27237a.size() + (-2) || (i10 == this.f27237a.size() + (-3) && b());
        }
        if (z10) {
            return true;
        }
        int i11 = i10 + 1;
        if (i11 < this.f27237a.size() - 1) {
            return false;
        }
        return this.f27237a.get(i11).equals(str);
    }

    public e d() {
        return this.f27238b;
    }

    public int e(String str, int i10) {
        if (f(str)) {
            return 0;
        }
        if (!this.f27237a.get(i10).equals("**")) {
            return 1;
        }
        return (i10 != this.f27237a.size() - 1 && this.f27237a.get(i10 + 1).equals(str)) ? 2 : 0;
    }

    public boolean g(String str, int i10) {
        if (f(str)) {
            return true;
        }
        if (i10 >= this.f27237a.size()) {
            return false;
        }
        return this.f27237a.get(i10).equals(str) || this.f27237a.get(i10).equals("**") || this.f27237a.get(i10).equals(MessageProxyConstants.NODE_ID_ANY);
    }

    public boolean h(String str, int i10) {
        return "__container".equals(str) || i10 < this.f27237a.size() - 1 || this.f27237a.get(i10).equals("**");
    }

    public d i(e eVar) {
        d dVar = new d(this);
        dVar.f27238b = eVar;
        return dVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("KeyPath{keys=");
        sb2.append(this.f27237a);
        sb2.append(",resolved=");
        sb2.append(this.f27238b != null);
        sb2.append('}');
        return sb2.toString();
    }

    private d(d dVar) {
        this.f27237a = new ArrayList(dVar.f27237a);
        this.f27238b = dVar.f27238b;
    }
}
