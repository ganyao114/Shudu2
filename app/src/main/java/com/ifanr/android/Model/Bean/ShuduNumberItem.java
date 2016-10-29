package com.ifanr.android.Model.Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ganyao on 2016/10/27.
 */

public class ShuduNumberItem{

    private int ID;// 文章 ID
    private String title;// 标题
    private String number;// 数字
    private String subfix;// 数字后缀
    private String description;// 数字描述
    private NumberSource[] sources;// 来源, 第一个键为原文链接
    private NumberComment[] comment_list;// 评论, 与主站的评论列表接口一样
    private String content;// 数字描述
    private String pubDate;// 发布时间
    private String like;// 喜欢数量

    private final String timeFormatLabelResult = "yyyy.MM.dd";
    private final String timeFormatLabelSource = "yyyy-MM-dd hh:mm:ss";
    private SimpleDateFormat dateFormat;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSubfix() {
        return subfix;
    }

    public void setSubfix(String subfix) {
        this.subfix = subfix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NumberComment[] getComment_list() {
        return comment_list;
    }

    public void setComment_list(NumberComment[] comment_list) {
        this.comment_list = comment_list;
    }

    public NumberSource[] getSources() {
        return sources;
    }

    public void setSources(NumberSource[] sources) {
        this.sources = sources;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getNumberLabel() {
        if (subfix != null) {
            return number + subfix;
        }
        return number;
    }

    public String getDate() {
        if (dateFormat == null)
            dateFormat = (SimpleDateFormat) SimpleDateFormat.getInstance();
        dateFormat.applyPattern(timeFormatLabelSource);
        try {
            Date date = dateFormat.parse(pubDate);
            dateFormat.applyPattern(timeFormatLabelResult);
            return dateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
