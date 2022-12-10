package com.cosyspark.CourseManager;

import com.cosyspark.CourseManager.slice.EntryGradeAbilitySlice;
import com.cosyspark.CourseManager.slice.EntryInfoAbilitySlice;
import com.cosyspark.CourseManager.slice.LoginAbilitySlice;
import com.cosyspark.CourseManager.slice.QueryGradeAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class MainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(LoginAbilitySlice.class.getName());
    }
}
