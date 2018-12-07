package com.maghraby.android.sandwichclub;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject root = new JSONObject(json);
            JSONObject name = root.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAsList = new ArrayList<>();
            for(int i=0; i<alsoKnownAs.length(); i++){
                alsoKnownAsList.add(alsoKnownAs.getString(i));
            }

            String placeOfOrigin = root.getString("placeOfOrigin");
            String description = root.getString("description");
            String image = root.getString("image");
            JSONArray ingredients = root.getJSONArray("ingredients");
            ArrayList<String> ingredientsList = new ArrayList<>();
            for(int i=0; i<ingredients.length(); i++){
                ingredientsList.add(ingredients.getString(i));
            }

            return new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
