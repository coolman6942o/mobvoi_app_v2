package y8;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.a;
/* compiled from: AbstractExpandedDecoder.java */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    private final a f36779a;

    /* renamed from: b  reason: collision with root package name */
    private final s f36780b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.f36779a = aVar;
        this.f36780b = new s(aVar);
    }

    public static j a(a aVar) {
        if (aVar.c(1)) {
            return new g(aVar);
        }
        if (!aVar.c(2)) {
            return new k(aVar);
        }
        int g10 = s.g(aVar, 1, 4);
        if (g10 == 4) {
            return new a(aVar);
        }
        if (g10 == 5) {
            return new b(aVar);
        }
        int g11 = s.g(aVar, 1, 5);
        if (g11 == 12) {
            return new c(aVar);
        }
        if (g11 == 13) {
            return new d(aVar);
        }
        switch (s.g(aVar, 1, 7)) {
            case 56:
                return new e(aVar, "310", "11");
            case 57:
                return new e(aVar, "320", "11");
            case 58:
                return new e(aVar, "310", "13");
            case 59:
                return new e(aVar, "320", "13");
            case 60:
                return new e(aVar, "310", "15");
            case 61:
                return new e(aVar, "320", "15");
            case 62:
                return new e(aVar, "310", "17");
            case 63:
                return new e(aVar, "320", "17");
            default:
                throw new IllegalStateException("unknown decoder: " + aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final s b() {
        return this.f36780b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a c() {
        return this.f36779a;
    }

    public abstract String d() throws NotFoundException, FormatException;
}
