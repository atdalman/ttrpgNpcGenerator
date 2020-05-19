package osr.monsterGenerator;

import org.junit.Assert;
import org.junit.Test;
import osr.monsterGenerator.utilities.StringUtils;

public class StringUtilTest {

    @Test
    public void toCamelCaseFromTitleCaseTest() {
        Assert.assertEquals("aCamelCase", StringUtils.toCamelCaseFromTitleCase("ACamelCase"));
        Assert.assertEquals("fangorn", StringUtils.toCamelCaseFromTitleCase("Fangorn"));
        Assert.assertEquals("", StringUtils.toCamelCaseFromTitleCase(""));
        Assert.assertEquals("1", StringUtils.toCamelCaseFromTitleCase("1"));
        Assert.assertEquals("string", StringUtils.toCamelCaseFromTitleCase(new String().getClass().getSimpleName()));
    }
}
