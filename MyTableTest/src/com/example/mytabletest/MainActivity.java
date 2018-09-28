package com.example.mytabletest;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author daij
 * @version 1.0
 * 
 */
public class MainActivity extends Activity {
	// private String[] items = { "01", "02", "03", "04", "05", "06", "07",
	// "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
	// "20" };
	private LinearLayout llFloorDes, llAreas;
	private RadioGroup rgFloors;
	private PopupWindow popupWindow;
	private TextView tvFloorNum;
	private Button btnUp, btnDown;
	private int totalFloors = 30, currentFloor = 1;
	private TextView tvWRItem1, tvWRItem2, tvWRItem3;
	private ArrayList<WashingRoomPojo> washingroomAreas = new ArrayList<WashingRoomPojo>();// 水系统

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		getData();
		setViews();
		initPopwindow();
		setListeners();

		showData();
	}

	/**
	 * 显示数据
	 */
	private void showData() {

		for (int i = 0; i < washingroomAreas.size(); i++) {// 动态添加状态
			final WashingRoomPojo pojo = washingroomAreas.get(i);

			LinearLayout llWashingRoomItem = new LinearLayout(this);
			llWashingRoomItem.setLayoutParams(new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			llWashingRoomItem = (LinearLayout) getLayoutInflater().inflate(
					R.layout.wr_area_item, null);
			TextView tvAreaName = (TextView) llWashingRoomItem
					.findViewById(R.id.tv_wr_areaname);
			TextView tvManMt = (TextView) llWashingRoomItem
					.findViewById(R.id.tv_wr_mt_man);
			TextView tvManDc = (TextView) llWashingRoomItem
					.findViewById(R.id.tv_wr_dc_man);
			TextView tvManXBC = (TextView) llWashingRoomItem
					.findViewById(R.id.tv_wr_xbc_man);
			TextView tvWomanMt = (TextView) llWashingRoomItem
					.findViewById(R.id.tv_wr_mt_woman);
			TextView tvWomanDc = (TextView) llWashingRoomItem
					.findViewById(R.id.tv_wr_dc_woman);
			TextView tvWomanXBC = (TextView) llWashingRoomItem
					.findViewById(R.id.tv_wr_xbc_woman);

			tvAreaName.setText(pojo.wrAreaName);
			tvManMt.setText("" + pojo.wrManMTNum);
			tvManDc.setText("" + pojo.wrManDCNum);
			tvManXBC.setText("" + pojo.wrManXBCNum);
			tvWomanMt.setText("" + pojo.wrWomanMTNum);
			tvWomanDc.setText("" + pojo.wrWomanDCNum);
			tvWomanXBC.setText("" + pojo.wrWomanXBCNum);
			llAreas.addView(llWashingRoomItem);
		}
	}

	/**
	 * 获取数据
	 */
	private void getData() {
		washingroomAreas.add(new WashingRoomPojo().setWrAreaName("A区")
				.setWrManDC(8).setWrManMT(6).setWrManXBC(6).setWrWomanDC(8)
				.setWrWomanMT(6).setWrWomanXBC(6));
		washingroomAreas.add(new WashingRoomPojo().setWrAreaName("B区")
				.setWrManDC(8).setWrManMT(5).setWrManXBC(6).setWrWomanDC(9)
				.setWrWomanMT(6).setWrWomanXBC(6));
		washingroomAreas.add(new WashingRoomPojo().setWrAreaName("C区")
				.setWrManDC(8).setWrManMT(6).setWrManXBC(4).setWrWomanDC(8)
				.setWrWomanMT(6).setWrWomanXBC(3));
		washingroomAreas.add(new WashingRoomPojo().setWrAreaName("D区")
				.setWrManDC(8).setWrManMT(6).setWrManXBC(6).setWrWomanDC(8)
				.setWrWomanMT(6).setWrWomanXBC(6));
		washingroomAreas.add(new WashingRoomPojo().setWrAreaName("E区")
				.setWrManDC(8).setWrManMT(5).setWrManXBC(6).setWrWomanDC(9)
				.setWrWomanMT(6).setWrWomanXBC(6));
		washingroomAreas.add(new WashingRoomPojo().setWrAreaName("F区")
				.setWrManDC(8).setWrManMT(6).setWrManXBC(4).setWrWomanDC(8)
				.setWrWomanMT(6).setWrWomanXBC(3));
		washingroomAreas.add(new WashingRoomPojo().setWrAreaName("G区")
				.setWrManDC(8).setWrManMT(6).setWrManXBC(4).setWrWomanDC(8)
				.setWrWomanMT(6).setWrWomanXBC(3));
		washingroomAreas.add(new WashingRoomPojo().setWrAreaName("H区")
				.setWrManDC(8).setWrManMT(6).setWrManXBC(6).setWrWomanDC(8)
				.setWrWomanMT(6).setWrWomanXBC(6));
		washingroomAreas.add(new WashingRoomPojo().setWrAreaName("I区")
				.setWrManDC(8).setWrManMT(5).setWrManXBC(6).setWrWomanDC(9)
				.setWrWomanMT(6).setWrWomanXBC(6));
		washingroomAreas.add(new WashingRoomPojo().setWrAreaName("J区")
				.setWrManDC(8).setWrManMT(6).setWrManXBC(4).setWrWomanDC(8)
				.setWrWomanMT(6).setWrWomanXBC(3));
	}

	private void setViews() {
		llFloorDes = (LinearLayout) findViewById(R.id.ll_floor);
		tvFloorNum = (TextView) findViewById(R.id.tv_floor_num);
		btnUp = (Button) findViewById(R.id.btn_wr_up);
		btnDown = (Button) findViewById(R.id.btn_wr_down);

		tvWRItem1 = (TextView) findViewById(R.id.tv_wr_item1);
		tvWRItem2 = (TextView) findViewById(R.id.tv_wr_item2);
		tvWRItem3 = (TextView) findViewById(R.id.tv_wr_item3);
		llAreas = (LinearLayout) findViewById(R.id.wr_areas);

		tvFloorNum.setText("" + currentFloor);
		initTvItems(tvWRItem1, tvWRItem2, tvWRItem3);

	}

	private void setListeners() {
		llFloorDes.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				openOrClosePopMenu(view);
			}
		});

		btnUp.setOnClickListener(new OnClickListener() {// 上一层
			@Override
			public void onClick(View v) {
				if (currentFloor < totalFloors) {
					tvFloorNum.setText("" + ++currentFloor);
				}
			}
		});

		btnDown.setOnClickListener(new OnClickListener() {// 下一层
			@Override
			public void onClick(View arg0) {
				if (currentFloor > 1) {
					tvFloorNum.setText("" + --currentFloor);
				}
			}
		});
	}

	/**
	 * PopupWindow初始化
	 */
	private void initPopwindow() {
		View contentView = getLayoutInflater().inflate(R.layout.floor_pop_menu,
				null, false);
		popupWindow = new PopupWindow(contentView,
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		popupWindow.setFocusable(true);// 取得焦点
		popupWindow.setOutsideTouchable(true); // 设置允许在外点击消失
		popupWindow
				.setBackgroundDrawable(new BitmapDrawable(getResources(), "")); // 点击返回键也能使其消失，不影响背景
		popupWindow.setAnimationStyle(R.style.animation);// 设置PopupWindow弹出和退出时候的动画效果

		rgFloors = (RadioGroup) contentView.findViewById(R.id.rg_floors); // 单选按钮组

		LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		for (int i = 1; i <= totalFloors; i++) {// 添加单选按钮
			RadioButton radio = (RadioButton) inflater.inflate(
					R.layout.floor_radiobutton_item, null);
			radio.setText(" " + i);
			radio.setId(i);// 让id和楼层相同
			rgFloors.addView(radio);

			if (i == currentFloor) {
				radio.setChecked(true);
			}
		}

		rgFloors.setOnCheckedChangeListener(new OnCheckedChangeListener() {// 设置楼层选择监听事件
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				currentFloor = checkedId;// 当前选中楼层
				// RadioButton rb = (RadioButton) group.findViewById(rgFloors
				// .getCheckedRadioButtonId());
				// String floor = rb.getText().toString();
				tvFloorNum.setText("" + currentFloor);
			}
		});
	}

	/**
	 * 初始化界面分类文字（字体大小不同）
	 * 
	 * @param tv1
	 * @param tv2
	 * @param tv3
	 */
	private void initTvItems(TextView tv1, TextView tv2, TextView tv3) {
		SpannableString itemText1 = new SpannableString("XX(XX)");
		SpannableString itemText2 = new SpannableString("XXX(XX)");
		SpannableString itemText3 = new SpannableString("XXX(XX)");
		itemText1.setSpan(new TextAppearanceSpan(this,
				R.style.wr_item_txt_front), 0, 2,
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		itemText1.setSpan(new TextAppearanceSpan(this,
				R.style.wr_item_txt_behind), 2, 6,
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		itemText2.setSpan(new TextAppearanceSpan(this,
				R.style.wr_item_txt_front), 0, 2,
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		itemText2.setSpan(new TextAppearanceSpan(this,
				R.style.wr_item_txt_behind), 2, 6,
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		itemText3.setSpan(new TextAppearanceSpan(this,
				R.style.wr_item_txt_front), 0, 3,
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		itemText3.setSpan(new TextAppearanceSpan(this,
				R.style.wr_item_txt_behind), 3, 7,
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		tv1.setText(itemText1, TextView.BufferType.SPANNABLE);
		tv2.setText(itemText2, TextView.BufferType.SPANNABLE);
		tv3.setText(itemText3, TextView.BufferType.SPANNABLE);
	}

	/**
	 * 弹出菜单
	 * 
	 * @param view
	 */
	public void openOrClosePopMenu(View view) {
		if (popupWindow.isShowing()) {
			popupWindow.dismiss();
			return;
		} else {
			popupWindow.showAsDropDown(view);
			rgFloors.check(currentFloor);// 每次打开弹窗，重新选中
		}
	}
}
