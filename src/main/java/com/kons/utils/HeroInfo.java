package com.kons.utils;

import java.io.Serializable;

public class HeroInfo implements Serializable {

    private int heroId;
    private String name;
    private String alias;
    private String title;

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "HeroInfo{" +
                "heroId=" + heroId +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
