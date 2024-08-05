import java.util.ArrayList;
import java.util.List;

public abstract class HTMLTag implements HTMLComponent{
    private String tagName;

    private List<HTMLComponent> htmlComponentList;

    HTMLTag(String tagName){
        this.tagName = tagName;
        this.htmlComponentList = new ArrayList<>();
    }

    @Override
    public String format() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(tagName).append(">");
        for(HTMLComponent component : htmlComponentList){
            sb.append(component.format());
        }
        sb.append("</").append(tagName).append(">");
        return sb.toString();
    }

    public List<HTMLComponent> getHtmlComponentList() {
        return htmlComponentList;
    }

    public void addHtmlComponent(HTMLComponent htmlComponent) {
        this.htmlComponentList.add(htmlComponent);
    }
}
