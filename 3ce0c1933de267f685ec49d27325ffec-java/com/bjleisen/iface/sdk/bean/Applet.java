package com.bjleisen.iface.sdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class Applet implements Parcelable {
    public static final Parcelable.Creator<Applet> CREATOR = new Parcelable.Creator<Applet>() { // from class: com.bjleisen.iface.sdk.bean.Applet.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Applet createFromParcel(Parcel parcel) {
            return new Applet(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Applet[] newArray(int i10) {
            return new Applet[i10];
        }
    };
    private int activateStatus;
    private int appletBusiType;
    private String appletDescMsg;
    private String appletName;
    private String appletVersion;
    private String cardBigIcon;
    private String cardIcon;
    private int cardPrice;
    private int downType;
    private String instanceAid;
    private String ssdAid;

    public Applet() {
    }

    public static Parcelable.Creator<Applet> getCreator() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getActivateStatus() {
        return this.activateStatus;
    }

    public int getAppletBusiType() {
        return this.appletBusiType;
    }

    public String getAppletDescMsg() {
        return this.appletDescMsg;
    }

    public String getAppletName() {
        return this.appletName;
    }

    public String getAppletVersion() {
        return this.appletVersion;
    }

    public String getCardBigIcon() {
        return this.cardBigIcon;
    }

    public String getCardIcon() {
        return this.cardIcon;
    }

    public int getCardPrice() {
        return this.cardPrice;
    }

    public int getDownType() {
        return this.downType;
    }

    public String getInstanceAid() {
        return this.instanceAid;
    }

    public String getSsdAid() {
        return this.ssdAid;
    }

    public void readToParcel(Parcel parcel) {
        this.appletName = parcel.readString();
        this.instanceAid = parcel.readString();
        this.appletVersion = parcel.readString();
        this.cardIcon = parcel.readString();
        this.cardBigIcon = parcel.readString();
        this.appletBusiType = parcel.readInt();
        this.downType = parcel.readInt();
        this.appletDescMsg = parcel.readString();
        this.cardPrice = parcel.readInt();
        this.activateStatus = parcel.readInt();
        this.ssdAid = parcel.readString();
    }

    public void setActivateStatus(int i10) {
        this.activateStatus = i10;
    }

    public void setAppletBusiType(int i10) {
        this.appletBusiType = i10;
    }

    public void setAppletDescMsg(String str) {
        this.appletDescMsg = str;
    }

    public void setAppletName(String str) {
        this.appletName = str;
    }

    public void setAppletVersion(String str) {
        this.appletVersion = str;
    }

    public void setCardBigIcon(String str) {
        this.cardBigIcon = str;
    }

    public void setCardIcon(String str) {
        this.cardIcon = str;
    }

    public void setCardPrice(int i10) {
        this.cardPrice = i10;
    }

    public void setDownType(int i10) {
        this.downType = i10;
    }

    public void setInstanceAid(String str) {
        this.instanceAid = str;
    }

    public void setSsdAid(String str) {
        this.ssdAid = str;
    }

    public String toString() {
        return "Applet [appletName=" + this.appletName + ", instanceAid=" + this.instanceAid + ", appletVersion=" + this.appletVersion + ", cardIcon=" + this.cardIcon + ", cardBigIcon=" + this.cardBigIcon + ", appletBusiType=" + this.appletBusiType + ", downType=" + this.downType + ", appletDescMsg=" + this.appletDescMsg + ", cardPrice=" + this.cardPrice + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.appletName);
        parcel.writeString(this.instanceAid);
        parcel.writeString(this.appletVersion);
        parcel.writeString(this.cardIcon);
        parcel.writeString(this.cardBigIcon);
        parcel.writeInt(this.appletBusiType);
        parcel.writeInt(this.downType);
        parcel.writeString(this.appletDescMsg);
        parcel.writeInt(this.cardPrice);
        parcel.writeInt(this.activateStatus);
        parcel.writeString(this.ssdAid);
    }

    public Applet(Parcel parcel) {
        readToParcel(parcel);
    }
}
