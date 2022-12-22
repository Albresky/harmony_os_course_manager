package com.cosyspark.CourseManager.slice;

import com.cosyspark.CourseManager.ResourceTable;
import com.cosyspark.CourseManager.bean.Course;
import com.cosyspark.CourseManager.provider.GradeItemProvider;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.ListContainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class QueryGradeAbilitySlice extends AbilitySlice {
    private static final int LIST_ITEM_COUNT = 9;

    private ListContainer listContainer;

    private GradeItemProvider gradeItemProvider;

    private ArrayList<Course> courseData;

    private ArrayList<String> courseNames;

    private ArrayList<String> courseIds;

    private ArrayList<String> coursePoints;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_query_grade_layout);

        initComponents();
        initGradeData();
        initProvider();
    }

    private void initComponents() {
        listContainer = (ListContainer) findComponentById(ResourceTable.Id_list_container);
    }

    private void initProvider() {
        gradeItemProvider = new GradeItemProvider(this, courseData);
        listContainer.setItemProvider(gradeItemProvider);
        listContainer.setReboundEffect(true);
    }

    private void initGradeData() {

        String[] names = {"软件工程", "计算机网络", "计算机组成原理", "马克思主义基本原理", "数据结构", "操作系统", "数据库原理", "计算机图形学", "计算机系统结构"};
        String[] ids = {"S2334101-1", "S2334101-2", "S2334101-3", "S2334101-4", "S2334101-5", "S2334101-6", "S2334101-7", "S2334101-8", "S2334101-9"};
        String[] points = {"4", "4", "4", "3", "4", "4", "3", "2", "2"};


        courseNames = new ArrayList<>(Arrays.asList(names));
        courseIds = new ArrayList<>(Arrays.asList(ids));
        coursePoints = new ArrayList<>(Arrays.asList(points));

        courseData = new ArrayList<>();
        for (int i = 0; i < LIST_ITEM_COUNT; i++) {
            addCourse(i);
        }
    }

    private void addCourse(int index) {
        Random random = new Random();
        courseData.add(new Course(courseNames.get(index), courseIds.get(index), coursePoints.get(index), String.valueOf(random.nextInt(20) + 80)));
    }
}
