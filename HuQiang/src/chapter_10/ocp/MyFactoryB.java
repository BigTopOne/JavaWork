package chapter_10.ocp;

public class MyFactoryA implements IMyFactory {
    @Override
    public String product() {
        return "A 产品";
    }
}
