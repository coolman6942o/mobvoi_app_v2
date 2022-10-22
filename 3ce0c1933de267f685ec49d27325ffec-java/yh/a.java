package yh;

import com.mobvoi.android.common.json.JsonBean;
import h8.c;
/* compiled from: CardRequest.java */
/* loaded from: classes2.dex */
public class a implements JsonBean {
    @c("client_type")
    public String clientType;
    @c("context")
    public C0539a context;
    @c("device_id")
    public String deviceId;
    @c("token")
    public String token;
    @c("vpa_version")
    public String version;
    @c("wwid")
    public String wwid;

    /* compiled from: CardRequest.java */
    /* renamed from: yh.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0539a implements JsonBean {
        @c("location_context")
        public b location;
        @c("current_mode")
        public String mode;
        @c("timestamp_seconds")
        public long timestamp;
    }

    /* compiled from: CardRequest.java */
    /* loaded from: classes2.dex */
    public static class b implements JsonBean {
        @c("address")
        public String address;
        @c("latitude")
        public double latitude;
        @c("longitude")
        public double longitude;
    }
}
