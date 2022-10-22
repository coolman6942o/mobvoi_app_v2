package com.huawei.hms.hmsscankit;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class DetailRect implements Parcelable {
    public static final Parcelable.Creator<DetailRect> CREATOR = new a();
    public static final String CUSTOMED_FLAG = "CustomedFlag";
    public static final String DEEPLINK_BACK_COLOR = "DeepLinkColor";
    public static final String DEEPLINK_JUMP_FLAG = "DeepLinkJumpFlag";
    public static final String DEEPLINK_VALUE = "DeepLinkValue";
    public static final int DEFALT_HMS_SCAN_VERSIONU = 0;
    public static final String FORMAT_FLAG = "FormatValue";
    public static int HMSSCAN_SDK_VALUE = 3;
    public static final String PHOTO_MODE = "PhotoMode";
    public static final String RECT_FLAG = "RectValue";
    public static final String RETURN_BITMAP = "return_bitmap";
    public static final String SCAN_LOCAL_DECODER = "localdecoder";
    public static final String SCAN_NEW_UI = "localui";
    public static final String SCAN_OFFSCEEN_FLAG = "ScanOffSceenFlag";
    public static final String TYPE_TRANS = "TransType";
    public static final int VALUE_HMS_SCAN_VERSION = 3;
    public int height;
    public int width;

    public DetailRect() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    public DetailRect(int i10, int i11) {
        this.width = i10;
        this.height = i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DetailRect(Parcel parcel) {
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }
}
