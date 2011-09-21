package com.softwarrior.rutrackerdownloader;

import com.softwarrior.rutrackerdownloader.R;
import com.softwarrior.rutrackerdownloader.RutrackerDownloaderApp;
import com.softwarrior.rutrackerdownloader.DownloadPreferencesScreen.MenuType;
import com.softwarrior.rutrackerdownloader.RutrackerDownloaderApp.ActivityResultType;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

public class MainScreen extends Activity {	
	
	    @Override
	    public void onCreate(Bundle icicle) {
	        super.onCreate(icicle);
	        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
	        
	        setContentView(R.layout.main_screen);
	        
	        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);
		        
	        if(RutrackerDownloaderApp.ExitState) RutrackerDownloaderApp.CloseApplication(this);
		    RutrackerDownloaderApp.AnalyticsTracker.trackPageView("/Main");
	    }
	    
	    @Override
	    protected void onResume() {
	    	super.onResume();
	        if(RutrackerDownloaderApp.ExitState) RutrackerDownloaderApp.CloseApplication(this);
	    }
	    		
		@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			switch(ActivityResultType.getValue(resultCode))
			{
			case RESULT_DOWNLOADER:
			case RESULT_PREFERENCES:
			case RESULT_EXIT:
				setResult(resultCode);
				finish();
				break;
			};		
		}
		
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			super.onCreateOptionsMenu(menu);
			menu.add(Menu.NONE, MenuType.About.ordinal(), MenuType.About.ordinal(), R.string.menu_about); 
			menu.add(Menu.NONE, MenuType.Help.ordinal(), MenuType.Help.ordinal(), R.string.menu_help);
			menu.add(Menu.NONE, MenuType.FileManager.ordinal(), MenuType.FileManager.ordinal(), R.string.menu_file_manager);
			menu.add(Menu.NONE, MenuType.WebHistory.ordinal(), MenuType.WebHistory.ordinal(), R.string.menu_web_history);
			menu.add(Menu.NONE, MenuType.Exit.ordinal(), MenuType.Exit.ordinal(), R.string.menu_exit);
			return true;
		}
		
		@Override
		public boolean onMenuItemSelected(int featureId, MenuItem item) {
			super.onMenuItemSelected(featureId, item);
			MenuType type = MenuType.values()[item.getItemId()];
			switch(type)
			{
			case About:{
				RutrackerDownloaderApp.AboutActivity(this);
			} break;
			case Help:{
				RutrackerDownloaderApp.HelpActivity(this);
			} break;
			case FileManager:{
				RutrackerDownloaderApp.FileManagerActivity(this);
			} break;
			case WebHistory:{
				RutrackerDownloaderApp.WebHistoryActivity(this);
			} break;
			case Exit:{
				RutrackerDownloaderApp.FinalCloseApplication(this);
			} break;
			}
			return true;
		}
				
		public void OnClickMainButtonDownload(View v){
			
		}
		public void OnClickMainButtonWebSearch(View v){
			
		}
		public void OnClickMainButtonRSSSearch(View v){
			
		}
		public void OnClickMainButtonPirateSearch(View v){
			
		}
		public void OnClickMainButtonKinoafisha(View v){
			
		}
		public void OnClickMainButtonSettings(View v){
			
		}
}
