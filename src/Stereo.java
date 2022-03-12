public class Stereo {

    public void on() {
        System.out.println("Stereo is on.");
    }

    public void off() {
        System.out.println("Stereo is off.");
    }

    public void setCD() {
        System.out.println("CD is plugged.");
    }

    public void setVolume(int volume) {
        System.out.println("Volume sets to "+ volume + ".");
    }
}

class StereoOnWithCDCommand implements Command {

    Stereo stereo;

    public StereoOnWithCDCommand (Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}

class StereoOffCommand implements Command {

    Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }
}