package com.example.picratio;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

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
	static void pictureDraw(Bitmap bitmap,float x,float y,Paint paint,Canvas canvas){
		canvas.drawBitmap(bitmap, x*Screen.ratioX, y*Screen.ratioY, paint);
	}
	/**����ȫ��ͼƬ*/
	static void pictureLoad(Resources resources){
		
		pic = pictureMake(resources, R.drawable.pic, 1280, 720);
		box = pictureMake(resources, R.drawable.box, 50, 50);
		
	}

	
	
	static Bitmap pic;
	static Bitmap box;
	
}
