package software.tingle.api;

import kotlin.jvm.internal.i;
import okhttp3.Headers;
/* compiled from: ResourceResponse.kt */
/* loaded from: classes3.dex */
public class d<TResource> extends b<TResource, c> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i10, Headers headers, TResource tresource, c cVar) {
        super(i10, headers, tresource, cVar);
        i.f(headers, "headers");
    }
}
