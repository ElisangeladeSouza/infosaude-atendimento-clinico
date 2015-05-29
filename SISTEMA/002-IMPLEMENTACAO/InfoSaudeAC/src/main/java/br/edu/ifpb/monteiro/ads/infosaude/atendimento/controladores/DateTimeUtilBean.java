package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.enterprise.inject.Model;

/**
 *
 * @author cassio
 */
@Model
public class DateTimeUtilBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date date = new Date();
    Calendar calendar = new GregorianCalendar();

    public DateTimeUtilBean() {

    }

    public Date getDateToday() {
        return new Date();
    }

    public Date dateHour() {
        this.date = new Timestamp(date.getTime());
        return date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
