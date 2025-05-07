public class URLFinder {

    private String url;

    public URLFinder(int url)
    {
        this.url="www.google.com";
    }

    public boolean urlChecker(String inputUrl)
    {
        return inputUrl.startsWith("http://") || inputUrl.startsWith("https://") && inputUrl.contains(".");

       
    }
  
}
