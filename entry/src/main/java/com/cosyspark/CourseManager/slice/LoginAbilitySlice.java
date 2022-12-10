package com.cosyspark.CourseManager.slice;

import com.cosyspark.CourseManager.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Text;
import ohos.agp.components.TextField;
import ohos.agp.window.dialog.ToastDialog;

public class LoginAbilitySlice extends AbilitySlice {
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_login);

        Text user_id = (TextField) findComponentById(ResourceTable.Id_user_id);
        Text user_passwd = (Text) findComponentById(ResourceTable.Id_user_passwd);

        Button login = (Button) findComponentById(ResourceTable.Id_btn_login);
        login.setClickedListener(component -> {
            String strUserId = user_id.getText();
            String strUserPasswd = user_passwd.getText();
            if (strUserPasswd.equals("admin")) {
                new ToastDialog(getContext())
                        .setText("欢迎您")
                        .show();
                switch (strUserId) {
                    // account for student page test
                    case "20041423":
                        present(new QueryGradeAbilitySlice(), new Intent());
                        terminate();
                        break;
                    // account for jwc page test
                    case "10000":
                        present(new EntryInfoAbilitySlice(), new Intent());
                        terminate();
                        break;
                    // account for teacher page test
                    case "00001":
                        present(new EntryGradeAbilitySlice(), new Intent());
                        terminate();
                        break;
                    default:
                        break;
                }
            } else {
                new ToastDialog(getContext())
                        .setText("用户信息错误")
                        .show();
            }
        });
    }
}
