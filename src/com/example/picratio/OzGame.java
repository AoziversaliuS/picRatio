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
	static ArrayList<Body> boxArray;
	static boolean Touch = false;
	static float x = 0;
	static float y = 0;
	
	static void load(float width,float height){
		aabb = new AABB();
		aabb.lowerBound.set(0, 0);
		aabb.upperBound.set(width, height);   //��󻭵�ʱ��Ű���������������������׼��Ļ�µĲ��ա�
		gravity = new Vec2(0,10);
		engine = new World(aabb, gravity, true);
		engine.step(refreshTime, iterations);
	}
	static void logic(){
		if(Touch = true){
			new Box(x, y, 50, 50, engine, boxArray);
			Touch = false;
		}
	}
	
	static void show(Canvas canvas,Paint paint){
		Vec2 position;
		
		P.pictureDraw(P.pic, 50, 50, paint, canvas);
		
		for(int i=0;i<boxArray.size();i++){
			position = boxArray.get(i).getPosition();
			P.pictureDraw(P.box, position.x-25, position.y-25, paint, canvas);
		}
	}
}
