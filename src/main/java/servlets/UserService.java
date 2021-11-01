package servlets;

import org.json.JSONArray;
import org.json.JSONObject;

public class UserService {
    private JSONArray array;

    public UserService() {
        this.array = new JSONArray();
    }

    public void init() {
        JSONObject user = new JSONObject();
        user.put("name", "bob");
        user.put("age", "25");
        array.put(user);
    }


    public JSONArray getUser() {
        return array;
    }

    public void addUser(JSONObject json) {
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = (JSONObject) array.get(i);
            if (obj.get("name").equals(json.get("name"))) {
                return;
            }
        }
        array.put(json);
    }

    public void putUser(JSONObject json) {
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = (JSONObject) array.get(i);
            if (obj.get("name").equals(json.get("name"))) {
                array.remove(i);
                array.put(json);
            }
        }
    }

    public void deleteUser(JSONObject json) {
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = (JSONObject) array.get(i);
            if (obj.get("name").equals(json.get("name"))) {
                array.remove(i);
            }
        }
    }
}
