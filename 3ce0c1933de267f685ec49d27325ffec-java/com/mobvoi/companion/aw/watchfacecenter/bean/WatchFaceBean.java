package com.mobvoi.companion.aw.watchfacecenter.bean;

import android.content.ComponentName;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.contacts.ContactConstant;
import h8.c;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: WatchFaceBean.kt */
/* loaded from: classes2.dex */
public final class WatchFaceBean implements JsonBean, Parcelable, Cloneable {
    public static final a CREATOR = new a(null);
    @h8.a
    @c("category")
    private int category;
    @h8.a
    @c("class_name")
    private String className;
    @h8.a
    @c("component_name")
    private ComponentName componentName;
    private String description;
    private String developerName;
    private boolean enableApply;
    private Boolean hasPaid;
    @h8.a
    @c(ContactConstant.CallsRecordKeys.NAME)
    private String name;
    @h8.a
    @c("need_pay")
    private boolean needPay;
    @h8.a
    @c("pkg")
    private String pkg;
    @h8.a
    @c("time_place")
    private Integer place;
    @h8.a(deserialize = false, serialize = false)
    private Bitmap preview;
    @h8.a(deserialize = false, serialize = false)
    private byte[] previewByte;
    private List<String> previewImages;
    @h8.a
    @c("preview_url")
    private String previewUrl;
    private Float price;
    @h8.a
    @c("show_battery")
    private Integer showBattery;
    @h8.a
    @c("show_date_and_week")
    private Integer showDateAndWeek;

    /* compiled from: WatchFaceBean.kt */
    /* loaded from: classes2.dex */
    public static final class a implements Parcelable.Creator<WatchFaceBean> {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        /* renamed from: a */
        public WatchFaceBean createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            return new WatchFaceBean(parcel);
        }

        /* renamed from: b */
        public WatchFaceBean[] newArray(int i10) {
            return new WatchFaceBean[i10];
        }
    }

    public WatchFaceBean() {
        this.category = 2;
        this.hasPaid = Boolean.FALSE;
    }

    public final void A(boolean z10) {
        this.enableApply = z10;
    }

    public final void B(String str) {
        this.name = str;
    }

    public final void C(boolean z10) {
        this.needPay = z10;
    }

    public final void D(String str) {
        this.pkg = str;
    }

    public final void E(Integer num) {
        this.place = num;
    }

    public final void F(Bitmap bitmap) {
        this.preview = bitmap;
    }

    public final void G(List<String> list) {
        this.previewImages = list;
    }

    public final void H(String str) {
        this.previewUrl = str;
    }

    public final void I(Float f10) {
        this.price = f10;
    }

    public final void J(Integer num) {
        this.showBattery = num;
    }

    public final void K(Integer num) {
        this.showDateAndWeek = num;
    }

    /* renamed from: a */
    public WatchFaceBean clone() {
        return (WatchFaceBean) super.clone();
    }

    public final int b() {
        return this.category;
    }

    public final String c() {
        return this.className;
    }

    public final String d() {
        return this.description;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.developerName;
    }

    public final boolean f() {
        return this.enableApply;
    }

    public final Boolean g() {
        return this.hasPaid;
    }

    public final String i() {
        return this.name;
    }

    public final boolean j() {
        return this.needPay;
    }

    public final String k() {
        return this.pkg;
    }

    public final Integer l() {
        return this.place;
    }

    public final Bitmap m() {
        return this.preview;
    }

    public final List<String> o() {
        return this.previewImages;
    }

    public final String p() {
        return this.previewUrl;
    }

    public final Float r() {
        return this.price;
    }

    public final Integer s() {
        return this.showBattery;
    }

    public final Integer t() {
        return this.showDateAndWeek;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("WatchFaceBean(componentName=");
        sb2.append(this.componentName);
        sb2.append(", preview=");
        sb2.append(this.preview);
        sb2.append(", previewUrl=");
        sb2.append((Object) this.previewUrl);
        sb2.append(", previewByte=");
        byte[] bArr = this.previewByte;
        if (bArr == null) {
            str = null;
        } else {
            str = Arrays.toString(bArr);
            i.e(str, "java.util.Arrays.toString(this)");
        }
        sb2.append((Object) str);
        sb2.append(", name=");
        sb2.append((Object) this.name);
        sb2.append(", pkg=");
        sb2.append((Object) this.pkg);
        sb2.append(", className=");
        sb2.append((Object) this.className);
        sb2.append(", category=");
        sb2.append(this.category);
        sb2.append(", place=");
        sb2.append(this.place);
        sb2.append(')');
        return sb2.toString();
    }

    public final void u(int i10) {
        this.category = i10;
    }

    public final void v(String str) {
        this.className = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        i.f(parcel, "parcel");
        parcel.writeParcelable(this.componentName, i10);
        parcel.writeParcelable(this.preview, i10);
        parcel.writeString(this.previewUrl);
        parcel.writeByteArray(this.previewByte);
        parcel.writeString(this.name);
        parcel.writeString(this.pkg);
        parcel.writeString(this.className);
        parcel.writeInt(this.category);
        parcel.writeValue(this.place);
        parcel.writeByte(this.needPay ? (byte) 1 : (byte) 0);
        parcel.writeValue(this.showBattery);
        parcel.writeValue(this.showDateAndWeek);
        parcel.writeValue(this.hasPaid);
        parcel.writeString(this.description);
        parcel.writeString(this.developerName);
        parcel.writeByte(this.enableApply ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.previewImages);
        parcel.writeValue(this.price);
    }

    public final void x(ComponentName componentName) {
        this.componentName = componentName;
    }

    public final void y(String str) {
        this.description = str;
    }

    public final void z(String str) {
        this.developerName = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WatchFaceBean(Parcel parcel) {
        this();
        i.f(parcel, "parcel");
        this.componentName = (ComponentName) parcel.readParcelable(ComponentName.class.getClassLoader());
        this.preview = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.previewUrl = parcel.readString();
        this.previewByte = parcel.createByteArray();
        this.name = parcel.readString();
        this.pkg = parcel.readString();
        this.className = parcel.readString();
        this.category = parcel.readInt();
        Class cls = Integer.TYPE;
        Object readValue = parcel.readValue(cls.getClassLoader());
        Float f10 = null;
        this.place = readValue instanceof Integer ? (Integer) readValue : null;
        boolean z10 = true;
        this.needPay = parcel.readByte() != 0;
        Object readValue2 = parcel.readValue(cls.getClassLoader());
        this.showBattery = readValue2 instanceof Integer ? (Integer) readValue2 : null;
        Object readValue3 = parcel.readValue(cls.getClassLoader());
        this.showDateAndWeek = readValue3 instanceof Integer ? (Integer) readValue3 : null;
        Object readValue4 = parcel.readValue(Boolean.TYPE.getClassLoader());
        this.hasPaid = readValue4 instanceof Boolean ? (Boolean) readValue4 : null;
        this.description = parcel.readString();
        this.developerName = parcel.readString();
        this.enableApply = parcel.readByte() == 0 ? false : z10;
        this.previewImages = parcel.createStringArrayList();
        Object readValue5 = parcel.readValue(Float.TYPE.getClassLoader());
        this.price = readValue5 instanceof Float ? (Float) readValue5 : f10;
    }
}
