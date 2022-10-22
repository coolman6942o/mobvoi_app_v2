package fk;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
/* compiled from: RecyclerViewSpacesItemDecoration.java */
/* loaded from: classes2.dex */
public class a extends RecyclerView.n {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, Integer> f27066a;

    public a(HashMap<String, Integer> hashMap) {
        this.f27066a = hashMap;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
        if (this.f27066a.get("top_decoration") != null) {
            rect.top = this.f27066a.get("top_decoration").intValue();
        }
        if (this.f27066a.get("left_decoration") != null) {
            rect.left = this.f27066a.get("left_decoration").intValue();
        }
        if (this.f27066a.get("right_decoration") != null) {
            rect.right = this.f27066a.get("right_decoration").intValue();
        }
        if (this.f27066a.get("bottom_decoration") != null) {
            rect.bottom = this.f27066a.get("bottom_decoration").intValue();
        }
    }
}
