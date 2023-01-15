package marketplace.validator;

import marketplace.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "Required");
        if (product.getTitle().length() < 3 || product.getTitle().length() > 20) {
            errors.rejectValue("title", "Size.productForm.title");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Required");
        if (product.getDescription().length() < 10) {
            errors.rejectValue("description", "Size.productForm.description");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startPrice", "Required");
        if (product.getStartPrice() == 0) {
            errors.rejectValue("startPrice", "Size.productForm.startPrice");
        }

        if (product.getStartPrice() % product.getBidInc() != 0) {
            errors.rejectValue("startPrice", "Different.productForm.startPriceIncrement");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "Required");
        if (product.getStartDate().getTime() > product.getEndDate().getTime()) {
            errors.rejectValue("startDate", "Size.productForm.StartDateLater");
        }

        if (product.getStartDate().getTime() < System.currentTimeMillis()) {
            errors.rejectValue("startDate", "Different.productForm.StartDateBeforeCurrentDate");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate", "Required");
        if (product.getStartDate().getTime() > product.getEndDate().getTime()) {
            errors.rejectValue("endDate", "Size.productForm.EndDateBefore");
        }

        if (product.getEndDate().getTime() <= System.currentTimeMillis()) {
            errors.rejectValue("endDate", "Different.productForm.EndDateBeforeCurrentDate");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bidInc", "Required");
        if (product.getBidInc() == 0) {
            errors.rejectValue("bidInc", "Size.productForm.bidInc");
        }

    }
}
