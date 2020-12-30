package demo.reflect;

public class Test {
    public static void main(String[] args) {
        Class<InterfaceDemo> clazz1 = InterfaceDemo.class;
        System.out.println(clazz1.isInterface());
        Class<InterfaceImpl> clazz2 = InterfaceImpl.class;
        System.out.println(clazz2.isInterface());
        System.out.println(clazz2.isInstance(InterfaceDemo.class));
        System.out.println(clazz2.isAnonymousClass());
        System.out.println(clazz2.isLocalClass());
        System.out.println(clazz2.isMemberClass());
    }
}
