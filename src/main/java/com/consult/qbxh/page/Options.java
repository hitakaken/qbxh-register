package com.consult.qbxh.page;

import com.google.appengine.repackaged.com.google.common.collect.Lists;
import com.google.sitebricks.Show;
import com.google.sitebricks.rendering.EmbedAs;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by CaoKe on 2015/6/19.
 */
@EmbedAs("Options")
@Show("/page/Options.html")
public class Options {
    private List<String> list;
    private String value;
    private List<Item> items;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
        reload();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        reload();
    }

    private void reload() {
        items = Lists.newArrayList();
        if(list!=null){
            for(String text:list)
                items.add(new Item(text,StringUtils.equals(text,value)));
        }
    }

    public List<Item> getItems(){
        if(items==null)
            reload();
        return items;
    }

    public static class Item{
        private String text;
        private boolean selected;

        public Item(String text, boolean selected) {
            this.text = text;
            this.selected = selected;
        }

        public String getText() {
            return text;
        }

        public boolean isSelected() {
            return selected;
        }
    }
}
