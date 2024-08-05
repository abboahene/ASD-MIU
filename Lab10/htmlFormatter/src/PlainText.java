public class PlainText implements HTMLComponent{

    private String content;

    PlainText(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String format() {
        return content;
    }
}
