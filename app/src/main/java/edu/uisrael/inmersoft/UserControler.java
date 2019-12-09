package edu.uisrael.inmersoft;

import android.content.Context;
import android.text.TextUtils;

public class UserControler {
    private final String KEY_USERNAME = "estudiante2019";
    private final String KEY_PASSWORD = "uisrael2019";
    public static String USER_YEY="userName" ;
    public static String NAME_COMPLETE="nameComplete";
    public static String P1_KEY_TXT="p1_key_txt";
    public static String P2_KEY_SCC="p2_key_scc";
    public static String P2_KEY_BK="p2_key_bk";
    public static String P2_KEY_WK="p2_key_wk";
    public static String P3_KEY_OPT="p3_key_opt";


    public UserControler(Context context) {
    }
    public boolean checkLoginValidate(String username, String password) {
        if ((!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) &&
                KEY_USERNAME.equals(username) &&
                KEY_PASSWORD.equals(password)) {
            return true;
        }
        return false;
    }
}
