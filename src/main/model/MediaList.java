package model;

import exceptions.EmptyStringException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Objects;

//List of MediaItem with a name
public class MediaList {

    private String listName; //Name of the list
    private String date;

    public MediaList(String name) throws EmptyStringException {
        if (name.isEmpty()) {
            throw new EmptyStringException();
        }
        this.listName = name;
        Calendar calendar = Calendar.getInstance();
        this.date = calendar.getTime().toString();
    }

    public String getName() {
        return this.listName;
    }

    public void setName(String newName) throws EmptyStringException {
        if (newName.isEmpty()) {
            throw new EmptyStringException();
        }
        this.listName = newName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MediaList mediaList = (MediaList) o;
        return listName.equals(mediaList.listName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listName);
    }

    // EFFECTS: save the information of the object into json
    public JSONObject save() {
        JSONObject mediaListObject = new JSONObject();
        mediaListObject.put("listName", this.listName);
        mediaListObject.put("date", this.date);
        return mediaListObject;
    }

    @Override
    public String toString() {
        return getName();
    }
}
