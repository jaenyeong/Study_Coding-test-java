package com.jaenyeong._01_string_array._11_uniqueemailaddress;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    /*
    [Question]
    Every email consists of a local name and domain name, separated by the @ sign.
    For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
    Besides lowercase letters, these emails may contain '.'s or '+'s.
    If you add periods ('.') between some characters in the local name part of an email address,
    mail sent there will be forwarded to the same address without dots in the local name.
    For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
    (Note that this rule does not apply for domain names.)
    If you add a plus ('+') in the local name, everything after the first plus sign will be ignored.
    This allows certain emails to be filtered,
    for example m.y+name@email.com will be forwarded to my@email.com.
    (Again, this rule does not apply for domain names.)
    It is possible to use both of these rules at the same time.
    Given a list of emails, we send one email to each address in the list.
    How many different addresses actually receive mails?

    [Input]
    > ["test.email+james@coding.com", "test.e.mail.+toto.jane@coding.com", "testemail+tom@cod.ing.com"]
    [Output]
    > 2

     */

    public static void main(String[] args) {
        String[] emails =
            {"test.email+james@coding.com", "test.e.mail+toto.jane@coding.com", "testemail+tom@cod.ing.com"};

        System.out.println(numUniqueEmails(emails));
    }

    static int numUniqueEmails(final String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String id = extractEmailId(email);
            String domainName = extractDomainName(email);
            set.add(id + "@" + domainName);
        }

        return set.size();
    }

//    static String extractEmailId(String email) {
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < email.length(); i++) {
//            char character = email.charAt(i);
//
//            if (character == '.') {
//                continue;
//            } else if (character == '+') {
//                break;
//            }
//
//            sb.append(character);
//        }
//
//        return sb.toString();
//    }

    private static String extractEmailId(final String email) {
        StringBuilder sb = new StringBuilder();

        String id = email.split("@")[0].split("\\+")[0];
        String[] idPieces = id.split("\\.");

        for (String piece : idPieces) {
            sb.append(piece);
        }

        return sb.toString();
    }

    private static String extractDomainName(final String email) {
        return email.substring(email.indexOf('@') + 1);
    }
}
