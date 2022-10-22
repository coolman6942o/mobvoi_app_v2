package com.mobvoi.device;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.companion.base.settings.a;
import ge.j;
import ge.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class DeviceProvider {

    /* loaded from: classes2.dex */
    public static class DeviceData implements Parcelable {
        public static final Parcelable.Creator<DeviceData> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f17847a;

        /* renamed from: b  reason: collision with root package name */
        public int f17848b;

        /* renamed from: c  reason: collision with root package name */
        public int f17849c;

        /* renamed from: d  reason: collision with root package name */
        public int f17850d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<DeviceData> f17851e;

        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<DeviceData> {
            a() {
            }

            /* renamed from: a */
            public DeviceData createFromParcel(Parcel parcel) {
                return new DeviceData(parcel);
            }

            /* renamed from: b */
            public DeviceData[] newArray(int i10) {
                return new DeviceData[i10];
            }
        }

        public DeviceData() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f17847a);
            parcel.writeInt(this.f17848b);
            parcel.writeInt(this.f17849c);
            parcel.writeInt(this.f17850d);
            parcel.writeTypedList(this.f17851e);
        }

        protected DeviceData(Parcel parcel) {
            this.f17847a = parcel.readInt();
            this.f17848b = parcel.readInt();
            this.f17849c = parcel.readInt();
            this.f17850d = parcel.readInt();
            this.f17851e = parcel.createTypedArrayList(CREATOR);
        }
    }

    private static DeviceData a(int i10, int i11, int i12, int i13) {
        DeviceData deviceData = new DeviceData();
        deviceData.f17847a = i10;
        deviceData.f17848b = i11;
        deviceData.f17849c = i12;
        deviceData.f17850d = i13;
        return deviceData;
    }

    public static List<DeviceData> b(boolean z10) {
        ArrayList arrayList = new ArrayList();
        DeviceData a10 = a(0, j.c_res_0x7f0801eb, m.f27437p, 1);
        a10.f17851e = new ArrayList<>();
        if (a.isW3Oversea(b.e())) {
            a10.f17851e.add(a(31, j.f27424o, m.B_res_0x7f1410a8, 0));
        } else {
            DeviceData a11 = a(10, j.f27423n, m.A_res_0x7f1410a7, 0);
            DeviceData a12 = a(11, j.f27422m, m.z_res_0x7f1410a6, 0);
            DeviceData a13 = a(17, j.f27418i, m.y_res_0x7f1410a4, 0);
            DeviceData a14 = a(18, j.f27414e, m.v_res_0x7f1410a0, 0);
            DeviceData a15 = a(12, j.f27420k, m.s_res_0x7f14109c, 0);
            DeviceData a16 = a(13, j.f27419j, m.q_res_0x7f14109a, 0);
            DeviceData a17 = a(20, j.a_res_0x7f0801e4, m.j_res_0x7f140c30, 0);
            if (z10) {
                DeviceData a18 = a(31, j.f27424o, m.B_res_0x7f1410a8, 0);
                DeviceData a19 = a(15, j.f27421l, m.t_res_0x7f14109d, 0);
                DeviceData a20 = a(19, j.f27415f, m.f27438w, 0);
                DeviceData a21 = a(16, j.f27426q, m.r_res_0x7f14109b, 0);
                a10.f17851e.add(a18);
                a10.f17851e.add(a11);
                a10.f17851e.add(a19);
                a10.f17851e.add(a12);
                a10.f17851e.add(a13);
                a10.f17851e.add(a20);
                a10.f17851e.add(a14);
                a10.f17851e.add(a15);
                a10.f17851e.add(a16);
                a10.f17851e.add(a21);
                a10.f17851e.add(a17);
            } else {
                DeviceData a22 = a(38, j.f27425p, m.C_res_0x7f1410a9, 0);
                DeviceData a23 = a(34, j.f27416g, m.x_res_0x7f1410a3, 0);
                DeviceData a24 = a(32, j.f27413d, m.u_res_0x7f14109f, 0);
                a(33, j.f27417h, m.e_res_0x7f14039f, 0);
                a10.f17851e.add(a22);
                a10.f17851e.add(a11);
                a10.f17851e.add(a12);
                a10.f17851e.add(a23);
                a10.f17851e.add(a24);
                a10.f17851e.add(a13);
                a10.f17851e.add(a14);
                a10.f17851e.add(a15);
                a10.f17851e.add(a16);
                a10.f17851e.add(a17);
            }
        }
        arrayList.add(a10);
        int i10 = j.b_res_0x7f0801ea;
        int i11 = m.o_res_0x7f140fce;
        DeviceData a25 = a(8, i10, i11, 1);
        a25.f17851e = new ArrayList<>();
        a25.f17851e.add(a(29, i10, i11, 1));
        arrayList.add(a25);
        return arrayList;
    }
}
