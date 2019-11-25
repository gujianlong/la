package com.example.myapplication.glide;
/*
 *@auther:谷建龙
 *@Date: 2019/11/23
 *@Time:8:54
 *@Description:
 * */


import android.content.Context;
import android.os.Environment;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.module.GlideModule;

import java.io.File;

public class MyGlide implements GlideModule {
    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        int cacheSize=1024*1024*20;
        File file=new File(Environment.getExternalStorageDirectory(),"cache");
        String path = file.getPath();
        builder.setDiskCache(new DiskLruCacheFactory(path,cacheSize));
    }

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {

    }
}
