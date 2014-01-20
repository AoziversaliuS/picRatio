package com.example.Item;

import java.util.ArrayList;

import org.jbox2d.collision.PolygonDef;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;


public class Box {
	static boolean test = false;
	public Box(float x,float y,float basicWidth,float basicHeight,World engine,ArrayList<Body> array){
		PolygonDef pd = new PolygonDef();
//		if(test){
//			pd.density = 0;
//			test = false;
//		}
//		else{
//			pd.density = 1;
//			test = true;
//		}
		pd.density = 10f;
		pd.friction = 0.1f;
		pd.restitution = 0.3f;
		pd.setAsBox(basicWidth/2, basicHeight/2);
		BodyDef bd = new BodyDef();
		bd.position.set(x+basicWidth/2, y+basicHeight/2);
		Body body = engine.createDynamicBody(bd);
		body.createShape(pd);
		body.setMassFromShapes();
		array.add(body);
	}
}
