import pckg_inner_2.Computer;

public class AppTest {

    public static void main(String[] args) {
        Computer comp = new Computer("DELL", "Intel i7", 3.5, 32);
//        Computer.Processor processor = comp.new Processor("Intel i5", 4.5);
//        processor.bootOS();
//        Computer.RAM ram = new Computer.RAM(64);
//        ram.testSystemRAM();
        comp.checkCompTemperature();
        comp.bootComputer();
    }
}
