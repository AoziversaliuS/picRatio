package com.example.picratio;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Callback,Runnable{

	private SurfaceHolder sfh;
	private Paint paint;
	private Thread thread;
	private boolean thread_flag = false;
	private Canvas canvas;
	static int i = 0;
	private int count = 0;
	
	public GameView(Context context) {
		super(context);
		sfh = this.getHolder();
		sfh.addCallback(this);
		paint = new Paint();
		setFocusable(true);
		P.pictureLoad(getResources());              //载入所有图片
		OzGame.load(Screen.width, Screen.height);    //载入引擎
		i++;
	}
	

	public boolean onTouchEvent(MotionEvent e) {
		if(count>10){
			OzGame.Touch = true;
			OzGame.x = e.getX();
			OzGame.y = e.getY();
			count = 0;
			System.out.println("触碰的坐标X" + OzGame.x +"触碰的坐标Y"+OzGame.y );
		}
		return true;
	}

	public void Draw(){
		this.canvas = sfh.lockCanvas();
		if(this.canvas != null){
			OzGame.engineSimulating();
			OzGame.logic();
			OzGame.show(canvas, paint);
		}
		sfh.unlockCanvasAndPost(canvas);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		
		//视图创建时候启动线程
		this.thread_flag = true;
		this.thread = new Thread(this);
		this.thread.start();
		
	}
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,int height) {
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		this.thread_flag = false;
	}

	
	
	@Override
	public void run() {
		try {
			while(this.thread_flag){
				if(OzGame.Touch == false){
					this.count++;
				}
//				System.out.println("计算大小："+count);
				this.Draw();
				Thread.sleep((long)(OzGame.refreshTime*100));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
