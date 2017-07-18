package nl.mranderson.mockito.common;


public class UrlUtils {

    public static String convertUrl(String partOfUrl) {
        if (partOfUrl.startsWith("mock")) {
            partOfUrl.concat("/testing");
        }
        return partOfUrl;
    }

}
