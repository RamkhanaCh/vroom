package com.vroom;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Log;

import java.lang.Exception;

/**
 * PersonalSettings creates the personal settings directory under the options menu. 
 * <p>
 * The class and its methods are responsible for holding, updating, and providing the various device settings
 * for the program
 * 
 * @author Neale Petrillo
 * @version 1.0 2/9/2011
 *
 */

public class PersonalSettings extends PreferenceActivity {
	/** 
	 * TAG defines the class for debuggin purposes
	 * 
	 * @see PersonalSettings
	 */
	private static final  String TAG = "PersonalSettings";
	
	/**
	 * OPT_KEY is the key for the personal key field in xml/personal_settings.xml
	 * 
	 * @see PersonalSettings
	 */
	private static final String OPT_KEY = "personal_key";
	/**
	 * OPT_KEY_DEF is the default value to return if the key field in xml/personal_settings.xml cannot be found
	 * 
	 * @see PersonalSettings
	 */
	private static final String OPT_KEY_DEF = "";
	
	/**
	 * PersonalSettings constructor.
	 * <p>
	 * Pulls the saved settings from xml/personal_settings and presents them to the user for editing.
	 * 
	 * @author Neale Petrillo
	 * @version 1.0 2/9/2011
	 * 
	 * @param savedInstanceState The saved instance state for returning, type Bundle
	 * @throws none
	 */
	//Start onCreate
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try{
			Log.v(TAG,"Creating personal settings menu!");
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.personal_settings);
		}
		catch (Exception e){
			Log.e(TAG,"There was an error creating the personal settings. Exiting. "+e.getMessage(),e.getCause());
			finish();
		}
	}
	//End onCreate
	
	/**
	 * Gets the current value of the programs access key.
	 * <p>
	 * The program's access key is used instead of a username and password for accessing the Vroom website and database.
	 * The key is automatically generated by the website and should be entered by the user.
	 * 
	 * @author Neale Petrillo
	 * @version 1.0 2/9/2011
	 * 
	 * @param context The context in which we're working, type Context
	 * @return key The program's key, type String
	 * @throws none
	 */
	//Start getKey
	public static String getKey(Context context){
		try{
			Log.v(TAG,"Retrieving value for the user's key");
			return PreferenceManager.getDefaultSharedPreferences(context).getString(OPT_KEY, OPT_KEY_DEF);
		}
		catch (Exception e){
			Log.e(TAG,"There was an error while trying to retrive the user's key. Returning nothing" + e.getMessage(),e.getCause());
			return "";
		}

	}
	//End getKey

}
