package j9;

import r9.b;
/* compiled from: DefaultConnectionCountAdapter.java */
/* loaded from: classes2.dex */
public class a implements b.a {
    @Override // r9.b.a
    public int a(int i10, String str, String str2, long j10) {
        if (j10 < 1048576) {
            return 1;
        }
        if (j10 < 5242880) {
            return 2;
        }
        if (j10 < 52428800) {
            return 3;
        }
        return j10 < 104857600 ? 4 : 5;
    }
}
