package pckg_snd;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        String filePath = "DATA_STRUCTURES/src/pckg_snd/quotes.txt";
        AUX_CLS.readFromFile(filePath);
        ArrayList<String[]> quotesData = AUX_CLS.readQuotes(filePath);
        AUX_CLS.listArrayListElements(quotesData);
        HashMap<String, ArrayList<String>> aQuotes = AUX_CLS.linkAuthorAndQuotes(quotesData);
        AUX_CLS.readAuthorAndQuotes(aQuotes);
        String newQuote = "Nova izreka za barba Einsteina!";
        String author = "Albert Einstein";
        AUX_CLS.addNewQuote(author, newQuote, aQuotes);
        AUX_CLS.readAuthorAndQuotes(aQuotes);
        String fPath = "DATA_STRUCTURES/src/pckg_snd/new_quote_file.txt";
        AUX_CLS.writeQuotesToFile(fPath, aQuotes);
        AUX_CLS.getNumberofQuotes(aQuotes);
        AUX_CLS.specifiedAuthorQuotes(aQuotes);
    }
}
