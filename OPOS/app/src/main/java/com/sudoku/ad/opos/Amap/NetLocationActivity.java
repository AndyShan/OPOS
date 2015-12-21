package com.sudoku.ad.opos.Amap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
import com.sudoku.ad.opos.R;

/**
 * 网络定位示例
 * */
public class NetLocationActivity extends Activity implements
		AMapLocationListener, OnClickListener {
	private LocationManagerProxy mLocationManagerProxy;


	private TextView mLocationDesTextView;// 定位描述信息



	private Random mRandom = new Random();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 不显示程序的标题栏
		setContentView(R.layout.activity_net_location);
		init();
		initView();
	}

	/**
	 * 初始化定位
	 */
	private void init() {
		// 初始化定位，只采用网络定位
		mLocationManagerProxy = LocationManagerProxy.getInstance(this);
		mLocationManagerProxy.setGpsEnable(false);
		// 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
		// 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用removeUpdates()方法来取消定位请求
		// 在定位结束后，在合适的生命周期调用destroy()方法
		// 其中如果间隔时间为-1，则定位只定一次,
		// 在单次定位情况下，定位无论成功与否，都无需调用removeUpdates()方法移除请求，定位sdk内部会移除
		mLocationManagerProxy.requestLocationData(
				LocationProviderProxy.AMapNetwork, 60 * 1000, 15, this);

	}

	/**
	 * 初始化View
	 */
	private void initView() {

		mLocationDesTextView = (TextView) findViewById(R.id.location_description_text);
		

	}

	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLocationChanged(AMapLocation amapLocation) {

		if (amapLocation != null
				&& amapLocation.getAMapException().getErrorCode() == 0) {
			// 定位成功回调信息，设置相关消息


			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date(amapLocation.getTime());

			mLocationDesTextView.setText(amapLocation.getAddress());

		} else {
			Log.e("AmapErr","Location ERR:" + amapLocation.getAMapException().getErrorCode());
		}

	}

	@Override
	protected void onPause() {
		super.onPause();
		// 移除定位请求
		mLocationManagerProxy.removeUpdates(this);
		// 销毁定位
		mLocationManagerProxy.destroy();
	}

	protected void onDestroy() {
		super.onDestroy();

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.location_time_button:
			// 注意更换定位时间后，需要先将定位请求删除，再进行定位请求
			mLocationManagerProxy.removeUpdates(this);
			int randomTime = mRandom.nextInt(1000);
			mLocationManagerProxy.requestLocationData(
					LocationProviderProxy.AMapNetwork, 60 * 1000 + randomTime,
					15, this);
			mLocationManagerProxy.setGpsEnable(false);
			break;
		}
	}
}
