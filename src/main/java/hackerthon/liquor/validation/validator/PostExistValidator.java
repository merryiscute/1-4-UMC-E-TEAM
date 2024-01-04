package hackerthon.liquor.validation.validator;

import hackerthon.liquor.apiPayload.code.status.ErrorStatus;
import hackerthon.liquor.domain.LiquorCombiPost;
import hackerthon.liquor.service.LiquorService;
import hackerthon.liquor.validation.anotation.ExistPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PostExistValidator implements ConstraintValidator<ExistPost, Long> {

    private final LiquorService liquorService;

    @Override
    public void initialize(ExistPost constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Optional<LiquorCombiPost> target = liquorService.findById(value);

        if (target.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.POST_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
