package software.tingle.api;

import kotlin.jvm.internal.i;
import okhttp3.Headers;
/* compiled from: CustomResourceResponse.kt */
/* loaded from: classes3.dex */
public class b<TResource, TError> {

    /* renamed from: a  reason: collision with root package name */
    private final int f35024a;

    /* renamed from: b  reason: collision with root package name */
    private final TResource f35025b;

    /* renamed from: c  reason: collision with root package name */
    private final TError f35026c;

    public b(int i10, Headers headers, TResource tresource, TError terror) {
        i.f(headers, "headers");
        this.f35024a = i10;
        this.f35025b = tresource;
        this.f35026c = terror;
    }

    public final TError a() {
        return this.f35026c;
    }

    public final TResource b() {
        return this.f35025b;
    }

    public final int c() {
        return this.f35024a;
    }

    public boolean d() {
        int i10 = this.f35024a;
        return (200 <= i10 && i10 <= 299) && this.f35026c == null;
    }
}
