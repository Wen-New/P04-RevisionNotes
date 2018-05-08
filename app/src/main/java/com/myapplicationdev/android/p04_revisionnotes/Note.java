package com.myapplicationdev.android.p04_revisionnotes;

public class Note {

	//What's here?
    private int id;
    private String content;
    private int star;

    public Note(int id, String content, int star) {
        this.id = id;
        this.content = content;
        this.star = star;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
