package yc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cardiex.arty.lite.models.coach.Question;
import com.mobvoi.companion.R;
import com.mobvoi.wear.util.DimensionUtils;
import io.m;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: ArtyCardAnswerView.kt */
/* loaded from: classes2.dex */
public final class a extends ConstraintLayout implements k, View.OnClickListener {

    /* renamed from: u  reason: collision with root package name */
    private final Context f36912u;

    /* renamed from: v  reason: collision with root package name */
    private TextView f36913v;

    /* renamed from: w  reason: collision with root package name */
    private TextView f36914w;

    /* renamed from: x  reason: collision with root package name */
    private TextView f36915x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f36916y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context mContext, AttributeSet attributeSet, int i10) {
        super(mContext, attributeSet, i10);
        i.f(mContext, "mContext");
        this.f36912u = mContext;
        E();
    }

    private final void E() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(DimensionUtils.dp2px(this.f36912u, 10.0f));
        Resources resources = getResources();
        int i10 = R.color.home_tab_card_arty_chart_answer;
        gradientDrawable.setStroke((int) DimensionUtils.dp2px(this.f36912u, 2.0f), resources.getColor(i10, null));
        m mVar = m.f28349a;
        TextView textView = new TextView(this.f36912u);
        this.f36913v = textView;
        textView.setBackgroundDrawable(gradientDrawable);
        TextView textView2 = this.f36913v;
        if (textView2 != null) {
            textView2.setText(getResources().getString(R.string.arty_home_card_answer_one));
            TextView textView3 = this.f36913v;
            if (textView3 != null) {
                textView3.setGravity(17);
                TextView textView4 = this.f36913v;
                if (textView4 != null) {
                    textView4.setVisibility(8);
                    TextView textView5 = this.f36913v;
                    if (textView5 != null) {
                        textView5.setId(R.id.arty_home_card_answer_one);
                        TextView textView6 = this.f36913v;
                        if (textView6 != null) {
                            textView6.setTextColor(getResources().getColor(i10));
                            TextView textView7 = this.f36913v;
                            if (textView7 != null) {
                                textView7.setTextSize(2, 18.0f);
                                TextView textView8 = this.f36913v;
                                if (textView8 != null) {
                                    textView8.setEllipsize(TextUtils.TruncateAt.END);
                                    TextView textView9 = this.f36913v;
                                    if (textView9 != null) {
                                        textView9.setOnClickListener(this);
                                        ConstraintLayout.b bVar = new ConstraintLayout.b(0, 0);
                                        bVar.Q = 0.485f;
                                        bVar.R = 0.475f;
                                        bVar.f1790d = 0;
                                        bVar.f1798h = 0;
                                        ((ViewGroup.MarginLayoutParams) bVar).rightMargin = (int) DimensionUtils.dp2px(this.f36912u, 6.0f);
                                        ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = (int) DimensionUtils.dp2px(this.f36912u, 6.0f);
                                        TextView textView10 = this.f36913v;
                                        if (textView10 != null) {
                                            textView10.setLayoutParams(bVar);
                                            TextView textView11 = this.f36913v;
                                            if (textView11 != null) {
                                                addView(textView11);
                                                TextView textView12 = new TextView(this.f36912u);
                                                this.f36914w = textView12;
                                                textView12.setGravity(17);
                                                TextView textView13 = this.f36914w;
                                                if (textView13 != null) {
                                                    textView13.setBackgroundDrawable(gradientDrawable);
                                                    TextView textView14 = this.f36914w;
                                                    if (textView14 != null) {
                                                        textView14.setText(getResources().getString(R.string.arty_home_card_answer_two));
                                                        TextView textView15 = this.f36914w;
                                                        if (textView15 != null) {
                                                            textView15.setId(R.id.arty_home_card_answer_two);
                                                            TextView textView16 = this.f36914w;
                                                            if (textView16 != null) {
                                                                textView16.setVisibility(8);
                                                                TextView textView17 = this.f36914w;
                                                                if (textView17 != null) {
                                                                    textView17.setTextColor(getResources().getColor(i10));
                                                                    TextView textView18 = this.f36914w;
                                                                    if (textView18 != null) {
                                                                        textView18.setTextSize(2, 18.0f);
                                                                        TextView textView19 = this.f36914w;
                                                                        if (textView19 != null) {
                                                                            textView19.setEllipsize(TextUtils.TruncateAt.END);
                                                                            TextView textView20 = this.f36914w;
                                                                            if (textView20 != null) {
                                                                                textView20.setOnClickListener(this);
                                                                                ConstraintLayout.b bVar2 = new ConstraintLayout.b(0, 0);
                                                                                bVar2.Q = 0.485f;
                                                                                bVar2.R = 0.475f;
                                                                                bVar2.f1796g = 0;
                                                                                bVar2.f1798h = 0;
                                                                                ((ViewGroup.MarginLayoutParams) bVar2).leftMargin = (int) DimensionUtils.dp2px(this.f36912u, 6.0f);
                                                                                ((ViewGroup.MarginLayoutParams) bVar2).bottomMargin = (int) DimensionUtils.dp2px(this.f36912u, 6.0f);
                                                                                TextView textView21 = this.f36914w;
                                                                                if (textView21 != null) {
                                                                                    textView21.setLayoutParams(bVar2);
                                                                                    TextView textView22 = this.f36914w;
                                                                                    if (textView22 != null) {
                                                                                        addView(textView22);
                                                                                        TextView textView23 = new TextView(this.f36912u);
                                                                                        this.f36915x = textView23;
                                                                                        textView23.setGravity(17);
                                                                                        TextView textView24 = this.f36915x;
                                                                                        if (textView24 != null) {
                                                                                            textView24.setBackgroundDrawable(gradientDrawable);
                                                                                            TextView textView25 = this.f36915x;
                                                                                            if (textView25 != null) {
                                                                                                textView25.setText(getResources().getString(R.string.arty_home_card_answer_three));
                                                                                                TextView textView26 = this.f36915x;
                                                                                                if (textView26 != null) {
                                                                                                    textView26.setId(R.id.arty_home_card_answer_three);
                                                                                                    TextView textView27 = this.f36915x;
                                                                                                    if (textView27 != null) {
                                                                                                        textView27.setVisibility(8);
                                                                                                        TextView textView28 = this.f36915x;
                                                                                                        if (textView28 != null) {
                                                                                                            textView28.setTextColor(getResources().getColor(i10));
                                                                                                            TextView textView29 = this.f36915x;
                                                                                                            if (textView29 != null) {
                                                                                                                textView29.setTextSize(2, 18.0f);
                                                                                                                TextView textView30 = this.f36915x;
                                                                                                                if (textView30 != null) {
                                                                                                                    textView30.setEllipsize(TextUtils.TruncateAt.END);
                                                                                                                    TextView textView31 = this.f36915x;
                                                                                                                    if (textView31 != null) {
                                                                                                                        textView31.setOnClickListener(this);
                                                                                                                        ConstraintLayout.b bVar3 = new ConstraintLayout.b(0, 0);
                                                                                                                        bVar3.Q = 0.485f;
                                                                                                                        bVar3.R = 0.475f;
                                                                                                                        bVar3.f1790d = 0;
                                                                                                                        bVar3.f1804k = 0;
                                                                                                                        ((ViewGroup.MarginLayoutParams) bVar3).topMargin = (int) DimensionUtils.dp2px(this.f36912u, 6.0f);
                                                                                                                        ((ViewGroup.MarginLayoutParams) bVar3).rightMargin = (int) DimensionUtils.dp2px(this.f36912u, 6.0f);
                                                                                                                        TextView textView32 = this.f36915x;
                                                                                                                        if (textView32 != null) {
                                                                                                                            textView32.setLayoutParams(bVar3);
                                                                                                                            TextView textView33 = this.f36915x;
                                                                                                                            if (textView33 != null) {
                                                                                                                                addView(textView33);
                                                                                                                                TextView textView34 = new TextView(this.f36912u);
                                                                                                                                this.f36916y = textView34;
                                                                                                                                textView34.setGravity(17);
                                                                                                                                TextView textView35 = this.f36916y;
                                                                                                                                if (textView35 != null) {
                                                                                                                                    textView35.setBackgroundDrawable(gradientDrawable);
                                                                                                                                    TextView textView36 = this.f36916y;
                                                                                                                                    if (textView36 != null) {
                                                                                                                                        textView36.setText(getResources().getString(R.string.arty_home_card_answer_four));
                                                                                                                                        TextView textView37 = this.f36916y;
                                                                                                                                        if (textView37 != null) {
                                                                                                                                            textView37.setId(R.id.arty_home_card_answer_four);
                                                                                                                                            TextView textView38 = this.f36916y;
                                                                                                                                            if (textView38 != null) {
                                                                                                                                                textView38.setVisibility(8);
                                                                                                                                                TextView textView39 = this.f36916y;
                                                                                                                                                if (textView39 != null) {
                                                                                                                                                    textView39.setTextColor(getResources().getColor(i10));
                                                                                                                                                    TextView textView40 = this.f36916y;
                                                                                                                                                    if (textView40 != null) {
                                                                                                                                                        textView40.setTextSize(2, 18.0f);
                                                                                                                                                        TextView textView41 = this.f36916y;
                                                                                                                                                        if (textView41 != null) {
                                                                                                                                                            textView41.setEllipsize(TextUtils.TruncateAt.END);
                                                                                                                                                            TextView textView42 = this.f36916y;
                                                                                                                                                            if (textView42 != null) {
                                                                                                                                                                textView42.setOnClickListener(this);
                                                                                                                                                                ConstraintLayout.b bVar4 = new ConstraintLayout.b(0, 0);
                                                                                                                                                                bVar4.Q = 0.485f;
                                                                                                                                                                bVar4.R = 0.475f;
                                                                                                                                                                bVar4.f1796g = 0;
                                                                                                                                                                bVar4.f1804k = 0;
                                                                                                                                                                ((ViewGroup.MarginLayoutParams) bVar4).topMargin = (int) DimensionUtils.dp2px(this.f36912u, 6.0f);
                                                                                                                                                                ((ViewGroup.MarginLayoutParams) bVar4).leftMargin = (int) DimensionUtils.dp2px(this.f36912u, 6.0f);
                                                                                                                                                                TextView textView43 = this.f36916y;
                                                                                                                                                                if (textView43 != null) {
                                                                                                                                                                    textView43.setLayoutParams(bVar4);
                                                                                                                                                                    TextView textView44 = this.f36916y;
                                                                                                                                                                    if (textView44 != null) {
                                                                                                                                                                        addView(textView44);
                                                                                                                                                                    } else {
                                                                                                                                                                        i.u("mAnswerFour");
                                                                                                                                                                        throw null;
                                                                                                                                                                    }
                                                                                                                                                                } else {
                                                                                                                                                                    i.u("mAnswerFour");
                                                                                                                                                                    throw null;
                                                                                                                                                                }
                                                                                                                                                            } else {
                                                                                                                                                                i.u("mAnswerFour");
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                            i.u("mAnswerFour");
                                                                                                                                                            throw null;
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        i.u("mAnswerFour");
                                                                                                                                                        throw null;
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    i.u("mAnswerFour");
                                                                                                                                                    throw null;
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                i.u("mAnswerFour");
                                                                                                                                                throw null;
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            i.u("mAnswerFour");
                                                                                                                                            throw null;
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        i.u("mAnswerFour");
                                                                                                                                        throw null;
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    i.u("mAnswerFour");
                                                                                                                                    throw null;
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                i.u("mAnswerThree");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            i.u("mAnswerThree");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        i.u("mAnswerThree");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    i.u("mAnswerThree");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                            } else {
                                                                                                                i.u("mAnswerThree");
                                                                                                                throw null;
                                                                                                            }
                                                                                                        } else {
                                                                                                            i.u("mAnswerThree");
                                                                                                            throw null;
                                                                                                        }
                                                                                                    } else {
                                                                                                        i.u("mAnswerThree");
                                                                                                        throw null;
                                                                                                    }
                                                                                                } else {
                                                                                                    i.u("mAnswerThree");
                                                                                                    throw null;
                                                                                                }
                                                                                            } else {
                                                                                                i.u("mAnswerThree");
                                                                                                throw null;
                                                                                            }
                                                                                        } else {
                                                                                            i.u("mAnswerThree");
                                                                                            throw null;
                                                                                        }
                                                                                    } else {
                                                                                        i.u("mAnswerTwo");
                                                                                        throw null;
                                                                                    }
                                                                                } else {
                                                                                    i.u("mAnswerTwo");
                                                                                    throw null;
                                                                                }
                                                                            } else {
                                                                                i.u("mAnswerTwo");
                                                                                throw null;
                                                                            }
                                                                        } else {
                                                                            i.u("mAnswerTwo");
                                                                            throw null;
                                                                        }
                                                                    } else {
                                                                        i.u("mAnswerTwo");
                                                                        throw null;
                                                                    }
                                                                } else {
                                                                    i.u("mAnswerTwo");
                                                                    throw null;
                                                                }
                                                            } else {
                                                                i.u("mAnswerTwo");
                                                                throw null;
                                                            }
                                                        } else {
                                                            i.u("mAnswerTwo");
                                                            throw null;
                                                        }
                                                    } else {
                                                        i.u("mAnswerTwo");
                                                        throw null;
                                                    }
                                                } else {
                                                    i.u("mAnswerTwo");
                                                    throw null;
                                                }
                                            } else {
                                                i.u("mAnswerOne");
                                                throw null;
                                            }
                                        } else {
                                            i.u("mAnswerOne");
                                            throw null;
                                        }
                                    } else {
                                        i.u("mAnswerOne");
                                        throw null;
                                    }
                                } else {
                                    i.u("mAnswerOne");
                                    throw null;
                                }
                            } else {
                                i.u("mAnswerOne");
                                throw null;
                            }
                        } else {
                            i.u("mAnswerOne");
                            throw null;
                        }
                    } else {
                        i.u("mAnswerOne");
                        throw null;
                    }
                } else {
                    i.u("mAnswerOne");
                    throw null;
                }
            } else {
                i.u("mAnswerOne");
                throw null;
            }
        } else {
            i.u("mAnswerOne");
            throw null;
        }
    }

    @Override // yc.k
    public void c(zc.a dataArty) {
        i.f(dataArty, "dataArty");
        if (dataArty.c() instanceof Question) {
            Object c10 = dataArty.c();
            Objects.requireNonNull(c10, "null cannot be cast to non-null type com.cardiex.arty.lite.models.coach.Question");
            String[] answers = ((Question) c10).getAnswers();
            if (answers != null) {
                int i10 = 0;
                for (String str : answers) {
                    if (i10 == 0) {
                        TextView textView = this.f36913v;
                        if (textView != null) {
                            textView.setText(str);
                            TextView textView2 = this.f36913v;
                            if (textView2 != null) {
                                textView2.setVisibility(0);
                            } else {
                                i.u("mAnswerOne");
                                throw null;
                            }
                        } else {
                            i.u("mAnswerOne");
                            throw null;
                        }
                    } else if (i10 == 1) {
                        TextView textView3 = this.f36914w;
                        if (textView3 != null) {
                            textView3.setText(str);
                            TextView textView4 = this.f36914w;
                            if (textView4 != null) {
                                textView4.setVisibility(0);
                            } else {
                                i.u("mAnswerTwo");
                                throw null;
                            }
                        } else {
                            i.u("mAnswerTwo");
                            throw null;
                        }
                    } else if (i10 == 2) {
                        TextView textView5 = this.f36915x;
                        if (textView5 != null) {
                            textView5.setText(str);
                            TextView textView6 = this.f36915x;
                            if (textView6 != null) {
                                textView6.setVisibility(0);
                            } else {
                                i.u("mAnswerThree");
                                throw null;
                            }
                        } else {
                            i.u("mAnswerThree");
                            throw null;
                        }
                    } else if (i10 == 3) {
                        TextView textView7 = this.f36916y;
                        if (textView7 != null) {
                            textView7.setText(str);
                            TextView textView8 = this.f36916y;
                            if (textView8 != null) {
                                textView8.setVisibility(0);
                            } else {
                                i.u("mAnswerFour");
                                throw null;
                            }
                        } else {
                            i.u("mAnswerFour");
                            throw null;
                        }
                    } else {
                        continue;
                    }
                    i10++;
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i10 = R.id.arty_home_card_answer_one;
        if (valueOf != null && valueOf.intValue() == i10) {
            Toast.makeText(getContext(), "answer one", 0).show();
            return;
        }
        int i11 = R.id.arty_home_card_answer_two;
        if (valueOf != null && valueOf.intValue() == i11) {
            Toast.makeText(getContext(), "answer two", 0).show();
            return;
        }
        int i12 = R.id.arty_home_card_answer_three;
        if (valueOf != null && valueOf.intValue() == i12) {
            Toast.makeText(getContext(), "answer three", 0).show();
            return;
        }
        int i13 = R.id.arty_home_card_answer_four;
        if (valueOf != null && valueOf.intValue() == i13) {
            Toast.makeText(getContext(), "answer four", 0).show();
        }
    }

    public /* synthetic */ a(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
