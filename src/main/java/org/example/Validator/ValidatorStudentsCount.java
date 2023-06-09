package org.example.Validator;

public class ValidatorStudentsCount extends ValidateAbstract<Integer> {

    public ValidatorStudentsCount() {
        super("StudyGroup.studentsCount");
    }

    @Override
    public Class<Integer> getType() {
        return Integer.class;
    }

    @Override
    public boolean validate(String value) {
        Integer val;
        try {
            val = Integer.parseInt(value);
            if (val > 0) {
                return true;
            }

            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean validate(String[] value) {
        return false;
    }
}
