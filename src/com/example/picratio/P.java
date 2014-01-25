package com.example.picratio;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.Log;

public class P {
	
	/**���ݱ����������ʺ���Ļ��ͼƬ*/
	static Bitmap pictureMake(Resources resources,int picId,int basicWidth,int basicHeight){
		Bitmap picBuffer; //ͼƬ��ʱ�����
		Bitmap picZoom;   //���ź��ͼƬ
		picBuffer = BitmapFactory.decodeResource(resources, picId);
		picZoom = Bitmap.createScaledBitmap(picBuffer, (int)(basicWidth*Screen.ratioX), (int)(basicHeight*Screen.ratioY), false);
		return picZoom;
	}
	/**��ͼƬ������Ļ�ĺ���λ��*/
	static void pictureDraw(Bitmap bitmap,float angle,float x,float y,Paint paint,Canvas canvas,boolean isCenter){
		Matrix mx = new Matrix();
		mx.postRotate(angle, bitmap.getWidth()/2, bitmap.getHeight()/2); /**����֮��Ҫ�ģ�������������������������*/
		if(isCenter){
			mx.postTranslate(x*Screen.ratioX-bitmap.getWidth()/2,  y*Screen.ratioY-bitmap.getHeight()/2);
		}
		else{
			mx.postTranslate(x*Screen.ratioX,  y*Screen.ratioY);
		}
		Log.v("OzGame", "����X:"+x*Screen.ratioX+" ����Y: "+y*Screen.ratioY);
		canvas.drawBitmap(bitmap, mx, paint);
//		canvas.drawBitmap(bitmap, x*Screen.ratioX, y*Screen.ratioY, paint);
	}
	/**����ȫ��ͼƬ*/
	static void pictureLoad(Resources resources){
		
		pic = pictureMake(resources, R.drawable.pic, 1280, 720);
		box = pictureMake(resources, R.drawable.box, 50, 50);
		
	}

	
	
	static Bitmap pic;
	static Bitmap box;
	
}
