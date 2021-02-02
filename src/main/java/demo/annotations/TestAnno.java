package demo.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author imnot
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnno {
    public int id() default 1;
    public String msg() default "-";
}
