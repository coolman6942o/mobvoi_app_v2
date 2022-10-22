package sd;

import cn.com.fmsh.tsm.business.enums.EnumOrderStatus;
/* compiled from: AbnormalOrderInfo.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f34378a;

    /* renamed from: b  reason: collision with root package name */
    public String f34379b;

    /* renamed from: c  reason: collision with root package name */
    public String f34380c;

    /* renamed from: d  reason: collision with root package name */
    public String f34381d;

    /* renamed from: e  reason: collision with root package name */
    public int f34382e;

    /* renamed from: f  reason: collision with root package name */
    public int f34383f;

    /* renamed from: g  reason: collision with root package name */
    public int f34384g;

    /* renamed from: h  reason: collision with root package name */
    public int f34385h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34386i;

    /* renamed from: j  reason: collision with root package name */
    public int f34387j = 0;

    /* renamed from: k  reason: collision with root package name */
    public EnumOrderStatus f34388k;

    /* renamed from: l  reason: collision with root package name */
    public int f34389l;

    /* renamed from: m  reason: collision with root package name */
    public String f34390m;

    public boolean a() {
        return this.f34389l == 0 && EnumOrderStatus.success == this.f34388k;
    }

    public String toString() {
        return "AbnormalOrder{cardAid=" + this.f34378a + ", cardName='" + this.f34379b + "', orderId='" + this.f34380c + "', orderTime='" + this.f34381d + "', payMoney=" + this.f34382e + ", orderMoney=" + this.f34383f + ", payway=" + this.f34384g + ", orderType=" + this.f34385h + ", unsettled=" + this.f34386i + ", sdk=" + this.f34387j + '}';
    }
}
