import java.util.*;

/**
 * ============================================================
 * ENCODE AND DECODE STRINGS (LC #271) — Medium
 * ============================================================
 * 
 * PROBLEM:
 * Design an algorithm to encode a list of strings to a single string,
 * and decode that single string back to the original list of strings.
 * 
 * The encoded string should be as compact as possible, and the
 * strings can contain ANY character (including delimiters like
 * commas, spaces, colons, #, etc.)
 * 
 * CONSTRAINTS:
 * - 0 <= strs.length <= 200
 * - 0 <= strs[i].length <= 200
 * - strs[i] can contain ANY 256 valid ASCII characters
 * 
 * PATTERN: Length-Prefix Encoding
 * 
 * APPROACH:
 * - Encode: For each string, prepend its length followed by a
 * delimiter character, then the string content.
 * Format: "length#string"
 * - Decode: Read the length (digits until #), skip #, then read
 * exactly 'length' characters.
 * 
 * COMPLEXITY:
 * - Time: O(n) for both encode and decode, where n = total chars across all
 * strings
 * - Space: O(n) for the encoded/decoded result
 * 
 * YOUR TASK: Implement encode() and decode() below.
 * ============================================================
 */
public class EncodeDecodeStrings {

    // Encode a list of strings to a single string.
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");

        for (String str : strs) {
            sb.append(str.length() + "#" + str);
        }
        return sb.toString();
    }

    // Decode a single string back to a list of strings.
    public static List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length();) {
            int hashPosition = s.indexOf('#', i);
            int length = Integer.parseInt(s.substring(i, hashPosition));
            String string = s.substring(hashPosition + 1, hashPosition + length + 1);
            i = hashPosition + length + 1;
            result.add(string);
        }
        return result;
    }

    // ==================== DRIVER CODE — DO NOT MODIFY ====================
    public static void main(String[] args) {
        int passed = 0;
        int total = 5;

        // Test 1: Basic case
        List<String> input1 = Arrays.asList("hello", "world");
        List<String> result1 = decode(encode(input1));
        if (result1.equals(input1)) {
            System.out.println("✅ Test 1 PASSED: [\"hello\", \"world\"]");
            passed++;
        } else {
            System.out.println("❌ Test 1 FAILED: Expected " + input1 + " but got " + result1);
        }

        // Test 2: Strings containing the delimiter character #
        List<String> input2 = Arrays.asList("a#b", "c#d#e");
        List<String> result2 = decode(encode(input2));
        if (result2.equals(input2)) {
            System.out.println("✅ Test 2 PASSED: Strings containing '#'");
            passed++;
        } else {
            System.out.println("❌ Test 2 FAILED: Expected " + input2 + " but got " + result2);
        }

        // Test 3: Empty strings in the list
        List<String> input3 = Arrays.asList("", "", "abc");
        List<String> result3 = decode(encode(input3));
        if (result3.equals(input3)) {
            System.out.println("✅ Test 3 PASSED: Empty strings in list");
            passed++;
        } else {
            System.out.println("❌ Test 3 FAILED: Expected " + input3 + " but got " + result3);
        }

        // Test 4: Empty list
        List<String> input4 = new ArrayList<>();
        List<String> result4 = decode(encode(input4));
        if (result4.equals(input4)) {
            System.out.println("✅ Test 4 PASSED: Empty list []");
            passed++;
        } else {
            System.out.println("❌ Test 4 FAILED: Expected " + input4 + " but got " + result4);
        }

        // Test 5: Strings with digits and mixed special chars
        List<String> input5 = Arrays.asList("123", "45#67", "a b c", "#");
        List<String> result5 = decode(encode(input5));
        if (result5.equals(input5)) {
            System.out.println("✅ Test 5 PASSED: Digits, spaces, and special chars");
            passed++;
        } else {
            System.out.println("❌ Test 5 FAILED: Expected " + input5 + " but got " + result5);
        }

        System.out.println("\n=== RESULTS: " + passed + "/" + total + " tests passed ===");
    }
}
