package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
class MMSharedPreferences implements SharedPreferences {
    private static final String TAG = "MicroMsg.SDK.SharedPreferences";
    private final ContentResolver cr;
    private final String[] columns = {"_id", "key", "type", HealthDataProviderContracts.NAME_VALUE};
    private final HashMap<String, Object> values = new HashMap<>();
    private REditor editor = null;

    /* loaded from: classes2.dex */
    private static class REditor implements SharedPreferences.Editor {
        private ContentResolver cr;
        private Map<String, Object> values = new HashMap();
        private Set<String> remove = new HashSet();
        private boolean clear = false;

        public REditor(ContentResolver contentResolver) {
            this.cr = contentResolver;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.clear = true;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00ae A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x003f A[SYNTHETIC] */
        @Override // android.content.SharedPreferences.Editor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean commit() {
            int i10;
            boolean z10;
            String str;
            ContentValues contentValues = new ContentValues();
            if (this.clear) {
                this.cr.delete(c.b.CONTENT_URI, null, null);
                this.clear = false;
            }
            Iterator<String> it = this.remove.iterator();
            while (it.hasNext()) {
                this.cr.delete(c.b.CONTENT_URI, "key = ?", new String[]{it.next()});
            }
            for (Map.Entry<String, Object> entry : this.values.entrySet()) {
                Object value = entry.getValue();
                if (value == null) {
                    str = "unresolve failed, null value";
                } else {
                    if (value instanceof Integer) {
                        i10 = 1;
                    } else if (value instanceof Long) {
                        i10 = 2;
                    } else if (value instanceof String) {
                        i10 = 3;
                    } else if (value instanceof Boolean) {
                        i10 = 4;
                    } else if (value instanceof Float) {
                        i10 = 5;
                    } else if (value instanceof Double) {
                        i10 = 6;
                    } else {
                        str = "unresolve failed, unknown type=" + value.getClass().toString();
                    }
                    if (i10 != 0) {
                        z10 = false;
                    } else {
                        contentValues.put("type", Integer.valueOf(i10));
                        contentValues.put(HealthDataProviderContracts.NAME_VALUE, value.toString());
                        z10 = true;
                    }
                    if (!z10) {
                        this.cr.update(c.b.CONTENT_URI, contentValues, "key = ?", new String[]{entry.getKey()});
                    }
                }
                Log.e("MicroMsg.SDK.PluginProvider.Resolver", str);
                i10 = 0;
                if (i10 != 0) {
                }
                if (!z10) {
                }
            }
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z10) {
            this.values.put(str, Boolean.valueOf(z10));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f10) {
            this.values.put(str, Float.valueOf(f10));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i10) {
            this.values.put(str, Integer.valueOf(i10));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j10) {
            this.values.put(str, Long.valueOf(j10));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            this.values.put(str, str2);
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            return null;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.remove.add(str);
            return this;
        }
    }

    public MMSharedPreferences(Context context) {
        this.cr = context.getContentResolver();
    }

    private Object getValue(String str) {
        try {
            Cursor query = this.cr.query(c.b.CONTENT_URI, this.columns, "key = ?", new String[]{str}, null);
            if (query == null) {
                return null;
            }
            Object a10 = query.moveToFirst() ? c.a.a(query.getInt(query.getColumnIndex("type")), query.getString(query.getColumnIndex(HealthDataProviderContracts.NAME_VALUE))) : null;
            query.close();
            return a10;
        } catch (Exception e10) {
            Log.e(TAG, "getValue exception:" + e10.getMessage());
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return getValue(str) != null;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        if (this.editor == null) {
            this.editor = new REditor(this.cr);
        }
        return this.editor;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        try {
            Cursor query = this.cr.query(c.b.CONTENT_URI, this.columns, null, null, null);
            if (query == null) {
                return null;
            }
            int columnIndex = query.getColumnIndex("key");
            int columnIndex2 = query.getColumnIndex("type");
            int columnIndex3 = query.getColumnIndex(HealthDataProviderContracts.NAME_VALUE);
            while (query.moveToNext()) {
                this.values.put(query.getString(columnIndex), c.a.a(query.getInt(columnIndex2), query.getString(columnIndex3)));
            }
            query.close();
            return this.values;
        } catch (Exception e10) {
            Log.e(TAG, "getAll exception:" + e10.getMessage());
            return this.values;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z10) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Boolean)) ? z10 : ((Boolean) value).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f10) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Float)) ? f10 : ((Float) value).floatValue();
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i10) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Integer)) ? i10 : ((Integer) value).intValue();
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j10) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Long)) ? j10 : ((Long) value).longValue();
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        Object value = getValue(str);
        return (value == null || !(value instanceof String)) ? str2 : (String) value;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return null;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
