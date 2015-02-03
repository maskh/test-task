package com.medinsky.demo.util.gson;

import com.google.gson.*;
import com.medinsky.demo.entity.DemoData;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DemoDataAdapter implements JsonDeserializer<DemoData>{
    @Override
    public DemoData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        DemoData result = new DemoData();
        if (json != null){
            JsonObject pair = ((JsonObject) json);
            JsonObject obj = pair.getAsJsonObject("obj");
            result.setId(obj.get("id").getAsString());
            result.setCh(obj.get("ch").getAsString());
            result.setVarch(obj.get("varch").getAsString());

            String dateAsString = obj.get("dt").getAsString();
            Date date = null;
            try {
                DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
                date = format.parse(dateAsString);
            } catch (ParseException e) {
                try {
                    DateFormat format = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
                    date = format.parse(dateAsString);
                } catch (ParseException e1) {/*NOP*/}
            }
            result.setDt(date);
        }
        return result;
    }
}
