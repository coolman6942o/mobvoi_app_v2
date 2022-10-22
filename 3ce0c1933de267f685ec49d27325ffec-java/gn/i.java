package gn;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts;
import android.provider.ContactsContract;
/* loaded from: classes2.dex */
public class i {
    public static String a(Context context, String str) {
        Cursor cursor;
        ContentResolver contentResolver = context.getContentResolver();
        String[] strArr = {"_id", "display_name"};
        String str2 = null;
        try {
            cursor = contentResolver.query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), strArr, null, null, null);
        } catch (Exception e10) {
            e10.printStackTrace();
            try {
                cursor = contentResolver.query(Uri.withAppendedPath(Contacts.Phones.CONTENT_FILTER_URL, Uri.encode(str)), strArr, null, null, null);
            } catch (Exception e11) {
                e11.printStackTrace();
                cursor = null;
            }
        }
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            String string = cursor.getString(1);
            if (string != null && !string.equals("")) {
                if (string.equals(str)) {
                    cursor.close();
                    return null;
                }
                boolean contains = str.contains(string.replace(" ", ""));
                u.d("caicai", "number1 =" + str + ",b=" + contains + ",name =" + string);
                if (contains) {
                    cursor.close();
                    return null;
                }
            }
            str2 = string;
        }
        if (cursor != null) {
            cursor.close();
        }
        return str2;
    }

    public static String b(Context context, String str) {
        Cursor cursor;
        String[] strArr = {"display_name", "data1"};
        try {
            cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, strArr, "data1 = '" + str + "'", null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        if (cursor == null) {
            u.d("number", "getPeople null");
            return null;
        }
        int count = cursor.getCount();
        u.d("getContactNameByPhNum", "count =" + count);
        if (count > 0) {
            cursor.moveToFirst();
            String string = cursor.getString(cursor.getColumnIndex("display_name"));
            u.d("getContactNameByPhNum", "name =" + string);
            if (string != null || !string.equals("")) {
                if (string.equals(str)) {
                    cursor.close();
                    return null;
                }
                boolean contains = str.contains(string.replace(" ", ""));
                u.d("caicai", "number1 =" + str + ",b=" + contains + ",name =" + string);
                if (contains) {
                    cursor.close();
                    return null;
                }
            }
            cursor.close();
            return string;
        }
        String a10 = a(context, str);
        u.d("getContactNameByPhNum", "phoneName =" + a10);
        cursor.close();
        if (a10 != null) {
            return a10;
        }
        return null;
    }
}
