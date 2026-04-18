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
 * Validate that the correo value isn't taken yet.
 */
@Target({ FIELD, METHOD, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = ProfesorCorreoUnique.ProfesorCorreoUniqueValidator.class
)
public @interface ProfesorCorreoUnique {

    String message() default "{Exists.profesor.correo}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class ProfesorCorreoUniqueValidator implements ConstraintValidator<ProfesorCorreoUnique, String> {

        private final ProfesorService profesorService;
        private final HttpServletRequest request;

        public ProfesorCorreoUniqueValidator(final ProfesorService profesorService,
                final HttpServletRequest request) {
            this.profesorService = profesorService;
            this.request = request;
        }

        @Override
        public boolean isValid(final String value, final ConstraintValidatorContext cvContext) {
            if (value == null) {
                // no value present
                return true;
            }
            @SuppressWarnings("unchecked") final Map<String, String> pathVariables =
                    ((Map<String, String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE));
            final String currentId = pathVariables.get("id");
            if (currentId != null && value.equalsIgnoreCase(profesorService.get(Long.parseLong(currentId)).getCorreo())) {
                // value hasn't changed
                return true;
            }
            return !profesorService.correoExists(value);
        }

    }

}
