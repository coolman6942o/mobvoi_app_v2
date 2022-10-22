package com.mobvoi.mcuwatch.ui.menstrualcycle.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* compiled from: PeriodCalendarData.java */
/* loaded from: classes2.dex */
public class a extends nk.a {

    /* renamed from: d  reason: collision with root package name */
    private List<Date> f19784d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private List<Date> f19785e = new ArrayList();

    public a(nk.a aVar) {
        super(aVar.c(), aVar.b(), aVar.a());
    }

    public List<Date> d() {
        return this.f19784d;
    }

    public List<Date> e() {
        return this.f19785e;
    }

    public void f(List<Date> list) {
        this.f19784d = list;
    }

    public void g(List<Date> list) {
        this.f19785e = list;
    }
}
