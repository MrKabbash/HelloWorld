package com.erinkabbash.helloworld;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
            ActionBar actionBar = getActionBar();
            actionBar.hide();
            
            fade();
        }


	private void fade() {
		Button buttonFade = (Button) findViewById(R.id.operateButton);
		final ImageView image = (ImageView) findViewById(R.id.helloWorldImage);

		final Animation animationFadeIn = AnimationUtils.loadAnimation(this,
				R.anim.fadein);
		final Animation animationFadeOut = AnimationUtils.loadAnimation(this,
				R.anim.fadeout);
		
		buttonFade.setOnClickListener(new Button.OnClickListener() {
			boolean isVisible = true;
			@Override			
			public void onClick(View arg0) {
				
				if (isVisible == true) {
					image.startAnimation(animationFadeOut);
					image.setVisibility(View.INVISIBLE);
					isVisible = false;
				} else {
					image.startAnimation(animationFadeIn);
					image.setVisibility(View.VISIBLE);
					isVisible = true;
				}
			}
		});
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
        
        
        
        
    }
    
    

}
