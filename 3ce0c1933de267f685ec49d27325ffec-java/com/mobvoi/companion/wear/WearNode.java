package com.mobvoi.companion.wear;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.companion.wear.WearPairingPool;
/* loaded from: classes2.dex */
public class WearNode implements JsonBean, Cloneable, Comparable<WearNode>, Parcelable {
    public static final Parcelable.Creator<WearNode> CREATOR = new a();
    public String nodeId;
    public String nodeName;
    public transient boolean persisted = false;
    public transient WearPairingPool.ConnectionState connectionState = WearPairingPool.ConnectionState.Disconnected;
    public transient int batteryLevel = -1;
    public transient String deviceId = "";

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<WearNode> {
        a() {
        }

        /* renamed from: a */
        public WearNode createFromParcel(Parcel parcel) {
            return new WearNode(parcel);
        }

        /* renamed from: b */
        public WearNode[] newArray(int i10) {
            return new WearNode[i10];
        }
    }

    public WearNode() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final WearNode clone() {
        WearNode wearNode;
        try {
            wearNode = (WearNode) super.clone();
        } catch (CloneNotSupportedException unused) {
            wearNode = new WearNode();
        }
        wearNode.c(this);
        return wearNode;
    }

    /* renamed from: b */
    public int compareTo(WearNode wearNode) {
        WearPairingPool.ConnectionState connectionState = this.connectionState;
        if (connectionState != wearNode.connectionState) {
            return connectionState.ordinal() > wearNode.connectionState.ordinal() ? -1 : 1;
        }
        return this.nodeName.compareTo(wearNode.nodeName);
    }

    public WearNode c(WearNode wearNode) {
        this.nodeId = wearNode.nodeId;
        this.nodeName = wearNode.nodeName;
        this.persisted = wearNode.persisted;
        this.connectionState = wearNode.connectionState;
        this.batteryLevel = wearNode.batteryLevel;
        this.deviceId = wearNode.deviceId;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WearNode)) {
            return false;
        }
        WearNode wearNode = (WearNode) obj;
        return TextUtils.equals(this.nodeId, wearNode.nodeId) && TextUtils.equals(this.nodeName, wearNode.nodeName) && TextUtils.equals(this.deviceId, wearNode.deviceId) && this.persisted == wearNode.persisted && this.connectionState == wearNode.connectionState && this.batteryLevel == wearNode.batteryLevel;
    }

    public String toString() {
        return "NodeInfo{nodeId=" + this.nodeId + ", nodeName=" + this.nodeName + ", state=" + this.connectionState + ", persisted=" + this.persisted + ", batteryLevel=" + this.batteryLevel + ", deviceId=" + this.deviceId + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.nodeId);
        parcel.writeString(this.nodeName);
    }

    protected WearNode(Parcel parcel) {
        this.nodeId = parcel.readString();
        this.nodeName = parcel.readString();
    }
}
