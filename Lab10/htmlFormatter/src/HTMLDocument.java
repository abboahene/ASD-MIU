import java.util.ArrayList;
import java.util.List;

public class HTMLDocument {

    private List<HTMLTag> htmlTagList;

    HTMLDocument(){
        htmlTagList = new ArrayList<>();
    }

    public List<HTMLTag> getHtmlTagList() {
        return htmlTagList;
    }

    public void addHtmlTag(HTMLTag htmlTag) {
        this.htmlTagList.add(htmlTag);
    }

    public String format() {
        StringBuilder html = new StringBuilder();

       for(HTMLTag tag : htmlTagList){
           html.append(tag.format());
       }
       return html.toString();
    }
}
