package com.mobvoi.companion.health;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import kotlin.jvm.internal.i;
/* compiled from: CardManagementModule.kt */
/* loaded from: classes2.dex */
final class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private final g f16807a;

    /* renamed from: b  reason: collision with root package name */
    private final RecyclerView.b0 f16808b;

    public a(g itemTouchHelper, RecyclerView.b0 viewHolder) {
        i.f(itemTouchHelper, "itemTouchHelper");
        i.f(viewHolder, "viewHolder");
        this.f16807a = itemTouchHelper;
        this.f16808b = viewHolder;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        i.f(view, "view");
        i.f(event, "event");
        if (event.getAction() != 0) {
            return false;
        }
        this.f16807a.E(this.f16808b);
        return false;
    }
}
