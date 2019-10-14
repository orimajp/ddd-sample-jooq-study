package com.example.dddcorestudy.infrastructure.repository.jooq.generator;

import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.meta.Definition;

public class SamplePrefixGeneratorStrategy extends DefaultGeneratorStrategy {
    @Override
    public String getJavaClassName(Definition definition, Mode mode) {
        final String name = super.getJavaClassName(definition, mode);

        switch (mode) {
            case POJO:
                return name + "Vo";
            case DEFAULT:
                return 'J' + name;
        }

        return name;
    }

}
