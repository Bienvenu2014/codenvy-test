package com.codenvy.testtask.qname;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class QNameParserTest {

    @Test(enabled = false)
    public void shouldGetLocalName() throws IllegalNameException {
        // given
        QNameParser qNameParser = new QNameParser();

        // when
        QName qName = qNameParser.parse("name");

        // then
        assertEquals(qName.getLocalName(), "name");
    }

    @Test(enabled = true)
    public void shouldGetPrefix() throws IllegalNameException {
        // given
        QNameParser qNameParser = new QNameParser();

        // when
        QName qName = qNameParser.parse("prefix:name");

        // then
        assertEquals(qName.getPrefix(), "prefix");
    }

    @Test(expectedExceptions = IllegalNameException.class)
    public void shouldThrowExceptionIfStringDoesNotMatch() throws IllegalNameException {
        // given
        QNameParser qNameParser = new QNameParser();

        // when
        qNameParser.parse(":name");
    }
}
