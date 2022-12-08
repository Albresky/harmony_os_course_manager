package com.cosyspark.CourseManager.provider;


import com.cosyspark.CourseManager.bean.Contact;
import com.cosyspark.coursemanager.ResourceTable;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.LayoutScatter;
import ohos.agp.components.BaseItemProvider;
import ohos.agp.components.Text;
import ohos.agp.components.TextField;
import ohos.agp.window.dialog.CommonDialog;
import ohos.app.Context;

import java.util.List;


public class ContactItemProvider extends BaseItemProvider {
    private static final int DIALOG_WIDTH = 900;

    private static final int DIALOG_HEIGHT = 600;

    private static final int DIALOG_CORNER_RADIUS = 30;

    private CommonDialog commonDialog;

    private List<Contact> contactData;

    private final Context context;

    public ContactItemProvider(Context context, List<Contact> contactData) {
        this.contactData = contactData;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contactData.size();
    }

    @Override
    public Object getItem(int position) {
        return contactData.get(position);
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
        Contact contact = contactData.get(position);
        Component container = LayoutScatter.getInstance(context).parse(ResourceTable.Layout_list_item, null, false);
        Text name = (Text) container.findComponentById(ResourceTable.Id_name);
        Text tel = (Text) container.findComponentById(ResourceTable.Id_tel);
        Component btnEdit = container.findComponentById(ResourceTable.Id_btn_edit);
        name.setText(contact.getUserName());
        tel.setText("tel:" + contact.getTelPhone());
        btnEdit.setClickedListener(component -> showContactDetailDialog(contact, position));
        return container;
    }

    private void showContactDetailDialog(Contact contact, int position) {
        Component container = LayoutScatter.getInstance(context).parse(ResourceTable.Layout_dialog_layout, null, false);
        TextField name = (TextField) container.findComponentById(ResourceTable.Id_name);
        name.setText(contact.getUserName());
        TextField tel = (TextField) container.findComponentById(ResourceTable.Id_tel);
        tel.setText(contact.getTelPhone());
        Button btnOk = (Button) container.findComponentById(ResourceTable.Id_btn_ok);

        btnOk.setClickedListener(component -> saveEdit(name.getText(), tel.getText(), position));
        commonDialog = new CommonDialog(context);
        commonDialog.setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
        commonDialog.setCornerRadius(DIALOG_CORNER_RADIUS);
        commonDialog.setContentCustomComponent(container);
        commonDialog.show();
    }

    private void saveEdit(String name, String tel, int position) {
        contactData.get(position).setUserName(name);
        contactData.get(position).setTelPhone(tel);
        notifyDataChanged();
        commonDialog.destroy();
    }

    /**
     * update list data
     *
     * @param data contactDevicesData list
     */
    public void update(List<Contact> data) {
        contactData = data;
        notifyDataChanged();
    }
}
