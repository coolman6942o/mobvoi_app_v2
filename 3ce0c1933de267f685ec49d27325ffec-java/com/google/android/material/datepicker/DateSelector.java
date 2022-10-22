package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import j0.d;
import java.util.Collection;
/* loaded from: classes.dex */
public interface DateSelector<S> extends Parcelable {
    void A0(long j10);

    View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, l<S> lVar);

    int V();

    int g0(Context context);

    boolean m0();

    String n(Context context);

    Collection<d<Long, Long>> q();

    Collection<Long> r0();

    void w(S s10);

    S w0();
}
