package org.sheehan.algorithm;

import junit.framework.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: bsheehan
 * Date: 6/27/14
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class StringsTest {

    @Test
    public void testReverse() throws Exception {
        String testStr = "hello";

        String reverseStr = Strings.reverse(testStr);
        System.out.println(reverseStr);
        Assert.assertEquals("olleh", reverseStr);


        reverseStr = Strings.reverseRecursively(testStr);
        System.out.println(reverseStr);
        Assert.assertEquals("olleh", reverseStr);

    }

    @Test
    public void testReverse2() throws Exception {
        String testStr = "hello there";

        String reverseStr = Strings.reverse(testStr.toCharArray(), 6, testStr.length() - 1);
        System.out.println(reverseStr);
        Assert.assertEquals("hello ereht", reverseStr);
    }

    @Test
    public void testReverse3() throws Exception {
        String testStr = "hello there";

        String reverseStr = Strings.reverseWords(testStr);
        System.out.println(reverseStr);
        Assert.assertEquals("olleh ereht", reverseStr);
    }

    @Test
    public void testPermutations() throws Exception {
        String testStr = "ABC";

        Set<String> cache = new HashSet<String>();

        Strings.getPermutations("", "ABC", cache);

        for (String s: cache)
            System.out.println(s);

        cache.clear();
        char[] chars = "ABC".toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c: chars)
            list.add(c);
        Strings.getPermutations2(list, 0, cache);

        for (String s: cache)
            System.out.println(s);
    }

    @Test
    public void testAllSubstrings() throws Exception {
        String testStr = "ABCD";

        Set<String> cache = new HashSet<String>();
        Strings.getSubstrings(testStr, cache);

        for (String s: cache)
            System.out.println(s);
    }

    @Test
    public void testBinStrToInt() throws Exception {
        System.out.println(Strings.binStr2Int("1111"));
        System.out.println(Strings.binStr2Int("0101"));

        System.out.println(Strings.binStr2Int2("1111"));
        System.out.println(Strings.binStr2Int2("0101"));
    }

    @Test
    public void testDecStrToInt() throws Exception {
        System.out.println(Strings.decStr2Int("1234"));
        System.out.println(Strings.decStr2Int("-1234"));
    }

    @Test
    public void testDecInt2Str() throws Exception {
        System.out.println(Strings.decInt2Str(1234));
        System.out.println(Strings.decInt2Str(-1234));
    }

    @Test
    public void testRotations() throws Exception {
        String testStr = "ABC";
        String testStr2 = "BCA";
        Assert.assertTrue(Strings.isRotation(testStr, testStr2));
        testStr = "ABC";
        testStr2 = "CBA";
        Assert.assertFalse(Strings.isRotation(testStr, testStr2));
    }

    @Test
    public void testPalindrome() throws Exception {
        String testStr = "ABCCBA";
        Assert.assertTrue(Strings.isPalindrome(testStr));
        testStr = "A";
        Assert.assertTrue(Strings.isPalindrome(testStr));
        testStr = "AB";
        Assert.assertFalse(Strings.isPalindrome(testStr));
    }

    @Test
    public void testPalindrome2() throws Exception {
        String testStr = "ABCCBA";
        Assert.assertTrue(Strings.isPalindrome2(testStr));
        testStr = "A";
        Assert.assertTrue(Strings.isPalindrome2(testStr));
        testStr = "AB";
        Assert.assertFalse(Strings.isPalindrome2(testStr));
    }

    private String generate(int length){
        int numberOfUuids = length/32 + 1;
        String str="";
        for (int i = 0; i < numberOfUuids; ++i) {
            String uuid = UUID.randomUUID().toString();
            uuid = uuid.replace("-", "");
            str += uuid;
        }

        return str.substring(0, length);
    }

    @Test
    public void testRandomStrings(){
        String str = generate(10);
        Assert.assertTrue(str.length() == 10);
        String str2 = generate(40);
        Assert.assertTrue(str2.length() == 40);
    }

    @Test
    public void testFirstNonRepeat(){
        for (int i = 0; i < 5; ++i) {
            String str = generate(20);
            System.out.println(str);
            char c = Strings.getFirstNonRepeatingChar(str);
            System.out.println(c);
        }
    }

    @Test
    public void testFindDuplicates(){
        String test = "ABABCDEFGHGH";
        Set<Character> duplicates = Strings.findDuplicates(test);
        duplicates.forEach(s -> System.out.print(s + " "));
        System.out.println();

        duplicates = Strings.findDuplicatesBrute(test);
        duplicates.forEach(s -> System.out.print(s + " "));
        System.out.println();

        duplicates = Strings.findDuplicatesSet(test);
        duplicates.forEach(s -> System.out.print(s + " "));

    }

    @Test
    public void testRemoveDuplicates(){
        String test = "ABABCDEFGHGH";
        String s = Strings.removeDuplicates(test);
        System.out.println(s);
    }

    @Test
    public void testFindSubstring(){
        String s1 = "I am a lovely bunch of coconuts";
        String s2 = "am";
        int i = Strings.findSubstring(s1, s2);
        Assert.assertEquals(2, i);;

        s2 = "coconuts";
        i = Strings.findSubstring(s1, s2);
        Assert.assertEquals(23, i);;
    }

}
