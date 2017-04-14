package cctv.cn.ipanda.fragment;

import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.common.App;

/**
 * Created by lenovo on 2017/4/13.
 */

public class PersonChangUserNameFragment extends BaseFragment implements View.OnClickListener {

    private EditText editText;
    private Button button;

    @Override
    protected int getLayoutId() {

        return R.layout.personinfo_changeusername;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

        editText = (EditText) view.findViewById(R.id.person_changeusername);
        button = (Button) view.findViewById(R.id.save);
    }

    @Override
    protected void initListener() {

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.save:
                String s = editText.getText().toString();
                Toast.makeText(App.context, "0...0" + s, Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
