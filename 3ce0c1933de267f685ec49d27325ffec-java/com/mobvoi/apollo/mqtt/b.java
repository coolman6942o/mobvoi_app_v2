package com.mobvoi.apollo.mqtt;

import android.util.Base64;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.ble.BleProtocol;
import io.d;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.e;
import okhttp3.f;
import okhttp3.w;
import okhttp3.y;
import okhttp3.z;
import org.json.JSONObject;
/* compiled from: MqttClientManager.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    private static final d f15575c;

    /* renamed from: e  reason: collision with root package name */
    private static final d f15577e;

    /* renamed from: a  reason: collision with root package name */
    public static final b f15573a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final com.mobvoi.apollo.mqtt.c f15574b = new com.mobvoi.apollo.mqtt.c();

    /* renamed from: d  reason: collision with root package name */
    private static final w f15576d = w.f32297g.a("application/json; charset=utf-8");

    /* compiled from: MqttClientManager.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements qo.a<String> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        @Override // qo.a
        public final String invoke() {
            String str = b.f15574b.d() + ':' + b.f15574b.b();
            Charset charset = kotlin.text.d.f30092a;
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes = str.getBytes(charset);
            i.e(bytes, "(this as java.lang.String).getBytes(charset)");
            return Base64.encodeToString(bytes, 2);
        }
    }

    /* compiled from: MqttClientManager.kt */
    /* renamed from: com.mobvoi.apollo.mqtt.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0193b implements f {
        C0193b() {
        }

        @Override // okhttp3.f
        public void onFailure(e call, IOException e10) {
            i.f(call, "call");
            i.f(e10, "e");
            k.a("AndroidMqttClient", e10.getMessage());
        }

        @Override // okhttp3.f
        public void onResponse(e call, b0 response) {
            i.f(call, "call");
            i.f(response, "response");
            if (response.E()) {
                c0 c10 = response.c();
                k.a("AndroidMqttClient", c10 == null ? null : c10.string());
                return;
            }
            k.a("AndroidMqttClient", response.I());
        }
    }

    /* compiled from: MqttClientManager.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements qo.a<y> {
        public static final c INSTANCE = new c();

        c() {
            super(0);
        }

        @Override // qo.a
        public final y invoke() {
            return new y();
        }
    }

    static {
        d a10;
        d a11;
        a10 = io.f.a(a.INSTANCE);
        f15575c = a10;
        a11 = io.f.a(c.INSTANCE);
        f15577e = a11;
    }

    private b() {
    }

    private final String b() {
        Object value = f15575c.getValue();
        i.e(value, "<get-basic>(...)");
        return (String) value;
    }

    private final y c() {
        return (y) f15577e.getValue();
    }

    public static final void d(String msg) {
        i.f(msg, "msg");
        com.mobvoi.apollo.mqtt.c cVar = f15574b;
        if (!(cVar.a().length() == 0)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("topic", cVar.c());
            jSONObject.put("clientid", i.n(cVar.a(), "_VPA"));
            jSONObject.put(BleProtocol.EXTRA_PAYLOAD, msg);
            jSONObject.put("encoding", "plain");
            jSONObject.put("qos", 0);
            jSONObject.put("retain", false);
            z.a aVar = new z.a();
            b bVar = f15573a;
            z.a p10 = aVar.a("Authorization", i.n("Basic ", bVar.b())).p("https://mqtt.mobvoi.com/api/v4/mqtt/publish");
            a0.a aVar2 = a0.Companion;
            String jSONObject2 = jSONObject.toString();
            i.e(jSONObject2, "params.toString()");
            bVar.c().a(p10.l(aVar2.b(jSONObject2, f15576d)).b()).h(new C0193b());
        }
    }

    public static final void e(String str) {
        if (!(str == null || str.length() == 0)) {
            f15574b.e(str);
        }
    }
}
