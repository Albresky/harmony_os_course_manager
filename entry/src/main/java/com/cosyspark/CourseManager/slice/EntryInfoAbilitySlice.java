package com.cosyspark.CourseManager.slice;

import com.cosyspark.coursemanager.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Text;


public class EntryInfoAbilitySlice extends AbilitySlice {
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_entry_info_layout);

        Text txtUserId=(Text) findComponentById(ResourceTable.Id_user_id);
        Text txtUserName=(Text)findComponentById(ResourceTable.Id_user_name);
        Text txtPhoneNumber=(Text) findComponentById(ResourceTable.Id_phone_number);
        Text txtHomeAddress=(Text) findComponentById(ResourceTable.Id_home_address);
        Text txtPs=(Text) findComponentById(ResourceTable.Id_ps);

    }
}