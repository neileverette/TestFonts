package com.samsung.testfonts;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

	// NEIL: You can edit the min and max sizes if you want
	// These are "sp" units.
	private static final int TYPEFACE_SIZE_MIN = 15;
	private static final int TYPEFACE_SIZE_MAX = 64;
	// NEIL: You can add a new font to the 'assets' folder, refresh the project from
	// Eclipse, and change the name here to apply it.
	private static final String FONT_FILE_NAME = "LTe50257.ttf";
	private static final String FONT_LABEL_NAME = "Helvetica Neue Light";

	private Typeface customTypeface = null;

	private void initFont()
	{
		/* NEIL: You can just put a .ttf file in the 'assets' folder and then update this text */
		customTypeface = Typeface.createFromAsset(getAssets(), FONT_FILE_NAME);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initFont();
		
		setContentView(R.layout.activity_main);
		ViewGroup topContainer = (ViewGroup) findViewById(R.id.top_container);
		
		addSentences(topContainer);
		applyCustomFont(topContainer);
	}

	private void addSentences(ViewGroup vg)
	{
		TextView tv;
		String textLabel;
		for(int size = TYPEFACE_SIZE_MIN; size <= TYPEFACE_SIZE_MAX; size++)
		{
			textLabel = FONT_LABEL_NAME + " " + size + "sp. Descenders: yjqg"; 
			
			tv = new TextView(this);
			tv.setTextSize(size);
			tv.setText(textLabel);
			vg.addView(tv);
			
			tv = new TextView(this);
			tv.setTextSize(size);
			tv.setText(textLabel.toUpperCase());
			vg.addView(tv);

		}
	}
	
	private void applyCustomFont(View v) {
		if (v instanceof ViewGroup) {
			ViewGroup vg = (ViewGroup) v;
			for (int i = 0; i < vg.getChildCount(); i++) {
				applyCustomFont(vg.getChildAt(i));
			}
		}
		else if(v instanceof TextView)
		{
			((TextView) v).setTypeface(customTypeface);
		}
	}
}