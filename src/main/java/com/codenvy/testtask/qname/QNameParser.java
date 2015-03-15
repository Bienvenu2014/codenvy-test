package com.codenvy.testtask.qname;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Юлечка on 13.03.2015.
 */
public class QNameParser {

    private final static Pattern QNAME_PATTERN = Pattern.compile("([\\w]+):(\\w)+");

    public QName parse(String sourceString) throws IllegalNameException {
        QName result = new QName();
        result.setName(sourceString);

        Matcher matcher = QNAME_PATTERN.matcher(sourceString);
        if (matcher.matches()) {
            String prefix = matcher.group(1);
            result.setPrefix(prefix);

            String name = matcher.group(2);
            result.setName(name);
            return result;
        } else {
            throw new IllegalNameException("String doesn't match convention");
        }

    }

    public static void main(String[] args) {
        Pattern pt = Pattern.compile("([\\w&&[^0-9]])+([\\w])+([\\:]?)([\\w])+([\\s])?([\\w])+");
        Matcher m = pt.matcher("1name");
        boolean ft = m.matches();

        System.out.println("ft = "+ ft);
    }
}
