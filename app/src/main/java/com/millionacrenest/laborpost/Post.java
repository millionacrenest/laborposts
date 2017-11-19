package com.millionacrenest.laborpost;

/**
 * Created by allisonmcentire on 10/12/17.
 */

public class Post {
    private String mTitle;
    private String mField_Image;
    private String mBody;


    public Post() {
        // Needed for Firebase
    }

    public Post(String title, String field_image, String body) {
        mTitle = title;
        mField_Image = field_image;
        mBody = body;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }

    public String getField_Image() {
        return mField_Image;
    }

    public void setField_Image(String field_image) {
        mField_Image = field_image;
    }
}
