package com.example.picratio;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Callback,Runnable{

	private SurfaceHolder sfh;
	private Paint paint;
	private Thread thread;
	private boolean thread_flag = false;
	private Canvas canvas;
	
	public GameView(Context context) {
		super(context);
		sfh = this.getHolder();
		sfh.addCallback(this);
		paint = new Paint();
		setFocusable(true);
		OzGame.load(Screen.width, Screen.height);    //��������
		P.pictureLoad(getResources());              //��������ͼƬ
	}
	

//	public boolean onTouchEvent(MotionEvent e) {
//		OzGame.Touch = true;
//		OzGame.x = e.getX();
//		OzGame.y = e.getY();
//		return true;
//	}

	public void Draw(){
		this.canvas = sfh.lockCanvas();
		if(this.canvas != null){
			OzGame.logic();
			OzGame.show(canvas, paint);
		}
		sfh.unlockCanvasAndPost(canvas);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		
		//��ͼ����ʱ�������߳�
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
				this.Draw();
				Thread.sleep((long)(OzGame.refreshTime*1000));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
