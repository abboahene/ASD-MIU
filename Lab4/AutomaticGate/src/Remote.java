public class Remote {
    private GateController controller;

    public Remote(GateController controller) {
        this.controller = controller;
    }

    public void pressButton() {
        controller.pressButton();
    }
}