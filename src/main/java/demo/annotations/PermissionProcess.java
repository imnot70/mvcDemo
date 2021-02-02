package demo.annotations;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @author zhangpeng
 * @description
 * @date 2020-08-19 11:24 下午
 **/
public class PermissionProcess extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for(TypeElement a:annotations){
            System.out.println(a.getSimpleName());
        }
        System.out.println(roundEnv.errorRaised());
        System.out.println(roundEnv.processingOver());
        return false;
    }
}
