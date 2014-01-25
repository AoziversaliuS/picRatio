package com.example.picratio;



import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		 DisplayMetrics dm=new DisplayMetrics(); 
		 super.getWindowManager().getDefaultDisplay().getMetrics(dm); 
		 Screen.width = dm.widthPixels;
		 Screen.height = dm.heightPixels;
		 Screen.ratioX = Screen.width/1280f;
		 Screen.ratioY = Screen.height/720f;
//		 System.out.println("¿í: "+Screen.width+" ¸ß: "+Screen.height+" DPI: "+dm.densityDpi);
		 Log.v("Screen", "ÆÁÄ»¿í£º "+Screen.width+" ÆÁÄ»¸ß£º "+Screen.height+" DPI: "+dm.densityDpi);
		setContentView(new GameView(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
