package okhttp3.internal.connection;

import java.net.Proxy;
/* loaded from: classes3.dex */
public final /* synthetic */ class g {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f32015a;

    static {
        int[] iArr = new int[Proxy.Type.values().length];
        f32015a = iArr;
        iArr[Proxy.Type.DIRECT.ordinal()] = 1;
        iArr[Proxy.Type.HTTP.ordinal()] = 2;
    }
}
