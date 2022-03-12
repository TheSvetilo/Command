public class RemoteControl {

    private final int BUTTONS = 7;

    private final Command[] onCommands;
    private final Command[] offCommands;

    private Command undoCommand;

    public RemoteControl() {
        this.onCommands = new Command[BUTTONS];
        this.offCommands = new Command[BUTTONS];

        Command noCommand = new NoCommand();
        for (int i = 0; i < BUTTONS; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = new NoCommand();
    }

    public void setSlot(int slot, Command commandOn, Command commandOff) {
        onCommands[slot] = commandOn;
        offCommands[slot] = commandOff;
    }

    public void onButtonPressedOn(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void onButtonPressedOff(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void onUndoButtonPressed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("\n ---- Remote Control ---- \n");
        for (int i = 0; i < BUTTONS; i++) {
            stringBuffer.append("Slot[" + i + "] " + onCommands[i].getClass().getName() + " " + offCommands[i].getClass().getName() + "\n");
        }

        return stringBuffer.toString();
    }
}
