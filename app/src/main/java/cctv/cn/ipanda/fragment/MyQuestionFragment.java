package cctv.cn.ipanda.fragment;

import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.BaseFragment;


public class MyQuestionFragment extends BaseFragment implements OnClickListener{
	CheckBox mCB1,mCB2,mCB3,mCB4,mCB5,mCB6;
	EditText mEt_content,mEt_conact;
	TextView mBtn_submit;
	@Override
	protected int getLayoutId() {
		return R.layout.fragment_personal_feedback_myquestion;
	}

	@Override
	protected void loadData() {

	}

	@Override
	protected void initData() {

	}

	@Override
	protected void initView(View v) {
		mCB1 = (CheckBox) v.findViewById(R.id.myquestion_cb1);
		mCB2 = (CheckBox) v.findViewById(R.id.myquestion_cb2);
		mCB3 = (CheckBox) v.findViewById(R.id.myquestion_cb3);
		mCB4 = (CheckBox) v.findViewById(R.id.myquestion_cb4);
		mCB5 = (CheckBox) v.findViewById(R.id.myquestion_cb5);
		mCB6 = (CheckBox) v.findViewById(R.id.myquestion_cb6);
		mEt_conact = (EditText) v.findViewById(R.id.myquestion_contact);
		mEt_content = (EditText) v.findViewById(R.id.myquestion_content);
		mBtn_submit = (TextView) v.findViewById(R.id.myquestion_submit_btn);
		mBtn_submit.setOnClickListener(this);

	}

	@Override
	protected void initListener() {

	}

	Toast mToast;
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId())
		{
		case R.id.myquestion_submit_btn:
			if (mToast != null) {
				mToast.cancel();
				mToast = null;
			}			
			if(TextUtils.isEmpty(makeTypes())||TextUtils.isEmpty(mEt_conact.getText())){
				String str = TextUtils.isEmpty(makeTypes())?"请选择问题类型！":"联系方式不能为空！";
				{
					mToast = Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT);
					mToast.show();
				}
				return;
				}
				else{
					if(!checkEmail()){
						mToast = Toast.makeText(getActivity(), "邮箱格式错误", Toast.LENGTH_SHORT);
						mToast.show();
						return;
					}
					String content = mEt_content.getText().toString();
					if(null != mBtn_submit.getTag() && content.equals(mBtn_submit.getTag())){
						mToast = Toast.makeText(getActivity(), "内容提交重复", Toast.LENGTH_SHORT);
						mToast.show();
						return;
					}
					mBtn_submit.setTag(content);
					requestHisData();
					mBtn_submit.setClickable(false);
				}
			break;
		}
	}
	
	//检查邮箱
	private boolean checkEmail(){
		String emailString  = mEt_conact.getText().toString().trim();
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		Matcher matcher = pattern.matcher(emailString);
		if(matcher.matches()){
			return true;
		}else {
			return false;
		}
	}
	
	private void requestHisData() {

		if (isConnected()) {


//			content	反馈内容
//			tel	电话
//			email	邮箱
//			appplat	应用平台
//			typeid[]	类型ID
//			phonemodel	手机型号
//			appversion	应用版本号
//			phoneversion	手机系统版本号
//			source	1:央视新闻   2:cbox央视影音 3:icctv央视悦动
//			4:党员网 5:客户端群
//			（默认不填写或为空时是央视新闻）
//			callback	回调函数(可选)
			JSONObject object = new JSONObject();
			HashMap<String, String> map = new HashMap<String, String>();
			try {
				object.put("content", mEt_content.getText().toString().trim());
				if(mEt_conact.getText().toString().trim().contains("@"))
				object.put("email", mEt_conact.getText().toString().trim());
				else
				object.put("tel", mEt_conact.getText().toString().trim());
				object.put("phonemodel", android.os.Build.MODEL);
				object.put("phoneversion", android.os.Build.VERSION.RELEASE);
				object.put("appversion", getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionCode);
				object.put("source", "1");
				object.put("appplat", "android");
				object.put("typeid", makeTypes());
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (NameNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("data", object.toString());
			map.put("method", "videoformobile.getUserVideoRecordList");
			map.put("client", "9");

			Log.e("wang", "json=" + object.toString());

			/*mHander.getHttpPostJson(
					Urls.PE_FEEDBACK_MYQUESTION.toString(), map,
					Object.class, 1);*/
		} else {
			Toast.makeText(getActivity(), "网络错误", Toast.LENGTH_SHORT)
					.show();
		}
	}

	private String makeTypes(){
		String types = "";
		if(mCB1.isChecked()){
			types += "1,";
		}
		if(mCB2.isChecked()){
			types += "2,";
		}
		if(mCB3.isChecked()){
			types += "3,";
		}
		if(mCB4.isChecked()){
			types += "4,";
		}
		if(mCB5.isChecked()){
			types += "5,";
		}
		if(mCB6.isChecked()){
			types += "6,";
		}
		return types;
	}
	public boolean isConnected() {
		// 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
		try {
			ConnectivityManager connectivity = (ConnectivityManager) getActivity()
					.getSystemService(getActivity().CONNECTIVITY_SERVICE);
			if (connectivity != null) {
				// 获取网络连接管理的对象
				NetworkInfo info = connectivity.getActiveNetworkInfo();

				if (info != null && info.isConnected()) {
					// 判断当前网络是否已经连接
					if (info.getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
				}
			}
		} catch (Exception e) {
		}
		return false;
	}
}
