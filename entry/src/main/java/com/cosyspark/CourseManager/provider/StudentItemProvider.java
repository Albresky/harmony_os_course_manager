package com.cosyspark.CourseManager.provider;


import com.cosyspark.CourseManager.ResourceTable;
import com.cosyspark.CourseManager.bean.Grade;
import ohos.agp.components.*;
import ohos.agp.window.dialog.CommonDialog;
import ohos.app.Context;

import java.util.List;


public class StudentItemProvider extends BaseItemProvider {
    private static final int DIALOG_WIDTH = 900;

    private static final int DIALOG_HEIGHT = 600;

    private static final int DIALOG_CORNER_RADIUS = 30;

    private CommonDialog commonDialog;

    private List<Grade> gradeData;

    private final Context context;

    public StudentItemProvider(Context context, List<Grade> gradeData) {
        this.gradeData = gradeData;
        this.context = context;
    }

    @Override
    public int getCount() {
        return gradeData.size();
    }

    @Override
    public Object getItem(int position) {
        return gradeData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Component getComponent(int position, Component component, ComponentContainer componentContainer) {
        return getItemComponent(position);
    }

    private Component getItemComponent(int position) {
        return getComponent(position);
    }

    private Component getComponent(int position) {
        Grade grade = gradeData.get(position);
        Component container = LayoutScatter.getInstance(context).parse(ResourceTable.Layout_list_item_for_teacher, null, false);
        Text name = (Text) container.findComponentById(ResourceTable.Id_name);
        Text id = (Text) container.findComponentById(ResourceTable.Id_id);
        Text mark = (Text) container.findComponentById(ResourceTable.Id_mark);
        Component btnEdit = container.findComponentById(ResourceTable.Id_btn_edit);
        name.setText(grade.getStuName());
        id.setText(grade.getStuId());
        mark.setText(grade.getStuGrade());
        btnEdit.setClickedListener(component -> showContactDetailDialog(grade, position));
        return container;
    }

    private void showContactDetailDialog(Grade grade, int position) {
        Component container = LayoutScatter.getInstance(context).parse(ResourceTable.Layout_dialog_layout, null, false);
        TextField d_grade = (TextField) container.findComponentById(ResourceTable.Id_grade);
        d_grade.setText(grade.getStuGrade());
        Button btnOk = (Button) container.findComponentById(ResourceTable.Id_btn_ok);

        btnOk.setClickedListener(component -> saveEdit(d_grade.getText(), position));
        commonDialog = new CommonDialog(context);
        commonDialog.setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
        commonDialog.setCornerRadius(DIALOG_CORNER_RADIUS);
        commonDialog.setContentCustomComponent(container);
        commonDialog.show();
    }

    private void saveEdit(String grade, int position) {
        gradeData.get(position).setStuGrade(grade);
        notifyDataChanged();
        commonDialog.destroy();
    }

    public void update(List<Grade> data) {
        gradeData = data;
        notifyDataChanged();
    }
}
