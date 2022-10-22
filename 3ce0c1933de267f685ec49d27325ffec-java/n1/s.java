package n1;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* compiled from: TransitionValues.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: b  reason: collision with root package name */
    public View f30987b;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f30986a = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<m> f30988c = new ArrayList<>();

    @Deprecated
    public s() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f30987b == sVar.f30987b && this.f30986a.equals(sVar.f30986a);
    }

    public int hashCode() {
        return (this.f30987b.hashCode() * 31) + this.f30986a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f30987b + "\n") + "    values:";
        for (String str2 : this.f30986a.keySet()) {
            str = str + "    " + str2 + ": " + this.f30986a.get(str2) + "\n";
        }
        return str;
    }

    public s(View view) {
        this.f30987b = view;
    }
}
