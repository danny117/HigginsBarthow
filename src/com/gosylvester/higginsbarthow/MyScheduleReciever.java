package com.gosylvester.higginsbarthow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

public class MyScheduleReciever extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub

		AudioManager amanager = (AudioManager) context
				.getSystemService(Context.AUDIO_SERVICE);
		
		boolean isMuted = true;

		amanager.setStreamMute(AudioManager.STREAM_SYSTEM, isMuted);
		// notifications
		amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, isMuted);
		// alarm
		amanager.setStreamMute(AudioManager.STREAM_ALARM, isMuted);
		// ringer
		amanager.setStreamMute(AudioManager.STREAM_RING, isMuted);
		// media
		amanager.setStreamMute(AudioManager.STREAM_MUSIC, isMuted);

		amanager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);

//		Intent i = new Intent();
//		i.setClassName("com.gosylvester.higginsbarthow",
//				"com.gosylvester.higginsbarthow.FullscreenActivity");
//		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		i.putExtra("mute", true);
//		context.startActivity(i);
	}

}
