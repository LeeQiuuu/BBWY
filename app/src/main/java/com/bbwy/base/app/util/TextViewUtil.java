package com.bbwy.base.app.util;

import android.widget.TextView;

public class TextViewUtil {
    public static void setText(String str, TextView tv){
        if (str ==null)tv.setText("");
        else tv.setText(str);
    }
}
