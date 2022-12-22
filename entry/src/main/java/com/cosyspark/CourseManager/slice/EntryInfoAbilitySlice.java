package com.cosyspark.CourseManager.slice;

import com.cosyspark.CourseManager.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.RadioButton;
import ohos.agp.components.Text;
import ohos.agp.window.dialog.ToastDialog;

import java.util.logging.Logger;


public class EntryInfoAbilitySlice extends AbilitySlice {

    private Logger logger;

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_entry_info_layout);

        logger = Logger.getLogger(getBundleName());

        Text txtUserId = (Text) findComponentById(ResourceTable.Id_user_id);
        Text txtUserName = (Text) findComponentById(ResourceTable.Id_user_name);
        RadioButton userGenderMale = (RadioButton) findComponentById(ResourceTable.Id_gender_male);
        RadioButton userGenderFemale = (RadioButton) findComponentById(ResourceTable.Id_gender_male);
        Text userGrade = (Text) findComponentById(ResourceTable.Id_s_grade);
        Text userClass = (Text) findComponentById(ResourceTable.Id_s_class);
        Text txtPhoneNumber = (Text) findComponentById(ResourceTable.Id_phone_number);
        Text txtHomeAddress = (Text) findComponentById(ResourceTable.Id_home_address);
        Text txtPs = (Text) findComponentById(ResourceTable.Id_ps);

        Button btn_entry = (Button) findComponentById(ResourceTable.Id_btn_load_info);
        Button btn_save = (Button) findComponentById(ResourceTable.Id_btn_save_info);

        userGenderMale.setChecked(true);

        btn_entry.setClickedListener(component -> {
            logger.warning(txtUserId.getText());
            if (txtUserId != null && txtUserId.getText().equals("20041423")) {
                txtUserName.setText("石开");
                userGenderMale.setChecked(true);
                userClass.setText("20052312");
                userGrade.setText("2020");
                txtPhoneNumber.setText("15988126307");
                txtHomeAddress.setText("浙江省杭州市钱塘区白杨街道杭州电子科技大学生活区28号楼515");
                new ToastDialog(getContext())
                        .setText("学生基本信息录入成功！")
                        .show();
            } else {
                new ToastDialog(getContext())
                        .setText("请输入正确的学号！")
                        .show();
            }
        });

        btn_save.setClickedListener(component -> {
            if (txtUserId.getText() != null
                    && txtUserName.getText() != null
                    && userClass.getText() != null
                    && userGrade.getText() != null
                    && txtPhoneNumber.getText() != null
                    && txtHomeAddress.getText() != null
            ) {
                if (userClass.getText().length() != 8) {
                    new ToastDialog(getContext())
                            .setText("班级信息非法！")
                            .show();
                    return;
                }
                if (userGrade.getText().length() != 4) {
                    new ToastDialog(getContext())
                            .setText("年级信息非法！")
                            .show();
                    return;
                }
                if (txtPhoneNumber.getText().length() != 11) {
                    new ToastDialog(getContext())
                            .setText("手机号码非法！")
                            .show();
                    return;
                }
                new ToastDialog(getContext())
                        .setText("学生基本信息录入成功！")
                        .show();
            } else {
                new ToastDialog(getContext())
                        .setText("请完善学生基本信息！")
                        .show();
            }
        });
    }
}