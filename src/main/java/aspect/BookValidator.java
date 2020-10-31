package aspect;

import model.Book;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class BookValidator implements Validator {
    @Override
    public boolean supports(Class aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.empty", "Id is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "Name is required.");
        Book b = (Book) o;
        if (b.getName().length() < 2 || b.getName().length() > 30) {
            errors.rejectValue("name", "string too short or too long");
        } else if (b.getId() == null) {
            errors.rejectValue("id", "null.value");
        }
    }
}
