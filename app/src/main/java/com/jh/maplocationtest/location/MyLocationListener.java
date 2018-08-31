package com.jh.maplocationtest.location;

import android.util.Log;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;

/**
 * Created by Administrator on 2018/8/31.
 *
 *  该类是定位成功后的回调实现类,定位的结果在BDLocation中
 *
 *  我们在此只处理定位成功的回调,定位不成功的回调,自己可以根据自己的代码来进行具体处理
 */

public class MyLocationListener extends BDAbstractLocationListener {

    private static final String TAG = MyLocationListener.class.getSimpleName();

    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
        if (bdLocation.getLocType()==61){           //GPS定位结果，GPS定位成功
            //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
            //以下只列举部分获取经纬度相关（常用）的结果信息
            //更多结果信息获取说明，请参照类参考中BDLocation类中的说明
            double latitude = bdLocation.getLatitude();        //获取纬度信息
            double longitude = bdLocation.getLongitude();      //获取经度信息
            float radius = bdLocation.getRadius();             //获取定位精度，默认值为0.0f
            String coorType = bdLocation.getCoorType();         //获取经纬度坐标类型，以LocationClientOption中设置过的坐标类型为准
            Log.i(TAG,latitude+","+longitude);
        }else if (bdLocation.getLocType()==161){              //网络定位结果，网络定位成功
            //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
            //以下只列举部分获取经纬度相关（常用）的结果信息
            //更多结果信息获取说明，请参照类参考中BDLocation类中的说明
            double latitude = bdLocation.getLatitude();       //获取纬度信息
            double longitude = bdLocation.getLongitude();     //获取经度信息
            float radius = bdLocation.getRadius();            //获取定位精度，默认值为0.0f
            String coorType = bdLocation.getCoorType();        //获取经纬度坐标类型，以LocationClientOption中设置过的坐标类型为准
            Log.i(TAG,latitude+","+longitude);
        }else{                                      //定位失败
            Log.i(TAG,"定位失败,错误码:"+bdLocation.getLocType());         //拿到错误码对照定位错误的返回码来具体检查自己的那步出现了问题
        }
    }
}
