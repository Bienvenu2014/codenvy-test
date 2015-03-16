package com.codenvy.testtask.qname;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QNameParser {

    private final static Pattern QNAME_PATTERN = Pattern.compile("(_?(?!((?i)xml|[_\\d\\W]))([\\w.-]+))? ([\\:])?([\\w]+)(([\\w]+)([\\s]?)([\\w]+))?");

    public QName parse(String sourceString) throws IllegalNameException {
        QName result = new QName();
        result.setLocalName(sourceString);

        Matcher matcher = QNAME_PATTERN.matcher(sourceString);
        if (matcher.matches()) {
            String prefix = matcher.group(1);
            result.setPrefix(prefix);

            String name = matcher.group(2);
            result.setLocalName(name);
            return result;
        } else {
            throw new IllegalNameException("String doesn't match convention");
        }

    }

    //public static void main(String[] args) {
    //Pattern pt = Pattern.compile("([\\w&&[^0-9]])+([\\w])+([\\:]?)([\\w])+([\\s])?([\\w])+");

//        String namePattern = ("([\\:])?([\\w]+)(([\\w]+)([\\s]?)([\\w]+))?");
//        String localNamePattern = ("([\\:])?([\\w]+)(([\\w]+)([\\s]?)([\\w]+))?");
//        String prefixPattern = ("(_?(?!((?i)xml|[_\\d\\W]))([\\w.-]+))?");
//        Pattern pt = Pattern.compile(prefixPattern+localNamePattern);
//        Pattern pt1 = Pattern.compile(namePattern);
//
//        Matcher m = pt.matcher("i.");
//        boolean ft = m.matches();
//
//        System.out.println("ft = "+ ft);
    //}
}
