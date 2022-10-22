package androidx.work;

import java.util.List;
/* compiled from: InputMerger.java */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4746a = k.f("InputMerger");

    public static h a(String str) {
        try {
            return (h) Class.forName(str).newInstance();
        } catch (Exception e10) {
            k c10 = k.c();
            String str2 = f4746a;
            c10.b(str2, "Trouble instantiating + " + str, e10);
            return null;
        }
    }

    public abstract d b(List<d> list);
}
