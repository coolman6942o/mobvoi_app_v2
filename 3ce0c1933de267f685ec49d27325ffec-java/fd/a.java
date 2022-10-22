package fd;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.e;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.companion.WearableModule;
import com.mobvoi.companion.wear.WearPairingPool;
import com.mobvoi.wear.common.base.TicwatchModels;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.info.CapabilityHelper;
import com.mobvoi.wear.info.CompanionInfo;
import com.mobvoi.wear.info.WearInfo;
import com.mobvoi.wear.msgproxy.MessageInfo;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyReceiver;
import com.mobvoi.wear.msgproxy.NodeInfo;
import java.util.List;
import of.h;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: WearMessageReceiver.java */
/* loaded from: classes2.dex */
public class a extends MessageProxyReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static a f26400a = new a();

    private a() {
    }

    private static String a() {
        String c10 = b.c();
        if (c10 == null) {
            c10 = "";
        }
        return c10.startsWith("tic_") ? c10.replace("tic_", "") : c10;
    }

    public static a b() {
        return f26400a;
    }

    public static void c() {
        Application e10 = b.e();
        CompanionInfo companionInfo = new CompanionInfo();
        companionInfo.wwid = ta.a.x();
        companionInfo.accountId = ta.a.d();
        companionInfo.sessionId = ta.a.s();
        companionInfo.nickName = ta.a.n();
        companionInfo.phoneNumber = ta.a.p();
        companionInfo.sex = AccountConstant.Sex.values()[ta.a.t()].name();
        companionInfo.height = ta.a.k();
        companionInfo.weight = ta.a.w();
        companionInfo.birthday = ta.a.f();
        companionInfo.headUrl = ta.a.j();
        companionInfo.isVpa = WearableModule.getInstance().isVpa();
        companionInfo.model = Build.MODEL;
        companionInfo.systemVersion = Build.VERSION.RELEASE;
        companionInfo.versionName = a();
        companionInfo.versionCode = String.valueOf(b.a());
        companionInfo.deviceId = e.e(e10);
        companionInfo.capabilities = CapabilityHelper.getAppCapabilities(e10);
        companionInfo.unit = com.mobvoi.companion.base.settings.a.getUnit(e10);
        companionInfo.temperature = com.mobvoi.companion.base.settings.a.getTempUnit(e10);
        companionInfo.dateformat = com.mobvoi.companion.base.settings.a.getDateFormat(e10);
        String s10 = new com.google.gson.e().s(companionInfo);
        k.c("WearMessageReceiver", "Send companion_info: %s", s10);
        MessageProxyClient.getInstance().sendMessage(WearPath.Companion.SEND_COMPANION_INFO, s10.getBytes());
    }

    public static void d(List<NodeInfo> list) {
        for (NodeInfo nodeInfo : list) {
            WearInfo i10 = com.mobvoi.companion.wear.a.f().i(nodeInfo.getId());
            if (i10 != null && TicwatchModels.isOverseaRoverU(i10.wearType)) {
                e(nodeInfo.getId());
            }
        }
    }

    public static void e(String str) {
        MessageProxyClient.getInstance().sendMessage(str, WearPath.Health.CMD_CHANGE_HEART_HEALTH_SWITCH, h.b().e(b.e()).getBytes());
    }

    private void f(String str, byte[] bArr) {
        String str2 = new String(bArr);
        k.c("WearMessageReceiver", "updateWearInfo: nodeId %s, data %s", str, str2);
        try {
            WearInfo wearInfo = (WearInfo) new com.google.gson.e().j(str2, WearInfo.class);
            sb.a.c(wearInfo.wearDeviceId, wearInfo.btAddress, wearInfo.wearType);
            if (TextUtils.isEmpty(wearInfo.wearVersion)) {
                WearPairingPool.i().x(str, wearInfo, str2);
            } else {
                com.mobvoi.companion.wear.a.f().l(str, wearInfo, str2);
            }
        } catch (Exception e10) {
            k.r("WearMessageReceiver", "Failed to update wear info", e10, new Object[0]);
        }
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyReceiver, com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onConnectedNodesChanged(List<NodeInfo> list) {
        k.c("WearMessageReceiver", "onConnectedNodesChanged: %s", list);
        if (list.size() > 0) {
            c();
            d(list);
        }
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyReceiver, com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onMessageReceived(MessageInfo messageInfo) {
        k.c("WearMessageReceiver", "onMessageReceived: %s", messageInfo);
        String nodeId = messageInfo.getNodeId();
        String path = messageInfo.getPath();
        byte[] payload = messageInfo.getPayload();
        if (WearPath.Companion.SYNC_WEAR_INFO.equals(path)) {
            f(nodeId, payload);
        } else if (WearPath.Companion.SYNC_WEAR_BATTERY.equals(path)) {
            int parseInt = Integer.parseInt(new String(payload));
            k.c("WearMessageReceiver", "onMessageReceived from %s: %s, battery: %d %%", nodeId, path, Integer.valueOf(parseInt));
            WearPairingPool.i().u(nodeId, parseInt);
        } else if (WearPath.Companion.GET_PHONE_BATTERY.equals(path)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("level", w9.a.b(b.e()).f36158c);
                jSONObject.put("scale", 100);
                MessageProxyClient.getInstance().sendMessage(nodeId, WearPath.Companion.GET_PHONE_BATTERY, jSONObject.toString().getBytes());
            } catch (JSONException e10) {
                k.e("WearMessageReceiver", "phone battery info send failed", e10);
            }
        }
    }
}
