package de.codecentric.psd.worblehat.web.validation;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintValidatorContext;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ISBNConstraintValidatorTest {

    private ISBNConstraintValidator isbnConstraintValidator;

    private ConstraintValidatorContext constraintValidatorContext;


    @Before
    public void setUp() throws Exception {
        isbnConstraintValidator = new ISBNConstraintValidator();
        constraintValidatorContext = mock(ConstraintValidatorContext.class);
    }

    @Test
    public void initializeShouldTakeIsbn() throws Exception {
        ISBN isbn= mock(ISBN.class);
        isbnConstraintValidator.initialize(isbn);
    }

    @Test
    public void shouldReturnTrueIfBlank() throws Exception {
        boolean actual = isbnConstraintValidator.isValid("", constraintValidatorContext);
        assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueIfValidISBN() throws Exception {
        boolean actual = isbnConstraintValidator.isValid("0132350882", constraintValidatorContext);
        assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueIfValidISBN13() throws Exception {
        boolean actual = isbnConstraintValidator.isValid("9781413304541", constraintValidatorContext);
        assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueIfInValidISBN13() throws Exception {
        boolean actual = isbnConstraintValidator.isValid("978113304541", constraintValidatorContext);
        assertFalse(actual);
    }

    @Test
    public void shouldReturnFalseIfInvalidISBN() throws Exception {
        boolean actual = isbnConstraintValidator.isValid("0123459789", constraintValidatorContext);
        assertFalse(actual);
    }

    @Test
    public void shouldReturnTrueIfISBNStartWithBlank() throws Exception {
        boolean actual = isbnConstraintValidator.isValid("    0123456789", constraintValidatorContext);
        assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueIfISBNEndsWithBlank() throws Exception {
        boolean actual = isbnConstraintValidator.isValid("0123456789      ", constraintValidatorContext);
        assertTrue(actual);
    }

}