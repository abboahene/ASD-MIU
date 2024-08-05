public class Main {
    public static void main(String[] args) {

        HTMLDocument document = new HTMLDocument();
        HTMLTag italic = new Italic();
        italic.addHtmlComponent(new PlainText("Hello"));
        HTMLTag bold = new Bold();
        bold.addHtmlComponent(italic);

        HTMLTag underline = new Underline();
        underline.addHtmlComponent(new PlainText("world!!!"));
        HTMLTag strikethrough = new Strikethrough();
        strikethrough.addHtmlComponent(underline);


        document.addHtmlTag(bold);
        document.addHtmlTag(strikethrough);

        System.out.println(document.format());

    }
}