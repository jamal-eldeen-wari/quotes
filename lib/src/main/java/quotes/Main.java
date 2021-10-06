package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("hello");
        String onlineQuotes = " http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
        URL url = new URL(onlineQuotes);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        int res  =0;
        try{
             res = connection.getResponseCode();
        }catch (Exception e){
            connection.disconnect();
        }

        if (res == HttpURLConnection.HTTP_OK){
            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String quote = bufferedReader.readLine();

            System.out.println("From API ");
            bufferedReader.close();

            Gson gson = new Gson();
            OnlineQoute quotes = gson.fromJson(quote,OnlineQoute.class);
            System.out.println("Author Is "+quotes.getQuoteAuthor());
            System.out.println("Quote Is "+quotes.getQuoteText());

//            To write data on the recentquotes.json file;
            Quotes newQuotes = new Quotes(quotes.getQuoteAuthor(), quotes.getQuoteText());
            Writer writer = new FileWriter("recentquotes.json",true);
            gson.toJson(newQuotes,writer);
//            System.out.println(newQuotes);
            writer.close();
        }else{
            System.out.println("From File");
            Gson gson  = new Gson();
            JsonReader fileReader = new JsonReader(new FileReader("recentquotes.json"));
            Type userListType = new TypeToken<ArrayList<Quotes>>(){}.getType();
            List<Quotes> quotes = gson.fromJson(fileReader,userListType);
//        http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en



            Random randomNumber = new Random();
            int i = randomNumber.nextInt(quotes.size());

            System.out.println(quotes.get(i).toString());

        }
    }
}
