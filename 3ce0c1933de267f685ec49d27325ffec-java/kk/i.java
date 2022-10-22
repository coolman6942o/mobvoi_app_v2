package kk;

import ak.d;
import ak.e;
import ak.g;
import android.util.Pair;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.x;
import dk.a;
import java.util.List;
import jk.a;
/* compiled from: TicCareSettingShareDataFragment.java */
/* loaded from: classes2.dex */
public class i extends a {

    /* renamed from: b  reason: collision with root package name */
    SwitchCompat f30009b;

    /* renamed from: c  reason: collision with root package name */
    SwitchCompat f30010c;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(Boolean bool) {
        if (!bool.booleanValue()) {
            Toast.makeText(requireContext(), getString(g.f247r), 0).show();
            Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(Pair pair) {
        if (((Boolean) pair.first).booleanValue()) {
            for (a.C0276a aVar : (List) pair.second) {
                if (aVar.shareDataType.equals("SHARE_EXERCISE")) {
                    this.f30009b.setChecked(aVar.shareDataStatus);
                    ek.a.b(requireContext(), "key_share_exercise", aVar.shareDataStatus);
                } else if (aVar.shareDataType.equals("SHARE_HEALTH")) {
                    this.f30010c.setChecked(aVar.shareDataStatus);
                    ek.a.b(requireContext(), "key_share_health", aVar.shareDataStatus);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(CompoundButton compoundButton, boolean z10) {
        this.f29645a.g0(requireContext(), "SHARE_EXERCISE", z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(CompoundButton compoundButton, boolean z10) {
        this.f29645a.g0(requireContext(), "SHARE_HEALTH", z10);
    }

    @Override // jk.a
    public int Y() {
        return e.j_res_0x7f0e0193;
    }

    @Override // jk.a
    public void Z() {
        this.f30010c.setChecked(ek.a.a(requireContext(), "key_share_health"));
        this.f30009b.setChecked(ek.a.a(requireContext(), "key_share_exercise"));
    }

    @Override // jk.a
    public void a0(View view) {
        this.f30009b = (SwitchCompat) view.findViewById(d.E_res_0x7f0b06ff);
        this.f30010c = (SwitchCompat) view.findViewById(d.F_res_0x7f0b0700);
        this.f29645a.D().i(this, new x() { // from class: kk.h
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                i.this.f0((Boolean) obj);
            }
        });
        this.f29645a.E().i(this, new x() { // from class: kk.g
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                i.this.g0((Pair) obj);
            }
        });
        this.f29645a.d0();
        this.f30009b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: kk.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                i.this.h0(compoundButton, z10);
            }
        });
        this.f30010c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: kk.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                i.this.i0(compoundButton, z10);
            }
        });
    }
}
