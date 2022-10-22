package com.mobvoi.wear.msgproxy.server;

import android.content.Context;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyService;
import com.mobvoi.wear.msgproxy.NodeInfo;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class PhoneMessageProxyService extends MessageProxyService {
    private static void checkInitialized() {
        if (!supportGms() && !supportMms()) {
            throw new RuntimeException("Neither GMS nor MMS is supported. Forgot to init?");
        }
    }

    public static void onAppStart(Context context, boolean z10, boolean z11) {
        MpsConfig.getInstance().init(1, z10, z11);
        MessageProxyClient.getInstance().setStandalone(true);
        if (z10) {
            GmsWearableClient.getInstance(context);
        }
        checkInitialized();
    }

    private static boolean supportGms() {
        return MpsConfig.getInstance().supportGms();
    }

    private static boolean supportMms() {
        return MpsConfig.getInstance().supportMms();
    }

    @Override // android.app.Service
    protected void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (supportGms()) {
            printWriter.append("GMS Local node: ").append((CharSequence) String.valueOf(GmsWearableClient.getInstance(this).getLocalNode()));
            printWriter.println();
        }
        printWriter.append("Connected nodes: ").append((CharSequence) String.valueOf(getConnectedNodes()));
        printWriter.println();
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyService
    public List<NodeInfo> getConnectedNodes() {
        checkInitialized();
        ArrayList arrayList = new ArrayList();
        if (supportGms()) {
            arrayList.addAll(GmsWearableClient.getInstance(this).getConnectedNodes());
        }
        return arrayList;
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyService
    public boolean hasConnectedNodes() {
        checkInitialized();
        return supportGms() && GmsWearableClient.getInstance(this).hasConnectedNodes();
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyService
    public void sendMessage(String str, String str2, byte[] bArr) {
        checkInitialized();
        if (supportGms()) {
            GmsWearableClient.getInstance(this).sendMessage(str, str2, bArr);
        }
    }
}
