package com.mobvoi.wear.quickcard;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.mobvoi.android.common.json.JsonBean;
/* loaded from: classes2.dex */
public class QuickCardInfo implements Parcelable, Comparable<QuickCardInfo>, JsonBean {
    public static final Parcelable.Creator<QuickCardInfo> CREATOR = new Parcelable.Creator<QuickCardInfo>() { // from class: com.mobvoi.wear.quickcard.QuickCardInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QuickCardInfo createFromParcel(Parcel parcel) {
            return new QuickCardInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QuickCardInfo[] newArray(int i10) {
            return new QuickCardInfo[i10];
        }
    };
    public static final int STATUS_DISABLED = 1;
    public static final int STATUS_ENABLED = 0;
    public static final int STATUS_SHOW_ALWAYS = 3;
    public static final int STATUS_VAILABLE = 2;
    public String mClass;
    public String mDisplayName;
    public int mOrder;
    public String mPackage;
    public int mStatus;

    public QuickCardInfo() {
    }

    public boolean canChangeOrder() {
        return this.mStatus != 2;
    }

    public boolean canChangeVisibility() {
        int i10 = this.mStatus;
        return i10 == 0 || i10 == 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof QuickCardInfo)) {
            return false;
        }
        QuickCardInfo quickCardInfo = (QuickCardInfo) obj;
        return this.mPackage.equals(quickCardInfo.mPackage) && this.mClass.equals(quickCardInfo.mClass);
    }

    public int hashCode() {
        if (TextUtils.isEmpty(this.mPackage) || TextUtils.isEmpty(this.mClass)) {
            return super.hashCode();
        }
        return (this.mPackage.hashCode() * 17) + (this.mClass.hashCode() * 31);
    }

    public String toString() {
        return String.format("[mPackage:%s, mClass:%s, mDisplayName:%s, mOrder:%s, mStatus:%s]", this.mPackage, this.mClass, this.mDisplayName, Integer.valueOf(this.mOrder), Integer.valueOf(this.mStatus));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mPackage);
        parcel.writeString(this.mClass);
        parcel.writeString(this.mDisplayName);
        parcel.writeInt(this.mOrder);
        parcel.writeInt(this.mStatus);
    }

    public QuickCardInfo(String str, String str2, String str3, int i10, int i11) {
        this.mPackage = str;
        this.mClass = str2;
        this.mDisplayName = str3;
        this.mOrder = i10;
        this.mStatus = i11;
    }

    public int compareTo(QuickCardInfo quickCardInfo) {
        return quickCardInfo.mOrder - this.mOrder;
    }

    protected QuickCardInfo(Parcel parcel) {
        this.mPackage = parcel.readString();
        this.mClass = parcel.readString();
        this.mDisplayName = parcel.readString();
        this.mOrder = parcel.readInt();
        this.mStatus = parcel.readInt();
    }
}
