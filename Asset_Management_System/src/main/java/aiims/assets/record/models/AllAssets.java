package aiims.assets.record.models;

import java.util.List;



public class AllAssets {

    private List<ComputerAsset> pc;
    private List<UPSAssets> ups;
    private List<PrinterAssets> printer;
    private List<Assets> others;

    public AllAssets() {
        super();
    }

    public List<ComputerAsset> getPc() {
        return pc;
    }

    public void setPc(List<ComputerAsset> pc) {
        this.pc = pc;
    }

    public List<UPSAssets> getUps() {
        return ups;
    }

    public void setUps(List<UPSAssets> ups) {
        this.ups = ups;
    }

    public List<PrinterAssets> getPrinter() {
        return printer;
    }

    public void setPrinter(List<PrinterAssets> printer) {
        this.printer = printer;
    }

    public List<Assets> getOthers() {
        return others;
    }

    public void setOthers(List<Assets> others) {
        this.others = others;
    }
}
