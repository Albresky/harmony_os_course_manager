package com.cosyspark.CourseManager.provider;


import com.cosyspark.CourseManager.ResourceTable;
import com.cosyspark.CourseManager.bean.Course;
import ohos.agp.components.*;
import ohos.app.Context;

import java.util.List;


public class GradeItemProvider extends BaseItemProvider {

    private List<Course> courseData;

    private final Context context;

    public GradeItemProvider(Context context, List<Course> courseData) {
        this.courseData = courseData;
        this.context = context;
    }

    @Override
    public int getCount() {
        return courseData.size();
    }

    @Override
    public Object getItem(int position) {
        return courseData.get(position);
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
        Course course = courseData.get(position);
        Component container = LayoutScatter.getInstance(context).parse(ResourceTable.Layout_list_item_for_student, null, false);
        Text name = (Text) container.findComponentById(ResourceTable.Id_name);
        Text id = (Text) container.findComponentById(ResourceTable.Id_id);
        Text point = (Text) container.findComponentById(ResourceTable.Id_point);
        Text mark = (Text) container.findComponentById(ResourceTable.Id_mark);
        name.setText(course.getName());
        id.setText(course.getId());
        point.setText(course.getPoint());
        mark.setText(course.getMark());
        return container;
    }
}
