
package ua.kek.dobriy_kot.startvk.model.attachment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.model.VKAttachments;

import java.util.NoSuchElementException;

public class ApiAttachment {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("photo")
    @Expose
    private Photo photo;

    private Audio audio;
    private Video video;
    private Doc doc;
    private Link link;
    private Page page;

    public Attachment getAttachment() {
        if (type.equals(VKAttachments.TYPE_PHOTO)) {
            return photo;
        }
        if (type.equals(VKAttachments.TYPE_DOC)) {
            return doc;
        }
        if (type.equals(VKAttachments.TYPE_AUDIO)) {
            return audio;
        }
        if (type.equals(VKAttachments.TYPE_LINK)) {
            return link;
        }
        if (type.equals(VKAttachments.TYPE_WIKI_PAGE)) {
            return page;
        } else {
            throw new NoSuchElementException("Attachment type " + type + " is not supported");
        }


    }


    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Audio getAudio() {
        return audio;
    }

    public Video getVideo() {
        return video;
    }

    public Doc getDoc() {
        return doc;
    }

    public Link getLink() {
        return link;
    }

    public Page getPage() {
        return page;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

}
