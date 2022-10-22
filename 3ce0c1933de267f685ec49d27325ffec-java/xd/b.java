package xd;

import retrofit2.http.GET;
import rx.c;
/* compiled from: UnitApi.java */
/* loaded from: classes2.dex */
public interface b {
    @GET("api/config/mobile/extra/region_default_unit")
    c<String> a();
}
