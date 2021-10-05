package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("hello");

        Gson gson  = new Gson();
        FileReader fileReader = new FileReader("recentquotes.json");
        Type userListType = new TypeToken<ArrayList<Quotes>>(){}.getType();
        List<Quotes> quotes = gson.fromJson(fileReader,userListType);

        Random randomNumber = new Random();
        int i = randomNumber.nextInt(quotes.size());

        System.out.println(quotes.get(i).toString());
    }


}
