//package hackerthon.liquor.validation.validator;
//
//import hackerthon.liquor.validation.anotation.ExistCategories;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class CategoryExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {
//
//    private final MemberCommandServiceImpl memberCommandService;
//    @Override
//    public void initialize(ExistCategories constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
//    }
//
//    @Override
//    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
//        boolean isValid = values.stream()
//                .allMatch(value -> memberCommandService.findFoodCategoryById(value));
//
//        if (!isValid) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
//        }
//
//        return isValid;
//
//    }
//}
