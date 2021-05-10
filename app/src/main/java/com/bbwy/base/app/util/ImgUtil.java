package com.bbwy.base.app.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ImgUtil {
    public static void loadVillagerImg(Context context, ImageView mImage,String path){
        // load image
        try {
            // get input stream
            InputStream ims = context.getAssets().open("villager/"+path+".png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            mImage.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }
    public static void loadNpcImg(Context context, ImageView mImage,String path){
        // load image
        try {
            // get input stream
            InputStream ims = context.getAssets().open("npc/"+path+".png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            mImage.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }
    public static void loadJiajuImg(Context context, ImageView mImage,String path){
        // load image
        try {
            // get input stream
            InputStream ims = context.getAssets().open("furniture/"+path+".png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            mImage.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }
    public static void loadFishImg(Context context, ImageView mImage,String path){
        // load image
        try {
            // get input stream
            InputStream ims = context.getAssets().open("fish/icon/"+path+".png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            mImage.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }
    public static void loadDiyItem(Context context, ImageView mImage,String path){
        // load image
        try {
            // get input stream
            InputStream ims = context.getAssets().open("diy/material/"+path+".png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            mImage.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }
    public static void loadJiajuItem(Context context, ImageView mImage,String path){
        // load image
        try {
            // get input stream
            InputStream ims = context.getAssets().open("diy/material/"+path+".png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            mImage.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }
    public static void loadInsectImg(Context context, ImageView mImage,String path){
        // load image
        try {
            // get input stream
            InputStream ims = context.getAssets().open("insect/icon/"+path+".png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            mImage.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }
    public static void loadTypeImg(Context context, ImageView mImage,String path){
        // load image
        try {
            // get input stream
            InputStream ims = context.getAssets().open("speciesIcons/"+path+".png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            mImage.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }
    public static void loadDiyImg(Context context, ImageView mImage,String path){
        // load image
        try {
            // get input stream
            InputStream ims = context.getAssets().open("diy/product/"+path+".png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            mImage.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }
    public static void loadClothImg(Context context, ImageView mImage,String path){
        // load image
        try {
            // get input stream
            InputStream ims = context.getAssets().open("cloth/"+path+".png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            mImage.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }
    public static void loadShellImg(Context context, ImageView mImage,String path){
        // load image
        try {
            // get input stream
            InputStream ims = context.getAssets().open("shell/"+path+".png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            mImage.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }
    public static void loadGoldenImg(Context context, ImageView mImage,String path){
        // load image
        try {
            // get input stream
            InputStream ims = context.getAssets().open("goldenTool/"+path+".png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            mImage.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }
    public static void loadPlantmg(Context context, ImageView mImage,String path){
        // load image
        try {
            // get input stream
            InputStream ims = context.getAssets().open("plant/"+path+".png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            mImage.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }
    public static void loadFosillImg(Context context, ImageView mImage,String path){
        // load image
        try {
            // get input stream
            InputStream ims = context.getAssets().open("fossil/"+path+".png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            mImage.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }
    public static void loadArtworkImg(Context context, ImageView mImage,String path){
        // load image
        try {
            // get input stream
            InputStream ims = context.getAssets().open("artwork/"+path+".png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            mImage.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }
    public static void loadAlbumImg(Context context, ImageView mImage,String path){
        // load image
        try {
            // get input stream
            InputStream ims = context.getAssets().open("album/"+path+".png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            mImage.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }
    public static List<Drawable> getDesignCloth(Context context){
        List<Drawable> list  = new ArrayList<>();
        try {
            String[]  flLists=context.getAssets().list("design/cloth");
            for (int i =0;i<flLists.length;i++){
                InputStream ims = context.getAssets().open("design/cloth/"+flLists[i]);
                // load image as Drawable
                Drawable d = Drawable.createFromStream(ims, null);
                list.add(d);
            }
            return list;
        }
        catch(IOException ex) {
            return list;
        }
    }
    public static List<Drawable> getDesignHead(Context context){
        List<Drawable> list  = new ArrayList<>();
        try {
            String[]  flLists=context.getAssets().list("design/hat");
            for (int i =0;i<flLists.length;i++){
                InputStream ims = context.getAssets().open("design/hat/"+flLists[i]);
                // load image as Drawable
                Drawable d = Drawable.createFromStream(ims, null);
                list.add(d);
            }
            return list;
        }
        catch(IOException ex) {
            return list;
        }
    }
    public static List<Drawable> getDesignPic(Context context){
        List<Drawable> list  = new ArrayList<>();
        try {
            String[]  flLists=context.getAssets().list("design/texture");
            for (int i =0;i<flLists.length;i++){
                InputStream ims = context.getAssets().open("design/texture/"+flLists[i]);
                // load image as Drawable
                Drawable d = Drawable.createFromStream(ims, null);
                list.add(d);
            }
            return list;
        }
        catch(IOException ex) {
            return list;
        }
    }

    /**
     * drawable转化成bitmap的方法
     * @param drawable 需要转换的Drawable
     */
    public static Bitmap drawableToBitamp(Drawable drawable) {
        Drawable d = drawable;
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();
        Bitmap.Config config = d.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        Bitmap bitmap = Bitmap.createBitmap(w,h,config);
        //注意，下面三行代码要用到，否在在View或者surfaceview里的canvas.drawBitmap会看不到图
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * bitmap转化成byte数组
     * @param bm 需要转换的Bitmap
     * @return
     */
    public static byte[] bitmap2Bytes(Bitmap bm){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }
}
