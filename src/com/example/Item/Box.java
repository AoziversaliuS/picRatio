package com.example.Item;

import java.util.ArrayList;

import org.jbox2d.collision.PolygonDef;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;


public class Box {
	public Box(float x,float y,float basicWidth,float basicHeight,World engine,ArrayList<Body> array){
		PolygonDef pd = new PolygonDef();
		pd.density = 1;
		pd.friction = 0.8f;
		pd.restitution = 0.3f;
		pd.setAsBox(basicWidth/2, basicHeight/2);
		BodyDef bd = new BodyDef();
		bd.position.set(x+basicWidth/2, y+basicHeight/2);
		Body body = engine.createDynamicBody(bd);
		body.setMassFromShapes();
		array.add(body);
	}
}
