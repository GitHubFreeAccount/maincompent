package com.wzx.maincompent;

import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.SurfaceHolder;

import java.io.IOException;

/**
 * Created by admin on 2017/6/15.
 */

public class VideoLiveWallPaper extends WallpaperService {

    private final String TAG="VideoLiveWallPaper";

    @Override
    public Engine onCreateEngine() {
        return new VideoEngine();
    }


    class VideoEngine extends Engine{
        private MediaPlayer mediaPlayer;

        @Override
        public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            super.onSurfaceChanged(holder, format, width, height);
        }

        @Override
        public void onSurfaceCreated(SurfaceHolder holder) {
            super.onSurfaceCreated(holder);
            mediaPlayer=new MediaPlayer();
            mediaPlayer.setSurface(holder.getSurface());
            AssetManager assetManager=getApplication().getAssets();
            try {
               AssetFileDescriptor  fileDescriptor= assetManager.openFd("test1.mp4");

                mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),
                        fileDescriptor.getStartOffset(),fileDescriptor.getLength());
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(0,0);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            Log.d(TAG,"onSurfaceDestroyed");
            mediaPlayer.release();
            mediaPlayer=null;
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
             if(visible){
                 mediaPlayer.start();
             }else {
                 mediaPlayer.pause();
             }
        }
    }

    /**
     * @param context
     * 设置桌面背景
     */
    public static void setToWallPaper(Context context){
        final Intent intent=new Intent(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
        intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,new ComponentName(context,VideoLiveWallPaper.class));
        context.startActivity(intent);
    }
}
