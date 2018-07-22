package demo.annotations;

public class AnnoDemo001 {

    @TestAnno(msg="-")
    private String testFiled;

    public String getTestFiled() {
        return testFiled;
    }

    public void setTestFiled(String testFiled) {
        this.testFiled = testFiled;
    }
}
