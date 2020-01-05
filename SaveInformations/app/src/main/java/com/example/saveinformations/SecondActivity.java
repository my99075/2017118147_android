package com.example.saveinformations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class SecondActivity extends Activity {
    // 展示用户名和电话
    private TextView tv_showName, tv_showPhone;
    // 修改密码所输入的值
    private String name,oldPsw,newPsw;
    // 修改密码输入框
    private EditText et_changeUsername,et_changeOldPsw,et_changeNewPsw;
    private ListView listview;
    private List<User> allUser;
    private ListViewAdapter adapter;
    private Button btn_deleteAll, btn_findAllUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }
    private void initView() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        tv_showName = (TextView) findViewById(R.id.tv_phone);
        tv_showPhone = (TextView) findViewById(R.id.tv_nickname);
        tv_showName.setText("电话号码：" + phone);
        tv_showPhone.setText("昵称:" + name + "（火星）");
        btn_deleteAll = (Button) findViewById(R.id.btn_deleteAllUser);
        btn_findAllUser = (Button) findViewById(R.id.btn_findAllUser);
    }
    // 修改密码对话框
    public void changepsw(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        view = View.inflate(this, R.layout.changepsw_dialog, null);
        builder.setView(view);
        et_changeUsername = (EditText) view.findViewById(R.id.username_et);
        et_changeOldPsw = (EditText) view.findViewById(R.id.psw_et);
        et_changeNewPsw = (EditText) view.findViewById(R.id.newpsw_et);
        builder.setPositiveButton("确定", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                name = et_changeUsername.getText().toString().trim();
                oldPsw = et_changeOldPsw.getText().toString().trim();
                newPsw = et_changeNewPsw.getText().toString().trim();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(oldPsw)
                        || TextUtils.isEmpty(newPsw)) {
                    Toast.makeText(SecondActivity.this, "选项不能为空", 0).show();
                    return;
                }
                String password = UserInfoManager.getInstance(
                        SecondActivity.this).findData(name,
                        UserInfoManager.PASSWORD);
                String phone = UserInfoManager.getInstance(SecondActivity.this)
                        .findData(name, UserInfoManager.PHONE);
                if (password.equals(oldPsw)) {
                    User user = new User(name, newPsw, phone);
                    UserInfoManager.getInstance(SecondActivity.this)
                            .updateUser(user);
                    Toast.makeText(SecondActivity.this, "修改成功", 0).show();
                    UserInfoManager.dialogState(dialog, true);
                } else {
                    Toast.makeText(SecondActivity.this, "用戶名或密码不正确", 0).show();
                    UserInfoManager.dialogState(dialog, false);
                }
            }
        });
        builder.setNegativeButton("取消", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                UserInfoManager.dialogState(dialog, true);
            }
        });
        builder.create().show();
    }
    public void findAllUser(View view) {
        allUser = UserInfoManager.getInstance(this).queryAll();
        listview = (ListView) findViewById(R.id.listview);
        listview.setVisibility(View.VISIBLE);
        adapter = new ListViewAdapter(this, allUser);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(adapter);
        btn_findAllUser.setVisibility(View.GONE);
        btn_deleteAll.setVisibility(View.VISIBLE);
        adapter.setOnClickListener(new onClickListener() {
            @Override
            public void onClick() {
                if (allUser.size() == 0) {
                    listview.setVisibility(View.GONE);
                    btn_deleteAll.setVisibility(View.GONE);
                }
            }
        });
    }
    public void deleteAll(View view) {
        UserInfoManager.getInstance(this).deleteAll();
        allUser.clear();
        adapter.notifyDataSetChanged();
        btn_deleteAll.setVisibility(View.GONE);
        listview.setVisibility(View.GONE);
    }
}

