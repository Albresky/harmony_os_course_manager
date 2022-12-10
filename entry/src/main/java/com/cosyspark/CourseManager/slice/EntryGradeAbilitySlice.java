package com.cosyspark.CourseManager.slice;

import com.cosyspark.CourseManager.ResourceTable;
import com.cosyspark.CourseManager.bean.Grade;
import com.cosyspark.CourseManager.provider.StudentItemProvider;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.ListContainer;

import java.util.ArrayList;
import java.util.Arrays;

public class EntryGradeAbilitySlice extends AbilitySlice {
    private static final int LIST_ITEM_COUNT = 23;

    private ListContainer listContainer;

    private StudentItemProvider studentItemProvider;

    private ArrayList<Grade> gradeData;

    private ArrayList<String> stuNames;

    private ArrayList<String> stuIds;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_entry_grade_layout);

        initComponents();
        initGradeData();
        initProvider();
    }

    private void initComponents() {
        listContainer = (ListContainer) findComponentById(ResourceTable.Id_list_container);
    }

    private void initProvider() {
        studentItemProvider = new StudentItemProvider(this, gradeData);
        listContainer.setItemProvider(studentItemProvider);
        listContainer.setReboundEffect(true);
    }

    private void initGradeData() {

        String[] names = {"张三", "李四", "王五", "赵六", "孙七", "周八", "吴九", "郑十", "钱十一", "孙十二", "李十三", "周十四", "吴十五", "郑十六", "钱十七", "孙十八", "李十九", "周二十", "吴二十一", "郑二十二", "钱二十三", "孙二十四", "李二十五"};
        String[] ids = {"20050001", "20050002", "20050003", "20050004", "20050005", "20050006", "20050007", "20050008", "20050009", "20050010", "20050011", "20050012", "20050013", "20050014", "20050015", "20050016", "20050017", "20050018", "20050019", "20050020", "20050021", "20050022", "20050023"};

        stuNames = new ArrayList<>(Arrays.asList(names));
        stuIds = new ArrayList<>(Arrays.asList(ids));

        gradeData = new ArrayList<>();
        for (int i = 0; i < LIST_ITEM_COUNT; i++) {
            addStudent(i);
        }
    }

    private void addStudent(int index) {
        gradeData.add(new Grade(stuNames.get(index), stuIds.get(index),"/"));
    }
}
