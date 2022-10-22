package com.mobvoi.wear.msgproxy;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class NodeInfo implements Parcelable {
    public static final Parcelable.Creator<NodeInfo> CREATOR = new Parcelable.Creator<NodeInfo>() { // from class: com.mobvoi.wear.msgproxy.NodeInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NodeInfo createFromParcel(Parcel parcel) {
            return new NodeInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NodeInfo[] newArray(int i10) {
            return new NodeInfo[i10];
        }
    };
    private static final String NODE_NAME_SEP_MAGIC = "_NMSM_";
    private boolean mNearby;
    private String mNodeId;
    private String mNodeName;
    private int mNodeType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.mNodeId;
    }

    public String getName() {
        return this.mNodeName;
    }

    public int getNodeType() {
        return this.mNodeType;
    }

    public boolean isNearby() {
        return this.mNearby;
    }

    public String toString() {
        return "NodeInfo[nodeType=" + this.mNodeType + ", nodeId=" + this.mNodeId + ", nodeName=" + this.mNodeName + ", nearby=" + this.mNearby + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mNodeId);
        parcel.writeString(this.mNodeName + NODE_NAME_SEP_MAGIC + this.mNodeType + NODE_NAME_SEP_MAGIC);
        parcel.writeByte(this.mNearby ? (byte) 1 : (byte) 0);
    }

    public NodeInfo(int i10, String str, String str2, boolean z10) {
        this.mNodeType = i10;
        this.mNodeId = str;
        this.mNodeName = str2;
        this.mNearby = z10;
    }

    private NodeInfo(Parcel parcel) {
        this.mNodeId = parcel.readString();
        String readString = parcel.readString();
        int indexOf = readString.indexOf(NODE_NAME_SEP_MAGIC);
        boolean z10 = false;
        if (indexOf != -1) {
            this.mNodeName = readString.substring(0, indexOf);
            int i10 = indexOf + 6;
            try {
                this.mNodeType = Integer.parseInt(readString.substring(i10, readString.indexOf(NODE_NAME_SEP_MAGIC, i10)));
            } catch (Exception e10) {
                this.mNodeType = -1;
                e10.printStackTrace();
            }
        } else {
            this.mNodeName = readString;
            this.mNodeType = -1;
        }
        this.mNearby = parcel.readByte() != 0 ? true : z10;
    }
}
