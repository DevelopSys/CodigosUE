package io.bootify.cursos_app.model;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import io.bootify.cursos_app.service.ProfesorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import org.springframework.web.servlet.HandlerMapping;


/**
 * Validate that the idCursoFK value isn't taken yet.
 */
@Target({ FIELD, METHOD, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = ProfesorIdCursoFKUnique.ProfesorIdCursoFKUniqueValidator.class
)
public @interface ProfesorIdCursoFKUnique {

    String message() default "{Exists.profesor.idCursoFK}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class ProfesorIdCursoFKUniqueValidator implements ConstraintValidator<ProfesorIdCursoFKUnique, Long> {

        private final ProfesorService profesorService;
        private final HttpServletRequest request;

        public ProfesorIdCursoFKUniqueValidator(final ProfesorService profesorService,
                final HttpServletRequest request) {
            this.profesorService = profesorService;
            this.request = request;
        }

        @Override
        public boolean isValid(final Long value, final ConstraintValidatorContext cvContext) {
            if (value == null) {
                // no value present
                return true;
            }
            @SuppressWarnings("unchecked") final Map<String, String> pathVariables =
                    ((Map<String, String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE));
            final String currentId = pathVariables.get("id");
            if (currentId != null && value.equals(profesorService.get(Long.parseLong(currentId)).getIdCursoFK())) {
                // value hasn't changed
                return true;
            }
            return !profesorService.idCursoFKExists(value);
        }

    }

}
