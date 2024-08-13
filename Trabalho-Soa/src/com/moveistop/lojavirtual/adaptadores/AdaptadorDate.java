package com.moveistop.lojavirtual.adaptadores;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class AdaptadorDate extends XmlAdapter<XMLGregorianCalendar, Date> {

   @Override
   public XMLGregorianCalendar marshal(Date date) throws Exception {
      GregorianCalendar calendar = new GregorianCalendar();
      calendar.setTime(date);

      XMLGregorianCalendar xmlCalendar = DatatypeFactory
              .newInstance()
              .newXMLGregorianCalendar(calendar);

      xmlCalendar.setMillisecond(DatatypeConstants.FIELD_UNDEFINED);
      xmlCalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);

      return xmlCalendar;
   }

   @Override
   public Date unmarshal(XMLGregorianCalendar xmlCalendar) throws Exception {
      return xmlCalendar.toGregorianCalendar().getTime();
   }

}
