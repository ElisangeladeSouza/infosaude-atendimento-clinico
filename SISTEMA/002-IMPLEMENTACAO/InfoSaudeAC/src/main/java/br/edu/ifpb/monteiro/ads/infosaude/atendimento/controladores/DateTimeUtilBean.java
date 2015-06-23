package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.enterprise.inject.Model;

/**
 * Classe utilitária que provê métodos relacionados a datas. Anotada como um
 * Bean CDI, pode ser usada diretamente nas paginas tambem.
 *
 * @author cassio
 */
@Model
public class DateTimeUtilBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date date = new Date();
    Calendar calendar = new GregorianCalendar();

    /**
     * Construtor da classe
     */
    public DateTimeUtilBean() {

    }

    /**
     * Retorna a data de hoje incluindo a hora atual.
     *
     * @return
     */
    public Date getDateToday() {
        return new Date();
    }

    /**
     *
     * @return
     */
    public Date dateHour() {
        this.date = new Timestamp(date.getTime());
        return date;
    }

    /**
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

}
