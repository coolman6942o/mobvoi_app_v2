package com.liulishuo.filedownloader.event;

import l9.b;
/* loaded from: classes2.dex */
public class DownloadServiceConnectChangedEvent extends b {

    /* loaded from: classes2.dex */
    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
    }
}
