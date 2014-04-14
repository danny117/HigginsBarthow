/**
 * 
 */
package com.gosylvester.higginsbarthow;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;

/**
 * @author daniel
 * 
 */
public class MuteService extends Service {

	private AudioManager amanager;

	/**
	 * 
	 */

	@Override
	public void onCreate() {
		super.onCreate();

	}

	public MuteService() {
		// TODO Auto-generated constructor stub

	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		int ret = Service.START_STICKY;
		boolean isMuted = intent.getBooleanExtra("mute", false);
		if (amanager == null) {
			amanager = (AudioManager) getBaseContext().getSystemService(
					Context.AUDIO_SERVICE);
		}
		amanager.setStreamMute(AudioManager.STREAM_SYSTEM, isMuted);
		// notifications
		amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, isMuted);
		// alarm
		amanager.setStreamMute(AudioManager.STREAM_ALARM, isMuted);
		// ringer
		amanager.setStreamMute(AudioManager.STREAM_RING, isMuted);
		// media
		amanager.setStreamMute(AudioManager.STREAM_MUSIC, isMuted);
		amanager.setRingerMode(isMuted ? AudioManager.RINGER_MODE_VIBRATE
				: AudioManager.RINGER_MODE_NORMAL);

		// end the service if we are not muted
		if (!isMuted) {
			stopSelf();
			ret = Service.START_NOT_STICKY;
		}
		return ret;
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
}
