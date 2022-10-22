package yd;

import android.app.Application;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.m;
import com.mobvoi.wear.common.base.TicwatchModels;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.mobvoi.wear.info.WearInfo;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyException;
import com.mobvoi.wear.msgproxy.NodeInfo;
import com.mobvoi.wear.util.MsgCallBack;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.i;
import kotlin.text.d;
import lb.c;
import of.h;
/* compiled from: RRIUtil.kt */
/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f37016a = new j();

    /* renamed from: b  reason: collision with root package name */
    private static final a f37017b = new a();

    /* compiled from: RRIUtil.kt */
    /* loaded from: classes2.dex */
    public static final class a implements MsgCallBack {
        a() {
        }

        @Override // com.mobvoi.wear.util.MsgCallBack
        public void sendRRIMsg(String value) {
            i.f(value, "value");
            k.a("RRIUtil", "sendMsg start");
            try {
                List<NodeInfo> connectedNodes = MessageProxyClient.getInstance().getConnectedNodes();
                i.e(connectedNodes, "getInstance().connectedNodes");
                for (NodeInfo nodeInfo : connectedNodes) {
                    k.c("RRIUtil", "sendMsg ing: nodeName = %s , value = %s", nodeInfo.getName(), value);
                    WearInfo i10 = com.mobvoi.companion.wear.a.f().i(nodeInfo.getId());
                    if (i10 != null && TicwatchModels.isOverseaRoverU(i10.wearType)) {
                        MessageProxyClient messageProxyClient = MessageProxyClient.getInstance();
                        String id2 = nodeInfo.getId();
                        byte[] bytes = value.getBytes(d.f30092a);
                        i.e(bytes, "(this as java.lang.String).getBytes(charset)");
                        messageProxyClient.sendMessage(id2, WearPath.Health.CMD_CHANGE_HEART_HEALTH_SWITCH, bytes);
                    }
                }
            } catch (MessageProxyException unused) {
                k.a("UserSettingHelper", "sendMsg MessageProxyException");
            }
        }
    }

    private j() {
    }

    private final String b(Context context) {
        String c10 = c(context);
        return TextUtils.isEmpty(c10) ? Locale.getDefault().getCountry() : c10;
    }

    public final void a() {
        if (TextUtils.isEmpty(ta.a.s())) {
            k.a("RRIUtil", "need login");
        } else if (m.b(b.e())) {
            h b10 = h.b();
            Application e10 = b.e();
            String s10 = ta.a.s();
            String x10 = ta.a.x();
            Application e11 = b.e();
            i.e(e11, "getApplication()");
            b10.f(e10, s10, x10, b(e11), c.k(), f37017b);
        }
    }

    public final String c(Context context) {
        Object systemService;
        String str = "network";
        i.f(context, "context");
        try {
            systemService = context.getSystemService(SharedWearInfoHelper.LocationInfo.TABLE);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (systemService != null) {
            LocationManager locationManager = (LocationManager) systemService;
            if (androidx.core.content.b.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.content.b.a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                k.d("RRIUtil", "GPS true");
                List<String> providers = locationManager.getProviders(true);
                i.e(providers, "locationManager.getProviders(true)");
                if (!providers.contains(str)) {
                    str = providers.contains("gps") ? "gps" : "";
                }
                Location lastKnownLocation = locationManager.getLastKnownLocation(str);
                if (lastKnownLocation != null) {
                    List<Address> fromLocation = new Geocoder(context, Locale.getDefault()).getFromLocation(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude(), 1);
                    if (fromLocation.size() > 0) {
                        return fromLocation.get(0).getCountryCode();
                    }
                }
            }
            return "";
        }
        throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
    }
}
