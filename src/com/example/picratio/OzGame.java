package com.example.picratio;

import java.util.ArrayList;

import org.jbox2d.collision.AABB;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

import com.example.Item.Box;

import android.graphics.Canvas;
import android.graphics.Paint;

public class OzGame {
	static float  refreshTime = 0.015f;  //ˢ��ʱ��
	static int    iterations = 10;      // ����ֵ
	static AABB   aabb;
	static Vec2   gravity;
	static World  engine;
	static ArrayList<Body> boxArray = new ArrayList<Body>();
	static boolean Touch = false;
	static float x = 0;
	static float y = 0;
	private static boolean engineCreated = false;
	static void load(float width,float height){
		if(!engineCreated){
			aabb = new AABB();
			aabb.lowerBound.set(0, 0);
//			System.out.println("�������淶Χ��" +width+"   "+height);
			aabb.upperBound.set(width, height);   //��󻭵�ʱ��Ű���������������������׼��Ļ�µĲ��ա�
			gravity = new Vec2(200.0f,0.0f);
			engine = new World(aabb, gravity, true);
			System.out.println(" ��������ɹ���"+GameView.i);
			engineCreated = true;
		}
	}
	static void engineSimulating(){
		engine.step(refreshTime, iterations);
	}
	static void logic(){
		if(Touch == true){
				new Box(OzGame.x, OzGame.y, 50, 50, engine, boxArray);
//			new Box(500, 300, 50, 50, engine, boxArray);
			Touch = false;
		}
	}
	
	static void show(Canvas canvas,Paint paint){
		Vec2 position;
		P.pictureDraw(P.pic,0,0,0, paint, canvas);
		P.pictureDraw(P.pic,0,0,0, paint, canvas);
//		P.pictureDraw(P.pic,0,0,0, paint, canvas);
		
		for(int i=0;i<boxArray.size();i++){
			float angle = 0;
			angle = (float) (boxArray.get(i).getAngle()*180/Math.PI);
			position = boxArray.get(i).getPosition();
			P.pictureDraw(P.box,angle, position.x-25, position.y-25, paint, canvas);
		}
	}
}
