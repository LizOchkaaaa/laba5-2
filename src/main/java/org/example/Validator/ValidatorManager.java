package org.example.Validator;

import org.example.models.StudyGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Stack;

public class ValidatorManager {
    private LinkedHashMap<String, ValidateAbstract<?>> validatorList;
    private ArrayList<String> validatorNameList;

    public ValidatorManager() {
        validatorList = new LinkedHashMap<String, ValidateAbstract<?>>();
        validatorList.put("id", null);
        ValidateName validateName = new ValidateName();
        validatorList.put(validateName.getName(), validateName);
        ValidateCoordinatesX coordinatesX = new ValidateCoordinatesX();
        validatorList.put(coordinatesX.getName(), coordinatesX);
        ValidatorCoordinatesY coordinatesY = new ValidatorCoordinatesY();
        validatorList.put(coordinatesY.getName(), coordinatesY);
        validatorList.put("creationDate", null);
        ValidatorStudentsCount validatorStudentsCount = new ValidatorStudentsCount();
        validatorList.put(validatorStudentsCount.getName(), validatorStudentsCount);
        ValidatorFormOfEducation validatorFormOfEducation = new ValidatorFormOfEducation();
        validatorList.put(validatorFormOfEducation.getName(), validatorFormOfEducation);
        ValidatorSemester validatorSemester = new ValidatorSemester();
        validatorList.put(validatorSemester.getName(), validatorSemester);
        var nameValidator = new ValidatorPersonname();
        validatorList.put(nameValidator.getName(), nameValidator);
        var weightValidator = new ValidatorWeight();
        validatorList.put(weightValidator.getName(), weightValidator);
        var validatorPassportId = new ValidatorPassportId();
        validatorList.put(validatorPassportId.getName(), validatorPassportId);
        var hairValidate = new ValidatorHairColor();
        validatorList.put(hairValidate.getName(), hairValidate);

        var personBirthday = new ValidatorBirthday();
        validatorList.put(personBirthday.getName(), personBirthday);
    }

    public ValidateAbstract<?> getValidator(String fildName) {
        return validatorList.get(fildName);
    }
}

