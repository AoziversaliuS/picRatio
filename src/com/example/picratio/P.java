package com.example.picratio;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.Log;

public class P {
	
	/**根据比例来制造适合屏幕的图片*/
	static Bitmap pictureMake(Resources resources,int picId,int basicWidth,int basicHeight){
		Bitmap picBuffer; //图片暂时存放区
		Bitmap picZoom;   //缩放后的图片
		picBuffer = BitmapFactory.decodeResource(resources, picId);
		picZoom = Bitmap.createScaledBitmap(picBuffer, (int)(basicWidth*Screen.ratioX), (int)(basicHeight*Screen.ratioY), false);
		return picZoom;
	}
	/**将图片画在屏幕的合适位置*/
	static void pictureDraw(Bitmap bitmap,float angle,float x,float y,Paint paint,Canvas canvas,boolean isCenter){
		Matrix mx = new Matrix();
		mx.postRotate(angle, bitmap.getWidth()/2, bitmap.getHeight()/2); /**这里之后要改！！！！！！！！！！！！！*/
		if(isCenter){
			mx.postTranslate(x*Screen.ratioX-bitmap.getWidth()/2,  y*Screen.ratioY-bitmap.getHeight()/2);
		}
		else{
			mx.postTranslate(x*Screen.ratioX,  y*Screen.ratioY);
		}
		Log.v("OzGame", "坐标X:"+x*Screen.ratioX+" 坐标Y: "+y*Screen.ratioY);
		canvas.drawBitmap(bitmap, mx, paint);
//		canvas.drawBitmap(bitmap, x*Screen.ratioX, y*Screen.ratioY, paint);
	}
	/**载入全部图片*/
	static void pictureLoad(Resources resources){
		
		pic = pictureMake(resources, R.drawable.pic, 1280, 720);
		box = pictureMake(resources, R.drawable.box, 50, 50);
		
	}

	
	
	static Bitmap pic;
	static Bitmap box;
	
}
