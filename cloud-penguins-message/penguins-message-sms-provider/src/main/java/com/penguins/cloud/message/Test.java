package com.penguins.cloud.message;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.util.ReflectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author 郑冰
 * @date 2022/1/21 11:48
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class Test {


    public static void main(String[] args) {
        class Demo {
            public List<String> list;
        }

// Turn on:
// - auto null reference initialization
// - auto collection growing
        SpelParserConfiguration config = new SpelParserConfiguration(true, true);

        ExpressionParser parser = new SpelExpressionParser(config);

        Expression expression = parser.parseExpression("list[3]");

        Demo demo = new Demo();

        Object o = expression.getValue(demo);

        System.out.println(Objects.isNull(o));
//        ReflectionUtils.in

// demo.list will now be a real collection of 4 entries
// Each entry is a new empty String


    }
}
