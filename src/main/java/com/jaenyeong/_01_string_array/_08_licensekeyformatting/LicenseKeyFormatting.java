package com.jaenyeong._01_string_array._08_licensekeyformatting;

public class LicenseKeyFormatting {
    /*
    [Question]
    You are given a license key represented as a string S which consists only alphanumeric character and dashes.
    The string is separated into N + 1 groups by N dashes.
    Given a number K, we would want to reformat the strings such that each group contains exactly K characters,
    except for the first group which could be shorter than K, but still must contain at least one character.
    Furthermore, there must be a dash inserted between two groups
    and all lowercase letters should be converted to uppercase.
    Given a non-empty string S and a number K, format the string according to the rules described above.

    [Input]
    S > "8F3Z-2e-9-w"
    K > 4
    [Output]
    > 8F3Z-2E9W

    [Input]
    S > "8-5G3J"
    K > 4
    [Output]
    > 8-5G3J

     */

    public static void main(String[] args) {
        String license = "8-5g-3-J";

        int key = 4;

        System.out.println(solve(license, key));
    }

    static String solve(final String license, int key) {
        String newLicense = license.replace("-", "");

        newLicense = newLicense.toUpperCase();

        int length = newLicense.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(newLicense.charAt(i));
        }

        for (int i = key; i < length; i = i + key) {
            sb.insert(length - i, '-');
        }

        return sb.toString();
    }
}
