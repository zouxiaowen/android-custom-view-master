package com.mxdl.customview;

import java.util.List;

public class ONNEwBen {
    String title; //文本内容
    List<String> url;//图片
    int imgaetype;// 2视频 3是文本 1 图片（1是一张图片 4是两张图片  5是三张图片  6是四张图片 ）
    public final static int IMAGETYPEIMAGEONE=1;
    public final static int IMAGETYPEVIDEO=2;
    public final static int IMAGETYPETITLE=3;
    public final static int IMAGETYPEIMAGETWO=4;
    public final static int IMAGETYPEIMAGETHREE=5;
    public final static int IMAGETYPEIMAGES=6;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public int getImgaetype() {
        return imgaetype;
    }

    public void setImgaetype(int imgaetype) {
        this.imgaetype = imgaetype;
    }
}
