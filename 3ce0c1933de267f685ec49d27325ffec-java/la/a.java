package la;

import java.util.UUID;
import kotlin.jvm.internal.i;
/* compiled from: Constants.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30445a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final UUID f30446b;

    /* renamed from: c  reason: collision with root package name */
    private static final UUID f30447c;

    static {
        UUID fromString = UUID.fromString("0000fea6-0000-1000-8000-00805f9b34fb");
        i.e(fromString, "fromString(\"0000fea6-0000-1000-8000-00805f9b34fb\")");
        f30446b = fromString;
        UUID fromString2 = UUID.fromString("0000fea6-0010-4135-bc55-d47637b5332e");
        i.e(fromString2, "fromString(\"0000fea6-0010-4135-bc55-d47637b5332e\")");
        f30447c = fromString2;
    }

    private a() {
    }

    public final UUID a() {
        return f30446b;
    }

    public final UUID b() {
        return f30447c;
    }
}
