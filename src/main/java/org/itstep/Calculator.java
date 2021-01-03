package org.itstep;

public class Calculator {
    static String add(String source) {
        long startTime = System.currentTimeMillis();
        if (source == null || source.isEmpty()) return (String.valueOf(0));
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == '–') {
                return ("throw NumberNegativException");
            }
            if (source.charAt(i) == '^') {
                String tmp;
                String rep;
                if (Character.isDigit(source.charAt(i + 1))) {
                    tmp = String.valueOf(source.charAt(i - 1)) + String.valueOf(source.charAt(i)) + String.valueOf(source.charAt(i + 1));
                    rep = tmp;
                } else {
                    tmp = String.valueOf(source.charAt(i - 1) + String.valueOf(source.charAt(i)) + "2");
                    rep = String.valueOf(source.charAt(i - 1) + String.valueOf(source.charAt(i)));
                }
                double res = Math.pow((Integer.parseInt(String.valueOf(tmp.charAt(0)))), Integer.parseInt(String.valueOf(tmp.charAt(2))));
                //
                source = source.replace(rep, String.valueOf((int) res));
                i--;
            }
        }
        if (source.charAt(0) == '/') {
            return (addSplit(source));
        } else {
            source = source.replaceAll("\\s+", ",");
            String[] str = source.split(",");
            int sum = 0;
            for (String s : str) {
                if (!s.isEmpty()) {
                    int num = Integer.parseInt(s);
                    if (num > 1000) continue;
                    sum += num;
                }
            }
            long timeSpent = System.currentTimeMillis() - startTime;
            if (timeSpent > 30) {
                return ("Error");
            }
            return String.valueOf(sum);
        }
    }

    static String addSplit(String source) {
        StringBuilder split = new StringBuilder();
        if (Character.isDigit(source.charAt(2))) {
            return ("throw SpliterFormatException");
        }
        source = source.replaceAll(" ", "");
        source = source.substring(2);
        if (source.charAt(0) == '[') {
            for (int j = 1; source.charAt(j) != '\n'; j++) {
                if (source.charAt(0) == '[') {
                    if (source.charAt(1) == ']') {
                        source = source.substring(2);
                        j = 0;
                        continue;
                    }
                    split.append(source.charAt(j));
                    if (source.charAt(j + 1) == ']') {
                        source = source.replace(split.toString(), ",");
                        split = new StringBuilder();
                        source = source.substring(3);
                        j = 0;
                    }
                } else {
                    break;
                }
            }
        } else {
            split.append(source.charAt(0));
            source = source.replace(split.toString(), ",");
        }
        for (int i = 0; i < source.length(); i++) {
            if (!Character.isDigit(source.charAt(i)) && source.charAt(i) != '\n' && source.charAt(i) != ' ' && source.charAt(i) != ',') {
                return ("throw SpliterFormatException");
            }
        }
        return add(source);
    }

    static String add(String source, String source1) {
        return (String.valueOf(Integer.parseInt(add(source)) + Integer.parseInt(add(source1))));
    }

    static String add(String source, String source1, String source2) {
        return (String.valueOf(Integer.parseInt(add(source)) + Integer.parseInt(add(source1)) + Integer.parseInt(add(source2))));
    }
}
