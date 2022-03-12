public class RemoteLouder {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light light = new Light();
        remoteControl.setSlot(2, new LightOnCommand(light), new LightOffCommand(light));

        Stereo stereo = new Stereo();
        remoteControl.setSlot(1, new StereoOnWithCDCommand(stereo), new StereoOffCommand(stereo));

        System.out.println(remoteControl);

        remoteControl.onButtonPressedOn(1);
        remoteControl.onButtonPressedOn(2);
        System.out.println();

        remoteControl.onUndoButtonPressed();
        remoteControl.onUndoButtonPressed();
    }

}
