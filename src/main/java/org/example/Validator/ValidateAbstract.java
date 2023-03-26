package org.example.Validator;

public abstract class ValidateAbstract<E> {
    private String name;

    public ValidateAbstract(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Class<E> getType();
//    public abstract boolean validate(E validate, Class<E> type);
//    public abstract E caster(String str, Class<E> type);

    public abstract boolean validate(String value);
    public abstract boolean validate(String[] value);
}