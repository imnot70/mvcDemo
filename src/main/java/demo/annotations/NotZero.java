package demo.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author imnot
 */
@Target(ElementType.FIELD)
public @interface NotZero {

}
