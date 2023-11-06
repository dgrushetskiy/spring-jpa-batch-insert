package ru.gothmog.ws.batch.core.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PasswordUtils {

//    public String generateSecureRandomPassword() {
//        Stream<Character> pwdStream = Stream.concat(getRandomNumbers(2),
//                                                    Stream.concat(getRandomSpecialChars(2),
//                                                                  Stream.concat(getRandomAlphabets(2, true),
//                                                                                getRandomAlphabets(4, false))));
//        List<Character> charList = pwdStream.collect(Collectors.toList());
//        Collections.shuffle(charList);
//        String password = charList.stream()
//                                  .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
//                                  .toString();
//        return password;
//    }

    public Stream<Character> getRandomSpecialChars(int count) {
        Random random = new SecureRandom();
        IntStream specialChars = random.ints(count, 33, 45);
        return specialChars.mapToObj(data -> (char) data);
    }

    public String generateCommonLangPassword() {
        String upperCaseLetters = RandomStringUtils.random(2, 65, 90, true, true);
        String lowerCaseLetters = RandomStringUtils.random(2, 97, 122, true, true);
        String numbers = RandomStringUtils.randomNumeric(2);
        String specialChar = RandomStringUtils.random(2, 33, 47, false, false);
        String totalChars = RandomStringUtils.randomAlphanumeric(2);
        String combinedChars = upperCaseLetters.concat(lowerCaseLetters)
                                               .concat(numbers)
                                               .concat(specialChar)
                                               .concat(totalChars);
        List<Character> pwdChars = combinedChars.chars()
                                                .mapToObj(c -> (char) c)
                                                .collect(Collectors.toList());
        Collections.shuffle(pwdChars);
        String password = pwdChars.stream()
                                  .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                                  .toString();
        return password;
    }
}
