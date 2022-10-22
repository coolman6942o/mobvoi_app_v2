package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
/* loaded from: classes.dex */
public class DropDownPreference extends ListPreference {
    private final Context A;
    private final ArrayAdapter B;
    private Spinner C;

    /* loaded from: classes.dex */
    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (i10 >= 0) {
                String charSequence = DropDownPreference.this.N()[i10].toString();
                if (!charSequence.equals(DropDownPreference.this.O()) && DropDownPreference.this.a(charSequence)) {
                    DropDownPreference.this.Q(charSequence);
                }
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.f3638c);
    }

    private void S() {
        this.B.clear();
        if (L() != null) {
            for (CharSequence charSequence : L()) {
                this.B.add(charSequence.toString());
            }
        }
    }

    protected ArrayAdapter R() {
        return new ArrayAdapter(this.A, 17367049);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void w() {
        super.w();
        ArrayAdapter arrayAdapter = this.B;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public void y() {
        this.C.performClick();
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        new a();
        this.A = context;
        this.B = R();
        S();
    }
}
