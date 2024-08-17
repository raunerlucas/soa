package com.loja_moveis.adaptadores;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class AdaptadorDate extends XmlAdapter<XMLGregorianCalendar, Date> {

   @Override
   public XMLGregorianCalendar marshal(Date date) throws Exception {
      GregorianCalendar gregCalendar = new GregorianCalendar();
      gregCalendar.setTime(date);

      XMLGregorianCalendar xmlGregCalendar = DatatypeFactory.newInstance()
              .newXMLGregorianCalendar(gregCalendar);

      xmlGregCalendar.setMillisecond(DatatypeConstants.FIELD_UNDEFINED);
      xmlGregCalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);

      return xmlGregCalendar;
   }

   @Override
   public Date unmarshal(XMLGregorianCalendar xmlGregCalendar) throws Exception {
       return xmlGregCalendar.toGregorianCalendar().getTime();
   }

}
